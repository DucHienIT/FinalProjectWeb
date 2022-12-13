package duchien.com.service;

import java.sql.SQLException;
import java.util.List;

import duchien.com.model.Cart;

public interface CartService {
	void insert(Cart cart) throws SQLException;

	void edit(Cart newCart) throws SQLException;

	void delete(int id) throws SQLException;

	Cart get(int id) throws SQLException;
	
	List<Cart> getAll() throws SQLException;

	List<Cart> search(String keyword) throws SQLException;
}
