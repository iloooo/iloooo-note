package com.xiaominfo.knife4j.domain.resp183;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户标签响应模型
 *
 * @author Janson
 * @date 2018-09-11
 */
@ApiModel(value = "CrmTagResponse")
public class CrmTagResponse {

    @ApiModelProperty(value = "客户标签ID")
    private long id;

    @ApiModelProperty(value = "客户标签名称")
    private String name;

    public CrmTagResponse(long id, String name) {
        this.id = id;
        this.name = name;
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
}
