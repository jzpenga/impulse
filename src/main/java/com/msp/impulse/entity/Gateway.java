package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "网关", description = "网关")
public class Gateway implements Serializable {
    @Id
    @ApiModelProperty(name = "id", value = "网关ID", example = "1")
    private String id;
    @ApiModelProperty(name = "equipmentName", value = "设备名称", example = "")
    private String equipmentName;
    @ApiModelProperty(name = "equipmentNo", value = "设备序列号", example = "")
    private Integer equipmentNo;
    @ApiModelProperty(name = "equipmentType", value = "设备类型", example = "")
    private String equipmentType;
    @ApiModelProperty(name = "equipmentModel", value = "设备型号", example = "")
    private String equipmentModel;

//    @ApiModelProperty(name = "totalPass", value = "总通道数", example = "100")
//    private Integer totalPass;
//    @ApiModelProperty(name = "usablePass", value = "可用通道数", example = "50")
//    private Integer usablePass;

    @ApiModelProperty(name = "longitude", value = "经度", example = "116.46176")
    private String longitude;
    @ApiModelProperty(name = "latitude", value = "纬度", example = "39.905859")
    private String latitude;
    @ApiModelProperty(name = "workModel", value = "工作模式", example = "")
    private String workModel;
    @ApiModelProperty(name = "port", value = "端口号", example = "8080")
    private String port;

//    @ApiModelProperty(name = "relayNumber", value = "继电器数量", example = "")
//    private Integer relayNumber;

    @ApiModelProperty(name = "pollPeriod", value = "轮询周期", example = "")
    private String pollPeriod;
    @ApiModelProperty(name = "overtimePeriod", value = "超时周期", example = "")
    private String overtimePeriod;
    @DBRef
    @ApiModelProperty(name = "pass", value = "通道参数", example = "[]")
    private List<Pass> passList;
    @DBRef
    @ApiModelProperty(name = "extPass", value = "外接通道参数", example = "[]")
    private ExtPass extPass;
    @DBRef
    @ApiModelProperty(name = "relayList", value = "继电器", example = "[]")
    private  List<Relay> relayList;
    @ApiModelProperty(name = "workStatus", value = "工作状态", example = "0-开 1-关")
    private String workStatus;
    @ApiModelProperty(name="deleteFlag",value = "删除标志",example = "0-使用1-删除")
    private  String  deleteFlag;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;
    @ApiModelProperty(name = "userId", value = "用户id", example = "5a31bhjb123333123dsada", required = true)
    private String userId;

    private String deviceId;
    private String loginName;


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Integer getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(Integer equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
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

    public String getWorkModel() {
        return workModel;
    }

    public void setWorkModel(String workModel) {
        this.workModel = workModel;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getPollPeriod() {
        return pollPeriod;
    }

    public void setPollPeriod(String pollPeriod) {
        this.pollPeriod = pollPeriod;
    }

    public String getOvertimePeriod() {
        return overtimePeriod;
    }

    public void setOvertimePeriod(String overtimePeriod) {
        this.overtimePeriod = overtimePeriod;
    }

    public List<Pass> getPassList() {
        return passList;
    }

    public void setPassList(List<Pass> passList) {
        this.passList = passList;
    }

    public ExtPass getExtPass() {
        return extPass;
    }

    public void setExtPass(ExtPass extPass) {
        this.extPass = extPass;
    }

    public List<Relay> getRelayList() { return relayList; }

    public void setRelayList(List<Relay> relayList) { this.relayList = relayList; }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
