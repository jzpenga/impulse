package com.msp.impulse.mapper;

import com.msp.impulse.entity.IotDeviceModel;
import com.msp.impulse.entity.IotDeviceModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IotDeviceModelMapper {
    long countByExample(IotDeviceModelExample example);

    int deleteByExample(IotDeviceModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IotDeviceModel record);

    int insertSelective(IotDeviceModel record);

    List<IotDeviceModel> selectByExample(IotDeviceModelExample example);

    IotDeviceModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IotDeviceModel record, @Param("example") IotDeviceModelExample example);

    int updateByExample(@Param("record") IotDeviceModel record, @Param("example") IotDeviceModelExample example);

    int updateByPrimaryKeySelective(IotDeviceModel record);

    int updateByPrimaryKey(IotDeviceModel record);

    List<IotDeviceModel> selectIotList(IotDeviceModel iotDeviceModel);
}