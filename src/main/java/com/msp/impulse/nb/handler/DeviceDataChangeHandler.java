package com.msp.impulse.nb.handler;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iotplatform.client.dto.NotifyDeviceDataChangedDTO;
import com.iotplatform.utils.JsonUtil;
import com.msp.impulse.nb.entity.DataReportEntity;
import com.msp.impulse.nb.service.SubscribeInfoService;
import com.msp.impulse.service.DataReportService;
import com.msp.impulse.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Component
public class DeviceDataChangeHandler implements IDataHandler<NotifyDeviceDataChangedDTO>{

    private Logger logger = LoggerFactory.getLogger(DeviceDataChangeHandler.class);
    @Autowired
    private DataReportService dataReportService;
    @Autowired
    private SubscribeInfoService subscribeInfoService;

    @Override
    public void handler(NotifyDeviceDataChangedDTO dto) {
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
                dataReportEntity.setDataValue(data.get(fileName).textValue());
                dataReportEntity.setDataMark(dataMark);
                dataReportEntities.add(dataReportEntity);
            });
            //System.out.println("入库数据 ====》 "+dataReportEntities);
            //入库
            boolean success = dataReportService.insertDateReport(dataReportEntities);
            //System.out.println("入库 ===》 "+success);
//            if (success){
//                //调用相关接口
//                String callbackUrl = subscribeInfoService.getSubscribeInfoByDeviceId(dto.getDeviceId()).getCallbackUrl();
//                HashMap<String, Object> stringObjectHashMap = dataReportService.messageReceiver(dataMark);
//                String s = JSONObject.toJSONString(stringObjectHashMap);
//                String response = HttpClientUtil.doPostJson(callbackUrl, s);
//                if (!StringUtils.isEmpty(response)){
//                    logger.info(dto.getDeviceId()+" send "+dto.getService().getEventTime()+" data ====>  success!");
//                }
//            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        //String json = "{\"notifyType\":\"deviceDataChanged\",\"requestId\":null,\"deviceId\":\"baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2\",\"gatewayId\":\"baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2\",\"service\":{\"serviceId\":\"Pressure\",\"serviceType\":\"Pressure\",\"data\":{\"C130\":\"000.00\",\"C242\":\"3.6\",\"C256\":\"13\"},\"eventTime\":\"20190225T061821Z\"}}";
        //NotifyDeviceDataChangedDTO dto = JsonUtil.jsonString2SimpleObj(json, NotifyDeviceDataChangedDTO.class);

//        System.out.println(dto.toString());
//        String response = HttpClientUtil.doPostJson("http://39.105.86.90:8072/v1.0.0/messageReceiver", json);
//        System.out.println(response);

        /*new Thread(DeviceDataChangeHandler::task).start();
        new Thread(DeviceDataChangeHandler::task).start();
        new Thread(DeviceDataChangeHandler::task).start();
        new Thread(DeviceDataChangeHandler::task).start();
        new Thread(DeviceDataChangeHandler::task).start();*/

        for (int i = 0; i < 5; i++) {
            new Thread(DeviceDataChangeHandler::task).start();
        }

    }

    private  static void task() {
        String json = "{\"notifyType\":\"deviceDataChanged\",\"requestId\":null,\"deviceId\":\"baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2\",\"gatewayId\":\"baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2\",\"service\":{\"serviceId\":\"Pressure\",\"serviceType\":\"Pressure\",\"data\":{\"C130\":\"000.00\",\"C242\":\"3.6\",\"C256\":\"13\"},\"eventTime\":\"20190225T061821Z\"}}";
        NotifyDeviceDataChangedDTO dto = JsonUtil.jsonString2SimpleObj(json, NotifyDeviceDataChangedDTO.class);
        String s = JSONObject.toJSONString(dto);
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            String response = HttpClientUtil.doPostJson("http://localhost:8072/v1.0.0/messageReceiver", s);
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"执行第 "+i+" 次耗时 "+(endTime-startTime)/1000f+"秒");
            //LoggerFactory.getLogger(DeviceDataChangeHandler.class).info(Thread.currentThread().getName()+"执行第 "+i+" 次耗时 "+(endTime-startTime)/1000f+"秒");
        }
    }
}
