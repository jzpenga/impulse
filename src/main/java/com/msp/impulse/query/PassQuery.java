package com.msp.impulse.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("通道查询")
public class PassQuery {
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;
    @ApiModelProperty(name = "passNo", value = "通道号", example = "")
    private String passNo;
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "")
    private String sensorName;
    @ApiModelProperty(name = "startTime", value = "开始时间", example = "")
    private Date startTime;
    @ApiModelProperty(name = "endTime", value = "结束时间", example = "")
    private Date endTime;

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passNo) {
        this.passNo = passNo;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
