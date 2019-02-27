package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "公司", description = "公司")
public class Company  implements Serializable {
    @Id
    @ApiModelProperty(name = "id", value = "id", example = "id", required = true)
    private String id;
    @ApiModelProperty(name = "companyName", value = "公司名称", example = "殷继彤的海鲜公司", required = true)
    private String companyName;
    @ApiModelProperty(name = "province", value = "省/市", example = "河北", required = true)
    private String province;
    @ApiModelProperty(name = "city", value = "市/区", example = "唐山", required = true)
    private String city;
    @ApiModelProperty(name = "detailedAdd", value = "详细地址", example = "", required = true)
    private String detailedAdd;
    @ApiModelProperty(name = "loginName", value = "登录名", example = "殷继彤的海鲜公司", required = true)
    private String loginName;
    @ApiModelProperty(name = "password", value = "密码", example = "admin", required = true)
    private String password;
    @ApiModelProperty(name = "postalCode", value = "邮政编码", example = "100000", required = true)
    private String postalCode;
    @ApiModelProperty(name = "name", value = "姓名", example = "殷继彤", required = true)
    private String name;
    @ApiModelProperty(name = "phoneNo", value = "手机号", example = "13333333333", required = true)
    private  String phoneNo;
    @ApiModelProperty(name = "gender", value = "性别", example = "女", required = true)
    private String gender;
    @ApiModelProperty(name = "email", value = "电子邮箱", example = "aaa@bbb.com", required = true)
    private String email;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;
    @ApiModelProperty(name = "gatewayNumber", value = "网关数", example = "2", required = true)
    private Integer gatewayNumber;
    @ApiModelProperty(name = "sensorNumber", value = "传感器数", example = "2", required = true)
    private Integer sensorNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailedAdd() {
        return detailedAdd;
    }

    public void setDetailedAdd(String detailedAdd) {
        this.detailedAdd = detailedAdd;
    }

    public String getLoginName() { return loginName; }

    public void setLoginName(String loginName) { this.loginName = loginName; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getGatewayNumber() {
        return gatewayNumber;
    }

    public void setGatewayNumber(Integer gatewayNumber) {
        this.gatewayNumber = gatewayNumber;
    }

    public Integer getSensorNumber() {
        return sensorNumber;
    }

    public void setSensorNumber(Integer sensorNumber) {
        this.sensorNumber = sensorNumber;
    }
}
