package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.AlarmDao;
import com.msp.impulse.entity.Alarm;
import com.msp.impulse.query.AlarmQuery;
import com.msp.impulse.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class AlarmDaoImpl implements AlarmDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据条件查询警报信息
     * @param alarmQuery
     * @return
     * @throws ParseException
     */
    @Override
    public List<Alarm> findAlarm(AlarmQuery alarmQuery,String userId) throws ParseException {
        Query query=new Query();
        if(StringUtils.isNotBlank(userId)){
            query.addCriteria(Criteria.where("userId").is(userId));
        }
        if(StringUtils.isNotBlank(alarmQuery.getGatewayName())){//网关名称
            Pattern pattern = Pattern.compile("^" + alarmQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("gatewayName").regex(pattern));
        }
        if(StringUtils.isNotBlank(alarmQuery.getSensorName())){//传感器名称
            Pattern pattern = Pattern.compile("^" + alarmQuery.getSensorName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("sensorName").regex(pattern));
        }
        if(StringUtils.isNotBlank(alarmQuery.getAlarmType())){//报警类型
            query.addCriteria(Criteria.where("alarmType").is(alarmQuery.getAlarmType()));
        }
        if(StringUtils.isNotBlank(alarmQuery.getAlarmStatus())){//报警状态
            query.addCriteria(Criteria.where("alarmStatus").is(alarmQuery.getAlarmStatus()));
        }
        Criteria alarmTime=null;
        if(alarmQuery.getAlarmDateFrom()!=null){//报警时间from
             alarmTime = Criteria.where("alarmTime").gte(DateUtil.dateToISODate(alarmQuery.getAlarmDateFrom()));
        }
        if(alarmQuery.getAlarmDateTo()!=null){//报警时间to
            alarmTime.lte(DateUtil.dateToISODate(alarmQuery.getAlarmDateTo()));
        }
        if(alarmTime!=null){
            query.addCriteria(alarmTime);
        }
        Criteria closeTime=null;
        if(alarmQuery.getCloseDateFrom()!=null){//关闭时间from
            closeTime=Criteria.where("closeTime").gte(DateUtil.dateToISODate(alarmQuery.getCloseDateFrom()));
        }
        if(alarmQuery.getCloseDateTo()!=null){//关闭时间to
            closeTime.lte(DateUtil.dateToISODate(alarmQuery.getCloseDateTo()));
        }
        if(closeTime!=null){
            query.addCriteria(closeTime);
        }
        List<Alarm> alarms = mongoTemplate.find(query, Alarm.class);
        return alarms;
    }

    /**
     * 查询所有警报信息
     * @return
     */
    @Override
    public List<Alarm> getAlarmList() {
        Query query=new Query();
        List<Alarm> alarms = mongoTemplate.find(query, Alarm.class);
        return alarms;
    }
}
