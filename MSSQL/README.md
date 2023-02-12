# SQL Server
|[DATABASE](./DATABASE.md)|[TABLE](./TABLE.md)|[DATA](./DATA.md)|[KEY](./KEY.md)|[VIEW](./VIEW.md)|
|-|-|-|-|-|

|[sa](sa.md)|Server預設的最大權限帳號|
|-|-|


## 開起/關閉資料庫變動權限
+ 工具 -> 選項 -> 設計師 -> 防止儲存需要資料表重建的變更

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
-- LIMIT
SELECT TOP 10 *
FROM City
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
## 待整理
```sql
-- 建立預存
ALTER PROCEDURE [dbo].[TEST]    /*注意: 名稱不能是sp_開頭!("sp_"是預留給系統的))*/
	@FirstName nvarchar(20), 
	@LastName nvarchar(20),
	@age int
AS
BEGIN
    SELECT @FirstName AS [姓], @LastName AS [名], @age AS [年齡]
END 
GO
-- 呼叫預存
EXEC [dbo].[TEST] 'Neko', 'Para', 5                                 -- 方法1 依序傳遞
EXEC [dbo].[TEST] @FirstName = 'Neko', @LastName = 'Para', @age = 5 -- 方法2 指定傳遞
GO
-- 條件判斷式
DECLARE @A int
SET @A = 10
SELECT
CASE
    WHEN @A > 10 THEN 11
    WHEN @A < 10 THEN 12
    ELSE 13
END
GO
-- if else
DECLARE @B int
SET @B = 0
IF @B > 0
    BEGIN
        PRINT N'Hello World 1'
    END
ELSE IF @B < 0
    BEGIN
        PRINT N'Hello World 2'
    END
ELSE
    BEGIN
        PRINT N'Hello World 3'
    END
GO
-- try catch
DECLARE @C int
BEGIN TRY
    SET @C = '%'
    PRINT N'Kirito'
END TRY
BEGIN CATCH
	PRINT N'Hi ERROR'
	PRINT ERROR_MESSAGE()
END CATCH
GO
-- T-SQL 交易管理
DECLARE @D int
BEGIN TRY

    BEGIN TRANSACTION       -- 開啟交易

        UPDATE [MES_T].[dbo].[Member]
        SET GroupID = 1
        WHERE UserID = 'TT05260'

        PRINT @@ERROR		-- 錯誤代碼，成功 = 0
        PRINT @@ROWCOUNT	-- 異動筆數

        SET @D = '%'

        UPDATE [MES_T].[dbo].[Member]
        SET GroupID = 6
        WHERE UserID = 'TT05260'

    COMMIT TRANSACTION      -- 結束(送出)交易

END TRY
BEGIN CATCH
	ROLLBACK TRANSACTION    -- 終止(回復)交易
END CATCH
GO

-- 例外跳出
BEGIN TRY
    RAISERROR('HAHAHA', 16, 1)  -- (錯誤訊息, 嚴重性(severity) 0~25, state 0~255)
    THROW 50000, 'HAHAHA', 16   -- (error_number 50000 ~ 2147483647, 錯誤訊息, state 0 ~ 255)
END TRY
BEGIN CATCH
    RAISERROR('HAHAHA', 16, 1)
	THROW 50000, 'HAHAHA', 16   -- 只能在try catch中使用
END CATCH
RAISERROR('HAHAHA', 16, 1)      -- 能直接使用 (建議改用THROW)
GO
```