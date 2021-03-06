# Cpp
|[SQL](./cpp/sql)|[檔案讀寫](./cpp/base/file.md)|
|-|-|

## 目錄
|[輸入輸出](#輸入輸出)|[變數](#變數)|[字串處理](#字串處理)|[算術運算子算](#算術運算子)|[Array](#Array)|[List](#Vector)|[Obj](#Obj)|
|-|-|-|-|-|-|-|

## 輸入輸出
```cpp
int n;
string s;
cin >> n;
cin >> s;

cout << n+1 << endl; // endl -> \n
cout << s<< endl;
```

## 變數
```cpp
string s = "abc";
char cs[100] = "def";
char *pcs = "ghi";
```

## 字串處理
```cpp
string str1="Hello World Zeko";
string str2="Hi Zeko";
// 字串長度
str1.length();
//字元長度
char cs[100] = "Hello World";
strlen(cs); // -> 11
// false 字串比較
str1.compare(str2) //相同 -> 0, 不同 -> -1
str1==str2;
// 字串擷取
str1.substr(1,3);// 擷取1-3(不包含) -> el
// 字串搜尋
str1.find(find_str); // -> no find = -1
// 字串取代
string old_str="Word";//舊字串
str.replace(input.find(old_str), old_str.length(), new_str);
/*C++取代(舊字串第一個字的位置, 舊字串的長度, 新字串)*/
// 字串為空?
str1.empty();
// 字元複製
char cs1[100] = "Hello World";
char cs2[100];
strcpy_s(cs2, cs1);
// 轉數字
string p = "3.14";
stoi(p); // int
stod(p); // double
```
```cpp
// 字串分割(split)
vector<string> mySplit(string str, string split){
    vector<string> result;
    int find=str.find(split);
    while(find!=-1){
        result.push_back(str.substr(0, find));
        str=str.substr(find+1);
        find=str.find(split);
    }
    result.push_back(str);
    return result;
}
```

## 算術運算子
```cpp
// and OR (舊)&&
// or  OR (舊)||
// not OR (舊)! 
// NULL
pow(4, 2); // 平方
sqrt(4); /* 開根號 or pow(4, 0.5)*/
abs(-3); fabs(-3.14); // 絕對值
round(2.4);	// 四捨五入
ceil(2.4); // 無條件進位
floor(2.4); // 無條件捨去
INT_MAX; // INT最大值
INT_MIN; // INT最小值
to_string(i); // 整數轉字串
```

## Array
```cpp
int numbers_1[4]; //預設-1
int numbers_2[] = {0, 1, 2, 3}; // 直接宣告
int numbers_3[2][3] = {0, 1, 2, 3, 4, 5}; // 二維
// 長度
size(numbers_1); // -> 4
sizeof(numbers_1)/sizeof(*numbers_1); // -> 4
```
```cpp
int arr[] = { 1,2,3,4,5 };
// int *p = arr; -> 會指向arr[0] 等同於 int *p = &arr[0];
for (int* p = arr; p != end(arr); ++p) {
    cout << *p;
}
```

## Vector
```cpp
#include <vector>
vector<int> nums;
// vector<int> nums = {1,2,3}; //初始化
// vector<int> nums(10, -1); // (數量, 初始值) 
// nums = {4,5,6}; //會覆蓋原本的

vector<vector<int>> numss; // 二維

nums.push_back(num); // 新增
nums.at(index); list[index]; // 取值
nums.pop_back(); // 刪除尾端
nums.erase(nums.begin()+2); // 指定刪除
nums.clear(); // 清空
nums.size(); // 大小	
nums.empty(); // 是否為空
// 預先配置記憶體大小
nums.reserve(20); // nums.capacity() -> 20
// 排序 (小 -> 大)
#include <algorithm>
sort(nums.begin(), nums.end());
auto u = unique(nums.begin(), nums.end()); // "連續重複"的會移到後面
n.erase(u, n.end()); // 刪除被移到後面的
// 從頭讀取
for (auto num = nums.begin(); num != nums.end(); num++) {
    cout << *num << endl;
}
// 複製copy
vector<int> nums_cp1(nums);
vector<int> nums_cp2 = nums;
vector<int> nums_cp3;
copy(nums.cbegin(), nums.cend(), nums_cp3);
// copy array
vector<int> cp_array(begin(nums), end(nums));

// 對調
vector<int> n1 = { 1,2,3,4,5 };
vector<int> n2 = { 1,2,3 };
swap(n1, n2);

// 插入 (除了list外，建議不要使用insert)
vector<int> n3 = { 1,2,3 };
n3.insert(n3.begin() + 1, 10); // -> 1, 10, 2, 3
```

## Obj
```cpp
// class & struct
// class 預設為 private
// struct 預設為 public
/*---calss---*/
#include <iostream>
using namespace std;
class Person {
public:
    // 建構子
    Person(string gender, int age, double heigth) : age(age), heigth(heigth) {
        genderCheck(gender);
        NO = ++count;
    }
    Person() : Person("", 0, 0.0) {}   // 委派建構子
    Person(string gender) : Person(gender, 0, 0.0) {}
    Person(int age) : Person("", age, 0.0) {}
    Person(double heigth) : Person("", 0, heigth) {}
    // 方法
    void detail() {
        cout << "------------------\n";
        cout << "NO : " << NO << endl;
        cout << "age : " << age << endl;
        cout << "heigth : " << heigth << endl;
        cout << "gender : " << gender << endl;
    }
    void genderCheck(string gender) {
        if (gender == "男" || gender == "女") {
            this->gender = gender;
        }
        else this->gender = "null";
    }
    void func() const { // const { 只能讀取不可修改 }
        int age = this->age; // OK
        // this->age = age; // error
        ++heigth;   // mutable 在const函式中也可以進行修改
    }
    void static pi() {
        cout << PI << endl;
    }
    // 變數
    static int count; // 非const，必須在類別外初始化
    static constexpr double PI = 3.14;
private:
    int NO;
    int age;
    mutable double heigth;
    string gender;
};
int Person::count = 0; // static int 初始化
```
```cpp
// 使用
int main()
{   
    Person p1;
    Person p2 = Person("男", 15, 175);
    Person p3{ "女", 8, 120 };
    
    cout << "create Person datas -> " << Person::count << endl;
    p1.detail();
    p2.detail();
    p3.detail();

}
```

# 待整理
## const
```cpp
int i = 3, n = 4;
/* value */
const int ci = 5; // 值不可變
ci = 6; // error
const int Ci; // error, 必須初始化(給值)
/* p */
const int* cpi; // 指向的值不可變動
cpi = &n;
*cpi = 15; // error
/*--------------------*/
int* const pci = &i; // 指向不可變, 必須初始化(給指向)
pci = &n; //error
*pci = 40;
```
## constexpr
```cpp
// 和const區分，作為常數使用
constexpr int i = 10;
constexpr int n = i * 10;
int I = 10;
constexpr int N = I * 10; // error, 只能用常數運算
/* p */
int v = 10; // 必須定義在函式外或使用static
constexpr int *pv = &v; // 指向不可變
```
## 別名(alias)
```cpp
// typedef
typedef const char* str;
str s1 = "test1";
str* ps1 = &s1;
// using
using str_ = const char*;
str_ s2 = "test2";
str_* ps2 = &s2;
```
## auto
```cpp
auto i = 10, * p = &i;
auto c = 'A', s = "abc"; // error, 型別不一致
const int n = 2;
auto p1 = &n;
p1 = &i;
const auto p2 = &n;
p2 = &i; // error
```
## decltype(型別複製)
```cpp
int i = 1;
decltype(i) n1 = 0; // n1 = int
decltype(i / 0.3) n2; // n2 = double
```
## 前置處理器(preprocessor)
### H1.h
```cpp
#ifndef TEST // 尋找前置處理器是否有"TEST"變數，變數不存在時才會執行到#endif
#define TEST // 在前置處理器中建立變數"TEST"
#include <iostream>
struct H1
{
    H1() {std::cout << "H1 Hi\n";}
};
#endif
```
### H2.h
```cpp
#ifndef TEST // 前置處理器的變數通常全部用大寫
#define TEST
#include <iostream>
struct H2
{
    H2(){std::cout << "H2 Hi\n";}
};
#endif
```
### main.cpp
```cpp
#include "H1.h"
#include "H2.h"
int main()
{
    H1 h1;
    H2 h2; // error
    /*TEST在H1.h時被建立，
    所以H2.h的#define...#endif被忽略執行*/
    return 0;
}
```
## using
```cpp
#include <iostream>
using std::cin;
int main()
{
    int a;
    std::cin >> a; // OK, 已先宣告std::cin
    cout << a; // error, 缺少std
    std::cout << a; // OK
    return 0;
}
```
## string
### 讀取 (cin >> a bb ccc)
```cpp
#include <iostream>
#include <string>
int main()
{
    std::string s;
    
    // 讀取到空白
    //a
    //bb
    //ccc
    while (std::cin >> s) {
        std::cout << s << std::endl;
    }
    // 讀取一行
    //a bb ccc
    while (std::getline(std::cin, s)) {
        std::cout << s << std::endl;
    }
    return 0;
}
```
### 大小寫
```cpp
#include <iostream>
#include <string>
#include <cctype>
using namespace std;
int main()
{
    string s("Hello World!!!");
    for (char &c : s) {
        c = toupper(c); // 大寫
        //c = toupper(c); // 小寫
    }
    cout << s;

    return 0;
}
```
### 轉16進位
```cpp
#include <iostream>
#include <string>
using namespace std;
int main()
{
    const string hexdigits = "0123456789ABCDEF";
    string result;
    string::size_type n; // size_type -> 一種無號型別，且>=0, vector<int>::size_type n
    while (cin >> n)
        if (n < hexdigits.size())
            result += hexdigits[n];
    
    cout << result;

    return 0;
}
```

## 迭代器 iterator
```cpp
#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main()
{   
    vector<int> v1{1,2,3,4,5,6}; // 可以用iterator和const_iterator
    // 可讀寫
    for (vector<int>::iterator it = v1.begin(); it != v1.end(); ++it) {
        cout << *it << endl;
    }
    const string s("Hello World"); // 只能const_iterator
    // 只可讀取
    for (string::const_iterator it = s.begin(); it != s.end(); ++it) {
        cout << *it << endl;
    }
    // cbegin(), cend() 會回傳const_iterator
    for (auto it = v1.cbegin(); it != v1.cend(); ++it) {
        cout << *it << endl;
    }
    // 會從中間開始
    for (auto it = v1.cbegin() + v1.size() / 2; it != v1.cend(); ++it) {
        cout << *it << endl;
    }
    return 0;
}
```
## cast 強制轉型
```cpp
// i = (int)d;
double d = 3.14;
int i = static_cast<int>(d);
// p = (char*)c;
const char* c;
char *p = const_cast<char*>(c);
```

## argc, argv[]
```cpp
#include <iostream>
using namespace std;
int main(int argc, char *argv[])
{   
    cout << "argc = " << argc << endl;
    for (int i = 0; i < argc; i++)
    {
        printf("argv[%d] = %s\n", i, *argv++);
    }
    system("pause");
    return 0;
}
```
### 使用(cmd)
```cmd
path\xxx.exe -d -o test1 test2
```
### 輸出結果
```cmd
argc = 5
argv[0] = path\xxx.exe
argv[1] = -d
argv[2] = -o
argv[3] = test1
argv[4] = test2
```
## NDEBUG前置處理器變數
```cpp
__func__; // 函式名稱(字串)
__FILE__; // 檔案名稱(字串)
__LINE__; // 目前行號(整數)
__TIME__; // 檔案編譯時間(字串)
__DATE__; // 檔案編譯日期(字串)
```
## inline
```cpp
class MyClass {
public: 
    MyClass() = default;
    void func1() { cout << "func1"; } // 類別內會自動inline
    void func2();
};
inline // 指定inline，可用來強調是class內部函式
void MyClass::func2() {
    cout << "Hello";
}
```

## thread
```cpp
// cli_winform
System::Threading::ThreadStart ts = gcnew System::Threading::ThreadStart(this, &Form1::func);
System::Threading::Thread^ t1 = gcnew System::Threading::Thread(ts);
t1->Start();
t1->Join();
```
//
## System::String^ & std::string
```cpp
// https://dotblogs.com.tw/v6610688/2014/01/07/std_string_to_cli_system_string

//System::String^ to std::string
String^ str = gcnew String(os.c_str());

const char* chars = (const char*)(System::Runtime::InteropServices::Marshal::StringToHGlobalAnsi(source)).ToPointer();
string dest = chars;
```

```c#
but_自定路徑_選資料夾.Click += (sender, e) => {

    var dialog = new FolderSelectDialog {
    //InitialDirectory = musicFolderTextBox.Text,
    Title = "Select a folder"
    };
    if (dialog.Show()) {
        text_自定儲存路徑.Text = dialog.FileName;
        radio_儲存路徑_自定.IsChecked = true;
    }
};
```

## datagridview

* AutoSizeColumnsMode -> 寬度自動化設定
* ColumnHeadersDefaultCellStyle -> 內容相關格式設定

## form
* this->MaximizeBox = true -> 放大按鈕

* FormBorderStyle = FixedSingle -> 邊寬相關格式(取消拖拉大小)