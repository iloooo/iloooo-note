/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/10/16 15:51
 */
@Component
public class AopDemoService {

    @Autowired
    ApplicationContext context;

    public Object getMappings() {
        test("hello aop {}" + this.getClass().getName());
        return null;
    }

    public String test(String msg) {
        System.out.println("test msg={}"+msg);
        return "yes";
    }
}
