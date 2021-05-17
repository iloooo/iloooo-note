package com.xiaominfo.knife4j.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户阶段响应模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel(description = "客户阶段模型",value = "CrmStageResponse")
public class CrmStageResponse {

    @ApiModelProperty(value = "客户阶段")
    private int stage;

    @ApiModelProperty(value = "客户阶段名称")
    private String name;

    public CrmStageResponse(int stage, String name) {
        this.stage = stage;
        this.name = name;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
