# JDK 8

## 新特性

## 升级引来的问题

### 依赖组件的兼容性问题

- Jackson版本
- 数据库驱动
- server版本

	- weblogic升级，编译器不再是javac，导致jsp limit
	- 不使用include标签，使用jsp:include标签引入拆分的jsp

### JVM配置问题

- PermSize不再使用
- Metaspace
- 方法区替换成了元空间，存储到系统内存里

### sun.* 包缺失

- 更改原有依赖

