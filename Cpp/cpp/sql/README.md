# lib use
|SQL||||
|-|-|-|-|
|[MySQL](./MySQL.java)|.\lib\libmysql.lib<br>.\lib\libmysql.dll|.\MySQL\MySQL Server 8.0|[環境設定(Visual Studio 2019)](./mysqlSet.md)|


# code use
## MySQL
```java
MySQL mysql = new MySQL();
		
String add = "INSERT neko(id, name, tel) VALUES(1, 'cat', '0800')";
mysql.executeUpdate(add);
String show = "SELECT * FROM neko";
mysql.executeQuery(show);
String delete = "DELETE FROM neko WHERE id >= 0";
mysql.executeUpdate(delete);
```