package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("实时数据查询")
public class DataHistoryQuery extends BaseRequest {
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "", required = true)
    private  String   gatewayName;
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "", required = true)
    private  String   sensorName;
    @ApiModelProperty(name = "value", value = "数据", example = "", required = true)
    private BigDecimal value;
    @ApiModelProperty(name = "reportDateFrom", value = "上报日期from", example = "2019-01-01", required = true)
    private String reportDateFrom;
    @ApiModelProperty(name = "reportDateTo", value = "上报日期to", example = "2019-01-01", required = true)
    private String reportDateTo;
    @ApiModelProperty(name = "sensorType", value = "检测类别", example = "", required = true)
    private String sensorType;
    @ApiModelProperty(name = "wayNo", value = "通道号", example = "")
    private Integer wayNo;
    @ApiModelProperty(name = "userId", value = "用户id", example = "")
    private Integer userId;
    @ApiModelProperty(name = "sensorModel", value = "设备型号", example = "")
    private String sensorModel;
    @ApiModelProperty(name = "deviceId", value = "设备型号", example = "")
    private String deviceId;

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getReportDateTo() {
        return reportDateTo;
    }

    public void setReportDateTo(String reportDateTo) {
        this.reportDateTo = reportDateTo;
    }

    public String getReportDateFrom() {
        return reportDateFrom;
    }

    public void setReportDateFrom(String reportDateFrom) {
        this.reportDateFrom = reportDateFrom;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Integer getWayNo() {
        return wayNo;
    }

    public void setWayNo(Integer wayNo) {
        this.wayNo = wayNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSensorModel() {
        return sensorModel;
    }

    public void setSensorModel(String sensorModel) {
        this.sensorModel = sensorModel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
