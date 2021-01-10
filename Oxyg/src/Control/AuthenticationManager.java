package Control;

import DAO.DBManager;
import DAO.PharmacistDAO;
import Entity.Pharmacist;

public class AuthenticationManager {

	public static boolean isAuthenticated() {
		return state;
	}

	public static void Authentication(String username, String password) {
		DBManager db = DBManager.getInstance();
		Pharmacist p = Pharmacist.getInstance();
		p.init(PharmacistDAO.readPharmacist(db, username, password).getId(),
				PharmacistDAO.readPharmacist(db, username, password).getName(),
				PharmacistDAO.readPharmacist(db, username, password).getSurname());
		PharmacistDAO.readPharmacist(db, username, password).getId();
		if (p.getId() != null) {
			state = true;
		}
	}

	private static boolean state = false;

}
