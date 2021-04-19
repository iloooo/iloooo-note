# 映射配置文件*.hbm.xml

## 注意

### 持久化类和数据表之间的对应关系

### 每个Hibernate-mapping中可以同时定义多个类. 但更推荐为每个类都创建一个单独的映射文件

## hibernate-mapping

### 根元素

### 属性

- schema: 指定所映射的数据库schema的名称。若指定该属性, 则表明会自动添加该 schema 前缀
- catalog:指定所映射的数据库catalog的名称。  
- default-cascade(默认为 none): 设置hibernate默认的级联风格. 若配置 Java 属性, 集合映射时没有指定 cascade 属性, 则 Hibernate 将采用此处指定的级联风格.   
- default-access (默认为 property): 指定 Hibernate 的默认的属性访问策略。默认值为 property, 即使用 getter, setter 方法来访问属性. 若指定 access, 则 Hibernate 会忽略 getter/setter 方法, 而通过反射访问成员变量.
- default-lazy(默认为 true): 设置 Hibernat morning的延迟加载策略. 该属性的默认值为 true, 即启用延迟加载策略. 若配置 Java 属性映射, 集合映射时没有指定 lazy 属性, 则 Hibernate 将采用此处指定的延迟加载策略 
- auto-import (默认为 true): 指定是否可以在查询语言中使用非全限定的类名（仅限于本映射文件中的类）。 
- package (可选) 

	- 指定一个包前缀，如果在映射文档中没有指定全限定的类名， 就使用这个作为包名。

## class

### 用于指定类和表的映射

### 属性

- name

	- 指定该持久化类映射的持久化类的

		- 类名

- table

	- 指定该持久化类映射的表名, Hibernate 默认以持久化类的类名作为表名

- dynamic-insert

	- 若设置为 true, 表示当保存一个对象时, 会动态生成 insert 语句, insert 语句中仅包含所有取值不为 null 的字段. 默认值为 false

- dynamic-update

	- 若设置为 true, 表示当更新一个对象时, 会动态生成 update 语句, update 语句中仅包含所有取值需要更新的字段. 默认值为 false

- select-before-update

	- 设置 Hibernate 在更新某个持久化对象之前是否需要先执行一次查询. 默认值为 false

- batch-size:指定根据 OID 来抓取实例时每批抓取的实例数.
- lazy: 指定是否使用延迟加载.  
- mutable: 若设置为 true, 等价于所有的 <property> 元素的 update 属性为 false, 表示整个实例不能被更新. 默认为 true. 
- discriminator-value: 指定区分不同子类的值. 当使用 <subclass/> 元素来定义持久化类的继承关系时需要使用该属性

## id

### 设定持久化类的 OID 和表的主键的映射

### 对象标识符(OID) 

- 对象的 OID 和数据表的主键对应
- 通过标识符生成器来为主键赋值
- 推荐在数据表中使用代理主键, 即不具备业务含义的字段. 代理主键通常为整数类型, 因为整数类型比字符串类型要节省更多的数据库空间.
- Java 的基本数据类型和包装类型对应相同的 Hibernate 映射类型. 基本数据类型无法表达 null, 所以

	- OID 推荐使用包装类型

### <generator> 子元素用来设定标识符生成器

- class: 指定使用的标识符生成器全限定类名或其缩写名

	- increment

		- 由 Hibernate 以递增的方式为代理主键赋值。读取表中的主键的最大值, 而接下来向 NEWS 表中插入记录时, 就在 max(id) 的基础上递增, 增量为 1.
		- 适用范围

			- 不依赖于底层数据库系统
			- 单个 Hibernate 应用进程访问同一个数据库的场合, 在集群环境下不推荐使用它
			- OID 必须为 long, int 或 short 类型

	- native

		- 依据底层数据库对自动生成标识符的支持能力, 来选择使用 identity, sequence 或 hilo 标识符生成器. 

	- identity

		- 底层数据库来负责生成标识符
		- 要求底层数据库把主键定义为自动增长字段类型

	- sequence

		- 底层数据库提供的序列来生成标识符. 
		- <generator class="sequence">
    <param name="sequence">news_seq</param>
</generator>
		- news_seq是数据库中sequence的名称

	- hilo

		- high/low 算法*生成标识符, 它从数据库的特定表的字段中获取 high 值.
		- hilo 标识符生成器在生成标识符时, 需要读取并修改 HI_TABLE 表中的 NEXT_VALUE 值.

### 属性

- name

	- 标识持久化类 OID 的属性名  

- column

	- 设置标识属性所映射的数据表的列名(主键字段的名字). 

- unsaved-value

	- 若设定了该属性, Hibernate 会通过比较持久化类的 OID 值和该属性值来区分当前持久化类的对象是否为临时对象

- type

	- 指定 Hibernate 映射类型. Hibernate 映射类型是 Java 类型与 SQL 类型的桥梁. 如果没有为某个属性显式设定映射类型, Hibernate 会运用反射机制先识别出持久化类的特定属性的 Java 类型, 然后自动使用与之对应的默认的 Hibernate 映射类型

## property

### 指定类的属性和表的字段的映射

### 属性

- name

	- 指定该持久化类的属性的名字

- column

	- 指定与类的属性映射的表的字段名. 如果没有设置该属性, Hibernate 将直接使用类的属性名作为字段名. 

- type

	- 指定 Hibernate 映射类型. Hibernate 映射类型是 Java 类型与 SQL 类型的桥梁. 如果没有为某个属性显式设定映射类型, Hibernate 会运用反射机制先识别出持久化类的特定属性的 Java 类型, 然后自动使用与之对应的默认的 Hibernate 映射类型.
	- 必须显式指定 Hibernate 映射类型

		- 一个 Java 类型可能对应多个 Hibernate 映射类型

			- java.util.Date 
			- 映射类型可以是 date, time 或 timestamp
			- 必须根据对应的数据表的字段的 SQL 类型, 来确定 Hibernate 映射类型

				- 如果字段为 DATE 类型, 那么 Hibernate 映射类型为 date; 
				- 如果字段为 TIME 类型, 那么 Hibernate 映射类型为 time; 
				- 如果字段为 TIMESTATMP 类型, 那么 Hibernate 映射类型为 timestamp.

- not-null

	- 若该属性值为 true, 表明不允许为 null, 默认为 false

- access

	- 指定 Hibernate 的默认的属性访问策略。默认值为 property, 即使用 getter, setter 方法来访问属性. 若指定 field, 则 Hibernate 会忽略 getter/setter 方法, 而通过反射访问成员变量

- unique

	- 设置是否为该属性所映射的数据列添加唯一约束. 

- index

	- 指定一个字符串的索引名称. 当系统需要 Hibernate 自动建表时, 用于为该属性所映射的数据列创建索引, 从而加快该数据列的查询.

- length

	- 指定该属性所映射数据列的字段的长度

- scale

	- 指定该属性所映射数据列的小数位数, 对 double, float, decimal 等类型的数据列有效

- formula

	- 设置一个 SQL 表达式, Hibernate 将根据它来计算出派生属性的值. 
	- formula=“(sql)” 的英文括号不能少
	- Sql 表达式中的列名和表名都应该和数据库对应, 而不是和持久化对象的属性对应
	- 如果需要在 formula 属性中使用参数, 这直接使用 where cur.id=id 形式, 其中 id 就是参数, 和当前持久化对象的 id 属性对应的列的 id 值将作为参数传入
	- private String desc;
<property name="desc" 
	formula="(SELECT concat(author, ': ', title) 
		FROM NEWS n WHERE n.id = id)">
</property>

## component

### 映射组成关系（持久类中又注入其他类）

- private Pay pay;
Pay{private Worker worker;}
<component name="pay" class="Pay">
	<parent name="worker"/>
	<!-- 指定组成关系的组件的属性 -->
	<property name="monthlyPay" column="MONTHLY_PAY"></property>
	<property name="yearPay" column="YEAR_PAY"></property>
	<property name="vocationWithPay" column="VOCATION_WITH_PAY"></property>
</component>

### 属性

- class:设定组成关系属性的类型, 此处表明 pay 属性为 Pay 类型

### <parent> 元素指定组件属性所属的整体类

- name: 整体类在组件类中的属性名

## 映射关联关系

### 一对多 和多对一  关联关系

- 一个用户Customer能发出多个订单Order , 而一个订单只能属于一个客户. 从 Order 到 Customer 的关联是多对一关联; 而从 Customer 到 Order 是一对多关联

### 多对一

- many-to-one

	- <many-to-one name="customer" class="Customer" column="CUSTOMER_ID"></many-to-one>
	- name: 设定待映射的持久化类的属性的名字
	- column: 设定和持久化类的属性对应的表的外键
	- class：设定待映射的持久化类的属性的类型

### 一对多

- 集合映射

	- 在映文件中使用list、set、map节点来实现
	- private Set<Order> orders = new HashSet<>();
	- set

		- <set name="orders" table="ORDERS" 
	inverse="true" order-by="ORDER_NAME DESC">
		<!-- 执行多的表中的外键列的名字 -->
		<key column="CUSTOMER_ID"></key>
		<!-- 指定映射类型 -->
		<one-to-many class="Order"/>
</set>
		- 属性

			- table: set 中的元素对应的记录放在哪一个数据表中. 该值需要和多对一的多的那个表的名字一致
			- inverse: 指定由哪一方来维护关联关系. 通常设置为 true, 以指定由多的一端来维护关联关系
			- cascade 设定级联操作. 开发时不建议设定该属性. 建议使用手工的方式来处理
			- order-by 在查询时对集合中的元素进行排序,使用的是表的字段名, 而不是持久化类的属性名 

		- key

			- 设定与所关联的持久化类对应的表的外键

		- one-to-many

			- 设定集合属性中所关联的持久化类

### 一对一

- many-to-one 的方式来映射 1-1 关联关系

	- 增加unique=“true” 属性来表示为1-1关联

- one-to-one

	- 在对应的数据表中已经有外键了, 当前持久化类使用 one-to-one 进行映射
	- 使用 property-ref 属性指定使用被关联实体主键以外的字段作为关联字段
	- <one-to-one name="dept" 
    class="com.foreign.Department"
    property-ref="mgrName">
</one-to-one>

### 多对多

- n-n 的关联必须使用连接表
- 与 1-n 映射类似，必须为 set 集合元素添加 key 子元素，指定 CATEGORIES_ITEMS 表中参照 CATEGORIES 表的外键为 CATEGORIY_ID
- 与 1-n 关联映射不同的是，建立 n-n 关联时, 集合中的元素使用 many-to-many. many-to-many 子元素的 class 属性指定 items 集合中存放的是 Item 对象, column 属性指定  CATEGORIES_ITEMS 表中参照 ITEMS 表的外键为 ITEM_ID
- many-to-many

### 继承映射

- subclass

	- 将域模型中的每一个实体对象映射到一个独立的表中，也就是说不用在关系数据模型中考虑域模型中的继承关系和多态。

- joined-subclass

	- 对于继承关系中的子类使用同一个表，这就需要在数据库表中增加额外的区分子类类型的字段。 

- union-subclass

	- 域模型中的每个类映射到一个表，通过关系数据模型中的外键来描述表之间的继承关系。这也就相当于按照域模型的结构来建立数据库中的表，并通过外键来建立表之间的继承关系。

