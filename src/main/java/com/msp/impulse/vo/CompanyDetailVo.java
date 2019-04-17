package com.msp.impulse.vo;

import com.github.pagehelper.PageInfo;
import com.msp.impulse.entity.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "公司详细信息", description = "公司详细信息")
public class CompanyDetailVo {
    @ApiModelProperty(name = "company", value = "公司", example = "公司", required = true)
    private Company company;
    @ApiModelProperty(name = "pageBeanGateway", value = "网关列表分页", example = "网关列表分页", required = true)
    private PageInfo<Gateway> pageBeanGateway;
    @ApiModelProperty(name = "pageBeanSensor", value = "传感器列表分页", example = "传感器列表分页", required = true)
    private PageInfo<Sensor> pageBeanSensor;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public PageInfo<Gateway> getPageBeanGateway() {
        return pageBeanGateway;
    }

    public void setPageBeanGateway(PageInfo<Gateway> pageBeanGateway) {
        this.pageBeanGateway = pageBeanGateway;
    }

    public PageInfo<Sensor> getPageBeanSensor() {
        return pageBeanSensor;
    }

    public void setPageBeanSensor(PageInfo<Sensor> pageBeanSensor) {
        this.pageBeanSensor = pageBeanSensor;
    }
}
