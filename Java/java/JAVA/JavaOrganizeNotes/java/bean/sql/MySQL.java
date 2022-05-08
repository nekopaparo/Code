package bean.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
	private Connection conn = null;
	private String driver = "com.mysql.cj.jdbc.Driver";
	// 資料庫位置
	private String path = "jdbc:mysql://localhost/";
	private String db = "world";
	// 新版MySQL需要設定的參數
	private String value = "?serverTimezon=GMT&useSSL=false&";
	private String url = path + db + value;
	// 使用者資料
	private String user = "root";
	private String password = "1234";

	public void setdb(String db) {
		this.db = db;
	}

	public void getdb() {
		System.out.println("資料庫名稱 : " + db);
	}

	// 如使用EclipseWeb，需將lib/JDBC的jar放入所使用的Apache/lib中才能使用driver
	// 不過Tomcat有內建，所以沒放也可以使用DriverManager.getConnection
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
