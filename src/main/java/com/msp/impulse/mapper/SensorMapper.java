package com.msp.impulse.mapper;

import com.msp.impulse.entity.Sensor;
import com.msp.impulse.entity.SensorExample;
import java.util.List;

import com.msp.impulse.entity.ServiceType;
import com.msp.impulse.query.SensorQuery;
import com.msp.impulse.vo.DataReportVo;
import org.apache.ibatis.annotations.Param;

public interface SensorMapper {
    long countByExample(SensorExample example);

    int deleteByExample(SensorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sensor record);

    int insertSelective(Sensor record);

    List<Sensor> selectByExample(SensorExample example);

    Sensor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sensor record, @Param("example") SensorExample example);

    int updateByExample(@Param("record") Sensor record, @Param("example") SensorExample example);

    int updateByPrimaryKeySelective(Sensor record);

    int updateByPrimaryKey(Sensor record);

    int findBySensorName(String name);

    List<Sensor> selectSensorInfo(SensorQuery sensorQuery);

    List<Sensor> getDeviceList(String loginName);

    Sensor findSensorByDeviceId(String deviceId);

    String findByDeviceId(String deviceId);

    List<Sensor> querySensorNotRelation(String sensorName);

    Sensor findSensorBySensorName(String sensorName);

    List<Sensor> findSensorByNameLike(@Param("sensorName")String sensorName,@Param("userId")Integer userId);

    List<ServiceType> findServiceType(String sensorModel);

    List<DataReportVo> selectDataReport(String deviceId);
}