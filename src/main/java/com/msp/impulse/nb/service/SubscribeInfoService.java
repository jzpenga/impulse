package com.msp.impulse.nb.service;

import com.msp.impulse.nb.dao.SubscribeInfoDao;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeInfoService {

    @Autowired
    private SubscribeInfoDao subscribeInfoDao;

    

    public SubscribeInfoEntity getSubscribeInfoByDeviceId(){
        return subscribeInfoDao.findByLoginName("");
    }
}
