package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	public Sessions() {
		
	}
	
	public Sessions( int sessionId, int trainingId, int addressId, int teacherId, Date startTime, Date endTime, int cancelled, int arch) {
		this.sessionId = sessionId;
		this.trainingId = trainingId;
		this.addressId = addressId;
		this.teacherId = teacherId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cancelled = cancelled;
		this.arch = arch;
		
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
	
	
	@Override
	public String toString() {
		return "ID: " + getSessionId() + "   StartTime: " + getStartTime();
	}
	
	

}
