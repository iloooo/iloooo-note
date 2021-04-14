# Servlet

## ServletContext：一个 web 工程，只有一个 ServletContex 对象实例 

## Request域对象：Attribute

### 范围：用于请求转发的多个资源中共享数据

### 操作：

- 1.void setAttribute(String name,Object obj):存储数据
- 2.Object getAttitude(String name):通过键获取值
- 3.void removeAttribute(String name):通过键移除键值对

## 请求转发 forward （内部）

### 特点：

- 1. 浏览器地址栏路径不发生变化
- 2. 只能转发到当前服务器内部资源中。
- 3. 转发是一次请求 (浏览器只请求了一次) 可以使用request域对象来共享数据

### 实现：

- 1.通过request对象获取请求转发器对象：RequestDispatcher  getRequestDispatcher(String path)
- 2.使用RequestDispatcher对象来进行转发：request.getRequestDispatcher("/requestDemo9").forward(request,response);

## 重定向 redirect

### 特点：

- 1. 地址栏发生变化
- 2. 重定向可以访问其他站点(服务器)的资源
- 3. 重定向是两次请求。不能使用request域对象来共享数据

### 实现：

- 1.设置状态码为302response.setStatus(302);
- 2.设置响应头location response.setHeader("location","/day15/responseDemo2");

## Bak-Home

