//package com.msp.impulse.dao.impl;
//
//import com.msp.impulse.dao.AdminDicDao;
//import com.msp.impulse.entity.DataDictionary;
//import com.msp.impulse.nb.entity.DataReportEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class AdminDicDaoImpl implements AdminDicDao {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public List<DataDictionary> findDicByGroupCode(String groupCode) {
//        Query query=new Query();
//        query.addCriteria(Criteria.where("").is(groupCode));
//        List<DataDictionary> dataDictionaryList = mongoTemplate.find(query, DataDictionary.class);
//        return dataDictionaryList;
//    }
//
//    @Override
//    public void save(DataDictionary dataDictionary) {
//        mongoTemplate.save(dataDictionary);
//    }
//}
