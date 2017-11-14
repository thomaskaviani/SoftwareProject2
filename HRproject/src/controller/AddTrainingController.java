package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import dao.TrainingDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Training;

public class AddTrainingController implements Initializable {
	
	@FXML private TextArea trainingDesc;
	@FXML private TextField trainingName;

	@FXML
	protected void saveTraining(ActionEvent e) {
		
		Training train = new Training(trainingName.getText(),trainingDesc.getText());
		TrainingDAO tdao = new TrainingDAO();
		tdao.insert(train);
		Navigator.loadVista(Navigator.SearchTrainingView);
				
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

	}

}
