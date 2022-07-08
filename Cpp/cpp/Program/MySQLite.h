#pragma once

#ifndef MYSQLITE
#define MYSQLITE

#include <iostream>
#include <vector>
#include <sqlite3.h>

namespace SQL
{
	class MySQLite
	{
	public:
		const char* dbPath;
		sqlite3* sqlite;
		sqlite3_stmt* stmt;

		MySQLite(const char* dbPath);
		~MySQLite();
		
		void loadConnect();
		void dispose();
		// sqlite3_exec
		std::vector<std::vector<std::string>>* query(const char* sql);
		void query_cmd(const char* sql);
		// sqlite3_prepare_v2
		std::vector<std::vector<std::string>>* query_v2(const char* sql);
		void query_v2_cmd(const char* sql);

	private:
		static int callback_ToTable(void* data, int argc, char** argv, char** azColName);
		static int callback_cmd(void* data, int argc, char** argv, char** azColName);
	};
}
#endif // !MYSQLITE