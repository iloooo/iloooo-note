# Spring 整合

## Spring整合 数据源DataSource

### 添加连接池、数据库驱动

- <!--连接池坐标-->
<dependency>
    <groupId>c3p0</groupId>
    <artifactId>c3p0</artifactId>
    <version>0.9.1.2</version>
</dependency>
<!--mysql驱动坐标-->
<dependency>    
    <groupId>mysql</groupId>   
    <artifactId>mysql-connector-java</artifactId>    
    <version>5.1.6</version>    
    <scope>runtime</scope>
</dependency>

### 加载jdbc.properties

- <beans ...
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="...
       http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd">
<context:property-placeholder location="classpath:jdbc.properties"/>

### Bean配置数据源对象

- <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
</bean>

## Spring整合 SpringMVC

## Spring 整合 Mybatis

### 添加MyBatis-Spring包

- <dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis-spring</artifactId>
  <version>x.x.x</version>
</dependency>

### Bean配置SqlSessionFactory

- <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
         <property name="dataSource" ref="dataSource"/>
         <!-- 当mybatis的xml文件和mapper接口不在相同包下时，需要用mapperLocations属性指定xml文件的路径。  
                      *是个通配符，代表所有的文件，**代表所有目录下 -->  
         <property name="mapperLocations" value="classpath:mapper/**/*.xml"/>
         <!-- 加载mybatis的全局配置文件 --> 
         <property name="configLocation" value="classpath:mybatis/mybatis-config.xml" />
</bean>
- 依赖注入<property name...

	- dataSource

		- 是数据源配置，常用有DBCP，C3P0，Druid等

	- mapperLocations

		- 是指接口xml的文件配置，如果不配映射接口类文件(.java)和映射XML文件(.xml)需要放在相同的包下。
		- 和mybatis-config.xml的mappers功能相似，两个不需要同时配。

	- configLocation

		- 不是必须的，如果没有全局配置文件可以去掉

### 注册和发现映射器

- 官方多种方法

- spring中显示的逐一注入，mapper很多的话就会麻烦
- 利用mybatis-spring提供的自动扫描机制<mybatis:scan/>

	- <beans ...
  xmlns:mybatis="http://mybatis.org/schema/mybatis-spring"
  xsi:schemaLocation="...
  http://mybatis.org/schema/mybatis-spring
  http://mybatis.org/schema/mybatis-spring.xsd">
 
  <mybatis:scan base-package="org.mybatis.spring.sample.mapper" />
</beans>

- Bean配置MapperScannerConfigurer

	- <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
  <property name="basePackage" value="org.mybatis.spring.sample.mapper" />
</bean>

- @MapperScan

	- @Configuration
@MapperScan("org.mybatis.spring.sample.mapper")
public class AppConfig {
  // ...
}

## Spring 整合Hibernate

## back-home

