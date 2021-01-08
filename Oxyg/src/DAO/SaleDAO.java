package DAO;

import java.sql.*;
import java.util.ArrayList;

import Entity.*;

public class SaleDAO {

	private static Sale deserializeCurrentRecord(ResultSet rs) throws SQLException {
		Sale s = new Sale();
		Client c = new Client();
		Pharmacist p = new Pharmacist();
		OxygenCylinder o = new OxygenCylinder();
		c.setCF(rs.getString("fiscal_code"));
		c.setName(rs.getString("client_name"));
		c.setSurname(rs.getString("client_surname"));
		c.setAddress(rs.getString("client_address"));
		p.setId(rs.getInt("id_pharmacist"));
		p.setName(rs.getString("name_pharmacist"));
		p.setSurname(rs.getString("surname_pharmacist"));
		o.setId(rs.getString("id_oxygen"));
		o.setVolume(rs.getInt("oxygen_volume"));
		s.setId(rs.getInt("id_sale"));
		s.setDate(rs.getDate("data_sale"));
		s.setClient(c);
		s.setOxygen(o);
		s.setPharmacist(p);
		return s;
	}

	public static ArrayList<Sale> readSales(DBManager db) {
		ArrayList<Sale> s = new ArrayList<Sale>();
		try (PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM sale_view")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					s.add(deserializeCurrentRecord(rs));
				}
			} catch (SQLException e) {
				System.err.println("Invalid Result Set." + e);
			}

		} catch (SQLException e) {
			System.err.println("Read Sales error." + e);
		}
		return s;
	}

	public static ArrayList<Sale> readSales(DBManager db, String CF) {
		ArrayList<Sale> s = new ArrayList<Sale>();
		try (PreparedStatement ps = db.getConnection()
				.prepareStatement("SELECT * FROM sale_view WHERE fiscal_code = ?")) {
			ps.setString(1, CF);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					s.add(deserializeCurrentRecord(rs));
				}
			} catch (SQLException e) {
				System.err.println("Invalid Result Set." + e);
			}

		} catch (SQLException e) {
			System.err.println("Read Sales error." + e);
		}
		return s;
	}

	public static void writeSale(DBManager db, Client c, Pharmacist p, OxygenCylinder o) {
		Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		try (PreparedStatement ps = db.getConnection()
				.prepareStatement("INSERT INTO sale(idClient, idPharmacist, idOxygen, data) VALUES (?, ?, ?, ?)")) {
			ps.setString(1, c.getCF());
			ps.setInt(2, p.getId());
			ps.setString(3, o.getId());
			ps.setDate(4, sqlDate);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Write sale error." + e);
		}
	}

}
