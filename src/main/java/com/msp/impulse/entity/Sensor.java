package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

@ApiModel(value = "传感器", description = "传感器")
public class Sensor {
    @Id
    @ApiModelProperty(name = "id", value = "传感器ID", example = "5be402294932ff3690e3f4ba")
    private  String id;
    @ApiModelProperty(name = "name", value = "传感器名称", example = "温度传感器", required = true)
    private String name;
    @ApiModelProperty(name = "sensorNo", value = "传感器序列号", example = "",required = true)
    private  String sensorNo;
    @ApiModelProperty(name = "passNumber", value = "通道数", example = "1", required = true)
    private Integer passNumber;
    @ApiModelProperty(name = "longitude", value = "经度", example = "116.46176")
    private  String  longitude;
    @ApiModelProperty(name = "latitude", value = "纬度", example = "39.905859")
    private String latitude;
    @DBRef
    @ApiModelProperty(name = "pass", value = "通道参数", example = "[]")
    private List<Pass> passList;
    @ApiModelProperty(name = "workStatus", value = "工作状态", example = "0-开 1-关")
    private String workStatus;
    @ApiModelProperty(name="deleteFlag",value = "删除标志",example = "0-使用1-删除")
    private  String  deleteFlag;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;
    @DBRef
    @ApiModelProperty(name = "gateway", value = "网管", example = "网关", required = true)
    private Gateway gateway;
    @ApiModelProperty(name = "userId", value = "用户id", example = "5a31bhjb123333123dsada", required = true)
    private String userId;


    public String getId() { return id; }

    public void setId(String id) {this.id = id; }

    public String getSensorNo() { return sensorNo; }

    public void setSensorNo(String sensorNo) { this.sensorNo = sensorNo; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getPassNumber() { return passNumber; }

    public void setPassNumber(Integer passNumber) {
        this.passNumber = passNumber;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<Pass> getPassList() {
        return passList;
    }

    public void setPassList(List<Pass> passList) {
        this.passList = passList;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getDeleteFlag() { return deleteFlag; }

    public void setDeleteFlag(String deleteFlag) { this.deleteFlag = deleteFlag; }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
