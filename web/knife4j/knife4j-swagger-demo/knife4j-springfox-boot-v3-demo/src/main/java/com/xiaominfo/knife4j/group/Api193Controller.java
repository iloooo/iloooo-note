/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.group;

import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.resp192.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/***
 * 1.9.1fixed bug修改
 * @since:swagger-bootstrap-ui 1.9.2
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019-3-17 13:31:53
 */
@Api(tags = "1.9.3版本-20190417-我的长度很长啊我的长度很长啊我的长度很长啊",position = 292)
@RestController
@RequestMapping(value = "/api/new193/")
public class Api193Controller {

    Logger logger= LoggerFactory.getLogger(Api193Controller.class);

    @PostMapping("/createOrder")
    @ApiOperation(value = "描述支持Html渲染37",notes = "验证码:<br />4000:成功<br/>5000:失败")
    public Rest<Order> createOrder(@RequestBody Order order){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }
    @PostMapping("/createOrder12")
    @ApiOperation(value = "描述支持Html渲染1-新接口4",notes = "验证码:<br />4000:成功<br/>5000:失败")
    public Rest<Order> createOrder1(@RequestBody Order order){
        Rest<Order> r=new Rest<>();
        r.setData(order);
        return r;
    }
    @PostMapping(value = "/createMap")
    @ApiOperation(value = "map参数请求")
    public Rest<Map<String,String>> map(@RequestHeader(value = "rToken1") String rtoken,@RequestParam Map<String,String> map){
        Rest<Map<String,String>> r=new Rest<>();
        r.setData(map);
        return r;
    }


}
