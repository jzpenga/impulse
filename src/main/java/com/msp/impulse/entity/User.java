package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "用户", description = "用户")
public class User implements Serializable {
    @ApiModelProperty(name = "name", value = "姓名", example = "殷继彤", required = true)
    private String name;
    @ApiModelProperty(name = "account", value = "账号/登录名", example = "admin", required = true)
    private String account;
    @ApiModelProperty(name = "phoneNo", value = "手机号", example = "13333333333", required = true)
    private  String phoneNo;
    @ApiModelProperty(name = "gender", value = "性别", example = "女", required = true)
    private String gender;
    @ApiModelProperty(name = "email", value = "电子邮箱", example = "aaa@bbb.com", required = true)
    private String email;
    @DBRef
    @ApiModelProperty(name = "company", value = "公司信息")
    private Company company;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
