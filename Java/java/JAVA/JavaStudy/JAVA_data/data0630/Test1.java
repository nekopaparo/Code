package data0630;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MYSQL Driver is OK");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("MYSQL Driver is not OK");
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/independent_study?"
					+"serverTimezon=GMT&useSSL=false&"+"user=root&password=1234");
			System.out.println("連線成功");
			
			Statement sm = conn.createStatement();
			//查詢
			ResultSet rs = sm.executeQuery("select * from user");
			ResultSetMetaData rsmd = rs.getMetaData();
			//從1開始，getColumnCount()取得欄位
			for(int i=1; i<=rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.print("\n=======================================\n");
			while(rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print("\n");
			}
			sm.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("連線失敗");
		}
		
	}

}
