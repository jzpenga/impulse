package com.msp.impulse.dao;

import com.msp.impulse.entity.Admin;
import com.msp.impulse.entity.Company;

import java.util.List;

public interface AdminDao {
    Admin addAdmin(Admin admin);

    Admin findAdminById(String id);

    void deleteAdminById(String id);

    Admin findByNameAndPwd(String loginName, String pwd);

    Admin finAdminByLoginName(String loginName);

    List<Company> findUser(Company company);

    Company findUserById(String id);
}
