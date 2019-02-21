package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("网关查询")
public class GatewayQuery  extends BaseRequest {
    @ApiModelProperty(name = "equipmentName", value = "设备名称", example = "")
    private String equipmentName;
    @ApiModelProperty(name = "equipmentType", value = "设备类型", example = "")
    private String equipmentType;
    @ApiModelProperty(name = "equipmentModel", value = "设备型号", example = "")
    private String equipmentModel;
    @ApiModelProperty(name = "workModel", value = "工作模式", example = "")
    private String workModel;
    @ApiModelProperty(name = "workStatus", value = "工作状态", example = "")
    private String workStatus;

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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

    public String getWorkModel() {
        return workModel;
    }

    public void setWorkModel(String workModel) {
        this.workModel = workModel;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

}
