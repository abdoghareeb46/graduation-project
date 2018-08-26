package com.rabie.MainServer.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Drug {
	private String drugName;
	private String drugPrice;
	private String drugQuantity;

	//No args-constructor
	public Drug() {
		
	}
	
	//Costructor with arguments
	public Drug(String drugName, String drugPrice, String drugQuantity) {
		super();
		this.drugName = drugName;
		this.drugPrice = drugPrice;
		this.drugQuantity = drugQuantity;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(String drugPrice) {
		this.drugPrice = drugPrice;
	}

	public String getDrugQuantity() {
		return drugQuantity;
	}

	public void setDrugQuantity(String drugQuantity) {
		this.drugQuantity = drugQuantity;
	}
	
	

}
