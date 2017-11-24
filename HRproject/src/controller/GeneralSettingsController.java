package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import application.Navigator;

public class GeneralSettingsController implements Initializable{

	@FXML
	protected void toAccountSettings(ActionEvent e) {
		
		Navigator.loadVista(Navigator.AccountSettingsView);
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

	       // TODO Auto-generated method stub
	   }
}
