/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp189.ModelMoreField;
import com.swagger.bootstrap.ui.demo.domain.resp192.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/***
 * 1.9.1fixed bug修改
 * @since:swagger-bootstrap-ui 1.9.2
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019-3-17 13:31:53
 */
@Api(tags = "1.9.2版本-20190317",position = 293)
@RestController
@RequestMapping(value = "/api/new192/")
public class Api192Controller {

    Logger logger= LoggerFactory.getLogger(Api192Controller.class);
    @ApiOperation(value = "数组请求Integer2")
    @PostMapping("/arrReques-Integer2")
    public Rest<List<Integer>> arrRequestInteger2(Integer[] arr){
        Rest<List<Integer>> r=new Rest<List<Integer>>();
        r.setData(Arrays.asList(arr));
        return r;
    }

    @ApiOperation(value = "interger参数")
    @PostMapping("/aar")
    public Rest<Integer> rr(@RequestParam(value = "num") Integer num){
        Rest<Integer> a=new Rest<>();
        a.setData(num);

        return a;
    }

    @ApiImplicitParam(value = "数字",name = "num",dataTypeClass = Integer.class)
    @ApiOperation(value = "interger参数1")
    @PostMapping("/aar1")
    public Rest<Integer> rr1(@RequestParam(value = "num") Integer num){
        Rest<Integer> a=new Rest<>();
        a.setData(num);

        return a;
    }
    @ApiOperation(value = "interger参数2")
    @PostMapping("/aar2")
    public Rest<Integer> rr2(@ApiParam(value = "数字") @RequestParam(value = "num") Integer num){
        Rest<Integer> a=new Rest<>();
        a.setData(num);

        return a;
    }
    @ApiOperation(value = "数组请求Integer1")
    @PostMapping("/arrReques-Integer1")
    public Rest<List<Integer>> arrRequestInteger1(Integer[] arr){
        Rest<List<Integer>> r=new Rest<List<Integer>>();
        r.setData(Arrays.asList(arr));
        return r;
    }
    @ApiOperation(value = "数组请求arr-String")
    @PostMapping("/arrReques-String")
    public Rest<List<String>> arrRequestIntegesr1(String[] arr){
        Rest<List<String>> r=new Rest<List<String>>();
        r.setData(Arrays.asList(arr));
        return r;
    }

    @ApiOperation(value = "响应模型中存在Map类型,解析失败")
    @PostMapping("mapRequest")
    public Rest<MapInfo> map(@RequestBody MapInfo mapInfo){
        Rest<MapInfo> r=new Rest<>();
        r.setData(mapInfo);
        return r;
    }
    @ApiOperation(value = "很多请求参数-折叠参数面板")
    @PostMapping("manParameters")
    public Rest<MapParameters> map1(MapParameters mapInfo){
        Rest<MapParameters> r=new Rest<>();
        r.setData(mapInfo);
        return r;
    }

    @ApiOperation(value = "下载图片",position = 30)
    @GetMapping(value = "/downloadFile1",produces = "image/png")
    public void postRequest2(HttpServletRequest request, HttpServletResponse response){
        String fileName="s7.png";
        try {
            response.setContentType("image/png;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            FileInputStream fis=new FileInputStream(new File("C:\\Users\\xiaoymin\\Desktop\\s7.png"));
            OutputStream outputStream=response.getOutputStream();
            int r=-1;
            byte[] by=new byte[1024];
            while ((r=fis.read(by))!=-1){
                outputStream.write(by,0,r);
            }
            outputStream.flush();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }

    @PostMapping("/createOrder11")
    @ApiOperation(value = "创建订单请求11")
    public Rest<Order> createOrder11(@RequestBody Order order){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }
    @PostMapping("/createOrder")
    @ApiOperation(value = "创建订单请求")
    public Rest<Order> createOrder(@RequestBody Order order){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }
    @PostMapping("/createOrder1")
    @ApiOperation(value = "创建订单请求-noRequestBody")
    public Rest<Order> createOrder1(Order order){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }

    @ApiOperation(value = "数组请求Double")
    @PostMapping("/arrReques-Double")
    public Rest<List<Double>> arrRequestDouble(@RequestBody List<Double> arr){
        Rest<List<Double>> r=new Rest<List<Double>>();
        r.setData(arr);
        return r;
    }
    @ApiOperation(value = "数组请求Integer")
    @PostMapping("/arrReques-Integer")
    public Rest<List<Integer>> arrRequestInteger(@RequestBody List<Integer> arr){
        Rest<List<Integer>> r=new Rest<List<Integer>>();
        r.setData(arr);
        return r;
    }

    @ApiOperation(value = "数组请求Long")
    @PostMapping("/arrReques-long")
    public Rest<List<Long>> arrRequestLong(@RequestBody List<Long> arr){
        Rest<List<Long>> r=new Rest<List<Long>>();
        r.setData(arr);
        return r;
    }
    @ApiOperation(value = "数组请求bigdecimal")
    @PostMapping("/arrReques-bigdecimal")
    public Rest<List<BigDecimal>> arrRequestbigdecimal(@RequestBody List<BigDecimal> arr){
        Rest<List<BigDecimal>> r=new Rest<List<BigDecimal>>();
        r.setData(arr);
        return r;
    }
    @ApiOperation(value = "数组请求String")
    @PostMapping("/arrRequest")
    public Rest<List<String>> arrRequest(@RequestBody List<String> arr){
        Rest<List<String>> r=new Rest<List<String>>();
        r.setData(arr);
        return r;
    }

    @ApiOperation(value = "readOnly泛型属性支持")
    @PostMapping("/readOnlySupport")
    public Rest<ModelMoreField> notfied(@RequestBody PageRequest<ModelMoreField> modelMoreField){
        Rest<ModelMoreField> r=new Rest<>();
        logger.info("page:{},size:{}",modelMoreField.getPage(),modelMoreField.getSize());
        r.setData(modelMoreField.getData());
        return r;
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public Result<UserLoginVo> login(){
        Result<UserLoginVo> r=new Result<>();
        UserLoginVo u=new UserLoginVo();
        u.setNickame("test");
        u.setToken("aaaaaaaaaaaaaaaa");
        r.setData(u);
        r.setMessage("SUCCESS");
        return r;
    }

}
