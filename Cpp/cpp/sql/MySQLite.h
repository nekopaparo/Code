#pragma once
#include <sqlite3.h>
namespace sql {
	class MySQLite {
	public:
		MySQLite();
		~MySQLite(); //-> 解構子...結束後執行
		static int callback(void* NotUsed, int argc, char** argv, char** azColName);
		bool query(const char* sql);
		bool query_callback(const char* sql);
		bool query_v2(const char* sql);
		bool showResult(const char* sql);
	private:
		const char* path;
		sqlite3* db;
		char* zErrMsg = 0;

		sqlite3_stmt* stmt = NULL;
		int column = 0;
		const unsigned char* value;
	};
}