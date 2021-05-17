/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.new2;

import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.google.common.collect.Lists;

import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.common.RestMessage;
import com.xiaominfo.knife4j.domain.resp196.IgnoreP1;
import com.xiaominfo.knife4j.domain.resp196.LongUser;
import com.xiaominfo.knife4j.domain.resp202.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/12/16 19:42
 */
@Api(tags = "2.0.2版本-20200226")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 286)
@RestController
@RequestMapping("/api/nxew202")
public class Api202Controller {

    @ApiOperation(value = "忽略参数")
    @ApiOperationSupport(order = 26,ignoreParameters = {"nodes[0]"})
    @GetMapping("/getUser221")
    public Rest<KDto> getUse1rx(KDto kDto){
        Rest<KDto> r=new Rest<>();
        r.setData(kDto);
        return r;
    }
    @ApiOperation(value = "忽略参数1")
    @ApiOperationSupport(order = 26,ignoreParameters = {"nodes[0].name"})
    @GetMapping("/getUser22121")
    public Rest<KDto> getUse1r13x(KDto kDto){
        Rest<KDto> r=new Rest<>();
        r.setData(kDto);
        return r;
    }
    @ApiOperation(value = "忽略参数xx1-json")
    @ApiOperationSupport(order = 27,ignoreParameters = {"kDto.nodes"})
    @GetMapping("/getUser221x")
    public Rest<KDto> getUse1rx1(@RequestBody KDto kDto){
        Rest<KDto> r=new Rest<>();
        r.setData(kDto);
        return r;
    }

    @ApiOperationSupport(order = 28,ignoreParameters = {"createTimes[0]"})
    @ApiOperation(value = "忽略数组类型的参数")
    @PostMapping("/Knife4jUser11")
    public Rest<Knife4jTime> findAll16(Knife4jTime knife4jTime) {
        Rest<Knife4jTime> r=new Rest<>();
        r.setData(knife4jTime);
        return r;
    }

    @ApiOperationSupport(order = 29,ignoreParameters = "longUsers.ids")
    @ApiOperation(value = "忽略参数值-数组类型")
    @PostMapping("/ex4")
    public Rest<List<LongUser>> findAll4(@RequestBody List<LongUser> longUsers) {
        Rest<List<LongUser>> r=new Rest<>();
        r.setData(longUsers);
        return r;
    }

    @ApiOperationSupport(order = 30,ignoreParameters = {"ignoreP1.ignoreLabels[0].code","ignoreP1.longUser.ids"})
    @ApiOperation(value = "忽略参数值-JSON类型1")
    @PostMapping("/ex3")
    public Rest<IgnoreP1> findAll3(@RequestBody IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }
    @ApiOperationSupport(order = 30,ignoreParameters = {"ignoreP1.ignoreLabels","ignoreP1.longUser.ids"})
    @ApiOperation(value = "忽略参数值-JSON类型2")
    @PostMapping("/ex322")
    public Rest<IgnoreP1> findAll3223(@RequestBody IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }

    @ApiOperationSupport(order = 31,ignoreParameters = "longUser.ids")
    @ApiOperation(value = "忽略参数值-JSON类型")
    @PostMapping("/ex2")
    public Rest<LongUser> findAll1(@RequestBody LongUser longUser) {
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }


    @ApiOperationSupport(order = 32,ignoreParameters = {"ignoreLabels","longUser.ids"})
    @ApiOperation(value = "忽略参数值-Form类型1")
    @PostMapping("/ex1")
    public Rest<IgnoreP1> findAll12(IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }

    @ApiOperationSupport(order = 33,ignoreParameters = "ids")
    @ApiOperation(value = "忽略参数值-Form类型")
    @PostMapping("/ex")
    public Rest<LongUser> findAll(LongUser longUser) {
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }


    @ApiOperationSupport(order = 40,includeParameters = {"ignoreLabels","longUser.ids"})
    @ApiOperation(value = "包含参数值-Form类型1")
    @PostMapping("/ex1c")
    public Rest<IgnoreP1> findAllc12(IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }



    @ApiOperationSupport(order = 41)
    @ApiOperation(value = "包含参数值-JSON类型")
    @PostMapping("/exc2")
    public Rest<LongUser> findAllc1(@RequestBody LongUser ongUser) {
        Rest<LongUser> r=new Rest<>();
        r.setData(ongUser);
        return r;
    }


    @ApiOperationSupport(order = 42)
    @ApiOperation(value = "包含参数值-JSON类型1")
    @PostMapping("/exc3")
    public Rest<IgnoreP1> findAllc3(@RequestBody IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }
    @ApiOperationSupport(order = 43)
    @ApiOperation(value = "包含参数值-JSON类型2")
    @PostMapping("/exc323")
    public Rest<IgnoreP1> findAllc333(@RequestBody IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }


    @Operation(summary = "url-form类型枚举下拉框显示-简单枚举11")
    @PostMapping(value = "/Knife4jUser",consumes = "application/x-www-form-urlencoded")
    public Rest<Knife4jUser> findAll5(Knife4jUser knife4jUser) {
        Rest<Knife4jUser> r=new Rest<>();
        r.setData(knife4jUser);
        return r;
    }
    @ApiOperation(value = "url-form类型枚举下拉框显示-复杂枚举22")
    @PostMapping("/Knife4jUser1")
    public Rest<Knife4jUab> findAll6(Knife4jUab knife4jUab) {
        Rest<Knife4jUab> r=new Rest<>();
        r.setData(knife4jUab);
        return r;
    }

    @ApiOperation(value = "formdata上传附带枚举参数")
    @PostMapping("/uploadModel")
    public RestMessage uploadModel(UploadEnum uploadEnum){
        RestMessage r=new RestMessage();
        String content="name:"+uploadEnum.getName()+",enum:"+uploadEnum.getKnife4jType().toString();
        r.setData(content);
        return r;
    }

    @ApiOperation(value = "raw-form类型枚举下拉框显示-复杂枚举")
    @PostMapping("/Knife4jUser7")
    public Rest<Knife4jUab> findAll7(Knife4jUab knife4jUab,@RequestBody Knife4jUser knife4jUser) {
        Rest<Knife4jUab> r=new Rest<>();
        r.setData(knife4jUab);
        System.out.println("user:"+knife4jUser.getName()+",type:"+knife4jUser.getKnife4jType().toString());
        return r;
    }



    @ApiOperation(value = "忽略数组类型的参数-不忽略")
    @PostMapping("/Knife4jUser12")
    public Rest<Knife4jTime> findAll18(Knife4jTime knife4jTime) {
        Rest<Knife4jTime> r=new Rest<>();
        r.setData(knife4jTime);
        return r;
    }

    @ApiOperation(value = "GET请求参数编码处理")
    @GetMapping("/getUser")
    public Rest<GetArray> getUser(GetArray getArray){
        Rest<GetArray> r=new Rest<>();
        r.setData(getArray);
        return r;
    }

    @ApiOperation(value = "GET请求参数编码处理1")
    @GetMapping("/getUser1")
    public Rest<GetArray> getUse1r(GetArray getArray){
        Rest<GetArray> r=new Rest<>();
        r.setData(getArray);
        return r;
    }


    @ApiOperation(value = "Get无刷新请求")
    @GetMapping("/getParams")
    public Rest<GetParam> getUse1rx1(){
        Rest<GetParam> r=new Rest<>();
        r.setData(new GetParam());
        return r;
    }
    @ApiOperation(value = "Get无刷新请求1")
    @GetMapping("/getParams1")
    public Rest<GetParam> getUse1rx111(){
        Rest<GetParam> r=new Rest<>();
        r.setData(new GetParam());
        return r;
    }
    @ApiOperationSupport(author = "xiaoymin@foxmail.com")
    @ApiOperation(value = "Get无刷新请求1777722222")
    @GetMapping("/getParams21")
    public Rest<GetParam> getUse1rx1113(){
        Rest<GetParam> r=new Rest<>();
        r.setData(new GetParam());
        return r;
    }


    @ApiOperationSupport(author = "xiaoymin@foxmail.com")
    @ApiOperation(value = "测试Loading效果")
    @GetMapping("/getLoading")
    public Rest<GetParam> getLoading(){
        Rest<GetParam> r=new Rest<>();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.setData(new GetParam());
        return r;
    }


    @ApiOperationSupport(author = "xiaoymin@foxmail.com")
    @ApiOperation(value = "写文档注释我是认真的")
    @GetMapping("/getRealDoc")
    public Rest<RealDescription> getRealDoc(){
        Rest<RealDescription> r=new Rest<>();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.setData(new RealDescription());
        return r;
    }

    @ApiOperationSupport(author = "xiaoymin@foxmail.com")
    @ApiOperation(value = "写文档注释我是认真的-array")
    @GetMapping("/getRealDocarr")
    public Rest<List<RealDescription>> getRealDoc1(){
        Rest<List<RealDescription>> r=new Rest<>();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.setData(Lists.newArrayList(new RealDescription()));
        return r;
    }


    @ApiOperationSupport(author = "xiaoymin@foxmail.com")
    @ApiOperation(value = "响应数据太长不换行")
    @GetMapping("/getRealDocarrx")
    public Rest<List<RealDescription>> getRealDoc3(){
        Rest<List<RealDescription>> r=new Rest<>();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RealDescription rd=new RealDescription();
        rd.setName(RandomUtil.randomNumbers(300));
        r.setData(Lists.newArrayList(new RealDescription(),rd));
        return r;
    }


    @ApiOperationSupport(author = "xiaoymin@foxmail.com")
    @ApiOperation(value = "字段太多了属性不显示?")
    @GetMapping("/getKdes")
    public Rest<KDescrption> getKdes(){
        Rest<KDescrption> r=new Rest<>();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.setData(new KDescrption());
        return r;
    }
}
