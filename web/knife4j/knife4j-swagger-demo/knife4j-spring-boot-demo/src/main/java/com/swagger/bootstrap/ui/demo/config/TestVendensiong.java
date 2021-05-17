/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.config;

import springfox.documentation.service.ListVendorExtension;

import java.util.List;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/10/23 21:02
 * @since:knife4j-spring-boot-demo 1.0
 */
public class TestVendensiong extends ListVendorExtension<ExtendFile> {

    public TestVendensiong(String name, List<ExtendFile> values) {
        super(name, values);
    }
}
