package ncom.ghareeb.abdo.graduation;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DatabaseConnection {

    private Connection conn = null;
    

    /*if statement*/
    /* Connection To database as a read only user*/
    public Connection getConnection() {
        String url = "jdbc:postgresql://"+ Configuration.URL + ":" + Configuration.PORT_NUMBER +"/" + 
        Configuration.DATABASE_NAME;
        try {
        	Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, Configuration.USER_NAME, Configuration.PASSWORD);
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return conn;
    }
    
    public ArrayList<Drug> selectByDrugName(String drug_name) throws SQLException {
        ArrayList<Drug> result = new ArrayList<Drug>();
        try {
        	
        	
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT "+
                    Configuration.COLUMN_DRUG_NAME+", " +
                    Configuration.COLUMN_DRUG_QUANTITY+ ", " +
                    Configuration.COLUMN_DRUG_PRICE +
                    " FROM " +
                    Configuration.TABLE_NAME +
                    " WHERE " +
                    Configuration.COLUMN_DRUG_NAME+" like CONCAT('%',?,'%')"+"AND " +Configuration.COLUMN_DRUG_QUANTITY +"!=0");
            st.setString(1, drug_name.toUpperCase());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Drug drug = new Drug(rs.getString(Configuration.COLUMN_DRUG_NAME),
                rs.getInt(Configuration.COLUMN_DRUG_QUANTITY),
                rs.getString(Configuration.COLUMN_DRUG_PRICE));
                result.add(drug);
            }
            rs.close();
            st.close();
          conn.close();
        } catch (SQLException ex) {
       }

        return result;

    }

}
