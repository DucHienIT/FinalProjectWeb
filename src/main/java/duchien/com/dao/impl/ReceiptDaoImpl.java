package duchien.com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

import duchien.com.dao.CartDao;
import duchien.com.dao.CategoryDao;
import duchien.com.dao.ProductDao;
import duchien.com.dao.ReceiptDao;
import duchien.com.Connection.DBConnection;
import duchien.com.model.Cart;
import duchien.com.model.Category;
import duchien.com.model.Product;
import duchien.com.model.Receipt;
import duchien.com.model.User;
import duchien.com.service.CartService;
import duchien.com.service.CategoryService;
import duchien.com.service.UserService;
import duchien.com.service.impl.CartServiceImpl;
import duchien.com.service.impl.CategoryServiceImpl;
import duchien.com.service.impl.UserServiceImpl;

public class ReceiptDaoImpl extends DBConnection implements ReceiptDao {
	UserService userS = new UserServiceImpl();
	CartService cartS = new CartServiceImpl();

	@Override
	public void insert(Receipt receipt) throws SQLException {
		String sql = "INSERT INTO Receipt(address, sdt, cart_id, user_id) VALUES (?,?,?,?)";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, receipt.getAddress());
			ps.setString(2, receipt.getSdt());
			ps.setString(3, receipt.getCart().getId());
			ps.setInt(4, receipt.getBuyer().getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Receipt receipt) throws SQLException {
		String sql = "UPDATE Receipt SET address = ?, sdt = ? WHERE id = ?";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, receipt.getAddress());
			ps.setString(2, receipt.getSdt());
			ps.setInt(3, receipt.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM Receipt WHERE id = ?";
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
	public Receipt get(int id) throws SQLException {
		String sql = "SELECT * FROM Receipt where Receipt.id = ?";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = userS.get(rs.getInt("user_id"));
				Cart cart = cartS.get(rs.getString("cart_id"));

				Receipt receipt = new Receipt();
				receipt.setId(rs.getInt("id"));
				receipt.setAddress(rs.getString("Address"));
				receipt.setSdt(rs.getString("sdt"));
				receipt.setCart(cart);

				return receipt;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Receipt> getAll() throws SQLException {
		List<Receipt> receiptList = new ArrayList<Receipt>();
		String sql = "SELECT * FROM Receipt";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = userS.get(rs.getInt("user_id"));
				Cart cart = cartS.get(rs.getString("cart_id"));

				Receipt receipt = new Receipt();
				receipt.setId(rs.getInt("id"));
				receipt.setAddress(rs.getString("Address"));
				receipt.setSdt(rs.getString("sdt"));
				receipt.setCart(cart);

				receiptList.add(receipt);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receiptList;
	}

	@Override
	public Receipt get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receipt> search(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
