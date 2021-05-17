/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.x190;

import com.swagger.bootstrap.ui.demo.common.Rest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/12/07 19:42
 */
@Api(tags = "2.0.0版本-20191101",position = 288)
@RestController
@RequestMapping("/api/new200")
public class Api197Controller {


    @ApiOperation(value = "测试CURL参数")
    @ApiImplicitParam(name = "name",value = "姓名")
    @GetMapping("/getCurl")
    public Rest<String> getCurl(@RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();
        r.setData(name);
        return r;
    }

    @ApiOperation(value = "测试CURL参数-POST")
    @ApiImplicitParam(name = "name",value = "姓名")
    @PostMapping("/postCurl")
    public Rest<String> postCurl(HttpServletRequest request, @RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();
        try {
            System.out.println(URLDecoder.decode(request.getHeader("Authorization"),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("name:"+name);
        r.setData(name);
        return r;
    }

    @ApiOperation(value = "返回Map类型在响应中出现双引号")
    @PostMapping("/respMapDoubles")
    public Rest<Map<String,Object>> respMapDoubles(){
        Rest<Map<String,Object>> rest=new Rest<>();
        Map<String,Object> map=new HashMap<>();
        map.put("name","张飞");
        map.put("name-birht","2019-11-11");
        map.put("images[0]","aaaaaaaaaa");
        map.put("0","1111111111111111111数字");

        Map<String,Object> map1=new HashMap<>();
        map1.put("name","张飞");
        map1.put("name-birht","2019-11-11");
        map1.put("map1-x-birht","2019-11-11");

        map.put("map1-1x",map1);
        rest.setData(map);
        return rest;
    }

    @ApiOperation(value = "@PathVariable Long类型显示异常",notes = "https://github.com/xiaoymin/swagger-bootstrap-ui/issues/161")
    @GetMapping("/user/{user_id}")
    public Rest<Long> pathLong(@PathVariable Long user_id){
        Rest<Long> rest=new Rest<>();
        rest.setData(user_id);
        return rest;
    }
}
