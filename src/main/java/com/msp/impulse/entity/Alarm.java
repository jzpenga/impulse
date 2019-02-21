package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "警报", description = "警报")
public class Alarm implements Serializable {
    @Id
    @ApiModelProperty(name = "id", value = "警报id", example = "1")
    private String id;
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "1")
    private String gatewayName;
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "1")
    private String sensorName;
    @ApiModelProperty(name = "passNo", value = "通道号", example = "1")
    private String passNo;
    @ApiModelProperty(name="alarmTime",value = "报警时间",example = "")
    private  Long alarmTime;
    @ApiModelProperty(name="closeTime",value = "关闭时间",example = "")
    private  Long closeTime;
    @ApiModelProperty(name="alarmStatus",value = "报警状态",example = "")
    private  String alarmStatus;
    @ApiModelProperty(name="alarmType",value = "报警类型",example = "")
    private  String alarmType;
    @ApiModelProperty(name="testValue",value = "检测值",example = "")
    private  Double testValue;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passNo) {
        this.passNo = passNo;
    }

    public Long getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Long alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Double getTestValue() {
        return testValue;
    }

    public void setTestValue(Double testValue) {
        this.testValue = testValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
