package com.rabie.MainServer.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugService {

	public Connection getConnection (){
		Connection con = null;
	      
	      try {
	         //Registering the MYSQL JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");
	         //Creating the connection with MYSQL
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinepharmacyservice","root","");	      
	      }  catch (Exception e) {
	         e.printStackTrace(System.out);
	      }
	      return con;
	      	
	}
	public List<String> getDrugListDB(){
		ArrayList<String> drugsList = new ArrayList<String>();
		Connection conn = getConnection();
		PreparedStatement stmt;
		try {
		stmt = conn.prepareStatement("SELECT DRUG_NAME FROM DRUGS");
		ResultSet rs = stmt.executeQuery();	
        while (rs.next()){
       	 drugsList.add(rs.getString(1));
       	 
        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return drugsList;
	}
	public boolean isDrugAvailable(String drugName){
		Connection conn = getConnection();
		boolean founded = false;
		PreparedStatement stmt;
		try {
		stmt = conn.prepareStatement("SELECT drug_name FROM DRUGS WHERE UPPER(drug_name) LIKE UPPER(?)");
		stmt.setString(1, drugName.toUpperCase()+"%");
		ResultSet rs = stmt.executeQuery();
        if (rs.next()){
       	 founded = true;
       	 
        }
        else founded = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return founded;
	}

	public List<String> getSoundexList (String word){
		ArrayList<String> drugsList = new ArrayList<String>();
		Connection conn = getConnection();
		PreparedStatement stmt;
		try {
		stmt = conn.prepareStatement("SELECT UPPER(drug_name) FROM DRUGS");
		ResultSet rs = stmt.executeQuery();
		int i = 0;
        while (rs.next()){
       	 if (Soundex.soundex(word).equals(Soundex.soundex(rs.getString(1).toUpperCase()))){
       		 drugsList.add(rs.getString(1));
       		 i++;
       	 }
       	 if (i == 10) break;
        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return drugsList;
		
	}

}
