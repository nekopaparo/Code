# lib use
|SQL|JDBC||
|-|-|-|
|[MariaDB](./MariaDB.java)|mariadb-java-client|[download](https://mariadb.com/downloads/connectors/connectors-data-access/java8-connector/)|
|[MySQL](./MySQL.java)|mysql-connector-java|.\MySQL\Connector J 8.0|
|[SQLite](./SQLite.java)|sqlite-jdbc |[download](https://github.com/xerial/sqlite-jdbc/releases)|

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