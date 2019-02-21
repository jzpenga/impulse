package com.msp.impulse.dao;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Company save(Company company);

    void save(User user);

    User findOne(String id);

    Company findByNameAndPwd(String loginName, String password);

    List<Company> findByName(String loginName);
}
