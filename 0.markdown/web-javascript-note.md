# JavaScript

## 基础语法

### 1, 引入方式 : 

- 1. 内部JS：定义<script>，标签体内容就是js代码

	- 定义的位置会影响执行顺序

- 2. 外部JS：定义<script>，通过src属性引入外部的js文件

	- <scriptype="text/javscript" src="1.js"></script>

### 2, 注释

- 1. 单行注释：//注释内容
2. 多行注释：/*注释内容*/

### 3, 数据类型

- 原始数据类型(基本数据类型)：
	1. number：数字类型 . 整数/小数/NaN(not a number 一个不是数字的数字类型)
	2. string：字符串.  字符串  "abc" "a" 'abc'
	3. boolean: true和false
	4. null：一个对象为空的占位符
	5. undefined：未定义。如果一个变量没有给初始化值，则会被默认赋值为undefined
- 引用数据类型：对象(对象类型默认值是null)

### 4, 变量

- 变量：一小块存储数据的内存空间
- Java语言是强类型语言，而JavaScript是弱类型语言。
	强类型：在开辟变量存储空间时，定义了空间将来存储的数据的数据类型。只能存储固定类型的数据
	弱类型：在开辟变量存储空间时，不定义空间将来的存储数据类型，可以存放任意类型的数据。
- 语法：var 变量名 = 初始化值;
- typeof运算符：获取变量的类型。
注：null运算后得到的是object

### 5, 运算符

- 1. 一元运算符：只有一个运算数的运算符
	++，-- ， +(正号)
注意：在JS中，如果运算数不是运算符所要求的类型，那么js引擎会自动的将运算数进行类型转换
其他类型转number：
	string转number：按照字面值转换。如果字面值不是数字，则转为NaN（不是数字的数字）
	boolean转number：true转为1，false转为0
- 算数运算符: + - * / % ...
- 赋值运算符: = += -+....
- 比较(关系)运算符:  > < >= <= == ===(全等于)
比较方式 : 
	1. 类型相同：直接比较
		字符串：按照字典顺序比较。按位逐一比较，直到得出大小为止。
	2. 类型不同：先进行类型转换，再比较
		===：全等于。在比较之前，先判断类型，如果类型不一样，则直接返回false
- 逻辑运算符 : &&   ||    !
其他类型转boolean：
	1. number：0或NaN为假，其他为真
	2. string：除了空字符串("")，其他都是true
	3. null&undefined:都是false
	4. 对象：所有对象都为true
- 三元运算符 :
格式 ：表达式? 值1:值2;    执行流程 : 判断表达式的值，如果是true则取值1，如果是false则取值2；

### 6, 流程控制语句 :

- 1. if...else...
2. switch:在java中，switch语句可以接受的数据类型： byte int shor char,枚举(1.5) ,String(1.7)
	在JS中,switch语句可以接受任意的原始数据类型
3. while
4. do...while
5. for

### 7, JS一些注意事项

- 1. 语句以;结尾，如果一行只有一条语句则 ;可以省略 (不建议)
2. 变量的定义使用var关键字，也可以不使用
	用： 定义的变量是局部变量
	不用：定义的变量是全局变量(不建议)

## JavaScript 事件

### 功能 :  某些组件被执行了某些操作后，触发某些代码的执行。

### 绑定事件

- 静态注册事件

	- 1. 直接在html标签上，指定事件的属性(操作)，属性值就是js代码

		- <scrip type="text/javscript">
// onload 事件的方法
function onloadFun() {
        alert('静态注册 onload 事件，所有代码');
}
</script>

<!--静态注册 onload 事件
onload事件是浏览器解析完页面之后就会自动触发的事件 -->
<body onload="onloadFun();">

</body>

- 动态注册事件

	- 2. 通过js获取元素对象，指定事件属性，设置一个函数

		- <scrip type="text/javscript">

// onload 事件动态注册。是固定写法
window.onload = function () {
	alert("动态注册的 onload 事件");
}
</script>

### 常用操作事件

- onclick: 点击事件
- onfocus:获得焦点时触发该事件
- onblur:失去焦点触发该事件
- onload : 页面加载事件
- ondblclick: 双击某个元素的事件

### 表单操作事件

- onsubmit : 表单提交的时候触发 必须有返回的boolean类型值
- onreset : 重置按钮被点击。

### 键盘操作事件:

- onkeydown : 某个键盘的键被按下
- onkeyup : 某个键盘的键被松开
- onkeypress : 某个键盘的键被按下和抬起或按住

### 鼠标操作事件：

- onmousemove : 鼠标被移动
- onmouseout ;鼠标从某元素移开
- onmouseover : 鼠标被移到某元素之上
- onmousedown : 某个鼠标按键被按下
- onmouseup : 某个鼠标按键被松开

### 选择和改变

- onchange : 下拉列表改变事件
- onselect : 文本被选中。

## JavaScript的内置对象

### 1. Function：函数(方法)对象

- 创建 

	- function 方法名称(形式参数列表){
	方法体
}
------------------------------------------
var 方法名 = function(形式参数列表){
	方法体
}

- 属性

	- 属性： length:代表形参的个数

- 特点

	- 1. 方法定义时，形参的类型不写,返回值类型也不写。
2. 方法是一个对象，如果定义名称相同的方法，会覆盖
3. 在JS中，方法的调用只与方法的名称有关，和参数列表无关
4. 在方法声明中有一个隐藏的内置对象（数组），arguments,封装所有的实际参数

- 调用

	- 方法名称(实际参数列表);

### 2. Array:数组对象

- 创建

	- 1. var arr = new Array(元素列表);
2. var arr = new Array(默认长度);
3. var arr = [元素列表];

- 方法

	- join(参数):将数组中的元素按照指定的分隔符拼接为字符串
push()	向数组的末尾添加一个或更多元素，并返回新的长度。

- 属性

	- length:数组的长度

- 特点 

	- 1. JS中，数组元素的类型可变的。
2. JS中，数组长度可变的。

### 3. Boolean

### 4. Date：日期对象

- 创建

	- var date = new Date();

- 方法

	- toLocaleString()：返回当前date对象对应的时间本地字符串格式
getTime():获取毫秒值。返回当前如期对象描述的时间到1970年1月1日零点的毫秒值差

### 5. Math：数学对象

- 创建：

	- 特点：Math对象不用创建，直接使用。  Math.方法名()

- 方法：

	- random():返回 0 ~ 1 之间的随机数。 含0不含1
ceil(x)：对数向上取整
floor(x)：对数向下取整
round(x)：把数四舍五入为最接近的整数。

- 属性：

	- PI -->  3.1415圆周率

### 6. Number

### 7. String

### 8. RegExp：正则表达式对象
正则表达式：定义字符串的组成规则。

- 1. 单个字符:[]
	如： [a] [ab] [a-zA-Z0-9_]
	* 特殊符号代表特殊含义的单个字符:
		\d:单个数字字符 [0-9]
		\w:单个单词字符[a-zA-Z0-9_]
2. 量词符号：
	?：表示出现0次或1次
	*：表示出现0次或多次
	+：出现1次或多次
	{m,n}:表示 m<= 数量 <= n
		* m如果缺省： {,n}:最多n次
		* n如果缺省：{m,} 最少m次
3. 开始结束符号
	* ^:开始
	* $:结束
- 正则对象：
1. 创建
	(1)var reg = new RegExp("正则表达式");
	(2)var reg = /正则表达式/;
2. 方法	
	test(参数):验证指定的字符串是否符合正则定义的规范	

### 9. Global

- 特点：

	- 全局对象，这个Global中封装的方法不需要对象就可以直接调用。  方法名();

- 方法：

	- encodeURI():url编码
decodeURI():url解码

encodeURIComponent():url编码,编码的字符更多
decodeURIComponent():url解码

parseInt():将字符串转为数字
	逐一判断每一个字符是否是数字，直到不是数字为止，将前边数字部分转为number
isNaN():判断一个值是否是NaN
	NaN六亲不认，连自己都不认。NaN参与的==比较全部问false
eval():讲 JavaScript 字符串，并把它作为脚本代码来执行。

- URL编码

## BOM(浏览器对象模型)

### Window : 窗口对象

- 注意:window属于bom最顶层对象,里面方法可以直接使用,不需要加window
- 弹出框相关的方法

	- alert() : 弹出警告框
	- confirm();弹出一个确认窗口
	如果用户点击确定按钮，则方法返回true
	如果用户点击取消按钮，则方法返回false
	- prompt();弹出一个可输入的对话框
	返回值：获取用户输入的值

- 打开关闭相关方法

	- open() : 打开一个新窗口 ,返回新的Window对象
	- close()	关闭浏览器窗口,谁调用我 ，我关谁

- 定时器相关的方法

	- setTimeout(  ..., ...)  : 隔多少毫秒执行该表达式(执行一次)
参数：
	1. js代码或者方法对象
	2. 毫秒值
返回值：唯一标识，用于取消定时器

举例 : setTimeout(“change()”,5000);

clearTimeout()	取消由 setTimeout() 方法设置的 timeout。
	- setInterval() : 每隔多少毫秒执行某个表达式

例如 : setInterval(“change()”,5000);

clearInterval()	取消由 setInterval() 设置的 timeout。

- window属性：

	- 1. 获取其他BOM对象：
	history
	location
	Navigator
	Screen:
2. 获取DOM对象
	document

### Navigator ：浏览器对象

### Screen : 显示器屏幕对象

### History : 历史记录对象

- 1. 创建(获取)：
	window.history
	history
- 2. 方法：
	back()	加载 history 列表中的前一个 URL。
	forward()	加载 history 列表中的下一个 URL。
	go(参数)	加载 history 列表中的某个具体页面。
		参数：正数：前进几个历史记录 ,  负数：后退几个历史记录
- 3. 属性：
	length	返回当前窗口历史列表中的 URL 数量。

### Location : 地址栏对象

- 1. 创建(获取)：
	window.location
	location
- 2. 方法：
	reload()	重新加载当前文档。刷新
- 3. 属性
	href	设置或返回完整的 URL。

## DOM(对象)

### 什么是DOM : 文档对象模型

- 将一个HTML的文档加载到内存形成一个树形结构,
从而操作树形结构就可以改变HTML的样子
- 作用：控制html文档的内容
- 通常开发步骤 : 
	1，JS通常都由一个事件触发
	2，触发一个函数
	3，获得操作对象的控制权
	4，修改要操作的对象的属性或值

### DOM的常用的方法

- 注意: 元素指的就是标签对象
- 获得元素

	- document.getElementById();	        -- 通过元素ID获得元素对象
	- document.getElementsByName();	-- 通过name属性获得元素
	- document.getElementsByTagName();	-- 通过标签名获得元素

- 创建元素

	- document.createElement();		-- 创建元素
	- document.createTextNode();		-- 创建文本

- 添加节点

	- element.appendChild();			-- 在最后添加一个节点
	- element.insertBefore();			-- 在某个元素之前插入

- 删除节点

	- element.removeChild();			-- 删除元素

### Document：文档对象

- 创建：1. window.document , 2. document
- 方法

	- 获取Element对象 : 

		- 1. getElementById() : 根据id属性值获取元素对象。id属性值一般唯一
		- 2. getElementsByTagName() ：根据元素名称获取元素对象们。返回值是一个数组
		- 3. getElementsByClassName() : 根据Class属性值获取元素对象们。返回值是一个数组
		- 4. getElementsByName() : 根据name属性值获取元素对象们。返回值是一个数组

	- 创建其他DOM对象 :

		- createAttribute(name)
createComment()
createElement()
createTextNode()

### Element：元素对象

- 创建 ：通过document来获取和创建
- 方法 : 

	- 1. removeAttribute()：删除属性
	- 2. setAttribute()：设置属性

### Node：节点对象

- 特点：所有dom对象都可以被认为是一个节点
- 方法：

	- appendChild()：向节点的子节点列表的结尾添加新的子节点。
	- removeChild()	：删除（并返回）当前节点的指定子节点。
	- replaceChild()：用新节点替换一个子节点。

- 属性：

	- parentNode 返回节点的父节点。

