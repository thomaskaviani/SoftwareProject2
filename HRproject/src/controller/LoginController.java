package controller;


import application.Navigator;

import dao.UserDAO;

import model.User;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class LoginController {
	
	UserDAO userManager = new UserDAO();
	 
	@FXML private Label username;
	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
	@FXML private Label errorLabel;
	
	@FXML
	protected void doLogin(ActionEvent e) {
		
		
		User x = userManager.getByUsername(usernameField.getText());
		System.out.println(x);
		if(x != null) {
			if (passwordField.getText().equals(x.getPassword())) {
				
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
		
		
	}
	  
}
