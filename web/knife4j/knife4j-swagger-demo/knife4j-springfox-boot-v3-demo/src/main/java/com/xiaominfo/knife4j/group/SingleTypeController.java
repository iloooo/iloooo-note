/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.group;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/14 9:36
 */
@Api(value = "基础类型",tags = "基础类型")
@RestController
@RequestMapping("/api/single")
public class SingleTypeController {

    @GetMapping(value = "/apiboole")
    @ApiOperation(value = "Boolean类型返回")
    public Boolean booleanapi(){
        return false;
    }
}
