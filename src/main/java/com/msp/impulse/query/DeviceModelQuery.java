package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import org.springframework.web.multipart.MultipartFile;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DeviceModelQuery extends BaseRequest implements Serializable {
    private Integer id;

    private String sensorModel;

    private String iotSensorType;

    private String deviceType;

    private String fileName;

    private String flag;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String state;

    private MultipartFile file;

    private List<Integer> modelServiceIds;

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
        this.state = state;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public List<Integer> getModelServiceIds() {
        return modelServiceIds;
    }

    public void setModelServiceIds(List<Integer> modelServiceIds) {
        this.modelServiceIds = modelServiceIds;
    }
}
