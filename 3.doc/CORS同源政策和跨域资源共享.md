# 跨域资源共享 CORS

> 首先了解 &#x1F4DC; [同源策略与跨域解决方案.md](同源策略与跨域解决方案.md)

### 跨域资源共享 CORS

CORS 是一种基于[HTTP](https://developer.mozilla.org/zh-CN/docs/Glossary/HTTP) 头的机制，它允许服务端来指定哪些主机[origin](https://developer.mozilla.org/zh-CN/docs/Glossary/Origin)（域，协议和端口）可以从这个服务端加载资源。

缩写："跨域资源共享"（Cross-origin resource sharing）

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



### CROS实现方式

#### &#x1f514; TODO：Apache Shiro 配置CROS

#### &#X1f514; TODO：Spring Security 配置CROS

#### &#x1f514; TODO：SpringMVC，Boot配置CROS

#### SpringBoot 配置CORS

Spring Boot默认对请求方法**只支持GET、HEAD和POST方式**，如果采用其他方式的请求，如DELETE,PUT等，**会变成option请求**。为了满足标准的Restful API，需要对默认的进行扩充

##### 方式1：返回新的CorsFilter

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configurationpublic
class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setMaxAge(3600L);
        corsConfiguration.setAllowCredentials(true);

        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());

        return new CorsFilter(source);
    }
}
```

##### 方式2：重写WebMvcConfigurer

```java
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {
    或者
@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            //设置允许跨域的路径
            registry.addMapping("/**")
                //设置允许跨域请求的域名                
                //当**Credentials为true时，**Origin不能为星号，需为具体的ip地址【如果接口不带cookie,ip无需设成具体ip】
                .allowedOrigins("*") 
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法 .allowedMethods("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE"); 
            	//跨域允许时间.maxAge(3600)
        }
    };
}
```

##### 方式3：使用注解（@CrossOrigin）

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("/admin/sysLog")
@CrossOrigin
public class SysLogController {
 
}
```

##### 方式4：手工设置响应头（HttpServletResponse ）

这种方式，可以自己手工加到，具体的controller，inteceptor，filter等逻辑里。

```java
@RequestMapping("/test")
@ResponseBody
public String test(){
	response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
	return "success";
}
```

> &#x1f449; [springboot设置Cors跨域的四种方式](https://blog.csdn.net/Mint6/article/details/104726325)

## 防止CSRF跨源伪造访问

* 防止**CSRF跨域请求伪造**（客户在B网站访问源网站时默认带上客户的cookie）攻击，可以通过在前端请求时拿取cookie中csrf token标识字段（因为攻击者不知道你cookie，如果XSS漏洞拿取了客户cookie还有其他防御办法）

> &#x1F4DC; [CSRF跨域请求伪造.md](CSRF跨域请求伪造.md)

