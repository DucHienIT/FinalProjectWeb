package duchien.com.service.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import duchien.com.dao.CartDao;
import duchien.com.dao.CartItemDao;
import duchien.com.dao.ProductDao;
import duchien.com.dao.UserDao;
import duchien.com.dao.impl.CartDaoImpl;
import duchien.com.dao.impl.CartItemDaoImpl;
import duchien.com.dao.impl.ProductDaoImpl;
import duchien.com.dao.impl.UserDaoImpl;
import duchien.com.model.Cart;
import duchien.com.model.CartItem;
import duchien.com.model.Product;
import duchien.com.model.User;
import duchien.com.service.CartItemService;
import duchien.com.service.CartService;
import duchien.com.service.ProductService;
import duchien.com.service.UserService;

public class CartServiceItemImpl implements CartItemService {
	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void insert(CartItem cartItem) throws SQLException {
		cartItemDao.insert(cartItem);
		
	}

	@Override
	public void edit(CartItem newCartItem) throws SQLException {
		CartItem oldCartItem = cartItemDao.get(newCartItem.getId());
		oldCartItem.setCart(newCartItem.getCart());
		oldCartItem.setProduct(newCartItem.getProduct());
		oldCartItem.setQuantity(newCartItem.getQuantity());
		oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
		
		cartItemDao.edit(oldCartItem);
	}

	@Override
	public void delete(String id) throws SQLException {
		cartItemDao.delete(id);
	}

	@Override
	public CartItem get(int id) throws SQLException {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItem> getAll() throws SQLException {
		return cartItemDao.getAll();
	}

	@Override
	public List<CartItem> search(String keyword) {
		return cartItemDao.search(keyword);
	}

	
}
