package com.capgemini.go.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
	
	
	public Address() {
		super();
		
	}
	private static final long serialVersionUID = 1L;
	public int getHouseNumber() {
		return houseNumber;
	}
	
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	public int getBuildingNumber() {
		return buildingNumber;
	}
	
	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getLandmark() {
		return landmark;
	}
	
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Column(name="houseNO")
	private int houseNumber;
	@Column(name="buildingNO")
	private int buildingNumber;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="field")
	private String landmark;
	@Column(name="zip")
	private String zip;
}
