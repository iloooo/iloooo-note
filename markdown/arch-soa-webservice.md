# Web Service

## 介绍

### Web Service平台需支持XML + HTTP

### RPC协议（远程服务调用协议）和REST风格

### 是一种跨编程语言和跨操作系统平台的远程调用技术

## 开发规范

### JAX-WS（JAX-RPC）

- Java API For XML-WebService
- javax.xml.ws.*
- 提供API 操作Web 服务
- 基于SOAP 的Web 服务

### JAXM&SAAJ

- JAVA API For XML Message
- javax.messaging.*是JAVAEE的可选包
- SOAP With Attachment API For Java
- 构建SOAP包和解析SOAP 
- 暴漏了SOAP更多的底层细节，编码比较麻烦

### JAX RS

- Java API for RESTful Web Services
- REST(RepresentationState Transfer)风格规范
- javax.ws.rs.*

## 三要素

### SOAP (简易对象访问协议)

- 简单对象访问协议(Simple Object Access Protocol)
- 基于XML语言用于有网上传输数据的通信协议
- HTTP的基础上+XML数据
- 组成

	- a)  Envelope – 必须的部分。以XML的根元素出现。
	- b)  Headers – 可选的。
	- c)  Body – 必须的。在body部分，包含要执行的服务器的方法。和发送到服务器的数据。

### WSDL (Web services 描述语言)

- SebService Definition Language
- 基于 XML 的用于 描述 以及 如何访问 Web Services 的语言

### UDDI (通用描述、发现及整合)

- Universal Description，Discovery and Integration
- 是一种目录服务，通过它企业可注册并搜索 Web services

## Apache CXF

### Apache CXF 开发步骤

- SOAP

	- 服务端

		- 1.引入依赖，jax-ws和jax-rs对应的包不同
		- 2.服务接口

			- @WebService

			  javax.jws.WebService
			  JDK

		- 3.服务端接口实现类

		  public class HelloServiceImpl implements HelloService {
		     public String sayHello(String name) {
		         return name + ",Welcome to Itheima!";
		     }
		  }

		- Spring整合

			- 整合1.web.xml 配置CXFServlet

			  <!‐‐ webservice服务端，发布服务需要配置CXFServlet ‐‐>
			  <!‐‐ 这里配置的servlet路径，最为最终服务路径的一部分： ‐‐>
			  <!‐‐ 服务访问路径：web.xml配置路径/spring配置的路径 ‐‐>
			  <servlet>
			  	<servlet‐name>cxfServlet</servlet‐name>
			  	<servlet‐class>org.apache.cxf.transport.servlet.CXFServlet</servlet‐class>
			  </servlet>
			  
			  <servlet‐mapping>
			  	<servlet‐name>cxfServlet</servlet‐name>
			  	<url‐pattern>/ws/*</url‐pattern>
			  </servlet‐mapping>

			- 整合2.Spring整合ApacheCXF，发布服务(服务地址、服务bean)

			  <beans ...
			  		xmlns:cxf="http://cxf.apache.org/core"
			  		xmlns:jaxws="http://cxf.apache.org/jaxws"
			  		xmlns:jaxrs="http://cxf.apache.org/jaxrs"
			  		xsi:schemaLocation="...
			  		http://cxf.apache.org/core
			  		http://cxf.apache.org/schemas/core.xsd
			  		http://cxf.apache.org/jaxws
			  		http://cxf.apache.org/schemas/jaxws.xsd
			  		http://cxf.apache.org/jaxrs
			  		http://cxf.apache.org/schemas/jaxrs.xsd">
			  <jaxws:server address="/userService">
			  		<jaxws:serviceBean>
			  			<bean class="com.itheima.service.impl.UserServiceImpl"></bean>
			  		</jaxws:serviceBean>
			  </jaxws:server>

		- 4.发布服务

			- JaxWsServerFactoryBean手写发布

			  // 服务工厂
			  JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
			  // 设置服务地址
			  factory.setAddress("http://localhost:8000/user");
			  // 设置服务类
			  factory.setServiceBean(new UserServiceImpl());
			  // 添加日志输入、输出拦截器，观察soap请求、soap响应内容
			  factory.getInInterceptors().add(new LoggingInInterceptor());
			  factory.getOutInterceptors().add(new LoggingOutInterceptor());
			  // 发布服务
			  factory.create();

			- spring整合后，运行tomcat或maven-tomcat-run

		- 5.访问wsdl说明书

			- http://localhost:8000/user?wsdl

	- 客户端

		- 1.明确服务端地址、接口、接口方法（方法参数、返回值）
		- 2.与服务端项目依赖一致
		- 3.服务端接口

			- @WebService

			  javax.jws.WebService
			  JDK

		- Spring整合ApacheCXF，客户端配置

		  <beans ...
		  	xmlns:cxf="http://cxf.apache.org/core"
		  	xmlns:jaxws="http://cxf.apache.org/jaxws"
		  	xmlns:jaxrs="http://cxf.apache.org/jaxrs"
		  	xsi:schemaLocation="...
		  	http://cxf.apache.org/core
		  	http://cxf.apache.org/schemas/core.xsd
		  	http://cxf.apache.org/jaxws
		  	http://cxf.apache.org/schemas/jaxws.xsd
		  	http://cxf.apache.org/jaxrs
		  	http://cxf.apache.org/schemas/jaxrs.xsd">
		  <jaxws:client id="userService" address="http://localhost:8080/ws/userService"
		  	serviceClass="com.itheima.service.UserService">
		  </jaxws:client>

		- 访问服务端

			- 手写JaxWsProxyFactoryBean访问服务 

			  // 创建cxf代理工厂
			  JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
			  // 设置远程访问服务端地址
			  factory.setAddress("http://localhost:8000/ws/hello");
			  // 设置接口类型
			  factory.setServiceClass(HelloService.class);
			  // 对接口生成代理对象
			  HelloService helloService = factory.create(HelloService.class);
			  // 代理对象对象
			  System.out.println(helloService.getClass());
			  // 远程访问服务端方法
			  String content = helloService.sayHello("Jet");

			- Junit 手写访问测试Spring整合

			  @RunWith(SpringJUnit4ClassRunner.class)
			  @ContextConfiguration("classpath:applicationContext.xml")
			  public class Client {
			   
			  // 注入远程访问服务端的接口的代理对象。
			  @Resource
			  private UserService userService;
			  @Test
			  public void test() throws Exception {
			  // org.apache.cxf.jaxws.JaxWsClientProxy@2826f61
			  System.out.println(userService);
			  // class com.sun.proxy.$Proxy45
			  System.out.println(userService.getClass());
			  // 远程调用服务接口
			  String content = userService.sayHi("球球");
			  System.out.println(content);

- RESTful

	- 服务端

		- 1.依赖

		  <!‐‐ cxf jaxrs 支持包 ‐‐>
		  <dependency>
		  <groupId>org.apache.cxf</groupId>
		  <artifactId>cxf‐rt‐frontend‐jaxrs</artifactId>
		  <version>3.0.1</version>
		  </dependency>
		   
		  <!‐‐ cxf内置的jetty服务器 ‐‐>
		  <dependency>
		  <groupId>org.apache.cxf</groupId>
		  <artifactId>cxf‐rt‐transports‐http‐jetty</artifactId>
		  <version>3.0.1</version>
		  </dependency>
		   
		  <!‐‐ 客户端调用时候使用的包(WebClient工具类调用服务端) ‐‐>
		  <dependency>
		  <groupId>org.apache.cxf</groupId>
		  <artifactId>cxf‐rt‐rs‐client</artifactId>
		  <version>3.0.1</version>
		  </dependency>
		   
		  <!‐‐ 基于restful风格的webservice，客户端与服务端之间可以传递json，这个就是json支持相关包 ‐‐>
		  <dependency>
		  <groupId>org.apache.cxf</groupId>
		  <artifactId>cxf‐rt‐rs‐extension‐providers</artifactId>
		  <version>3.0.1</version>
		  </dependency>
		  <!‐‐ 转换json工具包，被extension providers 依赖 ‐‐>
		  <dependency>
		  <groupId>org.codehaus.jettison</groupId>
		  <artifactId>jettison</artifactId>
		  <version>1.3.7</version>
		  </dependency>

		- 2.实体类Entity

		  @XmlRootElement(name = "Car")
		  public class Car {
		  private Integer id;
		  private String carName;
		  private Double price;

		- 3.服务接口service

		  // 访问当前服务接口对应的路径
		  @Path("/userService")
		  @Produces("*/*") // 服务器支持的返回的数据格式类型
		  public interface IUserService {
		   
		  // 表示处理的请求的类型，post 对应的是insert新增操作
		  @POST
		  // 访问当前服务接口方法对应的路径。 【.../userService/user】
		  @Path("/user")
		  // 服务器支持的请求的数据格式类型
		  @Consumes({ "application/xml", "application/json" })
		  public void saveUser(User user);
		   
		  // 表示处理的请求的类型，put 对应的是update修改操作
		  @PUT
		  @Path("/user")
		  @Consumes({ "application/xml", "application/json" })
		  public void updateUser(User user);
		   
		  // 表示处理的请求的类型，get 对应的是查询修改操作
		  @GET
		  @Path("/user")
		  // 服务器支持的返回的数据格式类型
		  @Produces({ "application/xml", "application/json" })
		  public List<User> findAllUsers();

		- 4.服务接口的实现ServiceImpl

		  public class UserServiceImpl implements IUserService {
		  public List<User> findAllUsers() {
		  List<User> users = new ArrayList<User>();
		  User user1 = new User();
		  user1.setId(1);
		  user1.setUsername("小明");
		  user1.setCity("北京");
		  List<Car> carList1 = new ArrayList<Car>();
		  User user2 = new User();
		  return users;
		  }

		- Spring整合
		- 5.发布服务

			- JAXRSServerFactoryBean手写发布

			  // 创建发布服务的工厂
			  JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
			  // 设置服务地址
			  factory.setAddress("http://localhost:8001/ws/");
			  // 设置服务类
			  factory.setServiceBean(new UserServiceImpl());
			  // 添加日志输入输出拦截器
			  factory.getInInterceptors().add(new LoggingInInterceptor());
			  factory.getOutInterceptors().add(new LoggingOutInterceptor());
			  // 发布服务
			  factory.create();
			  System.out.println("发布服务成功，端口8001");

			- spring整合后，运行tomcat或maven-tomcat-run-war

	- 客户端

		- 1.依赖

		  <!‐‐ cxf jaxrs 支持包 ‐‐>
		  <dependency>
		  <groupId>org.apache.cxf</groupId>
		  <artifactId>cxf‐rt‐frontend‐jaxrs</artifactId>
		  <version>3.0.1</version>
		  </dependency>
		   
		  <!-- 客户端 -->
		  <dependency>
		    <groupId>org.apache.cxf</groupId>
		    <artifactId>cxf-rt-rs-client</artifactId>
		    <version>3.0.1</version>
		  </dependency>
		   
		  <!‐‐ 客户端调用时候使用的包(WebClient工具类调用服务端) ‐‐>
		  <dependency>
		  <groupId>org.apache.cxf</groupId>
		  <artifactId>cxf‐rt‐rs‐client</artifactId>
		  <version>3.0.1</version>
		  </dependency>
		   
		  <!‐‐ 基于restful风格的webservice，客户端与服务端之间可以传递json，这个就是json支持相关包 ‐‐>
		  <dependency>
		  <groupId>org.apache.cxf</groupId>
		  <artifactId>cxf‐rt‐rs‐extension‐providers</artifactId>
		  <version>3.0.1</version>
		  </dependency>
		  <!‐‐ 转换json工具包，被extension providers 依赖 ‐‐>
		  <dependency>
		  <groupId>org.codehaus.jettison</groupId>
		  <artifactId>jettison</artifactId>
		  <version>1.3.7</version>
		  </dependency>

		- 2.实体类Entity

		  @XmlRootElement(name = "Car")
		  public class Car {
		  private Integer id;
		  private String carName;
		  private Double price;

			- {"User":  {"id":100,  "username":"jack","city":"广州" }}
			- <User>
    <id></id>
    <username></username>
    <city></city>
</User>

		- 访问服务端：WebClient

			- org.apache.cxf.jaxrs.client.WebClient
User user = new User();
user.setId(100);
// 通过WebClient对象远程调用服务端
WebClient
	.create("http://localhost:8080/ws/userService/userService/user")
	.type(MediaType.APPLICATION_JSON)  // 指定请求的数据格式为json
	.post(user);

### 介绍

- Celtix + XFire

## SOAP和RESTful的实现对比总结

## RESTful注解

### 实体类Entity：@XmlRootElement(name = "XXX")

- JDK-rt.jar
- 参数

	- namespace() default "##default"
	- name() default "##default"

- 指定根元素，客户端与服务端传递对象数据时候，序列化为xml或json的根元素的名称

  <Car></Car>
  或者
  {"Car": {"id":100,"name":"","price":100}}

### 服务端接口

- @Path("/userService")

  方法上继续定义
  @Path("/user")：访问当前服务接口方法对应的路径.../userService/user

	- 访问当前服务接口对应的路径

- @Consumes("application/xml")

  @Consumes({ "application/xml", "application/json" })

	- 服务器支持的 **请求**数据格式类型

- @Produces("*/*")

  image/jpeg
  @Produces({ "application/xml", "application/json" })

	-  服务器支持的 **返回**数据格式类型

- HTTP请求方法

	- @PUT
	- @GET
	- @POST
	- @DELETE

## SOAP客户端：传递参数、调用service总结（过程可看做调用方法传参已获得结果）

### Bean中配置好@Webservice接口服务的URL（相当于服务已经连接好了，）

### 调用注入的bean的方法，相当于传参去调用服务器这个接口的实现类

