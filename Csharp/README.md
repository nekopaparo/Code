# C#
|[SQL](./csharp/sql)|[Ninject](./csharp/NinjectSample)|
|-|-|

## 目錄
|[輸入輸出](#輸入輸出)|[變數](#變數)|[字串處理](#字串處理)|[算術運算子算](#算術運算子)|[Array](#Array)|[List](#List)|[Obj](#Obj)|
|-|-|-|-|-|-|-|

## 輸入輸出
```csharp
string s = System.Console.ReadLine();

System.Console.WriteLine(s); // Line = "\n"
```

## 變數
```csharp
uint i = 0; // = unsigned int
string s="abc";
```

## 字串處理
```csharp
string s = @"Hi\n\t"; // 純文字輸出 -> Hi\n\t
string str1="Hello World Zeko";
string str2="Hi Zeko";
// 字串長度
str.Length;
// false 字串比較
str1.Compare(str2) //相同 -> 0, 不同 -> -1
str1==str2;
// 字串分割(split)
str1.Split(" ", 2)
// 字串擷取
str1.Substring(1,3) // 擷取3個 -> "ell"
// 字串搜尋
str1.IndexOf(find_str); // -> no find = -1
// 字串取代
str1.Replace(old_str, new_str);
// 字串為空? if str = " " 
string.IsNullOrEmpty(str1); // False
string.IsNullOrWhiteSpace(); // True
// 字串轉數字
string num = "12345";
Convert.ToInt32(num);
int.Parse(num);
// 字串格式化
int n = 1;
string s = $"{n} + {n} = 2"; // -> 1 + 1 = 2
```

## 算術運算子
```cpp
// &&, ||, !, null
Math.Pow(4, 2); // 平方
Math.Sqrt(4); /* 開根號 or Math.Pow(4, 0.5)*/
Math.Abs(-3.14); // 絕對值
Math.Round(2.4);	// 四捨五入
Math.Ceiling(2.4); // 無條件進位
Math.Floor(2.4); // 無條件捨去
int.MaxValue; // INT最大值
int.MinValue; // INT最小值
Convert.ToString(i); // 整數轉字串
```

## Array
```csharp
int[] numbers_1 = new int[4]; //預設0
int[] numbers_2 = {0, 1, 2, 3}; // 直接宣告
int[,] numbers_3 = {{0, 1, 2},{3, 4, 5}}; // 二維, numbers_3[0,1] -> 1, 三維=[,,] 
numbers_1.Length; // 長度
```

## List
```csharp
using System.Collections.Generic; // List

List<string> list = new List<string> { "Hi", "Cshap", "List", "Hi" };
//List<string> list = new List<string>();
list.Add("New Value"); // 尾端新增
list.AddRange(new []{ "value1", "value2", "value1" });
list.Insert(2, "Insert"); // 插入 => list[2] = "Insert"
list.IndexOf("List"); // 搜尋 = 2
list.Sort(); // 排序
list.BinarySearch("List"); // 搜尋，要先排序才能用
// cmd顯示
list.ForEach(delegate (string item)
{
    Console.WriteLine(item);
});
string[] array = list.ToArray(); // 輸出陣列
int size = list.Count; // size
list.Remove("Hi"); // 刪除第一個符合的
list.RemoveAt(0); // 刪除第一個
list.Clear(); // 清空
```

## Obj
```csharp
/*---calss---*/
namespace Human
{
    class Person
    {
        public string name;
        private int age;
        private double heigth;
        private string gender;
        // 建構元
        public Person(string name, int age, double heigth)
        {
            this.name = name;
            this.age = age;
            this.heigth = heigth;
        }
        // get, set
        public string Gender
        {
            get { return gender; }
            set
            {
                if (value == "男" || value == "女")
                {
                    gender = value;
                }
                else
                    gender = null;
            }
        }
        public void Detail()
        {
            Console.WriteLine("age : " + age);
            Console.WriteLine("heigth : " + heigth);
            Console.WriteLine("gender : " + gender);
        }
    }
}

/*---使用---*/
Human.Person p1 = new Human.Person("Neko", 8, 140);
Console.WriteLine(p1.name);
p1.Detail();
// set
p1.Gender = "女"; // gender = 女
p1.Gender = "娚"; // gender = null
// get
Console.WriteLine(p1.Gender);
```