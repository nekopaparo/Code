package bean.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBBean {
	private Connection conn;
	private String driver = "org.mariadb.jdbc.Driver";
	private String url = "jdbc:mariadb://localhost:3307/";

	private String dbName = "mydb";
	private String user = "root";
	private String password = "1234";
	
	public void setdb(String db) {
		dbName = db;
	}
	public void getdb() {
		System.out.println("資料庫名稱 : " + dbName);
	}
	public Connection getCon() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url + dbName, user, password);
			System.out.println("連線成功");
		} catch (ClassNotFoundException e) {
			System.out.println("driver有問題");
		} catch (SQLException e) {
			System.out.println("conn有問題");
		}
		return conn;
	}
}
