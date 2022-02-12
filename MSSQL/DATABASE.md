# 資料庫 DATABASE
|[MSSQL](.)|[TABLE](./TABLE.md)|[DATA](./DATA.md)|[KEY](./KEY.md)|[VIEW](./VIEW.md)|
|-|-|-|-|-|

## 新增
```sql
IF EXISTS(SELECT * FROM sysdatabases WHERE name='mydb') CREATE DATABASE mydb
GO
```

## 刪除
```sql
-- !!!!!!不會跟你確認是否刪除，請小心使用!!!!!!
IF EXISTS(SELECT * FROM sysdatabases WHERE name='mydb') CREATE DATABASE mydb
GO
-- !!!!!!不會跟你確認是否刪除，請小心使用!!!!!!
```