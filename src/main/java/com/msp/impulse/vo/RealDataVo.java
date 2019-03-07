package com.msp.impulse.vo;

import com.msp.impulse.nb.entity.DataReportEntity;

import java.util.List;

public class RealDataVo{

    private Long total;
    private List<DataReportEntity> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<DataReportEntity> getList() {
        return list;
    }

    public void setList(List<DataReportEntity> list) {
        this.list = list;
    }
}
