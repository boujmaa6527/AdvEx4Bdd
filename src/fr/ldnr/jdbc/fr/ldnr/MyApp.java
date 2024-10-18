package fr.ldnr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.dao.ArticleDAO;
import fr.fms.dao.UserDAO;
import fr.fms.entities.Articles;
import fr.fms.entities.Users;

public class MyApp {

	
	public static void main(String[] args) throws Exception {
		
		
			
		
		ArrayList<Articles> ListArticles = new ArrayList<Articles>();
		ArticleDAO articleDao = new ArticleDAO();
		//creation d'un article
    	Articles newArticle = new Articles("tapis-souris", "valéo", 10, 1);
//		//articleDao.create(newArticle);
//		
//		
////		ListArticles = articleDao.readAll();
////		for(Articles a:ListArticles) {
////			System.out.println(a);
////		}
//		
		ArrayList<Users> ListUsers = new ArrayList<Users>();
		UserDAO userDao = new UserDAO();
//		
//		Users newUser = new Users("papin", "pass4");
//		//System.out.println(newUser);
//		//userDao.create(newUser);
////		Users u = userDao.read(2);
////		System.out.println(u);
//		
//		//Exercice 10
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre Login :");
		String loginUser = sc.nextLine();
		System.out.println("Entrez votre password: ");
		String passWordUser = sc.nextLine();
		boolean isUserValid = false;
		ListUsers = userDao.readAll();
		for(Users u: ListUsers) {
			
			if(u.getLogin().equalsIgnoreCase(loginUser) && u.getPassword().equalsIgnoreCase(passWordUser)) {
				ListArticles = articleDao.readAll();
				System.out.println("Access autorisé!");
				System.out.println("Listes des articles: ");
				for(Articles a:ListArticles) {
					System.out.println(a);
				}
					isUserValid = true; 
				
				}
				
			}
			
		
		if(!isUserValid) {
			System.out.println("Access refusé, Veuillez vous connecter!");
		}
		
		sc.close();	
	}
}
