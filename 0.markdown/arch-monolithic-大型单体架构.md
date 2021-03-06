# 大型单体架构 Monolithic

## 分析

### 大家都会进行分层

### 将软件拆分为各种模块，以便重用和管理代码

### 负载均衡器之后同时部署若干个相同的单体系统副本，以达到分摊流量压力的效果

### 规模小是优势，规模大是劣势

- 类比大公司和小公司拆分

## 缺陷

### 拆分之后的隔离与自治能力上的欠缺

### 所有代码都运行在同一个进程空间之内，任何一部分代码出现了缺陷，过度消耗了进程空间内的资源，所造成的影响也是全局性的、难以隔离的。

- 譬如内存泄漏、线程爆炸、阻塞、死循环等问题，都将会影响整个程序，而不仅仅是影响某一个功能、模块本身的正常运作。
- 如果消耗的是某些更高层次的公共资源，譬如端口号或者数据库连接池泄漏，影响还将会波及整台机器，甚至是集群中其他单体副本的正常工作。

### 不利于维护

- 程序升级、修改缺陷往往需要制定专门的停机更新计划，做灰度发布、A/B测试也相对更复杂。

