# Spring

## Spring IOC

### IOC解决问题

- 没有Spring前什么样子：传统的 Servlet 开发结构

	- Controller
	- Service
	- Dao

- 问题1：只做到了逻辑复用，没有做到资源复用（也就是创建了一堆重复对象，浪费资源，IOC解决问题）

	- 没有资源复用：上层调用下一层时，必然会持有下一层的对象引用，即成员变量。每一个成员变量都会实例化一个对象

		- Subtopic

	- 逻辑复用：

		- Subtopic

	- 理想状态：本应多个 Controller 复用同一个 Service，多个 Service 复用同一个 DAO
	- 实际状态：一个 Controller创建多个重复的 Service，多个 Service 又创建了多个重复的 DAO，从倒三角变成了正三角

- 问题2：耦合度高，更改底层代码代价大
- 问题3：创建和配置组件工作繁杂，给组件调用方带来极大不便。
- 类似Tomcat是Servlet的容器，Spring IOC是对象创建配置的容器

### 核心

- 核心思想：把对象创建和配置，交给Spring容器管理
- 目的：降低耦合度
- IOC：控制反转是目的（降低耦合度）
- DI：依赖注入是IOC的一种实现手段

### 底层原理：  xml 解析、工厂模式（对象工厂）、反射

### 初始化IOC容器，获取容器中Bean：ApplicationContext接口的实现类

- ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
UserDao userDao = (UserDao) applicationContext.getBean("userDao");
- ClassPathXmlApplicationContext ：类的根路径下加载配置文件
- FileSystemXmlApplicationContext：磁盘路径上加载配置文件
- AnnotationConfigApplicationContext：使用注解配置容器对象

### IOC实现：Bean管理

- Bean ：Spring IOC容器创建管理的对象
- 一些理解：

	- 什么对象可以作为Bean：可以创建实例的。
	- 定义成Bean后可以干啥？可以被依赖注入给其他Bean，这样使用时就不用重复new出这个实例了，所有Bean组成了容器
	- 要想产生这个Bean来用，有多种方式：

		- XML声明Bean并依赖注入
		- 自己的代码：直接@Service@Component..声明为Bean方便
		- 没法改的代码：用@import(全配置中引入除自己包的bean)+@Bean("xxxx")的方式
		- 没法改的代码：在XML中声明为bean为了用依赖注入更改其属性，前提是要可以注入（成员变量属性，setter方法或者有参构造）

- 声明Bean的两种方式

	- XML方式（麻烦，除非创建jar包里的对象bean）
	- 注解方式

		- 开启组件扫描

			- 最好配置个xml来防止声明没法用注解声明为Bean的对象(比如jar包里)
			- XML:<context:component-scan base-package="com.atguigu"></context:component-scan>
			- 注解

				- @Configuration  //作为配置类，替代xml配置文件
				- @ComponentScan(basePackages = {"com.atguigu"})

		- 定义bean：（注释作用域都是TYPE）

			- @Component：类
			- @Controller：web层
			- @Service：service层
			- @Repository：dao层

		- 其他

			- 
			- @import：4.x新特性：多个配置文件引入到一个文件

				- 

- 依赖注入DI(Dependency Injection)：就是给Bean注入属性

	- @Value：注入普通属性
	- Bean自动装配：<bean autowire="xxx"> 

		- NO：默认设置没有自动装配
		- byType:

			- @Autowired

				- (不能TYPE)CONSTRUCTOR、METHOD、PARAMETER、FIELD

			- @Resource //根据类型进行注入

		- byName:

			- @Qualifier("userDaoImpl")：配合@Autowired用 
			- @Resource(name = "userDaoImpl") //根据名称进行注入

	- 依赖注入的两种方式：

		- setter方法：

			- 优点：灵活。可以选择性地注入需要的对象。
			- 缺点：因为调用setter时才获得对象实例，本方法用还行，如果全类用不可

		- 有参构造：

			- 优点：对象初始化完成后便可获得可使用的对象。
			- 缺点：如果需要注入很多对象，构造器形参列表会过长
			- 

		- 总结：

			- ①如果全类用此注入对象，声明对象为成员变量，有参构造方式赋值。
			- ②如果单纯一个方法用，setter方法形参注入

- Bean作用域：<bean scope="xxx"> || @Scope

	- singleton:默认值，单例的
	- prototype:多例的
	- request:WEB 项目中，Spring 创建一个 Bean 的对象，将对象存入到 request 域中
	- session:WEB 项目中，Spring 创建一个 Bean 的对象，将对象存入到 session 域中
	- global session:WEB 项目中，应用在 Portlet 环境，如果没有 Portlet 环境那么global Session 相当于 session

- Bean生命周期

	- （1）通过构造器创建 bean 实例（无参数构造）
	- （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
	- （3）调用 bean 的初始化的方法（需要进行配置初始化的方法）
	- （4）bean 可以使用了（对象获取到了）
	- （5）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）

### Spring5新特性

### 实际应用：

- 面向接口编程+依赖注入

	- 将接口作为依赖注入对象，这样替换实现类时不用更改使用类

## back-home

