package com.msp.impulse.vo;

import com.msp.impulse.entity.ServiceType;

import java.util.List;
import java.util.Map;

public class DataHistoryMapVo {
    private List<ServiceType> serviceType;
    private List<Map<String, String>> list;

    public List<ServiceType> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<ServiceType> serviceType) {
        this.serviceType = serviceType;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(List<Map<String, String>> list) {
        this.list = list;
    }
}
