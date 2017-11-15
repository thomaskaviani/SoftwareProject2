package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;


import application.CacheData;
import application.Navigator;
import dao.ParticipationDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employee;
import model.Participation;
import model.Sessions;
import model.Training;

public class AddEmployeeToSessionController implements Initializable {

	public static Training training;
	public static Sessions session;
	
	public static List<Participation> parts;
	public static List<Employee> empsPart;
	
	@FXML private Label trainingTitle;
	
	@FXML private TableView<Employee> employeeTable;
	@FXML private TableView<Employee> participantTable;
	
	@FXML private TableColumn<Employee, String> employeeFirstNameCol;
	@FXML private TableColumn<Employee, String> employeeLastNameCol;
	@FXML private TableColumn<Employee, String> employeeFunctionCol;
	
	@FXML private TableColumn<Employee, String> participantFirstNameCol;
	@FXML private TableColumn<Employee, String> participantLastNameCol;
	@FXML private TableColumn<Employee, String> participantFunctionCol;
	
	
	
	@FXML
	protected void toTrainingDetail(ActionEvent e) {
		
		Navigator.loadVista(Navigator.TrainingDetailView);
				
	}
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String date = df.format(session.getStartTime());
		trainingTitle.setText(training.getName() + " - " + date);
		
		ObservableList<Employee> emps = FXCollections.observableArrayList(CacheData.employees);
		employeeTable.setItems(emps);
		
		employeeFirstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		employeeLastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		employeeFunctionCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("title"));
		
		ParticipationDAO pdao = new ParticipationDAO();
		if (pdao.getBySessionId(session.getSessionId()) != null) {
			parts = pdao.getBySessionId(session.getSessionId());
		}
		
		
		for (Participation p : parts) {
			
			//TO DOOO
			
		}
		
		
	}
	

}
