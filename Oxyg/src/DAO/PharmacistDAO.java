package DAO;

import java.sql.*;

import Entity.*;

public class PharmacistDAO {

	private static Pharmacist deserializeCurrentRecord(ResultSet rs) throws SQLException {
		Pharmacist p = new Pharmacist();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setSurname(rs.getString("surname"));
		return p;
	}

	public static Pharmacist readPharmacist(DBManager db, String username, String password) {
		Pharmacist p = new Pharmacist();
		try (PreparedStatement ps = db.getConnection()
				.prepareStatement("SELECT * FROM pharmacist WHERE " + "username = ? && password = MD5(?)")) {
			ps.setString(1, username);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					p = deserializeCurrentRecord(rs);
				}
			} catch (SQLException e) {
				System.err.println("Invalid Result Set. " + e);
			}
		} catch (SQLException e) {
			System.err.println("Read pharmacist error. " + e);
		}
		return p;
	}
	
	
	public static void writePharmacist(DBManager db, String name, String surname, String username, String password) {
		try (PreparedStatement ps = db.getConnection()
				.prepareStatement("INSERT INTO pharmacist(name, surname, username, password) VALUES (?, ?, ?, MD5(?))")){
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, username);
			ps.setString(4, password);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Insert pharmacist error. " + e);
		}
		
	}
}
