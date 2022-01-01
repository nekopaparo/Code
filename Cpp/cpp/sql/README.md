# lib use
|SQL|use|include|lib|位置|環境設定|
|-|-|-|-|-|-|
|[MySQL](./MySQL.cpp)|libmysql.h<br>libmysql.lib<br>libmysql.dll|.\include\\*|.\lib\\*|.\MySQL\MySQL Server 8.0|[Visual Studio 2019](./mysqlSet.md)|
|[SQLite](./MySQLite.cpp)|sqlite3.h<br>[sqlite3.lib](.)<br>sqlite3.dll|sqlite-tools-win32-x86-xxxxxxx.zip|sqlite-dll-win64-x64-xxxxxxx.zip|[download (Windows)](https://sqlite.org/download.html)|同上|


# code use
## MySQL
```cpp
#include <iostream>
#include "MySQL.cpp"

int main()
{
	sql::MySQL my;

	const char* add = " INSERT neko(id, name, tel) VALUES(1, 'cat2222', '0800')  ";
	my.query(add);
	const char* show = "SELECT * FROM neko";
	my.showResult(show);
	const char* _delete = "DELETE FROM neko WHERE id >= 0";
	my.query(_delete);

	system("pause");
	return 0;
}
```
## SQLite
```cpp
#include <iostream>
#include "MySQLite.h"

int main()
{
	sql::MySQLite my;

	const char* createTable = "CREATE TABLE neko("	\
		  "ID	INT  KEY, "	\
		  "Name	CHAR(20) UNIQUE NOT NULL, "	\
		  "Sex	VARCHAR(20) )";
	my.query(createTable);
	const char* add = "INSERT INTO neko(ID, Name) "	\
					  "VALUES (1, 'cat1'), (2, 'cat2'), (3, 'cat3');";
	my.query(add);
	const char* show = "SELECT * FROM neko";
	my.showResult(show);
	const char* _delete = "DELETE FROM neko WHERE ID >= 0";
	my.query(_delete);

	std::system("pause");
	return 0;
}
```