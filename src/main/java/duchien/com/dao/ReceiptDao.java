package duchien.com.dao;

import java.sql.SQLException;
import java.util.List;

import duchien.com.model.Receipt;


public interface ReceiptDao {
	void insert(Receipt receipt) throws SQLException;

	void edit(Receipt receipt) throws SQLException;

	void delete(int id) throws SQLException;

	Receipt get(String name);

	Receipt get(int id) throws SQLException;

	List<Receipt> getAll() throws SQLException;

	List<Receipt> search(String name) throws SQLException;
}
