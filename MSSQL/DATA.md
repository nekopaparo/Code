# 資料維護 DATA
|[MySQL](.)|[DATABASE](./DATABASE.md)|[TABLE](./TABLE.md)|[KEY](./KEY.md)|[VIEW](./VIEW.md)|
|-|-|-|-|-|

```sql
-- 表格資訊(相關設定)
EXEC sp_columns Products 
GO
```

## 新增
```sql
INSERT INTO Products (ProductID, ProductName) 
VALUES (1, 'json'), (2, 'gura') 
GO
```
## 修改
```sql
UPDATE Products
SET ProductName = 'peko'
WHERE ProductID = 1
GO
```
## 刪除
```sql
DELETE FROM Products
WHERE ProductID >= 2
GO
-- 刪除表格內所有資料，資料很多時刪除效率 TRUNCATE > DELETE
DELETE FROM Products
GO
TRUNCATE TABLE Products
GO
```