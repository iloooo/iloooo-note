/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.demo.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/***
 *
 * @since:knife4j-lower-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 14:48
 */
@Api(tags = "测试")
@RestController
@RequestMapping("/api")
public class HelloController {
    Logger logger= LoggerFactory.getLogger(HelloController.class);

    @ApiOperation(value = "sayHelo")
    @GetMapping("/hello")
    public ResponseEntity<String> hello(String name){
        return ResponseEntity.ok("Hello"+name);
    }

    @ApiOperation(value = "POST请求下载文件-Excel",position = 1)
    @PostMapping(value = "/downloadJsonFile2",produces = "application/octet-stream")
    public void postRequest3(HttpServletRequest request, HttpServletResponse response){
        String fileName="中文需求.xlsx";
        try {
            //此文件为本机测试
            File excelFile=new File("C:\\Users\\xiaoymin\\Desktop\\test.xlsx");
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
}
