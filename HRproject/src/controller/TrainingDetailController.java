package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import application.Navigator;
import dao.SessionsDAO;
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
import model.Employee;
import model.Sessions;
import model.Training;


public class TrainingDetailController implements Initializable{

	public static Training training;
	
	@FXML
	private Label trainingName;
	
	@FXML
	private TableView<Sessions> sessionTable;
	
	@FXML
	private TableView<Employee> participantTable;
	
	@FXML
	private TableColumn<Sessions, Date> sessionTableCol;
	
	@FXML
	private TableColumn<Employee, String> participantTableCol;
	
	@FXML
	private TextField sessionSearchBar;
	
	@FXML
	protected void toAddSession(ActionEvent e) {
			
			Navigator.loadVista(Navigator.AddSessionView);
	}
		
	/*deze view moet nog gemaakt worden
	 
	@FXML
	protected void toLocation(ActionEvent e) {
				
			Navigator.loadVista(Navigator.LocationView);
	}
	
	*/
	
	
	@FXML
	protected void toAddEmployee(ActionEvent e) {
				
			Navigator.loadVista(Navigator.AddEmployeeToSessionView);
	}
		
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		trainingName.setText(training.getName());
		
		
		SessionsDAO sdao = new SessionsDAO();
		ObservableList<Sessions> sessions = FXCollections.observableArrayList(sdao.getByTraining(training.getTrainingId()));
		
		sessionTable.setItems(sessions);
		sessionTableCol.setCellValueFactory(new PropertyValueFactory<Sessions, Date>("startTime"));
		
	}
	
	

}
