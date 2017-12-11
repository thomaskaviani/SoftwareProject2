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
import application.Main;
import application.Navigator;

import dao.SurveyDAO;

public class SearchSurveyController implements Initializable{

	public static Survey survey;
	
	
	@FXML private TextField searchBar;
	@FXML private Rectangle balk;
	@FXML private Label errorLabel;
	
	@FXML
	private TableView<Survey> surveyTable;
	
	@FXML
	private TableColumn<Survey, String> surveyNameCol;
	@FXML
	private TableColumn<Survey, String> isClosedCol;
	
	@FXML
	protected void toSurveyDetail(ActionEvent e) {
		
		Survey s = surveyTable.getSelectionModel().getSelectedItem();
		
		if (s != null) {
			SurveyDetailController.survey=s;
			Navigator.loadVista(Navigator.SurveyDetailView);
		} else {
			errorLabel.setText("No survey selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
				
				
	}	
@FXML
	protected void toHome(ActionEvent e) {
	
	
	Navigator.loadVista(Navigator.HomeView);
			
	
}
	
	@FXML protected void closeSurvey(ActionEvent e) {

		
		Survey s = surveyTable.getSelectionModel().getSelectedItem();
		
		if ( s != null) {
			SurveyDAO sdao = new SurveyDAO();
			sdao.setClosed(s);
			Navigator.loadVista(Navigator.SearchSurveyView);
		} else {
			errorLabel.setText("No survey selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
		

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		errorLabel.setText("");
		balk.setFill(Color.valueOf(Main.color));
		
		SurveyDAO sdao = new SurveyDAO();
		
		if (sdao.getAll() != null) {
			
			ObservableList<Survey> surveys = FXCollections.observableArrayList(sdao.getAll());
			
			
			surveyNameCol.setCellValueFactory(new PropertyValueFactory<Survey, String>("surveyName"));
			isClosedCol.setCellValueFactory(new PropertyValueFactory<Survey, String>("isClosed"));
      
		
			
			// 1. Wrap the ObservableList in a FilteredList (initially display all data).
			FilteredList<Survey> filteredSurveys = new FilteredList<>(surveys, p -> true);
					
			// 2. Set the filter Predicate whenever the filter changes.
			searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredSurveys.setPredicate(survey -> {
					// If filter text is empty, display all persons.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
							
					// Compare first name and last name of every employee with filter text.
					String lowerCaseFilter = newValue.toLowerCase();
							
					if (survey.getSurveyName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches training name.
					}
					
					return false; // Does not match.
				});
			});
					
			// 3. Wrap the FilteredList in a SortedList. 
			SortedList<Survey> sortedSurveys = new SortedList<>(filteredSurveys);
							
			// 4. Bind the SortedList comparator to the TableView comparator.
			// 	  Otherwise, sorting the TableView would have no effect.
			sortedSurveys.comparatorProperty().bind(surveyTable.comparatorProperty());
							
			// 5. Add sorted (and filtered) data to the table.
			surveyTable.setItems(sortedSurveys);
      
		}
	}
}
