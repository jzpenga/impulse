package com.msp.impulse.dao;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.query.FindUserQuery;

public interface AdminUserDao {

    PageBean findUser(FindUserQuery findUserQuery);

    Company findUserById(String id);
}
