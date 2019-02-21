package com.msp.impulse.vo;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.entity.Alarm;
import com.msp.impulse.entity.ControlInstru;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("首页返回数据")
public class HomePageDataVo extends BaseResponse {
    @ApiModelProperty(name = "gatewayNumber", value = "网关总个数", example = "")
    private Integer gatewayNumber;
    @ApiModelProperty(name = "gatewayOnNumber", value = "网关在线个数", example = "")
    private Integer gatewayOnNumber;
    @ApiModelProperty(name = "gatewayOffNumber", value = "网关离线个数", example = "")
    private Integer gatewayOffNumber;
    @ApiModelProperty(name = "sensorNumber", value = "传感器总个数", example = "")
    private Integer sensorNumber;
    @ApiModelProperty(name = "sensorOnNumber", value = "传感器在线个数", example = "")
    private Integer sensorOnNumber;
    @ApiModelProperty(name = "sensorOffNumber", value = "传感器离线个数", example = "")
    private Integer sensorOffNumber;
    @ApiModelProperty(name = "alarmNumber", value = "警报个数", example = "")
    private Integer alarmNumber;
    @ApiModelProperty(name = "alarmList", value = "警报", example = "")
    private List<Alarm> alarmList;
    @ApiModelProperty(name = "controlInstruList", value = "操作指令", example = "")
    private List<ControlInstru> controlInstruList;

    public HomePageDataVo() {
    }

    public HomePageDataVo(Integer gatewayNumber, Integer gatewayOnNumber, Integer gatewayOffNumber, Integer sensorNumber,
                          Integer sensorOnNumber, Integer sensorOffNumber, Integer alarmNumber,
                          List<Alarm> alarmList, List<ControlInstru> controlInstruList) {
        this.gatewayNumber = gatewayNumber;
        this.gatewayOnNumber = gatewayOnNumber;
        this.gatewayOffNumber = gatewayOffNumber;
        this.sensorNumber = sensorNumber;
        this.sensorOnNumber = sensorOnNumber;
        this.sensorOffNumber = sensorOffNumber;
        this.alarmNumber = alarmNumber;
        this.alarmList = alarmList;
        this.controlInstruList = controlInstruList;
    }

    public Integer getGatewayNumber() {
        return gatewayNumber;
    }

    public void setGatewayNumber(Integer gatewayNumber) {
        this.gatewayNumber = gatewayNumber;
    }

    public Integer getGatewayOnNumber() {
        return gatewayOnNumber;
    }

    public void setGatewayOnNumber(Integer gatewayOnNumber) {
        this.gatewayOnNumber = gatewayOnNumber;
    }

    public Integer getGatewayOffNumber() {
        return gatewayOffNumber;
    }

    public void setGatewayOffNumber(Integer gatewayOffNumber) {
        this.gatewayOffNumber = gatewayOffNumber;
    }

    public Integer getSensorNumber() {
        return sensorNumber;
    }

    public void setSensorNumber(Integer sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    public Integer getSensorOnNumber() {
        return sensorOnNumber;
    }

    public void setSensorOnNumber(Integer sensorOnNumber) {
        this.sensorOnNumber = sensorOnNumber;
    }

    public Integer getSensorOffNumber() {
        return sensorOffNumber;
    }

    public void setSensorOffNumber(Integer sensorOffNumber) {
        this.sensorOffNumber = sensorOffNumber;
    }

    public Integer getAlarmNumber() {
        return alarmNumber;
    }

    public void setAlarmNumber(Integer alarmNumber) {
        this.alarmNumber = alarmNumber;
    }

    public List<Alarm> getAlarmList() {
        return alarmList;
    }

    public void setAlarmList(List<Alarm> alarmList) {
        this.alarmList = alarmList;
    }

    public List<ControlInstru> getControlInstruList() {
        return controlInstruList;
    }

    public void setControlInstruList(List<ControlInstru> controlInstruList) {
        this.controlInstruList = controlInstruList;
    }
}
