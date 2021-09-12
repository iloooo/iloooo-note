# CSRF跨域请求伪造

CSRF 就是跨域请求伪造，英文全称是 Cross Site Request Forgery。

## 原理

下图简单阐述了CSRF攻击的思想：

![在这里插入图片描述](https://img-blog.csdnimg.cn/img_convert/31dc041623237a6289b9bf3783df80cb.png#pic_center)

从上图可以看出，要完成一次CSRF攻击，受害者必须依次完成两个步骤：

1.登录受信任网站A，并在本地生成Cookie。

2.在不登出A的情况下，访问危险网站B。



## 个人理解

攻击网站在不知道客户 **cookie** 的情况下，用户访问攻击网站时，攻击网站通过 **跨域访问** 目标网站业务API，并携带了目标网站cookie，服务器不能判断操作来源误认为正确访问。



## CSRF防御 

### 方式1：Cookie Hashing(所有表单都包含同一个伪随机值)

> 单纯防范CSRF，即假设攻击网站无法获得cookie信息

方法：

* 后端提供cookie时,增加_csrf 的随机数参数
* 前端请求时，从cookie中获得_csrf参数放到请求参数里
* 后端判断请求参数_csrf防御CSRF

#### Spring Security CSRF

```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .successHandler((req,resp,authentication)->{
                    resp.getWriter().write("success");
                })
                .permitAll()
                .and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
```

```html
<script>
    $("#loginBtn").click(function () {
        let _csrf = $.cookie('XSRF-TOKEN');
        $.post('/login.html',{username:$("#username").val(),password:$("#password").val(),_csrf:_csrf},function (data) {
            alert(data);
        })
    })
</script>
```

#### &#x1f514; TODO：Apache Shiro CSRF



### 方式2：验证码（同时防范XSS漏洞，即攻击网站获得了cookie）

> &#x1F4DC; [跨站脚本漏洞XSS.md](跨站脚本漏洞XSS.md)

每次的用户提交都需要用户在表单中填写一个图片上的随机字符串

### 方式3：One-Time Tokens(不同的表单包含一个不同的伪随机值)

效果同方式1

## 参考

> &#x1f449; [SpringBoot 如何防御 CSRF 攻击](https://mp.weixin.qq.com/s/CFchihImcC3_J4uqmgzE3w)
>
> &#x1f449; [Cross-site request forgery攻击方式](https://blog.csdn.net/qq_41499808/article/details/108710843)

