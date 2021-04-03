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

## Spring AOP

### AOP解决的问题

- OOP是自上而下的编程方式，犹如树状图，通过调用或继承来复用。而日志记录、性能统计、安全校验、事务管理等辅助逻辑就像一把闸刀横向贯穿所有方法

	- 

- 代理模式用来增加或增强原有功能再适合不过了，但切面逻辑的难点不是不修改原有业务，而是对所有业务生效
- AOP是对OOP的一种补充。无论有一个业务方法，还是一万个业务方法，只需编写一次切面逻辑，就能让所有业务方法生效，提高开发效率。

### 核心

- Aspect Oriented Programming面向切面编程
- Target（目标对象）：代理的目标对象
- Joinpoint（连接点）：类里可以增强的方法
- Pointcut（切点）：实际增强的方法

	- 切点表达式

		- execution([修饰符] 返回值类型 包名.类名.方法名(参数))
		- 访问修饰符可以省略
		- 返回值类型、包名、类名、方法名可以使用星号* 代表任意
		- 包名与类名之间一个点 . 代表当前包下的类，两个点 .. 表示当前包及其子包下的类
		- 参数列表可以使用两个点 .. 表示任意个数，任意类型的参数列表

- Advice（通知/ 增强）：实际增强的逻辑部分

	- XML

		- 

	- 注解：

		- 

- Aspect（切面）：通知+切入点（增强的方法和增强的逻辑）
- Weaving（织入）：把通知(增强)应用到切入点的过程。spring采用动态代理织入，而AspectJ采用编译期织入和类装载期织入
- Proxy （代理）：一个类被 AOP 织入增强后，就产生一个结果代理类
- AspectJ（Eclipse） 

	- AspectJ 不是Spring 组成部分，独立AOP 框架

### 底层原理：动态代理

- JDK动态代理：被代理的对象必须实现了某个接口

	-  ①目标类接口
 public interface TargetInterface 
	-  ②目标类实现接口
 public class Target implements TargetInterface
	-  ③动态代理代码
 Target target = new Target(); //创建目标对象
 //创建代理对象
 TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),
 //因为匿名内部类只重写唯一一个抽象方法，所以也可用lambda表示：(proxy,method,args) ->{} 
 new InvocationHandler() {
             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                 System.out.println("前置增强代码...");
                 Object invoke = method.invoke(target, args);
                 System.out.println("后置增强代码...");
                 return invoke;} } );

		- 第一参数，类加载器
		- 第二参数，增强方法所在的类，这个类实现的接口，支持多个接口
		- 第三参数，实现这个接口 InvocationHandler，创建代理对象，写增强的部分

- cglib 动态代理

	- 子类代理，从内存中构建出一个子类来扩展目标对象的功能

### AOP 实现的两种方式（基于AspectJ）

- XML

	- ①导入 AOP 相关坐标
	- ②创建目标接口和目标类（内部有切点）
	- ③创建切面类（内部有增强方法）
	- ④将目标类和切面类的对象创建权交给 spring

	   

	- ⑤在applicationContext.xml中配置织入关系

- 注解

	- @Aspect：用于定义一个切面
	- @Pointcut：用于定义切入点表达式，进行相同的切入点抽取
	- @Order(数字类型值)：有多个增强类多同一个方法进行增强，设置增强类优先级,越小越高
	- ①创建目标接口和目标类（内部有切点）
	- ③将目标类和切面类的对象创建权交给 spring
	- ②创建切面类（内部有增强方法)
	- ④在切面类中使用注解配置织入关系
	- ⑤在配置文件中开启组件扫描和 AOP 的自动代理

