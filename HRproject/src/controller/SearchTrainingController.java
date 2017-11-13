package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.TrainingDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TrainingDAO tdao = new TrainingDAO();
		
		ObservableList<Training> trainingen = FXCollections.observableArrayList(tdao.getAll());
		
		tableView.setItems(trainingen);
		
		trainingNameCol.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
		trainingDescCol.setCellValueFactory(new PropertyValueFactory<Training, String>("goal"));
		
		
	}

}


