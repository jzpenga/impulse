package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "控制指令", description = "控制指令")
public class ControlInstru implements Serializable {

    @DBRef
    @ApiModelProperty(name = "relay", value = "继电器", example = "", required = true)
    private Relay relay;
    @ApiModelProperty(name = "dealStatus", value = "处理状态", example = "0-开 1-关", required = true)
    private String  dealStatus;
    @ApiModelProperty(name = "returnStatus", value = "返回状态", example = "0-失败 1-成功", required = true)
    private String  returnStatus;
    @ApiModelProperty(name = "downTime", value = "下发时间", example = "", required = true)
    private  Date  downTime;
    @ApiModelProperty(name = "executeTime", value = "执行时间", example = "", required = true)
    private  Date  executeTime;
    @ApiModelProperty(name = "executeTime", value = "附加信息", example = "", required = true)
    private  String   extraMessage;
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "", required = true)
    private  String   gatewayName;
    @ApiModelProperty(name = "wayNo", value = "路数", example = "", required = true)
    private  Integer   wayNo;
    @ApiModelProperty(name = "finalStatus", value = "最终状态", example = "0-开 1-关", required = true)
    private String  finalStatus;
    @ApiModelProperty(name = "updateTime", value = "更新时间", example = "2019-01-01 00:00:00", required = true)
    private Date updateTime;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;

    public Relay getRelay() {
        return relay;
    }

    public void setRelay(Relay relay) {
        this.relay = relay;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
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
        this.extraMessage = extraMessage;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
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
        this.finalStatus = finalStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
