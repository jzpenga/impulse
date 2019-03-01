package com.msp.impulse.dao;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.query.FindUserQuery;
import com.msp.impulse.query.GateSenPageQuery;

public interface AdminUserDao {

    PageBean findUser(FindUserQuery findUserQuery);

    Company findUserById(String id);

    void save(Company company);

    void deleteUserById(String userId);

    PageBean findGatewayByUserId(GateSenPageQuery gateSenPageQuery);

    PageBean findSensorByUserId(GateSenPageQuery gateSenPageQuery);
}
