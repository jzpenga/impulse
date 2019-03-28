package com.msp.impulse.mapper;

import com.msp.impulse.entity.DeviceModel;
import com.msp.impulse.entity.DeviceModelExample;
import java.util.List;

import com.msp.impulse.vo.DeviceModelVo;
import org.apache.ibatis.annotations.Param;

public interface DeviceModelMapper {
    long countByExample(DeviceModelExample example);

    int deleteByExample(DeviceModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeviceModel record);

    int insertSelective(DeviceModel record);

    List<DeviceModel> selectByExample(DeviceModelExample example);

    DeviceModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeviceModel record, @Param("example") DeviceModelExample example);

    int updateByExample(@Param("record") DeviceModel record, @Param("example") DeviceModelExample example);

    int updateByPrimaryKeySelective(DeviceModel record);

    int updateByPrimaryKey(DeviceModel record);

    List<DeviceModelVo> selectIotList(DeviceModel deviceModel);
}