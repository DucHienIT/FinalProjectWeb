package duchien.com.service;

import java.sql.SQLException;
import java.util.List;


import duchien.com.model.Category;

public interface CategoryService {
	void insert(Category category)throws SQLException;

	void edit(Category category)throws SQLException;

	void delete(int id)throws SQLException;

	Category get(int id)throws SQLException;
	
	Category get(String name)throws SQLException;

	List<Category> getAll() throws SQLException;

	List<Category> search(String username) throws SQLException;
}
