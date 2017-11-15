package model;

import java.util.Date;

public class Employee {

	private String employeeId;
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
	
	private String photo;
	
	private String notes;
	
	private String email;
	
	//als dit "-1" is, heeft de mployee geen manager!
	private String reportso;
	
	private String photoPath;
	
	
	//private String email;
	
	//private ArrayList<Certificate> certificates;
	//private ArrayList<Training> trainingsFollowed;
	//private ArrayList<Training> trainingsRegistered;
	
	//CONSTRUCTOR id - firstname - lastname
	public Employee(String employeeId, String firstName, String lastName) {
		setEmployeeId(employeeId);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	//CONSTRUCTOR alle velden
	public Employee(String employeeId, String firstName, String lastName, String title, String titleOfCourtesy, Date birthDate, Date hireDate, String address, String city, String region, String postalCode, String country, String homePhone, String extension, String photo, String notes, String reportsto, String photoPath, String email) {
		
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
		
		setPhoto(photo);
		setPhotoPath(photoPath);
		
		setNotes(notes);
		
		setReportsTo(reportsto);
		
		setEmail(email);
		
		
	}
	
	
	public Employee() {
		
	}

	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getReportsTo() {
		return reportso;
	}

	public void setReportsTo(String reportso) {
		this.reportso = reportso;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String toString() {
		return "EmployeeID: "+ getEmployeeId()+'\n'+
		"Last Name : " + getLastName() +'\n'+
		"First Name : " +getFirstName()+'\n'+
		"Title : " + getTitle()+'\n'+
		"TitleOfCourtesy : "+getTitleOfCourtesy()+'\n'+
		"BirthDate : " + getBirthDate()+'\n'+
		"HireDate : " + getHireDate()+'\n'+
		"Address : " + getAddress()+'\n'+
		"City : " + getCity()+'\n'+
		"Region : " + getRegion()+'\n'+
		"PostalCode : " +getPostalCode()+'\n'+
		"Country : " + getCountry()+'\n'+
		"HomePhone : " + getHomePhone()+'\n'+
		"Extension : " + getExtension()+'\n'+
		"Photo : " + getPhoto()+'\n'+
		"Notes : " + getRegion()+'\n'+
		"ReportsTo : " + getReportsTo()+'\n'+
		"PhotoPath : " + getPhotoPath();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}
	
	
	
	
	
	
}
