package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Navigator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MenuBoxController implements Initializable {

	@FXML private Pane activePaneHome;
	@FXML private Pane activePaneEmployees;
	@FXML private Pane activePaneTraining;
	@FXML private Pane activePaneRequest;
	@FXML private Pane activePaneSurvey;
	@FXML private Pane activePaneBook;
	@FXML private Pane activePaneSettings;
	@FXML private Pane activePaneStats;
	
	@FXML private Button homeButton;
	@FXML private Button employeeButton;
	@FXML private Button trainingButton;
	@FXML private Button requestButton;
	@FXML private Button settingButton;
	@FXML private Button surveyButton;
	@FXML private Button bookButton;
	@FXML private Button statsButton;
	
	
	
	@FXML protected void toHome(ActionEvent e) {
		
		setHome();
		resetVars();
		Navigator.loadVista(Navigator.HomeView);
	}
    
	@FXML protected void toStats(ActionEvent e) {
		setStats();
		resetVars();
		Navigator.loadVista(Navigator.StatisticsView);
	}
    @FXML protected void toTrainings(ActionEvent e) {
    	
		setTraining();
		resetVars();
		Navigator.loadVista(Navigator.TrainingView);		
	}
	
	@FXML protected void toEmployees(ActionEvent e) {
		
		setEmps();
		resetVars();
		Navigator.loadVista(Navigator.EmployeeView);			
	}
	
	@FXML protected void toSettings(ActionEvent e) {
		
		setSettings();
		resetVars();
		Navigator.loadVista(Navigator.GeneralSettingsView);			
	}

	@FXML protected void toSurvey(ActionEvent e) {
		
		setSurvey();
		resetVars();
		Navigator.loadVista(Navigator.SearchSurveyView);			
	}
	
	@FXML protected void toTrainingRequests(ActionEvent e) {
		
		setRequest();
		resetVars();
		Navigator.loadVista(Navigator.TrainingRequestView);
		
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setHome();
	}

	
	public void setHome() {
		
		activePaneHome.setStyle("-fx-background-color: #" + Main.color + ";");
		activePaneEmployees.setStyle("-fx-background-color: lightgrey");
		activePaneTraining.setStyle("-fx-background-color: lightgrey");
		activePaneRequest.setStyle("-fx-background-color: lightgrey");
		activePaneSurvey.setStyle("-fx-background-color: lightgrey");
		activePaneBook.setStyle("-fx-background-color: lightgrey");
		activePaneSettings.setStyle("-fx-background-color: lightgrey");
		activePaneStats.setStyle("-fx-background-color: lightgrey");
		
		homeButton.setTextFill(Color.valueOf(Main.color));
		employeeButton.setTextFill(Color.BLACK);
		trainingButton.setTextFill(Color.BLACK);
		requestButton.setTextFill(Color.BLACK);
		settingButton.setTextFill(Color.BLACK);
		surveyButton.setTextFill(Color.BLACK);
		bookButton.setTextFill(Color.BLACK);
		statsButton.setTextFill(Color.BLACK);
		
	}
	public void setEmps() { 

		activePaneHome.setStyle("-fx-background-color: lightgrey");
		activePaneEmployees.setStyle("-fx-background-color: #" + Main.color + ";");
		activePaneTraining.setStyle("-fx-background-color: lightgrey");
		activePaneRequest.setStyle("-fx-background-color: lightgrey");
		activePaneSurvey.setStyle("-fx-background-color: lightgrey");
		activePaneBook.setStyle("-fx-background-color: lightgrey");
		activePaneSettings.setStyle("-fx-background-color: lightgrey");
		activePaneStats.setStyle("-fx-background-color: lightgrey");
		statsButton.setTextFill(Color.BLACK);
		homeButton.setTextFill(Color.BLACK);
		employeeButton.setTextFill(Color.valueOf(Main.color));
		trainingButton.setTextFill(Color.BLACK);
		requestButton.setTextFill(Color.BLACK);
		settingButton.setTextFill(Color.BLACK);
		surveyButton.setTextFill(Color.BLACK);
		bookButton.setTextFill(Color.BLACK);
		
	}
	public void setTraining() {
		
		activePaneHome.setStyle("-fx-background-color: lightgrey");
		activePaneEmployees.setStyle("-fx-background-color: lightgrey");
		activePaneTraining.setStyle("-fx-background-color: #" + Main.color + ";");
		activePaneRequest.setStyle("-fx-background-color: lightgrey");
		activePaneSurvey.setStyle("-fx-background-color: lightgrey");
		activePaneBook.setStyle("-fx-background-color: lightgrey");
		activePaneSettings.setStyle("-fx-background-color: lightgrey");
		activePaneStats.setStyle("-fx-background-color: lightgrey");
		statsButton.setTextFill(Color.BLACK);
		homeButton.setTextFill(Color.BLACK);
		employeeButton.setTextFill(Color.BLACK);
		trainingButton.setTextFill(Color.valueOf(Main.color));
		requestButton.setTextFill(Color.BLACK);
		settingButton.setTextFill(Color.BLACK);
		surveyButton.setTextFill(Color.BLACK);
		bookButton.setTextFill(Color.BLACK);
		
	}
	public void setSettings() {

		activePaneHome.setStyle("-fx-background-color: lightgrey");
		activePaneEmployees.setStyle("-fx-background-color: lightgrey");
		activePaneTraining.setStyle("-fx-background-color: lightgrey");
		activePaneRequest.setStyle("-fx-background-color: lightgrey");
		activePaneSurvey.setStyle("-fx-background-color: lightgrey");
		activePaneBook.setStyle("-fx-background-color: lightgrey");
		activePaneSettings.setStyle("-fx-background-color: #" + Main.color + ";");
		activePaneStats.setStyle("-fx-background-color: lightgrey");
		statsButton.setTextFill(Color.BLACK);
		homeButton.setTextFill(Color.BLACK);
		employeeButton.setTextFill(Color.BLACK);
		trainingButton.setTextFill(Color.BLACK);
		requestButton.setTextFill(Color.BLACK);
		settingButton.setTextFill(Color.valueOf(Main.color));
		surveyButton.setTextFill(Color.BLACK);
		bookButton.setTextFill(Color.BLACK);
		
	}
	public void setSurvey() {

		activePaneHome.setStyle("-fx-background-color: lightgrey");
		activePaneEmployees.setStyle("-fx-background-color: lightgrey");
		activePaneTraining.setStyle("-fx-background-color: lightgrey");
		activePaneRequest.setStyle("-fx-background-color: lightgrey");
		activePaneSurvey.setStyle("-fx-background-color: #" + Main.color + ";");
		activePaneBook.setStyle("-fx-background-color: lightgrey");
		activePaneSettings.setStyle("-fx-background-color: lightgrey");
		activePaneStats.setStyle("-fx-background-color: lightgrey");
		statsButton.setTextFill(Color.BLACK);
		homeButton.setTextFill(Color.BLACK);
		employeeButton.setTextFill(Color.BLACK);
		trainingButton.setTextFill(Color.BLACK);
		requestButton.setTextFill(Color.BLACK);
		settingButton.setTextFill(Color.BLACK);
		surveyButton.setTextFill(Color.valueOf(Main.color));
		bookButton.setTextFill(Color.BLACK);
		
	}
	public void setRequest() {

		activePaneHome.setStyle("-fx-background-color: lightgrey");
		activePaneEmployees.setStyle("-fx-background-color: lightgrey");
		activePaneTraining.setStyle("-fx-background-color: lightgrey");
		activePaneRequest.setStyle("-fx-background-color: #" + Main.color + ";");
		activePaneSurvey.setStyle("-fx-background-color: lightgrey");
		activePaneBook.setStyle("-fx-background-color: lightgrey");
		activePaneSettings.setStyle("-fx-background-color: lightgrey");
		activePaneStats.setStyle("-fx-background-color: lightgrey");
		statsButton.setTextFill(Color.BLACK);
		homeButton.setTextFill(Color.BLACK);
		employeeButton.setTextFill(Color.BLACK);
		trainingButton.setTextFill(Color.BLACK);
		requestButton.setTextFill(Color.valueOf(Main.color));
		settingButton.setTextFill(Color.BLACK);
		surveyButton.setTextFill(Color.BLACK);
		bookButton.setTextFill(Color.BLACK);
		
	}
	public void setStats() {
		
		activePaneHome.setStyle("-fx-background-color: lightgrey");
		activePaneEmployees.setStyle("-fx-background-color: lightgrey");
		activePaneTraining.setStyle("-fx-background-color: lightgrey");
		activePaneRequest.setStyle("-fx-background-color: lightgrey");
		activePaneSurvey.setStyle("-fx-background-color: lightgrey");
		activePaneBook.setStyle("-fx-background-color: lightgrey");
		activePaneSettings.setStyle("-fx-background-color: lightgrey");
		activePaneStats.setStyle("-fx-background-color: #" + Main.color + ";");
		statsButton.setTextFill(Color.valueOf(Main.color));
		homeButton.setTextFill(Color.BLACK);
		employeeButton.setTextFill(Color.BLACK);
		trainingButton.setTextFill(Color.BLACK);
		requestButton.setTextFill(Color.BLACK);
		settingButton.setTextFill(Color.BLACK);
		surveyButton.setTextFill(Color.BLACK);
		bookButton.setTextFill(Color.BLACK);
	}
	
	public void resetVars() {
		TrainingDetailController.training = null;
		EmployeeDetailController.employee = null;
	}
}
