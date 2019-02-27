package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.DataReportDao;
import com.msp.impulse.nb.entity.DataReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataReportDaoImpl implements DataReportDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void save(DataReportEntity dataReportEntity) {
            mongoTemplate.save(dataReportEntity);
    }

    @Override
    public List<DataReportEntity> findByDataMark(String dataMark) {
        Query query=new Query();
        query.addCriteria(Criteria.where("dataMark").is(dataMark));
        List<DataReportEntity> dataReportEntities = mongoTemplate.find(query, DataReportEntity.class);
        return dataReportEntities;
    }
}
