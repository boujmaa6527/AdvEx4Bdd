package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddConnection {
	
	   static Connection Connect(){
		try {
		
				Class.forName("org.mariadb.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		try {
			
			String url = "jdbc:mariadb://localhost:3306/Shop";
			String user = "root";
			String pwd = "fms2024";
			
			Connection connection = DriverManager.getConnection(url, user, pwd);
			return connection; 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}

}
