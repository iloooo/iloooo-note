# Java设计模式

## 代理模式

### 理解

- 代理对象来代替对真实对象(real object)的访问
- 不修改原目标对象的前提下，提供额外的功能操作，扩展目标对象的功能

### 应用

- Spring AOC 动态代理

### 静态代理

- 对目标对象的每个方法的增强都是手动完成
- 缺点，导致应用极少

	- 非常不灵活

		- 比如接口一旦新增加方法，目标对象和代理对象都要进行修改

	- 麻烦

		- 需要对每个目标类都单独写一个代理类

- 实现步骤

	- 1. 定义一个接口及其实现类

		- public interface SmsService {
    String send(String message);}
public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;

	- 2. 创建一个代理类同样实现这个接口

		- public class SmsProxy implements SmsService {
    private final SmsService smsService;
    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }
    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}

	- 3. 将目标对象注入进代理类，然后在代理类的对应方法调用目标类中的对应方法。通过代理类屏蔽对目标对象的访问，并且可以在目标方法执行前后做一些自己想做的事情

		- public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");

### 动态代理

- JDK 动态代理机制
- CGLIB 动态代理机制

## 工厂模式

### 应用

- Spring IOC

## 单例模式

## 模板方法

