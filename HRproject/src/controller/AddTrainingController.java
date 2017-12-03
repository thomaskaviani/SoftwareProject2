package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Training;
import application.CacheData;
import application.Main;
import application.Navigator;
import dao.TrainingDAO;

public class AddTrainingController implements Initializable {
	
	@FXML private Rectangle balk;
	@FXML private TextArea trainingDesc;
	@FXML private TextField trainingName;

	@FXML protected void saveTraining(ActionEvent e) {
		
		Training train = new Training(trainingName.getText(),trainingDesc.getText());
		TrainingDAO tdao = new TrainingDAO();
		tdao.insert(train);
		CacheData.setTrainings();
		Navigator.loadVista(Navigator.SearchTrainingView);
				
	}
	
	//backbutton
	@FXML protected void toTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));

	}

}
