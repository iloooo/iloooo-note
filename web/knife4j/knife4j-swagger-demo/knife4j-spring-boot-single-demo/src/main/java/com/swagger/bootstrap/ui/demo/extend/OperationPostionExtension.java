/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.extend;

import springfox.documentation.service.VendorExtension;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/05/29 22:16
 */
public class OperationPostionExtension implements VendorExtension<Integer> {
    @Override
    public String getName() {
        return "x-order";
    }

    @Override
    public Integer getValue() {
        return 1;
    }
}
