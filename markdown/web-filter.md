# Filter

## 概念：将请求拦截下来，过滤响应，完成一些特殊的功能。

## 作用：完成通用的操作。如：登录验证、统一编码处理、敏感字符过滤...日记操作、事务管理

## 使用：

### 1. 定义一个类，实现接口Filter

### 2.复写方法：init()/doFilter()/destroy()

### 3. 配置拦截

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

## Servlet Filter

### Filter API

- javax.servlet.Filter：包含有Filter的生命周期方法，在servlet容器初始化时或者销毁时被调用；
- javax.servlet.FilterConfig：包含有关于Filter的配置信息，里边最重要就是它的初始化参数；
- javax.servlet.FilterChain：是servlet容器提供的来实现多个过滤器之间的调用；

### FilterChain 过滤器链   （多个过滤器）

- 特点
- 先后顺序

	- 1. 注解配置：按照类名的字符串比较规则比较，值小的先执行
	- 2. web.xml配置： <filter-mapping>谁定义在上边，谁先执行

## Bak-Home

