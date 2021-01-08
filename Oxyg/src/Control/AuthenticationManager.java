package Control;

import DAO.DBManager;
import DAO.PharmacistDAO;

public class AuthenticationManager {
	
	
	
	public boolean isAuthenticated() {
		return AuthenticationManager.state;
	}
	
	public static void Authentication(String username, String password) {
		DBManager db = DBManager.getInstance();
		if (PharmacistDAO.readPharmacist(db, username, password) != null) {
			state = true;
		}
	}
	
	private static boolean state = false;
	
}
