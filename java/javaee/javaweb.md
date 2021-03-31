# JavaWeb

## Servlet

### ServletContext：一个 web 工程，只有一个 ServletContex 对象实例 

### Request域对象：Attribute

- 范围：用于请求转发的多个资源中共享数据
- 操作：

	- 1.void setAttribute(String name,Object obj):存储数据
	- 2.Object getAttitude(String name):通过键获取值
	- 3.void removeAttribute(String name):通过键移除键值对

### 请求转发 forward （内部）

- 特点：

	- 1. 浏览器地址栏路径不发生变化
	- 2. 只能转发到当前服务器内部资源中。
	- 3. 转发是一次请求 (浏览器只请求了一次) 可以使用request域对象来共享数据

- 实现：

	- 1.通过request对象获取请求转发器对象：RequestDispatcher  getRequestDispatcher(String path)
	- 2.使用RequestDispatcher对象来进行转发：request.getRequestDispatcher("/requestDemo9").forward(request,response);

### 重定向 redirect

- 特点：

	- 1. 地址栏发生变化
	- 2. 重定向可以访问其他站点(服务器)的资源
	- 3. 重定向是两次请求。不能使用request域对象来共享数据

- 实现：

	- 1.设置状态码为302response.setStatus(302);
	- 2.设置响应头location response.setHeader("location","/day15/responseDemo2");

## Filter

### 概念：将请求拦截下来，过滤响应，完成一些特殊的功能。

### 作用：完成通用的操作。如：登录验证、统一编码处理、敏感字符过滤...日记操作、事务管理

### 使用：

- 1. 定义一个类，实现接口Filter
- 2.复写方法：init()/doFilter()/destroy()
- 3. 配置拦截

	- 拦截实现方式：

		- 注解

			- @WebFilter("/*")  

		- XML

			-      <filter>
         <filter-name>demo1</filter-name>
         <filter-class>cn.itcast.web.filter.FilterDemo1</filter-class>
     </filter>
     <filter-mapping>
         <filter-name>demo1</filter-name>
           <!-- 拦截路径 --><url-pattern>/*</url-pattern>
    </filter-mapping>

	- 路径的选项：

		- 1. 具体资源路径： /index.jsp   
		- 2. 拦截目录： /user/* 访问/user下的所有资源时，过滤器都会被执行
		- 3. 后缀名拦截： *.jsp  访问所有后缀名为jsp资源时，过滤器都会被执行
		- 4. 拦截所有资源：/*  访问所有资源时，过滤器都会被执行
		- 5.不能 /index*    /index.*  /*.html

	- 拦截方式配置

		- 5种方式：

			- 1. REQUEST：默认值。浏览器直接请求资源
			- 2. FORWARD：转发访问资源
			- 3. INCLUDE：包含访问资源
			- 4. ERROR：错误跳转资源
			- 5. ASYNC：异步访问资源

		- 注解：dispatcherTypes属性
		- web.xml：<dispatcher></dispatcher>

### Servlet Filter

- Filter API

	- javax.servlet.Filter：包含有Filter的生命周期方法，在servlet容器初始化时或者销毁时被调用；
	- javax.servlet.FilterConfig：包含有关于Filter的配置信息，里边最重要就是它的初始化参数；
	- javax.servlet.FilterChain：是servlet容器提供的来实现多个过滤器之间的调用；

- FilterChain 过滤器链   （多个过滤器）

	- 特点
	- 先后顺序

		- 1. 注解配置：按照类名的字符串比较规则比较，值小的先执行
		- 2. web.xml配置： <filter-mapping>谁定义在上边，谁先执行

## Listener

### 事件监听机制：

- * 事件 ：一件事情
- * 事件源 ：事件发生的地方
- * 监听器 ：一个对象
- * 注册监听：将事件、事件源、监听器绑定在一起。 当事件源上发生某个事件后，执行监听器代码

### 作用：  监听某种事物的变化。然后通过回调函数，反馈给客户（程序）去做一些相应的处理。

### ServletContextListener

- 1. 定义一个类，实现ServletContextListener接口
- 2. 复写方法
- 3.配置

	- web.xml

		- <listener>
   <listener-class>cn.itcast.web.listener.ContextLoaderListener</listener-class>
</listener>
* 指定初始化参数<context-param>

	- 注解：@WebListener

## 会话技术

### 概念：一次会话中包含多次请求和响应。
（一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止）

### 功能：在一次会话的范围内的多次请求间，共享数据

### 客户端会话技术：Cookie

- TODO

### 服务器端会话技术：Session

- 原理：

	- TODO

