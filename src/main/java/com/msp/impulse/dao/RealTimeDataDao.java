package com.msp.impulse.dao;

import com.msp.impulse.entity.RealTimeData;

public interface RealTimeDataDao {
    RealTimeData  selectByDeviceIdAndDataKey(String deviceId,String dataKey);
    void save(RealTimeData realTimeData);
}
