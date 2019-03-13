package com.msp.impulse.vo;

import com.msp.impulse.entity.ServiceType;
import com.msp.impulse.nb.entity.DataReportEntity;

import java.util.List;

public class DataHistoryVo {
    private List<ServiceType> serviceType;
    private List<DataReportEntity> list;

    public List<ServiceType> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<ServiceType> serviceType) {
        this.serviceType = serviceType;
    }

    public List<DataReportEntity> getList() {
        return list;
    }

    public void setList(List<DataReportEntity> list) {
        this.list = list;
    }
}
