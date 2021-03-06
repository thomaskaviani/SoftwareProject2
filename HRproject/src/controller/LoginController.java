package controller;


import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import application.Navigator;

import dao.UserDAO;
import model.User;
import sha256.Encryption;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class LoginController implements Initializable {
	
	@FXML private Rectangle balk;
	
	private UserDAO userManager = new UserDAO();
	
	public static User userLogged;
	 
	@FXML private Label username;
	@FXML private JFXTextField usernameField;
	@FXML private JFXPasswordField passwordField;
	@FXML private Label errorLabel;
	
	@FXML protected void doLogin(ActionEvent e) {
		
		User x = userManager.getByUsername(usernameField.getText());
		
		if(x != null) {
			if (Encryption.sha256(passwordField.getText()).equals(x.getPassword())) {
				
				UserBoxController.user = x.getUsername();
				userLogged = x;
				Main.color = x.getColor();
				MenuBoxController.active = "home";
				
				Navigator.loadUserVista(Navigator.UserBoxView);
				//Navigator.loadMenuVista(Navigator.MenuBoxView);
				Navigator.loadVista(Navigator.HomeView);
				
				
			} else {
				errorLabel.setTextFill(Color.FIREBRICK);
				errorLabel.setText("Invalid username or password");
			}
		} else {
			errorLabel.setTextFill(Color.FIREBRICK);
			errorLabel.setText("No user found");
		}
	}
	
	@FXML protected void toForgotPassword(MouseEvent e) {
		
	
		Navigator.loadVista(Navigator.ForgotPasswordView);
	}
	
	@FXML public void onEnter(ActionEvent ae){
		doLogin(ae);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	usernameField.requestFocus();
	        }
	    });

		userLogged = null;
		balk.setFill(Color.valueOf("b3b7a9"));
		
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	usernameField.requestFocus();
	        }
	    });
		
		
	}
	  
}
