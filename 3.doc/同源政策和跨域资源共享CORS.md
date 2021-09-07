# 同源政策 和 跨域资源共享 CORS

## 同源政策

[浏览器安全的基石同源政策](https://www.ruanyifeng.com/blog/2016/04/same-origin-policy.html)

浏览器从一个域名的网页去请求另一个域名的资源时，**域名、端口、协议任一不同**

> "不同"注意:  域名和域名ip ,localhost和127.0.0.1虽然都指向本机，但也属于跨域

### 非同源行为受到限制（不能共享）:

```
（1） Cookie、LocalStorage 和 IndexDB 无法读取。
（2） DOM 无法获得。
（3） AJAX 请求不能发送。
```

#### Cookie非同源共享：

```javascript
document.domain = 'example.com';
或者：
Set-Cookie: key=value; domain=.example.com; path=/
```

> `http://w1.example.com/a.html`和`http://w2.example.com/b.html`，只要设置相同的`document.domain`，两个网页就可以共享Cookie。

#### AJAX非同源共享：

```
◾JSONP
◾WebSocket
◾CORS
```

## 跨域资源共享 CORS

概念："跨域资源共享"（Cross-origin resource sharing）,它允许浏览器向跨源服务器，发出[`XMLHttpRequest`](https://www.ruanyifeng.com/blog/2012/09/xmlhttprequest_level_2.html)请求，从而克服了AJAX只能同源使用的限制。

### 浏览器CROS分类

#### 简单请求（simple request）

```
（1) 请求方法是以下三种方法之一：
◾HEAD
◾GET
◾POST

（2）HTTP的头信息不超出以下几种字段：
◾Accept
◾Accept-Language
◾Content-Language
◾Last-Event-ID
◾Content-Type：只限于三个值application/x-www-form-urlencoded、multipart/form-data、text/plain
```

处理：https://www.ruanyifeng.com/blog/2016/04/cors.html

#### 非简单请求（not-so-simple request）

凡是不同时满足上面两个条件，就属于非简单请求

处理：https://www.ruanyifeng.com/blog/2016/04/cors.html

TODO：VUE 配置CROS

TODO：Apache Shiro 配置CROS

TODO：Spring Security 配置CROS

TODO：SpringMVC，Boot配置CROS

### SpringBoot 配置CORS

Spring Boot默认对请求方法**只支持GET、HEAD和POST方式**，如果采用其他方式的请求，如DELETE,PUT等，**会变成option请求**。为了满足标准的Restful API，需要对默认的进行扩充

```java
@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                .allowedOrigins("*") //允许所有的url
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE");
        }
    };
}
```

