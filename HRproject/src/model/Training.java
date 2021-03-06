package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Training {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int trainingId;
	
	@Column
	private String name;
	@Column
	private String goal;
	@Column
	private int arch;
	
	private int participators = 0;	
	
	public Training() {
	}
	
	public Training(String name, String description) {
		this.name = name;
		this.goal = description;
	}
	
	
	
	public int getArch() {
		return arch;
	}


	public void setArch(int arch) {
		this.arch = arch;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String description) {
		this.goal = description;
	}
	
	@Override
	public String toString() {
		return getName();
	}

	public int getParticipators() {
		return participators;
	}

	public void setParticipators(int participators) {
		this.participators = participators;
	}
	
}
