## Session
### 啟動session功能
```php
session_start();
```
### 變數
```php
$_SESSION['name'] = "小貓";
// 陣列名稱
$_SESSION['小貓']['name'] = "小花";
$_SESSION['小貓']['year'] = 3;
```
### 讀取
```php
echo $_SESSION['name'].<br>;
$_SESSION['小貓']['year']++; // -> 4
```
### 刪除
```php
unset($_SESSION['小貓']); // 指定刪除變數
session_unset(); // 清除session中所有變數
```