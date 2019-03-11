package com.msp.impulse.nb.service;

import com.msp.impulse.entity.Sensor;
import com.msp.impulse.mapper.CompanyMapper;
import com.msp.impulse.mapper.SensorMapper;
import com.msp.impulse.nb.dao.SubscribeInfoDao;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeInfoService {

    @Autowired
    private SubscribeInfoDao subscribeInfoDao;

    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private CompanyMapper companyMapper;

    public SubscribeInfoEntity getSubscribeInfoByDeviceId(String deviceId){
        Sensor sensor = sensorMapper.findSensorByDeviceId(deviceId);
        return subscribeInfoDao.findByCompanyName(sensor.getUserName());
    }

    public SubscribeInfoEntity saveSubscribeInfo(SubscribeInfoEntity subscribeInfoEntity){
        String companyName = companyMapper.findCompanyNameByLoginName(subscribeInfoEntity.getLoginName());
        if (StringUtils.isEmpty(companyName)){
            return null;
        }
        subscribeInfoEntity.setCompanyName(companyName);
        return subscribeInfoDao.save(subscribeInfoEntity);
    }
}
