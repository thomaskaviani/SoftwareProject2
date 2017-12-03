package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import application.Navigator;

public class HomeController implements Initializable {

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
	protected void toSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SearchSurveyView);
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
