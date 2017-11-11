package controller;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomeController {

	@FXML
	protected void toTrainings(ActionEvent e) {
		
		Navigator.loadVista(Navigator.TrainingView);
				
		
	}
	
	@FXML
	protected void toEmployees(ActionEvent e) {
		
		Navigator.loadVista(Navigator.EmployeeView);
				
		
	}
	
	@FXML
	protected void toSettings(ActionEvent e) {
		
		Navigator.loadVista(Navigator.GeneralSettingsView);
				
		
	}
	
	@FXML
	protected void toBooks(ActionEvent e) {
		
	}
	
	@FXML
	protected void toCertificates(ActionEvent e) {
		
	}
	
	@FXML
	protected void toSurveys(ActionEvent e) {
		
	}
}
