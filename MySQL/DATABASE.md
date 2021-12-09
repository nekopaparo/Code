# 資料庫 DATABASE
|[MySQL](.)|[TABLE](./TABLE.md)|[DATA](./DATA.md)|[KEY](./KEY.md)|[VIEW](./VIEW.md)|
|-|-|-|-|-|

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

## 新增
```sql
#IF NOT EXISTS -> 如果已存在就不建立，不會產生ERROR
CREATE DATABASE IF NOT EXISTS mydb
CHARACTER SET utf8 #可省略，會使用系統預設
COLLATE utf8_unicode_ci; #可省略，會使用系統預設
```

## 修改 
```sql
ALTER DATABASE mydb
CHARACTER SET utf8 #修改字元
COLLATE utf8_unicode_ci; #修改排序
```

## 刪除
```sql
# !!!!!!不會跟你確認是否刪除，請小心使用!!!!!!
DROP DATABASE IF EXISTS mydb; #IF EXISTS -> 資料庫有存在才刪除，不會產生ERROR
# !!!!!!不會跟你確認是否刪除，請小心使用!!!!!!
```