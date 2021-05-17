/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.swagger.bootstrap.ui.demo.annotation.ApiVersion;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp187.ModeValidl187;
import com.swagger.bootstrap.ui.demo.domain.resp187.Model187;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/***
 * 1.8.6fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/11/05 08:44
 */
@Api(value = "1.8.71版本-20181105",position = 297)
@RestController
@RequestMapping(value = "/api/new187/")
public class Api1871Controller {

    @ApiOperation(value = "版本2-post请求参数Hidden属性是否生效",position = 30)
    @PostMapping("/postRequest")
    @ApiVersion("2")
    public Rest<Model187> postRequest(@RequestBody Model187 model187){
        Rest<Model187> r=new Rest<>();
        r.setData(model187);
        return r;
    }



    @ApiOperation(value = "版本3-post请求参数Hidden属性是否生效",position = 2)
    @PostMapping("/postRequest")
    @ApiVersion("3")
    public Rest<Model187> postRequest1(@RequestBody Model187 model187){
        Rest<Model187> r=new Rest<>();
        r.setData(model187);
        return r;
    }

    @ApiOperation(value = "验证@Valid注解",position = 3)
    @PostMapping("/postValidRequest")
    public Rest<ModeValidl187> postValidRequest(@Valid @RequestBody ModeValidl187 model187){
        Rest<ModeValidl187> r=new Rest<>();
        r.setData(model187);
        return r;
    }

    @ApiOperation(value = "验证@rMap",position = 4)
    @PostMapping("/rMap")
    public Rest<Map<String,Object>> rMap(@RequestBody Map params){
        Rest<Map<String,Object>> r=new Rest<>();
        r.setData(params);
        return  r;
    }

    @ApiOperation(value = "验证泛型Rest<Model187>",position = 4)
    @PostMapping("/rT")
    @Deprecated
    public Rest<Model187> rT(@RequestBody Model187 params){
        Rest<Model187> r=new Rest<>();
        params.setName("验证泛型Rest<Model187>");
        r.setData(params);
        return  r;
    }
}
