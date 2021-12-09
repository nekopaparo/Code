# 資料表 TABLE 
|[MySQL](.)|[DATABASE](./DATABASE.md)|[DATA](./DATA.md)|
|-|-|-|

|[Table](#Table)|[欄位](#欄位)|
|-|-|

##### 相關資訊
```sql
SHOW TABLES FROM world;

SELECT
	TABLE_SCHEMA,	# 資料庫名稱
	TABLE_NAME,		# 表格名稱
	ENGINE,			# 使用的引擎
	TABLE_ROWS,		# 記錄數量
	AUTO_INCREMENT,	# AUTO_INCREMENT 目前儲存紀錄
	TABLE_COLLATION	# 排序集
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'world';
```
##### 修改預設引擎
```sql
#直接修改my.ini設定檔 -> default-storage-engine=InnoDB

SET GLOBAL storage_engine = InnoDB; # 伺服器重啟便會失效

SET SESSION storage_engine = InnoDB;# 客戶端離線便會失效
SET storage_engine = InnoDB;        # 客戶端離線便會失效
```
---
## Table
### 新增
```sql
CREATE TABLE neko(
  ID INT UNSIGNED AUTO_INCREMENT KEY,
  # 數值欄位特有: 
  # UNSIGNED -> 不能儲存負數 
  # AUTO_INCREMENT -> 自動累計，系統會儲存累計如有比他大，便會用該數+1，從1開始累計
  Name CHAR(20) UNIQUE NOT NULL, # UNIQUE -> 不可重複
  Sex VARCHAR(20) DEFAULT '無' # DEFAULT -> 預設
)ENGINE = InnoDB 			# 可省略  # 儲存引擎可用SHOW ENGINES查詢
 CHARACTER SET = utf8		# 會用 	  # UTF8已棄用，請改用UTF8MB4
 COLLATE = utf8_unicode_ci;	# 系統預設

CREATE TABLE tstable(
  ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  # CURRENT_TIMESTAMP -> 目前時間 # ON UPDATE -> 修改動作時進行
  ts2 TIMESTAMP DEFAULT '0000-00-00 00:00:00',
  area VARCHAR(20) NOT NULL,
  temp INT NOT NULL
);

#從已存在資料表複製格式(設定)建立新資料表
CREATE TABLE IF NOT EXISTS newneko
LIKE neko; 

# UNSIGNED ZEROFILL -> 少的會補0，將被移除不建議使用請使用LPAD()
# 要用ZEROFILL一定要搭配UNSIGNED
```
##### * 暫存表格(TEMPORARY)
```sql
# TEMPORARY -> 暫存表格，用戶端離線便會刪除
# 建立資料表的名字已存在時，資料庫的會被隱藏，重開就能再次讀取
CREATE TEMPORARY TABLE neko(
	ID VARCHAR(5),	
    Name VARCHAR(5)
);
```
### 修改Table名稱
```sql
ALTER TABLE new_neko RENAME TO neko; # TO 可省略，可用在暫存資料表
RENAME TABLE neko TO neko1, neko3 TO neko4; # 可一次多個修改，無法使用在暫存資料表
```
### 刪除 (!!!不會有確認刪除!!!)
```sql
DROP TABLE IF EXISTS neko1, neko4; #多個table刪除
```
---
## 欄位
### 新增
```sql
ALTER TABLE neko
#ADD COLUMN tt VARCHAR(10) FIRST; # COLUMN 可省略
ADD t VARCHAR(10) AFTER ID; # 新增在ID後面
#ADD (t1 INT, t2 INT); # 增加多欄位，但只能放最後面
```
### 修改
```sql
ALTER TABLE neko
#CHANGE tt new_tt INT DEFAULT 100 AFTER ID; # 可以修改欄位名稱、重新定義、改位置
MODIFY t CHAR(5) FIRST; # 和CHANGE差在不能改名稱
```
### 刪除 (!!!不會有確認刪除!!!)
```sql
ALTER TABLE neko
DROP COLUMN t; # COLUMN 可省略
```