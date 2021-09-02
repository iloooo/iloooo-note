# java-collection

## List<interface>：有序、可重复

 

### ArrayList

- 底层：默认长度是10的Object[]

	- 动态数组elementData

		- JDK7类似单例的饿汉式，直接初始化10
		- JDK8类似单例的懒汉式，调用add时才延迟创建

- 线程：不安全
- 方法

	- add(E e)：O(1)   大于原数组长度时扩容：

		- 1.5倍

			- 扩容消耗性能，所以最好预设数组大小
			- 插入元素之前,它会先检査是否需要扩容
			- 把元素添加到数组中最后一个元素的后面

	- add(int index, E element)：O(n) 数组元素移动费时间
	- remove(int index)：O(n)数组元素移动费时间

		- 与add(int index, E element)类似

	- get(int index)：O(1)

		- 判断有没有越界
		- 接通过数组下标来获取元素

### LinkedList

- 底层：双向链表Node<E>内部类

	- 内部私有类Node

		- 

	- 双向链表的结构

		- 
		- 内部没有声明数组，而是定义了Node类型的first和last，用于记录首末元素
		- Node除了保存数据，还定义了两个变量：prev变量记录前一个元素的位置；next变量记录下一个元素的位置

- 线程：不安全
- 方法

	- add(E e)：O(1)

		- 添加元素的操作无非就是在表头/表尾插入元素，又或者在指定位置插入元素

	- add(int index, E element)：O(n) 遍历链表费时间
	- remove((int index))

		- 
		- 

	- get(int index) 遍历链表费时间

		- 
		- 

### Vector

- 除了线程安全（不使用它），其他和ArrayList大致相同

	- 很多方法都跟 ArrayList 一样，只是多加了个 synchronized 来保证线程安全罢了

### LinkedList方法在指定位置

- 插入和删除元素

	- 的效率较高

- 但是查找的效率就不如数组那么高

	- ArrayList擅长于随机访问

### List线程安全：工具类Collections的synchronizedList（List<T>list）方法

## Set<interface>：无序、不可重复

### HashSet

- 底层：

	- HashMap实例（value是虚拟值）

		- 

- 线程：不安全
- 使用注意：添加类 要重写equals和hashCode方法

### LinkedHashSet

- 底层：

	- LinkedHashMap实例

		- 

- 线程：不安全
- 使用注意：添加类 要重写equals和hashCode方法

### TreeSet

- 底层：

	- 红黑树，TreeMap实例

## Map<interface>：key（无序的、不可重复的）、value（无序的、可重复的）

### HashMap

- 底层：

	- Node数组+单向链表+红黑树（解决hash冲突）

		- JDK7数组+链表（长度是16的一维数组Entry[] table）
		- JDK8数组+链表+红黑树（首次调用put()方法时，底层创建长度为16的Node数组）
		- 

- 线程：不安全
- 使用注意：value类 要重写equals和hashCode方法
- 方法：

	- 重要常量

		- DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
		- DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
		- threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
		- TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
		- MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64

	- get

		- 1、通过 hash 值获取该 key 映射到的桶。
2、桶上的 key 就是要查找的 key，则直接命中。
3、桶上的 key 不是要查找的 key，则查看后续节点：
（1）如果后续节点是树节点，通过调用树的方法查找该 key。
（2）如果后续节点是链式节点，则通过循环遍历链查找该 key。

	- put

		- 1、先通过 hash 值计算出 key 映射到哪个桶。
2、如果桶上没有碰撞冲突，则直接插入。
3、如果出现碰撞冲突了，则需要处理冲突：
(链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，用红黑树)
（1）如果该桶使用红黑树处理冲突，则调用红黑树的方法插入。
（2）否则采用传统的链式方法插入。如果链的长度到达临界值，则把链转变为红黑树。
4、如果桶中存在重复的键，则为该键替换新值。
5、如果 size 大于阈值，则进行扩容。
		- 扩容条件：默认情况下，HashMap中键值对个数个数超过16*0.72=12，就会触发扩容2倍。

			- 

		- 数组扩容最消耗性能，所以最好

			- 预设元素个数

				- HashMap(int initialCapacity)指定容量，加载因子默认

					- 

				- HashMap(int initialCapacity, float loadFactor)指定容量和加载因子

	- remove
	- clear

		- 清空

- 遍历

### LinkedHashMap

- 底层：

	- Node数组+双向链表+红黑树（增加了before和after指针）

		- 
		- 
		- LinkedHashMap 在不对HashMap做任何改变的基础上，给HashMap的任意两个节点间加了两条连线(before指针和after指针)，使这些节点形成一个双向链表。

### LinkedHashMap较HashMap保证了遍历时，可以

- 按照添加顺序实现遍历

	- HashMap是无序的，也就是说，迭代HashMap所得到的元素顺序并不是它们最初放置到HashMap的顺序。HashMap的这一缺点往往会造成诸多不便，因为在有些场景中，我们确需要用到一个可以保持插入顺序的Map。
	- 该迭代顺序可以是插入顺序，也可以是访问顺序。因此，根据链表中元素的顺序可以将LinkedHashMap分为：保持插入顺序的LinkedHashMap 和 保持访问顺序的LinkedHashMap，其中LinkedHashMap的默认实现是按插入顺序排序的。

### java.util.concurrent.ConcurrentHashMap

### TreeMap

- 底层：红黑树（实现键值对排序）

	- 

- 自然排序：key实现Comparable接口
- 定制排序：创建TreeMap时传入一个Comparator对象

### Hashtable

- 原理和功能同HashMap，但是不允许null

### Properties

- key、value都是字符串类型

## 相互转换

### Array转List 

- String[] s = new String[]{"A", "B", "C", "D","E"};
- List<String> list = Arrays.asList(s);
- 注意这里list里面的元素直接是s里面的元素( list backed by the specified array)

	- 对s的修改，直接影响list

### List转Array

- String[] dest = list.toArray(new String[0]);//new String[0]是指定返回数组的类型
- System.out.println("dest: " + Arrays.toString(dest));
- 注意这里的dest里面的元素不是list里面的元素

	- 对list中关于元素的修改，不会影响dest。 

### List转Set

- Set<String> set = new HashSet<>(list);
- 或者：

	- Set<String> result = new HashSet<>();
	- result.addAll(list);

### Set转List

- List<String> list_1 = new ArrayList<>(set);
- 或者：

	- List<String> result= new ArrayList<>();
	- result.addAll(set);

