

## 介绍

smart-doc是一款同时支持 **JAVA REST API**和 **Apache Dubbo RPC**接口文档生成的工具，smart-doc在业内率先提出 **基于JAVA泛型定义推导**的理念， 完全基于接口源码来分析生成接口文档，**不采用任何注解侵入到业务代码中**。你只需要按照 **java-doc标准编写注释**， smart-doc就能帮你生成一个简易明了的**Markdown**、HTML5、**Postman** Collection2.0+、OpenAPI 3.0+的文档。

https://gitee.com/smart-doc-team
https://gitee.com/smart-doc-team/smart-doc#introduce



## 功能

https://gitee.com/smart-doc-team/smart-doc#features

- 只需要写标准JAVA注释

- 对JSON请求参数的接口能够自动生成模拟JSON参数
- 支持导出错误码和定义在代码中的各种字典码到接口文档。
- 支持Maven、Gradle插件式轻松集成。



## Get Start

### 引入Maven 插件

https://gitee.com/smart-doc-team/smart-doc#add-plugin

https://gitee.com/smart-doc-team/smart-doc/wikis/smart-doc%20maven%E6%8F%92%E4%BB%B6?sort_id=1791450

[maven中央仓库版本](https://repo1.maven.org/maven2/com/github/shalousun/smart-doc-maven-plugin/)

Demo:

```xml
<plugin>
    <groupId>com.github.shalousun</groupId>
    <artifactId>smart-doc-maven-plugin</artifactId>
    <version>[最新版本 2.2.6]</version>
    <configuration>
        <!--指定生成文档的使用的配置文件,配置文件放在自己的项目中-->
        <configFile>./src/main/resources/smart-doc.json</configFile>
        <!--指定项目名称-->
        <projectName>测试</projectName>
    </configuration>
    <executions>
        <execution>
            <!--如果不需要在执行编译时启动smart-doc，则将phase注释掉-->
            <phase>compile</phase>
            <goals>
                <!--smart-doc提供了html、openapi、markdown等goal，可按需配置-->
                <goal>markdown</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

### 根据maven plugin中自定义设置的路径创建 smart-doc.json

https://gitee.com/smart-doc-team/smart-doc#configuration

最小配置单位：

```json
{
   "outPath": "D://md2" //指定文档的输出路径,相对路径时请用./开头，eg:./src/main/resources/static/doc
}
```

创建好smart-doc.json后，直接在IDE maven中执行mvn compile时即在指定目录生成文档。

执行`Plugins` / `smart-doc` / ` smart-doc:postman`即可在同目录获得postman.json，可以直接导入此json到postman中（smart-doc会自动填写一些示例数据，通过@mock注释可以指定示例数据数值）

[生成文档效图](https://gitee.com/smart-doc-team/smart-doc/wikis/%E6%96%87%E6%A1%A3%E6%95%88%E6%9E%9C%E5%9B%BE?sort_id=1652819)



## 其他配置

### smart-doc自定义注释tag

https://gitee.com/smart-doc-team/smart-doc/wikis/%E8%87%AA%E5%AE%9A%E4%B9%89tag%E4%BD%BF%E7%94%A8?sort_id=1652869

Bean Validation JSR303 外自定义的tag

> JSR-303 是JAVA EE 6 中的一项子规范，叫做Java Bean Validation，**Hibernate Validator** 是 Bean Validation 的参考实现， Hibernate Validator 提供了 JSR 303 规范中所有内置 constraint 的实现，除此之外还有一些附加的 constraint，大致来说就是对Java Bean 对象做参数校验的，Validator 中定义了大量校验参数的注解，为我们日常开发提供了便利，摈弃了传统的方式中业务代码中的串行校验
>
> &#x1f449; https://blog.csdn.net/weixin_43295079/article/details/100653977

| 注释tag       | 描述                                                         |
| ------------- | ------------------------------------------------------------ |
| @ignore       | 过滤请求参数对象上的某个字段，加到controller上进行忽略不想生成文档的接口类。用于方法上忽略某个请求参数。 |
| @required     | 标注请求参数对象的字段，输出参数列表时会设置为true。         |
| @mock         | 用于在对象基本类型字段设置自定义文档展示值，不再帮你生成随机值 |
| @dubbo        | 扫描Spring Cloud Feign的定义接口生成文档                     |
| @order        |                                                              |
| @ignoreParams | 标注在controller方法上忽略掉不想显示在文档中的参数，多个参数名用空格隔开 |
| @tag          | 可以将不同contoller下的方法指定到多个分类下, 同时也可以直接指定controller为一个分类或多个分类 |

### 响应字段忽略

https://gitee.com/smart-doc-team/smart-doc/wikis/%E5%93%8D%E5%BA%94%E5%AD%97%E6%AE%B5%E5%BF%BD%E7%95%A5?sort_id=1823812

### 导出数据字典

https://gitee.com/smart-doc-team/smart-doc/wikis/%E5%AF%BC%E5%87%BA%E6%95%B0%E6%8D%AE%E5%AD%97%E5%85%B8?sort_id=1713399

### swagger ui集成

https://gitee.com/smart-doc-team/smart-doc/wikis/swagger%20ui%E9%9B%86%E6%88%90?sort_id=3157367



## 不规范的返回定义和正确示范（规范学习）

https://gitee.com/smart-doc-team/smart-doc/wikis/%E4%BD%BF%E7%94%A8smart-doc%E7%9A%84%E4%BB%A3%E7%A0%81%E6%9C%80%E4%BD%B3%E5%AE%9E%E8%B7%B5?sort_id=1812571



## 原理

### 外部源码加载

https://gitee.com/smart-doc-team/smart-doc/wikis/%E9%85%8D%E7%BD%AE%E6%BA%90%E7%A0%81%E5%8A%A0%E8%BD%BD?sort_id=1653111