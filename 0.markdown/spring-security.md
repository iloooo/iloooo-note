# spring-security

## Web 权限方案

### yml设置username和password直接controller测试，会拦截url到自带登录页面，输入yml配置user和password可以访问此controller

### 设置登录系统的账号、密码

- 方式一：在 application.properties

	- spring.security.user.name=xxx
	- spring.security.user.password=xxx

- 方式二：编写类实现接口

### 实现数据库认证来完成用户登录

- 重写UserDetailsService的 loadUserByUsername方法，变为从数据库获取

### 未认证请求跳转到登录页

- 配置配置类继承WebSecurityConfigurerAdapter

## 术语与原理

### Web 应用的安全性

- 用户认证（Authentication）

	- 检验用户是否能访问系统
	- 你是谁

- 用户授权（Authorization）

	- 检验某个用户是否有权限执行某个操作
	- 你能干什么

- 术语

	- 主体principal

		- 谁使用系统谁就是主体

	- 认证authentication

		- “主体”证明自己是谁

	- 授权authorization

		- 是给用户分配权限

### 原理

- Filter

	- 本质是一个过滤器链：SpringSecurityFilterChain

- Servlet
- AOP

### Web Security

## 源码

### Spring Boot 自动配置Spring Security

- Spring Boot 配置文件中spring.security 配置项，对应 SecurityProperties 配置类

	- SecurityProperties 

- 默认情况下，Spring Boot UserDetailsServiceAutoConfiguration 自动化配置类，会创建一个内存级别的 InMemoryUserDetailsManager Bean 对象，提供认证的用户信息

	- 账号：user，密码：UUID.randomUUID().toString()

- SecurityAutoCnfiguration

	- @SpringBotAplication(exclude = {SecurityAutoCnfiguration.class})

### PasswordEncoder 接口

- // 表示把参数按照特定的解析规则进行解析
- String encode(CharSequence rawPassword);
- // 表示验证从存储中获取的编码密码与编码后提交的原始密码是否匹配。如果密码匹配，则返回 true；如果不匹配，则返回 false。第一个参数表示需要被解析的密码。第二个参数表示存储的密码。
- boolean matches(CharSequence rawPassword, String encodedPassword);
- // 表示如果解析的密码能够再次进行解析且达到更安全的结果则返回 true，否则返回false。默认返回 false。
- default boolean upgradeEncoding(String encodedPassword) {return false;}

### 实现类BCryptPasswordEncoder

- Spring Security 官方推荐的密码解析器，平时多使用
- 对 bcrypt 强散列方法的具体实现。是基于 Hash 算法实现的单向加密。可以通过 strength 控制加密强度，默认 10

### WebSecurityConfigurerAdapter

- configure(AuthenticationManagerBuilder auth)

	- 源码：禁用本地认证配置

		- this.disableLocalConfigureAuthenticationBldr = true;

	- 重写使用

		- auth.inMemoryAuthentication()

			- 使用内存级别的 InMemoryUserDetailsManager

		- auth.userDetailsService(userDetailsService)

			- 择使用自定义的UserDetailsService

- configure(HttpSecurity http)

	- http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
	- http.formLogin();
	- http.httpBasic();

- configure(WebSecurity web)

### AuthenticationManagerBuilder

- 配置全局的认证相关的信息,其实就是下面两个+
- AuthenticationProvider

	- 认证服务提供商

- UserDetailsService

	- 用户详情查询服务
	- 作用是从特定的地方获取认证的数据源（账号、密码）
	- 方法

		- // 表示获取登录用户所有权限
Collection<? extends GrantedAuthority> getAuthorities();
// 表示获取密码
String getPassword();
// 表示获取用户名
String getUsername();
// 表示判断账户是否过期
boolean isAccountNonExpired();
// 表示判断账户是否被锁定
boolean isAccountNonLocked();
// 表示凭证{密码}是否过期
boolean isCredentialsNonExpired();
// 表示当前用户是否可用
boolean isEnabled();

	- 实战

		- 实现其接口自定义UserDetailsService实现类

### HttpSecurity

- 权限控制规则配置，配置相当于xml配置中的一个标签

	- 各种具体的认证机制的相关配置
	- OpenIDLoginConfigurer
	- AnonymousConfigurer
	- FormLoginConfigurer
	- HttpBasicConfigurer等

- 方法

	- csrf()

		- 添加 CSRF 支持，使用WebSecurityConfigurerAdapter时，默认启用

			- 禁用：csrf().disable()

	- authorizeRequests()

		- 开启使用HttpServletRequest请求的访问限制

			- authorizeRequests().anyRequest().authenticated()

		- antMatchers()

			- 其可以与authorizeRequests()、RequestMatcher匹配

				- requestMatchers().antMatchers("/api/**")
				- 拦截的需要认证的url

	- formLogin()

		- 开启表单的身份验证，如果未指定FormLoginConfigurer#loginPage(String)，则将生成默认登录页面

			- formLogin().loginPage("/authentication/login").failureUrl("/authentication/login?failed")
			- formLogin().loginPage("/authentication/login").permitAll()

		- logoutSuccessHandler(logoutSuccessHandler)

			- 指定成功注销后处理类 如果使用了logoutSuccessHandler()的话， logoutSuccessUrl()就会失效

		- .invalidateHttpSession(true)  // httpSession是否有效时间，如果使用了 SecurityContextLogoutHandler，其将被覆盖                           
		- .addLogoutHandler(logoutHandler)在最后增加默认的注销处理类LogoutHandler                
		- .deleteCookies(cookieNamesToClear);//指定注销成功后remove cookies

	- logout()

		- 添加退出登录支持。当使用WebSecurityConfigurerAdapter时，这将自动应用。默认情况是，访问URL”/ logout”，使HTTP Session无效来清除用户，清除已配置的任何#rememberMe()身份验证，清除SecurityContextHolder，然后重定向到”/login?success”

			- logout().deleteCookies("remove").invalidateHttpSession(false).logoutUrl("/custom-logout").logoutSuccessUrl("/logout-success");

	- addFilter()

		- 添加自定义的filter

			- addFilter(new CustomFilter())

	- addFilterAt()

		- 在指定filter相同位置上添加自定义filter

			- addFilterAt(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)

	- addFilterBefore()

		- 在xxxxInterceptor前添加自定义的myFilterSecurityInterceptor

			- http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

	- addFilterAfter()

		- 在指定filter位置后添加自定义filter

			- addFilterAfter(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)

	- requestMatchers()

		- 开启配置HttpSecurity，仅当RequestMatcher相匹配时开启

			- requestMatchers().antMatchers("/api/**")

	- openidLogin()

		- 用于基于 OpenId 的验证

			- openidLogin().permitAll();

	- oauth2Login()

		- 开启OAuth 2.0或OpenID Connect 1.0身份验证

			- authorizeRequests()…anyRequest().authenticated()…and().oauth2Login()

	- rememberMe()

		- 开启配置“记住我”的验证

			- authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin().permitAll().and().rememberMe()

	- and()

		- 返回SecurityBuilder使用完成后SecurityConfigurer 

	- exceptionHandling()

		- 配置异常处理

- 实战

	- 配置 认证失败的handler处理类

		- .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		- 处理类内容：定义401，返回值

	- 登录过后访问无权限的接口时自定义403响应内容

		- .exceptionHandling().accessDeniedHandler(urlAccessDeniedHandler)

	- 配置不使用httpSession，即通过前端传token到后台过滤器中验证是否存在访问权限

		- .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

	- url权限 认证

		- 方式一：不同拦截url不同配置

			- .authorizeRequests().antMatchers("/login", "/captchaImage")

				- .anonymous()

			- .antMatchers(HttpMethod.GET,"/*.html","/**/*.js")

				- .permitAll()

			- .anyRequest() .authenticated() 接上面

				- 除上面外的所有请求全部需要鉴权认证

		- 方式二：拦截所有url

			- http.antMatcher("/**").authorizeRequests()

				- 获得拦截所有请求的ExpressionInterceptUrlRegistry的Registry

					- registry.withObjectPostProcessor

					  registry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
					      @Override
					      public <O extends FilterSecurityInterceptor> O postProcess(O o) {
					          o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
					          o.setAccessDecisionManager(urlAccessDecisionManager);
					          return o;
					      }
					  });
					  
					  

						- setSecurityMetadataSource

							- 认证权限入口
							- 子主题 2

						- setAccessDecisionManager

					- for (String url : oclProperties.getAuth().getIgnoreUrls()) {
    registry.antMatchers(url).permitAll();}
允许匿名的url - 可理解为放行接口 - 除配置文件忽略url以外，其它所有请求都需经过认证和授权
					- registry.anyRequest().authenticated()

- 源码解读

### WebSecurity

- 全局请求忽略规则配置

	- 比如静态文件，注册页面

- 全局HttpFirewall配置
- 是否debug配置
- 全局 SecurityFilterChain 配置
- privilege Evaluator
- expressionHandler
- security Interceptor

### ObjectPostProcessor接口

- 只要一个方法：postProcess（）
- AutowireBeanFactoryObjectPostProcessor 实现类

	- 构建 AutowireBeanFactoryObjectPostProcessor 对象时，传入了一个 AutowireCapableBeanFactory 对象

		- AutowireCapableBeanFactory 帮助我们手动的将一个实例注册到 Spring 容器中

	- postProcess方法是具体的注册逻辑

- 作用

	- 手动注入实例到 Spring 容器，并且让实例走一遍 Bean 的生命周期
	- 核心作用：修改某一个SpringSecurity对象的属性

- 为什么

	- Bean 没有通过自动扫描注入Spring容器原因

		- Spring Security大量的代码是直接 new 出来的

			- 本意是为了简化项目配置

		- 这样话没有将对象的各个属性都暴露出来

	- 我们需要手动将 Bean 注册到 Spring 容器中去，ObjectPostProcessor 就是为了解决该问题。

### SecurityMetadataSource

- 包含着AbstractSecurityInterceptor访问授权所需的元数据（动态url、动态授权所需的数据），在AbstractSecurityInterceptor授权模块中结合AccessDecisionManager进行访问授权
- 自定义SecurityMetadataSource数据源

	- 实现接口FilterInvocationSecurityMetadataSource
	- 使用：用ObjectPostProcessor方式注入

### AccessDecisionManager

- 由AbstractSecurityInterceptor调用，负责做出最终的访问控制决策

## 过滤器链 SpringSecurityFilterChain

### FilterSecurityInterceptor

- 是一个方法级的权限过滤器, 基本位于过滤链的最底部
- super.beforeInvocation(fi) 表示查看之前的 filter 是否通过
- fi.getChain().doFilter(fi.getRequest(), fi.getResponse());表示真正的调用后台的服务

### Filter链（顺序）

- ChannelProcessingFilter

	- 访问协议控制过滤器，可能会将我们重新定向到另外一种协议,从http转换成https

- WebAsyncManagerIntegrationFilter
- SecurityContextPersistenceFilter

	- 创建SecurityContext安全上下文信息和request结束时清空SecurityContextHolder

- HeaderWriterFilter

	- 给http response添加一些Header

- CorsFilter
- CsrfFilter

	- 跨域过滤器，跨站请求伪造保护Filter

- LogoutFilter

	- 处理退出登录的Filter

- X509AuthenticationFilter
- AbstractPreAuthenticatedProcessingFilter
- ConcurrentSessionFilter

	- 并发访问控制过滤器,主要功能：SessionRegistry中获取SessionInformation来判断session是否过期，从而实现并发访问控制.

- X509AuthenticationFilter

	- 添加X509预授权处理机制支持

- UsernamePasswordAuthenticationFilter

	- 对/login 的 POST 请求做拦截，校验表单中用户名，密码
	- 经过这些过滤器后SecurityContextHolder中将包含一个完全组装好的Authentication对象，从而使后续鉴权能正常执行

- DefaultLoginPageGeneratingFilter
- DefaultLogoutPageGeneratingFilter
- ConcurrentSessionFilter
- DigestAuthenticationFilter
- BasicAuthenticationFilter

	- 认证filter，经过这些过滤器后SecurityContextHolder中将包含一个完全组装好的Authentication对象，从而使后续鉴权能正常执行

- RequestCacheAwareFilter
- SecurityContextHolderAwareRequestFilter

	- 此过滤器对ServletRequest进行了一次包装，使得request具有更加丰富的API

- JaasApiIntegrationFilter

	- (JAAS)认证方式filter

- RememberMeAuthenticationFilter

	- 记忆认证处理过滤器，即是如果前面认证过滤器没有对当前的请求进行处理，启用了RememberMe功能，会从cookie中解析出用户，并进行认证处理，之后在SecurityContextHolder中存入一个Authentication对象.

- AnonymousAuthenticationFilter

	- 匿名认证处理过滤器，当SecurityContextHolder中认证信息为空,则会创建一个匿名用户存入到SecurityContextHolder中

- SessionManagementFilter

	- 会话管理Filter，持久化用户登录信息，可以保存到session中，也可以保存到cookie或者redis中

- ExceptionTranslationFilter

	- 异常过滤器，主要拦截后续过滤器（FilterSecurityInterceptor）操作中抛出的异常.

- FilterSecurityInterceptor

	- 安全拦截过滤器类，获取当前请求url对应的ConfigAttribute，并调用accessDecisionManager进行访问授权决策.

- SwitchUserFilter

### 查看顺序：

- FilterComparator 

## 认证

### 常见认证流程

- 用户用账密码登录
- 校验密码正确性
- 获取用户信息context，如权限

### 认证注意问题

### 默认代码流程

- 通常通过AbstractAuthenticationProcessingFilter过滤器将账号密码组装成Authentication实现类UsernamePasswordAuthenticationToken
- 将token传递给AuthenticationManager验证是否有效，而AuthenticationManager通常使用ProviderManager实现类来检验
- AuthenticationManager认证成功后将返回一个拥有详细信息的Authentication object（包括权限信息，身份信息，细节信息，但密码通常会被移除
- 通过SecurityContextHolder.getContext().getAuthentication().getPrincipal()将Authentication设置到security context中

### 实战开发

- 账户名密码验证

	- 内存

		- 方式1

			- configure(AuthenticationManagerBuilder auth)
			- auth.inMemoryAuthentication()

		- 方式2

			- 重写userDetailsService方法

## 记住我

### 一般没配置的话，用户关闭浏览器再访问某个接口需要重新登录

### 原理

- 配置了HttpSecurity.rememberMe()
- 登录成功多了一个参数remember-me：on；访问其他接口，cookie多了remember-me：.....

	- remember-me

		- 用户名
		- 过期时间戳
		- username + ":" + tokenExpiryTime + ":" + password + ":" + key

			- key防治令牌被修改

### remember-me 生成和解析过程

### 携带着 cookie 中的 remember-me 到服务端，服务到拿到值之后，可以方便的计算出用户名和过期时间，再根据用户名查询到用户密码，然后通过 MD5 散列函数计算出散列值，再将计算出的散列值和浏览器传递来的散列值进行对比，就能确认这个令牌是否有效。

## 授权

### 常见授权流程

- 为用户创建security context
- 访问权限控制，是否具有访问权限

### s实战开发

- 通过FilterSecurityInterceptor过滤器入口进入
- FilterSecurityInterceptor通过其继承的抽象类的AbstractSecurityInterceptor.beforeInvocation(Object object)方法进行访问授权

	- AuthenticationManager
	- AccessDecisionManager
	- SecurityMetadataSource

### 授权注意问题

- url 放行

	- 方式1

		- http.authorizeRequests()
		- .antMatchers("/admin/**").hasRole("admin")

	- Ant 风格的路径匹配符

		- **	匹配多层路径
		- *	匹配一层路径
		- ?	匹配任意单个字符

	- 匹配按顺序依次

		- 一旦匹配到了就不继续匹配

## 项目实战

### 开发步骤

- 创建RBAC权限模型的表
- 创建SpringSecurity的Configuration类，继承WebSecurityConfigurerAdapter

	- configure(AuthenticationManagerBuilder auth)

		- 默认调用UserDetailsService，所以手动实现这个接口，完成loadUserByUsername()方法的重写，数据库校验用户名密码

	- configure(HttpSecurity httpSecurity)

### RuoYi-Vue

- 基于 Spring Security 实现。
- 基于 RBAC 权限模型，并且支持动态的权限配置。
- 基于 Redis 服务，实现登陆用户的信息缓存。
- 前后端分离。同时前端采用 Vue ，相对来说后端会 Vue 的比 React 的多
- https://github.com/YunaiV/RuoYi-Vue

- 文章介绍

