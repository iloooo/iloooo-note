package com.swagger.bootstrap.ui.demo.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户字段选项响应模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel("客户字段选项模型")
public class CrmFieldParamResponse {

    @ApiModelProperty(value = "客户字段选项ID")
    private int id;

    @ApiModelProperty(value = "客户字段选项名称")
    private String name;

    public CrmFieldParamResponse(int id, String name) {
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
