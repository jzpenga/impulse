package com.msp.impulse.dao;

import com.msp.impulse.nb.entity.DataReportEntity;

import java.util.List;

public interface DataReportDao {
    void save(DataReportEntity dataReportEntityList);

    List<DataReportEntity> findByDataMark(String dataMark);
}
