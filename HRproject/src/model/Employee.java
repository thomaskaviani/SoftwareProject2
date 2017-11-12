package model;

import java.util.Date;

public class Employee {

	private int employeeId;
	private String lastName;
	private String firstName;
	private String title;
	private String titleOfCourtesy;
	
	private Date birthDate;
	private Date hireDate;
	
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	
	private String homePhone;
	private String extension;
	
	private String notes;
	
	
	//private String email;
	
	//private ArrayList<Certificate> certificates;
	//private ArrayList<Training> trainingsFollowed;
	//private ArrayList<Training> trainingsRegistered;
	
	//CONSTRUCTOR id - firstname - lastname
	public Employee(int employeeId, String firstName, String lastName) {
		setEmployeeId(employeeId);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	//CONSTRUCTOR alle velden
	public Employee(int employeeId, String firstName, String lastName, String title, String titleOfCourtesy, Date birthDate, Date hireDate, String address, String city, String region, String postalCode, String country, String homePhone, String extension, String notes) {
		
		setEmployeeId(employeeId);
		setFirstName(firstName);
		setLastName(lastName);
		setTitle(title);
		setTitleOfCourtesy(titleOfCourtesy);
		
		setBirthDate(birthDate);
		setHireDate(hireDate);
		
		setAddress(address);
		setCity(city);
		setRegion(region);
		setPostalCode(postalCode);
		setCountry(country);
		
		setHomePhone(homePhone);
		setExtension(extension);
		
		setNotes(notes);
		
		
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}


	public void setTitleOfCourtesy(String titleOfCourtesy) {
		this.titleOfCourtesy = titleOfCourtesy;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getHomePhone() {
		return homePhone;
	}


	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}


	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	
	
	
	
	
	
}
