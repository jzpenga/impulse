package com.msp.impulse.controller;

import com.auth0.jwt.JWT;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.User;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.query.AgentParam;
import com.msp.impulse.query.CompanyParam;
import com.msp.impulse.query.FindUserByIdQuery;
import com.msp.impulse.query.FindUserQuery;
import com.msp.impulse.service.AdminUserService;
import com.msp.impulse.vo.CompanyDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("impulse/admin/user")
@Api(value = "用户管理接口", tags = "用户管理接口", description = "用户管理接口API")
public class AdminUserController {
    private static Logger logger = LoggerFactory.getLogger(AdminUserController.class);
    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("findUser")
    @ApiOperation(value = "查询用户数据", notes = "查询用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse<PageInfo> findUser(@RequestBody FindUserQuery userQuery,HttpServletRequest httpServletRequest) {
        BaseResponse<PageInfo> response;
        try {
            String token = httpServletRequest.getHeader("token");
            String userId = JWT.decode(token).getAudience().get(0);
            response = adminUserService.findUser(userQuery,Integer.parseInt(userId));
        } catch(MyException e){
            logger.error(e.getMessage());
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
            response.setResponseMsg(e.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
    @PostMapping("findUserById")
    @ApiOperation(value = "根据id查询用户数据", notes = "根据id查询用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse<CompanyDetailVo> findUserById(@RequestBody FindUserByIdQuery findUserByIdQuery) {
        BaseResponse<CompanyDetailVo> response;
        try {
            response = adminUserService.findUserById(findUserByIdQuery);
        }catch(MyException e){
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
    /**
     * 新增修改用户数据
     */
    @PostMapping("saveUser")
    @ApiOperation(value = "新增修改用户数据", notes = "新增修改用户数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse saveUser(@RequestBody CompanyParam companyParam, HttpServletRequest httpServletRequest) {
        BaseResponse response;
        try {
            String token = httpServletRequest.getHeader("token");
            String userId = JWT.decode(token).getAudience().get(0);
            response = adminUserService.saveUser(companyParam,Integer.parseInt(userId));
        } catch(MyException e){
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

    /**
     * 新增修改用户数据
     */
    @PostMapping("saveAgent")
    @ApiOperation(value = "新增修改代理人", notes = "新增修改代理人", tags = "用户管理", httpMethod = "POST")
    public BaseResponse saveAgent(@RequestBody AgentParam agentParam, HttpServletRequest httpServletRequest) {
        BaseResponse response;
        try {
            String token = httpServletRequest.getHeader("token");
            String userId = JWT.decode(token).getAudience().get(0);
            response = adminUserService.saveAgent(agentParam,Integer.parseInt(userId));
        } catch(MyException e){
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
    /**
     * 批量删除用户数据
     */
    @PostMapping("deleteUserBatch")
    @ApiOperation(value = "批量删除用户数据", notes = "批量删除用户数据", tags = "用户管理", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "用户id", example = "1，3,4", required = true, dataType = "string")
    public BaseResponse deleteUserBatch(@RequestBody List<Integer> ids, HttpServletRequest httpServletRequest) {
        BaseResponse response;
        try {
            String token = httpServletRequest.getHeader("token");
            String userId = JWT.decode(token).getAudience().get(0);
            response = adminUserService.deleteUserBatch(ids,Integer.parseInt(userId));
        }catch(MyException e){
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
    /**
     * 根据名称搜索代理人
     */
    @GetMapping("searchAgentByName")
    @ApiOperation(value = "根据用户名称搜索代理人", notes = "根据用户名称搜索代理人", tags = "用户管理", httpMethod = "GET")
    public BaseResponse searchAgentByName( String agentName) {
        BaseResponse response;
        try {
            response = adminUserService.searchAgentByName(agentName);
        } catch(MyException e){
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

    @GetMapping("findAgentById/{id}")
    @ApiOperation(value = "根据id查询代理人数据", notes = "根据id查询代理人数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse<User> findAgentById(@PathVariable Integer id) {
        BaseResponse<User> response;
        try {
            response = adminUserService.findAgentById(id);
        }catch(MyException e){
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


    @PostMapping("deleteAgent")
    @ApiOperation(value = "批量删除代理人数据", notes = "批量删除代理人数据", tags = "用户管理", httpMethod = "POST")
    public BaseResponse deleteAgent(@RequestBody List<Integer> ids, HttpServletRequest httpServletRequest) {
        BaseResponse response;
        try {
            String token = httpServletRequest.getHeader("token");
            String userId = JWT.decode(token).getAudience().get(0);
            response = adminUserService.deleteAgent(ids,Integer.parseInt(userId));
        }catch(MyException e){
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
