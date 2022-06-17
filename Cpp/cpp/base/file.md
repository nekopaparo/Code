## 檔案
|[fstream](#fstream)|[sstream](#sstream)|
|-|-|
### FILE
> 讀寫
```cpp
#include <iostream>
#define FILE_PATH "D:\\file.txt"
#define OUTPUT "D:\\output.txt"
using namespace std;
int main(void)
{
// 讀檔
    FILE *fr;
    fr = fopen(FILE_PATH , "r");
    if(fr == NULL)
    {  cout << "File not found.\n"; }
    else
    {
        char c[100];
        int i=1;
        while (fgets(c, 99, fr) != NULL)
        {
            printf("%d\t%s", i++, c);
        }
        /*
        while (fgets(c, 99, fr))
        {
            if (feof(fr) != 0) break;
            printf("%d\t%s", i++, c);
        }
        */
    }
    fclose(fr);
// 寫檔
    FILE *fw;
    // w -> 覆蓋, a -> 接續寫入
    fw = fopen(OUTPUT, "w"); 
    // 寫入檔案
    fputs("test\n", fw);
    // 指定形式寫入
    fprintf(fw, "%s%d\n", "nekopapa use c", 8763);
    fclose(fw);

    return 0;
}

```
> 圖片複製 (二進位檔)
```cpp
#include <iostream>
#define IMG_PATH "D:\\img.jpg"
#define OUTPUT "D:\\cp.jpg"
using namespace std;
int main()
{
    FILE *fr;
    FILE *fw;
    short buf[256];
    fr = fopen(IMG_PATH, "rb");
    if(fr == NULL)
    {
        cout << "File not found.\n";
    }
    else
    {
        fw = fopen(OUTPUT, "wb"); //ab
        while(1)
        {
            //(緩衝區, 讀/寫基本單位(byte), 讀/寫次數, 檔案)
            fread(buf, sizeof(short), 256, fr);
            //sizeof(short)=2byte，緩衝區大小=256*2=512
            fwrite(buf, sizeof(short), 256, fw);
            if(feof(fr)) break;
        }
        fclose(fw);
    }
    fclose(fr);

    return 0;
}
```
### fstream
> 讀寫
```cpp
#include <iostream>
#include <fstream>
#define FILE_PATH "D:\\data.txt"
using namespace std;
int main()
{   
// 讀檔
	ifstream f_read(FILE_PATH); 
    // = fstream f_read(file_read, fstream::in);
	if (f_read.good()) // 開啟成功 = 1
    {
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

// 寫檔
    // app -> 從後面開始寫入
	ofstream f_write(FILE_PATH, fstream::app); 
    // = stream write(file_write, fstream::out, fstream::app);
	
	string data = "Hello Cpp fstram write.\n";
	// 方法1
	f_write << data;
	// 方法2
	f_write.write(data.c_str(), data.length());
	
	f_write.close();

    return 0;
}
```
> 二進位複製 (圖片複製)
```cpp
#include <iostream>
#include <fstream>
using namespace std;
int main()
{
	string file_in = "D:\\img.jpg";
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
```
### sstream
```cpp
#include<iostream>
#include<fstream>
#include<sstream>
#define FILE_PATH "D:\\data.txt"
using namespace std;
int main (int argc, char **argv)
{
	fstream fs(FILE_PATH);
	istringstream istr;
	string line, s;
	while (fs >> line)
    {
		istr.str(line);
		while (istr >> s)
		{
			cout << s << endl;
		}
		istr.clear();
	}
	fs.close();
}
```