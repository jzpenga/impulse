package com.msp.impulse.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("报警查询")
public class AlarmQuery{
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "")
    private String sensorName;
    @ApiModelProperty(name = "alarmType", value = "报警类型", example = "")
    private String alarmType;
    @ApiModelProperty(name = "alarmStatus", value = "报警状态", example = "")
    private String alarmStatus;
    @ApiModelProperty(name="alarmDateFrom",value = "报警时间from" , example="")
    private  String  alarmDateFrom;
    @ApiModelProperty(name="alarmDateTo",value="报警时间to",example="")
    private  String  alarmDateTo;
    @ApiModelProperty(name="closeDateFrom",value="关闭时间from",example="")
    private String closeDateFrom;
    @ApiModelProperty(name="closeDateTo",value="关闭时间to",example="")
    private  String  closeDateTo;

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

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }


    public String getAlarmDateFrom() {
        return alarmDateFrom;
    }

    public void setAlarmDateFrom(String alarmDateFrom) {
        this.alarmDateFrom = alarmDateFrom;
    }

    public String getAlarmDateTo() {
        return alarmDateTo;
    }

    public void setAlarmDateTo(String alarmDateTo) {
        this.alarmDateTo = alarmDateTo;
    }

    public String getCloseDateFrom() {
        return closeDateFrom;
    }

    public void setCloseDateFrom(String closeDateFrom) {
        this.closeDateFrom = closeDateFrom;
    }

    public String getCloseDateTo() {
        return closeDateTo;
    }

    public void setCloseDateTo(String closeDateTo) {
        this.closeDateTo = closeDateTo;
    }
}
