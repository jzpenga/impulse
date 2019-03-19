package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.IotDeviceModel;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.service.AdminDeviceModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("impulse/admin/deviceModel")
@Api(value = "iot平台设备类型管理", tags = "iot平台设备类型管理", description = "iot平台设备类型管理")
public class AdminDeviceModelController {
    private static Logger logger = LoggerFactory.getLogger(AdminDeviceModelController.class);
    @Autowired
    private AdminDeviceModelService adminDeviceModelService;

    @PostMapping("saveDeviceModel")
    @ApiOperation(value = "新增", notes = "新增iot设备类型", tags = "新增iot设备类型", httpMethod = "POST")
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

    @PostMapping("upload")
    @ApiOperation(value = "上传文件", notes = "新增iot设备类型", tags = "新增iot设备类型", httpMethod = "POST")
    public BaseResponse upload(@RequestParam("file") MultipartFile file, HttpSession session) {
        BaseResponse response = new BaseResponse();
        try {
            if (file.isEmpty()) {
                response.setResponseCode(ResponseCode.FILE_NOT_HAVE.getCode());
                response.setResponseMsg(ResponseCode.FILE_NOT_HAVE.getMessage());
                return response;
            }
            // 设置文件存储路径
            String path = session.getServletContext().getRealPath("/upload/");
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            // 检测是否存在目录
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(new File(path + File.separator + filename));// 文件写入

            response.setResponseCode(ResponseCode.OK.getCode());
            response.setResponseMsg(ResponseCode.OK.getMessage());
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
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }


}
