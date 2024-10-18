package fr.fms.entities;

public class Users {
	
	private int idUser;
	private String login;
	private String password;
	
	public Users(int idUser, String login, String password) {
		this.idUser = idUser;
		this.login = login;
		this.password = password;
	} 
	public Users(String login, String password) {
		this.login = login;
		this.password = password;
	} 
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String toString() {
		
		return "Id:" + getIdUser() +" Login: " + getLogin() + " PassWord: " + getPassword();
	}
	
}
