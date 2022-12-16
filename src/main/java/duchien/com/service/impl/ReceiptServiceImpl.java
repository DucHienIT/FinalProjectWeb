package duchien.com.service.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import duchien.com.dao.CartDao;
import duchien.com.dao.ProductDao;
import duchien.com.dao.ReceiptDao;
import duchien.com.dao.UserDao;
import duchien.com.dao.impl.CartDaoImpl;
import duchien.com.dao.impl.ProductDaoImpl;
import duchien.com.dao.impl.ReceiptDaoImpl;
import duchien.com.dao.impl.UserDaoImpl;
import duchien.com.model.Cart;
import duchien.com.model.Product;
import duchien.com.model.Receipt;
import duchien.com.model.User;
import duchien.com.service.CartService;
import duchien.com.service.ProductService;
import duchien.com.service.ReceiptService;
import duchien.com.service.UserService;

public class ReceiptServiceImpl implements ReceiptService {
	ReceiptDao receiptDao = new ReceiptDaoImpl();


	@Override
	public void insert(Receipt cart) throws SQLException {
		receiptDao.insert(cart);
	}

	@Override
	public List<Receipt> getAll() throws SQLException {
		return receiptDao.getAll();
	}

	@Override
	public Receipt get(int id) throws SQLException {
		return receiptDao.get(id);
	}

	@Override
	public void edit(Receipt newCart) throws SQLException {
		Receipt oldCart = receiptDao.get(newCart.getId());

		oldCart.setAddress(newCart.getAddress());
		oldCart.setSdt(newCart.getSdt());
		
		receiptDao.edit(oldCart);

	}

	@Override
	public void delete(int id) throws SQLException {
		receiptDao.delete(id);
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
