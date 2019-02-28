package com.msp.impulse;

import com.iotplatform.client.dto.DeviceInfo;
import com.msp.impulse.nb.utils.NBDXManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceManageTests {

    @Test
    public void testRegDevice() {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setName("AAAA");
        deviceInfo.setDeviceType("WaterMeter");
        deviceInfo.setModel("HY600");

        Random random = new Random();
        String nodeid = "testdemo" + (random.nextInt(9000000) + 1000000); //this is a test imei
        deviceInfo.setNodeId(nodeid);

        NBDXManager.registerDevice(deviceInfo);
    }

    @Test
    public void testDeleteDevice() {
        NBDXManager.deleteDevice("a54fa376-ca46-4292-bb19-07e83efb817e");
    }

}
