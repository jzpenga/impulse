package com.msp.impulse.controller;

import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Dictionary;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.query.ChildDicQuery;
import com.msp.impulse.query.DicQuery;
import com.msp.impulse.service.AdminDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("impulse/admin/dicManage")
@Api(value = "数据字典管理", tags = "数据字典管理", description = "数据字典管理")
public class AdminDicController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private AdminDicService adminDicService;
    @GetMapping("findDicById/{id}")
    @ApiOperation(value = "根据id查询数据字典", notes = "根据id查询数据字典", tags = "数据字典管理", httpMethod = "POST")
    public BaseResponse<Dictionary> findDicById(@PathVariable Integer id) {
        BaseResponse<Dictionary> response;
        try {
            response = adminDicService.findDicById(id);
        }  catch(MyException e){
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
    @PostMapping("addDictionary")
    @ApiOperation(value = "新增数据字典", notes = "新增数据字典", tags = "数据字典管理", httpMethod = "POST")
    public BaseResponse addDictionary(@RequestBody Dictionary dictionary) {
        BaseResponse response;
        try {
            response = adminDicService.addDictionary(dictionary);
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

    @PostMapping("findDicByCondition")
    @ApiOperation(value = "根据条件查询数据字典", notes = "根据条件查询数据字典", tags = "数据字典管理", httpMethod = "POST")
    public BaseResponse<PageInfo> findDicByCondition(@RequestBody DicQuery dicQuery) {
        BaseResponse<PageInfo> response;
        try {
            response = adminDicService.findDicByCondition(dicQuery);
        }  catch(MyException e){
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
    @PostMapping("findChildDicCode")
    @ApiOperation(value = "根据id查询子系统编码", notes = "根据id查询子系统编码", tags = "数据字典管理", httpMethod = "POST")
    public BaseResponse<PageInfo> findChildDicCode(@RequestBody ChildDicQuery childDicQuery) {
        BaseResponse<PageInfo> response;
        try {
            response = adminDicService.findChildDicCode(childDicQuery);
        }  catch(MyException e){
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
    @PostMapping("deleteDic")
    @ApiOperation(value = "批量删除数据字典", notes = "批量删除数据字典", tags = "数据字典管理", httpMethod = "POST")
    @ApiImplicitParam(name = "ids", value = "数据字典id", example = "1，3,4", required = true, dataType = "string")
    public BaseResponse deleteDic(@RequestBody List<Integer> ids) {
        BaseResponse response;
        try {
            response = adminDicService.deleteDic(ids);
        }  catch(MyException e){
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

//    @GetMapping("findAllDic/{id}")
//    @ApiOperation(value = "根据id查询数据字典", notes = "根据id查询数据字典", tags = "数据字典管理", httpMethod = "POST")
//    public BaseResponse findAllDic(@PathVariable Integer id) {
//        BaseResponse response;
//        try {
//            response = adminDicService.findAllDic(id);
//        }  catch(MyException e){
//            logger.error(e.getMessage());
//            response = new BaseResponse();
//            response.setResponseCode(ResponseCode.PARAMETER_VALIDATION_FAILED.getCode());
//            response.setResponseMsg(e.getMessage());
//        }catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            response = new BaseResponse<>();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }

    @GetMapping("findAllDic/{id}")
    @ApiOperation(value = "根据id查询数据字典", notes = "根据id查询数据字典", tags = "数据字典管理", httpMethod = "POST")
    public BaseResponse findAllDic(@PathVariable Integer id) {
        BaseResponse response;
        try {
            response = adminDicService.findAllDic(id);
        }  catch(MyException e){
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
}
