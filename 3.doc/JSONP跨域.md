## JSONP概念

JSONP(JSON with Padding)是[JSON](https://baike.baidu.com/item/JSON)的一种“使用模式”，可用于解决主流浏览器的跨域数据访问的问题。

## JSONP原理

目标页面回调本地页面的方法,并带入参数

### JSONP缺点：只能实现get一种请求。



## 使用JSONP需求

通常为了减轻web服务器的负载，我们把js、css，img等**静态资源**分离到另一台独立域名的服务器上，在html页面中再通过相应的标签从不同域名下加载静态资源，而被浏览器允许，基于此原理，我们可以通过动态创建script，再请求一个带参网址实现跨域通信。



## JSONP实现

### 1.）原生实现：

```html
 <script>
    var script = document.createElement('script');
    script.type = 'text/javascript';

    // 传参一个回调函数名给后端，方便后端返回时执行这个在前端定义的回调函数
    script.src = 'http://www.domain2.com:8080/login?user=admin&callback=handleCallback';
    document.head.appendChild(script);

    // 回调执行函数
    function handleCallback(res) {
        alert(JSON.stringify(res));
    }
 </script>
```

服务端返回如下（返回时即执行全局函数）：

```javascript
handleCallback({"status": true, "user": "admin"})
```

### 2.）jquery ajax：

```javascript
$.ajax({
    url: 'http://www.domain2.com:8080/login',
    type: 'get',
    dataType: 'jsonp',  // 请求方式为jsonp
    jsonpCallback: "handleCallback",    // 自定义回调函数名
    data: {}
});
```

### 3.）vue.js：

```javascript
this.$http.jsonp('http://www.domain2.com:8080/login', {
    params: {},
    jsonp: 'handleCallback'
}).then((res) => {
    console.log(res); 
})
```

后端node.js代码示例：

```javascript
var querystring = require('querystring');
var http = require('http');
var server = http.createServer();

server.on('request', function(req, res) {
    var params = qs.parse(req.url.split('?')[1]);
    var fn = params.callback;

    // jsonp返回设置
    res.writeHead(200, { 'Content-Type': 'text/javascript' });
    res.write(fn + '(' + JSON.stringify(params) + ')');

    res.end();
});

server.listen('8080');
console.log('Server is running at port 8080...');
```



> &#x1f449; [前端常见跨域解决方案（全）](https://segmentfault.com/a/1190000011145364)

