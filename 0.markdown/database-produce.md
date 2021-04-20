# 存储过程

## Oracle 存储过程

### 被命名的 PL/SQL 块，存储于数据库中，是数据库对象的一种。应用程序可以调用存储过程，执行相应的逻辑。

### 存储过程与存储函数区别

- 都可以封装一定的业务逻辑并返回结果
- 存储函数中有返回值，且必须返回；而存储过程没有返回值，可以通过传出参数返回多个值。
- 存储函数可以在 select 语句中直接使用，而存储过程不能。过程多数是被应用程序所调用
- 存储函数一般都是封装一个查询结果，而存储过程一般都封装一段事务代码

### 语法结构

- CREATE [ OR REPLACE ] PROCEDURE 存储过程名称
（参数名 类型, 参数名 类型, 参数名 类型）
IS|AS
	变量声明部分;
BEGIN
	逻辑部分
	[EXCEPTION 异常处理部分]
END;
- 参数只指定类型，不指定长度

### 过程参数

- IN 传入参数（默认）
- OUT 传出参数 ，主要用于返回程序运行结果
- IN OUT 传入传出参数

### 示例

- --增加业主信息存储过程
create or replace procedure pro_owners_add 
(v_name varchar2,
v_addressid number,
v_housenumber varchar2, 
v_watermeter varchar2,
v_type number)
is
begin
insert into T_OWNERS 
	values( seq_owners.nextval,v_name,v_addressid,
	v_housenumber,v_watermeter,sysdate,v_type );
commit;
end;

### 调用

- PL/SQL 中调用存储过程

	- call pro_owners_add('赵伟',1,'999-3','132-7',1);

- JDBC 调用存储过程

	- conn=BaseDao.getConnection();
stmt=conn.prepareCall("{call pro_owners_add(?,?,?,?,?)}");
stmt.setString(1, owners.getName());
stmt.setLong(2, owners.getAddressid());
stmt.setString(3, owners.getHousenumber());
stmt.setString(4, owners.getWatermeter());
stmt.setLong(5, owners.getOwnertypeid());
stmt.execute();

