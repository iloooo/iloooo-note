/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.swagger.controller;

import cn.hutool.core.date.DateTime;
import com.google.common.collect.Lists;
import com.xiaominfo.swagger.common.Rest;
import com.xiaominfo.swagger.domain.resp189.Model189;
import com.xiaominfo.swagger.domain.resp189.ModelElement;
import com.xiaominfo.swagger.domain.resp189.ModelMoreField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * 1.8.9fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019-1-7 16:18:56
 */
@Api(tags = "1.8.9版本-20190107",position = 296)
@RestController
@RequestMapping(value = "/api/new189/")
public class Api189Controller {

    Logger logger= LoggerFactory.getLogger(Api189Controller.class);

    @ApiOperation(value = "下载",position = 30)
    @GetMapping("/downloadFile")
    public void postRequest1(HttpServletRequest request, HttpServletResponse response){
        download(response);
    }
    @ApiOperation(value = "下载1-octet-stream",position = 30)
    @GetMapping(value = "/downloadFile1",produces = "application/octet-stream")
    public void postRequest2(HttpServletRequest request, HttpServletResponse response){
        download(response);
    }

    @ApiOperation(value = "list套list的返回值会不显示")
    @PostMapping("/listMul")
    public Rest<Model189> listMul(@RequestBody Model189 m){
        Rest<Model189> r=new Rest<>();
        r.setData(m);
        return r;
    }

    @ApiOperation(value = "响应内容逐行展示description字段")
    @PostMapping("/findAll")
    public Rest<List<ModelMoreField>> findAll(){
        Rest<List<ModelMoreField>> r=new Rest<>();
        List<ModelMoreField> modelMoreFields=new ArrayList<>();

        ModelMoreField m=new ModelMoreField();
        m.setAddress("浙江省杭州市文一西路22号杭州大厦18幢393");
        m.setAge(33);
        m.setCompany("代码无敌");
        m.setDes("Java无敌");
        m.setEmail("jwd@test.com");
        m.setId("2333");
        m.setJoinTime(DateTime.now().toJdkDate());
        m.setNickName("萧峰");
        m.setTel("18888888888");
        m.setWorker("架构师");

        modelMoreFields.add(m);
        ModelMoreField m1=new ModelMoreField();
        m1.setAddress("浙江省杭州市文一西路22号杭州大厦18幢393");
        m1.setAge(32);
        m1.setCompany("代码无敌");
        m1.setDes("JavaScript无敌");
        m1.setEmail("jswd@test.com");
        m1.setId("2334");
        m1.setJoinTime(DateTime.now().toJdkDate());
        m1.setNickName("虚竹");
        m1.setTel("18888888889");
        m1.setWorker("Javascript开发工程师");
        modelMoreFields.add(m1);
        r.setData(modelMoreFields);
        return r;
    }

    @ApiOperation(value = "全局参数与接口参数冲突")
    @PostMapping(value = "/paramMiss")
    public Rest<String> paramMiss(@ApiParam(value = "参数名称",name = "uid") @RequestParam(value = "uid") String uid, HttpServletRequest request){
        Rest<String> r=new Rest<>();
        String headerP=request.getHeader("uid");
        r.setData("传输uid参数为："+uid+",Header参数："+headerP);
        return r;
    }

    @ApiOperation(value = "html元素丢失")
    @PostMapping(value = "/elementMiss")
    public Rest<ModelElement> elementMiss(){
        Rest<ModelElement> r=new Rest<>();
        ModelElement img=new ModelElement();
        img.setElementName("image");
        img.setValue("<img src=\"http://www.xiaominfo.com/image/swaggerbui.jpg\" />");

        r.setData(img);

        return r;
    }
    @ApiOperation(value = "服务端数据响应HTML标签数据,无法解析,丢失")
    @PostMapping(value = "/elementMisss")
    public Rest<List<ModelElement>> elementMisss(){
        Rest<List<ModelElement>> r=new Rest<>();
        ModelElement img=new ModelElement();
        img.setElementName("image");
        img.setValue("<img src=\"http://www.xiaominfo.com/image/swaggerbui.jpg\" />");

        List<ModelElement> list= Lists.newArrayList();
        list.add(img);

        list.add(new ModelElement("div","<div>我是div元素</div>"));
        list.add(new ModelElement("span","<span>我是span元素</span>"));
        list.add(new ModelElement("font","<font>我是font元素</font>"));

        r.setData(list);

        return r;
    }

    @ApiOperation(value = "REST PUT 不支持query参数")
    @PutMapping("/putQueryParam/{id}")
    public Rest<String> putQueryParam(@ApiParam(value = "id") @PathVariable String id, @ApiParam(value = "fieldId") @RequestParam(value = "fieldId") String fieldId){
        Rest<String> r=new Rest<>();
        r.setData("请求id："+id+",Query-fieldId:"+fieldId);
        return r;
    }



    private void download(HttpServletResponse response){
        String fileName=new Random().nextInt(1000)+".txt";
        try {
            response.setContentType("text/plain;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            ByteArrayOutputStream by=new ByteArrayOutputStream();
            String content="This test Download File Api,哈哈哈,我是中文,我是无敌的";
            by.write(content.getBytes());
            by.writeTo(response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
