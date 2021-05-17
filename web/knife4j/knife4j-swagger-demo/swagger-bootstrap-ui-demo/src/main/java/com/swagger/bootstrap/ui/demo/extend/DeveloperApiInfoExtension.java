/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.extend;

import springfox.documentation.service.VendorExtension;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/05/29 14:20
 */
public class DeveloperApiInfoExtension implements VendorExtension<List<DeveloperApiInfo>> {

    private final String EXTEND_API_INFO="x-developers";

    private List<DeveloperApiInfo> developerApiInfoExtensions=new ArrayList<>();

    public DeveloperApiInfoExtension addDeveloper(DeveloperApiInfo developerApiInfo){
        developerApiInfoExtensions.add(developerApiInfo);
        return this;
    }

    @Override
    public String getName() {
        return EXTEND_API_INFO;
    }

    @Override
    public List<DeveloperApiInfo> getValue() {
        return developerApiInfoExtensions;
    }
}
