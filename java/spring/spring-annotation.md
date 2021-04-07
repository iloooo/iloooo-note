# Spring 相关注解总结

## Spring

## Spring MVC

## Spring 事务

## spring-mvc

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

## Spring容器初始化总结

### 创建IOC容器（ApplicationContext）

- web容器在web.xml定义加载

	- ContextLoaderListener负责创建IOC容器，并把容器放到ServletContext中
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

### Spring相关XML配置

- 声明Spring IOC配置为applicationContext.xml：
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
- SpringMVC的DispatcherServlet接管URL映射并定义spring-mvc.xml
<servlet>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>

### 注解驱动

- <mvc:annotation-driven />
- <context:component-scan base-package="com.atguigu"></context:component-scan>

