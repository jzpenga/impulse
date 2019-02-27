package com.msp.impulse.nb.dao.impl;

import com.msp.impulse.nb.dao.SubscribeInfoDao;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SubscribeInfoDaoImpl implements SubscribeInfoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public SubscribeInfoEntity save(SubscribeInfoEntity subscribeInfoEntity) {
        mongoTemplate.save(subscribeInfoEntity);
        return subscribeInfoEntity;
    }

    @Override
    public SubscribeInfoEntity findByLoginName(String loginName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("loginName").is(loginName));
        return mongoTemplate.findOne(query, SubscribeInfoEntity.class);
    }
}
