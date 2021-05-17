/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.new2;

import cn.hutool.core.io.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/10/19 12:47
 * @since:knife4j-spring-boot-demo 1.0
 */
@RestController
@ApiIgnore
@RequestMapping("/test")
public class DataController {
    @GetMapping("/json")
    public String json()  {
        return FileUtil.readString(new File("C:\\Users\\xiaoymin\\Desktop\\test.json"),"UTF-8");
    }
}
