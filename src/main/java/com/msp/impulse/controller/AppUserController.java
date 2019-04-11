package com.msp.impulse.controller;

import com.auth0.jwt.JWT;
import com.msp.impulse.annotation.UserLoginToken;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.query.AppSensorQuery;
import com.msp.impulse.query.AppUserLoginParam;
import com.msp.impulse.service.SensorService;
import com.msp.impulse.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("impulse/app/user")
@Api(value = "app用户管理接口", tags = "app用户管理接口", description = "app用户管理接口API")
public class AppUserController {
    private static Logger logger = LoggerFactory.getLogger(AppUserController.class);

    @Autowired
    private SensorService sensorService;
    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation(value = "用户登录", notes = "用户登录", tags = "app用户管理接口", httpMethod = "POST")
    public BaseResponse login(@RequestBody AppUserLoginParam appUserLoginParam) {

        BaseResponse response = new BaseResponse();
        try {
            response = userService.login(appUserLoginParam.getLoginName(), appUserLoginParam.getPassword());
        } catch (MyException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("scanSaveSensor")
    @ApiOperation(value="新增",notes = "新增或修改传感器",tags="app用户管理接口",httpMethod = "POST")
    @UserLoginToken
    public BaseResponse addSensor(@RequestBody AppSensorQuery appSensorQuery, HttpServletRequest httpServletRequest){
        BaseResponse response;
        try{
            String token = httpServletRequest.getHeader("token");
            String consumerId = JWT.decode(token).getAudience().get(0);
            response=sensorService.saveAppSensor(appSensorQuery,consumerId);
        }catch (MyException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        } catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("findUserByToken")
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息", tags = "app用户管理接口", httpMethod = "POST")
    public BaseResponse findUserInfo(HttpServletRequest httpServletRequest) {

        BaseResponse response = new BaseResponse();
        try {
            String token = httpServletRequest.getHeader("token");
            String userId = JWT.decode(token).getAudience().get(0);
            response = userService.findUserInfo(userId);
        } catch (MyException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }


}
