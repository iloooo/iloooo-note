# Oracle

## 视图

### 从表中抽出的逻辑上相关的数据集合

### 虚表

### 控制数据访问

### 简化查询

### 避免重复访问相同的数据

## 索引

## 序列

### 可供多个用户用来产生唯一数值的数据库对象

### 自动提供唯一的数值

### 共享对象

### 主要用于提供主键值

### 将序列值装入内存可以提高访问效率

## 同义词-synonym

### 方便访问其它用户的对象

### 缩短对象名字的长度

## PL/SQL

### 对 SQL 语言存储过程语言的扩展

## 存储函数

### 自定义函数。可以接收一个或多个参数，返回一个结果。在函数中我们可以使用 P/SQL 进行逻辑的处理。

### 语法结构

- CREATE [ OR REPLACE ] FUNCTION 函数名称
（参数名称 参数类型, 参数名称 参数类型, ...）
RETURN 结果变量数据类型
IS
	变量声明部分;
BEGIN
	逻辑部分;
	RETURN 结果变量;
	[EXCEPTION 异常处理部分]
END;

### 示例

- create function fn_getaddress(v_id number) 
return varchar2
is
	v_name varchar2(30);
begin
	select name into v_name from t_address where id=v_id;
return v_name;
end;

### 调用

- select fn_getaddress(3) from dual

## 存储过程

### 被命名的 PL/SQL 块，存储于数据库中，是数据库对象的一种。应用程序可以调用存储过程，执行相应的逻辑。

## 触发器

### 数据库触发器是一个与表相关联的、存储的 PL/SQL 程序。

### 每当一个特定的数据操作语句(Insert,update,delete)在指定的表上发出时，Oracle 自动地执行触发器中定义的语句序列。

