# MySQL
|[DATABASE](./DATABASE.md)|[TABLE](./TABLE.md)|[DATA](./DATA.md)|
|-|-|-|

|[基本](#基本)|[WHERE](#WHERE)|[常用方法](#常用方法)|[IF - WHEN](#IF%20-%20WHEN)|[分組](#分組)|[內部結合](#INNER)|
|-|-|-|-|-|-|

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