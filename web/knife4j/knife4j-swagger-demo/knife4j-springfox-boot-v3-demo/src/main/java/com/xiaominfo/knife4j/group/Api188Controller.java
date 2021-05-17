/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.group;


import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.resp183.CombineResponse;
import com.xiaominfo.knife4j.domain.resp187.MetaModel;
import com.xiaominfo.knife4j.domain.resp187.Model187;
import com.xiaominfo.knife4j.domain.resp188.Tags;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/***
 * 1.8.6fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/11/05 08:44
 */
@Api(tags = "1.8.8版本-20181208",position = 297)
@RestController
@RequestMapping(value = "/api/new188/")
public class Api188Controller {
    @ApiOperation(value = "异常处理1",position = 30)
    @PostMapping("/errorHandel1")
    public Rest<Model187> postRequest1(@RequestBody Model187 model187, @ApiParam(hidden = true) HttpSession httpSession){
        Rest<Model187> r=new Rest<>();
        r.setData(model187);
        if (true){
            throw new IllegalArgumentException("请求参数错误");
        }
        return r;
    }

    @ApiOperation(value = "异常处理",position = 30)
    @PostMapping("/errorHandel")
    public Rest<Model187> postRequest(@RequestBody Model187 model187){
        Rest<Model187> r=new Rest<>();
        r.setData(model187);
        if (true){
            throw new IllegalArgumentException("请求参数错误");
        }
        return r;
    }

    @ApiOperation(value = "delete请求类型-requestbody参数")
    @DeleteMapping("/delids")
    public Rest<List<String>> del(@RequestBody List<String> ids){
        Rest<List<String>> r=new Rest<>();
        r.setData(ids);
        return r;
    }

    @ApiOperation(value = "相同model1")
    @PostMapping(value = "/mmodel")
    public Rest<MetaModel> metaModelRest(@RequestBody MetaModel metaModel){
        Rest<MetaModel> r=new Rest<>();
        metaModel.setId(1069835774339543041L);
        r.setData(metaModel);
        return r;
    }
    @ApiOperation(value = "非标准JSON格式")
    @PostMapping(value = "/mmodel2")
    public Rest<Map<Integer,String>> getTags(){
        Rest<Map<Integer,String>> r=new Rest<>();
        r.setData(Tags.valueMap);
        return r;
    }

    @ApiOperation(value = "非标准JSON格式2")
    @PostMapping(value = "/mmodel23")
    public Rest<Map<Integer,String>> getTags2(){
        Rest<Map<Integer,String>> r=new Rest<>();
        r.setData(Tags.valueMap);
        return r;
    }
    @ApiOperation(value = "非标准JSON格式3")
    @PostMapping(value = "/mmodel233")
    public Rest<Map<Integer,String>> getTags33(){
        Rest<Map<Integer,String>> r=new Rest<>();
        r.setData(Tags.valueMap);
        return r;
    }
    @ApiResponses({
            @ApiResponse(code = 200,message = "ok"),
            @ApiResponse(code = 400,message = "code:<br/>40001:不存在<br/>40002:对象不存在")
    })
    @ApiOperation(value = "响应信息不支持HTML标签")
    @PostMapping(value = "/mmodel254")
    public Rest<Map<Integer,String>> getTags3(){
        Rest<Map<Integer,String>> r=new Rest<>();
        r.setData(Tags.valueMap);
        return r;
    }
    @ApiResponses({
            @ApiResponse(code = 200,message = "ok",response = MetaModel.class),
            @ApiResponse(code = 400,message = "code:<br/>40001:不存在<br/>40002:对象不存在",response = CombineResponse.class)
    })
    @ApiOperation(value = "response响应码响应多个schema")
    @PostMapping(value = "/mmodel255")
    public Rest<MetaModel> getTags4(@RequestBody MetaModel metaModel){
        Rest<MetaModel> r=new Rest<>();
        r.setData(metaModel);
        return r;
    }
}
