package com.msp.impulse.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("控制指令修改")
public class ControllnstruUpdateQuery {
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;
    @ApiModelProperty(name = "wayNo", value = "路数", example = "")
    private  Integer wayNo;
    @ApiModelProperty(name = "switchOperation", value = "开关操作 0-开 1-关", example = "")
    private  String switchOperation;
    @ApiModelProperty(name = "extraMessage", value = "附加信息", example = "")
    private  String extraMessage;

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public Integer getWayNo() {
        return wayNo;
    }

    public void setWayNo(Integer wayNo) {
        this.wayNo = wayNo;
    }

    public String getSwitchOperation() {
        return switchOperation;
    }

    public void setSwitchOperation(String switchOperation) {
        this.switchOperation = switchOperation;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public void setExtraMessage(String extraMessage) {
        this.extraMessage = extraMessage;
    }
}
