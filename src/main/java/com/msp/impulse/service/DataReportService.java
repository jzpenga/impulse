package com.msp.impulse.service;

import com.msp.impulse.dao.DataReportDao;
import com.msp.impulse.dao.RealTimeDataDao;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.*;
import com.msp.impulse.nb.entity.DataReportEntity;
import com.msp.impulse.vo.DataReportVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private RealTimeDataDao realTimeDataDao;

    public DataReportVo getDataReport(String deviceId) {
        //关联查询

        HashMap<String, String> dataKeyValue = new HashMap<>();
        List<DataReportVo> dataReportVoList = sensorMapper.selectDataReport(deviceId);
        if(dataReportVoList.isEmpty()){
            throw  new MyException("【"+deviceId+"】对应的数据不存在!");
        }
        DataReportVo dataReportVo1 = dataReportVoList.get(0);
        for (DataReportVo dataReportVo : dataReportVoList) {
            dataKeyValue.put(dataReportVo.getServiceCode(), dataReportVo.getCodeName());
        }
//        dataReportVo1.setCodeName();
        dataReportVo1.setLoginName(dataReportVo1.getLoginName());
        dataReportVo1.setDeviceId(dataReportVo1.getDeviceId());
        dataReportVo1.setGatewayName(dataReportVo1.getGatewayName());
        dataReportVo1.setSensorModel(dataReportVo1.getSensorModel());
        dataReportVo1.setSensorName(dataReportVo1.getSensorName());
        dataReportVo1.setSensorNo(dataReportVo1.getSensorNo());
        dataReportVo1.setSensorType(dataReportVo1.getSensorType());
        dataReportVo1.setUserId(dataReportVo1.getUserId());
        dataReportVo1.setCallbackUrl(dataReportVo1.getCallbackUrl());
//        dataReportVo1.setServiceCode();
        dataReportVo1.setDataValueAndKey(dataKeyValue);

        return dataReportVo1;
    }

    /**
     * 入库
     */
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public boolean insertDateReport(List<DataReportEntity> dataReportEntityList) {
        try {
            if (!dataReportEntityList.isEmpty()) {
                for (DataReportEntity dataReportEntity : dataReportEntityList) {
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
                    if (StringUtils.isBlank(dataReportEntity.getDataMark())) {
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
                    if (StringUtils.isBlank(dataReportEntity.getEquipmentNo())) {
                        throw new MyException("传感器序列号不能为空!");
                    }
                    if (StringUtils.isBlank(dataReportEntity.getSensorName())) {
                        throw new MyException("传感器名称不能为空!");
                    }
                    dataReportEntity.setCreateTime(new Date());
                    dataReportDao.save(dataReportEntity);
                    //记录最新实时数据======================start
                    //根据deviceId和dataKey查找数据,存在更新，不存在新增
                    long start = System.currentTimeMillis();
                    RealTimeData realTimeData1 = realTimeDataDao.selectByDeviceIdAndDataKey(dataReportEntity.getDeviceId(), dataReportEntity.getDataKey());
//                    RealTimeData realTimeData1 = realTimeDataMapper.selectByDeviceIdAndDataKey(dataReportEntity.getDeviceId(), dataReportEntity.getDataKey());
                    if (realTimeData1 != null) {  //更新数据
                        if (dataReportEntity.getUserId() != null) {
                            realTimeData1.setUserId(dataReportEntity.getUserId());
                        }
                        if (StringUtils.isNotBlank(dataReportEntity.getUserName())) {
                            realTimeData1.setUserName(dataReportEntity.getUserName());
                        }
                        realTimeData1.setServiceId(dataReportEntity.getServiceId());
                        realTimeData1.setServiceType(dataReportEntity.getServiceType());
                        realTimeData1.setSensorName(dataReportEntity.getSensorName());
                        //realTimeData1.setGatewayName();
                        realTimeData1.setEventTime(dataReportEntity.getEventTime());
                        realTimeData1.setEquipmentNo(dataReportEntity.getEquipmentNo());
                        realTimeData1.setDataValue(dataReportEntity.getDataValue());
                        if (StringUtils.isNotBlank(dataReportEntity.getDataKeyName())) {
                            realTimeData1.setDataKeyName(dataReportEntity.getDataKeyName());
                        }
                        realTimeData1.setFlag("0");
                        realTimeData1.setDataMark(dataReportEntity.getDataMark());
                        realTimeData1.setUpdateTime(new Date());
                        realTimeDataDao.save(realTimeData1);
                    } else {//新增数据
                        RealTimeData realTimeData = new RealTimeData();
                        if (dataReportEntity.getUserId()  != null) {
                            realTimeData.setUserId(dataReportEntity.getUserId() );
                        }
                        if (StringUtils.isNotBlank(dataReportEntity.getUserName())) {
                            realTimeData.setUserName(dataReportEntity.getUserName());
                        }
                        realTimeData.setDataKey(dataReportEntity.getDataKey());
                        if (StringUtils.isNotBlank(dataReportEntity.getDataKeyName())) {
                            realTimeData.setDataKeyName(dataReportEntity.getDataKeyName());
                        }
                        realTimeData.setDataMark(dataReportEntity.getDataMark());
                        realTimeData.setDataValue(dataReportEntity.getDataValue());
                        realTimeData.setDeviceId(dataReportEntity.getDeviceId());
                        realTimeData.setEquipmentNo(dataReportEntity.getEquipmentNo());
                        realTimeData.setEventTime(dataReportEntity.getEventTime());
                        //realTimeData.setGatewayName();
                        realTimeData.setSensorName(dataReportEntity.getSensorName());
                        realTimeData.setServiceType(dataReportEntity.getServiceType());
                        realTimeData.setServiceId(dataReportEntity.getServiceId());
                        realTimeData.setFlag("0");
                        realTimeData.setCreateTime(new Date());
                        realTimeDataDao.save(realTimeData);
                    }
                    logger.info("更新实时数据时间===>"+(System.currentTimeMillis()-start)/1000f+"秒");
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
    public HashMap<String, Object> messageReceiver(String dataMark) {
        HashMap<String, Object> receiverData = new HashMap<>();
        //根据dataMark查询datareport
        List<DataReportEntity> dataReportEntities = dataReportDao.findByDataMark(dataMark);
        if (dataReportEntities.isEmpty()) {
            return null;
        }
        DataReportEntity data = dataReportEntities.get(0);
        receiverData.put("deviceId", data.getDeviceId());
        receiverData.put("equipmentNo", data.getEquipmentNo());
        receiverData.put("eventTime", data.getEventTime());
        for (DataReportEntity dataReportEntity :
                dataReportEntities) {
            receiverData.put(dataReportEntity.getDataKey(), dataReportEntity.getDataValue());
        }
        return receiverData;
    }
}