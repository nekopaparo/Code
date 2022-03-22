#include<iostream>
#include<fstream>
#include<sstream>
using namespace std;
int main(int argc, char **argv)
{   
	string filepath = "D:\\data.txt";
	fstream fis(filepath);
	istringstream istr;
	string line, s;
	while (fis >> line) {
		istr.str(line);
		while (istr >> s) {
			cout << s << endl;
		}
		istr.clear();
	}
	
}