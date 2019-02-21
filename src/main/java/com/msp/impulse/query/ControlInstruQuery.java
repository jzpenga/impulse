package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("控制指令查询")
public class ControlInstruQuery extends BaseRequest {
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;
    @ApiModelProperty(name = "executeStatus", value = "开关状态", example = "0-开 1-关", required = true)
    private String  executeStatus;
    @ApiModelProperty(name = "downTimeStart", value = "下发时间开始", example = "", required = true)
    private String downTimeStart;
    @ApiModelProperty(name = "downTimeEnd", value = "下发时间结束", example = "", required = true)
    private String  downTimeEnd;
    @ApiModelProperty(name = "dealStatus", value = "处理状态", example = "0-开 1-关", required = true)
    private String  dealStatus;
    @ApiModelProperty(name = "executeTimeStart", value = "执行时间开始", example = "", required = true)
    private  String   executeTimeStart;
    @ApiModelProperty(name = "executeTimeEnd", value = "执行时间结束", example = "", required = true)
    private  String  executeTimeEnd;

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getExecuteStatus() {
        return executeStatus;
    }

    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus;
    }

    public String getDownTimeStart() {
        return downTimeStart;
    }

    public void setDownTimeStart(String downTimeStart) {
        this.downTimeStart = downTimeStart;
    }

    public String getDownTimeEnd() {
        return downTimeEnd;
    }

    public void setDownTimeEnd(String downTimeEnd) {
        this.downTimeEnd = downTimeEnd;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getExecuteTimeStart() {
        return executeTimeStart;
    }

    public void setExecuteTimeStart(String executeTimeStart) {
        this.executeTimeStart = executeTimeStart;
    }

    public String getExecuteTimeEnd() {
        return executeTimeEnd;
    }

    public void setExecuteTimeEnd(String executeTimeEnd) {
        this.executeTimeEnd = executeTimeEnd;
    }
}
