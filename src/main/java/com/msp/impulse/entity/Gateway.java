package com.msp.impulse.entity;

import java.io.Serializable;
import java.util.Date;

public class Gateway implements Serializable {
    private Integer id;

    private String gatewayName;

    private Integer gatewayNo;

    private String gatewayType;

    private String gatewayModel;

    private String longitude;

    private String latitude;

    private String workModel;

    private String port;

    private String pollPeriod;

    private String overtimePeriod;

    private String workStatus;

    private Integer userId;

    private String loginName;

    private String flag;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName == null ? null : gatewayName.trim();
    }

    public Integer getGatewayNo() {
        return gatewayNo;
    }

    public void setGatewayNo(Integer gatewayNo) {
        this.gatewayNo = gatewayNo;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType == null ? null : gatewayType.trim();
    }

    public String getGatewayModel() {
        return gatewayModel;
    }

    public void setGatewayModel(String gatewayModel) {
        this.gatewayModel = gatewayModel == null ? null : gatewayModel.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getWorkModel() {
        return workModel;
    }

    public void setWorkModel(String workModel) {
        this.workModel = workModel == null ? null : workModel.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getPollPeriod() {
        return pollPeriod;
    }

    public void setPollPeriod(String pollPeriod) {
        this.pollPeriod = pollPeriod == null ? null : pollPeriod.trim();
    }

    public String getOvertimePeriod() {
        return overtimePeriod;
    }

    public void setOvertimePeriod(String overtimePeriod) {
        this.overtimePeriod = overtimePeriod == null ? null : overtimePeriod.trim();
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus == null ? null : workStatus.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}