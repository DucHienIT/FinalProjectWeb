package duchien.com.service.impl;

import java.sql.SQLException;
import java.util.List;

import duchien.com.dao.TypeDao;
import duchien.com.dao.impl.TypeDaoImpl;
import duchien.com.model.Type;
import duchien.com.model.User;
import duchien.com.service.TypeService;

public class TypeServiceImpl implements TypeService {
	TypeDao typeDao = new TypeDaoImpl();

	@Override
	public void insert(Type Type) throws SQLException {
		typeDao.insert(Type);

	}

	@Override
	public void edit(Type newType) throws SQLException {
		Type oldCate = typeDao.get(newType.getId());
		oldCate.setName(newType.getName());
		typeDao.edit(oldCate);

	}

	@Override
	public void delete(int id) throws SQLException {
		typeDao.delete(id);

	}

	@Override
	public Type get(int id) throws SQLException {
		return typeDao.get(id);
	}

	@Override
	public Type get(String name) throws SQLException {
		return typeDao.get(name);
	}

	@Override
	public List<Type> getAll() throws SQLException {
		return typeDao.getAll();
	}

	@Override
	public List<Type> search(String username) throws SQLException{
		return typeDao.search(username);
	}
}