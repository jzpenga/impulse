package com.msp.impulse.nb.service;

import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.dao.SensorDao;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.nb.dao.SubscribeInfoDao;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeInfoService {

    @Autowired
    private SubscribeInfoDao subscribeInfoDao;

    @Autowired
    private SensorDao sensorDao;

    public SubscribeInfoEntity getSubscribeInfoByDeviceId(String deviceId){
        Sensor sensor = sensorDao.findSensorByDeviceId(deviceId);
        return subscribeInfoDao.findByLoginName(sensor.getLoginName());
    }

    public SubscribeInfoEntity saveSubscribeInfo(SubscribeInfoEntity subscribeInfoEntity){
        return subscribeInfoDao.save(subscribeInfoEntity);
    }
}
