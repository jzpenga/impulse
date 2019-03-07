package com.msp.impulse.mapper;

import com.msp.impulse.entity.Relay;
import com.msp.impulse.entity.RelayExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelayMapper {
    long countByExample(RelayExample example);

    int deleteByExample(RelayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Relay record);

    int insertSelective(Relay record);

    List<Relay> selectByExample(RelayExample example);

    Relay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Relay record, @Param("example") RelayExample example);

    int updateByExample(@Param("record") Relay record, @Param("example") RelayExample example);

    int updateByPrimaryKeySelective(Relay record);

    int updateByPrimaryKey(Relay record);
}