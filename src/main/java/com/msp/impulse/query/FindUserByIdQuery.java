package com.msp.impulse.query;

import io.swagger.annotations.ApiModel;

@ApiModel("根据用户id查询")
public class FindUserByIdQuery {
    private Integer userId;
    private Integer pageNoGate;
    private Integer pageSizeGate;
    private Integer pageNoSensor;
    private Integer pageSizeSensor;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPageNoGate() {
        return pageNoGate;
    }

    public void setPageNoGate(Integer pageNoGate) {
        this.pageNoGate = pageNoGate;
    }

    public Integer getPageSizeGate() {
        return pageSizeGate;
    }

    public void setPageSizeGate(Integer pageSizeGate) {
        this.pageSizeGate = pageSizeGate;
    }

    public Integer getPageNoSensor() {
        return pageNoSensor;
    }

    public void setPageNoSensor(Integer pageNoSensor) {
        this.pageNoSensor = pageNoSensor;
    }

    public Integer getPageSizeSensor() {
        return pageSizeSensor;
    }

    public void setPageSizeSensor(Integer pageSizeSensor) {
        this.pageSizeSensor = pageSizeSensor;
    }
}
