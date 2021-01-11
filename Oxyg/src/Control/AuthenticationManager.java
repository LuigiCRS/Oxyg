package Control;

import DAO.DBManager;
import DAO.PharmacistDAO;
import Entity.Pharmacist;

public class AuthenticationManager {
	
	public static void openConnection() {
		DBManager db = DBManager.getInstance();
		db.openConnection();
	}

	public static boolean isAuthenticated() {
		return state;
	}

	public static void Authentication(String username, String password) {
		DBManager db = DBManager.getInstance();
		Pharmacist p = Pharmacist.getInstance();
		p.init(PharmacistDAO.readPharmacist(db, username, password));
		if (p.getId() != null) {
			state = true;
		}
	}

	private static boolean state = false;

}
