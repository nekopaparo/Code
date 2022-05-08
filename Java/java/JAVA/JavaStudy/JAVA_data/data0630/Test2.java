package data0630;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("SQL Server Driver is OK");
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL Server Driver is Not OK");
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver:\\localhost\\sqlexpress;"
					+"user=neko;password=1234;database=ch2_db;");
			System.out.println("SQL 連線成功");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 不連線成功");
		}
	}

}
