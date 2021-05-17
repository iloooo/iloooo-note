/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import cn.hutool.core.date.DateTime;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp189.ModelMoreField;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.*;

/***
 * 1.9.0fixed bug修改
 * @since:swagger-bootstrap-ui 1.9.1
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019-3-5 18:53:45
 */
@Api(tags = "1.9.1版本-20190305",position = 294)
@RestController
@RequestMapping(value = "/api/new191/")
public class Api191Controller {


    @ApiOperation(value = "example属性丢失")
    @PostMapping("/notExample")
    public Rest<ModelMoreField> notfied(@ApiIgnore HttpSession httpSession, @RequestBody ModelMoreField modelMoreField){
        Rest<ModelMoreField> r=new Rest<>();
        System.out.println("dddddddddd");

        r.setData(modelMoreField);
        return r;
    }





    @ApiResponses({
            @ApiResponse(code = 1,message = "测试")
    })
    @ApiOperation(value = "apiResponse自定义后字段description丢失")
    @PostMapping("/findAll1")
    public Rest<List<ModelMoreField>> findAll1(@RequestParam(value = "size",defaultValue = "1000") Integer size){
        Rest<List<ModelMoreField>> r=new Rest<>();
        List<ModelMoreField> modelMoreFields=new ArrayList<>();
        ModelMoreField m1=new ModelMoreField();
        m1.setAddress("浙江省杭州市文一西路22号杭州大厦18幢393浙江省杭州市文一西路22号杭州大厦18幢393浙江省杭州市文一西路22号杭州大厦18幢393浙江省杭州市文一西路22号杭州大厦18幢393浙江省杭州市文一西路22号杭州大厦18幢393浙江省杭州市文一西路22号杭州大厦18幢393浙江省杭州市文一西路22号杭州大厦18幢393");
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
}
