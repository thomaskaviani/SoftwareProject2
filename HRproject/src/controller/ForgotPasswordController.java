package controller;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import application.Navigator;
import application.randomStringGenerator;
import dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.User;

public class ForgotPasswordController implements Initializable {
	
	@FXML private TextField usernameField;

	@FXML protected void toLogin(ActionEvent e) {
		Navigator.loadVista(Navigator.LoginView);
	}
	
	@FXML protected void sendMail(ActionEvent e) {
		
		
		UserDAO udao = new UserDAO();
		User usr = udao.getByUsername(usernameField.getText());

		
		
		if (usr != null) {
			 
			//nieuw random passwoord
			String newPass = randomStringGenerator.generateString();
			usr.setPassword(newPass);
			udao.update(usr);
			
			final String username = "reflextrainings.info@gmail.com";
			final String password = "EHBReflex";
			final String receiver = usr.getEmail();
			

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			
			
			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("reflextrainings.info@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiver));
				message.setSubject("Password Reflex-trainings");
				message.setText(
						
							"Dear " + usernameField.getText() + ",\n\n"
							+ "I am happy to present you with your new password for reflex: \n" 
							+ "Password: " + newPass
				);

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException x) {
					throw new RuntimeException(x);
			}
			
			
			Navigator.loadVista(Navigator.LoginView);
			
			
		}
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
