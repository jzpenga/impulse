package com.msp.impulse.dao;

import com.msp.impulse.entity.PageBean;
import com.msp.impulse.entity.RealTimeData;
import com.msp.impulse.query.DataHistoryQuery;

public interface RealTimeDataDao {
    RealTimeData  selectByDeviceIdAndDataKey(String deviceId,String dataKey);
    void save(RealTimeData realTimeData);

    PageBean selectRealTimeDataInfo(DataHistoryQuery dataHistoryQuery);
}
