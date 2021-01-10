package Control;

import DAO.ClientDAO;
import DAO.DBManager;
import DAO.OxygenCylinderDAO;
import DAO.SaleDAO;

import Entity.Client;
import Entity.OxygenCylinder;
import Entity.Pharmacist;

public class PharmacistControl {

	public static void buyOxygen(OxygenCylinder o, Client c) {
		DBManager db = DBManager.getInstance();
		if(ClientDAO.readClient(db, c.getCF()).getCF() == null)
			ClientDAO.writeClient(db, c.getCF(), c.getName(), c.getSurname(), c.getAddress());
		if(OxygenCylinderDAO.readOxygenCylinder(db, o.getId()).getId() == null)
			OxygenCylinderDAO.writeOxygenCylinder(db, o.getId(), o.getVolume());
		else
			OxygenCylinderDAO.updateAvailableOC(db, o.getId(), true);
		
		SaleDAO.writeSale(db, c, Pharmacist.getInstance(), o);
		
		
		
	}
}
