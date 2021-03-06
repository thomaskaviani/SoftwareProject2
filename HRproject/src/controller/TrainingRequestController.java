package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.CacheData;
import application.Main;
import application.Navigator;
import dao.TrainingDAO;
import dao.TrainingRequestDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Training;
import model.TrainingRequest;

public class TrainingRequestController implements Initializable {

	@FXML private Rectangle balk;
	@FXML private TableView<TrainingRequest> tableView;
	
	@FXML private TextField searchBar;
	@FXML private Label errorLabel;
	
	@FXML private TableColumn<TrainingRequest, String> trainingNameCol;
	
	@FXML private TableColumn<TrainingRequest, String> trainingDescCol;
	
	@FXML private TableColumn<TrainingRequest, String> employeeCol; 
	
	@FXML protected void clickTrain(MouseEvent e) {
		errorLabel.setText("");
	}
	
	@FXML protected void toHome(ActionEvent e) {
		Navigator.loadVista(Navigator.HomeView);
	}
	
	@FXML protected void acceptTraining(ActionEvent e) {
		
		TrainingRequest t = tableView.getSelectionModel().getSelectedItem();
		
		if (t != null) {
			
			Training temp = new Training (t.getName(),t.getGoal());
					
			TrainingDAO tdao = new TrainingDAO();
			TrainingRequestDAO trdao = new TrainingRequestDAO();
			trdao.delete(t);
			tdao.insert(temp);
			CacheData.setTrainings();
			Navigator.loadVista(Navigator.TrainingRequestView);
			
		} else {
			errorLabel.setText("No training selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
	}
	
	@FXML protected void assignTraining(ActionEvent e) {
		
		TrainingRequest request = tableView.getSelectionModel().getSelectedItem();
		if (request != null) {
			AssignRequestController.trainingRequest = request;
			Navigator.loadVista(Navigator.AssignRequestView);
		} else {
			errorLabel.setText("No trainingrequest selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//balk & errorlabel
		balk.setFill(Color.valueOf(Main.color));
		errorLabel.setText("");
		
		
		//TABEL
		TrainingRequestDAO tdao = new TrainingRequestDAO();
		ObservableList<TrainingRequest> trainings = FXCollections.observableArrayList(tdao.getAll());
		
		trainingNameCol.setCellValueFactory(new PropertyValueFactory<TrainingRequest, String>("name"));
		trainingDescCol.setCellValueFactory(new PropertyValueFactory<TrainingRequest, String>("goal"));
		employeeCol.setCellValueFactory(new PropertyValueFactory<TrainingRequest, String>("empId"));
		
		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<TrainingRequest> filteredTrainings = new FilteredList<>(trainings, p -> true);
						
		// 2. Set the filter Predicate whenever the filter changes.
		searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredTrainings.setPredicate(training -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
						return true;
				}
									
				// Compare first name and last name of every employee with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
									
				if (training.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches training name.
				} else if (training.getGoal().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches training description.
				}
							
				return false; // Does not match.
			});
		});
						
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<TrainingRequest> sortedTrainings = new SortedList<>(filteredTrainings);
								
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedTrainings.comparatorProperty().bind(tableView.comparatorProperty());
								
				// 5. Add sorted (and filtered) data to the table.
		tableView.setItems(sortedTrainings);
		
	}

}
