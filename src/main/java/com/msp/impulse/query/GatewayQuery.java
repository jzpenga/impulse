package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("网关查询")
public class GatewayQuery  extends BaseRequest {
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;
    @ApiModelProperty(name = "gatewayType", value = "网关类型", example = "")
    private String gatewayType;
    @ApiModelProperty(name = "gatewayModel", value = "网关型号", example = "")
    private String gatewayModel;
    @ApiModelProperty(name = "workModel", value = "工作模式", example = "")
    private String workModel;
    @ApiModelProperty(name = "workStatus", value = "工作状态", example = "")
    private String workStatus;
    @ApiModelProperty(name = "userId", value = "用户id", example = "")
    private Integer userId;

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public String getGatewayModel() {
        return gatewayModel;
    }

    public void setGatewayModel(String gatewayModel) {
        this.gatewayModel = gatewayModel;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
