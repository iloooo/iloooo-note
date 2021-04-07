# 数据库事务
(Transaction)

## 概念

### 数据库操作的最基本单元，逻辑上是一组操作，要么都成功，一败具败

### 一组操作语句：DML语句

### 事务管理语句：TCL语句

## 事务的4个特性（ACID）

### 1. 原子性（Atomicity）：操作要么都发生，要么都不发生

### 2. 一致性（Consistency）：必须使数据库从一个一致性状态变换到另外一个一致性状态

### 4. 持久性（Durability）：1个事务一旦被提交，它对数据库中数据的改变就是永久性的

### 3.隔离性（Isolation）：1个事务的执行不能被其他事务干扰

- 多个事务期间操作相同数据可能导致的并发问题：

	- 脏读：事务1读取到了事务2未提交的数据（T1读到T2未提交更新的数据，T2后面又回滚）

		- 

	- 不可重复读：同一个事务中，多次读取到的数据不一致 （T1读完数据，T2提交更新TI已读数据，T1再次读）

		- 

	- 幻读：读到老数据（T1读完数据T2才开始，T1没读到T2提交更新的数据）

		- 

- 事务隔离级别

	- 1、read uncommitted （读未提交数据）

		- MySQL

	- 2、read committed （读已提交数据）可以避免脏读

		- Oracle（默认）
		- MySQL

	- 3、repeatable read（可重复读）可以避免脏读、不可重复读和一部分幻读

		- MySQL（默认）

	- 4、serializable（串行化）可以避免脏读、不可重复读和幻读

		- Oracle
		- MySQL

## 事务管理操作（TCL）

### 主要操作：

- 创建（create）
- 提交（commit）
- 回滚（rollback）
- 关闭（close）

### MySQL

- 开关自动提交(默认开)

	- 开：SET AUTOCOMMIT = 1;
	- 关：SET AUTOCOMMIT = 0;

- 隔离级别

	- 查看当前的隔离级别：SELECT @@tx_isolation;
	- 设置当前连接的隔离级别: 
set transaction isolation level read committed;
	- 设置全局的隔离级别:
set global transaction isolation level read committed;

- 创建事务

	- 开启事务：start transaction;
	- DDL 或 DCL 语句（自动提交）
	- COMMIT 或 ROLLBACK 语句

- MySQL中事务的实现原理

### Oracle：TODO

## Spring 事务管理

## JDBC事务管理

## Mybatis事务管理

### MyBatis自身不会去实现事务管理，两种方式，一种JDBC，一种是让程序的容器如（JBOSS，Weblogic）来实现对事务的管理

