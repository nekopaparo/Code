# 時區設定(XAMPP)
### 修改 -> ./XAMPP/php/php.ini
* 找到 ↓
```ini
[Date]
;date.timezone= 
```
* 改成指定時區
```ini
[Date]
date.timezone="Asia/Taipei"
```
### 直接在PHP裡使用
```php
date_default_timezone_set("Asia/Taipei");
```
[PHP支援的時區表](https://www.php.net/manual/en/timezones.php)
