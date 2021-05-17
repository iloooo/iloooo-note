/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp184;

import com.swagger.bootstrap.ui.demo.domain.old.Menu;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/09/18 20:02
 */
public class SampleArray {
    private String sarrName;

    private Menu menu;

    @ApiModelProperty(value = "示例1")
    private List<SampleObject> sample1;

    @ApiModelProperty(value = "示例2")
    private List<SampleObject> sample2;


    public String getSarrName() {
        return sarrName;
    }

    public void setSarrName(String sarrName) {
        this.sarrName = sarrName;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<SampleObject> getSample1() {
        return sample1;
    }

    public void setSample1(List<SampleObject> sample1) {
        this.sample1 = sample1;
    }

    public List<SampleObject> getSample2() {
        return sample2;
    }

    public void setSample2(List<SampleObject> sample2) {
        this.sample2 = sample2;
    }
}
