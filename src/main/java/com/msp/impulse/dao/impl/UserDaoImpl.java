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
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public Company save(Company company) {
        mongoTemplate.save(company);
        return  company;
    }

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User findOne(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public Company findByNameAndPwd(String loginName, String password) {
        Query query = new Query(Criteria.where("loginName").is(loginName).and("password").is(password));
        return mongoTemplate.findOne(query, Company.class);
    }

    @Override
    public List<Company> findByName(String loginName) {
        Query query = new Query(Criteria.where("loginName").is(loginName));
        List<Company> companies = mongoTemplate.find(query, Company.class);
        return companies;
    }
}
