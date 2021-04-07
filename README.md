# 学习知识总结记录

**将知识先读厚，再将知识变薄，最后灵活运用、科学复习以防遗忘。**

# 前言

这个库是archive将知识变薄、和平时知识使用总结的结果，以脑图和Markdown笔记为主。

平时用来科学复习的Anki条目没有办法组成结构联系，有时候复习一条知识点条目时，其实脑中像脑图一样在回忆整个大类的知识点。不过还是容易遗漏知识。

后来发现学厚知识后，把整个知识体系通过脑图整理后更加深了知识的认识，也清晰了知识体系的结构。而且尝尝整理过程中会发现当时学厚知识时，只知其然不知其所以然。虽然常常这个过程挤占很多本来用来学习新知识的时间，不过整理出来以后，对知识的整体认识让自己体会到胸有成竹，不再是之前复习Anki时那样觉得自己什么都忘了。确实是忘了，其实更重要的是当时学厚时根本没消化。整理脑图来将知识变薄，就是在消化知识，也是在查漏补缺。意义非凡。

# 版本的重要性

我认为很多知识的学习不是一蹴而就。就像一门成熟的技术，也是伴随着版本的不断迭代，解决错误也会推陈出新。随着认识的深入和平时的实践，我们会对知识有新的理解感悟，会发现之前错误的认识。知识的总结是一个迭代的过程，记录好每次迭代的认识也是一项重要的工作。世上难有完美，一次次的增删改是我追寻完美的路程。

# 知识大纲

***

## Java

### 注解
[annotation-note.xmind](java/annotation/annotation-note.xmind)

定义注解
	元注解:修饰定义注解
使用注解
	注意注解生命周期：@Retention
	注意注解能在何处使用：@Target
	注意注解的参数，使用时显式赋值或者使用default值
解析注解：反射（注解完成特殊操作的核心）
	必须是@Retention为RUNTIME的才可以代码运行时通过反射解析

### 集合

#### [collection-note.mmap](java/collection/collection-note.mmap)

```
List：有序、可重复
	ArrayList底层、线程、方法
		add(E e)：O(1)   大于原数组长度时扩容：1.5倍.扩容消耗性能，所以最好预设数组大小
		add(int index, E element)：O(n) 数组元素移动费时间
		remove(int index)：O(n)数组元素移动费时间
		get(int index)：O(1)
	LinkedList底层、线程、方法
		add(E e)：O(1)
		add(int index, E element)：O(n) 遍历链表费时间
		remove((int index))
		get(int index) 遍历链表费时间
	Vector除了线程安全，其他和ArrayList大致相同，只是多加了个 synchronized 来保证线程安全罢了。
	LinkedList方法在指定位置插入和删除元素的效率较高，但是查找的效率就不如数组那么高（ArrayList擅长于随机访问）
	List线程安全：工具类Collections的synchronizedList（List<T>list）方法

Set：无序、不可重复
	HashSet底层、线程、使用注意
	LinkedHashSet底层、线程、使用注意
	TreeSet底层

Map：key（无序的、不可重复的）、value（无序的、可重复的）
	HashMap底层、线程、使用注意、重要常量、方法
		get
		put
	LinkedHashMap底层
	LinkedHashMap较HashMap保证了遍历时，可以按照添加顺序实现遍历
	TreeMap底层、自然和定制排序
	Hashtable原理和功能同HashMap，但是不允许nul
	Properties的key、value都是字符串类型
```

#### HashMap各遍历方式分析

[hashmap-iterate.mmap](java/collection/hashmap-iterate.mmap)

```
迭代器（Iterator）
	 EntrySet 性能最好、循环删除数据安全
	 KeySet 
For Each
	EntrySet 
	KeySet 
Lambda 表达式（JDK 1.8+）
Streams API（JDK 1.8+）
	单线程
	多线程

性能分析、遍历时删除数据的安全性分析
```


***

## JavaWeb

### JaveEE

#### [javaweb.xmind](java/javaee/javaweb.xmind)

#### Servlet

```
ServletContext
request域对象：Attribute 范围和操作
请求转发forward（内部）特点和实现
重定向redirect特点和实现
```

#### Filter

```
概念、作用、使用（注解、XML）
    路径的选项
    拦截方式配置
Servlet Filter
```

#### Listener

```
事件监听机制概念、作用
ServletContextListener 注解和XML方式
```

#### 会话技术

- [ ] TODO	Cookie
- [ ] TODO	Session

```
概念、功能
```

- [ ] TODO	JSP

****


## Database

### 数据库事务

[database-transaction.xmind](database/database-transaction.xmind)

- [ ] TODO	oracle/redis事务

```
概念
事务的4个特性（ACID）
	1.原子性（Atomicity）
	2.一致性（Consistency
	3.隔离性（Isolation）
	4.持久性（Durability）
		多个事务期间操作相同数据可能导致的并发问题
		事务隔离级别：
			1、read uncommitted （读未提交数据）
			2、read committed （读已提交数据）可以避免脏读
			3、repeatable read（可重复读）可以避免脏读、不可重复读和一部分幻读
			4、serializable（串行化）可以避免脏读、不可重复读和幻读
事务管理操作（TCL）
Spring事务管理
JDBC事务管理	database-jdbc.xmind
Mybatis事务管理	
```

### JDBC

[database-jdbc.xmind](database/database-jdbc.xmind)

- [ ] TODO	Resultset详解（数据类型对应）

```
加载驱动
	mysql，Oracle驱动
	驱动URL
	加载方式
获取数据库连接
	数据库连接池（数据源DataSource）
SQL操作和结果集
JDBC事务处理
```

### TODO	ORM-Mybatis

[orm-mybatis](database/orm/database-orm.xmind)

```
简介
全局配置文件 mybatis-config.xml
映射文件 XXMapper.xml
Mybatis 执行过程
层次结构与架构
Mybatis事务管理（不常用）：常用Spring事务
Mybatis缓存机制
Spring 整合Mybatis
逆向工程：MyBatis Generator
Mybatis优缺点
```

### TODO	ORM-Hibernate

[orm-hibernate](database/orm/database-orm.xmind)

```

```



## Spring
### Spring IOC
[Spring IOC](java/spring/spring-note.xmind)

```
IOC解决问题
核心
底层原理：xml 解析、工厂模式（对象工厂）、反射
初始化IOC容器，获取容器中Bean：ApplicationContext接口的实现类
IOC实现：Bean管理
	声明Bean的两种方式
	依赖注入DI(Dependency Injection)：就是给Bean注入属性
		依赖注入的两种方式：setter、有参构造
	Bean作用域：<bean scope="xxx"> || @Scope
	Bean生命周期
TODO	Spring5新特性
实际应用
```
### Spring AOP
[Spring AOP](java/spring/spring-note.xmind)

```
AOP解决的问题
核心
	Target（目标对象）：代理的目标对象
    Joinpoint（连接点）：类里可以增强的方法
    Pointcut（切点）：实际增强的方法
    切点表达式
    Advice（通知/ 增强）：实际增强的逻辑部分
        XML
        注解
    Aspect（切面）：通知+切入点（增强的方法和增强的逻辑）
    Weaving（织入）：把通知(增强)应用到切入点的过程。spring采用动态代理织入，而AspectJ采用编译期织入和类装载期织入
    Proxy （代理）：一个类被 AOP 织入增强后，就产生一个结果代理类
    AspectJ（Eclipse）
底层原理：动态代理
	JDK动态代理：被代理的对象必须实现了某个接口
	cglib 动态代理
AOP 实现的两种方式（基于AspectJ）
	XML
	注解
```
### Spring 整合总结
[Spring 整合总结](java/spring/spring-note.xmind)

```
数据源DataSource
TODO	SpringMVC
Mybatis
TODO	Hibernate
```
### Spring 事务
[Spring 事务](java/spring/spring-note.xmind)

```
编程式事务管理
声明式事务管理
	底层是AOP
	实现方式
		XML
		注解：使用 @Transactional 相当于：<tx:method>
		注解：xml开启事务的注解驱动<tx:annotation-driven />
```
### Spring XML配置总结
[Spring XML配置总结](java/spring/spring-note.xmind)

```
Spring整合
```
### TODO Spring 相关注解总结

[Spring 相关注解总结](java/spring/spring-note.xmind)

```
Spring容器初始化总结
TODO	Spring
Spring MVC
TODO	Spring 事务
```

### Spring MVC

[spring-mvc-note.xmind](java/spring/spring-mvc-note.xmind)

```
解决的问题
web中使用springmvc和spring
组件解析
	前端控制器 DispatcherServlet(调度)
        调用HandlerMapping 处理器映射器
            根据用户请求找到具体的Handler 处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回
            返回：处理器执行链 HandlerExecutionChain
        调用HandlerAdapter 处理器适配器
            经过适配调用具体的 处理器Controller(也叫后端控制器)
            Controller返回：ModelAndView
        调用ViewReslover 视图解析器
            处理 DispatcherServlet传来的ModelAndView
            返回：具体View
        渲染视图（即将模型数据填充至视图中）
        DispatcherServlet响应用户
开发步骤
spring-mvc.xml 配置
Filter
Interceptor 拦截器
Exception 异常处理机制
TODO	文件上传
```

