package data0630;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test3 {

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
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/world?"
					+"serverTimezon=GMT&useSSL=false&"+"user=root&password=1234");
			System.out.println("連線成功");
			
		
			//String sqlstr = "insert into cmdev.dept values (" + 1000 + ", '" + "Test" + "', '" + "Taiwan" + "')";
			//String sqlstr = "insert into cmdev.dept (deptno, dname, location) values(" + 1001 + ", '" + "Test" + "', '" + "Taiwan" + "')";
			//String delstr = "delete from cmdev.dept where deptno=" +  1000 ;
			String updaterstr = "update cmdev.dept set dname='test' where deptno = '1001' ";
			
			Statement sm = conn.createStatement();
			sm.executeUpdate(updaterstr);
			System.out.println("成功");
			sm.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("連線失敗");
		}
		
	}

}
