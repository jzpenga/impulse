package com.msp.impulse;

import com.msp.impulse.nb.dao.SubscribeInfoDao;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscribeInfoTests {

    @Autowired
    private SubscribeInfoDao subscribeInfoDao;
    @Test
    public void testSubscribeInfoDao(){
        SubscribeInfoEntity subscribeInfoEntity = new SubscribeInfoEntity();
        subscribeInfoEntity.setLoginName("tom");
        subscribeInfoEntity.setCallbackUrl("http://39.105.86.90:8072/v1.0.0/messageReceiver");
        subscribeInfoDao.save(subscribeInfoEntity);

        SubscribeInfoEntity tom = subscribeInfoDao.findByLoginName("tom");
        System.out.println(tom.getCallbackUrl());
    }
}
