package controller;

import java.net.URL;


import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import application.Main;
import application.Navigator;
import dao.UserDAO;
import model.User;
import sha256.Encryption;

public class AccountSettingsController implements Initializable{

	@FXML private Rectangle balk;
	
	

	
	@FXML private JFXTextField userNameField;
	@FXML private JFXPasswordField oldPasswordField;
	@FXML private JFXPasswordField newPasswordField;
	@FXML private Label	errorLabel;


	
	@FXML
	protected void toGeneral(ActionEvent e) {
		
		Navigator.loadVista(Navigator.GeneralSettingsView);
	}

	private UserDAO userManager = new UserDAO();
	public static User userLogged;

	@FXML
	protected void changeUsername(ActionEvent e) {
		User x = userManager.getByUsername(userNameField.getText());
		x.setUsername(userNameField.getText());
		userManager.update(x);
	}
	
	@FXML
	protected void changePassword(ActionEvent e) {
		User x = new User();
		if (Encryption.sha256(x.getPassword()).equals(oldPasswordField.getText())){
		x.setPassword(newPasswordField.getText());
		}
	}

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		balk.setFill(Color.valueOf(Main.color));
		
	}
}
