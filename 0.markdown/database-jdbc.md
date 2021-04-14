# JDBC

(Java Database Connectivity)

## 加载驱动

### 驱动：父接口java.sql.Driver

所有 JDBC 驱动程序需要实现的接口

- Oracle

	- oracle.jdbc.driver.OracleDriver
	- jar:ojdbc8-12.2.0.1.jar对应数据库版本
	- maven/官网下载地址

	  https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
	  Maven
	  之前想要在maven中使用Oracle JDBC Drive需要在官网下载驱动然后手工添加到maven仓库中
	       <dependency>
	       <groupId>com.oracle.ojdbc</groupId>
	       <artifactId>ojdbc10</artifactId>
	       <version>19.3.0.0</version>
	     </dependency>
	    
	  https://repo1.maven.org/maven2/com/oracle/ojdbc/
	  https://repo1.maven.org/maven2/com/oracle/ojdbc/ojdbc8/19.3.0.0/
	   
	       <dependency>
	       <groupId>com.oracle.database.jdbc</groupId>
	       <artifactId>ojdbc8</artifactId>
	       <version>12.2.0.1</version>
	     </dependency>
	    
	  https://repo1.maven.org/maven2/com/oracle/database/jdbc/
	  https://repo1.maven.org/maven2/com/oracle/database/jdbc/ojdbc8/12.2.0.1/

- MySQL

	- com.mysql.jdbc.Driver
	- jar:mysql-connector-java-x.x.xx.jar对应数据库版本
	- maven/官网下载地址

	  https://mirrors.tuna.tsinghua.edu.cn/mysql/downloads/Connector-J/
	  
	  https://repo1.maven.org/maven2/mysql/mysql-connector-java/
	  
	  <dependency>
	   <groupId>mysql</groupId>
	   <artifactId>mysql-connector-java</artifactId>
	   <version>x.x.x</version>
	  </dependency>

### 驱动URL

- MySQL

	- jdbc:mysql://[hostname][:port]/dbname[?param1=value1]&[?param2=value2]...

	  jdbc:mysql://localhost:3306/d_user?useUnicode=true&characterEncoding=utf8

	- param参数

		- 

- Oracle

	- jdbc:oracle:thin:@host:port:SID 

	  例如: jdbc:oracle:thin:@localhost:1521:orcl 
	  sqlplus / as sysdba 
	  select value from v$parameter where name='instance_name';

	- jdbc:oracle:thin:@//host:port/service_name 

	  例如: jdbc:oracle:thin:@//localhost:1521/orcl.city.com 
	  注意这里的格式，@后面有//, port后面:换成了/
	  sqlplus / as sysdba 
	  select value from v$parameter where name='service_names';

	- jdbc:oracle:thin:@TNSName 

	  例如:  jdbc:oracle:thin:@TNS_ALIAS_NAME 
	  
	  jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.16.91)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=orcl)))

- SQLServer

	- jdbc:sqlserver://主机名称:sqlserver服务端口号:DatabaseName=数据库名称

	  jdbc:sqlserver://localhost:1433:DatabaseName=d_usr

### 方式：

- 驱动配置：jdbc.properties

  user=root
  password=root
  url=jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true
  driverClass=com.mysql.jdbc.Driver

	- 加载properties,获取JDBC驱动配置

	  InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
	  Properties pros = new Properties();
	  pros.load(is);
	  String user = pros.getProperty("user");
	  String password = pros.getProperty("password");
	  String url = pros.getProperty("url");
	  String driverClass = pros.getProperty("driverClass");

- 加载驱动

  Class.forName(driverClass);
  或者
  Class.forName("com.mysql.jdbc.Driver");

## 获取数据库连接

### java.sql.Connection connection= java.sql.DriverManager.getConnection(url, user, password);

## 数据库连接池（数据源DataSource）

### 池中放入一定量的数据库连接，用完放回

### 常用

- C3P0（hibernate）
- DBCP 
- alibaba druid

## SQL操作和结果集

### 获取PreparedStatement实例 ps = connection.prepareStatement(sql)

### 执行：

- 查：ps.executeQuery();
- 增、删、改：ps.setObject();  ps.execute();

### 得到“查”的结果集：ResultSet

ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
              g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsDel(rs.getInt("isdel"));
        }

## JDBC 事务处理

### setAutoCommit(false); 取消自动提交事务

### commit(); 提交事务

### rollback(); 回滚事务

## 持久层 ORM框架

## 

## 

