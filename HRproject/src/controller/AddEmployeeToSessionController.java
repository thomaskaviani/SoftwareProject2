package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import model.Employee;
import model.Participation;
import model.Sessions;
import model.Training;
import application.CacheData;
import application.Navigator;
import dao.ParticipationDAO;

public class AddEmployeeToSessionController implements Initializable {

	public static Training training;
	public static Sessions session;
	public static List<Employee> participationEmployees;
	
	@FXML private Label trainingTitle;
	
	@FXML private Label errorLabel;
	
	@FXML private TableView<Employee> employeeTable;
	@FXML private TableView<Employee> participantTable;
	
	@FXML private TableColumn<Employee, String> employeeFirstNameCol;
	@FXML private TableColumn<Employee, String> employeeLastNameCol;
	@FXML private TableColumn<Employee, String> employeeFunctionCol;
	
	@FXML private TableColumn<Employee, String> participantFirstNameCol;
	@FXML private TableColumn<Employee, String> participantLastNameCol;
	@FXML private TableColumn<Employee, String> participantFunctionCol;
	
	
	//backbutton
	@FXML protected void toTrainingDetail(ActionEvent e) {
		resetVars();
		Navigator.loadVista(Navigator.TrainingDetailView);
				
	}
	
	@FXML protected void addEmpSession() {
		
		errorLabel.setText("");
		
		Employee emp = employeeTable.getSelectionModel().getSelectedItem();
		
		if (emp != null) {
			
			if (!participationEmployees.contains(emp)) {
				
				ParticipationDAO pdao1 = new ParticipationDAO();
				Participation p1 = pdao1.getByEmpId(emp.getEmployeeId(), session.getSessionId());
				
				participationEmployees.add(emp);
				ObservableList<Employee> parts = FXCollections.observableArrayList(participationEmployees);
				participantTable.setItems(parts);
				
				
				
				
				
				if (p1 == null) {
					
					Participation p2 = new Participation(training.getTrainingId(), emp.getEmployeeId(), 0, 0, session.getSessionId());
					ParticipationDAO pdao2 = new ParticipationDAO();
					pdao2.insert(p2);
					CacheData.setParticipations();
					
					
				} else {
					
					ParticipationDAO pdao2 = new ParticipationDAO();
					p1.setArch(0);
					pdao2.update(p1);
					CacheData.setParticipations();
				}
				
			} else {
				errorLabel.setTextFill(Color.FIREBRICK);
				errorLabel.setText("This employee is already participating");
			}
		}
	}
	
	@FXML protected void removeEmpSession() {
		
		errorLabel.setText("");
		
		Employee emp = participantTable.getSelectionModel().getSelectedItem();
		
		if (emp != null) {
			
			participationEmployees.remove(emp);
			ObservableList<Employee> parts = FXCollections.observableArrayList(participationEmployees);
			participantTable.setItems(parts);
			
			ParticipationDAO pdao = new ParticipationDAO();
			Participation part = pdao.getByEmpId(emp.getEmployeeId(), session.getSessionId());
			pdao.delete(part);
			CacheData.setParticipations();
			
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Titel van de sessie bepalen
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String date = df.format(session.getStartTime());
		trainingTitle.setText(training.getName() + " - " + date);
		
		
		//Employees die meedoen aan lijst toevoegen
		for (Participation p : CacheData.participations) {
			if (p.getSessionId() == session.getSessionId()) {
				if (CacheData.employees.size() >= Integer.valueOf(p.getEmpId())) {
							
					Employee emp = CacheData.employees.get(Integer.valueOf(p.getEmpId()) - 1);
							
					if (emp != null) {
						participationEmployees.add(emp);
					}
							
				}
			}
		}
		
		
		//vullen van tabellen met informatie
		ObservableList<Employee> emps = FXCollections.observableArrayList(CacheData.employees);
		ObservableList<Employee> parts = FXCollections.observableArrayList(participationEmployees);
		
		employeeFirstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		employeeLastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		employeeFunctionCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("title"));

		participantFirstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		participantLastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		participantFunctionCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("title"));
		
		employeeTable.setItems(emps);
		participantTable.setItems(parts);
		
	}
	
	public void resetVars() {
		training = null;
		session = null;
		participationEmployees = null;
	}
	
}
