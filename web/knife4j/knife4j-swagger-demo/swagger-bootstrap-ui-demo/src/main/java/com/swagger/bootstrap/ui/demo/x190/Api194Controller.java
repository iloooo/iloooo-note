/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.x190;

import com.alibaba.fastjson.JSONObject;
import com.swagger.bootstrap.ui.demo.annotation.DynamicField;
import com.swagger.bootstrap.ui.demo.annotation.DynamicFields;
import com.swagger.bootstrap.ui.demo.common.ErrorCode;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp192.Order;
import com.swagger.bootstrap.ui.demo.domain.resp192.OrderStatus;
import com.swagger.bootstrap.ui.demo.domain.resp194.OrderList;
import com.swagger.bootstrap.ui.demo.domain.resp194.OrderXml;
import io.swagger.annotations.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXB;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 * 1.9.3fixed bug修改
 * @since:swagger-bootstrap-ui 1.9.4
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019-5-18 16:58:11
 */
@Api(tags = "1.9.4版本-20190518",position = 291)
@RestController
@RequestMapping(value = "/api/new194/")
public class Api194Controller {

    Logger logger= LoggerFactory.getLogger(Api194Controller.class);

    @PostMapping("/createOr33der")
    @ApiOperationSupport(author = "张三",order = 2,params = @DynamicParameters(name = "",properties = {
    }))
    public Rest<Order> createOrdetr(@RequestBody Order order,@ApiIgnore HttpSession httpSession){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }

    @PostMapping("/createOrder421")
    @ApiOperation(value = "fastjson-JSONObject-动态创建显示参数")
    @ApiOperationSupport(params = @DynamicParameters(name = "CreateOrderModel",properties = {
            @DynamicParameter(name = "id",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name",value = "订单编号",required = false)
    }))
    public Rest<JSONObject> createOrder12222(@RequestBody JSONObject jsonObject){
        Rest<JSONObject> r=new Rest<>();
        r.setData(jsonObject);
        return r;
    }

    @PostMapping("/createOrder422")
    @ApiOperation(value = "jdk-Map-动态创建显示参数")
    @ApiOperationSupport(params = @DynamicParameters(name = "CreateOrderMapModel",properties = {
            @DynamicParameter(name = "id",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name",value = "订单编号"),
            @DynamicParameter(name = "name1",value = "订单编号1"),
            @DynamicParameter(name = "orderInfo",value = "订单信息",dataTypeClass = Order.class),
    }))
    public Rest<Map> createOrder12232(@RequestBody Map map){
        Rest<Map> r=new Rest<>();
        r.setData(map);
        return r;
    }

    @PostMapping("/createOrder424")
    @ApiOperation(value = "jdk-HashMap-动态创建显示参数")
    @DynamicParameters(name = "CreateOrderHashMapModel",properties = {
            @DynamicParameter(name = "id",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name",value = "订单编号-gson"),
            @DynamicParameter(name = "name1",value = "订单编号1-gson"),
    })
    public Rest<HashMap> createOrder123532(@RequestBody HashMap map){
        Rest<HashMap> r=new Rest<>();
        r.setData(map);
        return r;
    }

    @ApiImplicitParam(name = "token",value = "校验Token",paramType = "header")
    @PostMapping("/createOrder426")
    @ApiOperation(value = "jdk-HashMap-动态创建显示参数-无@RequestBody")
    @DynamicParameters(name = "CreateOrderHashMapModel",properties = {
            @DynamicParameter(name = "id",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name3",value = "订单编号-gson"),
            @DynamicParameter(name = "name1",value = "订单编号1-gson"),
    })
    public Rest<HashMap> createOrder1235332(@RequestBody HashMap map){
        Rest<HashMap> r=new Rest<>();
        r.setData(map);
        return r;
    }

    @PostMapping("/createOr33derList")
    @ApiOperation(value = "响应枚举List类型",position = 2)
    public Rest<OrderList> createOrdetrList(@RequestBody OrderList order, HttpSession httpSession){
        Rest<OrderList> r=new Rest<>();
        r.setData(order);
        return r;
    }
    @PostMapping("/createOrderxw")
    @ApiOperation(value = "多个@RequestBody")
    public Rest<Order> createOrderMultipartRequestBody(@RequestBody Order order,@RequestBody OrderList orderList){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }
    @PostMapping("/createOrder")
    @ApiOperationSort(3)
    @ApiOperation(value = "hash测试",nickname = "test")
    public Rest<Order> createOrder(@RequestBody Order order){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }

    @DynamicFields({})
    @PostMapping("/createOrder12")
    @ApiOperation(value = "hash测试1",nickname = "test")
    public Rest<Order> createOrder1(@RequestBody Order order){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }


    @PostMapping("/createOrder112")
    @ApiOperation(value = "hash测试12",nickname = "te2st")
    @DynamicFields({
            @DynamicField(name = "id",value = "编号id")
    })
    public Rest<String> createOrder12(@RequestBody JSONObject jsonObject){
        Rest<String> r=new Rest<>();
        r.setData(jsonObject.toJSONString());
        return r;
    }

    @ApiOperation(value = "响应XML数据格式支持")
    @GetMapping(value = "/responseXml")
    public void responseXml(HttpServletRequest request, HttpServletResponse response){
        List<Order> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            Order order=new Order();
            order.setAmount(new BigDecimal(i));
            order.setErrorCode(ErrorCode.SUCCESS);
            order.setStatus(OrderStatus.UNSUBMIT);
            list.add(order);
        }
        response.addHeader("Content-Type","application/xml;charset=UTF-8");
        try {
            JAXB.marshal(new OrderXml(list),response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }

    }

    @ApiOperation(value = "响应HTML数据格式支持")
    @GetMapping(value = "/responseHtml")
    public void responseHTML(HttpServletRequest request, HttpServletResponse response){
        response.addHeader("Content-Type","text/html;charset=UTF-8");
        try {
            CloseableHttpClient client=HttpClients.createDefault();
            HttpGet get=new HttpGet("https://www.xiaominfo.com/2019/06/03/springfox-21/");
            get.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
            get.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            get.addHeader("Accept-Encoding","gzip, deflate, br");
            get.addHeader("Host","www.xiaominfo.com");
            get.addHeader("Referer","https://www.oschina.net/p/swagger-bootstrap-ui");
            CloseableHttpResponse response1=client.execute(get);
            if (response1!=null&&response1.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                HttpEntity entity=response1.getEntity();
                entity.writeTo(response.getOutputStream());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }

    @ApiOperation(value = "响应text数据格式支持",position = 3)
    @GetMapping(value = "/responseText")
    public void responseText(HttpServletRequest request, HttpServletResponse response){
        response.addHeader("Content-Type","text/plain;charset=UTF-8");
        try {
            response.getOutputStream().write("我是文本".getBytes("UTF-8"));
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }
}
