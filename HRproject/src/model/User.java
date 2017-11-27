package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import sha256.Encryption;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int userId;
	
	@Column
	private String username;
	
	@Column 
	private String password;
	
	@Column
	private String function;
	
	@Column
	private int arch;
	
	@Column
	private byte[] imagefile;

	
	
	public User() {
		
	}
	
	public User(String username, String password, String function) {
		super();
		this.username = username;
		this.password = Encryption.sha256(password);
		this.function = function;
		this.arch = 0;
	}
	
	

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = Encryption.sha256(password);;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public int getArch() {
		return arch;
	}
	public void setArch(int arch) {
		this.arch = arch;
	}
	public byte[] getImagefile() {
		return imagefile;
	}
	public void setImagefile(byte[] imagefile) {
		this.imagefile = imagefile;
	}

	
	@Override 
	public String toString() {
		return "\n" + getUsername() + " " + getPassword() + " " + getFunction();
	}
	
}