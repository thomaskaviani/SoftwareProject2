package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AccountSettingsController implements Initializable{

	@FXML
	protected void toGeneral(ActionEvent e) {
		
		Navigator.loadVista(Navigator.GeneralSettingsView);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
