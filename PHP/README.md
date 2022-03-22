# PHP
|[環境設定](./phpSet.md)|[時區設定](./timezone.md)|[Cookie](./Cookie)|[Session](./Session)|
|-|-|-|-|

## 變數宣告
```php
$value = 10;
// 刪除變數
unset($value);
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
$strs_list = ["apple" => "蘋果", "banana", "香蕉"];
echo $strs_list["apple"]; // -> 蘋果
// 2.
$array = array(0, 1, 2, "peko");
// 3.
$name = ["coco", "gura"];
$name[] = "zako"; // 往後增加
$name[] = "neko";
$name[] = "peko";
echo $name[2]; // -> zako
echo sizeof($name); // -> 5
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
$week = [
    'sunday', 'monday', 
    'tuesday', 'wednesday', 
    'thursday', 'friday', 
    'saturday'
];

foreach($week as $day_num => $day) 
{
    echo "$day_num. $day<br>";
}
foreach($week as $day) 
{
    echo "$day<br>";
}

$WEEK = array (
    'sunday' => '星期日',
    'monday' => '星期一',
    'tuesday' => '星期二', 
    'wednesday'=>'星期三',
    'thursday' => '星期四',
    'friday' => '星期五',
    'saturday' => '星期六'
);
foreach($WEEK as $DAY => $DAY_Name) 
{
    echo "$DAY is $DAY_Name<br>";
}
```

## 紀錄
```php
htmlspecialchars("<p>hi</p>"); // 純字元 
```
## 字串處理
```php
// 取代
$str = "Hello World";
$new_str = str_replace("World", "php", $str);
echo $new_str; // -> Hello php
```