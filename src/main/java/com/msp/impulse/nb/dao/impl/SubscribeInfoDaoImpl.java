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

        Query query = new Query();
        query.addCriteria(Criteria.where("loginName").is(subscribeInfoEntity.getLoginName()));
        SubscribeInfoEntity infoEntity = mongoTemplate.findOne(query, SubscribeInfoEntity.class);
        if (infoEntity!=null){
            subscribeInfoEntity.setId(infoEntity.getId());
        }
        mongoTemplate.save(subscribeInfoEntity);
        return subscribeInfoEntity;
    }

    @Override
    public SubscribeInfoEntity findByCompanyName(String companyName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("companyName").is(companyName));
        return mongoTemplate.findOne(query, SubscribeInfoEntity.class);
    }
}
