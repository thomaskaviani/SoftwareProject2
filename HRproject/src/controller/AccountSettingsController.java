package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sha256.Encryption;
import application.Main;
import application.Navigator;
import dao.UserDAO;

public class AccountSettingsController implements Initializable{

	@FXML private Rectangle balk;
	
	@FXML private Label errorLabel1;
	@FXML private Label errorLabel2;
	
	@FXML private TextField newName;
	@FXML private PasswordField oldPass;
	@FXML private PasswordField newPass;
	@FXML private PasswordField confirmPass;
	
	
	@FXML protected void toGeneral(ActionEvent e) {
		
		Navigator.loadVista(Navigator.GeneralSettingsView);
	}

	@FXML protected void changePassword(ActionEvent e) {
		
		errorLabel1.setText("");
		errorLabel2.setText("");
		
		if (Encryption.sha256(oldPass.getText()).equals(LoginController.userLogged.getPassword())) {
			
			if (newPass.getText().trim().isEmpty() || newPass.getText().trim().isEmpty() || newPass.getText().length() < 4 || oldPass.getText().length() < 4) {
				
				errorLabel2.setText("New password needs to be longer than 4 characters");
				errorLabel2.setTextFill(Color.FIREBRICK);
				
			} else if (!(newPass.getText().equals(confirmPass.getText()))) {
				
				errorLabel2.setText("Passwords don't match");
				errorLabel2.setTextFill(Color.FIREBRICK);
				
				System.out.println(newPass.getText());
				System.out.println(confirmPass.getText());
				
			} else {
				
				LoginController.userLogged.setPassword(newPass.getText());
				UserDAO udao = new UserDAO();
				udao.update(LoginController.userLogged);
				errorLabel2.setText("Password changed");
				errorLabel2.setTextFill(Color.GREEN);
				oldPass.setText("");
				newPass.setText("");
				confirmPass.setText("");
				
			}
		} else {
			errorLabel2.setText("Wrong password");
			errorLabel2.setTextFill(Color.FIREBRICK);
		}
		
	} 
	
	@FXML protected void changeName(ActionEvent e) {
		
		errorLabel1.setText("");
		errorLabel2.setText("");
		
		if (newName.getText().trim().isEmpty() || newName.getText().length() < 5) {
			errorLabel1.setText("The accountname needs to be longer than 4 characters");
			errorLabel1.setTextFill(Color.FIREBRICK);

		} else {
			LoginController.userLogged.setUsername(newName.getText());
			UserDAO udao = new UserDAO();
			udao.update(LoginController.userLogged);
			errorLabel1.setText("Accountname changed");
			errorLabel1.setTextFill(Color.GREEN);
			newName.setText("");
			Navigator.loadUserVista(Navigator.UserBoxView);
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		balk.setFill(Color.valueOf(Main.color));
		errorLabel1.setText("");
		errorLabel2.setText("");
	}
}
