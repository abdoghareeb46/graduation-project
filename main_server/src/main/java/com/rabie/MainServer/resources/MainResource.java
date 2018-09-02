package com.rabie.MainServer.resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;









import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;









import javax.ws.rs.core.Response;

import com.rabie.MainServer.XConnection;
import com.rabie.MainServer.models.Drug;
import com.rabie.MainServer.models.PharmacyResult;
import com.rabie.MainServer.services.DrugService;
@Path("/main")
public class MainResource {
	@GET
	@Path("/suggestions")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSuggestions ()
	{
		DrugService drugService = new DrugService();
	    List<String> suggestions = drugService.getDrugListDB();
		String result = "";
		for (int i =0; i< suggestions.size();i++){
		if (i == suggestions.size()-1)
		result +=suggestions.get(i);
		else result += suggestions.get(i)+",";	
		}
		
	return result;	
	} 
	
	@GET
	@Path("/suggestions/website/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test() {
		DrugService drugService = new DrugService();
	    List<String> suggestions = drugService.getDrugListDB();
	    return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(suggestions)
	            .build();
	}
//	@GET
//	@Path("/drug/{drugName}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getDrug (@PathParam("drugName") String drugName){
//		String x = null;
//		try {
//			x = readFile("C:\\Users\\gerko\\Desktop\\Graduation Project\\pharmacyResult.json");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "[]";
//	}
//
	@GET
	@Path("/drug/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PharmacyResult> getDrug (@PathParam("drugName") String drugName){
		XConnection xConnection = new XConnection();
		List<PharmacyResult> result = xConnection.parseResults(xConnection.getResultFromPharmacies(drugName));
		for (PharmacyResult r : result){
			if (r.getNumberOfFoundedDrugs()>=20)
				return new ArrayList<PharmacyResult>();
		}
		return result;
	}
	
	@GET
	@Path("/drug/website/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(@PathParam("drugName")String drugName) {
		XConnection xConnection = new XConnection();
		List<PharmacyResult> result = xConnection.parseResults(xConnection.getResultFromPharmacies(drugName));
		for (PharmacyResult r : result){
			if (r.getNumberOfFoundedDrugs()>=20)
				return Response
			            .status(200)
			            .header("Access-Control-Allow-Origin", "*")
			            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
			            .header("Access-Control-Allow-Credentials", "true")
			            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			            .header("Access-Control-Max-Age", "1209600")
			            .entity(new ArrayList<PharmacyResult>())
			            .build();
		}
	    return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(result)
	            .build();
	}
	
	@GET
	@Path("/improvments/{word}")
	@Produces(MediaType.TEXT_PLAIN)
	public String useSoundex (@PathParam("word") String word)
	{
		DrugService drugService = new DrugService();
	    List<String> suggestions = drugService.getSoundexList(word);
		String result = "";
		for (int i =0; i< suggestions.size();i++){
		if (i == suggestions.size()-1)
		result +=suggestions.get(i);
		else result += suggestions.get(i)+",";	
		}	
		return result;	
	} 
	
	@GET
	@Path("/improvments/website/{word}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testSoundex(@PathParam("word") String word) {
		DrugService drugService = new DrugService();
	    List<String> suggestions = drugService.getSoundexList(word);
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(suggestions)
	            .build();
	}

//	@GET
//	@Path("/example")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getExample ()
//	{
//		String x = null;
//		try {
//			x = readFile("C:\\Users\\gerko\\Desktop\\Graduation Project\\pharmacyResult.json");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	return x;	
//	} 
//	public static String readFile(String file) throws IOException {
//	    BufferedReader reader = new BufferedReader(new FileReader (file));
//	    String         line = null;
//	    StringBuilder  stringBuilder = new StringBuilder();
//	    String         ls = System.getProperty("line.separator");
//	 
//	    try { 
//	        while((line = reader.readLine()) != null) {
//	            stringBuilder.append(line);
//	            stringBuilder.append(ls);
//	        } 
//	 
//	        return stringBuilder.toString();
//	    } finally { 
//	        reader.close();
//	    } 
//	} 
}
