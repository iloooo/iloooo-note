/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.google.common.collect.Lists;
import com.swagger.bootstrap.ui.demo.common.ErrorCode;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.old.ActInteger;
import com.swagger.bootstrap.ui.demo.domain.old.Domain182T1;
import com.swagger.bootstrap.ui.demo.domain.old.MulRequest;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/***
 * 1.8.2fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/21 12:44
 */
@Api(value = "1.8.2版本",tags = "1.8.2版本")
@ApiSort(304)
@RestController
@RequestMapping(value = "/api/new182/")
public class Api182Controller {


    @PostMapping("/mulreq")
    @ApiOperation(value = "关于@ApiModelProperty的value不支持\\n")
    public Rest<MulRequest> mulrequest(@RequestBody MulRequest mulRequest){
        Rest<MulRequest> r=new Rest<>();
        r.setData(mulRequest);
        return r;
    }

    @PostMapping("/stringarr")
    @ApiOperation(value = "string数组类型")
    public Rest<Domain182T1> stringarr(String name,String[] arrs){
        Rest<Domain182T1> r=new Rest<>();
        Domain182T1 d=new Domain182T1();
        d.setName(name);
        d.setLabels(Lists.newArrayList(arrs));
        r.setData(d);
        return r;
    }

    @PostMapping("/stringarrres")
    @ApiOperation(value = "string-response数组类型")
    public Rest<List<Domain182T1>> stringarrres(String name, String[] arrs){
        Rest<List<Domain182T1>> r=new Rest<>();
        Domain182T1 d=new Domain182T1();
        d.setName(name);
        d.setLabels(Lists.newArrayList(arrs));
        r.setData(Lists.newArrayList(d));
        return r;
    }

    @DeleteMapping("/requestHeader")
    @ApiOperation(value = "string-RequestHeader参数类型请求接口")
    public Rest<String> requestHeader(@RequestHeader(name = "key") String key){
        Rest<String> r=new Rest<>();
        r.setData(key);
        return r;
    }
    @GetMapping("/requestGetHeader")
    @ApiOperation(value = "string-Get-RequestHeader参数类型请求接口")
    public Rest<String> requestGetHeader(@RequestHeader(name = "key") String key){
        Rest<String> r=new Rest<>();
        r.setData(key);
        return r;
    }

    @PostMapping("/mulformAndBody")
    @ApiOperation(value = "form以及body参数一起传递")
    public Rest<ActInteger> mulformAndBody(String val,@RequestBody ActInteger actInteger){
        System.out.println("传递val名称："+val);
        Rest<ActInteger> r=new Rest<>();
        r.setData(actInteger);
        return r;
    }

    @PostMapping("/mulformAndEnum")
    @ApiOperation(value = "form+enum以及body参数一起传递")
    public Rest<ActInteger> mulformAndEnum(String val, ErrorCode errorCode, @RequestBody ActInteger actInteger){
        System.out.println("传递val名称："+val);
        System.out.println("枚举："+errorCode);
        Rest<ActInteger> r=new Rest<>();
        r.setData(actInteger);
        return r;
    }


    @PostMapping("/mulformAndEnumAndfile")
    @ApiOperation(value = "form+enum+file以及body参数一起传递")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true,dataType = "MultipartFile",allowMultiple = true)})
    public Rest<String> mulformAndEnumAndfile(String val, ErrorCode errorCode, @RequestParam(name = "file")MultipartFile file){
        System.out.println("传递val名称："+val);
        System.out.println("枚举："+errorCode);
        Rest<String> r=new Rest<>();
        r.setData(val);
        return r;
    }

    @PostMapping("/mulformAndEnumAndfileHeader")
    @ApiOperation(value = "form+enum+header+file以及body参数一起传递")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true,dataType = "MultipartFile",allowMultiple = true)})
    public Rest<String> mulformAndEnumAndfileHeader(@RequestHeader(name = "key") String key,String val, ErrorCode errorCode, @RequestParam(name = "file")MultipartFile file){
        System.out.println("Header---"+key);
        System.out.println("传递val名称："+val);
        System.out.println("枚举："+errorCode);
        Rest<String> r=new Rest<>();
        r.setData("Header---"+key+",传递val名称："+val+",枚举："+errorCode);
        return r;
    }
}
