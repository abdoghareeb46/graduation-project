package com.rabie.MainServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rabie.MainServer.models.Drug;
import com.rabie.MainServer.models.Pharmacy;
import com.rabie.MainServer.models.PharmacyResult;
import com.rabie.MainServer.services.PharmacyService;

public class XConnection {

	public List<String> getResultFromPharmacies(String searchKey) {
		List<String> results = new ArrayList<String>();
		// get all URLs to be connected with
		PharmacyService pharmacyService = new PharmacyService();
		List<String> pharmaciesURLS = pharmacyService.getPharmaciesURLS();

		// SetUp a connection to all and get result using HTTP protocol.
		for (String url : pharmaciesURLS) {
			try {
				results.add(sendGetRequest("http://" + url + searchKey.replaceAll(" ", "%20")));
			} catch (Exception e) {
				System.out.println("this url (" + url + ") is not connected");
			}
		}
		return results;
	}

	public String sendGetRequest(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setConnectTimeout(1000);

		// Reading and Storing results
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}
	
	public List<PharmacyResult> parseResults (List<String> results){
		List<PharmacyResult> pharmacyResults = new ArrayList<PharmacyResult>();
		//JSON PARSING
		for (String pharmacyResult: results){
			JSONParser parser = new JSONParser();
			try {
				JSONObject result =(JSONObject)parser.parse(pharmacyResult);
				String pharmacyId = (String)result.get("pharmacyID");
				PharmacyService pharmacyService = new PharmacyService();
				PharmacyResult returned = new PharmacyResult();
				Pharmacy pharmacy = pharmacyService.getPharmacyInfo(pharmacyId);
				returned.setPharmacyName(pharmacy.getPharmacyName());
				returned.setPharmacyLocation(pharmacy.getLocation());
				returned.setPharmacyLongitude(pharmacy.getLongitude());
				returned.setPharmacyLatitude(pharmacy.getLatitude());
				ArrayList<Drug> drugs = new ArrayList<Drug>();
				JSONArray foundedDrugs = (JSONArray) result.get("foundedDrugs");
				returned.setNumberOfFoundedDrugs(foundedDrugs.size());
				Iterator i = foundedDrugs.iterator();
				while(i.hasNext()){
					JSONObject drug = (JSONObject)i.next();
					String drugName = (String)drug.get("drugName");
					String drugPrice = (String)drug.get("drugPrice");
					long drugQuantity = (long)drug.get("drugQuantity");
					System.out.println("drug :" + drugName + " " + drugPrice + " " + drugQuantity);
					drugs.add(new Drug(drugName, drugPrice, "" + drugQuantity));
				}
				returned.setFoundedDrugs(drugs);
				pharmacyResults.add(returned);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return pharmacyResults;
	}

	public static void main(String args[]) throws Exception {
		XConnection x = new XConnection();
		for (String r : x.getResultFromPharmacies("pana")) {
			System.out.println(r);
		}
		
	}

}
