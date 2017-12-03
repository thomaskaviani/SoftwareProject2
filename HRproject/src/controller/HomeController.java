package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import application.Main;
import application.Navigator;

public class HomeController implements Initializable {

	@FXML private Rectangle balk;
	
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
	protected void toTrainingRequests(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingRequestView);
	}
	
	@FXML
	protected void toSurveys(ActionEvent e) {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		balk.setFill(Color.valueOf(Main.color));
		
	}
}
