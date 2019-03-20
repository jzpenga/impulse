package com.msp.impulse.nb.handler.task;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iotplatform.client.dto.NotifyDeviceDataChangedDTO;
import com.msp.impulse.nb.entity.DataReportEntity;
import com.msp.impulse.service.DataReportService;
import com.msp.impulse.vo.DataReportVo;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

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
            ObjectNode data = dto.getService().getData();
            Iterator<String> fieldNames = data.fieldNames();
            String dataMark = UUID.randomUUID().toString();
            List<DataReportEntity> dataReportEntities = new ArrayList<>();
            fieldNames.forEachRemaining(fileName -> {
                DataReportEntity dataReportEntity = new DataReportEntity();
                dataReportEntity.setDeviceId(dto.getDeviceId());
                dataReportEntity.setServiceId(dto.getService().getServiceId());
                dataReportEntity.setServiceType(dto.getService().getServiceType());
                dataReportEntity.setEventTime(dto.getService().getEventTime());
                dataReportEntity.setDataKey(fileName);
                dataReportEntity.setEquipmentNo(param.getSensorNo());
                dataReportEntity.setDataValue(data.get(fileName).textValue());
                dataReportEntity.setDataMark(dataMark);
                dataReportEntities.add(dataReportEntity);
            });
            //System.out.println("入库数据 ====》 "+dataReportEntities);
            //入库
            long start = System.currentTimeMillis();
            boolean success = dataReportService.insertDateReport(dataReportEntities);
            logger.info("数据入库时间===>"+(System.currentTimeMillis()-start)/1000f+"秒");
            //System.out.println("入库 ===》 "+success);
            if (success){
                //调用相关接口
                if (!TextUtils.isEmpty(param.getCallbackUrl())){
                    String callbackUrl = param.getCallbackUrl();
                    //HashMap<String, Object> stringObjectHashMap = dataReportService.messageReceiver(dataMark);
                    //HashMap<String, Object> stringObjectHashMap = dataReportService.messageReceiver("0972d42d-5f8b-42db-ac68-7705584422f6");
                    //String s = JSONObject.toJSONString(stringObjectHashMap);
                    //String response = HttpClientUtil.doPostJson(callbackUrl, s);
                    //if (!StringUtils.isEmpty(response)){
                     //   logger.info(dto.getDeviceId()+" send "+dto.getService().getEventTime()+" data ====>  success!");
                   // }
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
