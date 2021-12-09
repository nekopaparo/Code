# MySQL
[新增](#新增2)
## 基本
```sql
#使用該資料庫
USE world;
#顯示系統資料庫的所有資料表
SHOW TABLES
FROM information_schema;
#基本搜尋，DISTINCT排除重複資料，預設ALL
SELECT DISTINCT CountryCode
FROM city;

#排序
SELECT *
FROM city
#ORDER BY CountryCode; #預設ASC(小到大)
ORDER BY 3, Name DESC; /*用第三個column，和上面結果相同*/

#指定輸出資料數
SELECT *
FROM city
LIMIT 5,3; #跳過5筆資料後取3筆資料

#日期的加減，YEAR, HOUR, ...
SELECT '2007-01-01' + INTERVAL 3 DAY;

```

## WHERE
```sql
SELECT *
FROM country
WHERE (Continent = 'Europe' OR Continent = 'Africa') AND Population < 10000;
#!=WHERE Continent = 'Europe' OR Continent = 'Africa' AND Population < 10000;
# 優先順序 AND > OR

SELECT *
FROM country
WHERE Population BETWEEN 78000 AND 149000;
#=WHERE Population >= 78000 AND Population <= 149000;

SELECT *
FROM country
WHERE Code IN ('TWN', 'JPN', 'USA', 'ITA', 'KOR');

#判斷空值(NULL)
SELECT Name, LifeExpectancy
FROM country
WHERE LifeExpectancy IS NULL; #不等於 <=> , IS NOT

# match
SELECT *
FROM country
WHERE Name LIKE 'A%';
#WHERE Name LIKE 'Arub_';
# % = * (0~N個任意字元), _ = . (1個任意字元)
```

## 常用方法
```sql
#COUNT計數
SELECT COUNT(DISTINCT Continent) #DISTINCT -> 排除重複
FROM world.country;

#用指定字串補滿長度，RPAR -> 從右邊補，常用於左右對齊，取代ZEROFILL
SELECT LPAD(Name, 20, ' ')
FROM world.city;

#變字串，用逗號分隔
SELECT GROUP_CONCAT(DISTINCT Continent ORDER BY Continent) Continent
FROM world.country;

#替換
SELECT REPLACE('HACHAMA IS HACHA', 'IS', 'NOT');

#截取，從位置2開始取5個
SELECT SUBSTRING('HACHAMA IS HACHA', 2, 5);

#連接多個字串
SELECT CONCAT('HACHAMA', 'PEKO', 'COCO', 'GURA');

#以指定字串('@@')連接多個字串
SELECT CONCAT_WS('@@', 'HACHAMA', 'PEKO', 'COCO', 'GURA');

#字串長度
SELECT LENGTH('不可以色色'); #長度(bytes),英文是1byte，中文的byte依照字元集決定，e.g, UTF8 -> 3byte
SELECT CHAR_LENGTH('不可以色色'); #長度 -> 5

#indexOf，回傳指字串(' ')的位置(回傳第一個)，查無回傳0
SELECT LOCATE(' ','HELLO WORLD SQL');

#隨機查詢
SELECT Name
FROM country
ORDER BY ROUND() #回傳0 <= ROUND() < 1 的隨機數字
LIMIT 3;
```
|數字處理||
|-|-|
|ROUND(N)|4捨5入到整數|
|ROUND(N, 位數)| 4捨5入到小數點後位數|
|CEIL(N)|無條件進位變整數|
|FLOOR(N)|無條件捨去變整數|

|日期處理||
|-|-|
|DAYNAME()|Sunday(日) - Saturday(六)|
|DAYOFWEEK()|1(日) - 7(六)|

## IF - WHEN
```sql
#IF
SELECT IF(Population > 500000, Population, 'QAQ')
FROM world.city
LIMIT 10;

#IFNULL
SELECT ename, salary, comm, salary + IFNULL(comm, 0) FullSalary
FROM cmdev.emp;

#WHEN
SELECT ename, salary, salary *
CASE
    WHEN salary >= 3000 THEN 2.5
    WHEN salary BETWEEN 1000 AND 2999 THEN 1.5
    ELSE 1.2
END bonus
FROM cmdev.emp
ORDER BY bonus DESC;
```

## 分組
```sql
SELECT Continent, Region, SUM(Population) PopSum
FROM country
WHERE Continent IN ('Asia', 'Europe')
GROUP BY Continent, Region WITH ROLLUP #WITH ROLLUP -> 群組統計
#GROUP BY Continent WITH ROLLUP #未指定統計，依照前面來統計
HAVING SUM(Population) > 100000000 #包含群組函數要使用HAVING
ORDER BY Continent DESC;
```

## INNER JOIN 內部結合
```sql
SELECT Code, Capital, c.Name #非重複可不用指定表格
#SELECT country.Code, country.Capital, city.Name
FROM country, city c #指定別名
WHERE Capital = ID;

SELECT Code, Capital, c.Name
FROM country INNER JOIN city c ON Capital = ID;

#如果條件名稱相同可以用USING
SELECT empno, ename, dname
FROM cmdev.emp INNER JOIN cmdev.dept USING (deptno); 
#FROM cmdev.emp e INNER JOIN cmdev.dept d on e.deptno = d.deptno;
```

## 資料維護 data
```sql
#表格資訊
DESCRIBE cmdev.dept;
#DESC cmdev.dept; #簡化寫法
```

### 新增
```sql
INSERT IGNORE INTO cmdev.dept #略過錯誤訊息 
VALUES (90, 'SHIPPING_1', DEFAULT); #DEFAULT->使用預設值

#新增資料，主索引(KEY)資料已存在時會發生ERROR
INSERT INTO cmdev.dept
(deptno, dname) VALUES (91, 'SHIPPING_2'), (92, 'SHIPPING_3'); #未指定欄位會被寫入NULL

#主索引資料已存在時會進行指定條件取代資料
INSERT INTO cmdev.dept
(deptno, dname) VALUES (91, 'SHIPPING_2')
ON DUPLICATE KEY UPDATE dname = CONCAT(dname, '.'), location = 'TAIWAN'; 

#同INSERT，差在KEY已存在時，會直接覆蓋形成新資料
REPLACE INTO cmdev.dept
(deptno, dname) VALUES (91, 'SHIPPING_2');
```
### 修改
```sql
UPDATE cmdev.emp
SET salary = salary + 100
WHERE salary < 1500;

#salary不可為字串，會發生ERROR，資料不會做任何修改
UPDATE cmdev.emp
SET salary = 'HELLO', comm = 1000
WHERE empno = 8888;

#有問題的地方會被填入0，不會發生ERROR，資料會更新
UPDATE IGNORE cmdev.emp
SET salary = 'HELLO', comm = 1000
WHERE empno = 8888;

#編號倒數3個人薪水+1元
UPDATE cmdev.emp
SET salary = salary + 1
WHERE empno < 8000
ORDER BY empno DESC
LIMIT 3; #在這邊只能指定數量，不能用跳過
```
### 刪除
```sql
DELETE IGNORE FROM cmdev.dept #IGNORE忽略錯誤
WHERE deptno >= 90
ORDER BY deptno
Limit 1;

#刪除表格內所有資料，資料很多時刪除效率 TRUNCATE > DELETE
DELETE FROM cmdev.dept; 
TRUNCATE TABLE cmdev.dept; #TABLE可省略
```

## 資料庫 DATABASE
```sql
#顯示該資料庫的相關設定
SHOW CREATE DATABASE mydb;

# 顯示所有資料庫
SHOW DATABASES;
SHOW SCHEMAS;

# MySQL支援的字元集
SHOW CHARACTER SET; 

# MySQL支援的排序集
SHOW COLLATION LIKE 'latin1%';
# latin1_bin -> bin,binary，表示處理的單位是byte
# latin1_general_ci -> ci,case insensitive，不區分大小寫，除了影響排序 , AAA = aaa
# latin1_general_cs -> cs,case sensitive，區分大小寫

SELECT * FROM information_schema.SCHEMATA;
#information_schema -> 系統資料庫，儲存伺服器(server)所有重要的訊息
#SCHEMATA -> 負責儲存資料庫相關資訊
```

### 新增
```sql
#IF NOT EXISTS -> 如果已存在就不建立，不會產生ERROR
CREATE DATABASE IF NOT EXISTS mydb
CHARACTER SET utf8 #可省略，會使用系統預設
COLLATE utf8_unicode_ci; #可省略，會使用系統預設
```

### 修改 
```sql
ALTER DATABASE mydb
CHARACTER SET utf8 #修改字元
COLLATE utf8_unicode_ci; #修改排序
```

### 刪除
```sql
# !!!!!!不會跟你確認是否刪除，請小心使用!!!!!!
DROP DATABASE IF EXISTS mydb; #IF EXISTS -> 資料庫有存在才刪除，不會產生ERROR
# !!!!!!不會跟你確認是否刪除，請小心使用!!!!!!
```

## 資料表 TABLE
```sql
-- 相關資訊 --

SHOW TABLES FROM world;

SELECT TABLE_SCHEMA,	# 資料庫名稱
	   TABLE_NAME,		# 表格名稱
	   ENGINE,			# 使用的引擎
	   TABLE_ROWS,		# 記錄數量
	   AUTO_INCREMENT,	# AUTO_INCREMENT 目前儲存紀錄
	   TABLE_COLLATION	# 排序集
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'world';

-- 修改預設引擎 --

# 直接修改my.ini設定檔 -> default-storage-engine=InnoDB

SET GLOBAL storage_engine = InnoDB; # 伺服器重啟便會失效

SET SESSION storage_engine = InnoDB; # 客戶端離線便會失效
SET storage_engine = InnoDB;		 # 客戶端離線便會失效


# UNSIGNED ZEROFILL -> 少的會補0，將被移除不建議使用請使用LPAD()，要用ZEROFILL一定要搭配UNSIGNED
```

### Table
#### 新增
```sql
CREATE TABLE neko(
	ID		INT UNSIGNED AUTO_INCREMENT KEY, /*數值欄位特有: # UNSIGNED -> 不能儲存負數 # AUTO_INCREMENT -> 自動累計，系統會儲存累計如有比他大，便會用該數+1，從1開始累計 */
    Name	CHAR(20) UNIQUE NOT NULL, # UNIQUE -> 不可重複
    Sex		VARCHAR(20) DEFAULT '無' # DEFAULT -> 預設
)	ENGINE = InnoDB 			# 可省略  # 儲存引擎可用SHOW ENGINES查詢
	CHARACTER SET = utf8		# 會用 	  # UTF8已棄用，請改用UTF8MB4
    COLLATE = utf8_unicode_ci;	# 系統預設

CREATE TABLE tstable(
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, # CURRENT_TIMESTAMP -> 目前時間 # ON UPDATE -> 修改動作時進行
    ts2 TIMESTAMP DEFAULT '0000-00-00 00:00:00',
    area VARCHAR(20) NOT NULL,
    temp INT NOT NULL
);

#從已存在資料表複製格式(設定)建立新資料表
CREATE TABLE IF NOT EXISTS newneko
LIKE neko; 
```
##### 暫存表格(TEMPORARY)
```sql
# TEMPORARY -> 暫存表格，用戶端離線便會刪除
# 建立資料表的名字已存在時，資料庫的會被隱藏，重開就能再次讀取
CREATE TEMPORARY TABLE neko(
	ID VARCHAR(5),	
    Name VARCHAR(5)
);
```
#### 修改表格名稱
```sql
ALTER TABLE new_neko RENAME TO neko; # TO 可省略，可用在暫存資料表
RENAME TABLE neko TO neko1, neko3 TO neko4; # 可一次多個修改，無法使用在暫存資料表
```
#### 刪除 (!!!不會有確認刪除!!!)
```sql
DROP TABLE IF EXISTS neko1, neko4; #多個table刪除
```

### 欄位
#### 新增
```sql
ALTER TABLE neko
#ADD COLUMN tt VARCHAR(10) FIRST; # COLUMN 可省略
ADD t VARCHAR(10) AFTER ID; # 新增在ID後面
#ADD (t1 INT, t2 INT); # 增加多欄位，但只能放最後面
```
#### 修改
```sql
ALTER TABLE neko
#CHANGE tt new_tt INT DEFAULT 100 AFTER ID; # 可以修改欄位名稱、重新定義、改位置
MODIFY t CHAR(5) FIRST; # 和CHANGE差在不能改名稱
```
#### 刪除 (!!!不會有確認刪除!!!)
```sql
ALTER TABLE neko
DROP COLUMN t; # COLUMN 可省略
```



