using System;
using System.Collections.Generic;
using System.Data.SqlClient;

namespace MESMachineter.Services.SQL
{
    public enum SQLKey
    {
        WHERE,
        AND, OR,
        Equal
    }
    public class MSSQLSqlBuilder : MSSQLSql
    {
        ~MSSQLSqlBuilder()
        {
            Clear();
        }

        public MSSQLSqlBuilder AddArg(string arg)
        {
            args.Add(arg);
            return this;
        }

        public MSSQLSqlBuilder AddArg(object value)
        {
            values.Add(value);
            return AddArg(string.Format("@v{0}", values.Count - 1));
        }

        // SQLKey的值
        public MSSQLSqlBuilder AddArg(SQLKey sqlKey)
        {
            string arg;
            switch (sqlKey)
            {
                case SQLKey.WHERE:
                    arg = "WHERE";
                    break;
                case SQLKey.AND:
                    arg = "AND";
                    break;
                case SQLKey.OR:
                    arg = "OR";
                    break;
                case SQLKey.Equal:
                    arg = "=";
                    break;
                default:
                    return this;
            }
            return AddArg(arg);
        }

        // 加入值
        public string AddValue(object value)
        {
            values.Add(value);
            return string.Format("@v{0}", values.Count-1);
        }
        // 加入多筆值
        public string AddValue(List<object> values)
        {
            for (int i = 0; i < values.Count; ++i)
            {
                values[i] = AddValue(values[i]);
            }
            return string.Join(",", values);
        }

        /// <WHERE> 請記得先加入WHERE => AddArg(SQLKey.WHERE)
        // 符合條件
        public MSSQLSqlBuilder AddMatch(string name, object pattern)
        {
            return AddArg(string.Format("{0} LIKE {1}", name, AddValue(pattern)));
        }
        // 查詢指定值
        public MSSQLSqlBuilder AddSearch(string name, List<object> values)
        {
            return AddArg(string.Format("{0} IN ({1})", name, AddValue(values)));
        }
        /// </WHERE>

        // 資料來源
        public MSSQLSqlBuilder AddData(List<string> names, List<string> tables)
        {
            return AddArg(string.Format("SELECT {0} FROM {1}", string.Join(",", names), string.Join(",", tables)));
        }

        // 新增資料
        public MSSQLSqlBuilder INSERT(string table , List<string> names, List<List<object>> values)
        {
            if (names != null)
            {
                args.Add(string.Format("INSERT INTO [{0}] {1} VALUES", table, string.Join(",", names)));
            }
            else
            {
                args.Add(string.Format("INSERT INTO [{0}] VALUES", table));
            }
           
            foreach (List<object> value in values)
            {
                args.Add(string.Format("({0})", AddValue(value)));
            }
            
            return this;
        }

        // 更新
        public MSSQLSqlBuilder UPDATE(string table, List<string> names, List<object> values)
        {
            List<string> sets = new List<string>();
            for (int i = 0; i < names.Count; ++i)
            {
                sets.Add(string.Format("{0} = {1}", names[i], AddValue(values[i])));
            }

            return AddArg(string.Format("UPDATE [{0}] SET", table))
                    .AddArg(string.Join(",", sets))
                        .AddArg(SQLKey.WHERE);
        }

        // 獲取SQL結果
        public SqlDataReader GetDataReader(SqlConnection connection)
        {
            try
            {
                // 輸入SQL
                SqlCommand cmd = new SqlCommand(GetSql(), connection);
                // 加入 Parameter
                for (int i = 0; i < values.Count; ++i)
                {
                    cmd.Parameters.Add(new SqlParameter(string.Format("v{0}", i), values[i]));
                }
                // 輸出結果
                return cmd?.ExecuteReader();
            }
            catch (Exception ex)
            {
                Console.WriteLine("GetDataReader Error! -> " + ex.Message);
                return null;
            }
        }

        // 送出(無資料)
        public string Execute(SqlConnection connection)
        {
            try
            {
                // 輸入SQL
                SqlCommand cmd = new SqlCommand(GetSql(), connection);
                // 加入 Parameter
                for (int i = 0; i < values.Count; ++i)
                {
                    cmd.Parameters.Add(new SqlParameter(string.Format("v{0}", i), values[i]));
                }
                // 輸出結果
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
            return "成功";
        }

        // 清除SQL
        public void Clear()
        {
            args.Clear();
            values.Clear();
        }
    }
}
