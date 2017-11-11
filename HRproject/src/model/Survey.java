package model;



import java.util.ArrayList;

import javax.persistence.Column;

import javax.persistence.Entity;





@Entity
public class Survey {



	@Column
	private ArrayList<String> questions;

	@Column
	private ArrayList<String> answers;

	

	public Survey(ArrayList<String> questions,ArrayList<String> answers ) {

		this.questions = questions;

		this.answers = answers;

	}

	

	public ArrayList<String> getQuestions() {

		return questions;

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



	@Override

	public String toString() {



		return getQuestions() + "/n" + getAnswers()+"/n";

}



}