package duchien.com.dao;

import java.sql.SQLException;
import java.util.List;

import duchien.com.model.User;

public interface UserDao {
	void insert(User user) throws SQLException;

	void edit(User user) throws SQLException;

	void delete(int id) throws SQLException;

	User get(String username) throws SQLException;
	
	User get(int id) throws SQLException;

	List<User> getAll() throws SQLException;

	List<User> search(String username) throws SQLException;
	
	boolean checkExistEmail(String email) throws SQLException;
	
	boolean checkExistUsername(String username) throws SQLException;
}
