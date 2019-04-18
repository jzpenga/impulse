package com.msp.impulse.controller;

import com.auth0.jwt.JWT;
import com.msp.impulse.annotation.PassToken;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Company;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("impulse/user")
@Api(value = "用户接口", tags = "用户接口", description = "用户接口API")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PassToken
    @PostMapping("login")
    @ApiOperation(value = "用户登录", notes = "用户登录", tags = "登录登出", httpMethod = "POST")
    public BaseResponse login(@RequestBody Company company) {

        BaseResponse response = new BaseResponse();
        try {
            response = userService.loginByNameAndPwd(company.getLoginName(), company.getPassword());
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

    @PostMapping("logout")
    @ApiOperation(value = "退出登录", notes = "退出登录", tags = "登录登出", httpMethod = "POST")
    public BaseResponse logout(HttpSession session) {

        BaseResponse response = new BaseResponse();
        //退出登录
        session.removeAttribute("loginUser");
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }


    @GetMapping("modifyPwd")
    @ApiOperation(value = "修改密码", notes = "修改密码", tags = "修改密码", httpMethod = "GET")
    public BaseResponse modifyPwd(String oPwd, String newPwd , HttpServletRequest httpServletRequest) {
        BaseResponse response = new BaseResponse<>();
        try {
            String token = httpServletRequest.getHeader("token");
            String userId = JWT.decode(token).getAudience().get(0);
            //更新密码
            response = userService.modifyPwd(userId, oPwd, newPwd);
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
