package ncom.ghareeb.abdo.graduation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Drug {
    private String drugName;
    private int drugQuantity;
    private String drugPrice;

    public Drug(String drugName, int drugQuantity, String drugPrice) {
        this.drugName = drugName;
        this.drugQuantity = drugQuantity;
        this.drugPrice = drugPrice;
    }

    
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }
    

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public String getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(String drugPrice) {
        this.drugPrice = drugPrice;
    }
    
}
