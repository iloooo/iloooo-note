# spring-mvc

## 解决的问题：

### Java应用中：创建和使用SpringIOC容器需要创建ApplicationContext的实例，配置Bean的XML或者注解

- ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
UserDao userDao = (UserDao) applicationContext.getBean("userDao");

### Web应用中：Tomcat容器运行期间维护着ServletContext实例，ServletContextListener监听器监听其创建和销毁

### Web应用中使用Spring：

- ①IOC容器（ApplicationContext）随服务器启动创建：

	- 加载springmvc实现ContextLoaderListener的监听器：ContextLoaderListener
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

		- ContextLoaderListener负责创建IOC容器，并把容器放到ServletContext中

	- 声明Spring IOC配置为applicationContext.xml：
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>

- ②SpringMVC的DispatcherServlet接管URL映射并定义spring-mvc.xml

	- <servlet>
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

- ③spring-mvc.xml 配置，xml或者注解开发MVC架构

## 组件解析

### 

### C 前端控制器 DispatcherServlet(调度)

- 调用HandlerMapping 处理器映射器

	- 根据用户请求找到具体的Handler 处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回
	- 返回：处理器执行链 HandlerExecutionChain

- 调用HandlerAdapter 处理器适配器

	- 经过适配调用具体的 处理器Controller(也叫后端控制器)
	- Controller返回：ModelAndView

- 调用ViewReslover 视图解析器

	- 处理 DispatcherServlet传来的ModelAndView
	- 返回：具体View

- 渲染视图（即将模型数据填充至视图中）
- DispatcherServlet响应用户

## 开发步骤

### ②配置SpringMVC核心控制器DispathcerServlet

### ③创建Controller类和视图页面

### ④使用注解配置Controller类中业务方法的映射地址

### ⑤配置SpringMVC核心文件 spring-mvc.xml

### ⑥客户端发起请求测试

## spring-mvc.xml 配置

### Spring 相关配置：组件扫描

### 配置mvc注解驱动：<mvc:annotation-driven />

- 1.自动加载 
RequestMappingHandlerMapping（处理映射器）
RequestMappingHandlerAdapter（处理器适配器）
- 2.替代注解处理器和适配器的配置
- 3.默认底层就会集成jackson进行对象或集合的json格式字符串的转换

### 放行静态资源访问

- <mvc:default-servlet-handler/>
- <mvc:resources mapping="/js/**"location="/js/"/>

	- 前端控制器DispatcherServlet的url-pattern配置的是/,代表对所有的资源都进行过滤操作。需要指定放行静态资源

### viewResolver视图解析器配置

- <bean id="resourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
- Controller返回值拼接的前缀

	- <property name="prefix" value="/WEB-INF/pages/"></property>

- Controller返回值拼接的后缀

	- <property name="suffix" value=".jsp"></property>

## Filter

### 乱码过滤器

- filter-class：CharacterEncodingFilter

  <filter>
     <filter-name>CharacterEncodingFilter</filter-name>
     <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
     <init-param>
       <param-name>encoding</param-name>
       <param-value>UTF-8</param-value>
     </init-param>
   </filter>
   <filter-mapping>
     <filter-name>CharacterEncodingFilter</filter-name>
     <url-pattern>/*</url-pattern>
   </filter-mapping>

## Interceptor 拦截器

### AOP思想的具体实现

### SpringMVC拦截器和Filter的区别

## Exception 异常处理机制

### 异常向上抛出，最后由SpringMVC前端控制器交由异常处理器进行异常处理

### 简单异常处理器SimpleMappingExceptionResolver

<!--配置简单映射异常处理器-->
  <bean class=“org.springframework.web.servlet.handler.SimpleMappingExceptionResolver”>   
<property name=“defaultErrorView” value=“error”/>  默认错误视图
       <property name=“exceptionMappings”>
           <map>                异常类型                                            错误视图
               <entry key="com.itheima.exception.MyException" value="error"/>
               <entry key="java.lang.ClassCastException" value="error"/>
           </map>
       </property>
   </bean>

### 自定义异常处理器
实现HandlerExceptionResolver接口

①创建异常处理器类实现HandlerExceptionResolver
  public class MyExceptionResolver implements HandlerExceptionResolver {
@Override
public ModelAndView resolveException(HttpServletRequest request,
  HttpServletResponse response, Object handler, Exception ex) {
  //处理异常的代码实现
  //创建ModelAndView对象
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.setViewName("exceptionPage");
  return modelAndView;
  }
}
  
②配置异常处理器
  <bean id="exceptionResolver"    
   class="com.itheima.exception.MyExceptionResolver"/>
  
③编写异常页面
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Title</title>
</head>
<body>
这是一个最终异常的显示页面
</body>
</html>
  
④测试异常跳转
  @RequestMapping("/quick22")
@ResponseBody
public void quickMethod22() throws IOException, ParseException {
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  simpleDateFormat.parse("abcde");
}

## 文件上传

## spring-mvc 注解总结

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

## 

