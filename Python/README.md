# Python
|[Cpp](../Cpp)|[Java](../Java)|
|-|-|
## 目錄
|[變數](#變數)|[字串處理](#字串處理)|[算術運算子算](#算術運算子)|[Array](#Array)|[List](#List)|[Obj](#Obj)|
|-|-|-|-|-|-|

## 變數
```python
i=0
d=0.0
str_="abc"
b=True # False
ord('a') # 97
chr(97) # 'a'
```

## 字串處理
```python
str1="Hello World Zeko"
str2="Hi Zeko"
# 字串長度
len(str)
# false 字串比較
str1==str2
# 字串分割
str1.split(" ") # {Hello, World, Zeko}
str1.split(" ", 2) # 指定分割成2個, {Hello, Word Zeko}
# 字串擷取
str1[1:3] # 擷取1-3(不包含) -> el
# 字串搜尋
str1.find(find_str) # -> no find = -1
# 字串取代
str1.replace(old_str, new_str)
# 字串為空?
str1 # ->True
```

## 算術運算子
```python
# and, or, not, None
4**2 # 平方
4**0.5 # 開根號
abs(-3.14) # 絕對值
round(2.4)	# 四捨五入
math.ceil(2.4) # 無條件進位
math.floor(2.4) # 無條件捨去
2**31-1 # INT最大值
-2**31 # INT最小值
str(i) # 整數轉字串
```

## Array
```python
numbers_1= [0, 1, 2, 3] # 預設0
numbers_2=[range(3) for _ in range(2)] # 二維 -> [[0, 1, 2], [0, 1, 2]]
len(numbers_1) # 長度 -> 4
# 輸出成字串以_OAO_連接 -> "0_OAO_1_OAO_2_OAO_3"
s="_OAO_"
s.join(numbers_1)
```

## List
```python
nums=[]
nums+=[num] # 新增
nums[index] # 取值
nums=[] # 清空
len(nums) # 大小	
nums=sorted(nums) # 排序 (小 -> 大)
```

## Obj
```python
def sum(self, num1, num2):
    return num1+num2

self.sum(10, 20) # -> 30
```