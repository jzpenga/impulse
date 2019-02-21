package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.PassDao;
import com.msp.impulse.entity.Pass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PassDaoImpl implements PassDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Pass save(Pass pass) {
        mongoTemplate.save(pass);
        return pass;
    }
}
