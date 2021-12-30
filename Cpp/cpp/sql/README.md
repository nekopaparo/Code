# lib use
|SQL|lib|位置|環境設定|
|-|-|-|-|
|[MySQL](./MySQL.cpp)|.\lib\libmysql.lib<br>.\lib\libmysql.dll|.\MySQL\MySQL Server 8.0|[Visual Studio 2019](./mysqlSet.md)|


# code use
## MySQL
```cpp
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