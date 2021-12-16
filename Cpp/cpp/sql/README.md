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
	MySQL my = MySQL();

	char add[256] = " INSERT neko(id, name, tel) VALUES(1, 'cat', '0800')  ";
	my.query(add);
	char show[256] = "SELECT * FROM neko";
	my.query(show);
	char _delete[256] = "DELETE FROM neko WHERE id >= 0";
	my.query(_delete);

	system("pause");
	return 0;
}
```