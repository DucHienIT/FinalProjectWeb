package duchien.com.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static Connection getJDBCConnection() {
		Connection connection = null;
		System.out.println("************JDBC Start***********");
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String user = "duchien";
			String pass = "duchien";
			String url = "jdbc:sqlserver://HIENPC\\HIEN;"
							            + "databaseName=UNIFY;";

			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("************JDBC thanh cong***********");
			
		} catch (SQLException ex) {
			System.out.println("************JDBC Failed***********");
			ex.printStackTrace();
		}
		System.out.println("************return connection***********");
		System.out.println(connection);
		return connection;
	}
	
}