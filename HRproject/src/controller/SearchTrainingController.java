package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.CacheData;
import application.Navigator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Training;

public class SearchTrainingController implements Initializable {
	
	@FXML
	private TableView<Training> tableView;
	
	@FXML
	private TableColumn<Training, String> trainingNameCol;
	
	@FXML
	private TableColumn<Training, String> trainingDescCol;

	@FXML
	protected void toTrainingDetail(ActionEvent e) {
		
		Training t = tableView.getSelectionModel().getSelectedItem();
		TrainingDetailController.training = t;  
    
		Navigator.loadVista(Navigator.TrainingDetailView);
				
		
	}

	@FXML
	protected void toTraining(ActionEvent e) {
		
		
		Navigator.loadVista(Navigator.TrainingView);
				
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		ObservableList<Training> trainingen = FXCollections.observableArrayList(CacheData.trainings);
		
		tableView.setItems(trainingen);
		
		trainingNameCol.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
		trainingDescCol.setCellValueFactory(new PropertyValueFactory<Training, String>("goal"));
		
		
	}

}


