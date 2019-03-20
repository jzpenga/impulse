package com.msp.impulse.service;

import com.msp.impulse.dao.DataReportDao;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.CompanyMapper;
import com.msp.impulse.mapper.DictionaryMapper;
import com.msp.impulse.mapper.RealTimeDataMapper;
import com.msp.impulse.mapper.SensorMapper;
import com.msp.impulse.nb.entity.DataReportEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public class DataReportService {
    private static Logger logger = LoggerFactory.getLogger(DataReportService.class);
    @Autowired
    private DataReportDao dataReportDao;
    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private RealTimeDataMapper realTimeDataMapper;

    /**
     * 入库
     */
    @Transactional
    public boolean insertDateReport(List<DataReportEntity> dataReportEntityList) {
        try {
            if(!dataReportEntityList.isEmpty()) {

                for (DataReportEntity dataReportEntity : dataReportEntityList) {
                    //根据deviceId查询传感器信息
                    SensorExample sensorExample = new SensorExample();
                    sensorExample.createCriteria().andDeviceIdEqualTo(dataReportEntity.getDeviceId()).andFlagEqualTo("0");
                    List<Sensor> sensorList = sensorMapper.selectByExample(sensorExample);
                    if (sensorList.isEmpty()) {
                        throw new MyException("deviceId无对应传感器信息");
                    }
                    Sensor sensor = sensorList.get(0);
                    //查询userId
                    Integer userId = sensor.getUserId();
                    if (StringUtils.isBlank(dataReportEntity.getDataKey())) {
                        throw new MyException("dataKey不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getDeviceId())) {
                        throw new MyException("deviceId不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getServiceType())) {
                        throw new MyException("serviceType不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getDataKey())) {
                        throw new MyException("dataKey不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getDataValue())) {
                        throw new MyException("dataValue不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getDataValue())) {
                        throw new MyException("dataMark不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getServiceId())) {
                        throw new MyException("serviceId不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getServiceType())) {
                        throw new MyException("serviceType不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getEventTime())) {
                        throw new MyException("event_time不能为空!");
                    }
                    if (StringUtils.isBlank(sensor.getSensorNo())) {
                        throw new MyException("传感器序列号不能为空!");
                    }
                    //根据userId查询用户名
                    if (userId != null) {
                        CompanyExample companyExample = new CompanyExample();
                        companyExample.createCriteria().andIdEqualTo(userId).andFlagEqualTo("0");
                        List<Company> companyList = companyMapper.selectByExample(companyExample);
                        if (!companyList.isEmpty()) {
                            Company company = companyList.get(0);
                            if (StringUtils.isNotBlank(company.getCompanyName())) {
                                dataReportEntity.setUserName(company.getCompanyName());
                            }
                        }
                    }
                    //查询码表，插入字段
                    if (StringUtils.isNotBlank(dataReportEntity.getDataKey())) {
                        DictionaryExample dictionaryExample = new DictionaryExample();
                        dictionaryExample.createCriteria().andDicCodeEqualTo(dataReportEntity.getDataKey()).andFlagEqualTo("0");
                        List<Dictionary> dictionaryList = dictionaryMapper.selectByExample(dictionaryExample);
                        if (!dictionaryList.isEmpty()) {
                            Dictionary dictionary = dictionaryList.get(0);
                            dataReportEntity.setDataKeyName(dictionary.getDicName());
                        }
                    }
                    dataReportEntity.setEquipmentNo(sensor.getSensorNo());
                    dataReportEntity.setSensorName(sensor.getName());
                    if (StringUtils.isNotBlank(dataReportEntity.getGatewayName())) {
                        dataReportEntity.setGatewayName(dataReportEntity.getGatewayName());
                    }

                    dataReportEntity.setSensorName(sensor.getName());
                    dataReportDao.save(dataReportEntity);

                    //记录最新实时数据======================start
                    //根据deviceId和dataKey查找数据,存在更新，不存在新增
                    RealTimeData realTimeData1 = realTimeDataMapper.selectByDeviceIdAndDataKey(dataReportEntity.getDeviceId(), dataReportEntity.getDataKey());
                    if (realTimeData1 != null) {  //更新数据
                        if (userId != null) {
                            realTimeData1.setUserId(userId);
                        }
                        if (StringUtils.isNotBlank(dataReportEntity.getUserName())) {
                            realTimeData1.setUserName(dataReportEntity.getUserName());
                        }
                        realTimeData1.setServiceId(dataReportEntity.getServiceId());
                        realTimeData1.setServiceType(dataReportEntity.getServiceType());
                        realTimeData1.setSensorName(sensor.getName());
                        //realTimeData1.setGatewayName();
                        realTimeData1.setEventTime(dataReportEntity.getEventTime());
                        realTimeData1.setEquipmentNo(sensor.getSensorNo());
                        realTimeData1.setDataValue(dataReportEntity.getDataValue());
                        if (StringUtils.isNotBlank(dataReportEntity.getDataKeyName())) {
                            realTimeData1.setDataKeyName(dataReportEntity.getDataKeyName());
                        }
                        realTimeData1.setDataMark(dataReportEntity.getDataMark());
                        realTimeDataMapper.updateByPrimaryKey(realTimeData1);
                    } else {//新增数据
                        RealTimeData realTimeData = new RealTimeData();
                        if (userId != null) {
                            realTimeData.setUserId(userId);
                        }
                        if (StringUtils.isNotBlank(dataReportEntity.getUserName())) {
                            realTimeData.setUserName(dataReportEntity.getUserName());
                        }
                        realTimeData.setDataKey(dataReportEntity.getDataKey());
                        realTimeData.setDataKeyName(dataReportEntity.getDataKeyName());
                        realTimeData.setDataMark(dataReportEntity.getDataMark());
                        realTimeData.setDataValue(dataReportEntity.getDataValue());
                        realTimeData.setDeviceId(dataReportEntity.getDeviceId());
                        realTimeData.setEquipmentNo(sensor.getSensorNo());
                        realTimeData.setEventTime(dataReportEntity.getEventTime());
                        //realTimeData.setGatewayName();
                        realTimeData.setSensorName(sensor.getName());
                        realTimeData.setServiceType(dataReportEntity.getServiceType());
                        realTimeData.setServiceId(dataReportEntity.getServiceId());
                        realTimeDataMapper.insertSelective(realTimeData);
                    }
                    //======================================end
                }
            }
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * 根据dataMark查询数据
     */
    public HashMap<String,Object> messageReceiver(String dataMark) {
        HashMap<String,Object> receiverData=new HashMap<>();
        //根据dataMark查询datareport
        List<DataReportEntity> dataReportEntities = dataReportDao.findByDataMark(dataMark);
        if(dataReportEntities.isEmpty()){
            return null;
        }
        DataReportEntity  data = dataReportEntities.get(0);
        receiverData.put("deviceId",data.getDeviceId());
        receiverData.put("equipmentNo",data.getEquipmentNo());
        receiverData.put("eventTime",data.getEventTime());
        for (DataReportEntity dataReportEntity :
                dataReportEntities) {
            receiverData.put(dataReportEntity.getDataKey(),dataReportEntity.getDataValue());
        }
        return receiverData;
    }
}