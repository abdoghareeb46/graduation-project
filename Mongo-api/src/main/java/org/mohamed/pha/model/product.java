package org.mohamed.pha.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class product {

	private String drugName;
	private String drugPrice;
	private Integer drugQuantity;

	public product() {
	}

	public product(String drugName, String drugPrice, Integer drugQuantity) {
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

	public Integer getDrugQuantity() {
		return drugQuantity;
	}

	public void setDrugQuantity(Integer drugQuantity) {
		this.drugQuantity = drugQuantity;
	}

}
