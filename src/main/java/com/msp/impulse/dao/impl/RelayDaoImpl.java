package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.RelayDao;
import com.msp.impulse.entity.Relay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class RelayDaoImpl implements RelayDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Relay save(Relay relay) {
        relay.setCreateTime(new Date());
        mongoTemplate.save(relay);
        return relay;
    }
}
