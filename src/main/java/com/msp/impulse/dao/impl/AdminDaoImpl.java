package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.AdminDao;
import com.msp.impulse.entity.Admin;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.query.FindUserQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;


@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Admin addAdmin(Admin admin) {
        mongoTemplate.save(admin);
        return admin;
    }

    @Override
    public Admin findAdminById(String id) {
        Query query=new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Admin adminFind = mongoTemplate.findOne(query, Admin.class);
        return adminFind;
    }

    @Override
    public void deleteAdminById(String id) {
        Query query=new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query,Admin.class);
    }

    @Override
    public Admin findByNameAndPwd(String loginName, String pwd) {
        Query query = new Query(Criteria.where("loginName").is(loginName).and("password").is(pwd));
        return mongoTemplate.findOne(query, Admin.class);
    }

    @Override
    public Admin finAdminByLoginName(String loginName) {
        Query query = new Query(Criteria.where("loginName").is(loginName));
        return mongoTemplate.findOne(query, Admin.class);
    }



}

