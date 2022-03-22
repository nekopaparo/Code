[file.doc](https://www.php.net/manual/en/function.file.php)
## 讀寫
### file
```php
// 讀取
$lines = file('myfile.txt');
foreach ($lines as $line)
{
    echo "$line<br>";
}
```

## 二進位(圖片)讀寫
```php
// 讀取
$fr = fopen ("img.jpg", "r");
while (!feof ($fr))
{
   $buffer = fgets($fr, 4096);
   $lines[] = $buffer;
}
fclose ($fr);
// 寫入
$fw = fopen ("cp.jpg", "w");
for($i=0; $i<sizeof($lines); $i++)
{   
    fwrite($fw, $lines[$i]);
}
fclose($fw);
```