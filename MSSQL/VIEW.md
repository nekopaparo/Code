# VIEW
|[MSSQL](.)|[DATABASE](./DATABASE.md)|[TABLE](./TABLE.md)|[DATA](./DATA.md)|[KEY](./KEY.md)|
|-|-|-|-|-|

|[建立](#建立)|[修改](#修改)|[刪除](#刪除)|
|-|-|-|
## 查看
```sql
#查看資料庫中所有的VIEW
SELECT *
FROM INFORMATION_SCHEMA.VIEWS
GO

#使用VIEW
SELECT * 
FROM SurfaceArea_VIEW;
```

## 建立
```sql
CREATE VIEW SurfaceArea_VIEW AS
SELECT Region, SUM(SurfaceArea) SUM_SurfaceArea
FROM country
GROUP BY Region
GO
```

## 修改
```sql
ALTER VIEW SurfaceArea_VIEW AS
SELECT Region, MAX(SurfaceArea) MAX_SurfaceArea
FROM country
GROUP BY Region
GO
```

## 刪除
```sql
IF EXISTS ( 
	SELECT TABLE_NAME 
	FROM INFORMATION_SCHEMA.VIEWS 
	WHERE TABLE_NAME = 'SurfaceArea_VIEW'
	)	DROP VIEW SurfaceArea_VIEW
```