package com.xiaominfo.swagger.domain.resp185;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value="User",description="系统管理员用户表")
public class User  implements java.io.Serializable {

	/**
	 *  serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	

     @ApiModelProperty(value="用户ID")
     private Long userId;

     @ApiModelProperty(value="登录名")
     private String accountName;

     @ApiModelProperty(value="昵称")
     private String nickName;

     @ApiModelProperty(value="创建日期")
     private Date createTime;

     @ApiModelProperty(value="密码")
     private String userPassword;

     @ApiModelProperty(value="是否管理员")
     private boolean admin;

     @ApiModelProperty(value="是否启用, 描述：0 为失效 （false），1 为正常（true）")
     private boolean enabled;

     @ApiModelProperty(value="最后登录时间")
     private Date lastLogin;

     @ApiModelProperty(value="优先级")
     private int priority;

     @ApiModelProperty(value="是否软删除")
     private boolean softDelete;

     @ApiModelProperty(value="登录令牌")
     private String accessToken;

     @ApiModelProperty(value="令牌失效时间")
     private Date accessTokenExpire;

     @ApiModelProperty(value="最后登录IP")
     private String lastLoginIp;


    public User() {
    }

	
    public User(String accountName, Date createTime, String userPassword, boolean admin, boolean enabled, int priority, boolean softDelete) {
        this.accountName = accountName;
        this.createTime = createTime;
        this.userPassword = userPassword;
        this.admin = admin;
        this.enabled = enabled;
        this.priority = priority;
        this.softDelete = softDelete;
    }

   
	/**
	*字段名称:用户ID
	*/
    public Long getUserId() {
        return this.userId;
    }
    
	/**
	*字段名称:用户ID
	*/
    public void setUserId(Long userId) {
        this.userId = userId;
    }
	/**
	*字段名称:登录名
	*/
    public String getAccountName() {
        return this.accountName;
    }
    
	/**
	*字段名称:登录名
	*/
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
	/**
	*字段名称:昵称
	*/
    public String getNickName() {
        return this.nickName;
    }
    
	/**
	*字段名称:昵称
	*/
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
	/**
	*字段名称:创建日期
	*/
    public Date getCreateTime() {
        return this.createTime;
    }
    
	/**
	*字段名称:创建日期
	*/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	/**
	*字段名称:密码
	*/
    public String getUserPassword() {
        return this.userPassword;
    }
    
	/**
	*字段名称:密码
	*/
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public boolean isAdmin() {
        return this.admin;
    }
    
	/**
	*字段名称:是否管理员
	*/
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public boolean isEnabled() {
        return this.enabled;
    }
    
	/**
	*字段名称:是否启用
	*字段描述:0 为失效 （false），1 为正常（true）
	*/
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
	/**
	*字段名称:最后登录时间
	*/
    public Date getLastLogin() {
        return this.lastLogin;
    }
    
	/**
	*字段名称:最后登录时间
	*/
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
	/**
	*字段名称:优先级
	*/
    public int getPriority() {
        return this.priority;
    }
    
	/**
	*字段名称:优先级
	*/
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public boolean isSoftDelete() {
        return this.softDelete;
    }
    
	/**
	*字段名称:是否软删除
	*/
    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }
	/**
	*字段名称:登录令牌
	*/
    public String getAccessToken() {
        return this.accessToken;
    }
    
	/**
	*字段名称:登录令牌
	*/
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
	/**
	*字段名称:令牌失效时间
	*/
    public Date getAccessTokenExpire() {
        return this.accessTokenExpire;
    }
    
	/**
	*字段名称:令牌失效时间
	*/
    public void setAccessTokenExpire(Date accessTokenExpire) {
        this.accessTokenExpire = accessTokenExpire;
    }
	/**
	*字段名称:最后登录IP
	*/
    public String getLastLoginIp() {
        return this.lastLoginIp;
    }
    
	/**
	*字段名称:最后登录IP
	*/
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }




}


