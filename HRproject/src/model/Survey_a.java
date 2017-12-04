package model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Survey_a {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int answerId;
	
	@Column
	private int employeeId;
	@Column
	private int surveyId;
	@Column
	private int questionId;
	@Column
	private String answer;
	public Survey_a() {
		super();
	}
	public Survey_a(int employeeId, int surveyId, int questionId, String answer) {
		super();
		this.employeeId = employeeId;
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.answer = answer;
	}
	public Survey_a(int answerId, int employeeId, int surveyId, int questionId, String answer) {
		super();
		this.answerId = answerId;
		this.employeeId = employeeId;
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.answer = answer;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	@Override
	public String toString() {
		return "Survey_a [answerId=" + answerId + ", employeeId=" + employeeId + ", surveyId=" + surveyId
				+ ", questionId=" + questionId + ", answer=" + answer + "]";
	}
	
	
	
	
	
}
