package com.msp.impulse.entity;

import java.io.Serializable;
import java.util.Date;

public class Controlinstru implements Serializable {
    private Integer id;

    private String dealStatus;

    private String returnStatus;

    private Date downTime;

    private Date executeTime;

    private String extraMessage;

    private String gatewayName;

    private Integer wayNo;

    private String finalStatus;

    private Integer userId;

    private Integer relayId;

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

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus == null ? null : dealStatus.trim();
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus == null ? null : returnStatus.trim();
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public void setExtraMessage(String extraMessage) {
        this.extraMessage = extraMessage == null ? null : extraMessage.trim();
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName == null ? null : gatewayName.trim();
    }

    public Integer getWayNo() {
        return wayNo;
    }

    public void setWayNo(Integer wayNo) {
        this.wayNo = wayNo;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus == null ? null : finalStatus.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRelayId() {
        return relayId;
    }

    public void setRelayId(Integer relayId) {
        this.relayId = relayId;
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