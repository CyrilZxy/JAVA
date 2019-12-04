

库：
create database 库名 （IF NOT EXISTS 库名）；	建库
show databases； 				查看有哪些库
drop database 库名；			删除
use 库名；				设置默认库
show create database 库名；		查看建库的语句

表：
create table 表名 (                      )；	 	建表列定义
show table； 				查看有哪些表
select database()；				查看当前库
select  *  from 表名；			显示表内内容，全列查询
select 属性，属性+10 AS 别名 from 表名；
select distinct 属性 from 表名;			去重操作


mysql> create table student(
    -> id int,
    -> sn int comment '学号',
    -> name varchar(20) comment '姓名',
    -> mail varchar(20) comment '邮箱'
    -> );
    
    
mysql> insert into student values(001,3055,'张欣悦','115@qq.com');
Query OK, 1 row affected (0.02 sec)

mysql> insert into student values(002,3056,'王倩倩','123@qq.com');
Query OK, 1 row affected (0.01 sec)

mysql> insert into student values(003,3057,'巴啦啦',null);
mysql> insert into student values(003,3057,'巴啦啦',null);

mysql> insert into student(id,sn,name)values
    -> (004,3077,'宫素'),
    -> (005,3078,'刘子晴');
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> select id,name from student;
mysql> select id,name,sn+10 from student;
mysql> select id,name,sn+10 SN from student;
mysql> select id,name,sn+10 AS SN from student;
mysql> select distinct sn from student;