package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int addressId;
	
	@Column
	private String street;
	@Column
	private String number;
	@Column
	private String bus;
	@Column
	private String postalCode;
	@Column
	private String place;
	@Column
	private String country;
	
	@Column
	private int arch;
	
	public Address () {
		
	}
	
	public Address(String street, String number, String bus, String zipcode, String city, String country) {
		super();
		this.street = street;
		this.number = number;
		this.bus = bus;
		this.postalCode = zipcode;
		this.place = city;
		this.country = country;
		this.arch = 0;
	}
	
	//zonder bus
	public Address(String street, String number, String zipcode, String city, String country) {
		super();
		this.street = street;
		this.number = number;
		this.bus = null;
		this.postalCode = zipcode;
		this.place = city;
		this.country = country;
		this.arch = 0;
		//this.bus = ""; --> bus wordt hierboven al op null gezet!
	}
	
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalcode) {
		this.postalCode = postalcode;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String city) {
		this.place = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getArch() {
		return arch;
	}
	public void setArch(int arch) {
		this.arch = arch;
	}
	
	@Override
	public String toString() {
		return getStreet() + " " + getNumber() + " " + getBus() + " - " + getPostalCode() + " " + getPlace() + " - " + getCountry();
	}
	
	
}
