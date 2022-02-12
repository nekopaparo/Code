# 資料表 TABLE 
|[MSSQL](.)|[DATABASE](./DATABASE.md)|[DATA](./DATA.md)|[KEY](./KEY.md)|[VIEW](./VIEW.md)|
|-|-|-|-|-|

---
|[Table](#Table)|[欄位](#欄位)|
|-|-|

## Table
### 新增
```sql
-- 建立資料表
CREATE TABLE Products  
  (ProductID int PRIMARY KEY NOT NULL,  
   ProductName varchar(25) NOT NULL,  
   Price money NULL,  
   ProductDescription varchar(max) NULL)  
GO
```
##### TEMPORARY
```sql
-- 暫存表格1，用戶端離線便會刪除
CREATE TABLE #neko(
  ID VARCHAR(5),	
  Name VARCHAR(5)
)
GO
SELECT * FROM #neko
GO
```
##### DECLARE
```sql
-- 暫存表格2，存在記憶體中，執行完就會刪除
DECLARE @neko TABLE (
  ID VARCHAR(5),	
  Name VARCHAR(5)
)
GO
```
### 刪除 (!!!不會有確認刪除!!!)
```sql
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Products') DROP TABLE Products
GO 
```
---
## 欄位
### 新增
```sql
-- 新增資料
INSERT Products 
(ProductName, ProductID, Price, ProductDescription)  
VALUES 
('Clamp', 1, 12.48, 'Workbench'),
('Screwdriver', 50, 3.17, 'Flat head'),
('Tire Bar', 75, NULL, 'Flat head'),
('3 mm Bracket', 3000, 0.52, 'Flat head')
GO
```
### 修改
```sql
-- 更新資料
UPDATE Products
SET ProductName = 'Flat Head Screwdriver'  
WHERE ProductID = 50  
GO  
```
### 刪除 (!!!不會有確認刪除!!!)
```sql
DROP TABLE Products
GO
```