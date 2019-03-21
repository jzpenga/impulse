package com.msp.impulse.mapper;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.CompanyExample;
import java.util.List;

import com.msp.impulse.query.FindUserQuery;
import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {
    long countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    Company findByName(String loginName);

    Company findByNameAndPwd(@Param("loginName")String loginName, @Param("pwd")String pwd);

    List<Company> findUser(FindUserQuery findUserQuery);

    String findCompanyNameByLoginName(String loginName);

    List<Company> seletByUserName(String userName);
}