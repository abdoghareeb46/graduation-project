package org.mohamed.pha.medicine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoUtils {



	
	private static final String DATABASE_NAME="Med";
	private static final String COLLECTION_NAME="phh";
	private static MongoClient serverConnection = null;

	//TODO Thread Safety
	public static DBCollection getCollection() {
		if(serverConnection==null){
                    serverConnection = new MongoClient("localhost",27017);
		}		
		DB db = serverConnection.getDB(DATABASE_NAME);
		return db.getCollection(COLLECTION_NAME);
	

	
	
// Connection connection = null;
// String user = "root";
// String pass = ""; 
// String connectionURL ="jdbc:mysql://localhost:3306/medicine";
// String DBdriver="com.mysql.jdbc.Driver";
//
//try {
// Class.forName(DBdriver);
// connection = DriverManager.getConnection(connectionURL, user, pass);
// System.out.println(" data base is connected...");
//
//
//} catch ( ClassNotFoundException | SQLException e) {
//
// e.getLocalizedMessage();
// }
// return connection;
 }

}
