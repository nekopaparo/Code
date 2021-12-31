#pragma once
#include <mysql.h>
namespace sql {
	class MySQL {
	public:
		MySQL();
		~MySQL(); //-> 解構子...結束後執行
		bool query(const char* sql);
		MYSQL* getConn();
		bool showResult(const char* sql);
	private:
		MYSQL* db;
		//使用者設定
		const char* host = "localhost";
		const char* user = "root";
		const char* password = "1234";
		const char* dbName = "world";
		//可用預設
		int port = 0;
		const char* unix_socket = NULL;
		long client_flag = 0;
	};
}