package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Certificate {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int certificateId;
	
	@Column
	private int empId;
	@Column
	private int trainingId = -1;//moet niet persee een trainingId hebben (kan ook een externe training geweest zijn)
	@Column
	private String file;
	@Column
	private int arch = 0;
	
	public Certificate() {};
	
	//alle params
	public Certificate(int certificateId, int empId, int trainingId, String file, int arch) {
		super();
		this.certificateId = certificateId;
		this.empId = empId;
		this.trainingId = trainingId;
		this.file = file;
		this.arch = arch;
	}

	//zonder arch
	public Certificate(int certificateId, int empId, int trainingId, String file) {
		super();
		this.certificateId = certificateId;
		this.empId = empId;
		this.trainingId = trainingId;
		this.file = file;
		this.arch = 0;
	}
	//zonder training, zonder arch
	public Certificate(int certificateId, int empId, String file) {
		super();
		this.certificateId = certificateId;
		this.empId = empId;
		this.file = file;
		this.trainingId = -1;
		this.arch = 0;
	}
	

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getArch() {
		return arch;
	}

	public void setArch(int arch) {
		this.arch = arch;
	}

	@Override
	public String toString() {
		return "Certificate id: "+ getCertificateId() + '\n' + "Emp id: " + getEmpId() + '\n' +"Training id: "+ getTrainingId() + '\n'+"File:" + getFile() + '\n'+ "Arch: " + getArch();
	}
	
}
