package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.AdminDao;
import com.msp.impulse.entity.Admin;
import com.msp.impulse.entity.Company;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 查询用户信息
     * @param company
     * @return
     */
    @Override
    public List<Company> findUser(Company company) {
        Query query=new Query();
        //登录名
        if(StringUtils.isNotBlank(company.getLoginName())){
            Pattern pattern = Pattern.compile("^" + company.getLoginName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("loginName").regex(pattern));
        }
        //公司名称
        if(StringUtils.isNotBlank(company.getCompanyName())){
            Pattern pattern = Pattern.compile("^" + company.getCompanyName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("companyName").regex(pattern));
        }
        //联系人
        if(StringUtils.isNotBlank(company.getName())){
            Pattern pattern = Pattern.compile("^" + company.getCompanyName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("name").regex(pattern));
        }
        //联系人电话
        if(StringUtils.isNotBlank(company.getPhoneNo())){
            Pattern pattern = Pattern.compile("^" + company.getPhoneNo() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("phoneNo").regex(pattern));
        }
        //省
        if(StringUtils.isNotBlank(company.getProvince())){
            query.addCriteria(Criteria.where("province").is(company.getProvince()));
        }
        //市
        if(StringUtils.isNotBlank(company.getProvince())){
            query.addCriteria(Criteria.where("province").is(company.getProvince()));
        }

        List<Company> companyList = mongoTemplate.find(query, Company.class);

        return companyList;
    }

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    @Override
    public Company findUserById(String userId) {
        Query query=new Query();
        query.addCriteria(Criteria.where("id").is(userId));
        Company company = mongoTemplate.findOne(query, Company.class);
        return company;
    }
}

