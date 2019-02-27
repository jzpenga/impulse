package com.msp.impulse.nb.dao;

import com.msp.impulse.nb.entity.SubscribeInfoEntity;

public interface SubscribeInfoDao {

    SubscribeInfoEntity save(SubscribeInfoEntity subscribeInfoEntity);
    SubscribeInfoEntity findByLoginName(String  loginName);



}
