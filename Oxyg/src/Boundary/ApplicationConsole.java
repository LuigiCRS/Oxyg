package Boundary;

import java.io.IOException;

import DAO.DBManager;

public class ApplicationConsole {

	public static void start() throws IOException {
		DBManager db = DBManager.getInstance();
		db.openConnection();
		System.out.println("******     LOGIN     ******");
		Authentication.Login();
		System.out.println("Success.");
		PharmacistConsole.console();
		db.closeConnection();
	}
}
