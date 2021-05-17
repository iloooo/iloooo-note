/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.x180;

import com.google.common.collect.Lists;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.old.Domain182T1;
import com.swagger.bootstrap.ui.demo.domain.resp184.*;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/***
 * 1.8.3fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/21 12:44
 */
@Api(value = "1.8.4版本-20180918",tags = "1.8.4版本-20180918")
@ApiSort(301)
@RestController
@RequestMapping(value = "/api/new184/")
public class Api184Controller {

    @ApiOperation(value = "RequestParam参数类型请7求")
    @PostMapping("/requestParam")
    public Rest<String> RequestParam(@RequestParam(name = "key") String key,
                                      @RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();
        r.setData("formdata key:"+key+"------name:"+name);
        return r;
    }


    @ApiOperation(value = "RequestParam参数类型请求-modelAndParams")
    @PostMapping("/modelAndParams")
    public Rest<String> modelAndParams(SampleObject sampleObject, Integer page, Integer rows, @RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();
        r.setData("sampleName:"+sampleObject.getSampleName()+"page:"+page+",rows:"+rows+"------name:"+name);
        return r;
    }

    @ApiOperation(value = "属性List对象包含同一对象不显示")
    @PostMapping("/listSameProps")
    public Rest<SampleArray> listSameProps(@RequestBody SampleArray sampleArray){
        Rest<SampleArray> sampleArrayRest=new Rest<SampleArray>();
        sampleArrayRest.setData(sampleArray);
        return sampleArrayRest;
    }


    @ApiImplicitParams({@ApiImplicitParam(name = "file",paramType = "body", value = "上传文件", required = true,dataType = "MultipartFile",allowMultiple = true)}
    )
    @ApiOperation(value = "同时传输文本信息和文件")
    @PostMapping("/fileRequestMultValues")
    public Rest<SampleField> fileRequestMultValues(SampleField sampleField, HttpServletRequest request){
        Rest<SampleField> rest=new Rest<>();
        rest.setData(sampleField);
        return rest;
    }


    @ApiImplicitParam(value = "标题名称",paramType = "form",name = "name")
    @ApiOperation(value = "RequestformParam参数类型请求")
    @PostMapping("/RequestformParam")
    public Rest<String> RequestformParam(@RequestHeader(name = "key") String key,
                                     @RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();
        r.setData("formdata key:"+key+"------name:"+name);
        return r;
    }


    @PostMapping("/threeTClazz")
    @ApiOperation(value = "多层泛型返回")
    public Rest<SeriaClass<SampleField>> threeTClazz(@RequestBody SampleField sampleField){
        Rest<SeriaClass<SampleField>> rr=new Rest<>();
        SeriaClass<SampleField> ss=new SeriaClass<>();
        ss.getTypes().add(sampleField);
        ss.setSampleClass("SapleFiled");
        rr.setData(ss);
        return rr;
    }

    @PostMapping("/threeTClazzs")
    @ApiOperation(value = "多层泛型返回-复杂类")
    public Rest<SeriaClass<SampleObject>> threeTClazzs(@RequestBody SampleObject sampleField){
        Rest<SeriaClass<SampleObject>> rr=new Rest<>();
        SeriaClass<SampleObject> ss=new SeriaClass<>();
        ss.getTypes().add(sampleField);
        ss.setSampleClass("SampleObject");
        rr.setData(ss);
        return rr;
    }


    @ApiOperation(value = "[\"text/plain\"] controller接收问题")
    @PostMapping(value = "/plainRequest",consumes = "text/plain")
    public Rest<String> plainRequest(@RequestBody @ApiParam(required = true,value = "扫描出的二维码结果") String body){
        Rest<String> rest=new Rest<>();
        rest.setData(body);
        return rest;
    }


    @ApiOperation(value = "关于泛型数据接口返回list类型时的一个小bug")
    @PostMapping("/fanxingDefualt")
    public SeriDefaultClass<SampleField> fxT(@RequestBody SampleField sampleField){
        SeriDefaultClass<SampleField> ss=new SeriDefaultClass<>();
        ss.setData(sampleField);
        return ss;
    }

    @ApiOperation(value = "关于泛型数据接口返回list类型时的一个小bug")
    @PostMapping("/fxArrT")
    public SeriDefaultArrClass<SampleField> fxArrT(@RequestBody SampleField sampleField){
        SeriDefaultArrClass<SampleField> ss=new SeriDefaultArrClass<>();
        ss.getData().add(sampleField);
        return ss;
    }

    @PostMapping("/Integerarr")
    @ApiOperation(value = "int数组类型")
    public Rest<Domain182T1> stringarr(String name, int[] arrs){
        Rest<Domain182T1> r=new Rest<>();
        Domain182T1 d=new Domain182T1();
        List<String> arrStrs=Lists.newArrayList();
        for (int i=0;i<arrs.length;i++){
            arrStrs.add(arrs[i]+"");
        }
        d.setName(name);
        d.setLabels(arrStrs);
        r.setData(d);

        return r;
    }
    @PostMapping("/Integerarr1")
    @ApiOperation(value = "int数组类型111")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "name",paramType = "form"),
            @ApiImplicitParam(name = "arrs",value = "arrs",paramType = "form")
    })
    public Rest<Domain182T1> Integerarr1(String name, int[] arrs){
        Rest<Domain182T1> r=new Rest<>();
        Domain182T1 d=new Domain182T1();
        List<String> arrStrs=Lists.newArrayList();
        for (int i=0;i<arrs.length;i++){
            arrStrs.add(arrs[i]+"");
        }
        d.setName(name);
        d.setLabels(arrStrs);
        r.setData(d);

        return r;
    }

    @PostMapping("/IntegerList")
    @ApiOperation(value = "intList数组类型")
    public Rest<Domain182T1> stringarr(String name, ArrayList<Integer> arrs){
        Rest<Domain182T1> r=new Rest<>();
        Domain182T1 d=new Domain182T1();
        List<String> arrStrs=Lists.newArrayList();
        for (int i=0;i<arrs.size();i++){
            arrStrs.add(arrs.get(i)+"");
        }
        d.setName(name);
        d.setLabels(arrStrs);
        r.setData(d);

        return r;
    }


    @PostMapping("/threeSample")
    @ApiOperation(value = "三层解析")
    public RestJson<MyPageInfo<HasToDoTasksInfoSelectVo>> threeSample(){
        return null;
    }

    @PostMapping("/threeTClazzs1")
    @ApiOperation(value = "多层泛型返回-复杂类1")
    public Rest<MyPageInfo<HasToDoTasksInfoSelectVo>> threeTClazzsss(@RequestBody HasToDoTasksInfoSelectVo sampleField){
        Rest<MyPageInfo<HasToDoTasksInfoSelectVo>> rr=new Rest<>();
        MyPageInfo<HasToDoTasksInfoSelectVo> ss=new MyPageInfo<>();
        ss.setList(new ArrayList<HasToDoTasksInfoSelectVo>());
        ss.getList().add(sampleField);
        rr.setData(ss);
        return rr;
    }



}
