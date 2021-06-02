# spring-springboot-annotation

## Java

### @PostConstruct

- METHOD
- 方法会在服务器加载Servlet的时候运行

	- 只会被服务器执行一次

- 整个Bean初始化中的执行顺序

	- Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)

## Spring

### 开启组件扫描

- @Configuration  //作为配置类，替代xml配置文件
- @ComponentScan(basePackages = {"com.atguigu"})

### 定义bean：（注释作用域都是TYPE）

- @Component：类
- @Controller：web层
- @Service：service层
- @Repository：dao层

### @import：4.x新特性：多个配置文件引入到一个文件

- 

### 依赖注入DI(Dependency Injection)：就是给Bean注入属性

- @Value：注入普通属性

	- FIELD、METHOD、PARAMETER

		- value()

	- 也可以读取spring boot的yml文件：

		- @Value("${token.header}")

- Bean自动装配：<bean autowire="xxx"> 

	- NO：默认设置没有自动装配
	- byType:

		- @Autowired

			- <bean autowire="byType"> 

				- (不能TYPE)CONSTRUCTOR、METHOD、PARAMETER、FIELD

					- required() default true

		- @Resource //根据名称进行注入

	- byName:

		- @Qualifier("userDaoImpl")：配合@Autowired用 

			- <bean autowire="byName">

				- TYPE、METHOD、PARAMETER、FIELD

					- value()

		- @Resource(name = "userDaoImpl") //根据名称进行注入

			- 相当于@Autowired+@Qualifier

				- TYPE,  FIELD,  METHOD

					- name()

### 没法改的代码：用@import(全配置中引入除自己包的bean)

- +@Bean("xxxx")的方式

	- 标注将该方法的返回值存储到 Spring 容器中，相当于单独一个bean
	- 可以通过DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
	- METHOD

		- value()...

### 其他设置

- @Scope

	- <bean scope="prototype"

		- singleton:默认值，单例的
		- prototype:多例的
		- request:WEB 项目中，Spring 创建一个 Bean 的对象，将对象存入到 request 域中
		- session:WEB 项目中，Spring 创建一个 Bean 的对象，将对象存入到 session 域中
		- global session:WEB 项目中，应用在 Portlet 环境，如果没有 Portlet 环境那么global Session 相当于 session

	- TYPE、METHOD

		- value()...

- @PostConstruct

	- 使用在方法上标注该方法是Bean的初始化方法
	- METHOD

		- null

- @PreDestroy

	- 使用在方法上标注该方法是Bean的销毁方法
	- METHOD

		- null

## Spring MVC

### @RequestMapping

- 用于建立请求 URL 和处理请求方法之间的对应关系支持Ant风格资源地址

  Ant 风格资源地址支持 3 种匹配符：
   ?：匹配文件名中的一个字符
  *：匹配文件名中的任意字符
  **：** 匹配多层路径
   
  @RequestMapping 支持 Ant 风格的 URL：
   – /user/*/createUser: 匹配
  /user/aaa/createUser、/user/bbb/createUser 等 URL
  – /user/**/createUser: 匹配
  /user/createUser、/user/aaa/bbb/createUser 等 URL
  – /user/createUser??: 匹配
  /user/createUseraa、/user/createUserbb 等 URL
  
  

- 注解作用域

	- TYPE：类上，请求URL 的第一级访问目录。此处不写的话，就相当于应用的根目录
	- METHOD：方法上，请求 URL 的第二级访问目录，与类上的使用@ReqquestMapping标注的一级目录一起组成访问虚拟路径

- 注解属性

	- value：用于指定请求的URL。
	- method：用于指定请求的方式 method=RequestMethod.GET
	- params：用于指定限制请求参数的条件。它支持简单的表达式。要求请求参数的key和value必须和配置的一模一样
	- params = {"accountName"}，表示请求参数必须有accountName

### @ModelAttribute

- 在调用目标处理方法前，会先逐个调用在方法级上标注了@ModelAttribute 的方法
- 注解作用域

	- METHOD
	- PARAMETER

### 传出数据

- @ResponseBody

	- 方法返回的字符串不是跳转,直接在http响应体中返回
	- 注解作用域

		- TYPE
		- METHOD

	- 注解属性：null

- @SessionAttributes

	- 存到 HttpSession 中
	- 注解作用域：TYPE

### 接收数据

- @RequestBody

	- 当使用ajax提交时，可以指定contentType为json形式，那么在方法参数位置使用@RequestBody可以直接接收集合数据而无需使用POJO进行包装
	- 注解属性:boolean required() default true;

- @RequestParam

	- 显示的绑定请求的参数名称与Controller的业务方法参数名称

	  public void save16(@RequestParam(value="name",required=false,defaultValue="itcast")String username)

	- 注解属性

		- value()
		- boolean required() default true;默认true，不存在的话异常
		- String defaultValue() default "xxx"

- @PathVariable

	- Restful 风格请求，结合@RequestMapping使用

	  @RequestMapping(value="/quick17/{name}")
	  @ResponseBody
	  public void save17(@PathVariable(value="name") String username) throws IOException {
	       System.out.println(username);
	  }

- @RequestHeader

	- 获得请求头信息
	- 注解属性

		- value：请求头的名称
		- required：是否必须携带此请求头

- @CookieValue

	- 获得指定Cookie的值
	- 注解属性

		- value：指定cookie的名称
		- required：是否必须携带此cookie

	- 注解作用域

		- TYPE
		- PARAMETER

## Spring Boot

### @SpringBootApplication：下面3个注解的集合

- 一般不会主动去使用它
- @EnableAutoConfiguration

	- 启用 SpringBoot 的自动配置机制

- @ComponentScan

	- 扫描被@Component (@Service,@Controller)注解的 bean，注解默认会扫描该类所在的包下所有的类。

- @Configuration

	- 允许在 Spring 上下文中注册额外的 bean 或导入其他配置类

- TYPE

### @RestController

- Spring4新增
- @Controller
- @ResponseBody
- 控制器 bean,并且是将函数的返回值直接填入 HTTP 响应体中,是 REST 风格的控制器。

	- 前后端分离

- @RestController vs @Controller

	- 单独使用 @Controller 不加 @ResponseBody的话一般使用在要返回一个视图的情况，这种情况属于比较传统的Spring MVC 的应用，对应于前后端不分离的情况。

- TYPE

	- value()

### @GetMapping("hello")

- 等价于@RequestMapping(value="/hello",method=RequestMethod.GET)

### @ConfigurationProperties

- TYPE
- METHOD

	- 常用于配置读写分离的场景

	  @ConfigurationProperties(prefix = "spring.datasource.druid.read")
	      @Bean(name = "readDruidDataSource")
	      public DataSource readDruidDataSource() {
	          return new DruidDataSource();
	      }
	  
	  
	      /**
	       * DataSource 配置
	       * @return
	       */
	      @ConfigurationProperties(prefix = "spring.datasource.druid.write")
	      @Bean(name = "writeDruidDataSource")
	      @Primary
	      public DataSource writeDruidDataSource() {
	          return new DruidDataSource();
	      }
	  

		- 读取yml文件

- prefix属性

	- 指定前缀，用来拼接字段

- 配置文件中是driver-class-name, 转驼峰命名便可以绑定成

	- driverClassName

- @value 有着相同的功能,但是 @ConfigurationProperties的写法更为方便

## Spring 事务

### @Transactional 

## Spring Security

### 注意：Java Config类的配置的权限，和注解配置的权限，两者是叠加的

### @EnableWebSecurity

- 开启对 Spring Security 注解的方法，进行权限验证，用在配置类
- TYPE
- 指明了用户名密码的处理方式、请求路径、登录/登出控制等和安全相关的配置

### @PermitAll

### @PreAuthorize

### @AuthenticationPrincipal

- 作用：MVC的Controller传参里，直接获得自定义的UserDetails，自定义的实现类会解析token，获得userID等操作
- 相当于 mvc:argument-resolvers注入AuthenticationPrincipalArgumentResolver
- 相当于

	- Authentication authentication =
    SecurityContextHolder.getContext().getAuthentication();
    CustomUser custom = (CustomUser) authentication == null ? null : authentication.getPrincipal();

- PARAMETER

	- ANNOTATION_TYPE

- @EnableWebSecurity注解自动加上了

## Hibernate-Validator

### @Valid

- METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE
- 开启验证

### @Validated

- 开启分组验证
- TYPE, METHOD, PARAMETER

### @Null

- 被注解的元素必须为null

### @NotNull

- 被注解的元素必须不为null

### @AssertTrue

- 被注解的元素必须为true

### @AssertFalse

- 被注解的元素必须为false

### @Min(value)

- 被注解的元素必须为数字，其值必须大于等于最小值

### @Max(value)

- 被注解的元素必须为数字，其值必须小于等于最小值

### @Size(max,min)

- 被注解的元素的大小必须在指定范围内

### @Past

- 被注解的元素必须为过去的一个时间

### @Future

- 被注解的元素必须为未来的一个时间

### @Pattern

- 被注解的元素必须符合指定的正则表达式

## Mybatis

### @MapperScan

- 扫描包获得Mapper-XML

## Mybatis-Plus

