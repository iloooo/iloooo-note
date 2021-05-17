/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.group;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.resp185.Model1851;
import com.xiaominfo.knife4j.domain.resp185.Test1Model;
import com.xiaominfo.knife4j.domain.resp185.Test2Model;
import io.swagger.annotations.*;
import io.swagger.models.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;


/***
 * 1.8.4fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/25 12:44
 */
@Api(tags = "1.8.5版本-20180925",position = 300,description = "测试description属性")
@ApiSort(1)
@RestController
@RequestMapping(value = "/api/new185/")
public class Api185Controller {

    @ApiOperation(value = "BigDecimal类型解析为String类型",position = 1)
    @PostMapping("/dataBigDeciaml")
    public Rest<Model1851> dataBigDeciaml(@RequestBody Model1851 model1851){
        Rest<Model1851> r=new Rest<>();
        r.setData(model1851);
        return r;
    }
    @ApiOperation(value = "BigDecimal类型->String类型",position = 2)
    @PostMapping("/dataBigDeciaml1")
    @ApiImplicitParam(name = "bigDecimal",dataTypeClass = BigDecimal.class,value = "工资",required = true)
    public Rest<BigDecimal> dataBigDeciaml1(BigDecimal bigDecimal){
        Rest<BigDecimal> r=new Rest<>();
        r.setData(bigDecimal);
        return r;
    }


    @ApiOperation(value = "map参数请求",position = 3)
    @PostMapping("/requestMap")
    public Rest<Map<String,String>> requestMap(@RequestParam Map<String,String> params){
        Rest<Map<String,String>> r=new Rest<>();
        r.setData(params);
        return r;
    }


    @ApiOperation(value = "map参数请求1",position = 4)
    @PostMapping("/requestMap1")
    public Rest<Map<String,String>> requestMap1(@RequestBody Map<String,String> params){
        Rest<Map<String,String>> r=new Rest<>();
        r.setData(params);
        return r;
    }

    @PostMapping("/testArray")
    @ApiOperation(httpMethod = "POST",value = "测试数组参数，多个")
    @ApiResponses({
            @ApiResponse(code = 200, message = "非HTTP状态码，返回值JSON code字段值，描述：成功")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Access-Token",paramType ="header", value = "http header传登录时候获取到accessToken", required = true),
            @ApiImplicitParam(name = "ids",paramType ="form",value = "参数",allowMultiple = true, required = true)
    })
    public String testArray(int[] ids) {
        for (int id : ids) {
            System.out.println(id);
        }
        return "测试";
    }

    @PostMapping("/testArray1")
    @ApiOperation(httpMethod = "POST",position = 10,value = "Test1Model测试数组参数，多个",response = Test1Model.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "非HTTP状态码，返回值JSON code字段值，描述：成功")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",paramType ="form",value = "参数",allowMultiple = true, required = true)
    })
    public String testArray1(String[] ids,Model model) {
        for (String id : ids) {
            System.out.println(id);
        }
        return "test";
    }

    @PostMapping("/testArray2")
    @ApiOperation(httpMethod = "POST",position = 20,value = "Test2Model测试数组参数，多个",response= Test2Model.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "非HTTP状态码，返回值JSON code字段值，描述：成功")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",paramType ="form",value = "参数",allowMultiple = true, required = true)
    })
    public String testArray2(String[] ids,Model model) {
        for (String id : ids) {
            System.out.println(id);
        }
        return "test";
    }


    @PostMapping("/moreParams")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",paramType ="body",value = "参数", required = true),
            @ApiImplicitParam(name = "ids1",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids2",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids3",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids4",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids5",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids6",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids7",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids8",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids9",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids10",paramType ="query",value = "参数", required = true),
    })
    public Rest<String> moreParam(String ids){
        Rest<String> r=new Rest<>();
        r.setData(ids);
        return r;
    }
    @PostMapping("/moreParams1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",paramType ="body",value = "参数", required = true),
            @ApiImplicitParam(name = "ids1",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids2",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids3",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids4",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids5",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids6",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids7",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids8",paramType ="query",value = "参数", required = true)
    })
    public Rest<String> moreParam1(String ids){
        Rest<String> r=new Rest<>();
        r.setData(ids);
        return r;
    }
    @PostMapping("/moreParams2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",paramType ="body",value = "参数", required = true),
            @ApiImplicitParam(name = "ids1",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids2",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids3",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids4",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids5",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids6",paramType ="query",value = "参数", required = true)
    })
    public Rest<String> moreParam2(String ids){
        Rest<String> r=new Rest<>();
        r.setData(ids);
        return r;
    }

    @PostMapping("/moreParams3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",paramType ="body",value = "参数", required = true),
            @ApiImplicitParam(name = "ids1",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids2",paramType ="query",value = "参数", required = true),
            @ApiImplicitParam(name = "ids3",paramType ="query",value = "参数", required = true)
    })
    public Rest<String> moreParam3(String ids){
        Rest<String> r=new Rest<>();
        r.setData(ids);
        return r;
    }
}
