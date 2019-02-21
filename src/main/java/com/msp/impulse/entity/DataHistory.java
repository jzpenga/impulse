package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "实时数据", description = "实时数据")
public class DataHistory {
    @ApiModelProperty(name = "wayNo", value = "通道号", example = "")
    private Integer wayNo;
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "", required = true)
    private  String   gatewayName;
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "", required = true)
    private  String   sensorName;
    @ApiModelProperty(name = "value", value = "数据", example = "", required = true)
    private BigDecimal value;
    @ApiModelProperty(name = "reportDate", value = "上报日期", example = "2019-01-01", required = true)
    private Date reportDate;
    @ApiModelProperty(name = "SensorType", value = "检测类别", example = "", required = true)
    private String SensorType;

    public Integer getWayNo() {
        return wayNo;
    }

    public void setWayNo(Integer wayNo) {
        this.wayNo = wayNo;
    }

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

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getSensorType() {
        return SensorType;
    }

    public void setSensorType(String sensorType) {
        SensorType = sensorType;
    }
}
