#include "MySQLite.h"

/*
const char* tableName =
		"SELECT name FROM sqlite_schema "
		"WHERE type = 'table' "
		"ORDER BY name;";
*/

SQL::MySQLite::MySQLite(const char* dbPath)
{
	this->dbPath = dbPath;
	sqlite = nullptr;
	stmt = nullptr;
}
SQL::MySQLite::~MySQLite()
{
	dispose();
}

void SQL::MySQLite::loadConnect()
{
	if (sqlite3_open(dbPath, &sqlite) != SQLITE_OK)
	{
		std::cout << sqlite3_errmsg(sqlite) << std::endl;
	}
}
void SQL::MySQLite::dispose()
{
	if (sqlite != nullptr)
		sqlite3_close(sqlite);
	if (stmt != nullptr)
		sqlite3_finalize(stmt);
}
// sqlite3_exec
std::vector<std::vector<std::string>>* SQL::MySQLite::query(const char* sql)
{
	std::vector<std::vector<std::string>>* table = new std::vector<std::vector<std::string>>();
	if (sqlite3_exec(sqlite, sql, callback_ToTable, (void*)table, nullptr) != SQLITE_OK)
	{
		std::cout << sqlite3_errmsg(sqlite) << std::endl;
		return nullptr;
	}
	else
	{
		return table;
	}
}
void SQL::MySQLite::query_cmd(const char* sql)
{
	if (sqlite3_exec(sqlite, sql, callback_cmd, 0, nullptr) != SQLITE_OK)
	{
		std::cout << sqlite3_errmsg(sqlite) << std::endl;
	}
}
// sqlite3_prepare_v2
std::vector<std::vector<std::string>>* SQL::MySQLite::query_v2(const char* sql)
{
	if (sqlite3_prepare_v2(sqlite, sql, -1, &stmt, NULL) != SQLITE_OK)
	{
		std::cout << sqlite3_errmsg(sqlite) << std::endl;
		return nullptr;
	}
	else
	{
		std::vector<std::vector<std::string>>* table = new std::vector<std::vector<std::string>>();
		// column name
		std::vector<std::string>* colName = new std::vector<std::string>();
		for (int i = 0; i < sqlite3_column_count(stmt); ++i)
		{
			colName->push_back(sqlite3_column_name(stmt, i));
		}
		table->push_back(*colName);
		// column value
		std::vector<std::string>* row;
		const unsigned char* value;
		while (sqlite3_step(stmt) == SQLITE_ROW)
		{
			row = new std::vector<std::string>();
			for (int i = 0; i < sqlite3_column_count(stmt); ++i)
			{
				value = sqlite3_column_text(stmt, i);
				if (value != nullptr)
				{
					row->push_back(reinterpret_cast<const char*>(value));
				}
				else
				{
					row->push_back("NULL");
				}
			}
			table->push_back(*row);
		}
		return table;
	}
}
void SQL::MySQLite::query_v2_cmd(const char* sql)
{
	if (sqlite3_prepare_v2(sqlite, sql, -1, &stmt, NULL) != SQLITE_OK)
	{
		std::cout << sqlite3_errmsg(sqlite) << std::endl;
	}
	else
	{
		// column name
		for (int i = 0; i < sqlite3_column_count(stmt); ++i)
		{
			std::cout << sqlite3_column_name(stmt, i) << "\t";
		}
		std::cout << std::endl;
		sqlite3_value* value;
		while (sqlite3_step(stmt) == SQLITE_ROW)
		{
			for (int i = 0; i < sqlite3_column_count(stmt); ++i)
			{
				value = sqlite3_column_value(stmt, i);
				if (sqlite3_value_text(value) != nullptr)
				{
					std::cout << sqlite3_value_text(value) << "\t";
				}
				else
				{
					std::cout << "NULL\t";
				}
			}
			std::cout << std::endl;
		}
	}
}

int SQL::MySQLite::callback_ToTable(void* data, int argc, char** argv, char** azColName)
{
	std::vector<std::vector<std::string>>* table = (std::vector<std::vector<std::string>>*)data;
	// column name
	if (table->empty())
	{
		std::vector<std::string>* colName = new std::vector<std::string>();
		for (size_t i = 0; i < argc; ++i)
		{
			colName->push_back(azColName[i]);
		}
		table->push_back(*colName);
	}
	// column value
	std::vector<std::string>* value = new std::vector<std::string>();
	for (size_t i = 0; i < argc; ++i)
	{
		if (argv[i] != NULL)
		{
			value->push_back(argv[i]);
		}
		else
		{
			value->push_back("NULL");
		}
	}
	table->push_back(*value);
	return 0;
}
int SQL::MySQLite::callback_cmd(void* data, int argc, char** argv, char** azColName)
{
	for (size_t index = 0; index < argc; ++index)
	{
		printf("%s : %s\n", azColName[index], argv[index]);
	}
	std::cout << std::endl;
	return 0;
}