/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.group;


import com.xiaominfo.knife4j.common.Language;
import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.old.EnumDomain;
import com.xiaominfo.knife4j.domain.old.Recipt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/07/25 10:18
 */
@Api(value = "枚举测试",tags = "枚举测试")
@RestController
@RequestMapping("/api/enum")
public class EnumController {

    @PostMapping("/actEumList")
    @ApiOperation(value = "简单枚举类型",notes = "递归参数-enum-简单枚举",tags = {"枚举测试"})
    public Rest<Recipt> actEumList(Language language){
        Rest<Recipt> r=new Rest<>();
        Recipt rp=new Recipt();
        rp.setName(language.name());
        r.setData(rp);
        return r;
    }
    /*@PostMapping("/actEumsList")
    @ApiOperation(value = "复杂枚举类型",notes = "递归参数-enum-复杂枚举",tags = {"枚举测试"})
    public Rest<Recipt> actEumsList(ErrorCode errorCode){
        Rest<Recipt> r=new Rest<>();
        Recipt rp=new Recipt();
        rp.setName(errorCode.getMsg()+"--"+errorCode.getCode());
        r.setData(rp);
        return r;
    }*/

    @PostMapping("/actEumssList")
    @ApiOperation(value = "复杂枚举类型-domain",notes = "递归参数-enum-复杂枚举-domain",tags = {"枚举测试"})
    public Rest<EnumDomain> actEumssList(EnumDomain ed){
        Rest<EnumDomain> r=new Rest<>();
        r.setData(ed);
        return r;
    }
}
