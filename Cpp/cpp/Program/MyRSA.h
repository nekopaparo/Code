#pragma once

#ifndef MYRSA_H
#define MYRSA_H

#include <vector>
#include <ctime>
#include <fstream>

#define MAX_PRIME_SIZE 1000

namespace MyRSA
{
	struct PublicKey
	{
		unsigned int N;
		unsigned int e;
	};
	struct PrivateKey
	{
		unsigned int N;
		unsigned int d;
	};
	struct Key
	{
		PublicKey* publicKey;
		PrivateKey* privateKey;
	};

	class RSA
	{
	private:
		// 質數表
		static std::vector<unsigned int>* PrimeTable;
		void createPrimeTable();
		unsigned int getRandPrime();
		// 密鑰生成
		void keyGeneration();
		void keyDistribution(unsigned int N, unsigned int r);
		unsigned int getCoprimeE(unsigned int r);
		unsigned int modularArithmetic(unsigned int e, unsigned int r);
		// 數學
		unsigned int gcd(unsigned int a, unsigned int b);
		unsigned int lcm(unsigned int a, unsigned int b);
	public:
		Key* key;
		std::vector<unsigned int>* uiMessage;

		RSA();
		~RSA();

		void savePublicKey(char* filename);
		void savePrivateKey(char* filename);
		void readPublicKey(char* filename);
		void readPrivateKey(char* filename);
	};
	// string < = > unsigned int[]
	void stringToVUI(const char* str, std::vector<unsigned int>& uiMessages);
	std::string vUIToString(std::vector<unsigned int>& uiMessages);
	// 加/解密
	void encryption(std::vector<unsigned int>& uiMessages, PublicKey& key);
	void decryption(std::vector<unsigned int>& uiMessages, PrivateKey& key);
	unsigned int cryption(unsigned int base, unsigned int power, unsigned int N);
	// file
	void readFile(std::string filename, std::vector<unsigned int>& uiMessages);
	void writeFile(std::string filename, std::vector<unsigned int>& uiMessages);
	bool binNameCheck(std::string filename);
}

#endif // !MYRSA_H