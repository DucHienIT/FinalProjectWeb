package duchien.com.dao;

import java.sql.SQLException;
import java.util.List;

import duchien.com.model.Cart;
import duchien.com.model.CartItem;
import duchien.com.model.Category;

public interface CartItemDao {
	void insert(CartItem cartItem) throws SQLException;

	void edit(CartItem cartItem) throws SQLException;

	void delete(String id) throws SQLException;

	CartItem get(String name);

	CartItem get(int id) throws SQLException;

	List<CartItem> getAll() throws SQLException;

	List<CartItem> search(String name);
}
