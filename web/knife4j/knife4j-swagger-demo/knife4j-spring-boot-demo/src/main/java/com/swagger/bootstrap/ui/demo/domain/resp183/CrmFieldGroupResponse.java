package com.swagger.bootstrap.ui.demo.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 客户字段分组请求模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel(description = "客户字段分组模型",value = "CrmFieldGroupResponse")
public class CrmFieldGroupResponse {

    @ApiModelProperty(value = "客户字段分组ID")
    private int id;

    @ApiModelProperty(value = "客户字段分组名称")
    private String name;

    @ApiModelProperty(value = "客户字段数据")
    private List<CrmFieldResponse> fields;

    public CrmFieldGroupResponse(int id, String name, List<CrmFieldResponse> fields) {
        this.id = id;
        this.name = name;
        this.fields = fields;
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

    public List<CrmFieldResponse> getFields() {
        return fields;
    }

    public void setFields(List<CrmFieldResponse> fields) {
        this.fields = fields;
    }
}
