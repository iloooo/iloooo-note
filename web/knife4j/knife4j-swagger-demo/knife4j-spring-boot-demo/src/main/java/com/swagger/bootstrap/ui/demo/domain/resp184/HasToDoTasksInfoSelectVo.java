package com.swagger.bootstrap.ui.demo.domain.resp184;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by songYu on 2018/7/26 14:04
 * DESC : 已办任务信息 展示类
 */
@ApiModel(description="已办任务信息 展示类")
public class HasToDoTasksInfoSelectVo{


    /**
     * 逻辑主键 任务主键
     */
    @ApiModelProperty(value="任务主键",example="任务主键",required=true)
    private String taskId;
    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人",example="创建人",required=true)
    private String createBy;
    /**
     * 任务标题
     */
    @ApiModelProperty(value="任务标题",example="任务标题",required=true)
    private String taskTitle;
    /**
     * 任务类型
     */
    @ApiModelProperty(value="任务类型",example="任务类型",required=true)
    private String taskType;
    /**
     * 办理时间
     */
    @ApiModelProperty(value="办理时间",example="办理时间",required=true)
    private String completeTime;
    /**
     * 消耗时间
     */
    @ApiModelProperty(value="消耗时间",example="消耗时间",required=true)
    private String consumeTime;
    /**
     * 流程实例id
     */
    @ApiModelProperty(value="流程实例id",example="流程实例id",required=true)
    private String taskInstanceId;
    /**
     * 处理人串 按;划分
     */
    @ApiModelProperty(value="处理人串 按;划分",example="处理人串 按;划分",required=true)
    private String handler;
    /**
     * 实际处理人
     */
    @ApiModelProperty(value="实际处理人",example="实际处理人",required=true)
    private String actualHandler;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = "";
    }

    public String getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(String consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(String taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getActualHandler() {
        return actualHandler;
    }

    public void setActualHandler(String actualHandler) {
        this.actualHandler = actualHandler;
    }
}
