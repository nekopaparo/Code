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