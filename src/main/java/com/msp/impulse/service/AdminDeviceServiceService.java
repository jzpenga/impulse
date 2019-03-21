package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.DeviceType;
import com.msp.impulse.entity.DeviceTypeExample;
import com.msp.impulse.mapper.DeviceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminDeviceServiceService {
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;
    public BaseResponse findDeviceType() {
        BaseResponse response=new BaseResponse();
        DeviceTypeExample deviceTypeExample=new DeviceTypeExample();
        deviceTypeExample.createCriteria().andFlagEqualTo("0");
        List<DeviceType> deviceTypeList = deviceTypeMapper.selectByExample(deviceTypeExample);
        response.setData(deviceTypeList);
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }
}
