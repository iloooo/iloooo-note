package com.swagger.bootstrap.ui.demo.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户分组响应模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel(description = "客户分组模型",value = "CrmGroupResponse")
public class CrmGroupResponse {

    @ApiModelProperty(value = "客户分组ID")
    private int id;

    @ApiModelProperty(value = "客户分组名称")
    private String name;

    public CrmGroupResponse(int id, String name) {
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
