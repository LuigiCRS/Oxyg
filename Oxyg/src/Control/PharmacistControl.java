package Control;

import java.util.ArrayList;



import DAO.ClientDAO;
import DAO.DBManager;
import DAO.OxygenCylinderDAO;
import DAO.SaleDAO;

import Entity.Client;
import Entity.OxygenCylinder;
import Entity.Pharmacist;
import Entity.Sale;

public class PharmacistControl {

	public static void buyOxygen(OxygenCylinder o, Client c) {
		DBManager db = DBManager.getInstance();
		if (ClientDAO.readClient(db, c.getCF()).getCF() == null)
			ClientDAO.writeClient(db, c.getCF(), c.getName(), c.getSurname(), c.getAddress());
		if (OxygenCylinderDAO.readOxygenCylinder(db, o.getId()).getId() == null)
			OxygenCylinderDAO.writeOxygenCylinder(db, o.getId(), o.getVolume());
		else
			SaleDAO.updateSale(db, o.getId(), c.getCF(), false, true);

		SaleDAO.writeSale(db, c, Pharmacist.getInstance(), o);
	}

	public static void restitutionOxygen(String idOxygen, String CF) {
		DBManager db = DBManager.getInstance();

		if (OxygenCylinderDAO.readOxygenCylinder(db, idOxygen) != null)
			SaleDAO.updateSale(db, idOxygen, CF, true, false);
		else
			System.out.println("Cylinder not registered. Retry.");

	}

	public static boolean validId(String id) {
		DBManager db = DBManager.getInstance();
		if (!(OxygenCylinderDAO.readOxygenCylinder(db, id).getId() == null))
			return true;
		return false;

	}

	public static boolean validCF(String CF) {
		DBManager db = DBManager.getInstance();
		if (!(ClientDAO.readClient(db, CF).getCF() == null))
			return true;
		return false;

	}

	public static ArrayList<Sale> restitutionData() {
		ArrayList<Sale> r = new ArrayList<Sale>();
		DBManager db = DBManager.getInstance();
		r = SaleDAO.readSales(db);
		return r;
	}

	public static void exitControl() {
		DBManager dbManager = DBManager.getInstance();
		dbManager.closeConnection();
		System.exit(0);
	}
}