# Mybatis

## 简介

### MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架

### MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集

### MyBatis 可以对配置和原生Map使用简单的 XML 或注解，将接口和 Java 的 POJOs映射成数据库中的记录

## Mybatis 开发步骤

### 添加MyBatis的坐标

### 编写数据库表的实体类 

### 编写映射文件UserMapper.xml

### 编写核心配置文件SqlMapConfig.xml

### 手动调用，或者Spring管理

- //加载核心配置文件
InputStream resourceAsStream = 
	Resources.getResourceAsStream("SqlMapConfig.xml");
//获得sqlSession工厂对象
SqlSessionFactory sqlSessionFactory = new            
    SqlSessionFactoryBuilder().build(resourceAsStream);
//获得sqlSession对象
SqlSession sqlSession = sqlSessionFactory.openSession();
//执行sql语句
List<User> userList = sqlSession.selectList("userMapper.findAll");
//结果分析
System.out.println(userList);
//释放资源
sqlSession.close();
- Spring创建SQLSessionFactoryBean，注入全局配置文件和注册mapper的xml

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

## mapper的xml映射文件

### 顶级元素

- cache – 该命名空间的缓存配置。
- cache-ref – 引用其它命名空间的缓存配置。
- sql – 可被其它语句引用的可重用语句块。

  <!--sql语句抽取-->
  <sql id="selectUser">select * from user</sql>
  
  <select id="findByCondition" parameterType="user" resultType="user">
      <include refid="selectUser"></include>
      <where>
          <if test="id!=0">
              and id=#{id}
          </if>
          <if test="username!=null">
              and username=#{username}
          </if>
          <if test="password!=null">
              and password=#{password}
          </if>
      </where>
  </select>

- insert – 映射插入语句。

  <insert id="insertAuthor">
   insert into Author (id,username,password,email,bio)
   values (#{id},#{username},#{password},#{email},#{bio})
  </insert>

- update – 映射更新语句。

  <update id="updateAuthor">
   update Author set
    username = #{username},
    password = #{password},
    email = #{email},
    bio = #{bio}
   where id = #{id}
  </update>

- delete – 映射删除语句。

  <delete id="deleteAuthor">
   delete from Author where id = #{id}
  </delete>

- select – 映射查询语句。

  <select
   id="selectPerson"
   parameterType="int"
   parameterMap="deprecated"
   resultType="hashmap"
   resultMap="personResultMap"
   flushCache="false"
   useCache="true"
   timeout="10000"
   fetchSize="256"
   statementType="PREPARED"
   resultSetType="FORWARD_ONLY">

- resultMap – 描述如何从数据库结果集中加载对象，是最复杂也是最强大的元素。

### 属性

- select、insert、update、delete公共属性

	-   id必选

		- 在命名空间中唯一的标识符，可以被用来引用这条语句

	-   parameterType

	  <insert id="insertUser" parameterType="User">
	  	 insert into users (id, username, password)
	  		 values (#{id}, #{username}, #{password})
	  </insert>
	  如果 User 类型的参数对象传递到了语句中，id、username 和 password 属性将会被查找，然后将它们的值传入预处理语句的参数中

		- 将会传入这条语句的参数类的完全限定类名或别名
		- 可选，可以通过 TypeHandler 推断出具体传入语句的参数，默认值为 unset。

	- flushCache	

		- 将其设置为 true，任何时候只要语句被调用，都会导致本地缓存和二级缓存都会被清空
		- 默认值：true（对应插入、更新和删除语句）
		- 默认值：false （select）

	- timeout

		- 这个设置是在抛出异常之前，驱动程序等待数据库返回请求结果的秒数。
		- 默认值为 unset（依赖驱动）。

	- statementType

		- STATEMENT，PREPARED 或 CALLABLE 的一个。这会让 MyBatis 分别使用 Statement，PreparedStatement 或 CallableStatement，
		- 默认值：PREPARED。

- insert、update公共属性

	- useGeneratedKeys

		- 这会令 MyBatis 使用 JDBC 的 getGeneratedKeys 方法来取出由数据库内部生成的主键（比如：像 MySQL 和 SQL Server 这样的关系数据库管理系统的自动递增字段）
		- 默认值：false。

	- keyProperty

		- 唯一标记一个属性，MyBatis 会通过 getGeneratedKeys 的返回值或者通过 insert 语句的 selectKey 子元素设置它的键值
		- 默认：unset。如果希望得到多个生成的列，也可以是逗号分隔的属性名称列表。

	- keyColumn

		- 通过生成的键值设置表中的列名，这个设置仅在某些数据库（像 PostgreSQL）是必须的，当主键列不是表中的第一列的时候需要设置。如果希望得到多个生成的列，也可以是逗号分隔的属性名称列表。

- select属性

	-   useCache

		- 将其设置为 true，将会导致本条语句的结果被二级缓存
		- 默认值：对 select 元素为 true

	-   fetchSize

		- 这是尝试影响驱动程序每次批量返回的结果行数和这个设置值相等
		- 默认值为 unset（依赖驱动）

	-   resultSetType

		- 这个设置仅对多结果集的情况适用，它将列出语句执行后返回的结果集并每个结果集给一个名称，名称是逗号分隔的。

	-   resultType

		- 从这条语句中返回的期望类型的类的完全限定名或别名
		- 注意

			- 如果是集合情形，那应该是集合可以包含的类型，而不能是集合本身
			- 使用 resultType 或 resultMap，但不能同时使用

	-   resultMap

		- 外部 resultMap 的命名引用
		- 注意：使用 resultMap 或 resultType，但不能同时使用

### 主键的自动生成（insert）

- 数据库支持自动生成主键

	- 方法

		- 可以设置 useGeneratedKeys=”true”，然后再把 keyProperty 设置到目标属性上就OK了

	- 实例

		- <insert id="insertAuthor" useGeneratedKeys="true"
    keyProperty="id">
  insert into Author (username, password, email, bio) values
  <foreach item="item" collection="list" separator=",">
    (#{item.username}, #{item.password}, #{item.email}, #{item.bio})
  </foreach>
</insert>

- 数据库不支持自动生成主键

	- 方法

		- 在insert中使用selectKey语句
		- <selectKey  keyProperty="id"  resultType="int"  order="BEFORE"  statementType="PREPARED">

### 结果映射resultMap

### 缓存cache

- 要开启二级缓存,你需要在你的 SQL 映射文件中添加一行<cache/>
- <cache/>效果如下

	- 映射语句文件中的所有 select 语句将会被缓存。
	- 映射语句文件中的所有 insert,update 和 delete 语句会刷新缓存。
	- 缓存会使用 Least Recently Used(LRU,最近最少使用的)算法来收回。
	- 根据时间表(比如 no Flush Interval,没有刷新间隔), 缓存不会以任何时间顺序 来刷新。
	- 缓存会存储列表集合或对象(无论查询方法返回什么)的 1024 个引用。
	- 缓存会被视为是 read/write(可读/可写)的缓存,意味着对象检索不是共享的,而 且可以安全地被调用者修改,而不干扰其他调用者或线程所做的潜在修改。

- 属性

	- <cache
  eviction="FIFO"
  flushInterval="60000"
  size="512"
  readOnly="true"/>
	- 以上配置创建了一个 FIFO 缓存,并每隔 60 秒刷新,存数结果对象或列表的 512 个引用,而且返回的对象被认为是只读的

- 收回策略

	- LRU – 最近最少使用的:移除最长时间不被使用的对象。
	- FIFO – 先进先出:按对象进入缓存的顺序来移除它们。
	- SOFT – 软引用:移除基于垃圾回收器状态和软引用规则的对象。
	- WEAK – 弱引用:更积极地移除基于垃圾收集器状态和弱引用规则的对象
	- 默认的是 LRU

### 参数

- #{}和${}的区别

	- #{key}  获取参数的值，预编译到SQL中.安全

	  PreparedStatement ps = conn.prepareStatement(sql);
	  ps.setInt(1,id);
	  解析后执行的SQL：Select * from emp where name = ？

	- ${key}  获取参数的值，拼接到SQL中.有SQL注入问题
字符串替换使用：ORDER BY ${columnName}

	  Statement st = conn.createStatement();
	  ResultSet rs = st.executeQuery(sql);
	  解析后执行的SQL：Select * from emp where name =Smith

- 特殊类型参数

  #{property,javaType=int,jdbcType=NUMERIC}

	- 可能为空的列名指定 jdbcType
	- javaType、jdbcType、mode、numericScale、resultMap、typeHandler、jdbcTypeName

### 动态SQL

- if:判断
- choose (when, otherwise):分支选择；带了break的swtich-case如果带了id就用id查，如果带了lastName就用lastName查;只会进入其中一个
- trim:字符串截取(where(封装查询条件), set(封装修改条件))
- foreach 遍历集合

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

### 为了提高数据利用率和减小服务器和数据库的压力，MyBatis 会对于一些查询提供会话级别的数据缓存，会将对某一次查询，放置到SqlSession 中，在允许的时间间隔内，对于完全相同的查询，MyBatis 会直接将缓存结果返回给用户，而不用再到数据库中查找。

### 一级缓存

- SqlSession级别的缓存，也称为本地缓存
- 默认只有一级缓存开启
- 同一次会话期间只要查询过的数据都会保存在当前SqlSession的一个Map中
- 失效的四种情况

	- 1、不同的SqlSession对应不同的一级缓存
	- 2、同一个SqlSession但是查询条件不同
	- 3、同一个SqlSession两次查询期间执行了任何一次增删改操作
	- 4、同一个SqlSession两次查询期间手动清空了缓存

### 二级缓存

- 全局作用域缓存
- 手动开启和配置
- 通过实现Cache接口来自定义二级缓存,要求POJO实现Serializable接口
- 二级缓存在 SqlSession 关闭或提交之后才会生效

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

