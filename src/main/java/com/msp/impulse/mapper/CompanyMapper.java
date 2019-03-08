package com.msp.impulse.mapper;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.CompanyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    String findCompanyNameByLoginName(String loginName);
}