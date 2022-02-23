# SQL Server

|[DATABASE](./DATABASE.md)|[TABLE](./TABLE.md)|[DATA](./DATA.md)|[KEY](./KEY.md)|[VIEW](./VIEW.md)|
|-|-|-|-|-|

|[sa](sa.md)|Server預設的最大權限帳號|
|-|-|


## 無ldf檔時的匯入方法
```sql
sp_attach_single_file_db
@dbname = 'ch2_DB',
@physname = 'D:\ch2_DB.mdf';
```
## 基本SQL
```sql
-- 查詢資料庫
SELECT * 
FROM sysdatabases 
GO /* 分隔陳述式 = ; */
-- 使用資料庫
USE world
GO
-- SHOW TABLES
SELECT * 
FROM SYSOBJECTS
WHERE xtype = 'U'
GO
-- 基本查詢
SELECT * FROM City
WHERE CountryCode IN ('AFG', 'NLD', 'BRA') and Population > 100000
ORDER BY ID DESC
GO

-- 別名 AS 可省略
SELECT ProductName, Price * 1.07 AS CustomerPays
FROM Products 
GO
-- 內部結合
SELECT *
FROM City
INNER JOIN Country
ON CountryCode = Code
GO
-- 排序
SELECT * 
FROM Country
ORDER BY Name DESC /* ASC */
GO
-- 群組統計
SELECT Continent, Region
FROM Country
GROUP BY Continent, Region WITH ROLLUP
ORDER BY Continent DESC
GO
```