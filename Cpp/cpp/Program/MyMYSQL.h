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

		//�ϥΪ̳]�w
		const char* host;
		const char* user;
		const char* password;
		const char* dbName;
		//�i�ιw�]
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
		//�d��
		MYSQL_RES* query(const char* sql);
		// res to table[row][column]
		std::vector<std::vector<std::string>*>* resToTable(MYSQL_RES* res); // �N���G��string�t�~�x�s
		std::vector<std::vector<char*>*>* resToTable_ctrp(MYSQL_RES* res); // ��Ӥ��e���V���(char*)�A����ϥ�mysql_free_result(res)��Ʒ|�Q�M���A�ݨƫ�ϥ�
		void resToTable_cmd(MYSQL_RES* res); // ��X��cmd�W
	};
}
#endif // MyMYSQL