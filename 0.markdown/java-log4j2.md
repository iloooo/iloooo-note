# log4j2

## 配置

### 配置文件

- XML
- JSON
- YAML
- properties 

### configuration 

- 属性

	- advertiser
	- dest
	- monitorInterval
	- name
	- packages
	- schema
	- shutdownHook
	- shutdownTimeout
	- status：log事件级别

		- ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF
		- 打印高于或等于所设置级别的日志

	- strict
	- verbose

- Properties

	- 自定义一些常量，之后使用${变量名}引用
	- <Properties>
        <Property name="logFilePath">log</Property>
        <Property name="logFileName">test.log</Property>
    </Properties>

- appenders

	- 定义输出内容,输出格式,输出方式,日志保存策略等,常用其下三种标签[console,File,RollingFile]
	- Console

		- 控制台输出的配置
		- PatternLayout

			- 输出日志的格式,LOG4J2定义了输出代码,详见第二部分
			- <PatternLayout pattern="[%d{HH:mm:ss:SSS}] [%p] - %l - %m%n"/>

	- File
	- RollingFile

		- 属性

			- <RollingFile name="RollingFileInfo" 
	fileName="${sys:user.home}/logs/info.log"
    filePattern="${sys:user.home}/logs/$${date:yyyy-MM}/info-%d{yyyy-MM-dd}-%i.log">

		- ThresholdFilter 

			- 日志输出过滤
			- <!--level="info" :日志级别,onMatch="ACCEPT" :级别在info之上则接受,onMismatch="DENY" :级别在info之下则拒绝-->
			- <ThresholdFilter level="info" onMatch="ACCEPT" onMismatch="DENY"/>

		- PatternLayout 

			- <PatternLayout pattern="[%d{HH:mm:ss:SSS}] [%p] - %l - %m%n"/>

		- Policies

			- 日志滚动策略
			- <!-- TimeBasedTriggeringPolicy :时间滚动策略,默认0点小时产生新的文件,interval="6" : 自定义文件滚动时间间隔,每隔6小时产生新文件, modulate="true" : 产生文件是否以0点偏移时间,即6点,12点,18点,0点-->
			- <TimeBasedTriggeringPolicy interval="6" modulate="true"/>
			-  <!-- SizeBasedTriggeringPolicy :文件大小滚动策略-->
			-  <SizeBasedTriggeringPolicy size="100 MB"/>

	- DefaultRolloverStrategy

		- <!-- DefaultRolloverStrategy属性如不设置，则默认为最多同一文件夹下7个文件，这里设置了20 -->
		- <DefaultRolloverStrategy max="20"/>

- loggers

	- 只有定义了logger并引入的appender，appender才会生效
	- logger 

		- Logger节点用来单独指定日志的形式，name为包路径,比如要为org.springframework包下所有日志指定为INFO级别等
		- <logger name="org.springframework" level="INFO"></logger>
		- <logger name="org.mybatis" level="INFO"></logger>

	- root 

		- Root节点用来指定项目的根日志，如果没有单独指定Logger，那么就会默认使用该Root日志输出
		- <root level="all">
    <appender-ref ref="Console"/>
    <appender-ref ref="RollingFileInfo"/>
    <appender-ref ref="RollingFileWarn"/>
    <appender-ref ref="RollingFileError"/>
</root>

	- AsyncLogger 

		- 异步日志,LOG4J有三种日志模式,全异步日志,混合模式,同步日志,性能从高到底,线程越多效率越高,也可以避免日志卡死线程情况发生
		- additivity="false" : additivity设置事件是否在root logger输出，为了避免重复输出，可以在Logger 标签下设置additivity为”false”
		- <AsyncLogger name="AsyncLogger" level="trace" includeLocation="true" additivity="false">
    <appender-ref ref="RollingFileError"/>
</AsyncLogger>

