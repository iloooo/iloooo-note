/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/10/25 9:43
 * @since:knife4j-spring-boot-demo 1.0
 */
@ApiIgnore
@RestController
@RequestMapping("/data")
public class CallBackController {

    Logger logger= LoggerFactory.getLogger(CallBackController.class);
    @RequestMapping("/callback")
    public void callback(HttpServletRequest request, HttpServletResponse response){
        logger.info("callback");
    }
}
