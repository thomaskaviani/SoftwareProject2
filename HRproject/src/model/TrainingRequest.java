package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import application.CacheData;

@Entity
public class TrainingRequest {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int requestId;
	
	@Column
	private int trainingId;
	@Column
	private String name;
	@Column
	private String goal;
	@Column
	private int approval;
	@Column
	private Date created_at;
	@Column
	private Date updated_at;
	@Column
	private int empId;
	@Column
	private int forManager;
	
	public TrainingRequest() {
		
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

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	//CHECK
	public String getEmpId() {
		return CacheData.employees.get(empId-1).getFullName();
	}
	
	public int getRealEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public int getForManager() {
		return forManager;
	}

	public void setForManager(int forManager) {
		this.forManager = forManager;
	}

	
	
	
	
	
}
