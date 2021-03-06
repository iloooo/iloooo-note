# web-security

## 权限管理模型

### RBAC权限模型

- 基于角色的权限访问控制

	- Role-Based Access Control

- 用户与角色关联

	- 角色与权限管理

		- 权限与资源关联

### ACL

- 访问控制列表，是用以控制对象的访问权限的
- 一个用户/角色可以具备某个对象的多种权限，某个对象的权限也可以被多个用户/角色所持有

### DAC

- 除了权限控制，主体也可以将权限授予其他主体

### MAC 

- 资源可以被哪些类别的主体进行哪些操作，主体可以对哪些等级的资源进行哪些操作，这两个条件同时满足时，允许访问

### ABAC

- 基于属性的访问控制

### PBAC 

- 基于策略的访问控制

## CSRF 跨站请求伪造

### one-click-attack 

### 挟制用户在当前已登录的 Web 应用程序上执行非本意的操作的攻击方法

### XSS利用的是用户对指定网站的信任

### CSRF利用的是网站对用户网页浏览器的信任

### 攻击者通过一些技术手段欺骗用户的浏览器去访问一个自己曾经认证过的网站并运行一些操作（如发邮件，发消息，甚至财产操作如转账和购买商品）由于浏览器曾经认证过，所以被访问的网站会认为是真正的用户操作而去运行。

### 利用了 web 中用户身份验证的一个漏洞：简单的身份验证只能保证请求发自某个用户的浏览器，却不能保证请求本身是用户自愿发出的

### Spring Security 4.0 开始，默认情况下会启用 CSRF 保护

## JWT

### 问题

- A用户关注了B用户的时候，系统发邮件给B用户，并且附有一个链接“点此关注A用户”

	- https://your.awesome-app.com/make-friend/?from_user=B&target_user=A

- 上述URL描述存在弊端：前要求用户一定先登录
- 需求：简化这个流程，让B用户不用登录
- 解决

	- 添加好友的操作描述成一个JSON对象，载荷

### 概念介绍

- JSON Web Token（JWT）规范
- 使用JWT在用户和服务器之间传递安全可靠的信息
- 头部

	- 描述关于该JWT的最基本的信息，例如其类型以及签名所用的算法，JSON对象进行Base64编码后得到的字符串

- 载荷（Payload）

	- 描述操作的JSON对象进行Base64编码后得到的字符串
	- iss: 该JWT的签发者
	- sub: 该JWT所面向的用户
	- aud: 接收该JWT的一方
	- exp(expires): 什么时候过期，这里是一个Unix时间戳
	- iat(issued at): 在什么时候签发的

- 签名

	- 头部 . 载荷 拼接后进行加密算法加密
	- 目的：

		- 加密算法对于不同的输入产生的输出总是不一样的
		- 服务器应用在接受到JWT后，会首先对头部和载荷的内容用同一算法再次签名，比对传过来的签名验证信息是否被篡改过

- 头部

	- .

		- 载荷

			- .

				- 签名

### 和Session方式存储id的差异

- Session方式最大弊病在于要占用大量服务器内存，于较大型应用而言可能还要保存许多的状态
- JWT方式将用户状态通过cookie分散到了每个客户端（浏览器）中，可以明显减轻服务端的内存压力。除id之外，还可以存储其他的和用户相关的信息，例如该用户是否是管理员、用户所在的分桶
- 虽说JWT方式让服务器有一些计算压力（例如加密、编码和解码），但是这些压力相比磁盘I/O而言或许是半斤八两

### 参考

- JSON Web Token - 在 Web 应用间安全地传递信息

- 八幅漫画理解使用 JSON Web Token 设计单点登录系统

- 前后端分离 SpringBoot + SpringSecurity + JWT + RBAC 实现用户无状态请求验证

### 登录使用JWT情况

- one-click-login(公司)

	- JWT

### 在线JWT解密头部和载荷

## CORS 跨域资源共享

### 判断是否跨域

- 三点有其一不满足就会造成跨域
- 协议相同

	- http->https

- 域名相同
- 端口相同

### 参考

- http://www.ruanyifeng.com/blog/2016/04/cors.html

