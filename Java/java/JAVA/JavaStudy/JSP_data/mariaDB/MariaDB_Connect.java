package mariaDB;

import java.sql.*;

public class MariaDB_Connect {
	public static void main(String[] args)
    {
        Connection conn = null;
        Statement stmt = null;
        //程式參數
        
        //使用tomcat自己的mysql-connector
        String sDriver = "com.mysql.jdbc.Driver";  //MySQL: com.mysql.jdbc.Driver
        String url = "jdbc:mysql://localhost:3307/mydb";
        //使用mariadb的jdbc Driver
        //String sDriver = "org.mariadb.jdbc.Driver";                                             
        //String url = "jdbc:mariadb://localhost:3307/mydb";  //default port:3306
        String user = "root";
        String password = "1234";
      
        try   //載入JDBC driver 
        {     
            Class.forName(sDriver);
        }
        catch(Exception e)
        {
            System.out.println("無法載入驅動程式");
            return;
        }
       
        try   //建立資料連結和Statement物件
        {
            conn = DriverManager.getConnection(url,user,password);
            if(conn != null)
            {
                System.out.println("建立Connection物件成功!");
                
                stmt = conn.createStatement();
                if(stmt != null)
                    System.out.println("建立Statement物件成功!");
            }
        }
        catch(SQLException e)
        {
            System.out.println("與資料來源連結錯誤: " + conn);
            System.out.println(e.getMessage());
            
            if(conn != null)
            {
                try { conn.close(); }
                catch( SQLException e2 ) {}
            }
            return;
        }
        finally
        {
            try 
            { 
                stmt.close(); 
                conn.close(); 
            }
            catch( SQLException e ) {}
        }
    }
}
