package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;

@ApiModel(value = "管理员", description = "管理员")
public class Admin {
    @Id
    @ApiModelProperty(name = "id", value = "id", example = "1")
    private String id;
    @ApiModelProperty(name = "loginName", value = "登录名", example = "xaioa")
    private String loginName;
    @ApiModelProperty(name = "password", value = "密码", example = "123456")
    private String password;
    @ApiModelProperty(name = "phoneNo", value = "手机号", example = "13333333333")
    private String phoneNo;
    @ApiModelProperty(name = "email", value = "邮箱", example = "1326199999@163.com")
    private String email;
    @ApiModelProperty(name = "deleteFlag", value = "停用标志", example = "0-停用 1-启用")
    private String deleteFlag;
    @ApiModelProperty(name = "createTime", value = "注册时间", example = "2019-01-01 00:00:00")
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
