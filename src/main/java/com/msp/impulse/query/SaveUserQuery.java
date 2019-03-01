package com.msp.impulse.query;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.Sensor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("新增用户数据")
public class SaveUserQuery {
    @ApiModelProperty(name = "gatewayList", value = "网关列表", example = "")
    private List<Gateway> gatewayList;
    @ApiModelProperty(name = "sensorList", value = "传感器列表", example = "")
    private List<Sensor> sensorList;
    @ApiModelProperty(name = "company", value = "公司", example = "")
    private Company company;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
