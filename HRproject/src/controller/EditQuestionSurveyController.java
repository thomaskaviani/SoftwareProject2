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
import application.Main;
import application.Navigator;
import dao.Survey_qDAO;




public class EditQuestionSurveyController implements Initializable {
	public static Survey survey;
	public static Survey_q sQuestions;
		
	@FXML private TextArea question;
	@FXML private Rectangle balk;
	
	@FXML  private ComboBox<String> questionType; 	
	@FXML
	protected void saveEdit(ActionEvent e) {
		
		String myquestion = question.getText();
		int myquestionType=0;
		if(questionType.getValue()=="Open Question")
			myquestionType=1;
		else if(questionType.getValue()=="5-star rating")
			myquestionType=2;
		
		
			Survey_q surveyQ=new Survey_q(sQuestions.getQuestionId(),sQuestions.getSurveyId(),myquestionType, myquestion,sQuestions.getArch());
		
		Survey_qDAO sqdao = new Survey_qDAO();
		sqdao.update(surveyQ);
		SurveyDetailController.sQuestions=surveyQ;
		SurveyDetailController.survey=survey;
		Navigator.loadVista(Navigator.SurveyDetailView);		
		
		
	}
	@FXML
	protected void cancelEdit(ActionEvent e) {
		
		Navigator.loadVista(Navigator.SurveyDetailView);		
		
		
	}
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		
		String questiontype="";
		if(sQuestions.getTypeId()==1)
			questiontype="Open Question";
		else if(sQuestions.getTypeId()==2)
			questiontype="5-star rating";
		
			
		questionType.getItems().removeAll(questionType.getItems());
		questionType.getItems().addAll("Open Question", "5-star rating");
	    questionType.getSelectionModel().select(questiontype);
	    question.setText(sQuestions.getQuestion());

	}
}
