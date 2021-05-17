/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/06/27 20:00
 */
public class SessionContentResponse {
    @ApiModelProperty(value = "时间")
    private String respTime;

    @ApiModelProperty(value = "快显消息列表 " +
            "数据结构是Map<String,Map<Long, List<UserMessageRecordVO>>> 的格式;" +
            "第一层Map，用于区分发信和收信，Key为‘to’（发信），‘from’（收信）" +
            "第二层Map Key是消息ID，Value是对应消息" +
            "最内层List 是该条消息的不同收件人和消息内容")
    private Map<String, Map<Long, List<UserMessageRecordVO>>> msgList;


    /**
     * Gets msgList.
     *
     * @return Value of msgList.
     */
    public Map<String, Map<Long, List<UserMessageRecordVO>>> getMsgList() {
        return msgList;
    }

    /**
     * Sets new msgList.
     *
     * @param msgList New value of msgList.
     */
    public void setMsgList(Map<String, Map<Long, List<UserMessageRecordVO>>> msgList) {
        this.msgList = msgList;
    }

    public String getRespTime() {
        return respTime;
    }

    public void setRespTime(String respTime) {
        this.respTime = respTime;
    }
}
