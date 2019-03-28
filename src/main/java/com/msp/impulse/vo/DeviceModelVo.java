package com.msp.impulse.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "iot设备类型", description = "iot设备类型")
public class DeviceModelVo {
    private Integer id;
    private String sensorModel;
    private String iotSensorType;
    private String iotSensorTypeName;
    private String deviceType;
    private String fileName;
    private  String deviceTypeName;
    private String flag;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSensorModel() {
        return sensorModel;
    }

    public void setSensorModel(String sensorModel) {
        this.sensorModel = sensorModel;
    }

    public String getIotSensorType() {
        return iotSensorType;
    }

    public void setIotSensorType(String iotSensorType) {
        this.iotSensorType = iotSensorType;
    }

    public String getIotSensorTypeName() {
        return iotSensorTypeName;
    }

    public void setIotSensorTypeName(String iotSensorTypeName) {
        this.iotSensorTypeName = iotSensorTypeName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
