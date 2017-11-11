package model;

public class Employee {

	//private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	//private int cellphone;
	//private Addres addres;
	
	//private ArrayList<Certificate> certificates;
	//private ArrayList<Training> trainingsFollowed;
	//private ArrayList<Training> trainingsRegistered;
	
	//tijdelijk
	public Employee(String firstName, String lastName, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
	}
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
