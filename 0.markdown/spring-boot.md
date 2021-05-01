# Spring Boot

## 1、Spring Boot概述

### spring boot是一个搭建基于spring工程的脚手架

### 简化配置、依赖管理

### 特点：快速搭建、内嵌应用服务器、自动配置、无代码生成，也没有xml配置

## 2、快速入门

### 1、引入父依赖，指定spring boot版本2.1.5

### 2、添加启动器依赖

### 3、编写启动引导类

### 4、编写处理器

## 3、spring boot配置

### @ConfigurationProperties

- 将配置文件中的配置项读取到类中

### yaml配置文件

- 是一种树状层级的配置文件
- 功能与properties配置文件一致
- 在spring boot项目中配置文件可是：

	- application.properties
	- application.yaml
	- application.yml

- 可以在spring boot项目中使用多个yml配置文件，需要激活

## 4、自动配置原理

### 1、所有的自动配置类都在spring.factories文件中定义；根据启动器依赖实例化

### 2、配置流程

- 1、查找spring-boot-autoconfigure-***.jar
- 2、查找当前组件对应在上述jar包中的package
- 3、查看**Properties配置项类
- 4、到spring boot的application.yml配置文件中修改配置项

## 5、spring boot整合

### lombok

- 可以在实体类中简化各种方法的get/set/toString...

### 静态资源的放置

### jdbc和事务

- 默认连接池hikari
- @Transactional

### mybatis

- 添加mybatis官方的启动器
- 配置启动引导类中的mapper扫描
- 通用mapper

### junit

- 需要在测试类上添加@SpringBootTest

### redis

- 可以使用redisTemplate操作redis

## 6、项目打包部署

### 利用插件将项目打成一个jar包（跳过测试）；使用maven的package

### java -jar 包名

