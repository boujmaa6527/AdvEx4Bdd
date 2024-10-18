package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddConnection {
	   
	// on créee la connexion avec un variable d'instance
	   private static Connection connection = null;
	
	   public static Connection Connect(){
		   
		   if(connection == null) {
			   
					try {
							
							Class.forName("org.mariadb.jdbc.Driver");
						}catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					
					try {
						
						String url = "jdbc:mariadb://localhost:3306/Shop";
						String user = "root";
						String pwd = "fms2024";
						
						connection = DriverManager.getConnection(url, user, pwd);
						//System.out.println("Connection effectué");
						return connection; 
						
					}catch (SQLException e) {
						e.printStackTrace();
					}
			
		   }
		   return connection; 
		   
		
	}

}
