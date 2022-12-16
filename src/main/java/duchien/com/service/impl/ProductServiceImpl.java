package duchien.com.service.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import duchien.com.dao.ProductDao;
import duchien.com.dao.UserDao;
import duchien.com.dao.impl.ProductDaoImpl;
import duchien.com.dao.impl.UserDaoImpl;
import duchien.com.model.Product;
import duchien.com.model.User;
import duchien.com.service.ProductService;
import duchien.com.service.UserService;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();

	@Override
	public void insert(Product product) throws SQLException {
		productDao.insert(product);

	}

	@Override
	public void edit(Product newProduct) throws SQLException {
		Product oldProduct = productDao.get(newProduct.getId());

		oldProduct.setName(newProduct.getName());
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setCategory(newProduct.getCategory());
		if (newProduct.getImage() != null) {
			// XOA ANH CU DI
			String fileName = oldProduct.getImage();
			final String dir = "D:\\upload";
			File file = new File(dir + "/" + fileName);
			if (file.exists()) {
				file.delete();
			}

			oldProduct.setImage(newProduct.getImage());
		}

		productDao.edit(oldProduct);

	}

	@Override
	public void delete(int id) throws SQLException {
		productDao.delete(id);

	}

	@Override
	public Product get(int id) throws SQLException {
		return productDao.get(id);
	}

	@Override
	public List<Product> getAll() throws SQLException{
		return productDao.getAll();
	}

	@Override
	public List<Product> search(String product) throws SQLException {
		return productDao.search(product);
	}

	@Override
	public List<Product> seachByCategory(int cate_id) throws SQLException {
		return productDao.seachByCategory(cate_id);
	}
	public List<Product> seachByType(int type_id) throws SQLException {
		return productDao.seachByType(type_id);
	}

	@Override
	public List<Product> seachByName(String productName) throws SQLException {
		return productDao.seachByName(productName);
	}

}
