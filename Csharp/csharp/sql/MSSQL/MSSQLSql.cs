using System.Collections.Generic;

namespace MESMachineter.Services.SQL
{
    public abstract class MSSQLSql
    {
        public readonly List<string> args = new List<string>();
        public readonly List<object> values = new List<object>();

        public string GetSql()
        {
            return string.Join(" ", args);
        }
    }
}
