package org.mohamed.pha.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mohamed.pha.medicine.productaccess;
import org.mohamed.pha.model.pharmacy;
import org.mohamed.pha.model.product;

@Path("/drug")
public class ProductService {
	productaccess Productaccess = new productaccess();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public pharmacy getproducts() {
		pharmacy ph = new pharmacy();
		List<product> proo = Productaccess.getProductDetails();
		ph.setPharmacyID("1002");
		ph.setFoundedDrugs(proo);
		return ph;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{drugName}")
	public pharmacy getproductsByDrugName(@PathParam("drugName") String param1) {
		String s = param1;
		String name = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '*') {
				name += "[*]";
			} else {
				name += c;
			}
		}
		pharmacy ph = new pharmacy();
		List<product> proo = Productaccess.getProductDetailsByDrugName(name);
		ph.setPharmacyID("10002");
		ph.setFoundedDrugs(proo);
		return ph;

	}
}



