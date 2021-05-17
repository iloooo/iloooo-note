package com.xiaominfo.knife4j.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户来源响应模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel(description = "客户来源模型",value = "CrmSourceResponse")
public class CrmSourceResponse {

    @ApiModelProperty(value = "客户来源ID")
    private int id;

    @ApiModelProperty(value = "客户来源名称")
    private String name;

    public CrmSourceResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
