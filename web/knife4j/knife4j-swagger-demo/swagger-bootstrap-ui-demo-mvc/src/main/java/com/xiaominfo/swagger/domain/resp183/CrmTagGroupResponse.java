package com.xiaominfo.swagger.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 客户标签分组响应模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel(description = "客户标签分组模型",value = "CrmTagGroupResponse")
public class CrmTagGroupResponse {

    @ApiModelProperty(value = "客户标签分组ID")
    private long id;

    @ApiModelProperty(value = "客户标签分组名称")
    private String name;

    @ApiModelProperty(value = "是否允许多选 0：否，1：是")
    private int isMore;

    @ApiModelProperty(value = "分组样式")
    private String style;

    @ApiModelProperty(value = "客户标签数据")
    private List<CrmTagResponse> tags;

    public CrmTagGroupResponse(long id, String name, int isMore, String style, List<CrmTagResponse> tags) {
        this.id = id;
        this.name = name;
        this.isMore = isMore;
        this.style = style;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsMore() {
        return isMore;
    }

    public void setIsMore(int isMore) {
        this.isMore = isMore;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public List<CrmTagResponse> getTags() {
        return tags;
    }

    public void setTags(List<CrmTagResponse> tags) {
        this.tags = tags;
    }
}
