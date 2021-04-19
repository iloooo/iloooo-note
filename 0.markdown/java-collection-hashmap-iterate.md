# HashMap 遍历

## 迭代器（Iterator）

### EntrySet 

- 

### KeySet 

- 

## For Each

### EntrySet 

- 

### KeySet 

- 

## Lambda 表达式（JDK 1.8+）

### 

## Streams API（JDK 1.8+）

### 单线程

- 

### 多线程

- 
- 执行结果：4 MyBatis framework 5 Java中文社群 1 Java 2 JDK 3 Spring Framework

## 遍历时删除数据的安全性

### 迭代器中循环删除数据安全

- 

### For 循环中删除数据非安全

- 
- 

### Lambda 循环中删除数据非安全

- 
- 

### Lambda 删除的正确方式

- 

### Stream 循环中删除数据非安全

- 
- 

### Stream 循环删除的正确方式

- 

## 性能分析

### 

### 性能最好：EntrySet

### Stream API单线程

### KeySet性能是EntrySet的一半，不推荐

### KeySet 在循环时使用了 map.get(key)，而 map.get(key) 相当于又遍历了一遍 Map 集合去查询 key 所对应的值。为什么要用“又”这个词？那是因为在使用迭代器或者 for 循环时，其实已经遍历了一遍 Map 集合了，因此再使用 map.get(key) 查询时，相当于遍历了两遍。

### 性能最差：Lambda 

## 执行结果

### 执行结果：1 Java 2 JDK 3 Spring Framework 4 MyBatis framework 5 Java中文社群

## 创建并赋值 HashMap

### 

