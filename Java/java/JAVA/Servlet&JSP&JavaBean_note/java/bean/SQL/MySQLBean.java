package bean.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLBean {
	private Connection conn;

	private String driver = "com.mysql.cj.jdbc.Driver";

	private String sqlPath = "jdbc:mysql://localhost/";
	private String sqlName = "independent_study";
	// 新版MySQL需要設定的參數
	private String sqlValue = "?serverTimezon=GMT&useSSL=false&";
	private String url = sqlPath + sqlValue;

	private String user = "root";
	private String password = "1234";

	public void setSQL(String sql) {
		sqlName = sql;
	}
	public void getSQL(String sql) {
		System.out.println("資料庫名稱 : " + sqlName);
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
