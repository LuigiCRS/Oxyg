package Oxyg;

import DAO.*;

public class Oxyg {
	public static void main(String[] args) {
		DBManager db = DBManager.getInstance();
		db.openConnection();
		db.closeConnection();
	}
}
