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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class LoadingController implements Initializable {

	Float[] values = new Float[] {-1.0f};
	ProgressIndicator[] progressBar = new ProgressIndicator[values.length];

	@FXML private VBox loadingContent;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		ProgressIndicator pin = progressBar[0] = new ProgressIndicator();
		
        pin.setProgress(values[0]);
        pin.setScaleX(pin.getScaleX() * 2);
        pin.setScaleY(pin.getScaleY() * 2);
        loadingContent.getChildren().addAll(pin);
        
        //nieuwe thread voor caching
    	Thread th = new Thread(() -> {
    	    setCache();
    	});
    	th.setDaemon(true);
    	th.start();
    	
	}


	public void setCache() {
		
		try {
			CacheData.setEmployees();
		} catch (IOException | ParserConfigurationException | SAXException | ParseException e) {
			e.printStackTrace();
		}
    	
        CacheData.setTrainings();
        CacheData.setParticipations();
        
        PauseTransition delay = new PauseTransition(Duration.seconds(0.1));
    	delay.setOnFinished( event -> Navigator.loadVista(Navigator.LoginView) );
    	delay.play();

	}
}
