# Listener

## 事件监听机制：

### * 事件 ：一件事情

### * 事件源 ：事件发生的地方

### * 监听器 ：一个对象

### * 注册监听：将事件、事件源、监听器绑定在一起。 当事件源上发生某个事件后，执行监听器代码

## 作用：  监听某种事物的变化。然后通过回调函数，反馈给客户（程序）去做一些相应的处理。

## ServletContextListener

### 1. 定义一个类，实现ServletContextListener接口

### 2. 复写方法

### 3.配置

- web.xml

	- <listener>
   <listener-class>cn.itcast.web.listener.ContextLoaderListener</listener-class>
</listener>
* 指定初始化参数<context-param>

- 注解：@WebListener

## Bak-Home

