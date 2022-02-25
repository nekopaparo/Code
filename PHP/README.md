# PHP
|[環境設定](./phpSet.md)|
|-|

## 時區設定(XAMPP)
#### 1. 修改 -> ./XAMPP/php/php.ini
##### 1.1 找到 ↓
```ini
[Date]
;date.timezone= 
```
##### 1.2 改成指定時區
```ini
[Date]
date.timezone="Asia/Taipei"
```
#### 2. 直接在PHP裡使用
```php
date_default_timezone_set("Asia/Taipei");
```
[PHP支援的時區表](https://www.php.net/manual/en/timezones.php)

## 變數宣告
```php
$value = 10;
```
## 輸出
```php
// 兩種用法基本相同
echo "$value<br>";
print $value; // 成功時回傳1，失敗0 
```
## 字串連接(用.連接)
```php
$str1 = "Hello";
$str2 = "PHP";
$str3 = $str1." ".$str2;
```
## 陣列
```php
// 1.
$strs = ["peko1","peko2", "peko3"];
// 2.
$array = array(0, 1, 2, "peko");
// 3.
$name[] = "zako";
$name[] = "neko";
$name[] = "peko";
echo $name[1]; // -> neko
// 二維陣列
$score = array(
    array(0, 1, 2),
    array(3, 4, 5),
    array(6, 7, 8)
);
echo $score[1][1]; // -> 4
```

## 迴圈
### for
```php
for($i=0; $i<3; $i++) {
    echo "Hi<br>";
}
```
### while
```php
$i=0;
while($i<3){
    echo "Hi<br>";
    $i++;
}
do{
    echo "Hi<br>";
    $i--;
}while($i>0);
```
### foreach
```php
foreach($strs as $str) {
    echo "$str<br>";
}

$week = array (
    'sunday' => '星期日',
    'monday' => '星期一',
    'tuesday' => '星期二', 
    'wednesday'=>'星期三',
    'thursday' => '星期四',
    'friday' => '星期五',
    'saturday' => '星期六'
);
echo $week['sunday'];
foreach($week as $day => $dayname) {
    echo "$day is $dayname<br>";
}
```
## Cookie
```
setcookie(name, value, expire, path, domain, secure)
```
|參數|說明|
|-|-|
|name|Cookie 變數名稱|
|value|Cookie 變數的內容(字串格式)。|
|expire|Cookie 變數的有效期。|
|path|Cookie 變數儲存路徑。|
|domain|Cookie 共用網域。|
|secure|可否通過 HTTPS 連線傳輸 cookie。|
### 新增
```php
setcookie("name1", "value1");
```
### 讀取
```php
if (isset($_COOKIE["name1"])) {
    echo $_COOKIE["name1"]."<br>";
}else {
    echo "查無指定cookie，請重新整理網頁 <br>";
}
```
### 設定cookie有效時間(注意時區問題)
```php
$Todyend = date("y-m-d 23:59:59");
// date_default_timezone_set("Asia/Taipei"); // 設定時區
setcookie("name2", "value2", strtotime($Todyend));
```
### 刪除
```php
setcookie("name2", "null", time()-1); // time() = 現在時間
```
### 陣列
```php
//宣告
setcookie("var1[one]", "Cookie-1");
setcookie("var1[2]", "Cookie-two");
// 讀取 Cookie 變數是否存在
if (isset($_COOKIE["var1"])) {
    foreach($_COOKIE["var1"] as $name => $value) {
        echo "$name : $value <br>";
    }
}else {
    echo "查無指定cookie，請重新整理網頁 <br>";
}
```