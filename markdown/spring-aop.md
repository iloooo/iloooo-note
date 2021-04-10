# Spring

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

## back-home

