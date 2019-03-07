//package com.msp.impulse.controller;
//
//import com.msp.impulse.base.BaseResponse;
//import com.msp.impulse.base.ResponseCode;
//import com.msp.impulse.query.DataHistoryQuery;
//import com.msp.impulse.service.DataManageService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//@RequestMapping("impulse/dataManage")
//@Api(value = "数据管理", tags = "数据管理", description = "数据管理")
//public class DataManageController {
//    private static Logger logger = LoggerFactory.getLogger(DataManageController.class);
//    @Autowired
//    private DataManageService dataManageService;
//
//    @PostMapping("findHomeData")
//    @ApiOperation(value = "首页总览", notes = "首页总览", tags = "数据管理", httpMethod = "POST")
//    public BaseResponse findSenorByCondition() {
//        BaseResponse response;
//        try {
//            response = dataManageService.findHomeData();
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            response = new BaseResponse();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//    @PostMapping("extAlarmData")
//    @ApiOperation(value = "导出报警信息", notes = "导出报警信息", tags = "数据管理", httpMethod = "POST")
//    public void extAlarmData(HttpServletResponse servletResponse) {
//        try {
//            dataManageService.extAlarmData(servletResponse);
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//        }
//    }
//    @PostMapping("extControllnstruData")
//    @ApiOperation(value = "导出操作指令信息", notes = "导出操作指令信息", tags = "数据管理", httpMethod = "POST")
//    public void extControllnstruData(HttpServletResponse servletResponse) {
//        try {
//            dataManageService.extControllnstruData(servletResponse);
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//        }
//    }
//
//    @PostMapping("findRealTimeData")
//    @ApiOperation(value = "查询实时数据", notes = "查询实时数据", tags = "数据管理", httpMethod = "POST")
//    public BaseResponse findRealTimeData(@RequestBody DataHistoryQuery dataHistoryQuery) {
//        BaseResponse response;
//        try {
//            response = dataManageService.findRealTimeData(dataHistoryQuery);
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            response = new BaseResponse();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//
//    @PostMapping("findHistoryData")
//    @ApiOperation(value = "查询历史数据", notes = "查询历史数据", tags = "数据管理", httpMethod = "POST")
//    public BaseResponse findHistoryData(@RequestBody DataHistoryQuery dataHistoryQuery) {
//        BaseResponse response;
//        try {
//            response = dataManageService.findHistoryData(dataHistoryQuery);
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            response = new BaseResponse();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//
//    @PostMapping("findMapData")
//    @ApiOperation(value = "查询地图数据", notes = "查询地图数据", tags = "数据管理", httpMethod = "POST")
//    public BaseResponse findMapData() {
//        BaseResponse response;
//        try {
//            response = dataManageService.findMapData();
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            response = new BaseResponse();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//}
