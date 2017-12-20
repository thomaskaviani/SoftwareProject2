package controller;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import application.CacheData;
import application.Navigator;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class LoadingController implements Initializable {


	@FXML private VBox loadingContent;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
        //nieuwe thread voor caching
    	Thread th = new Thread(() -> {
    	    setCache();
    	});
    	th.setDaemon(true);
    	th.start();
    	
	}


	public void setCache() {
		
		
		CacheData.setAddresses();
		CacheData.setTeachers();
		
		
		try {
			CacheData.setEmployees();
		} catch (IOException | ParserConfigurationException | SAXException | ParseException e) {
			e.printStackTrace();
		}
    	
		CacheData.setTrainings();
        CacheData.setParticipations();
        CacheData.setNecessity();
        
        PauseTransition delay = new PauseTransition(Duration.seconds(0.1));
    	delay.setOnFinished( event -> Navigator.loadVista(Navigator.LoginView) );
    	delay.play();

	}
}
