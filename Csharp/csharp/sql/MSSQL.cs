using System;
using System.Data.SqlClient;

namespace FarmProductHTML.Services
{
    public class MSSQL
    {
        // The server's name
        private string DataSource = "NEKOMIMIRO\\SQLEXPRESS";

        // The name of the database
        private string InitialCatalog = "FarmProductHTML";

        // Windows 驗證
        private string IntegratedSecurity = "SSPI";

        // SQL Server 驗證
        private string UserID = "root";
        private string Password = "1234";

        private SqlConnection connection = null;

        public MSSQL()
        {
            // url
            string connectionString = "Data Source = " + DataSource
                                    + "; Initial Catalog = " + InitialCatalog
                                    /// (擇一)
                                    //+ "; Integrated Security = " + IntegratedSecurity
                                    + "; User ID = " + UserID
                                    + "; Password = " + Password
                                    /// END
                                    ;
            try
            {
                // 載入 Connection
                connection = new SqlConnection(connectionString);
                connection.Open();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Open Error! -> " + ex.Message);
            }
        }
        ~MSSQL()
        {
            Dispose();
        }
        public void Dispose()
        {
            if (connection != null)
            {
                if (connection.State == System.Data.ConnectionState.Open)
                {
                    connection.Close();
                    connection.Dispose();
                }
                connection = null;
            }
        }

        public SqlCommand GetCommand(string sql)
        {
            try
            {
                return new SqlCommand(sql, connection);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Command Error! -> " + ex.Message);
                return null;
            }
        }
        // 加入 Parameter
        public static void AddParm(SqlCommand cmd, string parmName, object parmValues)
        {
            cmd.Parameters.Add(new SqlParameter(parmName, parmValues));
        }
        public static void AddParm(SqlCommand cmd, string parmName, System.Data.SqlDbType type, object parmValue)
        {
            cmd.Parameters.Add(parmName, type).Value = parmValue;
        }
        // 取得資料
        public SqlDataReader GetDataReader(SqlCommand cmd)
        {
            try
            {
                return cmd?.ExecuteReader();
            }
            catch (Exception ex)
            {
                Console.WriteLine("DataReader Error! -> " + ex.Message);
                return null;
            }
        }
        // 查詢
        public SqlDataReader Query(string sql)
        {
            return GetCommand(sql)?.ExecuteReader();
        }
    }
}
