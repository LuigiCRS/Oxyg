package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import Entity.OxygenCylinder;

public class OxygenCylinderDAO {

	private static OxygenCylinder deserializeCurrentRecord(ResultSet rs) throws SQLException {
		OxygenCylinder o = new OxygenCylinder();
		o.setId(rs.getString("id"));
		o.setVolume(rs.getInt("volume"));
		o.setState(rs.getBoolean("state"));
		return o;
	}

	public static ArrayList<OxygenCylinder> readOxygenCylinders(DBManager db) {
		ArrayList<OxygenCylinder> os = new ArrayList<OxygenCylinder>();

		try (PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM oxygen")) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					os.add(deserializeCurrentRecord(rs));
				}

			} catch (SQLException e) {
				System.err.println("Invalid Result Set. " + e);
			}

		} catch (SQLException e) {
			System.err.println("Read Oxygen Cylinders error." + e);
		}

		return os;
	}

	public static OxygenCylinder readOxygenCylinder(DBManager db, String id) {
		OxygenCylinder o = new OxygenCylinder();
		try (PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM oxygen WHERE id = ?")) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					o = deserializeCurrentRecord(rs);
				}

			} catch (SQLException e) {
				System.err.println("Invalid Result Set. " + e);
			}

		} catch (SQLException e) {
			System.err.println("Read Oxygen Cylinder error. " + e);
		}
		return o;
	}

	public static void writeOxygenCylinder(DBManager db, String id, Integer volume) {
		try (PreparedStatement ps = db.getConnection()
				.prepareStatement("INSERT INTO oxygen(id, volume, state) VALUES (?, ?, ?)")) {
			ps.setString(1, id);
			ps.setInt(2, volume);
			ps.setBoolean(3, true);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Insert oxygen cylinders error. " + e);
		}
	}

	public static void writeOxygensCylinders(DBManager db, ArrayList<OxygenCylinder> os) {
		Iterator<OxygenCylinder> i = os.iterator();
		try (PreparedStatement ps = db.getConnection()
				.prepareStatement("INSERT INTO oxygen(id, volume) VALUES (?, ?, ?)")) {
			while (i.hasNext()) {
				OxygenCylinder o = i.next();

				ps.setString(1, o.getId());
				ps.setInt(2, o.getVolume());
				ps.setBoolean(3, true);

				ps.executeUpdate();
			}

		} catch (SQLException e) {
			System.err.println("Insert oxygen cylinders error. " + e);
		}
	}

	public static void updateAvailableOC(DBManager db, String id, boolean newState) {
		try (PreparedStatement ps = db.getConnection().prepareStatement("UPDATE oxygen SET state = ? WHERE id = ?")) {
			ps.setBoolean(1, newState);
			ps.setString(2, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Update state error." + e);
		}
	}

}
