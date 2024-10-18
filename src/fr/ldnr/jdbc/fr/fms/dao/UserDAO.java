package fr.fms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.dao.BddConnection;
import fr.fms.entities.Articles;
import fr.fms.entities.Users;
	
	
	public  class UserDAO implements Dao<Users>{
		
		static Connection connection; 
		static BddConnection bddConnection;
		
		private ArrayList<Users> listUsers; 
		//private Connection connection; 
		// private BddConnection bddConnection;
		
		
		public UserDAO(){
			listUsers = new ArrayList<Users>();
			
		}
		@Override
		public void create(Users obj) {
			// on appelle la fonction static Connect de la class BddConnection
			connection =  (Connection) BddConnection.Connect();
			
			String str = "INSERT INTO t_users(login, password) VALUES(?, ?);";
			try(PreparedStatement preparedStatement = connection.prepareStatement(str)){
				preparedStatement.setString(1, obj.getLogin());
				preparedStatement.setString(2, obj.getPassword());
				
				if(preparedStatement.executeUpdate() == 1) {
				System.out.println("Users recorded");
					}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		@Override
		public Users read(int IdUser) {
			// on appelle la fonciton static Connect de la class BddConnection
			connection = (Connection) BddConnection.Connect();
				try {
					//on prepare la requete avec l'id comme condition car nous recherchons par Id
					PreparedStatement preparedSatatement = connection.prepareStatement("SELECT * FROM t_users WHERE IdUser = ? ");
					preparedSatatement.setInt(1, IdUser);
					
					//on execute la requete
					ResultSet result = preparedSatatement.executeQuery();
					
					//Pas de boucle si nous recherchon par Id
					if(result.next()) {
						return new Users(
								result.getString("login"),
								result.getString("password"));						
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return null;
		}
		@Override
		public boolean update(Users obj) {
			// on appelle la fonciton static Connect de la class BddConnection
			connection = (Connection) BddConnection.Connect();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE t_users SET login = ?, password = ?, WHERE login = ? ");
				preparedStatement.setString(1, obj.getLogin());
				preparedStatement.setString(2, obj.getPassword());
				preparedStatement.setInt(3, obj.getIdUser());
				
				//on return true si l'update a été effectué
				return preparedStatement.executeUpdate() == 1;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			//sinon on return false
			return false;
		}
		@Override
		public boolean delete(int IdUser) {
			// on appelle la focniton static Connect de la class BddConnection
			connection =  (Connection) BddConnection.Connect();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM t_users WHERE idUser = ?");
				preparedStatement.setInt(1, IdUser);
				// return true si return 1
				return preparedStatement.executeUpdate() == 1;
				 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
		@Override
		public ArrayList<Users> readAll(){
			// on appelle la focniton static Connect de la class BddConnection
			connection =  (Connection) BddConnection.Connect();
			try {
				//on prepare la requete
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM T_users");
				//on execute la requete avec ResultSet
				ResultSet result = preparedStatement.executeQuery();
				//on parcour les resultats avec une boucle while
				while(result.next()) {
					//on recupere get les donnes des propriété
					Users user = new Users(
							result.getInt("IdUser"),
							result.getString("login"),
							result.getString("password"));
							
					//on ajoute les données a la liste
					listUsers.add(user);
							
				}
				//on return la liste des articles
				return listUsers; 
				
				
			}catch(SQLException e ) {
				e.printStackTrace();
			}
			return null; 
		}
	
	}
