package com.msp.impulse;

import com.alibaba.fastjson.JSONObject;
import com.iotplatform.client.dto.NotifyDeviceDataChangedDTO;
import com.iotplatform.utils.JsonUtil;
import com.msp.impulse.util.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImpulseApplicationTests {

    @Test
    public void contextLoads() {

        new Thread(ImpulseApplicationTests::task).start();
        new Thread(ImpulseApplicationTests::task).start();
        new Thread(ImpulseApplicationTests::task).start();
        new Thread(ImpulseApplicationTests::task).start();
        new Thread(ImpulseApplicationTests::task).start();
    }

    public static void task() {
        String json = "{\"notifyType\":\"deviceDataChanged\",\"requestId\":null,\"deviceId\":\"baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2\",\"gatewayId\":\"baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2\",\"service\":{\"serviceId\":\"Pressure\",\"serviceType\":\"Pressure\",\"data\":{\"C130\":\"000.00\",\"C242\":\"3.6\",\"C256\":\"13\"},\"eventTime\":\"20190225T061821Z\"}}";
        NotifyDeviceDataChangedDTO dto = JsonUtil.jsonString2SimpleObj(json, NotifyDeviceDataChangedDTO.class);
        String s = JSONObject.toJSONString(dto);
        for (int i = 0; i < 1000; i++) {
            long startTime = System.currentTimeMillis();
            String response = HttpClientUtil.doPostJson("http://localhost:8072/v1.0.0/messageReceiver", s);
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"执行第 "+i+" 次耗时 "+(endTime-startTime)/1000f+"秒");
        }
    }

}
