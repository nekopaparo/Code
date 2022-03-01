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