package com.msp.impulse.dao.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.constants.Constants;
import com.msp.impulse.dao.DataManageDao;
import com.msp.impulse.entity.*;
import com.msp.impulse.nb.entity.DataReportEntity;
import com.msp.impulse.query.DataHistoryQuery;
import com.msp.impulse.util.DateUtil;
import com.msp.impulse.vo.HomePageDataVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

@Repository
public class DataManageDaoImpl implements DataManageDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public HomePageDataVo findHomeData() {

        HomePageDataVo homePageDataVo=new HomePageDataVo(0,0,0,0,0,0,0,null,null);
        //网关总格数
        Query queryGateway=new Query();
        Long count = mongoTemplate.count(queryGateway, Gateway.class);
        homePageDataVo.setGatewayNumber(count.intValue());
        //在线网关数
        Query queryGatewayOn =new Query();
        queryGatewayOn.addCriteria(Criteria.where("workStatus").is(Constants.SwitchStatus.ON.getValue()));
        Long countGatewayOn = mongoTemplate.count(queryGatewayOn, Gateway.class);
        homePageDataVo.setGatewayOnNumber(countGatewayOn.intValue());
        //离线网关数
        Query queryGatewayOff =new Query();
        queryGatewayOff.addCriteria(Criteria.where("workStatus").is(Constants.SwitchStatus.OFF.getValue()));
        Long countGatewayOff= mongoTemplate.count(queryGatewayOff, Gateway.class);
        homePageDataVo.setGatewayOffNumber(countGatewayOff.intValue());
        //网关个数
        Query quertCountSensor=new Query();
        Long countSensor = mongoTemplate.count(quertCountSensor, Sensor.class);
        homePageDataVo.setSensorNumber(countSensor.intValue());
        //在线传感器个数
        Query querySensorOn =new Query();
        querySensorOn.addCriteria(Criteria.where("workStatus").is(Constants.SwitchStatus.ON.getValue()));
        Long countSensorOn = mongoTemplate.count(querySensorOn, Sensor.class);
        homePageDataVo.setSensorOnNumber(countSensorOn.intValue());
        //离线传感器数
        Query querySensorOff =new Query();
        querySensorOff.addCriteria(Criteria.where("workStatus").is(Constants.SwitchStatus.OFF.getValue()));
        Long countSensorOff= mongoTemplate.count(querySensorOff, Sensor.class);
        homePageDataVo.setSensorOffNumber(countSensorOff.intValue());
        //报警个数
        Query queryCoubtAlarm=new Query();
        Long countAlarm= mongoTemplate.count(queryCoubtAlarm, Alarm.class);
        homePageDataVo.setAlarmNumber(countAlarm.intValue());
        //警报
        Query alarmQuery=new Query();
        mongoTemplate.find(alarmQuery, Alarm.class);
        //操作指令
        Query controllnstruQuery=new Query();
        mongoTemplate.find(controllnstruQuery, Controlinstru.class);

        return homePageDataVo;
    }

    /**
     * 查询所有网关的位置
     */
    @Override
    public Map<String, Object> findGatewayMap() {
        Query query=new Query();
        List<Gateway> gateways = mongoTemplate.find(query, Gateway.class);
        List<Position> positionGatewayList=new ArrayList<>();
        for (Gateway gateway:gateways) {
            if(StringUtils.isNotBlank(gateway.getLongitude())&& StringUtils.isNotBlank(gateway.getLatitude())) {
                Position position = new Position();
                position.setLatitude(gateway.getLatitude());
                position.setLongitude(gateway.getLongitude());
                positionGatewayList.add(position);
            }
        }
        List<Sensor> sensorList = mongoTemplate.find(query, Sensor.class);
        List<Position> positionSensorList=new ArrayList<>();
        for (Sensor sensor:sensorList) {
            if(StringUtils.isNotBlank(sensor.getLongitude())&& StringUtils.isNotBlank(sensor.getLatitude())) {
                Position position = new Position();
                position.setLongitude(sensor.getLongitude());
                position.setLatitude(sensor.getLatitude());
                positionSensorList.add(position);
            }
        }
        Map<String,Object> mapMap=new HashMap();
        mapMap.put("positionGatewayList",positionGatewayList);
        mapMap.put("positionSensorList",positionSensorList);
        return mapMap;
    }

    /**
     * 查询历史数据
     * @param dataHistoryQuery
     * @return
     */
    @Override
    public List<DataHistory> findHistoryData(DataHistoryQuery dataHistoryQuery) throws ParseException {
        Query query=new Query();
        //网关名称
        if(StringUtils.isNotBlank(dataHistoryQuery.getGatewayName())){
            Pattern pattern = Pattern.compile("^" + dataHistoryQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("gatewayName").regex(pattern));
        }
        //传感器名称
        if(StringUtils.isNotBlank(dataHistoryQuery.getSensorName())){
            Pattern pattern = Pattern.compile("^" + dataHistoryQuery.getSensorName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("sensorName").regex(pattern));
        }
        if(dataHistoryQuery.getWayNo()!=null){
            query.addCriteria(Criteria.where("wayNo").is(dataHistoryQuery.getWayNo()));
        }
        //上报时间
        Criteria reportDate=null;
        if(StringUtils.isNotBlank(dataHistoryQuery.getReportDateFrom())){//上报时间 From
            reportDate = Criteria.where("reportDate").gte(DateUtil.dateToISODate(dataHistoryQuery.getReportDateFrom()));
        }
        if(StringUtils.isNotBlank(dataHistoryQuery.getReportDateTo())){//上报时间to
            reportDate.lte(DateUtil.dateToISODate(dataHistoryQuery.getReportDateTo()));
        }
        if(reportDate!=null) {
            query.addCriteria(reportDate);
        }
        List<DataHistory> passList = mongoTemplate.find(query, DataHistory.class);
        return passList;
    }

    @Override
    public PageInfo findRealTimeData(DataHistoryQuery dataHistoryQuery) throws ParseException {
        Criteria criteria=new Criteria();
        //用户id
        if(dataHistoryQuery.getUserId()!=null){
            criteria.where("userId").is(dataHistoryQuery.getUserId());
        }
        //网关名称
        if(StringUtils.isNotBlank(dataHistoryQuery.getGatewayName())){
            Pattern pattern = Pattern.compile("^" + dataHistoryQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("gatewayName").regex(pattern);
        }
        //传感器名称
        if(StringUtils.isNotBlank(dataHistoryQuery.getSensorName())){
            Pattern pattern = Pattern.compile("^" + dataHistoryQuery.getSensorName() + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("sensorName").regex(pattern);
        }
        //上报时间
        if(!StringUtils.isEmpty(dataHistoryQuery.getReportDateFrom())){//上报时间 From
            criteria.and("eventTime").gte(DateUtil.dateToISODate(dataHistoryQuery.getReportDateFrom()));
        }
        if(!StringUtils.isEmpty(dataHistoryQuery.getReportDateTo())){//上报时间to
            criteria.and("eventTime").lte(DateUtil.dateToISODate(dataHistoryQuery.getReportDateTo()));
        }
        if(dataHistoryQuery.getSensorType()!=null){
            criteria.and("dataKey").is(dataHistoryQuery.getSensorType());
        }
        //查询总条数
        if(dataHistoryQuery.getPageNo()==null){
            dataHistoryQuery.setPageNo(1);
        }
        if(dataHistoryQuery.getPageSize()==null){
            dataHistoryQuery.setPageSize(10);
        }
        Sort sort = new Sort(Sort.Direction.DESC,"deviceId")
                .and(new Sort(Sort.Direction.DESC,"dataKey"));
        PageHelper.startPage(dataHistoryQuery.getPageNo(),dataHistoryQuery.getPageSize());
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(criteria),//条件
                Aggregation.group("deviceId","dataKey").max("eventTime").as("eventTime"),//分组字段
                Aggregation.sort(sort)
                ,Aggregation.skip((dataHistoryQuery.getPageNo()>1?(dataHistoryQuery.getPageNo()-1)*dataHistoryQuery.getPageSize():0)),
                Aggregation.limit(dataHistoryQuery.getPageSize())//页数
                );
        AggregationResults<DataReportEntity> outputType=mongoTemplate.aggregate(agg,"dataReportEntity",DataReportEntity.class);
        List<DataReportEntity> list=outputType.getMappedResults();

        List<DataReportEntity> returnEntityList=new ArrayList<>() ;
        //根据时间，deviceId serviceType查询数据,根据时间排序，取第一条
        for(DataReportEntity dataReportEntity:list){
            Query queryData=new Query();
            Criteria criteriaData=new Criteria();
            queryData.addCriteria(criteriaData.where("deviceId").is(dataReportEntity.getDeviceId()).and("dataKey").is(dataReportEntity.getDataKey())
                    .and("eventTime").is(dataReportEntity.getEventTime()));
            List<DataReportEntity> dataReportEntity1 = mongoTemplate.find(queryData,DataReportEntity.class);
            returnEntityList.add(dataReportEntity1.get(0));
        }
        PageInfo pageInfo=new PageInfo(returnEntityList);

        Aggregation aggCount = Aggregation.newAggregation(
                Aggregation.match(criteria),//条件
                Aggregation.group("deviceId","dataKey").max("eventTime").as("eventTime"),//分组字段
                Aggregation.sort(new Sort(Sort.Direction.DESC,"eventTime"))
        );
        AggregationResults<DataReportEntity> outputTypeCount=mongoTemplate.aggregate(aggCount,"dataReportEntity",DataReportEntity.class);
        List<DataReportEntity> list1=outputTypeCount.getMappedResults();
        pageInfo.setTotal(list1.size());

        return pageInfo;
    }
}
