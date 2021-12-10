# lib use
|SQL|||
|-|-|-|
|[MySQL](./MySQL.cs)|MySql.Data.dll|.\MySQL\Connector NET 8.0\Assemblies\\*|

# code use
## MySQL
```csharp
using sql;
MySQL mysql = new MySQL();

string ADD = "INSERT neko(id, name, tel) "+
             "VALUES (1, 'cat', '0800')";
mysql.Execute(ADD);
string show = "SELECT * FROM neko";
mysql.Reader(show);
string delete = "DELETE FROM neko WHERE id >= 0";
mysql.Execute(delete);
```