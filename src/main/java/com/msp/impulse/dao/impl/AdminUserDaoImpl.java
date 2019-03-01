package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.AdminUserDao;
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
public class AdminUserDaoImpl implements AdminUserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询用户信息
     *
     * @param findUserQuery
     * @return
     */
    @Override
    public PageBean findUser(FindUserQuery findUserQuery) {
        Query query = new Query();
        //登录名
        if (StringUtils.isNotBlank(findUserQuery.getLoginName())) {
            Pattern pattern = Pattern.compile("^" + findUserQuery.getLoginName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("loginName").regex(pattern));
        }
        //公司名称
        if (StringUtils.isNotBlank(findUserQuery.getCompanyName())) {
            Pattern pattern = Pattern.compile("^" + findUserQuery.getCompanyName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("companyName").regex(pattern));
        }
        //联系人
        if (StringUtils.isNotBlank(findUserQuery.getName())) {
            Pattern pattern = Pattern.compile("^" + findUserQuery.getCompanyName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("name").regex(pattern));
        }
        //联系人电话
        if (StringUtils.isNotBlank(findUserQuery.getPhoneNo())) {
            Pattern pattern = Pattern.compile("^" + findUserQuery.getPhoneNo() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("phoneNo").regex(pattern));
        }
        //省
        if (StringUtils.isNotBlank(findUserQuery.getProvince())) {
            query.addCriteria(Criteria.where("province").is(findUserQuery.getProvince()));
        }
        //市
        if (StringUtils.isNotBlank(findUserQuery.getProvince())) {
            query.addCriteria(Criteria.where("province").is(findUserQuery.getProvince()));
        }
        //查询总条数
        Long totalRecord = mongoTemplate.count(query, Company.class);
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(findUserQuery.getPageNo(), findUserQuery.getPageSize(), sort);
        List<Company> companyList = mongoTemplate.find(query.with(pageable), Company.class);

        PageBean pageBean = new PageBean(findUserQuery.getPageNo(), findUserQuery.getPageSize(), totalRecord.intValue());
        pageBean.setList(companyList);
        return pageBean;
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
