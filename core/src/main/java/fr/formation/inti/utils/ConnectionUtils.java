package fr.formation.inti.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {
	
	public static Connection getConnection() {
		Connection con = null;
			Properties props = new Properties();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("src/main/resources/jdbc.properties");
				props.load(fis);
				// create the connection now
				con = DriverManager.getConnection(
						props.getProperty("DB_URL"), 
						props.getProperty("DB_USERNAME"),
						props.getProperty("DB_PASSWORD"));

			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		
		return con;
	}
	
	public int executeQuery(String query) throws ClassNotFoundException, SQLException {
	    return getConnection().createStatement().executeUpdate(query);
	  }

}
