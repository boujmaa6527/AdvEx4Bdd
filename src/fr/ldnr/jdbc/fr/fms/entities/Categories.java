package fr.fms.entities;

public class Categories {

		private int idCategiries;
		private String catName;
		private String description;
		
		public Categories(int idCategiries, String catName, String description) {
			super();
			this.idCategiries = idCategiries;
			this.catName = catName;
			this.description = description;
		} 
		
		public int getIdCategiries() {
			return idCategiries;
		}

		public void setIdCategiries(int idCategiries) {
			this.idCategiries = idCategiries;
		}

		public String getCatName() {
			return catName;
		}

		public void setCatName(String catName) {
			this.catName = catName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		
}
