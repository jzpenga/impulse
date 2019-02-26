package com.msp.impulse.nb.entity;

/**
 * 设备数据上报实体类
 */
public class DataReportEntity {

    private String deviceId;

    private String serviceId;

    private String serviceType;

    private String eventTime;

    //设备序列号
    private String equipmentNo;

    private String dataKey;
    private String dataValue;
    private String dataMark;


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
