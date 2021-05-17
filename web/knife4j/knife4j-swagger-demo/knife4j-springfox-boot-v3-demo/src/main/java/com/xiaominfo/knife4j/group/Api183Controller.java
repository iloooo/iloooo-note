/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.group;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.google.common.collect.Lists;
import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.old.MulRequest;
import com.xiaominfo.knife4j.domain.resp183.CombineResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * 1.8.2fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/21 12:44
 */
@Api(value = "1.8.3版本",tags = "1.8.3版本")
@ApiSort(302)
@RestController
@RequestMapping(value = "/api/new183/")
public class Api183Controller {


    @PostMapping("/deepResponseModel")
    @ApiOperation(value = "多层model不显示bug")
    public Rest<CombineResponse> mulrequest(@RequestBody CombineResponse mulRequest){
        Rest<CombineResponse> r=new Rest<>();
        r.setData(mulRequest);
        return r;
    }

    /***
     * 泛型返回List类型
     * @param mulRequest
     * @return
     */
    @PostMapping("/mulListResponse")
    @ApiOperation(value = "泛型返回List类型")
    public Rest<List<MulRequest>> mulListResponse(@RequestBody MulRequest mulRequest){
        Rest<List<MulRequest>> m=new Rest<>();
        List<MulRequest> list=Lists.newArrayList(mulRequest);
        m.setData(list);
        return m;
    }

    @DeleteMapping("/requestQuery")
    @ApiOperation(value = "delete-RequestQuery参数类型请求接口")
    public Rest<String> requestHeader(@RequestHeader(name = "key") String key,
                                      @RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();
        r.setData(key+"------name:"+name);
        return r;
    }

    @PostMapping(value = "/formdata",consumes = "multipart/form-data")
    @ApiOperation(value = "formdata参数类型请求")
    public Rest<String> formdata(@RequestParam(name = "key") String key,
                                      @RequestParam(value = "name") String name){
        Rest<String> r=new Rest<>();
        r.setData("formdata key:"+key+"------name:"+name);
        return r;
    }



}
