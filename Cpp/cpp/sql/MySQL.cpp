#include <iostream>
#include <mysql.h>
using namespace std;
class MySQL {
private:
	MYSQL* mysql;
	//�ϥΪ̳]�w
	char host[256] = "localhost";
	char user[256] = "root";
	char password[256] = "1234";
	char dbName[256] = "world";

	//�i�ιw�]
	int port = 0;
	char unix_socket[256] = { NULL };
	long client_flag = 0;
public:
	MySQL() {
		mysql = new MYSQL;
		if (mysql_init(mysql) == 0){
			cout << mysql_error(mysql) << endl;
		}
		else{
			mysql_set_character_set(mysql, "utf8");
			//���Jconnect
			if (mysql_real_connect(mysql, host, user, password, dbName, port, unix_socket, client_flag) == 0) {
				cout << mysql_error(mysql) << endl;
			}
			else {
				cout << "���\���J��Ʈw" << endl;
			}
		}
	}
	// mysql_real_query(mysql, sql, (unsigned int)strlen(sql)) & mysql_query(mysql, sql)
	// mysql_real_query() is faster than mysql_query()
	// mysql_query() cannot use binary data;
	bool query(char* sql) {
		//sql
		if (mysql_real_query(mysql, sql, (unsigned int)strlen(sql)) != 0) {
			cout << "ERROR:sql -> " << mysql_error(mysql) << endl;
			return false;
		}
		//���G result
		MYSQL_RES* res = mysql_store_result(mysql);
		if (res == 0) return true; //�L��X���G
		int column = mysql_num_fields(res);
		//���D
		for (int index = 0; index < column; index++)
		{
			cout << mysql_fetch_field(res)->name << "\t";
		}
		cout << endl;
		//���e
		MYSQL_ROW row;
		unsigned long* values_length;
		int index;
		while (row = mysql_fetch_row(res)) {
			values_length = mysql_fetch_lengths(res);
			for (index = 0; index < column; index++)
			{
				//row[index] = NULL�ɡA�|���XERROR�L�k���X
				//�Q�έȪ����רӱư��ŭ�(NULL) https://dev.mysql.com/doc/c-api/8.0/en/mysql-fetch-row.html
				if (values_length[index]) {
					cout << row[index] << "\t";
				}
				else {
					cout << "NULL\t";
				}
			}
			cout << endl;
		}
		//clean
		row = 0;
		mysql_free_result(res);

		return true;
	}
	MYSQL* getConn() { return mysql; }
};