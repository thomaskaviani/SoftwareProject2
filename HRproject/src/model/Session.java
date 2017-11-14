package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Session {

	
	private int sessionId;
	private int trainingId;
	private int addressId;
	private int teacherId;

	private Date startDate;
	private Date endDate;
	private boolean cancelled;
	
	@Transient
	private Address location;
	//private Teacher teacher;
	
	public Session(int sessionId, String teacher, Address location, Date startDate, Date endDate, boolean canceled) {
		super();
		this.sessionId = sessionId;
		//this.teacher = teacher;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cancelled = canceled;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	/*
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	*/
	public Address getLocation() {
		return location;
	}
	public void setLocation(Address location) {
		this.location = location;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public void cancelSession()
	{
		this.cancelled=true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
