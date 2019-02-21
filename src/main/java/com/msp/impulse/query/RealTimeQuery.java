package com.msp.impulse.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("实时数据查询")
public class RealTimeQuery {
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "")
    private String sensorName;
    @ApiModelProperty(name="reportDateFrom",value = "报警时间from" , example="")
    private  String  reportDateFrom;
    @ApiModelProperty(name="reportDateTo",value="报警时间to",example="")
    private  String  reportDateTo;
    @ApiModelProperty(name="MonitorType",value="监测类别",example="")
    private String MonitorType;

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

    public String getReportDateFrom() {
        return reportDateFrom;
    }

    public void setReportDateFrom(String reportDateFrom) {
        this.reportDateFrom = reportDateFrom;
    }

    public String getReportDateTo() {
        return reportDateTo;
    }

    public void setReportDateTo(String reportDateTo) {
        this.reportDateTo = reportDateTo;
    }

    public String getMonitorType() {
        return MonitorType;
    }

    public void setMonitorType(String monitorType) {
        MonitorType = monitorType;
    }
}
