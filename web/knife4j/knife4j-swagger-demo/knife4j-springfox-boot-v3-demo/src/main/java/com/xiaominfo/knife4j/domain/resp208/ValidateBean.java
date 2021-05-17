/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.domain.resp208;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/11/20 21:21
 * @since:knife4j-spring-boot-demo 1.0
 */
public class ValidateBean {

    @ApiModelProperty(value = "姓名")
    @NotBlank
    @Pattern(regexp = ".*?fw.*")
    private String name;

    @ApiModelProperty(value = "标题")
    @Pattern(regexp = ".*?ttte")
    private String title;

    @ApiModelProperty(value = "年龄")
    @Min(0)
    @Max(100)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
