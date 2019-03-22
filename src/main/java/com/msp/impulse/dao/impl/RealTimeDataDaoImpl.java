package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.RealTimeDataDao;
import com.msp.impulse.entity.RealTimeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RealTimeDataDaoImpl implements RealTimeDataDao {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public RealTimeData selectByDeviceIdAndDataKey(String deviceId, String dataKey) {
        Query query=new Query();
        query.addCriteria(Criteria.where("deviceId").is(deviceId).and("dataKey").is(dataKey));
         RealTimeData realTimeData = mongoTemplate.findOne(query, RealTimeData.class);
        return realTimeData;
    }

    @Override
    public void save(RealTimeData realTimeData) {
        mongoTemplate.save(realTimeData);
    }
}
