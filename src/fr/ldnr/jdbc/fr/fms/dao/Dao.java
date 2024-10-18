package fr.fms.dao;
import java.util.ArrayList;

public interface Dao<T> {

		//public Connection connection = BddConnection.getConnection();
		public void create(T obj);//ajout d'une nouvelle occurence en base
		public T read(int id);// renvoie un objet correspondant à l'id en base
		public boolean update(T obj);//met à jour l'objet en base, return true
		public boolean delete(int Id);//supprime un objet en et return true
		public ArrayList<T> readAll();//renvoie tous les objets de la table correspondante	
		
}
