using MySql.Data.MySqlClient;
using System;

namespace sql
{
    class MySQL
    {
        private string dbHost = "localhost";
        private string dbUser = "root";
        private string dbPass = "1234";
        private string dbName = "world";
        private string url;
        private MySqlConnection conn = null;

        public MySQL()
        {
            // 如果有特殊的編碼在database後面請加上;CharSet=編碼, utf8請使用utf8_general_ci
            url = "server=" + dbHost + ";uid=" + dbUser + ";pwd=" + dbPass + ";database=" + dbName;
            conn = new MySqlConnection(url);

            // 連線到資料庫
            try
            {
                if (conn.State != System.Data.ConnectionState.Open)
                {
                    conn.Open();
                    Console.WriteLine("成功連線到資料庫");
                }
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                switch (ex.Number)
                {
                    case 0:
                        Console.WriteLine("無法連線到資料庫");
                        break;
                    case 1045:
                        Console.WriteLine("使用者帳號或密碼錯誤");
                        break;
                }
            }
        }

        public MySqlConnection getConn() { return conn; }
        //可讀出可寫入
        public void Reader(string sql)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(sql, conn);
                MySqlDataReader data = cmd.ExecuteReader();
                if (!data.HasRows)
                {
                    // 如果沒有資料,顯示沒有資料的訊息
                    Console.WriteLine("No data.");
                }
                else
                {
                    // 標題
                    for (int i = 0; i < data.GetSchemaTable().Rows.Count; i++)
                    {
                        Console.Write(data.GetName(i) + "\t");
                    }
                    Console.WriteLine();
                    // 內容
                    while (data.Read())
                    {
                        for (int i = 0; i < data.GetSchemaTable().Rows.Count; i++)
                        {
                            if (!data.IsDBNull(i))
                            {
                                Console.Write(data.GetString(i) + "\t");
                            }
                            else
                            {
                                Console.Write("null\t");
                            }
                        }
                        Console.WriteLine();
                    }
                }
                data.Close();
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                Console.WriteLine("Error " + ex.Number + " : " + ex.Message);
            }
            catch (System.InvalidOperationException)
            {
                Console.WriteLine("連線位置錯誤, Error:( " + url + " )");
            }
            catch (System.ArgumentException)
            {
                Console.WriteLine("SQL錯誤, Error:( " + sql + " )");
            }
        }
        //只可以寫入
        public void Execute(string sql)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(sql, conn);
                switch (cmd.ExecuteNonQuery())
                {
                    case 0:
                        Console.WriteLine("寫入失敗");
                        break;
                    case 1:
                        Console.WriteLine("成功寫入");
                        break;
                }
            }
            catch (MySql.Data.MySqlClient.MySqlException ex)
            {
                Console.Write("新增失敗 -> ");
                switch (ex.Number)
                {
                    case 1062:
                        Console.WriteLine("key已存在");
                        break;
                    case 1146:
                        Console.WriteLine("資料表不存在");
                        break;
                }
            }
        }
    }
}
