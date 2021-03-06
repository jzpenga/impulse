package com.msp.impulse.mapper;

import com.msp.impulse.entity.User;
import com.msp.impulse.entity.UserExample;
import java.util.List;

import com.msp.impulse.vo.AppUserVo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByNameAndPwd(@Param("loginName") String loginName, @Param("pwd")String pwd);

    AppUserVo findUserInfo(String userId);
}