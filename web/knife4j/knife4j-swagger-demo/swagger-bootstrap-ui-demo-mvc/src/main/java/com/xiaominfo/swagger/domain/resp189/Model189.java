/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.swagger.domain.resp189;

import com.xiaominfo.swagger.domain.resp187.MetaModel;

import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/01/09 17:21
 */
public class Model189 {

    private String name;

    private List<List<MetaModel>> metaModels;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<MetaModel>> getMetaModels() {
        return metaModels;
    }

    public void setMetaModels(List<List<MetaModel>> metaModels) {
        this.metaModels = metaModels;
    }
}
