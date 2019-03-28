package com.msp.impulse.vo;

import com.msp.impulse.entity.ModelService;

import java.util.Date;
import java.util.List;

public class ModelServiceVo {
    private Integer id;

    private String sensorModel;

    private String iotSensorType;

    private String deviceType;

    private String fileName;

    private Date createTime;

    private Date updateTime;

    List<ModelService> modelServiceList;

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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public List<ModelService> getModelServiceList() {
        return modelServiceList;
    }

    public void setModelServiceList(List<ModelService> modelServiceList) {
        this.modelServiceList = modelServiceList;
    }
}
