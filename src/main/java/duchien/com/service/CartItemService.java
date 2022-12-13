package duchien.com.service;

import java.sql.SQLException;
import java.util.List;

import duchien.com.model.Cart;
import duchien.com.model.CartItem;

public interface CartItemService {
	void insert(CartItem cartItem) throws SQLException;

	void edit(CartItem cartItem) throws SQLException;

	void delete(String id)throws SQLException;

	CartItem get(int id)throws SQLException;
	
	List<CartItem> getAll()throws SQLException;

	List<CartItem> search(String keyword)throws SQLException;
}
