# java-lombok

## 概括

### https://projectlombok.org/

### version

- https://github.com/projectlombok/lombok/releases

- https://repo1.maven.org/maven2/org/projectlombok/lombok/

- 	<dependency>
	    <groupId>org.projectlombok</groupId>
	    <artifactId>lombok</artifactId>
	    <version>1.18.8</version>
</dependency>

## 注解和配置

### val

- 局部变量前面
- 相当于将变量声明为final，推断类型
- val example = new ArrayList<String>();

### var

- 除没有final其他val一样
- 1.16.20

### @NonNull

- FIELD,METHOD,PARAMETER,LOCAL_VARIABLE

	- 属性、方法、形参、局部变量

- 对该参数进行是否为空的校验，如果为空，则抛出NPE（NullPointerException）
- public NonNullExample(@NonNull Person person)
- if (person == null) {
      throw new NullPointerException("person is marked @NonNull but is null");
  }

### @Cleanup

- LOCAL_VARIABLE
- 自动生成try-finally这样的代码来关闭流
- @Cleanup InputStream in = new FileInputStream(args[0]);

### @Getter/@Setter

- FIELD、TYPE
- setter和getter方法，可以指定访问范围

### @ToString

- TYPE
- 自动重写toString方法

### @EqualsAndHashCode

- TYPE
- 自动生成equals方法和hashCode方法
- @EqualsAndHashCode.Exclude 排除参数

### Constructor

- @NoArgsConstructor

	- 自动生成无参构造

- @RequiredArgsConstructor

	- final / @NonNull field做参数的构造

- @AllArgsConstructor

	- 使用所有参数的构造函数

- staticName = “of ” 参数

	- 生成一个返回类对象的静态工厂方法
	- private ConstructorExample(T description) {
    this.description = description;
  }
	- public static <T> ConstructorExample<T> of(T description) {
    return new ConstructorExample<T>(description);
  }

### @Data

- POJO类
- @ToString+@EqualsAndHashCode+@Getter+@Setter+@RequiredArgsConstrutor

### @Value

- TYPE
- 是@Data的不可变形式
- all fields are made private and final by default, and setters are not generated

### @SneakyThrows

- METHOD,CONSTRUCTOR
- 自动抛异常，而无需显式在方法上使用throws语句

### @Synchronized

- METHOD
- private static final Object $LOCK = new Object[0];
    public static void hello() {
        synchronized ($LOCK) {
            System.out.println("world");
        }
    }
- 将方法声明为同步的，并自动加锁，而锁对象是一个私有的属性$lock或$LOCK，而java中的synchronized关键字锁对象是this，锁在this或者自己的类对象上存在副作用，就是你不能阻止非受控代码去锁this或者类对象，这可能会导致竞争条件或者其它线程错误

### @Log

- @CommonsLog

	- private static final org.apache.commons.logging.Log log 
	- = org.apache.commons.logging.LogFactory.getLog(LogExample.class)

- @Flogger

	- private static final com.google.common.flogger.FluentLogger log
	- = com.google.common.flogger.FluentLogger.forEnclosingClass();

- @JBossLog

	- private static final org.jboss.logging.Logger log 
	- = org.jboss.logging.Logger.getLogger(LogExample.class);

- @Log

	- private static final java.util.logging.Logger log
	- = java.util.logging.Logger.getLogger(LogExample.class.getName());

- @Log4j

	- private static final org.apache.log4j.Logger log
	- = org.apache.log4j.Logger.getLogger(LogExample.class);

- @Log4j2

	- private static final org.apache.logging.log4j.Logger log
	- = org.apache.logging.log4j.LogManager.getLogger(LogExample.class);

- @Slf4j

	- private static final org.slf4j.Logger log
	- = org.slf4j.LoggerFactory.getLogger(LogExample.class);

- @XSlf4j

	- private static final org.slf4j.ext.XLogger log
	- = org.slf4j.ext.XLoggerFactory.getXLogger(LogExample.class);

- @CustomLog

	- private static final com.foo.your.Logger log
	- = com.foo.your.LoggerFactory.createYourLogger(LogExample.class);

### @Getter(lazy=true)

- 替代经典的Double Check Lock样板代码
- FIELD,TYPE

### @Builder

-  v1.16.0升级到了主 lombok 
- TYPE,METHOD,CONSTRUCTOR
- 提供复杂的builder APIs

### @With

- v1.18.10中,@wither 被重新命名为@with，从实验中移出并进入核心包

### @Accessors(chain = true)

- 开启链式编程

	- Apple apple = new Apple();
	- apple.setColor("red").setFlag(true).setHeight(22.56);//链式

## 原理

### 传统反射：注解的生命周期@Retention为Runtime时，过反射来获取注解值

### JSR 269 Pluggable Annotation Processing API

- JDK6

### @Retention为SOURCE，Javac的编译期

