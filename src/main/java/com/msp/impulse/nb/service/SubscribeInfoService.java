package com.msp.impulse.nb.service;

import com.msp.impulse.entity.Sensor;
import com.msp.impulse.mapper.SensorMapper;
import com.msp.impulse.nb.dao.SubscribeInfoDao;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeInfoService {

    @Autowired
    private SubscribeInfoDao subscribeInfoDao;

    @Autowired
    private SensorMapper sensorMapper;

    public SubscribeInfoEntity getSubscribeInfoByDeviceId(String deviceId){
        Sensor sensor = sensorMapper.findSensorByDeviceId(deviceId);
        return subscribeInfoDao.findByLoginName(sensor.getUserName());
    }

    public SubscribeInfoEntity saveSubscribeInfo(SubscribeInfoEntity subscribeInfoEntity){
        return subscribeInfoDao.save(subscribeInfoEntity);
    }
}
