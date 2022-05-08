package javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRead {

	public static void main(String[] args) {
		Connection conn;
		String driver = "com.mysql.cj.jdbc.Driver";

		String sqlPath = "jdbc:mysql://localhost/independent_study";
		String sqlValue = "?serverTimezon=GMT&useSSL=false&";
		String url = sqlPath + sqlValue;

		String user = "root";
		String password = "1234";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("連線成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("driver有問題");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("conn有問題");
		}

	}
}
