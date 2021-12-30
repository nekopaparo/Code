#include "MySQL.h"
#include <iostream>

using namespace sql;

MYSQL_RES* result;
MYSQL_ROW row;
int column;
int index;
unsigned long* values_length;

MySQL::MySQL() {
	db = new MYSQL;
	//載入connect
	if (mysql_init(db) == 0 || mysql_real_connect(db, host, user, password, dbName, port, unix_socket, client_flag) == 0) {
		std::cout << mysql_error(db) << std::endl;
	}
	else {
		mysql_set_character_set(db, "utf8");
		std::cout << "成功載入資料庫" << std::endl;
	}
}
MySQL::~MySQL() {
	//關閉db
	if (db) {
		mysql_close(db);
	}
}
// mysql_real_query(mysql, sql, (unsigned int)strlen(sql)) & mysql_query(mysql, sql)
// mysql_real_query() is faster than mysql_query()
// mysql_query() cannot use binary data;
bool MySQL::query(const char* sql) {
	if (mysql_real_query(db, sql, (unsigned int)strlen(sql)) != 0) {
		std::cout << "query_sql_err -> " << mysql_error(db) << std::endl;
		return false;
	}
	return true;
}
bool MySQL::showResult(const char* sql) {
	if (!query(sql)) return false;
	//結果 result
	result = mysql_store_result(db);
	if (result != 0) {
		//column
		column = mysql_num_fields(result);
		//標題
		for (int index = 0; index < column; index++){
			std::cout << mysql_fetch_field(result)->name << "\t";
		}
		std::cout << std::endl;
		//內容
		while (row = mysql_fetch_row(result)) {
			//取得每個資料欄(值)的長度
			values_length = mysql_fetch_lengths(result);
			for (index = 0; index < column; index++)
			{
				//row[index] = NULL時，會跳出ERROR無法取出
				//利用值的長度來排除空值(NULL) https://dev.mysql.com/doc/c-api/8.0/en/mysql-fetch-row.html
				if (values_length[index]) {
					std::cout << row[index] << "\t";
				}
				else {
					std::cout << "NULL\t";
				}
			}
			std::cout << std::endl;
		}
		//clean
		row = 0;
		mysql_free_result(result);
	}
	return true;
}
MYSQL* MySQL::getConn() { return db; }