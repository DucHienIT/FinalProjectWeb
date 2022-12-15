package duchien.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import duchien.com.dao.CategoryDao;
import duchien.com.Connection.DBConnection;
import duchien.com.model.Category;

public class CategoryDaoImpl extends DBConnection implements CategoryDao {

	@Override
	public void insert(Category category) throws SQLException {
		String sql = "INSERT INTO Category(cate_name) VALUES (?)";
		Connection con = super.getJDBCConnection();

		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.executeUpdate();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Lỗi sql");
		}
	}

	@Override
	public void edit(Category category) throws SQLException {
		String sql = "UPDATE category SET cate_name = ? WHERE cate_id = ?";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setInt(2, category.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM category WHERE cate_id = ?";
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
	public Category get(int id) throws SQLException {
		String sql = "SELECT * FROM category WHERE cate_id = ? ";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("cate_id"));
				category.setName(rs.getString("cate_name"));

				return category;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAll() throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM Category";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("cate_id"));
				category.setName(rs.getString("cate_name"));

				categories.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public List<Category> search(String keyword) throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM category WHERE name LIKE ? ";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));

				categories.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public Category get(String name) throws SQLException {
		String sql = "SELECT * FROM Category WHERE cate_name = ? ";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("cate_id"));
				category.setName(rs.getString("cate_name"));

				return category;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
