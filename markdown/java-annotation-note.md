# Annotation注解

## 定义注解

### 元注解:修饰定义注解

- @Retention：生命周期
- @Target：使用范围
- @Documented：javadoc包含注解
- @Inherited：继承性（较少用）

### 定义属性（实例变量）：可以有default值

## 使用注解

### 注意注解生命周期：@Retention

### 注意注解能在何处使用：@Target

- FIELD：静态非静态的成员变量、(枚举)常量
- TYPE：类
- CONSTRUCTOR：构造方法
- METHOD：方法
- LOCAL_VARIABLE：局部变量
- PARAMETER：形参
- 代码块和静态代码块、构造方法调用普通方法、实参等没有elementType，不可以使用注解
-  field不包含parameter、local_variable，method不包含constructor

### 注意注解的参数，使用时显式赋值或者使用default值

## 解析注解：反射（注解完成特殊操作的核心）

### 必须是@Retention为RUNTIME的才可以代码运行时通过反射解析

### 获取使用注解的对象的class，根据注解target和使用在哪里，获取class相应method、field等等

### isAnnotationPresent(Class<? extends Annotation> annotationClass)方法判断该元素上是否配置有某个指定的注解

### getAnnotation(Class<A>annotationClass)方法获取该元素上指定的注解。

### 通过该注解类获取注解定义的元素和方法

