/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp188;

import java.util.HashMap;
import java.util.Map;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/12/09 15:41
 */
public enum  Tags {

    FamilyUser(1,"家人"),
    Fridens(2,"朋友");

    public static final Map<Integer,String > valueMap=new HashMap<>();
    static
    {
        for (Tags tag:Tags.values()){
            valueMap.put(tag.index,tag.name);
        }
    }

    Tags(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    private Integer index;
    private String name;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
