package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Client;

public class ClientDAO {

	private static Client deserializeCurrentRecord(ResultSet rs) throws SQLException {
		Client c = new Client();
		c.setCF(rs.getString("CF"));
		c.setName(rs.getString("name"));
		c.setSurname(rs.getString("surname"));
		c.setAddress(rs.getString("address"));
		return c;
	}

	public static ArrayList<Client> readClients(DBManager db) {
		ArrayList<Client> clients = new ArrayList<Client>();
		try (PreparedStatement p = db.getConnection()
				.prepareStatement("SELECT * FROM client")) {

			try (ResultSet rs = p.executeQuery()) {
				while (rs.next()) {
					clients.add(deserializeCurrentRecord(rs));
				}

			} catch (SQLException e) {
				System.err.println("Invalid Result Set. " + e);
			}

		} catch (SQLException e) {
			System.err.println("Read clients error. " + e);
		}
		return clients;
	}

	public static Client readClient(DBManager db, String CF) {
		Client c = new Client();
		try (PreparedStatement ps = db.getConnection()
				.prepareStatement("SELECT * FROM client WHERE CF = ?")) {
			ps.setString(1, CF);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next())
					c = deserializeCurrentRecord(rs);
			} catch (SQLException e) {
				System.err.println("Invalid Result Set.");
			}

		} catch (SQLException e) {
			System.err.println("Read client error. " + e);
		}
		return c;
	}

	public static void writeClient(DBManager db, String CF, String name, String surname, String address) {
		try (PreparedStatement ps = db.getConnection()
				.prepareStatement("INSERT INTO client(CF, name, surname, address) VALUES (?, ?, ?, ?)")) {
			ps.setString(1, CF);
			ps.setString(2, name);
			ps.setString(3, surname);
			ps.setString(4, address);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Insert pharmacist error. " + e);
		}

	}

}
