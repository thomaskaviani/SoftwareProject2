package model;



import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Survey_q {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int questionId;
	
	@Column
	private int surveyId;
	@Column
	private int typeId;
	@Column
	private String question;
	@Column
	private int arch;
	
	
	
	public Survey_q(int questionId, int surveyId, int typeId, String question, int arch) {
		super();
		this.questionId = questionId;
		this.surveyId = surveyId;
		this.typeId = typeId;
		this.question = question;
		this.arch = arch;
	}
	public Survey_q(int surveyId, int typeId, String question) {
		super();
		this.surveyId = surveyId;
		this.typeId = typeId;
		this.question = question;
	}
	
	public Survey_q() {
		super();
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getArch() {
		return arch;
	}
	public void setArch(int arch) {
		this.arch = arch;
	}
	
	

	
}
