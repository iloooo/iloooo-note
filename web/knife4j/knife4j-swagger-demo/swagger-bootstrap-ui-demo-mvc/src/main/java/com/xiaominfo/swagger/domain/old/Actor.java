/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.swagger.domain.old;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/07/25 7:45
 */
public class Actor {

    private Recipt recipt;

    private String address;
    private Integer sort;

    private DeepOne deepOne;

    public DeepOne getDeepOne() {
        return deepOne;
    }

    public void setDeepOne(DeepOne deepOne) {
        this.deepOne = deepOne;
    }

    public Recipt getRecipt() {
        return recipt;
    }

    public void setRecipt(Recipt recipt) {
        this.recipt = recipt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
