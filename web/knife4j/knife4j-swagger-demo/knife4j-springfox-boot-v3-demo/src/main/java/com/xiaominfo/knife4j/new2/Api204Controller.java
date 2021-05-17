/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.new2;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.resp192.MapInfo;
import com.xiaominfo.knife4j.grn.SessionContentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/06/25 22:59
 */
@Api(tags = "2.0.4版本-20200620")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 284)
@RestController
@RequestMapping("/api/nxew204")
public class Api204Controller {

    @ApiOperation(value = "针对实体类Map字段包含类本身的Value指引")
    @GetMapping("/getInfo")
    public Rest<MapInfo> getInfo(){
        Rest<MapInfo> r=new Rest<>();
        return r;
    }

    @ApiOperation(value = "针对Map复杂类型的情况无法显示字段")
    @GetMapping("/getMapInfo")
    public Rest<SessionContentResponse> getMapInfo(){
        Rest<SessionContentResponse> responseRest=new Rest<>();
        SessionContentResponse sessionContentResponse=new SessionContentResponse();
        sessionContentResponse.setRespTime(String.valueOf(System.currentTimeMillis()));
        responseRest.setData(sessionContentResponse);
        return responseRest;
    }
    @ApiOperation(value = "根据内容响应不同HTTP状态码以及ContentType",notes = "1、code为10001时响应404<br /> 2、code为10002时状态码为201 <br/> 3、其他情况状态码为200 <br /> 4、See https://gitee.com/xiaoym/knife4j/issues/I1BKRH")
    @GetMapping("/writeResponseCodeByBusiness")
    public void writeResponseCodeByBusiness(HttpServletResponse response, @RequestParam(value = "code") String code){
        try{
            PrintWriter printWriter=response.getWriter();
            response.setCharacterEncoding("UTF-8");
            if(StrUtil.equalsIgnoreCase(code,"10001")){
                response.setStatus(404);
                //response.setStatus(201);
                //虽然响应类型是json，但是write出去却是文本
                response.setContentType("application/json");
                printWriter.write("Hello Knife4jText,code:"+code+",time:"+System.currentTimeMillis());
                printWriter.close();
            }else if(StrUtil.equalsIgnoreCase(code,"10002")){
                response.setStatus(201);
                response.setContentType("text/plain");
                printWriter.write("Hello Knife4jText,code:"+code+",time:"+System.currentTimeMillis());
                printWriter.close();
            }else{
                response.setContentType("application/json");
                response.setStatus(200);
                printWriter.write(new Gson().toJson(ImmutableMap.of("code",code,"name", RandomUtil.randomString(32))));
                printWriter.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
