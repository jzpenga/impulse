package com.msp.impulse.nb.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.service.SensorService;
import com.msp.impulse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1.0.0/device/")
public class DeviceController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private UserService userService;

    @PostMapping("getDeviceList")
    public BaseResponse<List<Sensor>> getDeviceList(@RequestBody Company para){
        BaseResponse<List<Sensor>> baseResponse = new BaseResponse<>();
        Company company = userService.findByNameAndPwd(para.getLoginName(), para.getPassword()).getData();
        if (company!=null){
            List<Sensor> deviceList = sensorService.getDeviceList(company.getLoginName());
            baseResponse.setResponseCode(200);
            baseResponse.setResponseMsg("success");
            baseResponse.setData(deviceList);
        }else {
            baseResponse.setResponseCode(403);
            baseResponse.setResponseMsg("用户名密码认证失败");
        }
        return baseResponse;
    }


}
