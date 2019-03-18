package com.msp.impulse.mapper;

import com.msp.impulse.entity.DeviceService;
import com.msp.impulse.entity.DeviceServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceServiceMapper {
    long countByExample(DeviceServiceExample example);

    int deleteByExample(DeviceServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeviceService record);

    int insertSelective(DeviceService record);

    List<DeviceService> selectByExample(DeviceServiceExample example);

    DeviceService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeviceService record, @Param("example") DeviceServiceExample example);

    int updateByExample(@Param("record") DeviceService record, @Param("example") DeviceServiceExample example);

    int updateByPrimaryKeySelective(DeviceService record);

    int updateByPrimaryKey(DeviceService record);
}