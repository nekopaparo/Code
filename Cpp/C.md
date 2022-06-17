# Cpp
|[SQL](./cpp/sql)|[檔案讀寫](./cpp/base/_fstream.cpp)|
|-|-|

## 目錄
|[輸入輸出](#輸入輸出)|[變數](#變數)|[字串處理](#字串處理)|[算術運算子算](#算術運算子)|[Array](#Array)|[動態配置]
|-|-|-|-|-|-|

## Base
```c
#include <stdio.h>
int main(int argc, char *argv[]) // arg 可省略
{
    // argc = argvSize 
    // argv = 命令列的參數
    // argv[0] -> 該程式路徑
    printf("Hello C");
    return 0;
}
```

## 輸入輸出
```c
printf("%d %f %c %s", 10, 3.14, X, "Hello C");
```

## 變數
```c
// string
// 字串結尾為\0, 不寫系統會自動補上
char str1 [] = "string\0";
char *str2 = "string";
```

## 字串處理
```c
// 陣列大小至少 strlen(str) + 1 (要加上\0的空間)
char str [6] = "Hello";
// 字串長度
strlen(str); // -> 5 = Hello

char a [100];
char b [] = "World";
// 數字轉字串
sprintf(a, "%f", 3.14);
// 字串轉數字 use -> #include <stdlib.h>
int i = atoi(a);
float f = atof(a);

#include <string.h>
// 指派/複製 -> C語言字串是陣列, 所以不能直接指派新字串
strcpy(a, b); // -> a = "World"
// 結合
strcat(a, b); // -> a = "WorldWorld"
// 比較
int c = strcmp(a, b); // 相等 = 0
// <string.h> end
```

## 算術運算子
```c
// && || ! 
```

## Array
```c
// 一維
int n [] = {1, 2, 3, 4, 5};
// 二維 array[x][y];
int array[][8] = { // 只有一維的可以空
    {1,2,3,4,5,6,7,8},
    {9,10,11,12} // 不足的會補0
}
// 陣列空間大小
int x =  sizeof(array) / sizeof(array[0]); // = 2
int y = sizeof(array[0]) / sizeof(array[0][0]); // = 8
```
## 指標 -> *
```c
char str [] = "Hello C";
char *p = str; // *p -> 'H', 陣列本身會指向第一個 *str -> 'H'
p += 4; // *p -> 'o'
*(p - 3); // -> 'e'
// 參考 -> &
int n = 10;
int *p = &n; // p = n
*p = 11; // n -> 11
```
## 動態配置
```c
#include <stdlib.h>
#include <malloc.h>
#include <memory.h>
char arry[] = {10, 20, 30, 40}, *cp;
int arrySize = 5;
// 配置空間*
cp = (char *)malloc(sizeof(char) * arrySize);
if (cp != NULL) {
    // 複製內容
    memcpy(cp, arry, sizeof(char) * arrySize); 
    for (int i = 0; i < arrySize; ++i)
        printf("%d ", cp[i]);
}
// 釋放空間*
free(cp);
```