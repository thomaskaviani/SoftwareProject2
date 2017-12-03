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

public class AccountSettingsController implements Initializable{

	@FXML private Rectangle balk;
	
	@FXML
	protected void toGeneral(ActionEvent e) {
		
		Navigator.loadVista(Navigator.GeneralSettingsView);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		balk.setFill(Color.valueOf(Main.color));
		
	}
}
