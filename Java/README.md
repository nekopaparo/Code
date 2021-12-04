# Java
|[Cpp](../Cpp)|[Python](../Python)|
|-|-|
## 目錄
|[變數](#變數)|[字串處理](#字串處理)|[算術運算子算](#算術運算子)|[Array](#Array)|[List](#List)|[Obj](#Obj)|
|-|-|-|-|-|-|

## 變數
```Java
int i=0;
long l=0L;
float f=0.0F;
double d=0.0;
char c='a';
String s="abc";
(int)'a'; //=97
(char)97; //='a'
```

## 字串處理
```Java
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
```

## 算術運算子
```Java
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
```Java
int[] numbers_1 = new int[4]; // 預設0
int[] numbers_2 = {0, 1, 2, 3}; // 直接宣告
int[][] numbers_3 = new int[2][3]; // 二維
numbers_1.length; // 長度 -> 4
numbers_2.join("_OAO_", array);	// 輸出成字串以_OAO_連接 -> 0_OAO_1_OAO_2_OAO_3
```

## List
```Java
import java.util.ArrayList;
ArrayList<Integer> nums=new ArrayList<Integer>();
nums.add(num); // 新增
nums.get(index); // 取值
nums.remove(index); // 刪除
nums.clear(); // 清空
nums.size(); // 大小	
nums.toArray(String[]::new); // 轉陣列
nums.isEmpty(); // 是否為空
```
```Java
// 排序 (小 -> 大)
import java.util.Collections;
Collections.sort(nums);
```

## Obj
```Java
/*---calss---*/
class Person{
    public String name;
    private int age;
    private double heigth;
    private String gender;
    public Person(String name, int age, double heigth){
        this.name = name;
        this.age = age;
        this.heigth = heigth;
    }
    public void detail(){
        System.out.println("age : " + age);
        System.out.println("heigth : " + heigth);
        System.out.println("gender : " + gender);
    }
    public String get() {return gender;}
    public void set(String gender) {
        if (gender == "男" || gender == "女"){
            this.gender = gender;
        }
        else this.gender = null;
    }
}

/*---使用---*/
Person p1 = new Person("Neko", 8, 140);
System.out.println(p1.name);
p1.detail();
// set
p1.set("女"); // gender = 女
p1.set("娚");; // gender = null
// get
System.out.println(p1.get());
```