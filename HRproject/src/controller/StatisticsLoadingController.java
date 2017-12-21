package controller;

import java.net.URL;
import java.util.ResourceBundle;


import application.CacheData;
import application.Main;
import application.Navigator;
import dao.CertificateDAO;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.Certificate;
import model.Employee;
import model.Training;

public class StatisticsLoadingController implements Initializable {

	@FXML private Rectangle balk;
	
	@FXML protected void toHome(ActionEvent e) {
		Navigator.loadVista(Navigator.HomeView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		
		
		//nieuwe thread voor caching
    	Thread th = new Thread(() -> {
    	    setCache();
    	});
    	th.setDaemon(true);
    	th.start();

	}

	
	public void setCache() {
		
		
		CertificateDAO cdao = new CertificateDAO();
		int numberCerts;
		for (Employee x : CacheData.employees) {			
			numberCerts = cdao.getAmountByEmpId(x.getEmployeeId());
			x.setAmountCertificates(numberCerts);
		}
		
		for (Training t : CacheData.trainings) {
			for (Certificate c : CacheData.certificates) {
				if (c.getTrainingName().equals(t.getName())) {
					t.setParticipators(t.getParticipators() + 1);
				}
			}
		}
		
		
		Main.stats = true;
		
		PauseTransition delay = new PauseTransition(Duration.seconds(0.1));
		delay.setOnFinished( event -> Navigator.loadVista(Navigator.StatisticsView) );
		delay.play();

	}
}
