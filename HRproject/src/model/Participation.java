package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Participation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int participationId;
	
	@Column
	private int trainingId;
	@Column
	private String empId;
	@Column
	private int isChecked;
	@Column
	private int cancelled;
	@Column
	private int arch;
	@Column
	private int sessionId;
	
	
	public Participation() {
		
	}
	
	public Participation(int trainingId, String empId, int isChecked, int cancelled, int sessionId) {
		
		this.trainingId = trainingId;
		this.sessionId = sessionId;
		this.empId = empId;
		this.isChecked = 0;
		this.cancelled = 0;
		this.arch = 0;	
	}

	public int getParticipationId() {
		return participationId;
	}

	public void setParticipationId(int participationId) {
		this.participationId = participationId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}

	public int getCancelled() {
		return cancelled;
	}

	public void setCancelled(int cancelled) {
		this.cancelled = cancelled;
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
	
	
	@Override
	public String toString() {
		return "TrainingId: " + getTrainingId() + "- EmpId: " + getEmpId() + " - SessionId: " + getSessionId() + "\n";
	}
	
	
}
