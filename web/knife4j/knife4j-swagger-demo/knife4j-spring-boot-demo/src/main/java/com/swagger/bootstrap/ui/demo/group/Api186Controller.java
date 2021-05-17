/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp185.Model1851;
import com.swagger.bootstrap.ui.demo.domain.resp185.Test1Model;
import com.swagger.bootstrap.ui.demo.domain.resp185.Test2Model;
import com.swagger.bootstrap.ui.demo.domain.resp186.Model186;
import com.swagger.bootstrap.ui.demo.domain.resp186.Model1861;
import io.swagger.annotations.*;
import io.swagger.models.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Map;


/***
 * 1.8.4fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/25 12:44
 */
@Api(tags = "1.8.6版本-20181019",position = 299)
@ApiSort(1)
@RestController
@RequestMapping(value = "/api/new186/")
public class Api186Controller {

    @ApiOperation(value = "参数很长导致换行",position = 1)
    @PostMapping("/paramTooLong")
    public Rest<Model186> paramTooLong(@RequestBody Model186 model1851){
        Rest<Model186> r=new Rest<>();
        r.setData(model1851);
        return r;
    }
    @ApiOperation(value = "request mapping 中地址不支持path参数",position = 2)
    @PostMapping(path = "/pathRequest")
    @ApiImplicitParam(name = "bigDecimal",dataTypeClass = BigDecimal.class,value = "工资",required = true)
    public Rest<BigDecimal> dataBigDeciaml1(BigDecimal bigDecimal){
        Rest<BigDecimal> r=new Rest<>();
        r.setData(bigDecimal);
        return r;
    }

    @ApiOperation(value = "header参数无请求示例",position = 1)
    @PostMapping("/headerBody")
    public Rest<Model186> headerBody(@RequestHeader(value = "key")String key,@RequestBody Model186 model1851){
        Rest<Model186> r=new Rest<>();
        r.setData(model1851);
        return r;
    }
    @ApiOperation(value = "header参数无请求示例1",position = 1)
    @PostMapping("/headerBody1")
    public Rest<String> headerBody1(@RequestHeader(value = "token")String token){
        Rest<String> r=new Rest<>();
        r.setData(token);
        return r;
    }

    @ApiOperation(value = "使用HttpSession参数显示错误",position = 3)
    @PostMapping(value = "/useSession")
    public Rest<Model186> useSession(@RequestBody Model186 model1851, HttpSession httpSession){
        Rest<Model186> r=new Rest<>();
        r.setData(model1851);
        return r;
    }

    @ApiOperation(value = "使用HttpServletRequest参数",position = 4)
    @PostMapping(value = "/useRequest")
    public Rest<Model186> useRequest(@RequestBody Model186 model1851, HttpServletRequest request){
        Rest<Model186> r=new Rest<>();
        r.setData(model1851);
        return r;
    }
    @ApiOperation(value = "请求参数存在多个数组,增加按钮无效",position = 5)
    @PostMapping("/mulArrParamRequest")
    public Rest<Model1861> mulArrParamRequest(Model1861 model1861){
        Rest<Model1861> r=new Rest<>();
        r.setData(model1861);
        return r;
    }
}
