package controller;

import java.net.URL;
import java.util.ResourceBundle;

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

import model.Survey;
import model.Training;
import application.CacheData;
import application.Main;
import application.Navigator;
import dao.SurveyDAO;

public class SearchTrainingController implements Initializable {
	
	@FXML private Rectangle balk;
	
	@FXML private TableView<Training> tableView;
	
	@FXML private TextField searchBar;
	@FXML private Label errorLabel;
	
	@FXML private TableColumn<Training, String> trainingNameCol;
	
	@FXML private TableColumn<Training, String> trainingDescCol;

	@FXML protected void toTrainingDetail(ActionEvent e) {
		
		Training t = tableView.getSelectionModel().getSelectedItem();
		
		if (t != null) {
			TrainingDetailController.training = t;  
			Navigator.loadVista(Navigator.TrainingDetailView);
		} else {
			errorLabel.setText("No training selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
				
	}

	@FXML protected void toTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
	}
	
	@FXML protected void toAddSession(ActionEvent e) {
		
		Training training = tableView.getSelectionModel().getSelectedItem();
		
		if (training != null) {
			AddSessionController.training = training;
			Navigator.loadVista(Navigator.AddSessionView);
		} else {
			errorLabel.setText("No training selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
	}
	
	@FXML protected void toSurvey(ActionEvent e) {
		SurveyDAO sdao = new SurveyDAO();
		Training t = tableView.getSelectionModel().getSelectedItem();
		
		if (t != null) {
			
			if(sdao.getByTraining(t.getTrainingId())!=null)
			{
				errorLabel.setText("The survey for training: " + t.getTrainingId() + " already exists");
				errorLabel.setTextFill(Color.FIREBRICK);
			}
			else
			{
				String surveyNaam = t.getName() + " Survey";
				Survey s = new Survey(t.getTrainingId(),surveyNaam);
				
				sdao.insert(s);
				s=sdao.getByTraining(t.getTrainingId());
				AddQuestionSurveyController.training = t;  
				AddQuestionSurveyController.survey=s;
				 
				Navigator.loadVista(Navigator.AddQuestionSurveyView);
			}
			
		} else {
			errorLabel.setText("No training selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
	
	}

	@FXML protected void clickTrain(MouseEvent e) {
		errorLabel.setText("");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		errorLabel.setText("");
		balk.setFill(Color.valueOf(Main.color));
		
		ObservableList<Training> trainings = FXCollections.observableArrayList(CacheData.trainings);
		
		trainingNameCol.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
		trainingDescCol.setCellValueFactory(new PropertyValueFactory<Training, String>("goal"));
		
		
		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Training> filteredTrainings = new FilteredList<>(trainings, p -> true);
				
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
		SortedList<Training> sortedTrainings = new SortedList<>(filteredTrainings);
						
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedTrainings.comparatorProperty().bind(tableView.comparatorProperty());
						
		// 5. Add sorted (and filtered) data to the table.
		tableView.setItems(sortedTrainings);
		
	}

	
}


