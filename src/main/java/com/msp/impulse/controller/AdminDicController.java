//package com.msp.impulse.controller;
//
//import com.msp.impulse.base.BaseResponse;
//import com.msp.impulse.base.ResponseCode;
//import com.msp.impulse.entity.DataDictionary;
//import com.msp.impulse.service.AdminDicService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("admin/dicManage")
//@Api(value = "数据字典管理", tags = "数据字典管理", description = "数据字典管理")
//public class AdminDicController {
//    private static Logger logger = LoggerFactory.getLogger(UserController.class);
//    @Autowired
//    private AdminDicService adminDicService;
//    @GetMapping("findDicById/{id}")
//    @ApiOperation(value = "根据id查询数据字典", notes = "根据id查询数据字典", tags = "数据字典管理", httpMethod = "POST")
//    public BaseResponse<DataDictionary> findDicById(@PathVariable String  id) {
//        BaseResponse<DataDictionary> response;
//        try {
//            response = adminDicService.findDicById(id);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            response = new BaseResponse<>();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//    @GetMapping("addDictionary")
//    @ApiOperation(value = "新增数据字典", notes = "新增数据字典", tags = "数据字典管理", httpMethod = "POST")
//    public BaseResponse addDictionary(@RequestBody DataDictionary dataDictionary) {
//        BaseResponse response;
//        try {
//            response = adminDicService.addDictionary(dataDictionary);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            response = new BaseResponse<>();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//
//    @GetMapping("findDicByCondition")
//    @ApiOperation(value = "根据条件查询数据字典", notes = "根据条件查询数据字典", tags = "数据字典管理", httpMethod = "POST")
//    public BaseResponse<List<DataDictionary>> findDicByCondition(String  groupCode) {
//        BaseResponse<List<DataDictionary>> response;
//        try {
//            response = adminDicService.findDicByGroupCode(groupCode);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            response = new BaseResponse<>();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//}
