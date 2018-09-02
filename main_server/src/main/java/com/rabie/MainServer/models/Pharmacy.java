package com.rabie.MainServer.models;

public class Pharmacy {
	private String id;
	private String url;
	private String pharmacyName;
	private String longitude;
	private String latitude;
	private String location;
	public Pharmacy(String id, String url, String pharmacyName,
			String longitude, String latitude, String location) {
		this.id = id;
		this.url = url;
		this.pharmacyName = pharmacyName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.location = location;
	}
	public Pharmacy() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
