package com.xiaominfo.knife4j.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 数据聚合响应模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel(description = "数据聚合模型",value = "CombineResponse")
public class CombineResponse {

    @ApiModelProperty(value = "客户标签数据")
    private List<CrmTagGroupResponse> tags;

    @ApiModelProperty(value = "客户字段数据")
    private List<CrmFieldGroupResponse> fields;

    @ApiModelProperty(value = "客户分组数据")
    private List<CrmGroupResponse> groups;

    @ApiModelProperty(value = "客户来源数据")
    private List<CrmSourceResponse> sources;

    @ApiModelProperty(value = "客户阶段数据")
    private List<CrmStageResponse> stages;

    public List<CrmTagGroupResponse> getTags() {
        return tags;
    }

    public void setTags(List<CrmTagGroupResponse> tags) {
        this.tags = tags;
    }

    public List<CrmFieldGroupResponse> getFields() {
        return fields;
    }

    public void setFields(List<CrmFieldGroupResponse> fields) {
        this.fields = fields;
    }

    public List<CrmGroupResponse> getGroups() {
        return groups;
    }

    public void setGroups(List<CrmGroupResponse> groups) {
        this.groups = groups;
    }

    public List<CrmSourceResponse> getSources() {
        return sources;
    }

    public void setSources(List<CrmSourceResponse> sources) {
        this.sources = sources;
    }

    public List<CrmStageResponse> getStages() {
        return stages;
    }

    public void setStages(List<CrmStageResponse> stages) {
        this.stages = stages;
    }
}
