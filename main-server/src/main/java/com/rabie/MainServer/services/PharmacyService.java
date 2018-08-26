package com.rabie.MainServer.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rabie.MainServer.models.Pharmacy;

public class PharmacyService {
	public Connection getConnection (){
		Connection con = null;
	      
	      try {
	         //Registering the HSQLDB JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");
	         //Creating the connection with HSQLDB
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinepharmacyservice","root","");	      
	      }  catch (Exception e) {
	         e.printStackTrace(System.out);
	      }
	      return con;
	      	
	}
	public List<String> getPharmaciesURLS (){
		List<String> URLS = new ArrayList<String>();
		Connection conn = getConnection();
		PreparedStatement stmt;
		try {
		stmt = conn.prepareStatement("SELECT IP FROM PHARMACY");
		ResultSet rs = stmt.executeQuery();
        while (rs.next()){
       	 URLS.add(rs.getString(1) + ":8080/onlinepharmacyservice/webapi/drug/");
        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		try {
			conn.close();
		} catch (SQLException e) {
			
		}
		return URLS;
	}
	public Pharmacy getPharmacyInfo (String pharmacyID){
		Pharmacy pharmacy = null;
		Connection conn = getConnection();
		PreparedStatement stmt;
		try {
		stmt = conn.prepareStatement("SELECT * FROM PHARMACY WHERE PHARMACYID = ? ");
		stmt.setString(1, pharmacyID);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()){
       	 pharmacy = new Pharmacy();
       	 pharmacy.setId(pharmacyID);
       	 pharmacy.setUrl(rs.getString("IP")+"/onlinepharmacyservice/webapi/drug/");
       	 pharmacy.setPharmacyName(rs.getString("PHARMACYNAME"));
       	 pharmacy.setLongitude(rs.getString("LONGITUDE"));
       	 pharmacy.setLatitude(rs.getString("LATITUDE"));
       	 pharmacy.setLocation(rs.getString("LOCATION"));
        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return pharmacy;
		
	}
}
