package com.msp.impulse.mapper;

import com.msp.impulse.entity.deviceService;
import com.msp.impulse.entity.deviceServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface deviceServiceMapper {
    long countByExample(deviceServiceExample example);

    int deleteByExample(deviceServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(deviceService record);

    int insertSelective(deviceService record);

    List<deviceService> selectByExample(deviceServiceExample example);

    deviceService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") deviceService record, @Param("example") deviceServiceExample example);

    int updateByExample(@Param("record") deviceService record, @Param("example") deviceServiceExample example);

    int updateByPrimaryKeySelective(deviceService record);

    int updateByPrimaryKey(deviceService record);
}