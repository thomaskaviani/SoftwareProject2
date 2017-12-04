package model;




import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;





@Entity
public class Survey {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int surveyId;
	
	@Column
	private int trainingId;
	@Column
	private String surveyName;
	@Column
	private int isClosed;
	@Column
	private int arch;
	
	public Survey() {
		super();
	}
	public Survey( int trainingId, String surveyName ) {
		super();
		
		this.trainingId = trainingId;
		this.surveyName = surveyName;
		
	}
	
	
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getSurveyName() {
		return surveyName;
	}
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	public int getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
	}
	public int getArch() {
		return arch;
	}
	public void setArch(int arch) {
		this.arch = arch;
	}
	
	
	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", trainingId=" + trainingId + ", surveyName=" + surveyName
				+ ", isClosed=" + isClosed + ", arch=" + arch + "]";
	}

	
	
	
/*
 
 
	public Survey(ArrayList<String> questions,ArrayList<String> answers ) {

		this.questions = questions;

		this.answers = answers;

	}

	
	

	public Survey(ArrayList<String> questions) {
		super();
		this.questions = questions;
	}

	public Survey() {
		
	}



	public ArrayList<String> getQuestions() {

		return questions;

	}
	

	public ArrayList<Integer> getQuestionType() {
		return questionType;
	}




	public void setQuestionType(ArrayList<Integer> questionType) {
		this.questionType = questionType;
	}




	public void setQuestions(ArrayList<String> questions) {

		this.questions = questions;

	}

	public ArrayList<String> getAnswers() {

		return answers;

	}

	public void setAnswers(ArrayList<String> answers) {

		this.answers = answers;

	}

	public void addQuestion(String myquestion, int myquestionType)
	{
		this.questions.add(myquestion);
		this.questionType.add(myquestionType);
		
	}


	public String toStringQuestions() {



		return getQuestions() + "/n" + getQuestionType() +"/n";

}


	
	@Override

	public String toString() {



		return getQuestions() + "/n" + getAnswers()+"/n";

}


*/
}
	