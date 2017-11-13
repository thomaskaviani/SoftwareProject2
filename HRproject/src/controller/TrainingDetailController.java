package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Training;


public class TrainingDetailController implements Initializable{

	public static Training training;
	
	@FXML
	private Label trainingName;
	
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
			
	}
	
	

}
