package com.msp.impulse.service;

import com.msp.impulse.dao.DataReportDao;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.exception.MyException;
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

    /**
     * 入库
     */
    @Transactional
    public boolean insertDateReport(List<DataReportEntity> dataReportEntityList) {
        try {
            //查询usrId
            Sensor sensor = sensorMapper.findSensorByDeviceId(dataReportEntityList.get(0).getDeviceId());
            if(sensor==null){
                throw  new MyException("请输入传感器信息");
            }
            Integer userId=sensor.getUserId();
            for (DataReportEntity dataReportEntity : dataReportEntityList) {
                if(userId!=null){
                    dataReportEntity.setUserId(userId);
                }
                //根据deviceId查找序列号
                String sensorNo = sensorMapper.findByDeviceId(dataReportEntity.getDeviceId());
                if (StringUtils.isNotBlank(sensorNo)) {
                    dataReportEntity.setEquipmentNo(sensorNo);
                }
                dataReportEntity.setSensorName(sensor.getName());
                if(StringUtils.isNotBlank(dataReportEntity.getGatewayName())){
                    dataReportEntity.setGatewayName(dataReportEntity.getGatewayName());
                }
                dataReportDao.save(dataReportEntity);
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