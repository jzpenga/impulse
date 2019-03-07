package com.msp.impulse.entity;

import java.io.Serializable;
import java.util.Date;

public class Pass implements Serializable {
    private Integer id;

    private Integer passNo;

    private String alarmCeil;

    private String alarmFloor;

    private String ceilStatus;

    private String floorStatus;

    private String analogZero;

    private String analogFull;

    private String sensorZero;

    private String sensorFull;

    private String decimalPlaces;

    private Integer gatewayId;

    private String gatewayName;

    private Integer sensorId;

    private String sensorName;

    private String sensorType;

    private Integer userId;

    private String userName;

    private Integer extPassId;

    private String extPassFlag;

    private String extPassAddress;

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

    public Integer getPassNo() {
        return passNo;
    }

    public void setPassNo(Integer passNo) {
        this.passNo = passNo;
    }

    public String getAlarmCeil() {
        return alarmCeil;
    }

    public void setAlarmCeil(String alarmCeil) {
        this.alarmCeil = alarmCeil == null ? null : alarmCeil.trim();
    }

    public String getAlarmFloor() {
        return alarmFloor;
    }

    public void setAlarmFloor(String alarmFloor) {
        this.alarmFloor = alarmFloor == null ? null : alarmFloor.trim();
    }

    public String getCeilStatus() {
        return ceilStatus;
    }

    public void setCeilStatus(String ceilStatus) {
        this.ceilStatus = ceilStatus == null ? null : ceilStatus.trim();
    }

    public String getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(String floorStatus) {
        this.floorStatus = floorStatus == null ? null : floorStatus.trim();
    }

    public String getAnalogZero() {
        return analogZero;
    }

    public void setAnalogZero(String analogZero) {
        this.analogZero = analogZero == null ? null : analogZero.trim();
    }

    public String getAnalogFull() {
        return analogFull;
    }

    public void setAnalogFull(String analogFull) {
        this.analogFull = analogFull == null ? null : analogFull.trim();
    }

    public String getSensorZero() {
        return sensorZero;
    }

    public void setSensorZero(String sensorZero) {
        this.sensorZero = sensorZero == null ? null : sensorZero.trim();
    }

    public String getSensorFull() {
        return sensorFull;
    }

    public void setSensorFull(String sensorFull) {
        this.sensorFull = sensorFull == null ? null : sensorFull.trim();
    }

    public String getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(String decimalPlaces) {
        this.decimalPlaces = decimalPlaces == null ? null : decimalPlaces.trim();
    }

    public Integer getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Integer gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName == null ? null : gatewayName.trim();
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName == null ? null : sensorName.trim();
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType == null ? null : sensorType.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getExtPassId() {
        return extPassId;
    }

    public void setExtPassId(Integer extPassId) {
        this.extPassId = extPassId;
    }

    public String getExtPassFlag() {
        return extPassFlag;
    }

    public void setExtPassFlag(String extPassFlag) {
        this.extPassFlag = extPassFlag == null ? null : extPassFlag.trim();
    }

    public String getExtPassAddress() {
        return extPassAddress;
    }

    public void setExtPassAddress(String extPassAddress) {
        this.extPassAddress = extPassAddress == null ? null : extPassAddress.trim();
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