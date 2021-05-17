/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.new2;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.resp196.LongUser;
import com.xiaominfo.knife4j.domain.resp202.KDto;
import com.xiaominfo.knife4j.domain.resp202.KDtoInfo;
import com.xiaominfo.knife4j.domain.resp202.KDtoObject;
import com.xiaominfo.knife4j.domain.resp203.InsureXmlReq;
import com.xiaominfo.knife4j.domain.resp203.TechModel;
import com.xiaominfo.knife4j.domain.resp203.UploadBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/12 9:04
 */
@Api(tags = "2.0.3版本-20200312")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 285)
@RestController
@RequestMapping("/api/nxew203")
public class Api203Constroller {

    @ApiOperation(value = "XML请求")
    @PostMapping(value = "/xml",produces = "application/xml",consumes = "application/xml")
    public String xml(@RequestBody InsureXmlReq insureXmlReq){
        ObjectMapper objectMapper = new XmlMapper();
        try {
            String result=objectMapper.writeValueAsString(insureXmlReq);
            System.out.println("result:");
            System.out.println(result   );
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }


    @ApiOperation(value = "根据内容响应不同HTTP状态码",notes = "1、code为10001时响应404<br /> 2、code为10002时状态码为201 <br/> 3、其他情况状态码为200 <br /> 4、See https://gitee.com/xiaoym/knife4j/issues/I1BKRH")
    @GetMapping("/writeResponseCodeByBusiness")
    public void writeResponseCodeByBusiness(HttpServletResponse response, @RequestParam(value = "code") String code){
        try{
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            if(StrUtil.equalsIgnoreCase(code,"10001")){
                response.setStatus(404);
                /*PrintWriter printWriter=response.getWriter();
                printWriter.write(new Gson().toJson(ImmutableMap.of("code",code,"name-x", RandomUtil.randomString(32))));
                printWriter.close();*/
            }else if(StrUtil.equalsIgnoreCase(code,"10002")){
                response.setStatus(201);
                /*PrintWriter printWriter=response.getWriter();
                printWriter.write(new Gson().toJson(ImmutableMap.of("code",code,"name-a", RandomUtil.randomString(32))));
                printWriter.close();*/
            }else{
                 response.setStatus(200);
                 PrintWriter printWriter=response.getWriter();
                 printWriter.write(new Gson().toJson(ImmutableMap.of("code",code,"name", RandomUtil.randomString(32))));
                 printWriter.close();
             }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @ApiOperation(value = "测试JSON请求下的全局header参数",notes = "see https://gitee.com/xiaoym/knife4j/issues/I1C86F")
    @PostMapping("/jsonHeader")
    public Rest<LongUser> findAlljsonheader(HttpServletRequest request, @RequestBody LongUser longUser) {
        Rest<LongUser> r=new Rest<>();
        System.out.println("参数key:x-au-token,value:"+request.getParameter("x-au-token"));
        longUser.setName(longUser.getName());
        r.setData(longUser);
        return r;
    }


    @ApiOperationSupport(ignoreParameters = "ids",author = "张飞")
    @ApiOperation(value = "GET请求参数出现NULL的情况啊")
    @GetMapping("/ex")
    public Rest<LongUser> findAll(HttpServletRequest request,LongUser longUser) {
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }

    @ApiOperation(value = "忽略参数")
    @ApiOperationSupport(ignoreParameters = {"nodes[0].knife4jUsers"},includeParameters = {"key","value"})
    @GetMapping(value = "/getUser221",consumes = "application/x-www-form-urlencoded")
    public Rest<KDto> getUse1rx(KDto kDto){
        Rest<KDto> r=new Rest<>();
        r.setData(kDto);
        return r;
    }

    @ApiOperation(value = "忽略参数-Object")
    @ApiOperationSupport(ignoreParameters = {"nodes[0].knife4jUsers"})
    @GetMapping(value = "/getUse1rxobj",consumes = "application/x-www-form-urlencoded;charset=utf-8")
    public Rest<KDtoObject> getUse1rxobj(KDtoObject kDtoObject){
        Rest<KDtoObject> r=new Rest<>();
        r.setData(kDtoObject);
        return r;
    }

    @ApiOperation(value = "忽略参数-Object1")
    @ApiOperationSupport(ignoreParameters = {"nodes[0].knife4jUsers","obj"})
    @GetMapping(value = "/getUse1rxobj1",consumes = "application/x-www-form-urlencoded;charset=utf-8")
    public Rest<KDtoInfo> getUse1s1rxobj(KDtoInfo kDtoObject){
        Rest<KDtoInfo> r=new Rest<>();
        r.setData(kDtoObject);
        return r;
    }
    @ApiOperation(value = "包含参数-Object1")
    @ApiOperationSupport(includeParameters = {"nodes[0].knife4jUsers","obj"})
    @GetMapping(value = "/getUse1rxobj1c",consumes = "application/x-www-form-urlencoded;charset=utf-8")
    public Rest<KDtoInfo> getUse1s1rxobjx(KDtoInfo kDtoObject){
        Rest<KDtoInfo> r=new Rest<>();
        r.setData(kDtoObject);
        return r;
    }

    @ApiOperation(value = "json请求url携带参数")
    @PostMapping("/urp")
    public Rest<LongUser> getParams(HttpServletRequest request,@RequestParam(value = "token")String token,@RequestBody LongUser longUser){
        Enumeration<String> params= request.getParameterNames();
        while (params.hasMoreElements()){
            String key=params.nextElement();
            String value=request.getParameter(key);
            System.out.println("key:"+key+",value:"+value);
        }
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }


    /**
     * https://gitee.com/xiaoym/knife4j/issues/I1C5OQ
     * @param request
     * @param name
     * @return
     */
    @ApiOperation(value = "多余的参数请求失败")
    @GetMapping("/getOutParams")
    public Rest<List<String>> getOutParams(HttpServletRequest request,@RequestParam(value = "name")String name){
        Enumeration<String> params= request.getParameterNames();
        List<String> paramArrs=new ArrayList<>();
        while (params.hasMoreElements()){
            String key=params.nextElement();
            String value=request.getParameter(key);
            paramArrs.add("key:"+key+",value:"+value);
        }
        Rest<List<String>> r=new Rest<>();
        r.setData(paramArrs);
        return r;
    }

    /**
     * https://gitee.com/xiaoym/knife4j/issues/I1GLPJ
     * @param response
     * @param name
     * @return
     */
    @ApiOperation(value = "在某些特殊情况下不响应数据或响应text数据-文档显示异常")
    @PostMapping("/urp2")
    public Rest<LongUser> getParam2s(HttpServletResponse response,@RequestParam(value = "name")String name){
        Rest<LongUser> r=new Rest<>();
        int romd=RandomUtil.randomInt(10);
        if (romd>5){
            LongUser longUser=new LongUser();
            longUser.setName(name);
            r.setData(longUser);
        }else{
            try{
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(200);
                PrintWriter printWriter=response.getWriter();
                printWriter.write("随机WriteText数据-random:"+romd);
                printWriter.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return r;
    }

    /**
     * https://gitee.com/xiaoym/knife4j/issues/I1GJ2O
     * @param techModel
     * @return
     */
    @ApiOperation(value = "example属性为长数字时-页面显示为科学计数法")
    @ApiOperationSupport(ignoreParameters = "techModel.allInfomationWebVo.id")
    @PostMapping("/tech")
    public Rest<TechModel> tech(@RequestBody TechModel techModel){
        return Rest.data(techModel);
    }


    @ApiOperation(value = "获取Cookie")
    @GetMapping("/getCookie")
    public Rest<String> getCookie(@RequestHeader("Cookie")String cookie,HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            System.out.println("cookie不为空");
            for (Cookie cookie1:cookies){
                System.out.println("cooke:"+cookie1.getName()+",value:"+cookie1.getValue());
            }
        }
        return Rest.data(cookie);
    }

    @ApiOperation(value = "下载zip文件")
    @GetMapping(value = "/download",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void downloadZip(HttpServletResponse response,@RequestParam(value = "fileName") String fileName){
        try{
            File file=new File("D:\\"+fileName);
            if (file.exists()){
                response.setContentType("application/zip");
                response.addHeader("Content-Disposition","attachement;filename="+RandomUtil.randomString(4)+".zip");
                OutputStream outputStream= response.getOutputStream();
                FileInputStream fileInputStream=new FileInputStream(file);
                int i=-1;
                byte[] b=new byte[1024*1024];
                while ((i=fileInputStream.read(b))!=-1){
                    outputStream.write(b,0,i);
                }
                IoUtil.close(fileInputStream);
                IoUtil.close(outputStream);
            }
        }catch (Exception e){

        }

    }

    @PostMapping("/testupload")
    public void testupload(@RequestParam(value = "file")MultipartFile multipartFile,@RequestBody UploadBody uploadBody){
        System.out.println("test");
    }

}
