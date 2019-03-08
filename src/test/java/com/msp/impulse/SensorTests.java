package com.msp.impulse;

import com.msp.impulse.entity.Sensor;
import com.msp.impulse.query.SensorAddQuery;
import com.msp.impulse.service.SensorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorTests {

    @Autowired
    private SensorService sensorService;

    @Test
    public void testAddSensor() {

        Sensor sensor1 = new Sensor();
        sensor1.setName("智能压力液位变送器703304");
        sensor1.setDeviceId("b96e5bc4-1758-403c-a53b-b629c90813cd");
        sensor1.setSensorNo("868744030703304");
        sensor1.setSensorType("WaterMeter");
        sensor1.setSensorModel("HY600");

        Sensor sensor2 = new Sensor();
        sensor2.setName("智能压力液位变送器708766");
        sensor2.setDeviceId("15ed729f-cdf0-4fa0-af31-f2763300a074");
        sensor2.setSensorNo("868744030708766");
        sensor2.setSensorType("WaterMeter");
        sensor2.setSensorModel("HY600");

        Sensor sensor3 = new Sensor();
        sensor3.setName("智能压力液位变送器708410");
        sensor3.setDeviceId("e8de9755-97b1-425e-a75d-f849bc5ad661");
        sensor3.setSensorNo("868744030708410");
        sensor3.setSensorType("WaterMeter");
        sensor3.setSensorModel("HY600");

        Sensor sensor4 = new Sensor();
        sensor4.setName("智能压力液位变送器708436");
        sensor4.setDeviceId("b9e1d11b-140e-4310-a924-1b9f3216da19");
        sensor4.setSensorNo("868744030708436");
        sensor4.setSensorType("WaterMeter");
        sensor4.setSensorModel("HY600");

        Sensor sensor5 = new Sensor();
        sensor5.setName("智能压力液位变送器703452");
        sensor5.setDeviceId("09de02cb-7aa0-483a-b63d-37a9aeaa7f8e");
        sensor5.setSensorNo("868744030703452");
        sensor5.setSensorType("WaterMeter");
        sensor5.setSensorModel("HY600");

        SensorAddQuery sensorAddQuery1 = new SensorAddQuery();
        sensorAddQuery1.setSensor(sensor1);
        sensorAddQuery1.setPassList(new ArrayList<>());

        SensorAddQuery sensorAddQuery2 = new SensorAddQuery();
        sensorAddQuery2.setSensor(sensor2);
        sensorAddQuery2.setPassList(new ArrayList<>());

        SensorAddQuery sensorAddQuery3 = new SensorAddQuery();
        sensorAddQuery3.setSensor(sensor3);
        sensorAddQuery3.setPassList(new ArrayList<>());

        SensorAddQuery sensorAddQuery4 = new SensorAddQuery();
        sensorAddQuery4.setSensor(sensor4);
        sensorAddQuery4.setPassList(new ArrayList<>());

        SensorAddQuery sensorAddQuery5 = new SensorAddQuery();
        sensorAddQuery5.setSensor(sensor5);
        sensorAddQuery5.setPassList(new ArrayList<>());


        //sensor.setPassList(new ArrayList<>());
//        sensorService.saveSensor(sensorAddQuery1,7);
//        sensorService.saveSensor(sensorAddQuery2,7);
//        sensorService.saveSensor(sensorAddQuery3,7);
//        sensorService.saveSensor(sensorAddQuery4,7);
        //sensorService.saveSensor(sensorAddQuery5,7);
    }


}
