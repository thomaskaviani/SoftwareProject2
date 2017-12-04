package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Survey;
import model.Survey_q;
import model.Training;
import application.Main;
import application.Navigator;
import dao.Survey_qDAO;



public class AddQuestionSurveyController implements Initializable{
	
	public static Survey survey;
	public static Training training;
	
	@FXML private Rectangle balk;
	
	@FXML private TextArea question;
	
	@FXML  private ComboBox<String> questionType; 	
	
	
	@FXML
	protected void nextQuestion(ActionEvent e) {
		
		String myquestion = question.getText();
		int myquestionType=0;
		if(questionType.getValue()=="Open Question")
			myquestionType=1;
		else if(questionType.getValue()=="5-star rating")
			myquestionType=2;
		
		
		//nieuwe vraag 
		Survey_q surveyQ = new Survey_q(survey.getSurveyId(),myquestionType, myquestion);
		//inserten in db
		Survey_qDAO sqdao = new Survey_qDAO();
		sqdao.insert(surveyQ);
		
		
		/*
		 AddQuestionSurveyController.training = training;  
		 AddQuestionSurveyController.survey = survey;
		 
		 */
			
		 Navigator.loadVista(Navigator.AddQuestionSurveyView);		
		 
	}
	
	//endSurvey(save)
	@FXML
	protected void endSurvey(ActionEvent e) {
		
		String myquestion = question.getText();
		int myquestionType=0;
		if(questionType.getValue()=="Open Question")
			myquestionType=1;
		else if(questionType.getValue()=="5-star rating")
			myquestionType=2;
		
		
		 if(question.getText().trim().equals(""))
		 {
			 
		 }
		 else
		 {
			Survey_q surveyQ=new Survey_q(survey.getSurveyId(),myquestionType, myquestion);
				
			Survey_qDAO sqdao = new Survey_qDAO();
			sqdao.insert(surveyQ);
		 }
		SurveyDetailController.survey=survey;
		Navigator.loadVista(Navigator.SurveyDetailView);	
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		
		questionType.getItems().removeAll(questionType.getItems());
		questionType.getItems().addAll("Open Question", "5-star rating");
	    questionType.getSelectionModel().select("Open Question");

	}

}
