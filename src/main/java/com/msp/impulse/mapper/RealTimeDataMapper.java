package com.msp.impulse.mapper;

import com.msp.impulse.entity.RealTimeData;
import com.msp.impulse.entity.RealTimeDataExample;
import java.util.List;

import com.msp.impulse.query.DataHistoryQuery;
import org.apache.ibatis.annotations.Param;

public interface RealTimeDataMapper {
    long countByExample(RealTimeDataExample example);

    int deleteByExample(RealTimeDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RealTimeData record);

    int insertSelective(RealTimeData record);

    List<RealTimeData> selectByExample(RealTimeDataExample example);

    RealTimeData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RealTimeData record, @Param("example") RealTimeDataExample example);

    int updateByExample(@Param("record") RealTimeData record, @Param("example") RealTimeDataExample example);

    int updateByPrimaryKeySelective(RealTimeData record);

    int updateByPrimaryKey(RealTimeData record);

    List<RealTimeData> selectRealTimeDataInfo(DataHistoryQuery dataHistoryQuery);
}