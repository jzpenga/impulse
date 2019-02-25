package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;

@ApiModel(value = "通道", description = "通道")
public class Pass  {
    @Id
    @ApiModelProperty(name = "id", value = "通道id", example = "5be402294932ff3690e3f4ba")
    private  String id;
    @ApiModelProperty(name = "passNo", value = "通道号", example = "")
    private  String passNo;
    @ApiModelProperty(name = "alarmCeil", value = "报警上限", example = "")
    private  String alarmCeil;
    @ApiModelProperty(name = "alarmFloor", value = "报警下限", example = "")
    private  String alarmFloor;
    @ApiModelProperty(name = "ceilStatus", value = "上限状态", example = "")
    private  String ceilStatus;
    @ApiModelProperty(name = "floorStatus", value = "下限状态", example = "")
    private  String floorStatus;
    @ApiModelProperty(name = "analogZero", value = "模拟信号量程-零度", example = "")
    private  String analogZero;
    @ApiModelProperty(name = "analogFull", value = "模拟信号量程-满点", example = "")
    private  String analogFull;
    @ApiModelProperty(name = "sensorZero", value = "传感器量程-零度", example = "")
    private  String sensorZero;
    @ApiModelProperty(name = "sensorFull", value = "传感器量程-满点", example = "")
    private  String sensorFull;
    @ApiModelProperty(name = "decimalPlaces", value = "小数点位数", example = "3")
    private  String decimalPlaces;
    @ApiModelProperty(name="deleteFlag",value = "删除标志",example = "0-使用1-删除")
    private  String  deleteFlag;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;
    @ApiModelProperty(name="SensorName",value = "传感器名称",example = "")
    private  String  SensorName;
    @ApiModelProperty(name="SensorType",value = "传感类型",example = "")
    private  String  SensorType;
    @ApiModelProperty(name = "userId", value = "用户id", example = "5a31bhjb123333123dsada", required = true)
    private String userId;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passNo) {
        this.passNo = passNo;
    }

    public String getAlarmCeil() {
        return alarmCeil;
    }

    public void setAlarmCeil(String alarmCeil) {
        this.alarmCeil = alarmCeil;
    }

    public String getAlarmFloor() {
        return alarmFloor;
    }

    public void setAlarmFloor(String alarmFloor) {
        this.alarmFloor = alarmFloor;
    }

    public String getCeilStatus() {
        return ceilStatus;
    }

    public void setCeilStatus(String ceilStatus) {
        this.ceilStatus = ceilStatus;
    }

    public String getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(String floorStatus) {
        this.floorStatus = floorStatus;
    }

    public String getAnalogZero() {
        return analogZero;
    }

    public void setAnalogZero(String analogZero) {
        this.analogZero = analogZero;
    }

    public String getAnalogFull() {
        return analogFull;
    }

    public void setAnalogFull(String analogFull) {
        this.analogFull = analogFull;
    }

    public String getSensorZero() {
        return sensorZero;
    }

    public void setSensorZero(String sensorZero) {
        this.sensorZero = sensorZero;
    }

    public String getSensorFull() {
        return sensorFull;
    }

    public void setSensorFull(String sensorFull) {
        this.sensorFull = sensorFull;
    }

    public String getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(String decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
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

    public String getSensorName() {
        return SensorName;
    }

    public void setSensorName(String sensorName) {
        SensorName = sensorName;
    }

    public String getSensorType() {
        return SensorType;
    }

    public void setSensorType(String sensorType) {
        SensorType = sensorType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
