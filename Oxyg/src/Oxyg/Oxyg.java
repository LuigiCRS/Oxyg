package Oxyg;

import DAO.*;

public class Oxyg {
	public static void main(String[] args) {
		DBManager db = DBManager.getInstance();
		db.openConnection();
		String password = "1234";
		PharmacistDAO.writePharmacist(db, "Luigi", "Crisci", "luigi.crisci", password);
		
		db.closeConnection();
	}
}
