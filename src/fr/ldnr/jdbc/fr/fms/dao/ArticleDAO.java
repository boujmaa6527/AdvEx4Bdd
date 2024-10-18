package fr.fms.dao;
//on importe l'entité Article dans le package "entity"
import fr.fms.entities.Articles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Articles;

public  class ArticleDAO implements Dao<Articles> {
	
		private ArrayList<Articles> listArticles; 
		private Connection connection; 
		private BddConnection bddConnection; 
		
		//contructeur pour la connexion a notre BDD le chemin, login et pwd
		public ArticleDAO(){
			listArticles = new ArrayList<Articles>();
			
		}
		
	//enregiste une occurence dans la bdd
	@Override
	public void create(Articles obj) {
		// on appelle la fonciton static Connect de la class BddConnection
		//connection =  (Connection) BddConnection.Connect();
		
		try(Statement statement = connection.createStatement()){
			String str = "INSERT INTO t_articles (Description, Brand, UnitaryPrice, Idcategory)"
					+ "VALUES ('" + obj.getDescription() +"' ,'"+ obj.getBrand() +"' , "+ obj.getPrice()+" , "+ obj.getIdCategory()+");";
			int row = statement.executeUpdate(str);
			if(row == 1) 	System.out.println("Insertion ok");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// return un objet article grace a son id 
	@Override
	public Articles read(int IdArticle) {
		// on appelle la fonciton static Connect de la class BddConnection
		connection =  (Connection) BddConnection.Connect();
			try {
				//on prepare la requete avec l'id comme condition car nous recherchons par Id
				PreparedStatement preparedSatatement = connection.prepareStatement("SELECT * FROM t_Articles WHERE IdArticle = ? ");
				preparedSatatement.setInt(1, IdArticle);
				
				//on execute la requete
				ResultSet result = preparedSatatement.executeQuery();
				
				//Pas de boucle si nous recherchon par Id
				if(result.next()) {
					return new Articles(
							result.getInt("idArticle"),
							result.getString("description"),
							result.getString("brand"),
							result.getDouble("unitaryPrice"),
							result.getInt("idCategory"));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	//mise à jour de l'objet articles grace a son id
	@Override
	public boolean update(Articles obj) {
		// on appelle la fonciton static Connect de la class BddConnection
		connection =  (Connection) BddConnection.Connect();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE t_articles SET description = ?, Brand = ?, UnitaryPrice = ? WHERE description = ? ");
			preparedStatement.setString(1, obj.getDescription());
			preparedStatement.setString(2, obj.getBrand());
			preparedStatement.setDouble(3, obj.getPrice());
			preparedStatement.setInt(3, obj.getIdArticle());
			
			//on return true si l'update a été effectué
			return preparedStatement.executeUpdate() == 1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//sinon on return false
		return false;
	}
	@Override
	public boolean delete(int IdArticle) {
		// on appelle la fonciton static Connect de la class BddConnection
		connection =  (Connection) BddConnection.Connect();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM t_articles WHERE idArticle = ?");
			preparedStatement.setInt(1, IdArticle);
			// return true si return 1
			return preparedStatement.executeUpdate() == 1;
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; 
	}
	// on obtient la liste des articles
	@Override
	public ArrayList<Articles> readAll(){
		// on appelle la fonciton static Connect de la class BddConnection
		connection =  (Connection) BddConnection.Connect();
		try {
			//on prepare la requete
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM T_articles");
			//on execute la requete avec ResultSet
			ResultSet result = preparedStatement.executeQuery();
			//on parcour les resultats avec une boucle while
			while(result.next()) {
				//on recupere get les donnes des propriété
				Articles article = new Articles(
						result.getInt("Idarticle"),
						result.getString("description"),
						result.getString("brand"),
						result.getDouble("unitaryPrice"),
						result.getInt("idCategory"));
				//on ajoute les données a la liste
				listArticles.add(article);
						
			}
			//on return la liste des articles
			return listArticles; 
			
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return null; 
	}




	

}
