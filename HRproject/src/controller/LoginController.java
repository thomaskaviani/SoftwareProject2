package controller;


import java.net.URL;
import java.util.ResourceBundle;

import application.CacheData;
import application.Navigator;

import dao.UserDAO;

import model.User;
import sha256.Encryption;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class LoginController implements Initializable {
	
	UserDAO userManager = new UserDAO();
	 
	@FXML private Label username;
	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
	@FXML private Label errorLabel;
	
	@FXML
	protected void doLogin(ActionEvent e) {
		
		System.out.println("Check!");
		
		/*
		User x = userManager.getByUsername(usernameField.getText());
		
		if(x != null) {
			if (Encryption.sha256(passwordField.getText()).equals(x.getPassword())) {
				
				UserBoxController.user = x.getUsername();
				CacheData.loggedIn = true;
				
				Navigator.loadVista(Navigator.HomeView);
				Navigator.loadUserVista(Navigator.UserBoxView);
				Navigator.loadMenuVista(Navigator.MenuBoxView);
				
			} else {
				errorLabel.setTextFill(Color.FIREBRICK);
				errorLabel.setText("Invalid username or password");
			}
		} else {
			
			errorLabel.setTextFill(Color.FIREBRICK);
			errorLabel.setText("No user found");
		}
		
		*/
		
		
	}
	
	
	
	@FXML
	protected void doLogin2(KeyEvent e) {
		switch(e.getCode()) {
			case ENTER: 
				User x = userManager.getByUsername(usernameField.getText());
				System.out.println(x);
				
				if(x != null) {
					if (Encryption.sha256(passwordField.getText()).equals(x.getPassword())) {
						
						UserBoxController.user = x.getUsername();
						CacheData.loggedIn = true;
						
						Navigator.loadVista(Navigator.HomeView);
						Navigator.loadUserVista(Navigator.UserBoxView);
						Navigator.loadMenuVista(Navigator.MenuBoxView);
						
					} else {
						errorLabel.setTextFill(Color.FIREBRICK);
						errorLabel.setText("Invalid username or password");
					}
				} else {
					
					errorLabel.setTextFill(Color.FIREBRICK);
					errorLabel.setText("No user found");
				}
				
				break;
			default:
				break;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	usernameField.requestFocus();
		    }
		});
	}
	  
}
