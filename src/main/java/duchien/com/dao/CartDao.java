package duchien.com.dao;

import java.sql.SQLException;
import java.util.List;

import duchien.com.model.Cart;
import duchien.com.model.Category;

public interface CartDao {
	void insert(Cart cart) throws SQLException;

	void edit(Cart cart) throws SQLException;

	void delete(String id) throws SQLException;

	Cart get(String id) throws SQLException;

	List<Cart> getAll() throws SQLException;

	List<Cart> search(String name) throws SQLException;
}
