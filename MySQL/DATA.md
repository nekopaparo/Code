# 資料維護 DATA
|[MySQL](.)|[DATABASE](./DATABASE.md)|[TABLE](./TABLE.md)|[KEY](./KEY.md)|[VIEW](./VIEW.md)|
|-|-|-|-|-|

```sql
#表格資訊(相關設定)
DESCRIBE cmdev.dept;
#DESC cmdev.dept; #簡化寫法
```

## 新增
```sql
INSERT IGNORE INTO cmdev.dept #略過錯誤訊息 
VALUES (90, 'SHIPPING_1', DEFAULT); #DEFAULT->使用預設值

#新增資料，主索引(KEY)資料已存在時會發生ERROR
INSERT INTO cmdev.dept
(deptno, dname) VALUES (91, 'SHIPPING_2'), (92, 'SHIPPING_3'); #未指定欄位會被寫入NULL

#主索引資料已存在時會進行指定條件取代資料
INSERT INTO cmdev.dept
(deptno, dname) VALUES (91, 'SHIPPING_2')
ON DUPLICATE KEY UPDATE dname = CONCAT(dname, '.'), location = 'TAIWAN'; 

#同INSERT，差在KEY已存在時，會直接覆蓋形成新資料
REPLACE INTO cmdev.dept
(deptno, dname) VALUES (91, 'SHIPPING_2');
```
## 修改
```sql
UPDATE cmdev.emp
SET salary = salary + 100
WHERE salary < 1500;

#salary不可為字串，會發生ERROR，資料不會做任何修改
UPDATE cmdev.emp
SET salary = 'HELLO', comm = 1000
WHERE empno = 8888;

#有問題的地方會被填入0，不會發生ERROR，資料會更新
UPDATE IGNORE cmdev.emp
SET salary = 'HELLO', comm = 1000
WHERE empno = 8888;

#編號倒數3個人薪水+1元
UPDATE cmdev.emp
SET salary = salary + 1
WHERE empno < 8000
ORDER BY empno DESC
LIMIT 3; #在這邊只能指定數量，不能用跳過
```
## 刪除
```sql
DELETE IGNORE FROM cmdev.dept #IGNORE忽略錯誤
WHERE deptno >= 90
ORDER BY deptno
Limit 1;

#刪除表格內所有資料，資料很多時刪除效率 TRUNCATE > DELETE
DELETE FROM cmdev.dept; 
TRUNCATE TABLE cmdev.dept; #TABLE可省略
```