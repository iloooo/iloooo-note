# SOAP和RESTful的实现对比总结

## JAX-WS-SOAP

### 服务端

- 定义服务接口@Webservice声明此类
- 定义实现类
- 发布服务

### 发布的服务

- WSDL查看和check请求数据

### 客户端

- 定义相同接口@Webservice声明此类
- 调用服务的实现类

	- 具体方法

- 调用服务后获得返回

## JAX-RS-Restful

### 服务端

- 定义结果实体类@XmlRootElement(name = "Car")
- 服务配置接口service
- 服务接口的实现ServiceImpl
- 定义实现类

### 发布的服务

### 客户端

- 定义相同结果实体类@XmlRootElement(name = "Car")
- 调用服务的实现类

	- 具体方法

- 调用服务后获得返回

	- XML
	- JSON

## Apache CXF 实现

## Bak web service

## 服务的主要业务

## SOAP的服务接口前后端要一致，客户端类似注入服务这个接口，调用远端的实现类

## RESTful不用定义服务接口，不同URI对应访问服务接口实现的不同方法

## RESTful因为不用写服务接口，它必须要有结果实体类来接收服务

