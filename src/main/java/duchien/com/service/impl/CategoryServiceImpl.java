package duchien.com.service.impl;

import java.sql.SQLException;
import java.util.List;

import duchien.com.dao.CategoryDao;
import duchien.com.dao.impl.CategoryDaoImpl;
import duchien.com.model.Category;
import duchien.com.model.User;
import duchien.com.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(Category category) throws SQLException {
		categoryDao.insert(category);

	}

	@Override
	public void edit(Category newCategory) throws SQLException {
		Category oldCate = categoryDao.get(newCategory.getId());
		oldCate.setName(newCategory.getName());
		categoryDao.edit(oldCate);

	}

	@Override
	public void delete(int id) throws SQLException {
		categoryDao.delete(id);

	}

	@Override
	public Category get(int id) throws SQLException {
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) throws SQLException {
		return categoryDao.get(name);
	}

	@Override
	public List<Category> getAll() throws SQLException {
		return categoryDao.getAll();
	}

	@Override
	public List<Category> search(String username) throws SQLException{
		return categoryDao.search(username);
	}
}