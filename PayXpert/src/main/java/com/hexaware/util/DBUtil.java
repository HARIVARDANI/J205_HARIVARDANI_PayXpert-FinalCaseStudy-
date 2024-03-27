package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Utility class for managing database connections.
 */

public class DBUtil {
	
	static Connection  con;
	
/**
  * Retrieves a database connection.
  *
  * @return the database connection
  */
	
	public static Connection getDBConn() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PayXpert", "root", "Harivardani@06");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
/**
  * Main method to test the database connection.
  *
  * @param args the command-line arguments
  */
	
	public static void main(String[] args) {
		System.out.println(getDBConn());
	}

}
