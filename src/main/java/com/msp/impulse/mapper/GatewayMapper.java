package com.msp.impulse.mapper;

import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.GatewayExample;
import com.msp.impulse.query.GatewayQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GatewayMapper {
    long countByExample(GatewayExample example);

    int deleteByExample(GatewayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gateway record);

    int insertSelective(Gateway record);

    List<Gateway> selectByExample(GatewayExample example);

    Gateway selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gateway record, @Param("example") GatewayExample example);

    int updateByExample(@Param("record") Gateway record, @Param("example") GatewayExample example);

    int updateByPrimaryKeySelective(Gateway record);

    int updateByPrimaryKey(Gateway record);

    int findGatewayName(String gatewayName);

    List<Gateway> selectGatewayfo(GatewayQuery gatewayQuery);
}