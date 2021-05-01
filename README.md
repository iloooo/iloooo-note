# 学习知识总结记录

**将知识先读厚，再将知识变薄，最后灵活运用、科学复习以防遗忘。**

# 前言

这个库是archive将知识变薄、和平时知识使用总结的结果，以脑图和Markdown笔记为主。

平时用来科学复习的Anki条目没有办法组成结构联系，有时候复习一条知识点条目时，其实脑中像脑图一样在回忆整个大类的知识点。不过还是容易遗漏知识。

后来发现学厚知识后，把整个知识体系通过脑图整理后更加深了知识的认识，也清晰了知识体系的结构。而且尝尝整理过程中会发现当时学厚知识时，只知其然不知其所以然。虽然常常这个过程挤占很多本来用来学习新知识的时间，不过整理出来以后，对知识的整体认识让自己体会到胸有成竹，不再是之前复习Anki时那样觉得自己什么都忘了。确实是忘了，其实更重要的是当时学厚时根本没消化。整理脑图来将知识变薄，就是在消化知识，也是在查漏补缺。意义非凡。

# 版本的重要性

我认为很多知识的学习不是一蹴而就。就像一门成熟的技术，也是伴随着版本的不断迭代，解决错误也会推陈出新。随着认识的深入和平时的实践，我们会对知识有新的理解感悟，会发现之前错误的认识。知识的总结是一个迭代的过程，记录好每次迭代的认识也是一项重要的工作。世上难有完美，一次次的增删改是我追寻完美的路程。

# 知识大纲：

***

&#x1F4CA;  代表图片

&#x1F4C4;  代表xmind脑图

&#x1F4BE;  代表markdown笔记（脑图导出，用来备份、概览、比较差异等）

## Java

### 基础

&#x1F4C4;  [java-note.xmind](java/java-note.xmind)

&#x1F4CA;  [Java基础脑图](1.pic/java-note.png)

&#x1F4BE;  [java-note.md](0.markdown/java-note.md)

```
Java核心
	Java跨平台原理
	面向对象
标识符和命名规范
	标识符规则
	命名规范
运算符
	自增自减
	算法+赋值运算符
	==和 equals 的区别
	逻辑与或、短路与或：区别在于短路不符合条件后，后面表达式不执行
	运算符优先级
注释
流程控制
数据类型
	基本数据类型
	基本数据类型默认值
	包装类：装箱拆箱
	引用数据类型
	基本数据类型的转换
		自动类型转换
变量
常量
```

### 关键字

&#x1F4C4;  [java-note.xmind](java/java-note.xmind)

&#x1F4CA;  [Java关键字脑图](1.pic/java-关键字.png)

&#x1F4BE;  [java-关键字.md](0.markdown/java-关键字.md)

```
break、continue、return区别
final修饰类、方法、成员变量、局部变量
static 注意，修饰成员变量、方法、代码块、内部类
```

### 类和类的成员

&#x1F4C4;  [java-note.xmind](java/java-note.xmind)

&#x1F4CA;  [类和类的成员.脑图](1.pic/java-类和类的成员.png)

&#x1F4BE;  [java-类和类的成员.md](0.markdown/java-类和类的成员.md)

```
类成员的执行和初始化顺序
```

### 注解

&#x1F4C4;  [java-annotation-note.xmind](java/java-annotation-note.xmind)

&#x1F4CA;  [Java注解脑图](1.pic/java-annotation.png)

&#x1F4BE;  [java-annotation-note.md](0.markdown/java-annotation-note.md)

```
定义注解
	元注解:修饰定义注解
使用注解
	注意注解生命周期：@Retention
	注意注解能在何处使用：@Target
	注意注解的参数，使用时显式赋值或者使用default值
解析注解：反射（注解完成特殊操作的核心）
	必须是@Retention为RUNTIME的才可以代码运行时通过反射解析
```

### 集合

&#x1F4CA;  [集合继承实现关系图](1.pic/java-collection-diagram.png)

&#x1F4C4;  [collection-note.xmind](java/collection/collection-note.xmind)

&#x1F4CA;  [Java集合脑图](1.pic/java-collection.png)

&#x1F4BE;  [java-collection.md](0.markdown/java-collection.md)

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

&#x1F4C4;  [collection-hashmap-iterate.xmind](java/collection/collection-hashmap-iterate.xmind)

&#x1F4CA;  [HashMap各遍历方式分析脑图](1.pic/java-collection-hashmap-iterate.png)

&#x1F4BE;  [java-collection-hashmap-iterate.md](0.markdown/java-collection-hashmap-iterate.md)
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

### 设计模式

&#x1F4C4;  [java-pattern.xmind](java/pattern/java-pattern.xmind)

&#x1F4CA;  [Java设计模式脑图](1.pic/java-pattern.png)

&#x1F4BE;  [java-pattern.md](0.markdown/java-pattern)

```
代理模式
	理解
	应用
	静态代理
	动态代理
		JDK 动态代理机制
		CGLIB 动态代理机制
工厂模式
	应用
单例模式
模板方法
```

### Java8

&#x1F4C4;  [java8-note.xmind](java/java8/java8-note.xmind)

&#x1F4CA;  [JDK8 脑图](1.pic/java-jdk8.png)

&#x1F4BE;  [java-jdk8.md](0.markdown/java-jdk8.md)

```
新特性
升级引来的问题
	依赖组件的兼容性问题
	JVM配置问题
	sun.* 包缺失
```




***

## Web

### JaveEE

&#x1F4C4;  [javaee.xmind](web/javaee.xmind)

&#x1F4BE;  [web-javaee.md](0.markdown/web-javaee.md)

#### Servlet

&#x1F4CA;  [Servlet脑图](1.pic/web-servlet.png)

&#x1F4BE;  [web-servlet.md](0.markdown/web-servlet.md)

```
ServletContext
request域对象：Attribute 范围和操作
请求转发forward（内部）特点和实现
重定向redirect特点和实现
```

#### Filter

&#x1F4CA;  [Filter脑图](1.pic/web-servlet.png)

&#x1F4BE;  [web-filter.md](0.markdown/web-filter.md)

```
概念、作用、使用（注解、XML）
    路径的选项
    拦截方式配置
Servlet Filter
```

#### Listener

&#x1F4CA;  [Listener脑图](1.pic/web-listener.png)

&#x1F4BE;  [web-listener.md](0.markdown/web-listener.md)

```
事件监听机制概念、作用
ServletContextListener 注解和XML方式
```

#### 会话技术

- [ ] TODO	Cookie

- [ ] TODO	Session

&#x1F4BE;  [web-cookie-session.md](0.markdown/web-cookie-session.md)

```
概念、功能
```

- [ ] TODO	JSP

### JavaScript

&#x1F4C4;  [javascript-note.xmind](web/javascript-note.xmind)

&#x1F4CA;  [JavaScript脑图](1.pic/web-javascript-note.png)

&#x1F4BE;  [web-javascript-note.md](0.markdown/web-javascript-note.md)

```
基本语法
JavaScript事件
JavaScript内置对象
BOM对象
DOM对象
```

TODO 拆分


****
## Database

### 数据库事务

&#x1F4C4;  [database-transaction.xmind](database/database-transaction.xmind)

&#x1F4CA;  [数据库事务脑图](1.pic/database-transaction.png)

&#x1F4BE;  [database-transaction.md](0.markdown/database-transaction.md)

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

### 存储过程

&#x1F4C4;  [database-produce.xmind](database/database-produce.xmind)

&#x1F4CA;  [存储过程脑图](1.pic/database-produce.png)

&#x1F4BE;  [database-produce.md](0.markdown/database-produce.md)

```
Oracle存储过程
	简介
	*存储过程和存储函数的区别
		- 都可以封装一定的业务逻辑并返回结果（相同）
        - 存储函数中有返回值，且必须返回；而存储过程没有返回值，可以通过传出参数返回多个值。（返回值）
        - 存储函数可以在 select 语句中直接使用，而存储过程不能。过程多数是被应用程序所调用（调用）
        - 存储函数一般都是封装一个查询结果，而存储过程一般都封装一段事务代码（使用）
	存储过程的语法结构
	过程参数
	示例
	调用（PL/SQL、JDBC）
```

### Oracle数据库

&#x1F4C4;  [database-note.xmind](database/database-note.xmind)

&#x1F4CA;  [Oracle数据库脑图](1.pic/database-oracle.png)

&#x1F4BE;  [database-oracle.md](0.markdown/database-oracle.md)

```
视图
索引
序列
同义词
PL/SQL
存储函数
	简介
	语法结构
	示例
	调用
存储过程
触发器
```

### JDBC

&#x1F4C4;  [database-jdbc.xmind](database/database-jdbc.xmind)

&#x1F4CA;  [JDBC脑图](1.pic/database-jdbc.png)

&#x1F4BE;  [database-jdbc.md](0.markdown/database-jdbc.md)

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

### Mybatis

&#x1F4C4;  [database-orm](database/orm/database-orm.xmind)

&#x1F4CA;  [Mybatis脑图](1.pic/database-mybatis.png)

&#x1F4BE;  [database-orm-mybatis.md](0.markdown/database-orm-mybatis.md)

```
简介
Mybatis 开发步骤
	添加MyBatis的坐标
    编写数据库表的实体类 
    编写映射文件UserMapper.xml
    编写核心配置文件SqlMapConfig.xml
    手动调用，或者Spring管理
	//加载核心配置文件
Mybatis 执行过程
	加载配置并初始化： Configuration对象
	接收调用请求 
	SQL解析与执行
	结果映射
	释放连接资源，返回处理结果
全局配置文件 mybatis-config.xml
映射文件 XXMapper.xml
	cache – 该命名空间的缓存配置。
    cache-ref – 引用其它命名空间的缓存配置。
    sql – 可被其它语句引用的可重用语句块。
    insert – 映射插入语句。
    update – 映射更新语句。
    delete – 映射删除语句。
    select – 映射查询语句。
    resultMap – 描述如何从数据库结果集中加载对象，是最复杂也是最强大的元素。
    主键的自动生成（insert）
	缓存cache
	#{}和${}的区别
	动态SQL
层次结构与架构
	图
Mybatis事务管理（不常用）：常用Spring事务
Mybatis缓存机制
	一级缓存
	二级缓存
Spring 整合Mybatis
逆向工程：MyBatis Generator
Mybatis优缺点
	优点
		1. 易于上手和掌握。
        2. sql写在xml里，便于统一管理和优化。
        3. 解除sql与程序代码的耦合。
        4. 提供映射标签，支持对象与数据库的orm字段关系映射
        5. 提供对象关系映射标签，支持对象关系组建维护
        6. 提供xml标签，支持编写动态sql。
	缺点
		1. sql工作量很大，尤其是字段多、关联表多时，更是如此。
        2. sql依赖于数据库，导致数据库移植性差。
        3. 由于xml里标签id必须唯一，导致DAO中方法不支持方法重载。
        4. 字段映射标签和对象关系映射标签仅仅是对映射关系的描述，具体实现仍然依赖于sql。（比如配置了一对多Collection标签，如果sql里没有join子表或查询子表的话，查询后返回的对象是不具备对象关系的，即Collection的对象为null）
        5. DAO层过于简单，对象组装的工作量较大。
        6.  不支持级联更新、级联删除。
        7. 编写动态sql时,不方便调试，尤其逻辑复杂时。
        8 提供的写动态sql的xml标签功能简单（连struts都比不上），编写动态sql仍然受限，且可读性低。
        9. 若不查询主键字段，容易造成查询出的对象有“覆盖”现象。
        10. 参数的数据类型支持不完善。（如参数为Date类型时，容易报没有get、set方法，需在参数上加@param）
        11. 多参数时，使用不方便，功能不够强大。（目前支持的方法有map、对象、注解@param以及默认采用012索引位的方式）
        12. 缓存使用不当，容易产生脏数据。
```

&#x1F4CA;  [Mybatis结果映射脑图](1.pic/database-mybatis-resultmap.png)

&#x1F4BE;  [database-orm-mybatis-resultmap.md](0.markdown/database-orm-mybatis-resultmap.md)

```
select子元素：resultType
	列名匹配：幕后创建ResultMap
	列名不匹配
		可以在列名上使用 select 字句的别名来匹配标签
高级结果映射：元素 resultMap
	使用
	resultMap子元素
```

### Hibernate

&#x1F4C4;  [orm-hibernate](database/orm/database-orm.xmind)

&#x1F4CA;  [Hibernate脑图](1.pic/database-hibernate.png)

&#x1F4BE;  [database-orm-hibernate.md](0.markdown/database-orm-hibernate.md)

```
Hibernate 开发步骤
Hibernate 执行过程
核心配置文件hibernate.cfg.xml
Hibernate 缓存
Hibernate 事务
Hibernate 检索策略、方式
Hibernate 调用存储过程
```

#### 映射配置文件*.hbm.xml
&#x1F4C4;  [orm-hibernate](database/orm/database-orm.xmind)

&#x1F4CA;  [Hibernate映射配置文件*.hbm.xml脑图](1.pic/database-hibernate-hbmxml.png)

&#x1F4BE;  [database-orm-hibernate-hbm.xml.md](0.markdown/database-orm-hibernate-hbm.xml.md)

```
hibernate-mapping
class
id
property
component
映射关联关系
```

#### Java 类型, Hibernate 映射类型及 SQL 类型之间的对应关系
&#x1F4C4;  [Java 类型, Hibernate 映射类型及 SQL 类型之间的对应关系 ](0.markdown/database-orm-hibernate-类型之间对应关系.md)

&#x1F4CA;  [Hibernate-映射关系对应脑图](1.pic/database-hibernate-映射关系对应.png)

&#x1F4BE;  [database-orm-hibernate-类型之间对应关系.md](0.markdown/database-orm-hibernate-类型之间对应关系.md)

```
Java时间和日期类型的 Hibernate 映射
Java大对象类型的 Hiberante 映射
Java 类型, Hibernate 映射类型及 SQL 类型之间的对应关系 
```

## Spring
### Spring IOC

&#x1F4C4;  [Spring IOC](spring/spring-note.xmind)

&#x1F4CA;  [Spring IOC 脑图](1.pic/spring-ioc.png)

&#x1F4BE;  [spring-ioc.md](0.markdown/spring-ioc.md)

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

&#x1F4C4;  [Spring AOP](spring/spring-note.xmind)

&#x1F4CA;  [spring AOP 脑图](1.pic/spring-aop.png)

&#x1F4BE;  [spring-aop.md](0.markdown/spring-aop.md)

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
TODO 拆分



### Spring 整合总结

&#x1F4C4;  [Spring 整合总结](spring/spring-note.xmind)

&#x1F4CA;  [Spring 整合脑图](1.pic/spring-integration.png)

&#x1F4BE;  [spring-integration.md](0.markdown/spring-integration.md)

```
数据源DataSource
TODO	SpringMVC
Mybatis
TODO	Hibernate
TODO	Junit
```


### Spring 容器初始化总结

&#x1F4C4;  [Spring 容器初始化总结](spring/spring-note.xmind)

&#x1F4CA;  [Spring 容器初始化总结脑图](1.pic/spring-init.png)

&#x1F4BE;  [spring-init.md](0.markdown/spring-init.md)

```
创建IOC容器（ApplicationContext）
	web
	手动
定义XML配置位置
注解驱动
```



### Spring XML配置总结

&#x1F4C4;  [Spring XML配置总结](spring/spring-note.xmind)

&#x1F4CA;  [TODO](1.pic/TODO.png)

&#x1F4BE;  [spring-xml.md](0.markdown/spring-xml.md)

```
Spring整合
```



### Spring 事务

&#x1F4C4;  [Spring 事务](spring/spring-note.xmind)

&#x1F4CA;  [Spring 事务脑图](1.pic/spring-transaction.png)

&#x1F4BE;  [spring-transaction](0.markdown/spring-transaction.md)

```
编程式事务管理
声明式事务管理
	底层是AOP
	实现方式
		XML
		注解：使用 @Transactional 相当于：<tx:method>
		注解：xml开启事务的注解驱动<tx:annotation-driven />
```


### Spring MVC

&#x1F4C4;  [spring-mvc-note.xmind](spring/spring-mvc-note.xmind)

&#x1F4CA;  [Spring MVC脑图](1.pic/spring-mvc.png)

&#x1F4BE;  [spring-mvc-note.md](0.markdown/spring-mvc-note.md)

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

### Spring/Spring Boot 注解总结

&#x1F4C4;  [spring-springboot-annotation.xmind](spring/spring-springboot-annotation.xmind)

&#x1F4CA;  [Spring-注解总结脑图](1.pic/spring-springboot-注解总结.png)

&#x1F4BE;  [spring-springboot-annotation.md](0.markdown/spring-springboot-annotation.md)

```
spring-springboot-annotation
Spring容器初始化总结
TODO	Spring
Spring MVC
TODO	Spring 事务
```



### Spring Boot

&#x1F4C4;  [spring-boot.xmind](spring/spring-boot.xmind)

&#x1F4CA;  [Spring Boot 脑图](1.pic/spring-boot.png)

&#x1F4BE;  [spring-boot.md](0.markdown/spring-boot.md)

```

```



### Spring Boot 整合



## architecture 架构

### monolithic-单体架构

&#x1F4C4;  [monolithic-单体架构.xmind](architecture/monolithic-单体架构.xmind)

&#x1F4CA;  [大型单体架构-Monolithic脑图](1.pic/arch-monolithic-大型单体架构.png)

&#x1F4BE;  [arch-monolithic-大型单体架构.md](0.markdown/arch-monolithic-大型单体架构.md)

```
分析
	大家都会进行分层
	将软件拆分为各种模块，以便重用和管理代码
	负载均衡器之后同时部署若干个相同的单体系统副本，以达到分摊流量压力的效果
	规模小是优势，规模大是劣势
		类比大公司和小公司拆分
缺陷
	拆分之后的隔离与自治能力上的欠缺
	所有代码都运行在同一个进程空间之内，任何一部分代码出现了缺陷，过度消耗了进程空间内的资源，所造成的影响也是全局性的、难以隔离的。
		譬如内存泄漏、线程爆炸、阻塞、死循环等问题，都将会影响整个程序，而不仅仅是影响某一个功能、模块本身的正常运作。
		如果消耗的是某些更高层次的公共资源，譬如端口号或者数据库连接池泄漏，影响还将会波及整台机器，甚至是集群中其他单体副本的正常工作。
	不利于维护
		程序升级、修改缺陷往往需要制定专门的停机更新计划，做灰度发布、A/B测试也相对更复杂。
```

## TODO distributed-分布式系统

&#x1F4C4;  [distributed-system-分布式系统.xmind](architecture/distributed-system-分布式系统.xmind)

&#x1F4CA;  [TODO脑图](1.pic/TODO.png)

&#x1F4BE;  [arch-distributed-分布式系统.md](0.markdown/arch-distributed-分布式系统.md)

```

```

## soa-webservice-面向服务

&#x1F4C4;  [soa-webservice-面向服务.xmind](architecture/soa-webservice-面向服务.xmind)

&#x1F4CA;  [SOA面向服务脑图](1.pic/arch-soa面向服务架构.png)

&#x1F4BE;  [arch-soa面向服务架构.md](0.markdown/arch-soa面向服务架构.md)

```
起因和解决问题
	解决单体架构的问题
		允许程序出错
		获得隔离、自治的能力
		为了可以技术异构等目标
	开发分布式程序也并不意味着一定要依靠微服务架构才能实现，人们曾经探索过几种服务拆分方法，将一个大的单体系统拆分为若干个更小的、不运行在同一个进程的独立服务
优缺
	可以实现多个异构大型系统之间的复杂集成交互，却很难作为一种具有广泛普适性的软件架构风格来推广
Web Service
RPC 远程服务调用
SOAP
基于REST风格构建的API-RESTful API
```

#### Web Service

&#x1F4C4;  [soa-webservice-面向服务.xmind](architecture/soa-webservice-面向服务.xmind)

&#x1F4CA;  [Web Service脑图](1.pic/arch-soa-webservice.png)

&#x1F4BE;  [arch-soa-webservice.md](0.markdown/arch-soa-webservice.md)

```
介绍
开发规范
	JAX-WS（JAX-RPC）
	JAXM&SAAJ
	JAX RS
三要素
	SOAP (简易对象访问协议)
	WSDL (Web services 描述语言)
	UDDI (通用描述、发现及整合)
Apache CXF 开发步骤
	SOAP服务端
	SOAP客户端
	RESTful客户端
	RESTful服务端
RESTful注解
```

#### SOAP和RESTful的实现对比总结

&#x1F4C4;  [soa-webservice-面向服务.xmind](architecture/soa-webservice-面向服务.xmind)

&#x1F4CA;  [SOAP和RESTful的实现对比总结脑图](1.pic/arch-soa-SOAP和RESTful的实现对比总结.png)

&#x1F4BE;  [arch-soa-SOAP和RESTful的实现对比总结.md](0.markdown/arch-soa-SOAP和RESTful的实现对比总结.md)

```
SOAP更像是本地调用接口和接口实现类的感觉
RESTful更像是数据库，要定义实体类接收结果

SOAP的服务接口前后端要一致，客户端类似注入服务这个接口，调用远端的实现类
RESTful不用定义服务接口，不同URI对应访问服务接口实现的不同方法
RESTful因为不用写服务接口，它必须要有结果实体类来接收服务
```

#### TODO RPC 远程服务调用

&#x1F4C4;  [soa-webservice-面向服务.xmind](architecture/soa-webservice-面向服务.xmind)

&#x1F4BE;  [arch-soa-rpc.md](0.markdown/arch-soa-rpc.md)

```

```

#### RESTful

&#x1F4C4;  [soa-webservice-面向服务.xmind](architecture/soa-webservice-面向服务.xmind)

&#x1F4CA;  [RESTful脑图](1.pic/arch-soa-restful.png)

&#x1F4BE;  [arch-soa-restful.md](0.markdown/arch-soa-restful.md)

```
基于REST风格构建的API
每种资源对应一个特定的URI
操作（请求行）：DELETE http://api.qc.com/v1/friends  HTTP/1.1
有点像数据库操作，增删改查
```

## microservices-微服务

&#x1F4C4;  [microservices-微服务.xmind](architecture/microservices-微服务.xmind)

&#x1F4CA;  [微服务脑图](1.pic/arch-microservices微服务.png)

&#x1F4BE;  [arch-microservices微服务.md](0.markdown/arch-microservices微服务.md)

```

```

## Other 其他

### 字符编码

&#x1F4C4;  [字符编码.xmind](other/字符编码.xmind)

&#x1F4CA;  [字符编码脑图](1.pic/other-字符编码.png)

&#x1F4BE;  [other-字符编码.md](0.markdown/other-字符编码.md)

```
ASCII 字符集
Unicode 字符集
```

