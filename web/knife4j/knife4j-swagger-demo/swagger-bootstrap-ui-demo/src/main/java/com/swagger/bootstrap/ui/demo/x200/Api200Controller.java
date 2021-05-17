/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.x200;

import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.AllInfomationWebVo;
import com.swagger.bootstrap.ui.demo.domain.resp196.LongUser;
import com.swagger.bootstrap.ui.demo.domain.resp196.TaskOrEventWebVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/12/07 19:42
 */
@Api(tags = "2.0.0版本-20191101",position = 288)
@RestController
@RequestMapping("/api/nxew200")
public class Api200Controller {


    @ApiResponses({
            @ApiResponse(code = 200,message = "成功",response = TaskOrEventWebVo.class),
            @ApiResponse(code = 400,message = "失败",response = LongUser.class),
            @ApiResponse(code = 401,message = "失败1",response = AllInfomationWebVo.class)
    })
    @ApiOperation(value = "多个response")
    @ApiImplicitParam(name = "name",value = "姓名",defaultValue = "test",required = true)
    @GetMapping("/getCurl")
    public Rest<String> getCurl(@RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();
        r.setData(name);
        return r;
    }

    @ApiImplicitParam(name = "key",value = "key姓名")
    @ApiOperation(value = "raw类型请求携带query参数")
    @PostMapping("/rawPostHeader")
    public Rest<LongUser> rawPostHeader(@RequestParam(value = "key") String key,@RequestBody LongUser longUser){
        System.out.println("key:"+key);
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return  r;
    }

    @ApiImplicitParam(name = "key",value = "key姓名")
    @ApiOperation(value = "raw类型请求携带query参数和path参数")
    @PostMapping("/rawPostHeaderPath/{id}")
    public Rest<LongUser> rawPostHeaderPath(@PathVariable("id") String id,@RequestParam(value = "key") String key,@RequestBody LongUser longUser){
        System.out.println("pathId:"+id+"key:"+key);
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return  r;
    }

}
