# 微服务Microservices

## 概念

### 服务围绕业务能力而非特定的技术标准来构建

### 各个服务可以采用不同的编程语言，不同的数据存储技术，运行在不同的进程之中

### 服务采取轻量级的通信机制和自动化的部署机制实现通信与运维。

### SOA发展时催生的产物

## 核心特征

### 围绕业务能力构建

### 分散治理

### 通过服务来实现独立自治的组件

- 类库在编译期静态链接到程序中，通过本地调用来提供功能，而服务是进程外组件，通过远程调用来提供功能

### 产品化思维

- 关心整个产品的全部方面是具有可行性的

### 数据去中心化

- 数据应该按领域分散管理、更新、维护、存储

### 强终端弱管道

- 反对SOAP和ESB的那一堆复杂的通信机制
- RESTful风格的通信在微服务中会是更加合适的选择

### 容错性设计

- 有自动的机制对其依赖的服务能够进行快速故障检测
- 在持续出错的时候进行隔离
- 在服务恢复的时候重新联通

### 演进式设计

- 承认服务会被报废淘汰
- 服务是多么的优秀、多么的重要，反而是一种系统设计上脆弱的表现，微服务所追求的独立、自治，也是反对这种脆弱性的表现

### 基础设施自动化

- 减少了构建、发布、运维工作的复杂性

## 后微服务时代-云原生Docker/Kubernetes

### 虚拟化技术和容器化技术

### 当虚拟化的基础设施从单个服务的容器扩展至由多个容器构成的服务集群、通信网络和存储设施时，软件与硬件的界限便已经模糊。一旦虚拟化的硬件能够跟上软件的灵活性，那些与业务无关的技术性问题便有可能从软件层面剥离，悄无声息地解决于硬件基础设施之内，让软件得以只专注业务，真正“围绕业务能力构建”团队与产品。

## 传统Spring Cloud与Kubernetes提供的解决方案对比

### 弹性伸缩

- Kubernetes

	- Autoscaling

### 配置中心

- Kubernetes

	- ConfigMap / Secret		

- Spring Cloud

	- Spring Cloud Config

### 服务发现

- Kubernetes

	- KubeDNS / CoreDNS		

- Spring Cloud

	- Spring Cloud Eureka

### 服务网关

- Kubernetes

	- Ingress Controller		

- Spring Cloud

	- Spring Cloud Zuul

### 负载均衡

- Kubernetes

	- Load Balancer			

- Spring Cloud

	- Spring Cloud Ribbon

### 服务安全

- Kubernetes

	- RBAC API				

- Spring Cloud

	- Spring Cloud Security

### 跟踪监控

- Kubernetes

	- Metrics API / Dashboard

- Spring Cloud

	- Spring Cloud Turbine

### 降级熔断

- Spring Cloud

	- Spring Cloud Hystrix

## 服务发现：注册中心

### 对消费者来说，外部的服务由谁提供？具体在什么网络位置？

## 网关路由

### 对生产者来说，内部哪些服务需要暴露？哪些应当隐藏？应当以何种形式暴露服务？以什么规则在集群中分配请求？

## 负载均衡

### 对调用过程来说，如何保证每个的远程服务都接收到相对平均的流量，获得尽可能高的服务质量与可靠性？

