package fr.fms.entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Articles {

	private int idArticle;
	private String description;
	private String brand;
	private double price;
	private int IdCategory; 
	
	public Articles(int idArticle, String description, String brand, double price) {
		super();
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.price = price;
	} 
	public Articles( String description, String brand, double price) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
	} 
	public Articles(int idArticle,String description, String brand, double price, int idCategory) {
		super();
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.IdCategory = idCategory; 
	} 
	public Articles(String description, String brand, double price, int idCategory) {
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.IdCategory = idCategory;
	} 
	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		
		return "Id:"+ getIdArticle()+ " Description: "+ getDescription() + " Brand: "+ getBrand()+ " Price "+getPrice()+" Category: "+getIdCategory();
	}
	public int getIdCategory() {
		return IdCategory;
	}
	public void setIdCategory(int idCategory) {
		this.IdCategory = idCategory;
	}
	
}
