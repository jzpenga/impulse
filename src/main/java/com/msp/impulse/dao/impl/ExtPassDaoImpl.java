//package com.msp.impulse.dao.impl;
//
//import com.msp.impulse.dao.ExtPassDao;
//import com.msp.impulse.entity.ExtPass;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class ExtPassDaoImpl implements ExtPassDao {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public ExtPass save(ExtPass extPass) {
//
//        mongoTemplate.save(extPass);
//        return  extPass;
//    }
//}
