# SQL Server

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
-- 使用資料庫
USE world
GO /* 分隔陳述式 = ; */
-- 基本查詢
SELECT * FROM City
WHERE CountryCode IN ('AFG', 'NLD', 'BRA') and Population > 100000
ORDER BY ID DESC
GO
-- 建立資料表
CREATE TABLE Products  
  (ProductID int PRIMARY KEY NOT NULL,  
   ProductName varchar(25) NOT NULL,  
   Price money NULL,  
   ProductDescription varchar(max) NULL)  
GO
-- 新增資料
INSERT Products 
(ProductName, ProductID, Price, ProductDescription)  
VALUES 
('Clamp', 1, 12.48, 'Workbench'),
('Screwdriver', 50, 3.17, 'Flat head'),
('Tire Bar', 75, NULL, 'Flat head'),
('3 mm Bracket', 3000, 0.52, 'Flat head')
GO
-- 更新資料
UPDATE Products
SET ProductName = 'Flat Head Screwdriver'  
WHERE ProductID = 50  
GO  

SELECT ProductName, Price, Price * 1.07 AS CustomerPays -- 別名
FROM Products 
```