package com.msp.impulse.dao;

import com.msp.impulse.entity.PageBean;
import com.msp.impulse.entity.RealTimeData;
import com.msp.impulse.query.DataHistoryQuery;

import java.util.List;

public interface RealTimeDataDao {
    RealTimeData  selectByDeviceIdAndDataKey(String deviceId,String dataKey);
    void save(RealTimeData realTimeData);

    PageBean selectRealTimeDataInfo(DataHistoryQuery dataHistoryQuery);

    List<RealTimeData> selectByDeviceId(String deviceId);

    void updateFlag(RealTimeData realTimeData);

    List<RealTimeData> findRealTimeDataByDeviceId(String deviceId);
}
