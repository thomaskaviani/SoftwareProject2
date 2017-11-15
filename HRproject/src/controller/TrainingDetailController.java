package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import application.Navigator;
import dao.AddressDAO;
import dao.SessionsDAO;
import dao.TeacherDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Address;
import model.Employee;
import model.Sessions;
import model.Teacher;
import model.Training;


public class TrainingDetailController implements Initializable{

	public static Training training;
	
	@FXML private Label trainingName;
	
	@FXML private Label infoTeacher;
	@FXML private Label infoAddress;
	@FXML private Label infoAddress2;
	@FXML private Label infoAddress3;
	
	@FXML private Label infoTime1;
	@FXML private Label infoTime2;
	
	@FXML
	private TableView<Sessions> sessionTable;
	
	@FXML
	private TableView<Employee> participantTable;
	
	@FXML
	private TableColumn<Sessions, Date> sessionTableCol;
	
	@FXML
	private TableColumn<Employee, String> participantFirstNameCol;
	@FXML
	private TableColumn<Employee, String> participantLastNameCol;
	
	@FXML
	private TextField sessionSearchBar;
	
	
	@FXML
	protected void toAddSession(ActionEvent e) {
			
			AddSessionController.training = training;
			Navigator.loadVista(Navigator.AddSessionView);
	}

	
	@FXML
	protected void toTrainingView(ActionEvent e) {
			
			Navigator.loadVista(Navigator.SearchTrainingView);
	}
	
	
	
	/*deze view moet nog gemaakt worden
	 
	@FXML
	protected void toLocation(ActionEvent e) {
				
			Navigator.loadVista(Navigator.LocationView);
	}
	
	*/
	
	
	@FXML
	protected void toAddEmployee(ActionEvent e) {
			
		if (sessionTable.getSelectionModel().isEmpty()) {
			
		} else {
			AddEmployeeToSessionController.session = sessionTable.getSelectionModel().getSelectedItem();
			AddEmployeeToSessionController.training = training;
			Navigator.loadVista(Navigator.AddEmployeeToSessionView);
		}
	}
		
	
	
	
	
	@FXML
	public void clickSession(MouseEvent e) {
		
		Sessions s = sessionTable.getSelectionModel().getSelectedItem();
		
		TeacherDAO teachdao = new TeacherDAO();
		Teacher t = teachdao.getById(s.getTeacherId());
		
		AddressDAO adao = new AddressDAO();
		Address a = adao.getById(s.getAddressId());
		
		String bus;	
		if (a.getBus() == null) {
			bus = "";
		} else {
			bus = a.getBus();
		}
		
		infoTeacher.setText(t.getTeacherName() + "		Email: " + t.getEmail() + "		Company: " + t.getCompany());
		infoAddress.setText(a.getStreet() + " " + a.getNumber() + " " + bus);
		infoAddress2.setText(a.getPostalCode() + " " + a.getPlace());
		infoAddress3.setText(a.getCountry());
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dateStart = df.format(s.getStartTime());
		String dateEnd = df.format(s.getEndTime());
		
		infoTime1.setText(dateStart);
		infoTime2.setText(dateEnd);
	}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		trainingName.setText(training.getName());
		
		
		SessionsDAO sdao = new SessionsDAO();
		
		if (sdao.getByTraining(training.getTrainingId()) != null) {
			
			ObservableList<Sessions> sessions = FXCollections.observableArrayList(sdao.getByTraining(training.getTrainingId()));
			
			sessionTable.setItems(sessions);
			sessionTableCol.setCellValueFactory(new PropertyValueFactory<Sessions, Date>("startTime"));
			
		}
		
	}
	
	

}
