package org.mohamed.pha.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class pharmacy {
	
	
	
	private String pharmacyID;
	private List<product> foundedDrugs;
	public String getPharmacyID() {
		return pharmacyID;
	}
	public void setPharmacyID(String pharmacyID) {
		this.pharmacyID = pharmacyID;
	}
	public List<product> getFoundedDrugs() {
		return foundedDrugs;
	}
	public void setFoundedDrugs(List<product> foundedDrugs) {
		this.foundedDrugs = foundedDrugs;
	}
	
	
	
	
	

}
