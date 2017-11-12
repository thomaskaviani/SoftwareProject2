package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
		
	}

}


