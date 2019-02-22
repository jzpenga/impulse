package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Admin;
import com.msp.impulse.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/user")
@Api(value = "用户管理接口", tags = "用户管理接口", description = "用户管理接口API")
public class AdminUserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private AdminService adminService;

    @PostMapping("findUser")
    @ApiOperation(value = "查询用户数据", notes = "查询用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse<Admin> findUser(@RequestBody Admin admin) {
        BaseResponse<Admin> response;
        try {
            response = adminService.addAdmin(admin);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
}
