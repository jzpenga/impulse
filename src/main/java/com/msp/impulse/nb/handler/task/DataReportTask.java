package com.msp.impulse.nb.handler.task;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iotplatform.client.dto.NotifyDeviceDataChangedDTO;
import com.msp.impulse.nb.entity.DataReportEntity;
import com.msp.impulse.service.DataReportService;
import com.msp.impulse.util.HttpClientUtil;
import com.msp.impulse.vo.DataReportVo;
import org.apache.commons.lang.StringUtils;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DataReportTask implements Runnable {
    private Logger logger = LoggerFactory.getLogger(DataReportTask.class);

    private DataReportVo param;
    private NotifyDeviceDataChangedDTO dto;
    private DataReportService dataReportService;

    public DataReportTask(DataReportVo dataReportVo, NotifyDeviceDataChangedDTO notifyDeviceDataChangedDTO,DataReportService dataReportService) {
        this.param = dataReportVo;
        this.dto = notifyDeviceDataChangedDTO;
        this.dataReportService = dataReportService;
    }

    @Override
    public void run() {
        try {


            HashMap<String, String> subData = new HashMap<>();

            ObjectNode data = dto.getService().getData();
            Iterator<String> fieldNames = data.fieldNames();
            String dataMark = UUID.randomUUID().toString();
            List<DataReportEntity> dataReportEntities = new ArrayList<>();
            fieldNames.forEachRemaining(fieldName -> {
                DataReportEntity dataReportEntity = new DataReportEntity();
                dataReportEntity.setDeviceId(dto.getDeviceId());
                dataReportEntity.setServiceId(dto.getService().getServiceId());
                dataReportEntity.setServiceType(dto.getService().getServiceType());
                dataReportEntity.setEventTime(dto.getService().getEventTime());
                dataReportEntity.setDataKey(fieldName);
                dataReportEntity.setUserName(param.getCompanyName());
                dataReportEntity.setSensorName(param.getSensorName());
                dataReportEntity.setEquipmentNo(param.getSensorNo());
                dataReportEntity.setDataKeyName(param.getDataValueAndKey().get(fieldName));
                dataReportEntity.setDataValue(data.get(fieldName).textValue());
                dataReportEntity.setDataMark(dataMark);
                dataReportEntities.add(dataReportEntity);
                subData.put(fieldName,data.get(fieldName).textValue());
            });
            //System.out.println("入库数据 ====》 "+dataReportEntities);
            //入库
            long start = System.currentTimeMillis();
            boolean success = dataReportService.insertDateReport(dataReportEntities);
            logger.info("数据入库时间===>"+(System.currentTimeMillis()-start)/1000f+"秒");
            //System.out.println("入库 ===》 "+success);
            if (success){
                //调用相关接口
                String callbackUrl = param.getCallbackUrl();
                if (!TextUtils.isEmpty(callbackUrl)){
                    subData.put("deviceNo",param.getSensorNo());
                    subData.put("eventTime",dto.getService().getEventTime());
                    String s = JSONObject.toJSONString(subData);
                    String response = HttpClientUtil.doPostJson(callbackUrl, s);
                    if (!StringUtils.isEmpty(response)){
                        logger.info(dto.getDeviceId()+" send "+dto.getService().getEventTime()+" data ====>  success!");
                    }
                }else {
                    logger.info(dto.getDeviceId()+"====>未被订阅");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
