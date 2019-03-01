package com.msp.impulse.dao;

import com.msp.impulse.entity.Admin;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.query.FindUserQuery;

import java.util.List;

public interface AdminDao {
    Admin addAdmin(Admin admin);

    Admin findAdminById(String id);

    void deleteAdminById(String id);

    Admin findByNameAndPwd(String loginName, String pwd);

    Admin finAdminByLoginName(String loginName);


}
