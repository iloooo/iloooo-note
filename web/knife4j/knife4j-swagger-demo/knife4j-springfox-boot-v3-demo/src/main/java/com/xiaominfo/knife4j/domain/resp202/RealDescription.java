/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp202;

import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/07 16:50
 */
public class RealDescription {

    @ApiModelProperty(value = "主键id",example = "12")
    private Long id;


    @ApiModelProperty(value = "姓名",example = "ABBB")
    private String name;

    @ApiModelProperty(value = "主键id1",example = "12")
    private Long id1;


    @ApiModelProperty(value = "姓名1",example = "ABBB")
    private String name1;


    @ApiModelProperty(value = "主键id2",example = "12")
    private Long id2;


    @ApiModelProperty(value = "姓名2",example = "ABBB")
    private String name2;


    @ApiModelProperty(value = "主键id3",example = "12")
    private Long id3;


    @ApiModelProperty(value = "姓名3",example = "ABBB")
    private String name3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Long getId3() {
        return id3;
    }

    public void setId3(Long id3) {
        this.id3 = id3;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }
}
