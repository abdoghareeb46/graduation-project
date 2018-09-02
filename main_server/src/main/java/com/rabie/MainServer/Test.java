package com.rabie.MainServer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rabie.MainServer.models.Pharmacy;
import com.rabie.MainServer.services.PharmacyService;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Test {
	public static void main (String args[]){
		
	try {
		FileReader reader = new FileReader("E:\\grad.json");
		JSONParser parser = new JSONParser();
		JSONObject result = (JSONObject)parser.parse(reader);
		String pharmacyId = (String)result.get("pharmacyID");
		System.out.println("pharmacy id is " + pharmacyId);
		PharmacyService pharmacyService = new PharmacyService();
		Pharmacy pharmacy = pharmacyService.getPharmacyInfo(pharmacyId);
		System.out.println("pharmacy name : " + pharmacy.getPharmacyName());
		System.out.println("pharmacy location : " + pharmacy.getLocation());
		JSONArray foundedDrugs = (JSONArray) result.get("foundedDrugs");
		Iterator i = foundedDrugs.iterator();
		System.out.println("Founded drugs :");
		while(i.hasNext()){
			JSONObject drug = (JSONObject)i.next();
			String drugName = (String)drug.get("drugName");
			String drugPrice = (String)drug.get("drugPrice");
			long drugQuantity = (long)drug.get("drugQuantity");
			System.out.println("name : " + drugName);
			System.out.println("price : " + drugPrice);
			System.out.println("quantity : " + drugQuantity);
		}
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
