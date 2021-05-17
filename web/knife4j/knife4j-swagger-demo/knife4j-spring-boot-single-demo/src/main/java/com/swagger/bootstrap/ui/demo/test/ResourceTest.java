/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.test;



import com.github.xiaoymin.knife4j.core.io.ResourceUtil;

import java.util.Set;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/04/30 15:36
 */
public class ResourceTest {

    public static void main(String[] args) {
        ResourceUtil ru=new ResourceUtil();
        ru.find("com.swagger.bootstrap.ui.demo.domain.old","cn.hutool.aop");
        Set<Class<?>> s= ru.getClasses();
        System.out.println("--------------------------------------");
        for (Class<?> clazz:s){
            System.out.println(clazz.getName());
        }

    }
}
