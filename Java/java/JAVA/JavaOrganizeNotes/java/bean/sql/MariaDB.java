package bean.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDB {
	private Connection conn = null;
	private String driver = "org.mariadb.jdbc.Driver";
	// 資料庫位置
	private String path = "jdbc:mariadb://localhost:3307/";
	private String db = "mydb";
	private String url = path + db;
	// 使用者資料
	private String user = "root";
	private String password = "1234";

	public void setdb(String db) {
		this.db = db;
	}

	public void getdb() {
		System.out.println("資料庫名稱 : " + db);
	}

	public Connection getCon() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("連線成功");
		} catch (ClassNotFoundException e) {
			System.out.println("driver有問題");
		} catch (SQLException e) {
			System.out.println("conn有問題");
		}
		return conn;
	}
}
