package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MenuBoxController implements Initializable {

	@FXML
	protected void toHome(ActionEvent e) {
		Navigator.loadVista(Navigator.HomeView);
	}
    
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
	protected void toSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SearchSurveyView);			
	}
	
	
	@FXML
	protected void toTrainingRequests(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingRequestView);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
