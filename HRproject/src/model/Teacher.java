package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Teacher {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int teacherId;
	
	@Column
	private String teacherName;
	@Column
	private String email;
	@Column
	private String company;
	@Column
	private int arch;
	
	public Teacher() {
		
	}
	
	public Teacher(String teacherName, String email, String company) {
		this.teacherName = teacherName;
		this.email = email;
		this.company = company;
		this.arch = 0;
	}

	
	
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getArch() {
		return arch;
	}

	public void setArch(int arch) {
		this.arch = arch;
	}
	
	@Override
	public String toString() {
		return getTeacherName() + " - " + getCompany();
	}
	
}
