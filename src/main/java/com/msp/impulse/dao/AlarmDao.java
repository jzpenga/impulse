package com.msp.impulse.dao;

import com.msp.impulse.entity.Alarm;
import com.msp.impulse.query.AlarmQuery;

import java.text.ParseException;
import java.util.List;

public interface AlarmDao {
    List<Alarm> getAlarmList();

    List<Alarm> findAlarm(AlarmQuery alarmQuery,String userId) throws ParseException;
}
