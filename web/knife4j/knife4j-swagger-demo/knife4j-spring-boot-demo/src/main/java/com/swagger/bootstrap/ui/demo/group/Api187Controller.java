/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import cn.hutool.core.collection.CollectionUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp186.Model186;
import com.swagger.bootstrap.ui.demo.domain.resp187.Model187;
import com.swagger.bootstrap.ui.demo.domain.resp187.Model1871;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/***
 * 1.8.6fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/11/05 08:44
 */
@Api(tags = "1.8.7版本-20181105",position = 298)
@ApiSort(1)
@RestController
@RequestMapping(value = "/api/new187/")
public class Api187Controller {

    @ApiOperation(value = "参数为Map的情9况",position = 1)
    @PostMapping("/paramMap")
    public Rest<Map<String,Object>> paramTooLong(@RequestParam Map<String,Object> params){
        Rest<Map<String,Object>> r=new Rest<>();
        r.setData(params);
        return r;
    }

    @ApiOperation(value = "响应多条",position = 1)
    @PostMapping("/responseMulti")
    public Rest<List<Model186>> paramTooLong(String name){
        Rest<List<Model186>> r=new Rest<>();
        List<Model186> model186List= CollectionUtil.newArrayList();
        for (int i=0;i<100 ;i++){
            Model186 m=new Model186();
            m.setName(name+"i");
            m.setTotal(new BigDecimal(i));
            m.setZhegecanshuhenchanghenchanghenchanghenchang("nnnnnnnnnnnnnnnn"+name+"------------"+i);
            model186List.add(m);
        }
        r.setData(model186List);

        return r;
    }



    @ApiOperation(value = "post请求参数Hidden属性是否生效",position = 3)
    @PostMapping("/postRequest")
    public Rest<Model187> postRequest(@RequestBody Model187 model187){
        Rest<Model187> r=new Rest<>();
        r.setData(model187);
        return r;
    }
    @ApiOperation(value = "get请求参数Hidden属性是否生效",position = 3)
    @PostMapping("/getRequest")
    public Rest<Model187> getRequest(Model187 model187){
        Rest<Model187> r=new Rest<>();
        r.setData(model187);
        return r;
    }
    @ApiOperation(value = "get1请求参数Hidden属性是否生效",position = 3)
    @PostMapping("/getRequest1")
    public Rest<Model1871> getRequest1(Model1871 model187){
        Rest<Model1871> r=new Rest<>();
        r.setData(model187);
        return r;
    }
}
