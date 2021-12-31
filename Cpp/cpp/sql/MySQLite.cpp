#include "MySQLite.h"
#include <iostream>

using namespace sql;

MySQLite::MySQLite() {
	path = ".\\test.db";
	//sqlite3_open_v2(path, &db, SQLITE_OPEN_READWRITE | SQLITE_OPEN_CREATE | SQLITE_OPEN_NOMUTEX | SQLITE_OPEN_SHAREDCACHE, NULL);
	if (sqlite3_open(path, &db) == SQLITE_OK) {
		std::cout << "Opened database successfully" << std::endl;
	}
	else {
		std::cout << "Can't open database: " << std::endl;
		std::cout << sqlite3_errmsg(db) << std::endl;
	}
}

MySQLite::~MySQLite() {
	if (db) {
		sqlite3_close(db);
		//sqlite3_close_v2(db);
	}
}

int MySQLite::callback(void* NotUsed, int argc, char** argv, char** azColName)
{
	int i;
	std::cout << argc << std::endl;
	for (i = 0; i < argc; i++) {
		printf("%s = %s\n", azColName[i], argv[i] ? argv[i] : "NULL");
	}
	printf("\n");
	return 0;
}

bool MySQLite::query(const char* sql)
{
	if (!db) return false;
	if (sqlite3_exec(db, sql, 0, 0, &zErrMsg) == SQLITE_OK) {
		std::cout << "query successfully\n";
	}
	else {
		std::cout << "SQL error: " << zErrMsg << std::endl;
		sqlite3_free(zErrMsg);
		return false;
	}
	return true;
}

bool sql::MySQLite::query_callback(const char* sql)
{
	if (!db) return false;
	if (sqlite3_exec(db, sql, 0, callback, &zErrMsg) == SQLITE_OK) {
		std::cout << "query_callback successfully\n";
	}
	else {
		std::cout << "SQL error: " << zErrMsg << std::endl;
		sqlite3_free(zErrMsg);
		return false;
	}
	return true;
}

bool sql::MySQLite::query_v2(const char* sql)
{
	if (!db) return false;
	if (sqlite3_prepare_v2(db, sql, -1, &stmt, NULL) == SQLITE_OK) {
		std::cout << "query_callback successfully\n";
	}
	else {
		std::cout << "SQL error: " << zErrMsg << std::endl;
		sqlite3_free(zErrMsg);
		return false;
	}
	return true;
}

bool sql::MySQLite::showResult(const char* sql)
{
	if (query_v2(sql)) {
		//標題
		column = sqlite3_column_count(stmt);
		for (int i = 0; i < column; i++) {
			std::cout << sqlite3_column_name(stmt, i) << "\t";
		}
		std::cout << std::endl;
		//內容
		while (sqlite3_step(stmt) == SQLITE_ROW) {
			for (int i = 0; i < column; i++) {
				value = sqlite3_column_text(stmt, i);
				//排除空值
				if (value) {
					std::cout << value << "\t";
				}
				else {
					std::cout << "NULL\t";
				}
			}
			std::cout << std::endl;
		}
	}
	else {
		std::cout << "sql error" << std::endl;
	}
	//clear
	sqlite3_finalize(stmt);

	return true;
}
