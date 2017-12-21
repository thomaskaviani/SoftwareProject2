package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Necessity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int necessityId;
	
	@Column
	private int trainingId;
	@Column
	private int bookId;
	@Column
	private int amount;
	@Column
	private int arch;
	
	public Necessity() {
		
	}
	
	public int getNecessityId() {
		return necessityId;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setNecessityId(int necessityId) {
		this.necessityId = necessityId;
	}


	public int getTrainingId() {
		return trainingId;
	}


	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public int getArch() {
		return arch;
	}
	public void setArch(int arch) {
		this.arch = arch;
	}
	public String toString() {
		return "tr"+trainingId +'\n'+
				"b"+bookId+'\n'+
				"am"+amount;
	}
	
}