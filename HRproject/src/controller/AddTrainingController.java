package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
	@FXML private Label errorLabel;

	@FXML protected void saveTraining(ActionEvent e) {
		
		
		TrainingDAO tdao = new TrainingDAO();
		Training temp = tdao.getByName(trainingName.getText().trim());
		
		if (trainingName.getText().trim().isEmpty() || trainingDesc.getText().trim().isEmpty()) {
			errorLabel.setTextFill(Color.FIREBRICK);
			errorLabel.setText("Training name or description can not be empty");
		} else if (trainingName.getText().trim().length() < 6) {
			errorLabel.setTextFill(Color.FIREBRICK);
			errorLabel.setText("Training name needs to be longer than 5 characters");
		} else if (trainingDesc.getText().trim().length() < 16) {
			errorLabel.setTextFill(Color.FIREBRICK);
			errorLabel.setText("Training description needs to be longer than 15 characters");
		} else if (temp != null){
			errorLabel.setTextFill(Color.FIREBRICK);
			errorLabel.setText("Training already exists!");
		} else {
			Training train = new Training(trainingName.getText(),trainingDesc.getText());
			tdao.insert(train);
			CacheData.setTrainings();
			Navigator.loadVista(Navigator.SearchTrainingView);
		}
		
				
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
