#include<iostream>
#include <fstream>
using namespace std;
int main()
{   
	string filepath = "D:\\data.txt";

	// 讀檔
	ifstream f_read(filepath); // = fstream f_read(file_read, fstream::in);
	if (f_read.good()) { // 開啟成功 = 1
		// 讀到空白
		string s;
		while (f_read >> s) {
			cout << s << endl;
		}
		// 讀字元
		char c;
		while (f_read.get(c)) {
			cout << c;
		}
	}
	f_read.close();

	// 寫檔 app -> 從後面開始寫入
	ofstream f_write(filepath, fstream::app); // = stream write(file_write, fstream::out, fstream::app);
	
	string data = "\n123456 44 53";
	// 方法1
	f_write << data;
	// 方法2
	f_write.write(data.c_str(), data.length());
	
	f_write.close();

	// 二進位複製(圖片複製)
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