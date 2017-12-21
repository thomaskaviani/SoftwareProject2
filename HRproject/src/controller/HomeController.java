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
		MenuBoxController.active = "trainings";
		Navigator.loadMenuVista(Navigator.MenuBoxView);
		Navigator.loadVista(Navigator.TrainingView);
	}
	
	@FXML
	protected void toEmployees(ActionEvent e) {
		MenuBoxController.active = "employees";
		Navigator.loadMenuVista(Navigator.MenuBoxView);
		Navigator.loadVista(Navigator.EmployeeView);
				
		
	}
	
	@FXML
	protected void toStats(ActionEvent e) {
		
		MenuBoxController.active = "stats";
		Navigator.loadMenuVista(Navigator.MenuBoxView);
		if (Main.stats) {
			Navigator.loadVista(Navigator.StatisticsView);
		} else {
			Navigator.loadVista(Navigator.StatisticsLoadingView);
		}
	}
	
	//MOET NOG WEG
	@FXML
	protected void toBooks(ActionEvent e) {
		
		Navigator.loadVista(Navigator.SearchBookView);
				
		
	}
	
	@FXML
	protected void toSettings(ActionEvent e) {
		MenuBoxController.active = "settings";
		Navigator.loadMenuVista(Navigator.MenuBoxView);
		Navigator.loadVista(Navigator.GeneralSettingsView);
				
		
	}
	
	@FXML
	protected void toTrainingRequests(ActionEvent e) {
		MenuBoxController.active = "requests";
		Navigator.loadVista(Navigator.TrainingRequestView);
	}
	
	@FXML
	protected void toSurvey(ActionEvent e) {
		MenuBoxController.active = "surveys";
		Navigator.loadMenuVista(Navigator.MenuBoxView);
		Navigator.loadVista(Navigator.SearchSurveyView);		
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		MenuBoxController.active = "home";
		Navigator.loadMenuVista(Navigator.MenuBoxView);
		
	}
}
