package duchien.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import duchien.com.dao.ProductDao;
import duchien.com.dao.UserDao;
import duchien.com.Connection.DBConnection;
import duchien.com.model.Category;
import duchien.com.model.Product;
import duchien.com.model.Type;
import duchien.com.model.User;
import duchien.com.service.CategoryService;
import duchien.com.service.TypeService;
import duchien.com.service.impl.CategoryServiceImpl;
import duchien.com.service.impl.TypeServiceImpl;

public class ProductDaoImpl extends DBConnection implements ProductDao {
	CategoryService categortService = new CategoryServiceImpl();
	TypeService typeService = new TypeServiceImpl();

	@Override
	public void insert(Product product) throws SQLException {
		String sql = "INSERT INTO Product(name, price, image, cate_id, des, type_id) VALUES (?,?,?,?,?,?)";
		Connection con = super.getJDBCConnection();
		System.out.print("-----------------SQL SQL ------------------------");

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setLong(2, product.getPrice());
			ps.setString(3, product.getImage());
			ps.setInt(4, product.getCategory().getId());
			ps.setString(5, product.getDes());
			ps.setInt(6, product.getType().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Product product) throws SQLException {
		String sql = "UPDATE Product SET Product.name = ? , price = ?, image = ?,cate_id=?, des=?, type_id=?  WHERE id = ?";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			;
			ps.setString(3, product.getImage());
			ps.setInt(4, product.getCategory().getId());
			ps.setString(5, product.getDes());
			ps.setInt(6, product.getType().getId());
			ps.setInt(7, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM Product WHERE id=?";
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
	public Product get(int id) throws SQLException {
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des, "
				+ "category.cate_name AS c_name, category.cate_id AS c_id, typePro.type_name AS t_name, typePro.type_id AS t_id "
				+ "FROM product, Category, TypePro "
				+ "where product.cate_id = category.cate_id and Product.type_id = TypePro.type_id and product.id=?";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categortService.get(rs.getInt("c_id"));
				Type type = typeService.get(rs.getInt("t_id"));

				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDes(rs.getString("des"));
				product.setCategory(category);
				product.setType(type);

				return product;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAll() throws SQLException {

		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des, "
				+ "category.cate_name AS c_name, category.cate_id AS c_id, typePro.type_name AS t_name, typePro.type_id AS t_id "
				+ "FROM product, Category, TypePro "
				+ "where product.cate_id = category.cate_id and Product.type_id = TypePro.type_id";
		Connection conn = super.getJDBCConnection();
		System.out.println("**********ProductDaoImpl getAll() Start********");
		try {
			System.out.println("***********Try***********");
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("**********PreparedStatement************");
			ResultSet rs = ps.executeQuery();
			System.out.println("***********ResultSet***********");
			
			while (rs.next()) {
				System.out.println("**********while (rs.next())********");
				Category category = categortService.get(rs.getInt("c_id"));
				Type type = typeService.get(rs.getInt("t_id"));
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDes(rs.getString("des"));
				product.setCategory(category);
				product.setType(type);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("**********ProductDaoImpl getAll() Error********");
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public List<Product> search(String keyword) throws SQLException {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM user WHERE name LIKE ? ";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDes(rs.getString("des"));

				Category category = new Category();
				Type type = new Type();
				category.setId(rs.getInt("c_id"));
				category.setName(rs.getString("c_name"));
				type.setId(rs.getInt("t_id"));
				type.setName(rs.getString("t_name"));

				product.setCategory(category);
				product.setType(type);

				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public List<Product> seachByCategory(int cate_id) throws SQLException {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id , typePro.type_name AS t_name, typePro.type_id AS t_id 	 FROM Product , Category, TypePro  where product.cate_id = category.cate_id and typePro.type_id = product.type_id and Category.cate_id=? ";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cate_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categortService.get(rs.getInt("c_id"));
				Type type = typeService.get(rs.getInt("t_id"));
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDes(rs.getString("des"));
				product.setCategory(category);

				product.setType(type);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}
	
	public List<Product> seachByType(int type_id) throws SQLException {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id , typePro.type_name AS t_name, typePro.type_id AS t_id 	 FROM Product , Category, TypePro  where product.cate_id = category.cate_id and typePro.type_id = product.type_id and typePro.type_id=?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, type_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categortService.get(rs.getInt("c_id"));
				Type type = typeService.get(rs.getInt("t_id"));
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDes(rs.getString("des"));
				product.setCategory(category);
				product.setType(type);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public List<Product> seachByName(String productName) throws SQLException {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , "
				+ "category.cate_name AS c_name, category.cate_id AS c_id, typePro.type_name AS t_name, typePro.type_id AS t_id "
				+ " FROM Product , Category , TypePro  where product.type_id = typePro.type_id and product.cate_id = category.cate_id and Product.name like ? ";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+ productName +"%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categortService.get(rs.getInt("c_id"));
				Type type = typeService.get(rs.getInt("t_id"));
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDes(rs.getString("des"));
				product.setCategory(category);

				product.setType(type);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

}
