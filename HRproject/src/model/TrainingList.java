package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingList {

	List<Training> trainingList = new ArrayList<Training>();

	public TrainingList(List<Training> trainingList) {
		super();
		this.trainingList = trainingList;
	}

	public List<Training> getTrainingList() {
		return trainingList;
	}

	public void setTrainingList(List<Training> trainingList) {
		this.trainingList = trainingList;
	}
	
	public void addTraining(Training training)
	{
		this.trainingList.add(training);
		
	}
	

}
