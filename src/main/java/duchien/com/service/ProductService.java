package duchien.com.service;

import java.sql.SQLException;
import java.util.List;

import duchien.com.model.Product;

public interface ProductService {
	void insert(Product product)throws SQLException;

	void edit(Product product) throws SQLException;

	void delete(int id) throws SQLException;

	Product get(int id) throws SQLException;

	List<Product> getAll() throws SQLException;

	List<Product> search(String username) throws SQLException;
	
	List<Product> seachByCategory(int cate_id) throws SQLException;
	
	List<Product> seachByName(String productName) throws SQLException;
}
