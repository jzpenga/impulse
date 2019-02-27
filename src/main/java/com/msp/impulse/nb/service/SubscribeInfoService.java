package com.msp.impulse.nb.service;

import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.nb.dao.SubscribeInfoDao;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeInfoService {

    @Autowired
    private SubscribeInfoDao subscribeInfoDao;

    @Autowired
    private GatewayDao gatewayDao;


//    public SubscribeInfoEntity getSubscribeInfoByDeviceId(String deviceId){
//        Gateway gataway = gatewayDao.findGatewayByDeviceId(deviceId);
//        return subscribeInfoDao.findByLoginName(gataway.getLoginName());
//    }
}
