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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Survey;
import model.Survey_q;
import application.Main;
import application.Navigator;

import dao.Survey_qDAO;

public class SurveyDetailController implements Initializable {
	
	public static Survey survey;
	public static Survey_q sQuestions;
	
	@FXML
	private TableView<Survey_q> questionTable;
	
	@FXML private TableColumn<Survey_q, String> questionCol;
	@FXML private Label surveyName;
	@FXML private Label errorLabel;
	@FXML private Rectangle balk;
	@FXML private TextField searchBar;
	
	
	@FXML protected void toSearchSurvey (ActionEvent e) {
		
		Navigator.loadVista(Navigator.SearchSurveyView);
	}
	
	@FXML protected void toViewAnswer (ActionEvent e) {
			
		Survey_q sq = questionTable.getSelectionModel().getSelectedItem();
		
		if (sq != null) {
			QuestionResultController.sQuestions=sq;
			QuestionResultController.survey=survey;
			Navigator.loadVista(Navigator.QuestionResultView);		
		} else {
			errorLabel.setText("No question selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
			
	}
	@FXML protected void addQuestion (ActionEvent e) {
		
	
		AddQuestionSurveyController.survey=survey;
		Navigator.loadVista(Navigator.AddQuestionSurveyView);		
			
	}
	
	@FXML protected void editQuestion(ActionEvent e) {
			
		
		Survey_q sq = questionTable.getSelectionModel().getSelectedItem();
		
		if (sq != null) {
			EditQuestionSurveyController.sQuestions=sq;
			EditQuestionSurveyController.survey=survey;
			Navigator.loadVista(Navigator.EditQuestionSurveyView);
		} else {
			errorLabel.setText("No question selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
						
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		balk.setFill(Color.valueOf(Main.color));
		
		surveyName.setText("Questions - " + survey.getSurveyName());
		Survey_qDAO qsdao = new Survey_qDAO();
		
		if (qsdao.getBySurveyId(survey.getSurveyId()) != null) {
			
			//qsdao.getBySurveyId(survey.getSurveyId());
			ObservableList<Survey_q> qlist = FXCollections.observableArrayList(qsdao.getBySurveyId(survey.getSurveyId()));
			
			//questionTable.setItems(qlist);
			questionCol.setCellValueFactory(new PropertyValueFactory<Survey_q, String>("question"));
		
			// 1. Wrap the ObservableList in a FilteredList (initially display all data).
			FilteredList<Survey_q> filteredSurveyQs = new FilteredList<>(qlist, p -> true);
								
			// 2. Set the filter Predicate whenever the filter changes.
			searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredSurveyQs.setPredicate(survey_q -> {
						// If filter text is empty, display all persons.
						if (newValue == null || newValue.isEmpty()) {
								return true;
						}
											
						// Compare first name and last name of every employee with filter text.
						String lowerCaseFilter = newValue.toLowerCase();
											
						if (survey_q.getQuestion().toLowerCase().indexOf(lowerCaseFilter) != -1) {
								return true; // Filter matches training name.
						}
								
						return false; // Does not match.
					});
				});
								
				// 3. Wrap the FilteredList in a SortedList. 
				SortedList<Survey_q> sortedSurveyQs = new SortedList<>(filteredSurveyQs);
										
				// 4. Bind the SortedList comparator to the TableView comparator.
				// 	  Otherwise, sorting the TableView would have no effect.
				sortedSurveyQs.comparatorProperty().bind(questionTable.comparatorProperty());
										
				// 5. Add sorted (and filtered) data to the table.
				questionTable.setItems(sortedSurveyQs);
		}
	
	}
	 
	
}
