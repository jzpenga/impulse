package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.query.FindUserQuery;
import com.msp.impulse.query.GateSenPageQuery;
import com.msp.impulse.query.SaveUserQuery;
import com.msp.impulse.service.AdminUserService;
import com.msp.impulse.vo.CompanyDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
    private AdminUserService adminUserService;

    @PostMapping("findUser")
    @ApiOperation(value = "查询用户数据", notes = "查询用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse<PageBean> findUser(@RequestBody FindUserQuery userQuery) {
        BaseResponse<PageBean> response;
        try {
            response = adminUserService.findUser(userQuery);
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
            response = adminUserService.findUserById(userId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
    /**
     * 新增修改用户数据
     */
    @PostMapping("saveUser")
    @ApiOperation(value = "新增修改用户数据", notes = "新增修改用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse saveUser(@RequestBody SaveUserQuery saveUserQuery) {
        BaseResponse response;
        try {
            response = adminUserService.saveUser(saveUserQuery);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
    /**
     * 根据id删除用户数据
     */
    @PostMapping("deleteUserById/{userId}")
    @ApiOperation(value = "根据id删除用户数据", notes = "根据id删除用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse deleteUserById(@PathVariable String userId) {
        BaseResponse response;
        try {
            response = adminUserService.deleteUserById(userId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
    /**
     * 批量删除用户数据
     */
    @PostMapping("deleteUserBatch")
    @ApiOperation(value = "批量删除用户数据", notes = "批量删除用户数据", tags = "用户管理", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "用户id", example = "1，3,4", required = true, dataType = "string")
    public BaseResponse deleteUserBatch(@RequestBody List<String> ids) {
        BaseResponse response;
        try {
            response = adminUserService.deleteUserBatch(ids);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
    /**
     * 根据userId分页查询网关信息
     */
    @PostMapping("findGatewayByUserId")
    @ApiOperation(value = "根据userId分页查询网关信息", notes = "根据userId分页查询网关信息", tags = "用户管理", httpMethod = "POST")
    public BaseResponse findGatewayByUserId(@RequestBody GateSenPageQuery gateSenPageQuery) {
        BaseResponse response;
        try {
            response = adminUserService.findGatewayByUserId(gateSenPageQuery);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
    /**
     * 根据userId分页查询网关信息
     */
    @PostMapping("findSensorByUserId")
    @ApiOperation(value = "根据userId分页查询传感器信息", notes = "根据userId分页查询传感器信息", tags = "用户管理", httpMethod = "POST")
    public BaseResponse findSensorByUserId(@RequestBody GateSenPageQuery gateSenPageQuery) {
        BaseResponse response;
        try {
            response = adminUserService.findSensorByUserId(gateSenPageQuery);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
}
