/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.new2;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;

import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.resp189.ModelMoreField;
import com.xiaominfo.knife4j.domain.resp192.MapInfo;
import com.xiaominfo.knife4j.domain.resp196.LongUser;
import com.xiaominfo.knife4j.domain.resp205.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020-8-9 10:47:39
 */
@Api(tags = "2.0.5版本-20200809")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 283)
@RestController
@RequestMapping("/api/nxew205")
public class Api205Controller {

    Logger logger= LoggerFactory.getLogger(Api205Controller.class);

    @ApiOperation(value = "描述支持markdown",notes = "# 访问此接口返回Hello语句<br />## 二级标题 你好Markdown`markdown`是一个不错的")
    @GetMapping("/description")
    public Rest<MapInfo> getInfo(){
        Rest<MapInfo> r=new Rest<>();
        return r;
    }
    @ApiOperation(value = "描述支持markdown",notes = "# 一、前言\n" +
            "\n" +
            "v2.0 搜索组件渲染接口\n" +
            "\n" +
            "\n" +
            "\n" +
            "# 二、请求参数\n" +
            "\n" +
            "- searchCode:搜索编码,后端定义,每个页面固定使用\n" +
            "\n" +
            "\n" +
            "\n" +
            "# 三、返回参数\n" +
            "\n" +
            "返回参数:JSON\n" +
            "\n" +
            "```json\n" +
            "{\n" +
            "\t\"data\": {\n" +
            "\t\t\"children\": {},\n" +
            "\t\t\"id\": 0,\n" +
            "\t\t\"name\": \"\"\n" +
            "\t},\n" +
            "\t\"errCode\": 0,\n" +
            "\t\"message\": \"\",\n" +
            "\t\"success\": true\n" +
            "}\n" +
            "```\n" +
            "\n")
    @GetMapping("/description1")
    public Rest<MapInfo> getInfo1(){
        Rest<MapInfo> r=new Rest<>();
        return r;
    }

    @ApiOperation(value = "curl为空的问题")
    @PostMapping("/codes")
    public Rest<String> codes(@RequestParam(value = "code",required = false) String code){
        if (StrUtil.isNotBlank(code)){
            return Rest.data(code);
        }else{
            return Rest.data(RandomUtil.randomString(10));
        }
    }

    @ApiOperation(value = "服务端指定consumes")
    @PostMapping(value = "/reqJson",consumes = "application/json;charset=UTF-8")
    public Rest<LongUser> reqJson(@RequestBody LongUser longUser){
        return Rest.data(longUser);
    }

    @ApiOperation(value = "大数据响应接口-渲染很慢")
    @PostMapping("/findAll")
    public Rest<List<ModelMoreField>> findAll(@RequestParam(value = "size",defaultValue = "1000") Integer size){
        Rest<List<ModelMoreField>> r=new Rest<>();
        List<ModelMoreField> modelMoreFields=new ArrayList<>();
        for (int i=0;i<size;i++){
            ModelMoreField m=new ModelMoreField();
            m.setAddress("浙江省杭州市文一西路22号杭州大厦18幢393"+i);
            m.setAge(33+i);
            m.setCompany("代码无敌");
            m.setDes("Java无敌");
            m.setEmail("jwd@test.com");
            m.setId("2333");
            m.setJoinTime(DateTime.now().toJdkDate());
            m.setNickName("萧峰"+i);
            m.setTel("18888888888");
            m.setWorker("架构师"+i);
            modelMoreFields.add(m);
        }
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


    @ApiOperation(value = "字符串数组")
    @PostMapping("/reqArr")
    public Rest<RequestArr> reqArr(RequestArr requestArr){
        return Rest.data(requestArr);
    }

    @ApiOperation(value = "枚举多选")
    @PostMapping("/reqEnumArr")
    public Rest<RequestEnumArr> reqEnumArr(RequestEnumArr requestArr){
        return Rest.data(requestArr);
    }

    @ApiOperation(value = "枚举多选-GET请求")
    @GetMapping("/reqEnumArr1")
    public Rest<RequestEnumArr> reqEnumArrGet(RequestEnumArr requestArr){
        return Rest.data(requestArr);
    }

    @ApiOperation(value = "POST空请求")
    @PostMapping("/reqEnumArrEmpty")
    public Rest<String> reqEnumArrEmpty(){
        return Rest.data(RandomUtil.randomString(32));
    }

    @ApiOperation(value = "返回实体类集成HashMap")
    @PostMapping("/respToMap")
    public Rest<ResponseToMap> respToMap(){
        return Rest.data(new ResponseToMap("name"+RandomUtil.randomNumbers(13),"135"+RandomUtil.randomNumbers(8)));
    }

    @ApiOperation(value = "GET请求数组请求")
    @GetMapping("/reqGetArr1")
    public Rest<RequestGetArr> reqGetArr1(RequestGetArr requestArr){
        return Rest.data(requestArr);
    }
    @ApiOperation(value = "GET请求数组请求2")
    @GetMapping("/reqGetArr2")
    public Rest<String> reqGetArr2(@RequestParam String[] codes){
        String codeArr=StrUtil.join(",",codes);
        return Rest.data(codeArr);
    }

    @ApiOperation(value = "POST请求下载文件",position = 1)
    @PostMapping(value = "/downloadFile",produces = "application/octet-stream")
    public void postRequest2(HttpServletRequest request, HttpServletResponse response){
        String fileName="中文需求.xlsx";
        try {
            //此文件为本机测试
            File excelFile=new File("C:\\Users\\xiaoymin\\Desktop\\高德地图城市编码.xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;FileName=" + URLEncoder.encode(fileName,"utf-8"));
            FileInputStream fis=new FileInputStream(excelFile);
            byte[] b=new byte[1024*1024];
            int r=-1;
            while ((r=fis.read(b))!=-1){
                response.getOutputStream().write(b,0,r);
            }
            response.getOutputStream().flush();
        } catch (IOException e) {
        }
    }

    @ApiOperation(value = "POST请求下载文件-JSON请求-Text",position = 1)
    @PostMapping(value = "/downloadTextFile",produces = "application/octet-stream")
    public void postRequest2json(@RequestBody LongUser longUser, HttpServletResponse response){
        logger.info("接收JSON参数：{}",longUser.toString());
        String fileName="中文需求.txt";
        try {
            //此文件为本机测试
            File excelFile=new File("C:\\Users\\xiaoymin\\Desktop\\test.txt");
            response.setContentType("text/plain;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;FileName=" + URLEncoder.encode(fileName,"utf-8"));
            FileInputStream fis=new FileInputStream(excelFile);
            byte[] b=new byte[1024*1024];
            int r=-1;
            while ((r=fis.read(b))!=-1){
                response.getOutputStream().write(b,0,r);
            }
            response.getOutputStream().flush();
        } catch (IOException e) {
        }
    }

    @ApiOperation(value = "POST请求下载文件-Excel",position = 1)
    @PostMapping(value = "/downloadJsonFile2",produces = "application/octet-stream")
    public void postRequest3(@RequestBody LongUser longUser, HttpServletRequest request, HttpServletResponse response){
        logger.info("接收JSON参数：{}",longUser.toString());
        String fileName="中文需求.xlsx";
        try {
            //此文件为本机测试
            File excelFile=new File("C:\\Users\\xiaoymin\\Desktop\\t1.xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;FileName=" + URLEncoder.encode(fileName,"utf-8"));
            FileInputStream fis=new FileInputStream(excelFile);
            byte[] b=new byte[1024*1024];
            int r=-1;
            while ((r=fis.read(b))!=-1){
                response.getOutputStream().write(b,0,r);
            }
            response.getOutputStream().flush();
        } catch (IOException e) {
        }
    }

    @ApiOperation(value = "长精度丢失的问题")
    @GetMapping("/reqLong")
    public Rest<ReqLong> reqLongRest(){
        ReqLong reqLong=new ReqLong();
        reqLong.setName("name"+RandomUtil.randomNumbers(5));
        reqLong.setValue(System.currentTimeMillis());
        reqLong.setValue(Long.parseLong("1293385365155090452"));
        logger.info("当前返回对象:{}",reqLong.toString());
        return Rest.data(reqLong);
    }

    @ApiOperation(value = "请求参数说明显示默认值")
    @PostMapping("/reqLong1")
    public Rest<ReqLong> reqLongRest1(@RequestBody ReqLong reqLong){
        logger.info("当前返回对象:{}",reqLong.toString());
        return Rest.data(reqLong);
    }

    @ApiOperation(value = "请求参数说明显示默认值2")
    @ApiImplicitParam(name = "name",value = "名称",example = "AAAAAAAAAAAAAAAA")
    @GetMapping("/reqLong2")
    public Rest<ReqLong> reqLongRest2(@RequestParam(value = "name") String name){
        ReqLong reqLong=new ReqLong();
        reqLong.setName(name);
        reqLong.setValue(System.currentTimeMillis());
        logger.info("当前返回对象:{}",reqLong.toString());
        return Rest.data(reqLong);
    }

    @ApiOperation(value = "json-consumes")
    @PostMapping(value = "po1",consumes = "application/json")
    public Rest<String> po1(){
        return Rest.data(RandomUtil.randomString(32));
    }



}
