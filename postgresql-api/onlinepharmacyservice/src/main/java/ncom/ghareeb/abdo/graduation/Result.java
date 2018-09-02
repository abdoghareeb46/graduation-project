package ncom.ghareeb.abdo.graduation;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
	private String pharmacyID ;
	private ArrayList<Drug> foundedDrugs;
	
	public Result(ArrayList<Drug> foundedDrugs) {
		pharmacyID = Configuration.PHARAMACY_ID;
        this.foundedDrugs = foundedDrugs;
    }
	
	public String getPharmacyID() {
		return pharmacyID;
	}
	public void setPharmacyID(String pharmacyID) {
		this.pharmacyID = pharmacyID;
	}
	public ArrayList<Drug> getFoundedDrugs() {
		return foundedDrugs;
	}
	public void setFoundedDrugs(ArrayList<Drug> foundedDrugs) {
		this.foundedDrugs = foundedDrugs;
	}
	
	

}
