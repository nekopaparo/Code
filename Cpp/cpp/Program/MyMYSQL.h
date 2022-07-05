#pragma once

#ifndef MYMYSQL
#define MYMYSQL

#include <iostream>
#include <mysql.h>
#include <vector>

namespace SQL
{
	class MyMYSQL
	{
	private:

		MYSQL* mysql;

		//使用者設定
		const char* host;
		const char* user;
		const char* password;
		const char* dbName;
		//可用預設
		int port;
		const char* unix_socket;
		long client_flag;

	public:
		MyMYSQL(const char* host, const char* user, const char* password, const char* dbName, int port = 0, const char* unix_socket = (const char*)0, long client_flag = 0L);
		~MyMYSQL();
		// user data
		void setUserData(const char* host, const char* user, const char* password, const char* dbName, int port = 0, const char* unix_socket = (const char*)0, long client_flag = 0L);
		// load connect
		void loadConnect();
		//查詢
		MYSQL_RES* query(const char* sql);
		// res to table[row][column]
		std::vector<std::vector<std::string>*>* resToTable(MYSQL_RES* res); // 將結果用string另外儲存
		std::vector<std::vector<char*>*>* resToTable_ctrp(MYSQL_RES* res); // 表個內容指向資料(char*)，不能使用mysql_free_result(res)資料會被清除，需事後使用
		void resToTable_cmd(MYSQL_RES* res); // 輸出到cmd上
	};
}
#endif // MyMYSQL