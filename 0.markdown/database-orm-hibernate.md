# Hibernate

## 比较优势

### hibernate

- 非常优秀、成熟的 ORM 框架。
- 完成对象的持久化操作
- Hibernate 允许开发者采用面向对象的方式来操作关系数据库。
- 消除那些针对特定数据库厂商的 SQL 代码

### myBatis

- 相比 Hibernate 灵活高，运行速度快
- 开发速度慢，不支持纯粹的面向对象操作，需熟悉sql语 句，并且熟练使用sql语句优化功能 

## Hibernate 开发步骤

### 1. 创建 Hibernate 配置文件

### 2. 创建持久化类

### 3. 创建对象-关系映射文件

### 4. 通过 Hibernate API 编写访问数据库的代码

- //1.加载主配置文件
Configuration cfg = new Configuration();
cfg.configure();
//hibernate4新增 任何配置和服务都需要在该对象中注册后才能有效.
ServiceRegistry serviceRegistry = 
		new ServiceRegistryBuilder().applySettings(configuration.getProperties())
		                            .buildServiceRegistry();
//2.构建SessionFactory
SessionFactory factory = cfg.buildSessionFactory(serviceRegistry );
/3.使用SessionFactory生产一个Session
Session session = factory.openSession();//打开一个新的Session
//4.开启事务
Transaction tx = session.beginTransaction();
//5.保存客户
session.save(c);//根据映射配置文件，生成SQL语句，实现保存。
//6.提交事务
tx.commit();
//7.释放资源
session.close();
factory.close();											

## Hibernate 执行过程

### 加载配置并初始化： Configuration对象

- 加载解析配置文件hibernate.cfg.xml
- Configuration cfg = new Configuration().configure();
- File file = new File(“simpleit.xml”);
Configuration cfg = new Configuration().configure(file);

### hibernate4新增配置和服务注册：ServiceRegistry对象

- ServiceRegistry serviceRegistry = 
		new ServiceRegistryBuilder().applySettings(configuration.getProperties())
		                          .buildServiceRegistry();

### 生成Session的工厂：SessionFactory接口

- 线程安全
- 一旦构造完毕，即被赋予特定的配置信息
- 构造 SessionFactory 很消耗资源，一般情况下一个应用中只初始化一个 SessionFactory 对象
- SessionFactory factory = cfg.buildSessionFactory(serviceRegistry );
- hibernate4之前：SessionFactory factory = cfg.buildSessionFactory( );

### 运作的中心单线程对象：Session接口

- Session session = factory.openSession();//打开一个新的Session
- 方法

	- 取得持久化对象的方法： get() load()
	- 持久化对象都得保存，更新和删除：save(),update(),saveOrUpdate(),delete()
	- 开启事务: beginTransaction().
	- 管理Session的方法：isOpen(),flush(), clear(), evict(), close()等

### org.hibernate.Transaction

- commit():提交相关联的session实例
- rollback():撤销事务操作
- wasCommitted():检查事务是否提交

## 核心配置文件hibernate.cfg.xml

### 两种格式

- hibernate.properties
- hibernate.cfg.xml 

### 每个 Hibernate 配置文件对应一个 Configuration 对象

### 官方配置提示

- hibernate-release-5.1.5.Final\project\etc\hibernate.properties

	- hibernate.cfg.xml

- hibernate-release-5.1.5.Final\project\etc\hibernate.cfg.xml

	- hibernate.properties

### 根元素：<session-factory name="foo">

### 映射配置文件的位置

- <mapping resource="org/hibernate/test/legacy/Simple.hbm.xml"/>

### 缓存策略配置

- <class-cache class="org.hibernate.test.legacy.Simple" region="Simple" usage="read-write"/>

### 常用properties

- JDBC连接

	- <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
	- <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/test</property>
	- <property name="hibernate.connection.username">root</property>
	- <property name="hibernate.connection.password">root</property>
	- <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>

- 连接池

	- 引入驱动包：hibernate-release-5.1.5.Final\lib\optional\c3p0\*.jar
	- hibernate.connection.provider_class：org.hibernate.connection.C3P0ConnectionProvider  配置连接池驱动类
	- hibernate.c3p0.max_size: 数据库连接池的最大连接数
	- hibernate.c3p0.min_size: 数据库连接池的最小连接数
	- hibernate.c3p0.timeout: 池中连接对象超时销毁时间
	- hibernate.c3p0.max_statements:  Statement对象的数量
	- hibernate.c3p0.idle_test_period: 多长时间检测一次池内的所有链接对象是否超时. 

	  连接池本身不会把自己从连接池中移除，而是专门有一个线程按照一定的时间间隔来做这件事，这个线程通过比较连接对象最后一次被使用时间和当前时间的时间差来和 timeout 做对比，进而决定是否销毁这个连接对象。

	- hibernate.c3p0.acquire_increment: 连接耗尽时同一时刻获取多少个数据库连接

- hibernate.show_sql：是否将运行期生成的SQL输出到日志以供调试。取值 true | false 
- hibernate.format_sql：是否将 SQL 转化为格式良好的 SQL . 取值 true | false
- hibernate.hbm2ddl.auto：在启动和停止时自动地创建，更新或删除数据库模式。取值 create | update | create-drop | validate
- hibernate.jdbc.fetch_size：读取数据的时候每次从数据库中取出的记录条数

  –例如一次查询1万条记录，对于Oracle的JDBC驱动来说，是不会 1 次性把1万条取出来的，而只会取出 fetchSize 条数，当结果集遍历完了这些记录以后，再去数据库取 fetchSize 条数据。因此大大节省了无谓的内存消耗。Fetch Size设的越大，读数据库的次数越少，速度越快；Fetch Size越小，读数据库的次数越多，速度越慢。Oracle数据库的JDBC驱动默认的Fetch Size = 10，是一个保守的设定，根据测试，当Fetch Size=50时，性能会提升1倍之多，当 fetchSize=100，性能还能继续提升20%，Fetch Size继续增大，性能提升的就不显著了。并不是所有的数据库都支持Fetch Size特性，例如MySQL就不支持

- hibernate.jdbc.batch_size：批量删除，批量更新和批量插入的时候的批次大小

  •设定对数据库进行批量删除，批量更新和批量插入的时候的批次大小，类似于设置缓冲区大小的意思。batchSize 越大，批量操作时向数据库发送sql的次数越少，速度就越快。
  –测试结果是当Batch Size=0的时候，使用Hibernate对Oracle数据库删除1万条记录需要25秒，Batch Size = 50的时候，删除仅仅需要5秒！Oracle数据库 batchSize=30 的时候比较合适。

## 映射配置文件*.hbm.xml

## Hibernate 缓存

### 持久化对象状态

•Session 具有一级缓存, 位于缓存中的对象称为持久化对象, 它和数据库中的相关记录对应. Session 能够在某些时间点, 按照缓存中对象的变化来执行相关的 SQL 语句, 来同步更新数据库, 这一过程被称为刷新缓存(flush)

- 临时状态（Transient）

  在数据库中没有对应的记录

- 持久化状态（托管Persist）

  在同一个 Session 实例的缓存中, 数据库表中的每条记录只对应唯一的持久化对象

	- 位于 Session 缓存中
	- OID 不为 null

- 游离状态（脱管Detached）

	- OID 不为 null

- 删除状态(Removed)

### 对象的状态转换

- 临时状态  -->  持久化状态

	- session.save(POJO) 

		- 执行 INSERT 操作使一个临时对象变为持久化对象
		- 在 save 方法之前的 id 是无效的
		- 持久化对象的 ID 是不能被修改的

	- session.persist(POJO) 

		- 也会执行 INSERT 操作
		- 和save()的区别

		  在调用 persist 方法之前, 若对象已经有 id 了, 则不会执行 INSERT, 而抛出异常

	- session.get(class,ID)

	  News news = (News) session.get(News.class, 1);

	- session.load(class,ID)

	  News news = (News) session.load(News.class, 1);

-  持久化状态 --> 游离状态

	- session.close()
	- session.clear()：清理缓存
	- session.evict(POJO)：从session缓存中把指定的持久化对象移除

	  News news1 = (News) session.get(News.class, 94);
	  News news2 = (News) session.get(News.class, 96);	
	  news1.setTitle("AA");
	  news2.setTitle("BB");	
	  session.evict(news1); 
	  //只更新BB

-  持久化状态 <-- 游离状态

	- session.update(POJO)

		- 更新持久化对象:不需要显示的调用update方法

		  因为在调用 Transaction的 commit() 方法时, 会先执行 session 的 flush 方法.
		  News news = (News) session.get(News.class, 1);
		  news.setId(100);

		- 更新游离对象:需要显式的调用

		  News news = (News) session.get(News.class, 94);
		  transaction.commit();
		  session.close();	
		  session = sessionFactory.openSession();
		  transaction = session.beginTransaction();
		  
		  news.setAuthor("SUN");		
		  session.update(news);

		- 注意

			- 1. 无论要更新的游离对象和数据表的记录是否一致, 都会发送 UPDATE 语句
			- 1.无论要更新的游离对象和数据表的记录是否一致, 都会发送 UPDATE 语句. 
			- 2.可以在xx.hbm.xml的class节点设置select-before-update=true(默认为 false)来防止更新不一致. 
			- 3.若数据表中没有对应的记录, 但还调用了 update 方法, 会抛出异常
			- 4.Session缓存中不能有两个 OID 相同的对象

			  News news = (News) session.get(News.class, 94);
			  
			  transaction.commit();
			  session.close();
			  session = sessionFactory.openSession();
			  transaction = session.beginTransaction();
			  
			  news.setAuthor("xxxx");
			  News news2 = (News) session.get(News.class, 94);
			  session.update(news);

	- session.saveOrUpdate(POJO)

		- update或者insert：取决是否给定OID

		  若 OID 不为 null, 但数据表中还没有和其对应的记录. 会抛出一个异常.
		  News news = new News("FFF", "fff", new Date());
		  news.setId(11);//11没有对应值
		  session.saveOrUpdate(news); 
		  //抛异常

	- session.merge()

-  持久化状态 --> 删除态

	- session.delete(POJO)

		- 只要 OID 和数据表中一条记录对应, 就会准备执行 delete 操作
		- 若 OID 在数据表中没有对应的记录, 则抛出异常

### 一级缓存（Session缓存）

- 它是属于事务范围的缓存。由 hibernate 管理
- API

	- session.flush()

		- 使数据表中的记录和 Session 缓存中的对象的状态保持一致. 为了保持一致, 则可能会发送对应的 SQL 语句，并没有提交事务

	- session.refresh(POJO)

		- 会强制发送 SELECT 语句, 以使 Session 缓存中对象的状态和数据表中对应的记录保持一致

	- session.clear()：清理缓存

- 刷新缓存情况

	- 显式调用 Session 的 flush() 方法
	- 调用 Transaction 的 commit（）方法的时, 该方法先 flush，再commit
	- 执行一些查询(HQL, Criteria)操作，如果缓存中持久化对象的属性已经发生了变化，会先 flush 缓存，以保证查询结果能够反映持久化对象的最新状态

### 二级缓存（SessionFactory缓存）

- 属于进程范围的缓存
- 内置缓存

	- Hibernate 自带的, 不可卸载
	- 通常在 Hibernate 的初始化阶段, Hibernate 会把映射元数据和预定义的 SQL 语句放到 SessionFactory 的缓存中, 映射元数据是映射文件中数据（.hbm.xml 文件中的数据）的复制. 该内置缓存是只读的. 

- 外置缓存(二级缓存)

	- 一个可配置的缓存插件
	- 在默认情况下, SessionFactory 不会启用这个缓存插件. 外置缓存中的数据是数据库数据的复制, 外置缓存的物理介质可以是内存或硬盘
	- 适合放入二级缓存中的数据

		- 很少被修改
		- 不是很重要的数据, 允许出现偶尔的并发问题

	- 不适合放入二级缓存中的数据

		- 经常被修改
		- 财务数据, 绝对不允许出现并发问题
		- 与其他应用程序共享的数据

## Hibernate 事务

### Transaction 的 commit() 方法中: 先调用 session 的 flush 方法, 再提交事务

### 设置隔离级别：
hibernate.connection.isolation 

- 1.read uncommitted （读未提交数据）

	- MySQL

- 2.read committed （读已提交数据）可以避免脏读

	- Oracle（默认）
	- MySQL

- 4.repeatable read（可重复读）可以避免脏读、不可重复读和一部分幻读

	- MySQL（默认）

- 8.serializable（串行化）可以避免脏读、不可重复读和幻读

	- Oracle
	- MySQL

## Hibernate 检索策略、方式

## Hibernate 调用存储过程

## 

## 用操作对象的思想去思考问题

## 数据库事务

