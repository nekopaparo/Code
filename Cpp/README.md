# Cpp
|[C#](../Csharp)|[Java](../Java)|[Python](../Python)|
|-|-|-|

|[SQL](./cpp/sql)|
|-|

## 目錄
|[輸入輸出](#輸入輸出)|[變數](#變數)|[字串處理](#字串處理)|[算術運算子算](#算術運算子)|[Array](#Array)|[List](#List)|[Obj](#Obj)|
|-|-|-|-|-|-|-|

## 輸入輸出
```cpp
int n;
string s;
cin >> n;
cin >> s;

cout << n+1 << endl; // endl -> \n
cout << s<< endl;
cou
```

## 變數
```cpp
int     i=0;
long    l=0;
float   f=0.0;
double  d=0.0;
char    c='a';
string s="abc";
(int)'a'; //=97
(char)97; //='a'
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
// 長度 -> 需已知空間才可使用,不然會ERROR
numbers_4[6];
numbers_4.size(); // -> 6
n=6;
numbers_5[n];
numbers_5.size(); // -> Error
```

## List
```cpp
#include <vector>
vector<int> nums;
nums.push_back(num); // 新增
nums.at(index); list[index]; // 取值
nums.clear(); // 清空
nums.size(); // 大小	
nums.empty(); // 是否為空
// 排序 (小 -> 大)
#include <algorithm>
sort(nums.begin(), nums.begin()+nums.size());
// 從頭讀取
for(auto num = nums.begin(); num != nums.end(); ++num){
    cout >> *num >> endl;
}
```

## Obj
```cpp
/*---calss---*/
class Person {
    private:
        int age;
        double heigth;
        string gender;
    public:
        string name;
        Person(string name, int age, double heigth){
            this->name = name;
            this->age = age;
            this->heigth = heigth;
        }
        detail(){
            cout << "age : " << age << endl;
            cout << "heigth : " << heigth << endl;
        }
        string get() {return gender;}
        void set(string gender) {
            if (gender == "男" || gender == "女"){
                this->gender = gender;
            }
            else this->gender = "null";
        }
};
/*---使用---*/
Person p1 = Person("Neko", 8, 140);
cout << "name : " << p1.name << endl;
p1.detail();
// set
p1.set("女"); // gender = 女
p1.set("娚"); // gender = null
// get
cout << "gender : " << p1.get() << endl;
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
## 前置處理器(preprocessor)
### H1.h
```cpp
#ifndef TEST // 尋找前置處理器是否有"TEST"變數，變數不存在時才會執行到#endif
#define TEST // 在前置處理器中建立變數"TEST"
#include <iostream>
struct H1
{
	H1() {
		std::cout << "H1 Hi\n";
	}
};
#endif
```
### H2.h
```cpp
#ifndef TEST
#define TEST
#include <iostream>
struct H2
{
	H2() {
		std::cout << "H2 Hi\n";
	}
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