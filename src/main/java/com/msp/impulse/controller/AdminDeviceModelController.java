package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.IotDeviceModel;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.service.AdminDeviceModelService;
import com.msp.impulse.service.DataReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("impulse/admin/deviceModel")
@Api(value = "iot平台设备型号管理", tags = "iot平台设备型号管理", description = "iot平台设备型号管理")
public class AdminDeviceModelController {
    private static Logger logger = LoggerFactory.getLogger(AdminDeviceModelController.class);
    @Autowired
    private AdminDeviceModelService adminDeviceModelService;
    @Autowired
    private DataReportService dataReportService;

    @PostMapping("saveDeviceModel")
    @ApiOperation(value = "新增", notes = "新增iot设备类型", tags = "iot平台设备型号管理", httpMethod = "POST")
    public BaseResponse saveDeviceType(IotDeviceModel iotDeviceModel, HttpSession session) {
        BaseResponse response;
        try {
            response = adminDeviceModelService.saveDeviceType(iotDeviceModel,session);
        } catch (IllegalStateException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        }catch (MyException e) {
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

    @GetMapping("profileDownload")
    @ApiOperation(value = "profile文件下载", notes = "profile文件下载", tags = "iot平台设备型号管理", httpMethod = "GET")
    public BaseResponse profileDownload( String fileName, HttpServletResponse httpResponse,HttpSession session) {
        BaseResponse response=new BaseResponse();
        try {
             adminDeviceModelService.profileDownload(fileName,httpResponse,session);
        } catch (IllegalStateException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        }catch (MyException e) {
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

    @PostMapping("queryDeviceModelById/{id}")
    @ApiOperation(value = "根据id查询", notes = "根据id查询", tags = "iot平台设备型号管理", httpMethod = "POST")
    public BaseResponse queryDeviceModelById(@PathVariable Integer id) {
        BaseResponse response;
        try {

            response = adminDeviceModelService.queryDeviceModelById(id);
        }catch (MyException e) {
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
    @PostMapping("deleteDeviceModelById")
    @ApiOperation(value = "根据id删除", notes = "根据id删除", tags = "iot平台设备型号管理", httpMethod = "POST")
    public BaseResponse deleteDeviceModelById(@RequestBody List<Integer> ids) {
        BaseResponse response;
        try {
            response = adminDeviceModelService.deleteDeviceModelById(ids);
        }catch (MyException e) {
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
    @PostMapping("queryDeviceModelList")
    @ApiOperation(value = "查询列表", notes = "查询列表", tags = "iot平台设备型号管理", httpMethod = "POST")
    public BaseResponse queryDeviceModelList(@RequestBody IotDeviceModel iotDeviceModel) {
        BaseResponse response;
        try {
            response = adminDeviceModelService.queryDeviceModelList(iotDeviceModel);
        }catch (MyException e) {
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
    @GetMapping("test")
    @ApiOperation(value = "查询列表", notes = "查询列表", tags = "iot平台设备型号管理", httpMethod = "GET")
    public BaseResponse getDataReport(String deviceId) {
        BaseResponse response=new BaseResponse();
        try {
            dataReportService.getDataReport(deviceId);
        }catch (MyException e) {
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
