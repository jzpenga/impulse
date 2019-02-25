package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "外接通道参数", description = "通道参数")
public class ExtPass implements Serializable {
    @Id
    @ApiModelProperty(name = "id", value = "外接通道ID", example = "1")
    private String id;
    @ApiModelProperty(name = "passNo", value = "编号", example = "1")
    private String passNo;
    @ApiModelProperty(name = "address", value = "地址", example = "北京市海淀区西三旗街道小营东路七号院")
    private String address;
    @DBRef
    @ApiModelProperty(name = "passList", value = "通道", example = "[]")
    private List<Pass> passList;
    @ApiModelProperty(name="deleteFlag",value = "删除标志",example = "0-使用1-删除")
    private  String  deleteFlag;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;
    @ApiModelProperty(name = "userId", value = "用户id", example = "5a31bhjb123333123dsada", required = true)
    private String userId;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passNo) {
        this.passNo = passNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pass> getPassList() {
        return passList;
    }

    public void setPassList(List<Pass> passList) {
        this.passList = passList;
    }

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
