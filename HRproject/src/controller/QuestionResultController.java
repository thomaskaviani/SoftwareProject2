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
import model.Survey_a;
import model.Training;
import application.CacheData;
import application.Navigator;
import dao.SessionsDAO;
import dao.SurveyDAO;
import dao.Survey_aDAO;
import dao.Survey_qDAO;

public class QuestionResultController implements Initializable  {
	
	public static Survey survey;
	public static Survey_q sQuestions;
	
	@FXML
	private TableView<Survey_a> answerTable;
	
	@FXML
	private TableColumn<Survey_a, String> answerCol;
	@FXML
	private TableColumn<Survey_a, Integer> employeeCol;
	
	@FXML private Label questionLabel;
	@FXML private Label questionTypeLabel;
	@FXML
	protected void toQuestions (ActionEvent e) {
			Navigator.loadVista(Navigator.SurveyDetailView);
		}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		questionLabel.setText(sQuestions.getQuestion());
		
		String qType="";
		if(sQuestions.getTypeId()==1)
			qType="Open Question";
		else if(sQuestions.getTypeId()==2)
			qType="5-star rating";
		questionTypeLabel.setText(qType);
		 // s=sdao.getByTraining(t.getTrainingId());
		  //getBySurveyId
//System.out.println(sQuestions.getQuestionId());
		Survey_aDAO asdao = new Survey_aDAO();
		
		if (asdao.getByQuestionId(sQuestions.getQuestionId()) != null) {
			
			//qsdao.getBySurveyId(survey.getSurveyId());
			ObservableList<Survey_a> alist = FXCollections.observableArrayList(asdao.getByQuestionId(sQuestions.getQuestionId()));
			
			answerTable.setItems(alist);
			answerCol.setCellValueFactory(new PropertyValueFactory<Survey_a, String>("answer"));
			employeeCol.setCellValueFactory(new PropertyValueFactory<Survey_a, Integer>("employeeId"));
		
		}
	
	}
	 

}
