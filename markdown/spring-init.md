# Spring容器初始化总结

## 创建IOC容器（ApplicationContext）

### web容器在web.xml定义加载

- ContextLoaderListener负责创建IOC容器，并把容器放到ServletContext中
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

## 定义XML配置位置

### 声明Spring IOC配置为applicationContext.xml：
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>

### SpringMVC的DispatcherServlet接管URL映射并定义spring-mvc.xml
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

## 注解驱动

### <mvc:annotation-driven />

### <context:component-scan base-package="com.atguigu"></context:component-scan>

