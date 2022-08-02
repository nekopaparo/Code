/// https://www.delftstack.com/zh-tw/howto/csharp/connect-to-sql-database-from-csharp/
/// https://stackoverflow.com/questions/25739788/select-query-to-get-data-from-sql-server
using System;
using System.Data.SqlClient;

namespace SQL
{
    class MSSQL
    {
        public MSSQL()
        {
            // The server's name
            string DataSource = "NEKOMIMIRO\\SQLEXPRESS";

            // The name of the database
            string InitialCatalog = "FarmProductHTML";

            // Windows 驗證
            string IntegratedSecurity = "SSPI";

            // SQL Server 驗證
            string UserID = "root";
            string Password = "1234";
            
            // url
            string connectionString = "Data Source = " + DataSource
                                    + "; Initial Catalog = " + InitialCatalog
                                    /// (擇一)
                                    //+ "; Integrated Security = " + IntegratedSecurity
                                    + "; User ID = " + UserID
                                    + "; Password = " + Password
                                    /// END
                                    ;

            // 使用資料庫
            SqlConnection connection = null;
            try
            {
                // 載入 Connection
                connection = new SqlConnection(connectionString);
                connection.Open();
                Console.WriteLine("The database has been opened!");
                Console.WriteLine("Connection State: " + connection.State.ToString());

                // 查詢 Query
                SqlCommand command = new SqlCommand("SELECT * FROM FPHProductDataVIEW", connection);
                int result = command.ExecuteNonQuery();
                using (SqlDataReader reader = command.ExecuteReader())
                {
                    // Name
                    for (int i = 0; i < reader.FieldCount; i += 2)
                    {
                        Console.Write(String.Format("{0}\t", reader.GetName(i)));
                    }
                    Console.WriteLine();
                    // Value
                    while (reader.Read())
                    {
                        for (int i = 0; i < reader.FieldCount; i += 2)
                        {
                            Console.Write(String.Format("{0}\t", reader.GetValue(i)));
                        }
                        Console.WriteLine();
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("There's an error connecting to the database!\n" + ex.Message);
            }
            finally
            {
                if (connection != null)
                {
                    if (connection.State == System.Data.ConnectionState.Open)
                    {
                        connection.Close();
                        Console.WriteLine("The database has been closed!");

                        connection.Dispose();
                        Console.WriteLine("The database connection has been disposed!");
                        Console.WriteLine("Connection State: " + connection.State.ToString());
                    }
                    connection = null;
                }
            }
            Console.WriteLine("END");
            Console.ReadLine();
        }
    }
}
