package base.bean.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	// 如使用EclipseWeb，需將lib/JDBC的jar放入所使用的Apache/lib中才能使用driver
	// 不過Tomcat有內建，所以沒放也可以使用DriverManager.getConnection
	MySQL() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("連線成功");
		} catch (ClassNotFoundException e) {
			System.out.println("driver有問題");
		} catch (SQLException e) {
			System.out.println("conn有問題");
		}
	}
	public void setdb(String db) {
		this.db = db;
	}

	public void getdb() {
		System.out.println("資料庫名稱 : " + db);
	}

	public Connection getCon() { return conn; }

	// 輸出
	public void executeQuery(String sql) {
		try {
			Statement sm = conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);

			// 標題
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			for (int i = 1; i < column; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println();
			// 內容
			while (rs.next()) {
				for (int i = 1; i < column; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("輸出失敗");
			e.printStackTrace();
		}

	}

	// 輸入
	public void executeUpdate(String sql) {
		try {
			Statement sm = conn.createStatement();
			switch (sm.executeUpdate(sql)) {
			case 0:
				System.out.println("輸入失敗");
				break;
			case 1:
				System.out.println("輸入成功");
				break;
			}
		} catch (SQLException e) {
			System.out.println("輸入失敗");
			e.printStackTrace();
		}

	}
}
