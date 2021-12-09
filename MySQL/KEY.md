# KEY(索引)
|[MySQL](.)|[DATABASE](./DATABASE.md)|[TABLE](./TABLE.md)|[DATA](./DATA.md)|
|-|-|-|-|

|[新增](#建立索引)|[刪除](#刪除索引)|[AUTO_INCREMENT](#AUTO_INCREMENT)|
|-|-|-|

## 查詢索引資訊
```sql
SHOW INDEX FROM mydb.addressbook;
```

## 建立索引
### 新增TABLE時建立
```sql
# 索引寫在後面
CREATE TABLE mydb.addressbook (
    # PRIMARY KEY -> 主索引
    id INT UNSIGNED PRIMARY KEY,
    name VARCHAR(20),
    tel VARCHAR(20),
    address VARCHAR(80),
    birthdate DATE,
    # UNIQUE KEY -> 一般索引，UNIQUE(不可重複)
    email VARCHAR(20) UNIQUE KEY,
    INDEX (name, tel)
);
# 索引寫在最下面
CREATE TEMPORARY TABLE addressbook (
    id INT UNSIGNED,
    name VARCHAR(20),
    tel VARCHAR(20),
    address VARCHAR(80),
    birthdate DATE,
    email VARCHAR(20),
    PRIMARY KEY (id),
    UNIQUE KEY (email),
    INDEX (name, tel)
);
```
### 事後建立
```sql
CREATE TEMPORARY TABLE addressbook (
    id INT UNSIGNED,
    name VARCHAR(20),
    tel VARCHAR(20),
    address VARCHAR(80),
    birthdate DATE,
    email VARCHAR(20)
);

#建立主索引
ALTER TABLE addressbook
ADD PRIMARY KEY /*indexname*/ (name);

#建立唯一索引、一般索引
# 1)這種一定要替索引取名
CREATE UNIQUE INDEX email_index 
ON addressbook (email);
# 2)
CREATE INDEX name_tel_index
ON addressbook (name, tel);
# 3)
CREATE INDEX address_index
ON addressbook (address (5) DESC);
```

## 刪除索引
```sql
DROP INDEX address_index ON addressbook;

ALTER TABLE addressbook
DROP PRIMARY KEY, # -> 刪除主索引
DROP KEY name, # -> 沒取名的索引 # INDEX (name, tel)
DROP INDEX name_tel_index,
DROP INDEX name_tel_index;
```
## AUTO_INCREMENT
```sql
#在 引擎:MyISAM 中特殊用法 -> 自動累加
CREATE TEMPORARY TABLE travelautoincr (
    empno INT NOT NULL,
    location VARCHAR(16) NOT NULL,
    counter SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (empno, location, counter)
)ENGINE = MyISAM;

INSERT INTO travelautoincr (empno, location)
VALUES  (7369, 'CHICAGO'),(7369, 'CHICAGO'),
        (7499, 'DALLAS'),(7499, 'DALLAS'),
        (7499, 'DALLAS'),(7566, 'BOSTON'),
        (7566, 'BOSTON');
```