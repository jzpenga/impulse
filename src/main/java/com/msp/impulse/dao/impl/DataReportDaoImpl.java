package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.DataReportDao;
import com.msp.impulse.nb.entity.DataReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataReportDaoImpl implements DataReportDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void save(DataReportEntity dataReportEntity) {
            mongoTemplate.save(dataReportEntity);
    }
}
