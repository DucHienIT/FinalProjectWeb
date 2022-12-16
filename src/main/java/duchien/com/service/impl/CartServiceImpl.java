package duchien.com.service.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import duchien.com.dao.CartDao;
import duchien.com.dao.ProductDao;
import duchien.com.dao.UserDao;
import duchien.com.dao.impl.CartDaoImpl;
import duchien.com.dao.impl.ProductDaoImpl;
import duchien.com.dao.impl.UserDaoImpl;
import duchien.com.model.Cart;
import duchien.com.model.Product;
import duchien.com.model.User;
import duchien.com.service.CartService;
import duchien.com.service.ProductService;
import duchien.com.service.UserService;

public class CartServiceImpl implements CartService {
	CartDao cartDao = new CartDaoImpl();

	@Override
	public List<Cart> search(String name) throws SQLException {
		return cartDao.search(name);
	}

	@Override
	public void insert(Cart cart) throws SQLException {
		cartDao.insert(cart);

	}

	@Override
	public List<Cart> getAll() throws SQLException {
		return cartDao.getAll();
	}

	@Override
	public Cart get(String id) throws SQLException {
		return cartDao.get(id);
	}

	@Override
	public void edit(Cart newCart) throws SQLException {
		Cart oldCart = cartDao.get(newCart.getId());

		oldCart.setBuyDate(newCart.getBuyDate());
		oldCart.setBuyer(newCart.getBuyer());
		
		
		cartDao.edit(oldCart);

	}

	@Override
	public void delete(String id) throws SQLException {
		cartDao.delete(id);
	}
}
