# 结果映射

## select子元素：resultType

### 列名匹配：幕后创建ResultMap

- <!-- In mybatis-config.xml file -->
<typeAlias type="com.someapp.model.User" alias="User"/>

<!-- In SQL Mapping XML file -->
<select id="selectUsers" resultType="User">
  select id, username, hashedPassword
  from some_table
  where id = #{id}
</select>
- 这些情况会在幕后自动创建一个 ResultMap,基于属性名来映射列到 JavaBean 的属性上。

### 列名不匹配

- 可以在列名上使用 select 字句的别名来匹配标签
- <select id="selectUsers" resultType="User">
  select
    user_id             as "id",
    user_name           as "userName",
    hashed_password     as "hashedPassword"
  from some_table
  where id = #{id}
</select>

## 高级结果映射：元素 resultMap

### 使用

- 定义顶级元素

	- <resultMap id="userResultMap" type="User">
  <id property="id" column="user_id" />
  <result property="username" column="user_name"/>
  <result property="password" column="hashed_password"/>
</resultMap>

- select子元素：resultMap

	- <select id="getDeptByIdPlus" resultMap="User">
		SELECT d.id ,d.user_name hashed_password
		FROM tbl_dept d
		WHERE d.id=#{id}
	</select>

### resultMap子元素

- id & result

	- 例子

		- <id property="id" column="post_id"/>
<result property="subject" column="post_subject"/>

	- 结果映射最基本内容.都映射一个单独列的值到简单数据类型(字符 串,整型,双精度浮点数,日期等)的单独属性或字段
	- 这两者之间的唯一不同是 id 表示的结果将是当比较对象实例时用到的标识属性

- 构造方法constructor

	- 例子

		- <constructor>
   <idArg column="id" javaType="int"/>
   <arg column="username" javaType="String"/>
   <arg column="age" javaType="_int"/>
</constructor>

	- 对应构造方法

		- public class User {
   //...
   public User(Integer id, String username, int age) {
     //...
  }
//...
}

- collection – 复杂类型的集

	- 集合元素的作用几乎和关联是相同的。
	- 要映射嵌套结果集合到 List 中,我们使用集合元素。就像关联元素一样,我们可以从 连接中使用嵌套查询,或者嵌套结果。

- discriminator – 使用结果值来决定使用哪个结果映射
- 关联association 

	- 例子

		- <association property="author" column="blog_author_id" javaType="Author">
  <id property="id" column="author_id"/>
  <result property="username" column="author_username"/>
</association>

	- 对应类型关系

		- public class User {
   //...
   private Author author;
//...
}
		- 一个博客有一个用户

	- 关联的嵌套查询

	  我们有两个查询语句:一个来加载博客,另外一个来加载作者,而且博客的结果映射描 述了“selectAuthor”语句应该被用来加载它的 author 属性。
	  
	  其他所有的属性将会被自动加载,假设它们的列和属性名相匹配。
	  
	  这种方式很简单, 但是对于大型数据集合和列表将不会表现很好。 问题就是我们熟知的 “N+1 查询问题”。概括地讲,N+1 查询问题可以是这样引起的:
	  
	  你执行了一个单独的 SQL 语句来获取结果列表(就是“+1”)。
	  对返回的每条记录,你执行了一个查询语句来为每个加载细节(就是“N”)。
	  这个问题会导致成百上千的 SQL 语句被执行。这通常不是期望的。
	  
	  MyBatis 能延迟加载这样的查询就是一个好处,因此你可以分散这些语句同时运行的消 耗。然而,如果你加载一个列表,之后迅速迭代来访问嵌套的数据,你会调用所有的延迟加 载,这样的行为可能是很糟糕的。

		- <resultMap id="blogResult" type="Blog">
  <association property="author" column="author_id" javaType="Author" select="selectAuthor"/>
</resultMap>

<select id="selectBlog" resultMap="blogResult">
  SELECT * FROM BLOG WHERE ID = #{id}
</select>

<select id="selectAuthor" resultType="Author">
  SELECT * FROM AUTHOR WHERE ID = #{id}
</select>
		- 两个查询语句:一个来加载博客,另外一个来加载作者

	- 关联的嵌套结果

		- <resultMap id="blogResult" type="Blog">
  <id property="id" column="blog_id" />
  <result property="title" column="blog_title"/>
  <association property="author" column="blog_author_id" javaType="Author" resultMap="authorResult"/>
</resultMap>

<resultMap id="authorResult" type="Author">
  <id property="id" column="author_id"/>
  <result property="username" column="author_username"/>
  <result property="password" column="author_password"/>
  <result property="email" column="author_email"/>
  <result property="bio" column="author_bio"/>
</resultMap>
		- 注意

			- id元素在嵌套结果映射中扮演着非 常重要的角色。你应该总是指定一个或多个可以唯一标识结果的属性。

