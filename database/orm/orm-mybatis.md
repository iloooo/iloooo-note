# Mybatis

## 简介

### MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架

### MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集

### MyBatis 可以对配置和原生Map使用简单的 XML 或注解，将接口和 Java 的 POJOs映射成数据库中的记录

## 全局配置文件：

### configuration（顶层）

### properties（属性） 

<!--通过properties标签加载外部properties文件-->
<properties resource= "jdbc.properties" ></properties>

### settings（设置）

<!-- 
   2、settings包含很多重要的设置项
   setting:用来设置每一个设置项
      name：设置项名
      value：设置项取值
 -->
<settings>
   <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>

### typeAliases（类型别名）

<!-- 3、typeAliases：别名处理器：可以为我们的java类型起别名 
      别名不区分大小写
-->
<typeAliases>
   <!-- 1、typeAlias:为某个java类型起别名
         type:指定要起别名的类型全类名;默认别名就是类名小写；employee
         alias:指定新的别名
    -->
   <!-- <typeAlias type="com.atguigu.mybatis.bean.Employee" alias="emp"/> -->
   
   <!-- 2、package:为某个包下的所有类批量起别名 
         name：指定包名（为当前包以及下面所有的后代包的每一个类都起一个默认别名（类名小写），）
   -->
   <package name="com.atguigu.mybatis.bean"/>
   
   <!-- 3、批量起别名的情况下，使用@Alias注解为某个类型指定新的别名 -->
</typeAliases>

### typeHandlers（类型处理器）

### objectFactory（对象工厂）

### plugins（插件）

### environments（环境配置）

<!-- 
   4、environments：环境们，mybatis可以配置多种环境 ,default指定使用某种环境。可以达到快速切换环境。
      environment：配置一个具体的环境信息；必须有两个标签；id代表当前环境的唯一标识
         transactionManager：事务管理器；
            type：事务管理器的类型;JDBC(JdbcTransactionFactory)|MANAGED(ManagedTransactionFactory)
               自定义事务管理器：实现TransactionFactory接口.type指定为全类名
         dataSource：数据源;
            type:数据源类型;UNPOOLED(UnpooledDataSourceFactory)
                     |POOLED(PooledDataSourceFactory)
                     |JNDI(JndiDataSourceFactory)
            自定义数据源：实现DataSourceFactory接口，type是全类名
    -->
<environments default="dev_mysql">
   <environment id="dev_mysql">
      <transactionManager type="JDBC"></transactionManager>
      <dataSource type="POOLED">
         <property name="driver" value="${jdbc.driver}" />
         <property name="url" value="${jdbc.url}" />
         <property name="username" value="${jdbc.username}" />
         <property name="password" value="${jdbc.password}" />
      </dataSource>
   </environment>

   <environment id="dev_oracle">
      <transactionManager type="JDBC" />
      <dataSource type="POOLED">
         <property name="driver" value="${orcl.driver}" />
         <property name="url" value="${orcl.url}" />
         <property name="username" value="${orcl.username}" />
         <property name="password" value="${orcl.password}" />
      </dataSource>
   </environment>
</environments>

- environment（环境变量）
- transactionManager（事务管理器）

	- 一般不配置，使用Spring声明式事务

- dataSource（数据源）

	- 一般不配置，而是使用spring整合中配置数据库连接池

	  <!--加载jdbc.properties-->
	  <context:property-placeholder location="classpath:jdbc.properties"/>
	  <!--配置数据源-->
	  <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
	     <property name="driverClass" value="${jdbc.driver}"/>
	     <property name="jdbcUrl" value="${jdbc.url}"/>
	     <property name="user" value="${jdbc.username}"/>
	     <property name="password" value="${jdbc.password}"/>
	  </bean>
	   
	  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	  <!-- 指定mybatis全局配置文件位置 -->
	  <property name="configLocation" value="classpath:mybatis/mybatis-config.xml"></property>
	  <!--指定数据源 -->
	  <property name="dataSource" ref="dataSource"></property>
	  <!--mapperLocations：所有sql映射文件所在的位置 -->
	  <property name="mapperLocations" value="classpath:mybatis/mapper/*.xml"></property>
	  <!--typeAliasesPackage：批量别名处理-->
	  <property name="typeAliasesPackage" value="com.atguigu.bean"></property>
	  </bean>

### databaseIdProvider（数据库厂商标识）

<!-- 5、databaseIdProvider：支持多数据库厂商的；
    type="DB_VENDOR"：VendorDatabaseIdProvider
      作用就是得到数据库厂商的标识(驱动getDatabaseProductName())，mybatis就能根据数据库厂商标识来执行不同的sql;
      MySQL，Oracle，SQL Server,xxxx
  -->
<databaseIdProvider type="DB_VENDOR">
   <!-- 为不同的数据库厂商起别名 -->
   <property name="MySQL" value="mysql"/>
   <property name="Oracle" value="oracle"/>
   <property name="SQL Server" value="sqlserver"/>
</databaseIdProvider>

### mappers（映射器）

mapper逐个注册SQL映射文件
  <mappers>
       <mapper resource="com/itheima/mapper/UserMapper.xml"></mapper>
//或者批量注册包里
<package name="com.mybatis"/>
</mappers>

- Spring整合

	- Bean：MapperScannerConfigurer
	- DI注入扫描包:<property name="basePackage" value="com.atguigu.dao"></property>

	  <!--自动的扫描所有的mapper的实现并加入到ioc容器中 -->
	  <bean id="configure" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	  <!– basePackage:指定包下所有的mapper接口实现自动扫描并加入到ioc容器中 -->
	  <property name="basePackage" value="com.atguigu.dao"></property>
	  </bean>

## 映射文件（mappers里注册的xml）

### 元素

- cache – 该命名空间的缓存配置。
- cache-ref – 引用其它命名空间的缓存配置。
- sql – 可被其它语句引用的可重用语句块。
- insert – 映射插入语句。
- update – 映射更新语句。
- delete – 映射删除语句。
- select – 映射查询语句。
- resultMap – 描述如何从数据库结果集中加载对象，是最复杂也是最强大的元素。

### 参数

- #{key}：预编译到SQL中。安全。是把#{}替换为?号，调用PreparedStatement的set方法来赋值；
- ${key}：拼接到SQL中。有SQL注入问题。是把${}替换成变量的值。

### 动态SQL

- if:判断
- choose (when, otherwise):分支选择；带了break的swtich-case如果带了id就用id查，如果带了lastName就用lastName查;只会进入其中一个
- trim:字符串截取(where(封装查询条件), set(封装修改条件))
- foreach 遍历集合

## Mybatis 执行过程

### 加载配置并初始化： Configuration对象

- 加载配置文件mybatis-config.xml到MyBatis内部
- 使用 org.apache.ibatis.session.Configuration对象作为一个所有配置信息的容器，Configuration对象的组织结构和XML配置文件的组织结构几乎完全一样，这样配置文件的信息就存到了Configuration这个类中了

### 接收调用请求 

- org.apache.ibatis.session.SqlSessionFactoryBuilder

	- InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
	- SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

- org.apache.ibatis.session.SqlSessionFactory

	- SqlSession sqlSession = sqlSessionFactory.openSession();

- org.apache.ibatis.session.SqlSession表示和数据库交互的会话，完成必要数据库增删改查功能

	- UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	- List<User> all = mapper.findAll();

### SQL解析与执行

- 根据SQL的ID查找对应的MappedStatement对象。 
- 根据传入参数对象解析MappedStatement对象，得到最终要执行的SQL和执行传入参数。 
- 获取数据库连接，根据得到的最终SQL语句和执行传入参数到数据库执行，并得到执行结果。 

### 结果映射

### 释放连接资源，返回处理结果

## 层次结构与架构

## Mybatis 事务管理

### 使用JDBC的事务管理机制

- 利用java.sql.Connection对象完成对事务的操作

  SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
  long start = System.currentTimeMillis();
  try{
     EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
     for (int i = 0; i < 10000; i++) {
        mapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0, 5), "b", "1"));
     }
     openSession.commit();
     long end = System.currentTimeMillis();
     //批量：（预编译sql一次==>设置参数===>10000次===>执行（1次））
     //Parameters: 616c1(String), b(String), 1(String)==>4598
     //非批量：（预编译sql=设置参数=执行）==》10000    10200
     System.out.println("执行时长："+(end-start));
  }finally{
     openSession.close();
  }

### 使用MANAGED的事务管理机制

- 这种机制MyBatis自身不会去实现事务管理，而是让程序的容器如（JBOSS，Weblogic）来实现对事务的管理

## Mybatis 缓存机制

## Spring 整合 Mybatis

## 逆向工程：MyBatis Generator

## Mybatis 优缺点

### 优点

- 1. 易于上手和掌握。
- 2. sql写在xml里，便于统一管理和优化。
- 3. 解除sql与程序代码的耦合。
- 4. 提供映射标签，支持对象与数据库的orm字段关系映射
- 5. 提供对象关系映射标签，支持对象关系组建维护
- 6. 提供xml标签，支持编写动态sql。

### 缺点

- 1. sql工作量很大，尤其是字段多、关联表多时，更是如此。
- 2. sql依赖于数据库，导致数据库移植性差。
- 3. 由于xml里标签id必须唯一，导致DAO中方法不支持方法重载。
- 4. 字段映射标签和对象关系映射标签仅仅是对映射关系的描述，具体实现仍然依赖于sql。（比如配置了一对多Collection标签，如果sql里没有join子表或查询子表的话，查询后返回的对象是不具备对象关系的，即Collection的对象为null）
- 5. DAO层过于简单，对象组装的工作量较大。
- 6.  不支持级联更新、级联删除。
- 7. 编写动态sql时,不方便调试，尤其逻辑复杂时。
- 8 提供的写动态sql的xml标签功能简单（连struts都比不上），编写动态sql仍然受限，且可读性低。
- 9. 若不查询主键字段，容易造成查询出的对象有“覆盖”现象。
- 10. 参数的数据类型支持不完善。（如参数为Date类型时，容易报没有get、set方法，需在参数上加@param）
- 11. 多参数时，使用不方便，功能不够强大。（目前支持的方法有map、对象、注解@param以及默认采用012索引位的方式）
- 12. 缓存使用不当，容易产生脏数据。

## URL

## URL

## 数据库事务

