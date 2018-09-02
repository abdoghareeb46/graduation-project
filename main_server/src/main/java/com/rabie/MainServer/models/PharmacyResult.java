package com.rabie.MainServer.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class PharmacyResult {
	private String pharmacyName;
	private String pharmacyLocation;
	private String pharmacyLongitude;
	private String pharmacyLatitude;
	private long numberOfFoundedDrugs;
	private ArrayList<Drug> foundedDrugs;
	
	public PharmacyResult() {
	}

	public PharmacyResult(String pharmacyName, String pharmacyLocation,
			String pharmacyLongitude, String pharmacyLatitude,int drugsNumber,
			ArrayList<Drug> foundedDrugs) {
		super();
		this.pharmacyName = pharmacyName;
		this.pharmacyLocation = pharmacyLocation;
		this.pharmacyLongitude = pharmacyLongitude;
		this.pharmacyLatitude = pharmacyLatitude;
		this.numberOfFoundedDrugs = drugsNumber;
		this.foundedDrugs = foundedDrugs;
	}

	public long getNumberOfFoundedDrugs() {
		return numberOfFoundedDrugs;
	}

	public void setNumberOfFoundedDrugs(long numberOfFoundedDrugs) {
		this.numberOfFoundedDrugs = numberOfFoundedDrugs;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getPharmacyLocation() {
		return pharmacyLocation;
	}

	public void setPharmacyLocation(String pharmacyLocation) {
		this.pharmacyLocation = pharmacyLocation;
	}

	public String getPharmacyLongitude() {
		return pharmacyLongitude;
	}

	public void setPharmacyLongitude(String pharmacyLongitude) {
		this.pharmacyLongitude = pharmacyLongitude;
	}

	public String getPharmacyLatitude() {
		return pharmacyLatitude;
	}

	public void setPharmacyLatitude(String pharmacyLatitude) {
		this.pharmacyLatitude = pharmacyLatitude;
	}

	public ArrayList<Drug> getFoundedDrugs() {
		return foundedDrugs;
	}

	public void setFoundedDrugs(ArrayList<Drug> foundedDrugs) {
		this.foundedDrugs = foundedDrugs;
	}
	
	
	
}
