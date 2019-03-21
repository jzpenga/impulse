package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.service.AdminDeviceServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("impulse/admin/deviceService")
@Api(value = "服务类型管理", tags = "服务类型管理", description = "服务类型管理")
public class AdminDeviceServiceController {
    private static Logger logger = LoggerFactory.getLogger(AdminDeviceServiceController.class);
    @Autowired
    private AdminDeviceServiceService adminDeviceServiceService;

    @PostMapping("findDeviceType")
    @ApiOperation(value = "查询所有设备型号", notes = "查询所有设备型号", tags = "服务类型管理", httpMethod = "POST")
    public BaseResponse findDeviceType() {
        BaseResponse response;
        try {
            response = adminDeviceServiceService.findDeviceType();
        } catch (MyException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
}
