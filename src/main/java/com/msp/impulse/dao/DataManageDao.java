package com.msp.impulse.dao;

import com.github.pagehelper.PageInfo;
import com.msp.impulse.entity.DataHistory;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.query.DataHistoryQuery;
import com.msp.impulse.vo.HomePageDataVo;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


public interface DataManageDao {
    HomePageDataVo findHomeData();

    Map<String, Object> findGatewayMap();

    List<DataHistory> findHistoryData(DataHistoryQuery dataHistoryQuery) throws ParseException;

    PageInfo findRealTimeData(DataHistoryQuery dataHistoryQuery) throws ParseException;
}
