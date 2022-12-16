package duchien.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import duchien.com.dao.TypeDao;
import duchien.com.Connection.DBConnection;
import duchien.com.model.Type;

public class TypeDaoImpl extends DBConnection implements TypeDao {

	@Override
	public void insert(Type type) throws SQLException {
		String sql = "INSERT INTO Type(type_name) VALUES (?)";
		Connection con = super.getJDBCConnection();

		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, type.getName());
			ps.executeUpdate();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Lỗi sql");
		}
	}

	@Override
	public void edit(Type type) throws SQLException {
		String sql = "UPDATE Type SET type_name = ? WHERE type_id = ?";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, type.getName());
			ps.setInt(2, type.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM Type WHERE type_id = ?";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Type get(int id) throws SQLException {
		String sql = "SELECT * FROM Type WHERE type_id = ? ";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Type type = new Type();

				type.setId(rs.getInt("type_id"));
				type.setName(rs.getString("type_name"));

				return type;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Type> getAll() throws SQLException {
		List<Type> categories = new ArrayList<Type>();
		String sql = "SELECT * FROM Type";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Type type = new Type();

				type.setId(rs.getInt("type_id"));
				type.setName(rs.getString("type_name"));

				categories.add(type);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public List<Type> search(String keyword) throws SQLException {
		List<Type> categories = new ArrayList<Type>();
		String sql = "SELECT * FROM Type WHERE name LIKE ? ";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Type type = new Type();

				type.setId(rs.getInt("id"));
				type.setName(rs.getString("name"));

				categories.add(type);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public Type get(String name) throws SQLException {
		String sql = "SELECT * FROM Type WHERE type_name = ? ";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Type type = new Type();

				type.setId(rs.getInt("type_id"));
				type.setName(rs.getString("type_name"));

				return type;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
