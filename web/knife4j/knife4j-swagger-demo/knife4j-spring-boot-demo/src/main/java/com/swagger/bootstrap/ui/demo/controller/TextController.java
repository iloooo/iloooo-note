/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.controller;

import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/12/30 18:26
 * @since:knife4j-spring-boot-demo 1.0
 */
@RestController
@RequestMapping("/text")
public class TextController {

    @GetMapping("/trans")
    public String transfor(HttpServletRequest request, HttpServletResponse response){
        String content=HttpUtil.get("https://baijiahao.baidu.com/s?id=1687497241206416545",3000);
        response.setContentType("text/html;charset=UTF-8");

        return "";
    }
}
