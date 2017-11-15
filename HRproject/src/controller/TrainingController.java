package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TrainingController implements Initializable {

	@FXML
	protected void toSearchTraining(ActionEvent e) {
		
		Navigator.loadVista(Navigator.SearchTrainingView);
				
		
	}
	@FXML
	protected void toHome(ActionEvent e) {
		
		Navigator.loadVista(Navigator.HomeView);
				
		
	}
	
	@FXML
	protected void toAddTraining(ActionEvent e) {
		
		Navigator.loadVista(Navigator.AddTrainingView);
				
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
