package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Sessions;
import model.Survey;
import model.Survey_q;
import model.Training;
import application.CacheData;
import application.Navigator;
import dao.SessionsDAO;
import dao.SurveyDAO;
import dao.Survey_qDAO;

public class SurveyDetailController implements Initializable {
public static Survey survey;
public static Survey_q sQuestions;
	
	@FXML
	private TableView<Survey_q> questionTable;
	
	@FXML
	private TableColumn<Survey_q, String> questionCol;
	@FXML private Label surveyName;
	@FXML
	protected void toSearchSurvey (ActionEvent e) {
		
		
			Navigator.loadVista(Navigator.SearchSurveyView);
		}
	
	@FXML
	protected void toViewAnswer (ActionEvent e) {
			
		
		Survey_q sq = questionTable.getSelectionModel().getSelectedItem();
		QuestionResultController.sQuestions=sq;
		QuestionResultController.survey=survey;
			Navigator.loadVista(Navigator.QuestionResultView);
					
			
		}
	@FXML
	protected void editQuestion(ActionEvent e) {
			
		
		Survey_q sq = questionTable.getSelectionModel().getSelectedItem();
		EditQuestionSurveyController.sQuestions=sq;
		EditQuestionSurveyController.survey=survey;
			Navigator.loadVista(Navigator.EditQuestionSurveyView);
					
			
		}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 // s=sdao.getByTraining(t.getTrainingId());
		  //getBySurveyId
		surveyName.setText(survey.getSurveyName());
		Survey_qDAO qsdao = new Survey_qDAO();
		
		if (qsdao.getBySurveyId(survey.getSurveyId()) != null) {
			
			//qsdao.getBySurveyId(survey.getSurveyId());
			ObservableList<Survey_q> qlist = FXCollections.observableArrayList(qsdao.getBySurveyId(survey.getSurveyId()));
			
			questionTable.setItems(qlist);
			questionCol.setCellValueFactory(new PropertyValueFactory<Survey_q, String>("question"));
		
		}
	
	}
	 
	
}
