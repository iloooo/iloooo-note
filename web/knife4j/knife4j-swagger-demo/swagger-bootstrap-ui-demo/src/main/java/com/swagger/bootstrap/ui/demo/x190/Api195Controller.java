/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.x190;

import com.alibaba.fastjson.JSONObject;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp192.Order;
import com.swagger.bootstrap.ui.demo.domain.resp194.OrderDate;
import com.swagger.bootstrap.ui.demo.domain.resp195.RestResponse;
import com.swagger.bootstrap.ui.demo.domain.resp195.UptModel;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/07/28 17:43
 */
@Api(tags = "1.9.5版本-20190728",position = 290)
/*@ApiSort(290)*/
@RestController
@RequestMapping("/api/new195")
public class Api195Controller {


    @ApiOperation(value = "请求头未显示")
    @GetMapping("/header")
    @ApiResponses(
            @ApiResponse(code = 200,message = "ok",response = Order.class,responseHeaders = {
                    @ResponseHeader(name = "x-page",description = "页码",response = Long.class),
                    @ResponseHeader(name = "x-total",description = "总数",response = Long.class),
                    @ResponseHeader(name = "x-per-page",description = "大小",response = Long.class)
            })
    )
    @ApiImplicitParams({
            @ApiImplicitParam(value = "日期",dataTypeClass = Date.class,name = "date",required = true),
            @ApiImplicitParam(value = "名称",name = "name",required = true)
    })
    @ApiOperationSupport(order = 1)
    public Rest<String> headerShow(@RequestParam(value = "name") String name, @RequestParam(value = "date") Date date){
        Rest<String> r=new Rest<>();

        r.setData(name);
        return r;

    }

    @ApiOperation(value = "请求头未显示1")
    @GetMapping("/heade1")
    @ApiResponses(
            {@ApiResponse(code = 200,message = "ok",response = Order.class,responseHeaders = {
                    @ResponseHeader(name = "x-page",description = "页码",response = Long.class),
                    @ResponseHeader(name = "x-total",description = "总数",response = Long.class),
                    @ResponseHeader(name = "x-per-page",description = "大小",response = Long.class)
            }),
            @ApiResponse(code = 400,message = "400",response = Order.class,responseHeaders = {
                    @ResponseHeader(name = "x-page1",description = "页码1",response = Long.class),
                    @ResponseHeader(name = "x-total1",description = "总数1",response = Long.class),
                    @ResponseHeader(name = "x-per-page1",description = "大1",response = Long.class)
            })}
    )
    @ApiOperationSupport(order = 2)
    public Rest<String> headerSho1w(@RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();

        r.setData(name);
        return r;

    }

    @ApiOperation(value = "请求带date类型")
    @GetMapping("/orderdate")
    public Rest<OrderDate> orderDateRest(OrderDate orderDate){
        Rest<OrderDate> r=new Rest<>();
        r.setData(orderDate);
        return r;
    }
    @ApiOperation(value = "请求带date类型-POST")
    @PostMapping("/orderdate1")
    public Rest<OrderDate> orderDateRest1(OrderDate orderDate){
        Rest<OrderDate> r=new Rest<>();
        r.setData(orderDate);
        return r;
    }

    @ApiOperation(value = "DELETE请求类型传参错误")
    @DeleteMapping("/delArr")
    public Rest<String> delArr(@RequestHeader(value = "token")String token,@RequestHeader(value = "pvesion")String pvesion,
                               Integer[] ids){
        Rest<String> r=new Rest<>();

        r.setData(token);
        return r;
    }

    @ApiOperation(value = "GET请求支持RequestBody",notes = "ui依赖的发送组件jQuery,axios均不支持get请求发送body,况且该类请求在各个规范里面也不尽相同,有些会过滤掉GET请求body内容,因此暂不支持此功能,请使用POST或者PUT")
    @ApiOperationSupport(
            params = @DynamicParameters(properties = {
                    @DynamicParameter(value = "编号",name = "id"),
                    @DynamicParameter(value = "名称",name = "name")
            })
    )
    @GetMapping("/getBody")
    public Rest<Map<String,String>> getBody(@RequestBody Map<String,String> map){
        Rest<Map<String,String>> r=new Rest<>();
        r.setData(map);
        return r;
    }

    @ApiOperation(value = "解决地址显示的BUG, 确保请求能够正确发送出去")
    @RequestMapping(method = RequestMethod.POST,value = "/cwx",params = "action=crawl")
    public Rest<String> crawl(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        Rest<String> r=new Rest<>();
        r.setData(start.toString());
        return r;
    }

    @ApiOperation(value = "List集合泛型解析错误")
    @GetMapping("/restResponse")
    public RestResponse<OrderDate> restResponse(){
        List<OrderDate> list=new ArrayList<>();
        list.add(new OrderDate("name1","date1"));
        RestResponse<OrderDate> r=new RestResponse<>();
        r.setData(list);
        return r;
    }

    @ApiImplicitParam(name = "token",value = "校验Token",paramType = "header")
    @PostMapping("/createOrder426")
    @ApiOperation(value = "jdk-HashMap-动态创建显示参数-无@RequestBody")
    @DynamicParameters(name = "CreateOrderHashMapModel",properties = {
            @DynamicParameter(name = "",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name3",value = "订单编号-gson"),
            @DynamicParameter(name = "name1",value = "订单编号1-gson"),
    })
    public Rest<HashMap> createOrder1235332(HttpServletRequest request, @RequestBody HashMap map){
        String token=request.getHeader("token");
        System.out.println("token:"+token);
        Rest<HashMap> r=new Rest<>();
        r.setData(map);
        return r;
    }

    @ApiOperation(value = "返回基础类型")
    @GetMapping("/basicType")
    public Object basicType(){
        int rod=new Random().nextInt(100);
        if (rod>30){
            return 2;
        }else{
            return false;
        }
    }


    @ApiOperation(value = "新增Model接口")
    @ApiOperationSupport(ignoreParameters = {"uptModel.id","uptModel.name","uptModel.orderDate.id"})
    @PostMapping("/insertModel")
    public Rest<UptModel> insertModel(@RequestBody UptModel uptModel){
        Rest<UptModel> r =new Rest<>();
        r.setData(uptModel);
        return r;
    }
    @ApiOperation(value = "新增Model接口1")
    @ApiOperationSupport(ignoreParameters = {"id","orderDate.id"})
    @PostMapping("/insertMode1l")
    public Rest<UptModel> insertModel1(UptModel uptModel){
        Rest<UptModel> r =new Rest<>();
        r.setData(uptModel);
        return r;
    }
    @ApiOperation(value = "修改Model接口")
    @PostMapping("/updateModel")
    public Rest<UptModel> updateModel(@RequestBody UptModel uptModel){
        Rest<UptModel> r =new Rest<>();
        r.setData(uptModel);
        return r;
    }


    @ApiOperationSupport(
            responses = @DynamicResponseParameters(properties = {
                    @DynamicParameter(value = "编号",name = "id"),
                    @DynamicParameter(value = "名称",name = "name"),
                    @DynamicParameter(value = "订单",name = "orderDate",dataTypeClass = OrderDate.class)
            })
    )
    @ApiOperation(value = "响应JSONObject类型")
    @GetMapping("/jsonObject")
    public JSONObject jsonObjectxxxx(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","xx");
        return jsonObject;
    }

    @ApiOperationSupport(params = @DynamicParameters(name = "CreateOrderModel3",properties = {
            @DynamicParameter(name = "id3",value = "注解id3",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name3",value = "订单编号3",required = false),
            @DynamicParameter(name = "sub3",value = "包含子类3",dataTypeClass = OrderDate.class),
    })
            ,responses = @DynamicResponseParameters(properties = {
            @DynamicParameter(value = "编号99",name = "id3"),
            @DynamicParameter(value = "名称99",name = "name3"),
            @DynamicParameter(value = "订单99",name = "deptName")
    })
    )
    @ApiOperation(value = "响应JSONObject类型-String")
    @PostMapping("/jsonObjectString")
    public String jsonObjectxxxxString(@RequestBody Map map){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","xx");
        return jsonObject.toJSONString();
    }

    @ApiOperationSupport(
            responses = @DynamicResponseParameters(properties = {
                    @DynamicParameter(value = "编号",name = "id"),
                    @DynamicParameter(value = "名称",name = "name"),
                    @DynamicParameter(value = "订单",name = "orderDate",dataTypeClass = OrderDate.class)
            })
    )
    @ApiOperation(value = "泛型包装类是JSONObject")
    @GetMapping("/generic")
    public Rest<JSONObject> genericDynamicResponse(){
        Rest<JSONObject> rest=new Rest<>();

        return rest;
    }

    @ApiOperationSupport(
            responses = @DynamicResponseParameters(properties = {
                    @DynamicParameter(value = "编号",name = "id"),
                    @DynamicParameter(value = "名称",name = "name"),
                    @DynamicParameter(value = "订单",name = "orderDate",dataTypeClass = OrderDate.class)
            })
    )
    @ApiOperation(value = "泛型包装类是JSONObject1")
    @GetMapping("/generic1")
    public Rest<JSONObject> genericDynamicResponseX(){
        Rest<JSONObject> rest=new Rest<>();

        return rest;
    }
}
