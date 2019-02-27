package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Company;
import com.msp.impulse.service.AdminService;
import com.msp.impulse.vo.CompanyDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/user")
@Api(value = "用户管理接口", tags = "用户管理接口", description = "用户管理接口API")
public class AdminUserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private AdminService adminService;

    @PostMapping("findUser")
    @ApiOperation(value = "查询用户数据", notes = "查询用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse<List<Company>> findUser(@RequestBody Company company) {
        BaseResponse<List<Company>> response;
        try {
            response = adminService.findUser(company);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
    @GetMapping("findUserById/{userId}")
    @ApiOperation(value = "根据id查询用户数据", notes = "根据id查询用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse<CompanyDetailVo> findUserById(@PathVariable String userId) {
        BaseResponse<CompanyDetailVo> response;
        try {
            response = adminService.findUserById(userId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

}
