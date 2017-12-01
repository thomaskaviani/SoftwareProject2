package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Sessions {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int sessionId;
	
	@Column
	private int trainingId;
	@Column
	private String sessionName;
	@Column
	private int addressId;
	@Column
	private int teacherId;
	@Column
	private Date startTime;
	@Column
	private Date endTime;
	@Column
	private int cancelled;
	@Column
	private int arch;
	
	@Transient
	private String startTimeString;
	
	public Sessions() {
		
	}
	
	public Sessions(int trainingId, String sessionName, int addressId, int teacherId, Date startTime, Date endTime) {
		
		this.trainingId = trainingId;
		this.sessionName = sessionName;
		this.addressId = addressId;
		this.teacherId = teacherId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cancelled = 0;
		this.arch = 0;
		
	}

	
	
	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		System.out.println("WOOOOOOO");
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	
	
	public void setStartTimeString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		startTimeString = df.format(getStartTime());
	}
	
	public String getStartTimeString() {
		return startTimeString;
	}
	
	@Override
	public String toString() {
		return "ID: " + getSessionId() + "   StartTime: " + getStartTime();
	}
	
	

}
