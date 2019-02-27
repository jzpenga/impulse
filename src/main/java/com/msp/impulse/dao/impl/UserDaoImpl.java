package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.UserDao;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Company save(Company company) {
        mongoTemplate.save(company);
        return  company;
    }

    @Override
    public Company findByNameAndPwd(String loginName, String password) {
        Query query = new Query(Criteria.where("loginName").is(loginName).and("password").is(password));
        return mongoTemplate.findOne(query, Company.class);
    }

    @Override
    public Company findByName(String loginName) {
        Query query = new Query(Criteria.where("loginName").is(loginName));
        Company company = mongoTemplate.findOne(query, Company.class);
        return company;
    }

    @Override
    public Company findById(String userId) {
        Query query = new Query(Criteria.where("id").is(userId));
        Company company = mongoTemplate.findOne(query, Company.class);
        return company;
    }
}
