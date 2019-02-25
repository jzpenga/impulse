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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin/adminManage")
@Api(value = "管理员信息", tags = "管理员信息管理", description = "管理员信息管理")
public class AdminController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private  AdminService adminService;

    @PostMapping("addAdmin")
    @ApiOperation(value = "新增修改管理员", notes = "新增管理员", tags = "管理员操作", httpMethod = "POST")
    public BaseResponse<Admin> addAdmin(@RequestBody Admin admin) {
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

    @GetMapping("findAdminById/{id}")
    @ApiOperation(value = "根据id查询管理员", notes = "根据id查询管理员", tags = "管理员操作", httpMethod = "POST")
    public BaseResponse<Admin> findAdminById(@PathVariable String id) {
        BaseResponse<Admin> response;
        try {
            response = adminService.findAdminById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @GetMapping("deleteAdminById/{id}")
    @ApiOperation(value = "根据id删除管理员", notes = "根据id删除管理员", tags = "管理员操作", httpMethod = "POST")
    public BaseResponse deleteAdminById(@PathVariable String id) {
        BaseResponse response;
        try {
            response = adminService.deleteAdminById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("adminLogin")
    @ApiOperation(value = "管理员登录", notes = "管理员登录", tags = "管理员操作", httpMethod = "POST")
    public BaseResponse adminLogin(@RequestBody Admin admin, HttpSession session) {
        BaseResponse response;
        try {
            response = adminService.findByNameAndPwd(admin.getLoginName(), admin.getPassword());
            //记录登录状态
            session.setAttribute("loginAdmin", response.getData());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("adminLogout")
    @ApiOperation(value = "退出登录", notes = "退出登录", tags = "登录登出", httpMethod = "POST")
    public BaseResponse logout(HttpSession session) {

        BaseResponse response = new BaseResponse();
        //退出登录
        session.removeAttribute("loginAdmin");
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
