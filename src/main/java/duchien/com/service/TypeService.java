package duchien.com.service;

import java.sql.SQLException;
import java.util.List;


import duchien.com.model.Type;

public interface TypeService {
	void insert(Type type)throws SQLException;

	void edit(Type type)throws SQLException;

	void delete(int id)throws SQLException;

	Type get(int id)throws SQLException;
	
	Type get(String name)throws SQLException;

	List<Type> getAll() throws SQLException;

	List<Type> search(String username) throws SQLException;
}
