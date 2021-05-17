/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.jfinal.controller;

import cn.hutool.core.map.MapBuilder;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/01 20:07
 * @since:knife4j-jfinal-demo 1.0
 */
@Api(tags = "测试")
public class HelloController extends Controller {

    @ApiOperation(value = "欢迎语")
    @ActionKey("ccc")
    public void index(){
        renderText("Hello");
    }

    @ApiOperation(value = "响应json")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "姓名",name = "name"),
            @ApiImplicitParam(name = "address",value = "地址")
    })
    public void json(){
        System.out.println("123");
        renderJson(MapBuilder.create().put("name",getPara("name")).put("address",getPara("address")).build());
        System.out.println("abc");
    }
}
