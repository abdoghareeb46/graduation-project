package com.rabie.MainServer;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rabie.MainServer.models.Drug;

/**
 * Root resource (exposed at "pharmacydrugs" path)
 */
@Path("pharmacydrugs")
public class PharmacyDrugs {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Drug getIt() {
        return new Drug("It's Name", "it's Price", "It's quantity");
    }
    @GET
    @Path("/{drugString}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getDrugList() {
    	List<String> drugList = new ArrayList<String>();
    	
        return drugList;
    }
}
