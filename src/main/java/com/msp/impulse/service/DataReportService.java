package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.DataReportDao;
import com.msp.impulse.dao.SensorDao;
import com.msp.impulse.nb.entity.DataReportEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataReportService {
    @Autowired
    private DataReportDao dataReportDao;
    @Autowired
    private SensorDao sensorDao;

    /**
     * 入库
     */
    @Transactional
    public BaseResponse insertDateReport(List<DataReportEntity> dataReportEntityList) {
        BaseResponse response = new BaseResponse<>();
        for (DataReportEntity dataReportEntity:dataReportEntityList) {
            //根据deviceId查找序列号
            String sensorNo=sensorDao.findByDeviceId(dataReportEntity.getDeviceId());
            if(StringUtils.isNotBlank(sensorNo)){
                dataReportEntity.setEquipmentNo(sensorNo);
            }
            dataReportDao.save(dataReportEntity);
        }
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return  response;
    }

}
