#include<iostream>
#include <fstream>
using namespace std;
int main()
{   
	// 二進位複製
	string file_in = "D:\\image.jpg";
	string file_out = "D:\\cp.jpg";
	ifstream input(file_in , fstream::binary);
	ofstream output(file_out , fstream::binary );

	// 方法1
	istreambuf_iterator<char> ibuff(input);
	istreambuf_iterator<char> ibuff_end(nullptr);
	ostreambuf_iterator<char> obuff(output);
	while (ibuff != ibuff_end) {
		*obuff++ = *ibuff++;
	}
	// 方法2
	char c;
	do {
		input.get(c);
		output << c;
	} while (input);
	// 方法3
	output << input.rdbuf();

	input.close();
	output.close();
}