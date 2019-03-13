package com.msp.impulse.mapper;

import com.msp.impulse.entity.deviceType;
import com.msp.impulse.entity.deviceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface deviceTypeMapper {
    long countByExample(deviceTypeExample example);

    int deleteByExample(deviceTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(deviceType record);

    int insertSelective(deviceType record);

    List<deviceType> selectByExample(deviceTypeExample example);

    deviceType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") deviceType record, @Param("example") deviceTypeExample example);

    int updateByExample(@Param("record") deviceType record, @Param("example") deviceTypeExample example);

    int updateByPrimaryKeySelective(deviceType record);

    int updateByPrimaryKey(deviceType record);
}