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


    private String C130;
    private String C242;
    private String C256;


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

    public String getC130() {
        return C130;
    }

    public void setC130(String c130) {
        C130 = c130;
    }

    public String getC242() {
        return C242;
    }

    public void setC242(String c242) {
        C242 = c242;
    }

    public String getC256() {
        return C256;
    }

    public void setC256(String c256) {
        C256 = c256;
    }
}
