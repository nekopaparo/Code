package bean.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {
	private Connection con = null;
	private String driver = "org.sqlite.JDBC"; //sqlite-jdbc-3.36.0.1.jar

	private String path = "jdbc:sqlite:";
	private String db = "data/world.db";
	private String url = path + db;

	public Connection getCon() throws SQLException {
		try {
			Class.forName(driver);
			System.out.println("SQLite driver is OK");
			con = DriverManager.getConnection(url);
			System.out.println("SQLite 連線成功");
		} catch (ClassNotFoundException e) {
			System.out.println("SQLite driver is not OK");
		} catch (SQLException e) {
			System.out.println("SQLite 連線失敗");
			throw new SQLException();
		}
		return con;
	}
}
