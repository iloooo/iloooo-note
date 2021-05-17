/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.AllInfomationWebVo;
import com.swagger.bootstrap.ui.demo.domain.resp196.AllInfomationWebVo1;
import com.swagger.bootstrap.ui.demo.domain.resp196.LongUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;


/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/07/28 17:43
 */
@Api(tags = "1.9.6版本-20190827",position = 289)
@RestController
@RequestMapping("/api/new196")
public class Api196Controller {
    Logger logger= LoggerFactory.getLogger(Api196Controller.class);


    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "长整型丢失精度问题")
    @GetMapping(value = "/longUserRest")
    public Rest<LongUser> longUserRest(@RequestParam(value = "name") String name){
        Rest<LongUser> rest=new Rest<>();
        LongUser longUser=new LongUser();
        longUser.setName(name);
        longUser.setId(1153475471162216445L);
        rest.setData(longUser);
        return rest;
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "curl参数复制被转义")
    @GetMapping(value = "/longUserRest1")
    public Rest<LongUser> longUserRest1(@RequestParam(value = "name") String name, @RequestParam(value = "title") String title){
        Rest<LongUser> rest=new Rest<>();
        LongUser longUser=new LongUser();
        longUser.setName(name+title);
        longUser.setId(1153475471162216445L);
        rest.setData(longUser);
        return rest;
    }

    @ApiOperation(value = "PathVariable参数调试")
    @PostMapping(value = "/config/kg/en/{kno}/{enable}")
    public Rest<LongUser> pathUser(@PathVariable(value = "kno") String kno, @PathVariable(value = "enable") String enable){
        Rest<LongUser> rest=new Rest<>();
        LongUser longUser=new LongUser();
        longUser.setName("kno:"+kno+",enable:"+enable);
        longUser.setId(1153475471162216445L);
        rest.setData(longUser);
        return rest;
    }

    @ApiOperation(value = "字段不显示")
    @GetMapping("/allinfoweb")
    public Rest<AllInfomationWebVo> tas(){
        Rest<AllInfomationWebVo> r=new Rest<>();
        r.setData(new AllInfomationWebVo());
        return r;
    }
    @ApiOperation(value = "字段不显示1")
    @GetMapping("/allinfoweb1")
    public Rest<AllInfomationWebVo1> tas1(){
        Rest<AllInfomationWebVo1> r=new Rest<>();
        r.setData(new AllInfomationWebVo1());
        return r;
    }

    @ApiOperation(value = "下载文件-文件类型下载测试",position = 1)
    @GetMapping(value = "/downloadExcelFile",produces = "application/octet-stream")
    public void postRequest332(HttpServletRequest request, HttpServletResponse response){
        String fileName="中文需求 - 副本.xlsx";
        try {
            //此文件为本机测试
            File excelFile=new File("C:\\Users\\xiaoymin\\Desktop\\中文需求 - 副本.xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;FileName=" + URLEncoder.encode(fileName,"utf-8"));
            FileInputStream fis=new FileInputStream(excelFile);
            byte[] b=new byte[1024*1024];
            int r=-1;
            while ((r=fis.read(b))!=-1){
                response.getOutputStream().write(b,0,r);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }

    @ApiOperation(value = "下载文件-excel文件类型下载测试-非中文名",position = 1)
    @GetMapping(value = "/downloadExcelFilee",produces = "application/octet-stream")
    public void postRequest3321(HttpServletRequest request, HttpServletResponse response){
        String fileName="abc.xlsx";
        try {
            //此文件为本机测试
            File excelFile=new File("C:\\Users\\xiaoymin\\Desktop\\中文需求 - 副本.xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;FileName=" + URLEncoder.encode(fileName,"utf-8"));
            FileInputStream fis=new FileInputStream(excelFile);
            byte[] b=new byte[1024*1024];

            int r=-1;
            while ((r=fis.read(b))!=-1){
                response.getOutputStream().write(b,0,r);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }


    @ApiOperation(value = "下载文件名称为中文时乱码的情况",position = 1)
    @GetMapping(value = "/downloadFile1",produces = "application/octet-stream")
    public void postRequest2(HttpServletRequest request, HttpServletResponse response){
        download("八一菜刀",response);
    }

    private void download(String name,HttpServletResponse response){
        String fileName="我是中文名称.txt";
        try {
            response.setContentType("text/plain;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;FileName=" + URLEncoder.encode(fileName,"utf-8"));
            ByteArrayOutputStream by=new ByteArrayOutputStream();
            String content="This test Download File Api,哈哈哈,我是中文,我是无敌的,我的名字是："+name;
            by.write(content.getBytes());
            by.writeTo(response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }


}
