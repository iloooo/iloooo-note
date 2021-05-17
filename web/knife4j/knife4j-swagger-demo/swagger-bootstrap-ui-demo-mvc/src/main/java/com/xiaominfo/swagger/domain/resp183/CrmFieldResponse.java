package com.xiaominfo.swagger.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 客户字段响应模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel(description = "客户字段模型",value = "CrmFieldResponse")
public class CrmFieldResponse {

    @ApiModelProperty(value = "客户字段ID")
    private int id;

    @ApiModelProperty(value = "客户字段名称")
    private String name;

    @ApiModelProperty(value = "客户系统字段标识 范围：1~18")
    private int flag;

    @ApiModelProperty(value = "是否必填 0：否，1：是")
    private int isMust;

    @ApiModelProperty(value = "字段类型 input：文本，time：时间，currency：货币，select：下拉，radio：单选，checkbox：复选，selectinput：下拉文本组合")
    private String type;

    @ApiModelProperty(value = "客户字段选项数据")
    private List<CrmFieldParamResponse> params;

    public CrmFieldResponse(int id, String name, int flag, int isMust, String type, List<CrmFieldParamResponse> params) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.isMust = isMust;
        this.type = type;
        this.params = params;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getIsMust() {
        return isMust;
    }

    public void setIsMust(int isMust) {
        this.isMust = isMust;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CrmFieldParamResponse> getParams() {
        return params;
    }

    public void setParams(List<CrmFieldParamResponse> params) {
        this.params = params;
    }
}
