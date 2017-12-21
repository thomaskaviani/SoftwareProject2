package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import application.Main;
import application.Navigator;

public class GeneralSettingsController implements Initializable{

	@FXML private Rectangle balk;
	
	@FXML
	protected void toAccountSettings(ActionEvent e) {
		
		Navigator.loadVista(Navigator.AccountSettingsView);
	}
	
	@FXML
	protected void toGeneral(ActionEvent e) {
			
		Navigator.loadVista(Navigator.HomeView);
	}
	@FXML
	protected void toStyleOptions(ActionEvent e) {
			
		Navigator.loadVista(Navigator.StyleOptionsView);
	}
	
	/*
	
	@FXML
	protected void toStyleOptions(ActionEvent e) {
			
			Navigator.loadVista(Navigator.ExtrasView);
	}
	
	*/
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

			balk.setFill(Color.valueOf(Main.color));
	   }
}
