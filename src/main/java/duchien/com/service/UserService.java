package duchien.com.service;

import java.sql.SQLException;
import java.util.List;

import duchien.com.model.User;

public interface UserService {
	void insert(User user)throws SQLException;

	void edit(User user)throws SQLException;

	void delete(int id)throws SQLException;

	User get(String username)throws SQLException;
	
	User get(int id)throws SQLException;
	
	User login(String username, String password)throws SQLException;
	
	boolean register(String email, String password, String username)throws SQLException;

	List<User> getAll() throws SQLException;

	List<User> search(String keyword)throws SQLException;
	
	boolean checkExistEmail(String email)throws SQLException;
	
	boolean checkExistUsername(String username) throws SQLException;
	
}
