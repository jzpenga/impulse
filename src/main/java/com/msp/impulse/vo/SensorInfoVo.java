package com.msp.impulse.vo;

import io.swagger.annotations.ApiModel;

@ApiModel("传感器相关信息")
public class SensorInfoVo {
    private String sensorName;
    private String deviceId;
    private String sensorModel;

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSensorModel() {
        return sensorModel;
    }

    public void setSensorModel(String sensorModel) {
        this.sensorModel = sensorModel;
    }
}
