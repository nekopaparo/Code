package mariaDB;

import java.sql.*;

public class MariaDB_GetRow
{
	public static void main(String[] args)
    {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //程式參數
        String sDriver = "org.mariadb.jdbc.Driver";  //"com.mysql.jdbc.Driver"                                                  
        String url = "jdbc:mariadb://localhost:3307/mydb"; //"jdbc:mysql://localhost:3307/mydb"
        String user = "root";
        String password = "1234";
        String sql = "select num,name,address from employee"; 
             
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
                //System.out.println("建立Connection物件成功!");
                
                stmt = conn.createStatement();
                //if(stmt != null)
                    //System.out.println("建立Statement物件成功!");
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
        
        try {
             rs = stmt.executeQuery( sql ); 
             
             System.out.println("num" + "\t\t" + "name" + "\t\t" + "address");
             System.out.println("==========================================================");
             
             while(rs.next())
             { 
                 System.out.printf("%-8s\t",rs.getInt(1));
                 System.out.printf("%-10s\t",rs.getString(2));
                 System.out.printf("%-30s\n",rs.getString(3));                 
             }
        } 
        catch(SQLException e){}
        
        try 
        { 
            stmt.close(); 
            conn.close(); 
        }
        catch( SQLException e ) {}
        
        
    }
}