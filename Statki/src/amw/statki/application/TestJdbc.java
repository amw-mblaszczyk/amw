/**
 * Test application presents plain JDBC style database application.
 */
package amw.statki.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import amw.statki.model.Port;

/**
 * @author blaszczyk
 *
 */
public class TestJdbc {
	// JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	   //static final String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;DatabaseName=Statki"; 
	   static final String DB_URL = "jdbc:sqlserver://ORKAN\\Informatyka;DatabaseName=Statki";

	   //  Database credentials
	   static final String USER = "hibernate";
	   static final String PASS = "hibernate";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 1: Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      //STEP 2: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 3: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT id, nazwa, skrot, la, fi FROM Port";

	      System.out.println("Executing statement...");
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 4: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
		     int id  = rs.getInt("id");
	         String nazwa  = rs.getString("nazwa");
	         String skrot = rs.getString("skrot");
	         double fi = rs.getDouble("fi");
	         double la = rs.getDouble("la");

	         //STEP 5: Map values to Java POJO
	         Port port = new Port(nazwa, skrot, fi, la);
	         port.setId(id);
	         //Print retrived object
	         System.out.println(port);
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Done.");
	}//end main
}
