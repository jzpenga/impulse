package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("网关查询")
public class SensorQuery extends BaseRequest {
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "")
    private String sensorName;
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }
}

