package com.msp.impulse.nb.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 设备数据上报实体类
 */
public class DataReportEntity {

    @Id
    private String id;
    private String deviceId;

    private String serviceId;

    private String serviceType;

    private String eventTime;

    //设备序列号
    private String equipmentNo;

    private  String dataKeyName;
    private String dataKey;
    private String dataValue;
    private String dataMark;
    private String sensorName;
    private String gatewayName;
    private  Integer userId;
    private  String userName;
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo;
    }


    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataMark() {
        return dataMark;
    }

    public void setDataMark(String dataMark) {
        this.dataMark = dataMark;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDataKeyName() {
        return dataKeyName;
    }

    public void setDataKeyName(String dataKeyName) {
        this.dataKeyName = dataKeyName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DataReportEntity{" +
                "deviceId='" + deviceId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", equipmentNo='" + equipmentNo + '\'' +
                ", dataKey='" + dataKey + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", dataMark='" + dataMark + '\'' +
                '}';
    }
}
