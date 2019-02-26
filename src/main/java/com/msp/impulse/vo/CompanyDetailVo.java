package com.msp.impulse.vo;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.Sensor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "公司详细信息", description = "公司详细信息")
public class CompanyDetailVo {
    @ApiModelProperty(name = "company", value = "公司", example = "公司", required = true)
    private Company company;
    @ApiModelProperty(name = "gatewayList", value = "网关列表", example = "网关列表", required = true)
    private List<Gateway> gatewayList;
    @ApiModelProperty(name = "sensorList", value = "传感器列表", example = "传感器列表", required = true)
    private List<Sensor> sensorList;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Gateway> getGatewayList() {
        return gatewayList;
    }

    public void setGatewayList(List<Gateway> gatewayList) {
        this.gatewayList = gatewayList;
    }

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }
}
