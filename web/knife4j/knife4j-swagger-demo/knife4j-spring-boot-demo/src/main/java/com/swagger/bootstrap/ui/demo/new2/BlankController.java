/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/03/07 10:42
 * @since:knife4j-spring-boot-demo 1.0
 */
@Api(tags = "我是空白菜单-20210307")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 279)
@RestController
@RequestMapping("/api/newBlank")
public class BlankController {

}
