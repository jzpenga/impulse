package com.msp.impulse.nb.handler;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iotplatform.client.dto.NotifyDeviceDataChangedDTO;
import com.iotplatform.utils.JsonUtil;
import com.msp.impulse.dao.DataReportDao;
import com.msp.impulse.dao.UserDao;
import com.msp.impulse.entity.User;
import com.msp.impulse.nb.entity.DataReportEntity;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import com.msp.impulse.nb.service.SubscribeInfoService;
import com.msp.impulse.service.DataReportService;
import com.msp.impulse.service.UserService;
import com.msp.impulse.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Component
public class DeviceDataChangeHandler implements IDataHandler<NotifyDeviceDataChangedDTO>{

    @Autowired
    private DataReportService dataReportService;

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
                dataReportEntity.setDataValue(data.get(fileName).toString());
                dataReportEntity.setDataMark(dataMark);
                System.out.println(dataReportEntity);
                dataReportEntities.add(dataReportEntity);
            });
            //入库
            System.out.println(dataReportService.toString());
            //调用相关接口
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String json = "{\"notifyType\":\"deviceDataChanged\",\"requestId\":null,\"deviceId\":\"baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2\",\"gatewayId\":\"baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2\",\"service\":{\"serviceId\":\"Pressure\",\"serviceType\":\"Pressure\",\"data\":{\"C130\":\"000.00\",\"C242\":\"3.6\",\"C256\":\"13\"},\"eventTime\":\"20190225T061821Z\"}}";
        NotifyDeviceDataChangedDTO dto = JsonUtil.jsonString2SimpleObj(json, NotifyDeviceDataChangedDTO.class);

//        System.out.println(dto.toString());
//        String response = HttpClientUtil.doPostJson("http://39.105.86.90:8072/v1.0.0/messageReceiver", json);
//        System.out.println(response);
    }
}
