# VIEW
|[MySQL](.)|[DATABASE](./DATABASE.md)|[TABLE](./TABLE.md)|[DATA](./DATA.md)|[KEY](./KEY.md)|
|-|-|-|-|-|

|[建立](#建立)|[修改](#修改)|[刪除](#刪除)|
|-|-|-|
## 查看
```sql
#查看VIEW的設定
DESC CountryMaxGNP;

#查看資料庫中所有的VIEW
SELECT *
FROM information_schema.VIEWS;

#使用VIEW
SELECT * 
FROM CountryMaxGNP;
```

## 建立
```sql
CREATE VIEW CountryMaxGNP AS
SELECT Name, GNP
FROM country
WHERE (Region, GNP) IN (SELECT Region, MAX(GNP)
                        FROM country
                        GROUP BY Region);
```

## 修改
```sql
# OR REPLACE -> 不存在會新增，已存在會修改
CREATE OR REPLACE VIEW CountryMaxGNP AS 
#ALTER VIEW CountryMaxGNP AS # 不存在會ERROR
SELECT Code, Name, GNP
FROM country
WHERE (Region, GNP) IN (SELECT Region, MAX(GNP)
                        FROM country
                        GROUP BY Region);
```

## 刪除
```sql
DROP VIEW IF EXISTS CountryMaxGNP;
```