package duchien.com.service.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import duchien.com.dao.UserDao;
import duchien.com.dao.impl.UserDaoImpl;
import duchien.com.model.User;
import duchien.com.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(User user) throws SQLException {
		userDao.insert(user);
	}

	@Override
	public void edit(User newUser) throws SQLException {
		User oldUser = userDao.get(newUser.getId());

		oldUser.setEmail(newUser.getEmail());
		oldUser.setUsername(newUser.getUsername());
		oldUser.setPassword(newUser.getPassword());
		oldUser.setRoleId(newUser.getRoleId());
		if (newUser.getAvatar() != null) {
			// XOA ANH CU DI
			String fileName = oldUser.getAvatar();
			final String dir = "C:\\Users\\mai vien\\eclipse-workspace\\UNIFY\\upload";
			File file = new File(dir + "/" + fileName);
			if (file.exists()) {
				file.delete();
			}
			// THEM ANH MOI
			oldUser.setAvatar(newUser.getAvatar());
		}

		userDao.edit(oldUser);
	}

	@Override
	public void delete(int id) throws SQLException {
		userDao.delete(id);
	}

	@Override
	public User get(String username) throws SQLException {
		return userDao.get(username);
	}

	@Override
	public User get(int id) throws SQLException {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() throws SQLException {
		return userDao.getAll();
	}

	@Override
	public List<User> search(String username) throws SQLException {
		return userDao.search(username);
	}

	@Override
	public User login(String username, String password) throws SQLException {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}

		return null;
	}

	@Override
	public boolean register(String username, String password, String email) throws SQLException {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		userDao.insert(new User(email, username, password));
		return true;
	}
	

	public boolean checkExistEmail(String email) throws SQLException {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) throws SQLException {
		return userDao.checkExistUsername(username);
	}
}
