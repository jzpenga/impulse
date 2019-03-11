package com.msp.impulse.controller;

import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.query.GatewayAddQuery;
import com.msp.impulse.query.GatewayQuery;
import com.msp.impulse.service.GatewayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("impulse/gateway")
@Api(value = "网关管理", tags = "网关管理", description = "设备管理-网关管理")
public class GatewayController {
    private static Logger logger = LoggerFactory.getLogger(GatewayController.class);
    @Autowired
    private GatewayService gatewayService;

    @PostMapping("findGatewayByCondition")
    @ApiOperation(value = "根据条件查询网关", notes = "根据条件查询网关", tags = "网关管理", httpMethod = "POST")
    public BaseResponse<PageInfo> findGatewayByCondition(@RequestBody GatewayQuery gatewayQuery, HttpSession session) {
        BaseResponse<PageInfo> response;
        try {
            //获取用户id
            Integer userId=null;
            Company company= (Company)session.getAttribute("loginUser");
            if(company!=null&&gatewayQuery.getUserId()!=null){
                userId=company.getId();
                gatewayQuery.setUserId(userId);
            }
            response = gatewayService.findGatewayByCondition(gatewayQuery);
        } catch (MyException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
        }
        return response;
    }

    @GetMapping("findGatewayById/{id}")
    @ApiOperation(value = "根据id查询网关", notes = "根据id查询网关", tags = "网关管理", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "网关ID", example = "1", required = true, dataType = "string")
    public BaseResponse<Gateway> findGatewayById(@PathVariable Integer id) {
        BaseResponse<Gateway> response;
        try {
            response = gatewayService.findGatewayById(id);
        } catch (MyException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
        }
        return response;
    }

    @PostMapping("saveGateway")
    @ApiOperation(value = "新增修改网关信息", notes = "新增修改网关信息", tags = "网关管理", httpMethod = "POST")
    public BaseResponse addGateway(@RequestBody GatewayAddQuery gatewayAddQuery, HttpSession session) {
        BaseResponse response;
        try {
            //获取用户id
            Integer userId = null;
            Company company = (Company) session.getAttribute("loginUser");
            if (company != null) {
                userId = company.getId();
            }
            response = gatewayService.saveGateway(gatewayAddQuery, userId);
        } catch (MyException e) {
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @GetMapping("deleteGateway/{id}")
    @ApiOperation(value = "根据id删除网关信息", notes = "根据id删除网关信息", tags = "网关管理", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "网关ID", example = "1", required = true, dataType = "string")
    public BaseResponse deleteGateway(@PathVariable Integer id,HttpSession session) {
        BaseResponse response;
        try {
            //获取用户id
            Integer userId = null;
            Company company = (Company) session.getAttribute("loginUser");
            if (company != null) {
                userId = company.getId();
            }
            response = gatewayService.deleteGateway(id,userId);
        } catch (MyException e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;

    }

    @PostMapping("deleteGatewayBatch")
    @ApiOperation(value = "批量删除网关信息", notes = "批量删除网关信息", tags = "网关管理", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "网关ID集合", example = "1，3,4", required = true, dataType = "string")
    public BaseResponse deleteGatewayBatch(@RequestBody List<Integer> ids,HttpSession session) {
        BaseResponse response;
        try {
            //获取用户id
            Integer userId = null;
            Company company = (Company) session.getAttribute("loginUser");
            if (company != null) {
                userId = company.getId();
            }
            response = gatewayService.deleteGatewayBatch(ids,userId);
        } catch (MyException e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
}
