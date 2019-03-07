//package com.msp.impulse;
//
//import com.msp.impulse.entity.Sensor;
//import com.msp.impulse.service.SensorService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SensorTests {
//
//    @Autowired
//    private SensorService sensorService;
//
//    @Test
//    public void testAddSensor() {
//        Sensor sensor = new Sensor();
//        sensor.setName("智能压力液位变送器1");
//        sensor.setDeviceId("baeffdea-a3b6-4a74-bc4b-ed6dd1f310b2");
//        sensor.setLoginName("tom");
//        sensor.setSensorNo("a3b6-4a74-bc4b-ed6dd1f310b2");
//        sensor.setSensorType("WaterMeter");
//        sensor.setSensorModel("HY600");
//        sensor.setPassList(new ArrayList<>());
//        sensorService.saveSensor(sensor,"");
//    }
//
//
//}
