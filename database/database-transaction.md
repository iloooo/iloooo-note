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

### 编程式事务管理

- PlatformTransactionManager：事务管理器 

	- 

- TransactionDefinition：定义信息对象

	- 事务隔离级别

		- ISOLATION_DEFAULT
		- ISOLATION_READ_UNCOMMITTED
		- ISOLATION_READ_COMMITTED
		- ISOLATION_REPEATABLE_READ
		- ISOLATION_SERIALIZABLE

	- 事务传播行为

	  https://mp.weixin.qq.com/s/xFnVBqcVNRFQfHyd03iWcg3.3.1https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247486668&idx=2&sn=0381e8c836442f46bdc5367170234abb&chksm=cea24307f9d5ca11c96943b3ccfa1fc70dc97dd87d9c540388581f8fe6d805ff548dff5f6b5b&token=1776990505&lang=zh_CN&scene=21#wechat_redirect

		- 支持当前事务

			- TransactionDefinition.PROPAGATION_REQUIRED： 如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
			- TransactionDefinition.PROPAGATION_SUPPORTS： 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
			- TransactionDefinition.PROPAGATION_MANDATORY： 如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。（mandatory：强制性）

		- 不支持当前事务

			- TransactionDefinition.PROPAGATION_REQUIRES_NEW： 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
			- TransactionDefinition.PROPAGATION_NOT_SUPPORTED： 以非事务方式运行，如果当前存在事务，则把当前事务挂起。
			- TransactionDefinition.PROPAGATION_NEVER： 以非事务方式运行，如果当前存在事务，则抛出异常。

		- 其他情况

			- TransactionDefinition.PROPAGATION_NESTED： 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。

	- 

- TransactionStatus：事务具体的运行状态 

	- 

### 声明式事务管理

- 底层是AOP
- 实现方式

	- XML

		- ①引入tx命名空间

		  <beans xmlns="http://www.springframework.org/schema/beans"
		     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		     xmlns:context="http://www.springframework.org/schema/context"
		     xmlns:aop="http://www.springframework.org/schema/aop"
		     xmlns:tx="http://www.springframework.org/schema/tx"
		     xsi:schemaLocation="
		      http://www.springframework.org/schema/context
		      http://www.springframework.org/schema/context/spring-context.xsd
		      http://www.springframework.org/schema/aop
		      http://www.springframework.org/schema/aop/spring-aop.xsd
		      http://www.springframework.org/schema/tx 
		      http://www.springframework.org/schema/tx/spring-tx.xsd
		      http://www.springframework.org/schema/beans
		      http://www.springframework.org/schema/beans/spring-beans.xsd">

		- ②配置事务增强

		  <!--平台事务管理器-->
		  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		    <property name="dataSource" ref="dataSource"></property>
		  </bean>
		  <!--事务增强配置-->
		  <tx:advice id="txAdvice" transaction-manager="transactionManager">
		    <tx:attributes>
		      <tx:method name="*"/>
		    </tx:attributes>
		  </tx:advice>

			- 切点方法的事务参数的配置

			  <!--事务增强配置-->
			     <tx:advice id="txAdvice" transaction-manager="transactionManager">
			         <tx:attributes>
			             <tx:method name="*"/>
			         </tx:attributes>
			     </tx:advice>
			  其中，tx:method 代表切点方法的事务参数的配置，例如：
			    <tx:method name="transfer" isolation="REPEATABLE_READ" propagation="REQUIRED" timeout="-1" read-only="false"/>
			   
			  - name：切点方法名称
			  - isolation:事务的隔离级别
			  - propogation：事务的传播行为
			  - timeout：超时时间
			  - read-only：是否只读

		- ③配置事务 AOP 织入

		  <!--事务的aop增强-->
		  <aop:config>
		    <aop:pointcut id="myPointcut" expression="execution(* com.itheima.service.impl.*.*(..))"/>
		    <aop:advisor advice-ref="txAdvice" pointcut-ref="myPointcut"></aop:advisor>
		  </aop:config>

		- ④使用事务

		  @Override
		  public void transfer(String outMan, String inMan, double money) {
		    accountDao.out(outMan,money);
		    int i = 1/0;
		    accountDao.in(inMan,money);
		  }

	- 注解

		- 使用 @Transactional 相当于：<tx:method>

		  ，注解可用的属性同 xml 配置方式，例如隔离级别、传播行为等。 在需要进行事务控制的类或是方法上修饰

			- 注解使用在类上，那么该类下的所有方法都使用同一套注解参数配置。
			- 使用在方法上，不同的方法可以采用不同的事务参数配置。(只能应用到 public 方法)
			- 常用参数

				- 

		- ④xml开启事务的注解驱动<tx:annotation-driven />

