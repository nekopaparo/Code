# Java
|[SQL](./java/bean/sql)|[多執行緒](./java/base/_Thread.java)|
|-|-|

## 目錄
|[輸入輸出](#輸入輸出)|[變數](#變數)|[字串處理](#字串處理)|[算術運算子算](#算術運算子)|[Array](#Array)|[List](#List)|[Obj](#Obj)|
|-|-|-|-|-|-|-|
## base
```java
public class FileName // FileName.java
{
	public static void main(String[] args)
	{
		System.out.println("Hello world");
	}
}
```
## 輸入輸出
```java
import java.util.Scanner;

public class Scan
{
	public static void main(String[] args)
	{
	// 輸入
		Scanner scn = new Scanner(System.in);
		// 讀到空白
		int i = scn.nextInt();
		double d = scn.nextDouble();
		String word = scn.next();
		// 讀取整行 (讀到換行符號\n)
		String line = scn.nextLine();
        // *輸入結束時要關閉
		scn.close();
	// 輸出
		System.out.print(word + '\n'); // \n = 換行
		System.out.println(line); // 輸出完換行
		System.out.printf("%02d, %.3f\n", i, d); // 格式化輸出
	}
}
```

## 變數
```java
// java 沒有 signed / unsigned
// 變數可用class來宣告
Integer I = 0; // = new Integer(0);
int i = 0; // 大小 32 bit
byte b = 0; // -128 ~ 127 (8 bit)
// java不是預設(int, double)時要寫強調
long l = 0L; 
float f = 0.0F;
char c = 0; // 0 ~ 65535 (16 bit)
// java的字串是class
String s = "abc";
```

## 字串處理
```java
String str1="Hello World Zeko";
String str2="Hi Zeko";
// 字串長度
str1.length();
// false 字串比較
str1.equals(str2);
// 字串分割
str1.split(" "); /*{Hello, World, Zeko}*/
str1.split(" ", 2); /* 指定分割成2個, {Hello, Word Zeko}*/
// 字串擷取
str1.substring(1,3);// 擷取1-3(不包含) -> el
// 字串搜尋
str1.indexOf(find_str); // -> no find = -1
// 字串取代
str1.replace(old_str, new_str);
// 字串為空?
str1.isEmpty();
// 轉數字
String iStr = "123456";
int i = Integer.parseInt(iStr);
// 字串格式化
int n = 1;
// result = "1 + 1 = 2"
String result = String.format("%d + %d = %d", n, n, n+n);
```

## 算術運算子
```java
// && -> and, || -> or, ! -> not, null
Math.pow(4, 2); // 平方
Math.sqrt(4); /* 開根號 or Math.pow(4, 0.5)*/
Math.abs(-3.14); // 絕對值
Math.round(2.4); // 四捨五入
Math.ceil(2.4); // 無條件進位
Math.floor(2.4); // 無條件捨去
Integer.MAX_VALUE; // INT最大值
Integer.MIN_VALUE; // INT最小值
Integer.toString(i); // 整數轉字串
```

## Array
```java
int[] numbers_1 = new int[4]; // 預設0
int[] numbers_2 = {0, 1, 2, 3}; // 直接宣告
int[][] numbers_3 = new int[2][3]; // 二維
numbers_1.length; // 長度 -> 4
// 輸出成字串以_OAO_連接 -> 0_OAO_1_OAO_2_OAO_3
numbers_2.join("_OAO_", array);
```

## List
```java
import java.util.ArrayList;
import java.util.Collections;

public class ListSample
{
	public static void main(String[] args)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(num); // 新增
		nums.get(index); // 取值
		nums.remove(index); // 刪除
		nums.clear(); // 清空
		nums.size(); // 大小	
		nums.toArray(String[]::new); // 轉陣列
		nums.isEmpty(); // 是否為空
		// 排序 (小 -> 大)
		Collections.sort(nums);
	}
}
```

## Obj
```java
class Person
{
    // 變數
    public String name;
    private int age; // private -> 無法從外部進行存取
    // 建構子 1
    public Person()
    {
    	this.name = null;
        this.age = -1;
    }
    // 建構子 2
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    // 方法 1
    public void detail()
    {
    	System.out.println("name : " + name);
        System.out.println("age : " + age);
    }
    // 方法 2
    public void setAge(int newAge)
    {
    	this.age = newAge;
    }
}
```
```java
Person p1 = new Person("Neko", 8);
p1.detail();
Person p2 = new Person();
p2.setAge(10);
p2.detail();
```