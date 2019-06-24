package com.msp.impulse.controller;

import com.auth0.jwt.JWT;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.RealTimeData;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.query.DataHistoryQuery;
import com.msp.impulse.service.DataManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("impulse/dataManage")
@Api(value = "数据管理", tags = "数据管理", description = "数据管理")
public class DataManageController {
    private static Logger logger = LoggerFactory.getLogger(DataManageController.class);
    @Autowired
    private DataManageService dataManageService;

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

    @PostMapping("findRealTimeData")
    @ApiOperation(value = "查询实时数据", notes = "查询实时数据", tags = "数据管理", httpMethod = "POST")
    public BaseResponse<PageInfo> findRealTimeData(@RequestBody DataHistoryQuery dataHistoryQuery, HttpServletRequest httpServletRequest) {
        BaseResponse<PageInfo> response = new BaseResponse<>();
//        if ("1".equals(dataHistoryQuery.getPageNo())){
//            RealDataVo realDataVo = new RealDataVo();
//            realDataVo.setTotal(2L);
//            List<DataReportEntity> dataReportEntities = new ArrayList<>();
//            DataReportEntity dataReportEntity = new DataReportEntity();
//            dataReportEntity.setDataValue("3.6");
//            dataReportEntity.setId("1");
//            dataReportEntity.setEventTime("2019-09-07 09:09:07");
//            dataReportEntity.setSensorName("智能压力液位变送器");
//            dataReportEntity.setTypeName("电池");
//            dataReportEntity.setGatewayName("智能");
//            dataReportEntities.add(dataReportEntity);
//            realDataVo.setList(dataReportEntities);
//            response.setData(realDataVo);
//        }
//        if ("2".equals(dataHistoryQuery.getPageNo())){
//            RealDataVo realDataVo = new RealDataVo();
//            realDataVo.setTotal(2L);
//            List<DataReportEntity> dataReportEntities = new ArrayList<>();
//            DataReportEntity dataReportEntity = new DataReportEntity();
//            dataReportEntity.setDataValue("18");
//            dataReportEntity.setId("2");
//            dataReportEntity.setEventTime("2019-09-07 09:10:07");
//            dataReportEntity.setSensorName("智能压力液位变送器");
//            dataReportEntity.setTypeName("信号强度");
//            dataReportEntity.setGatewayName("智能");
//            dataReportEntities.add(dataReportEntity);
//            realDataVo.setList(dataReportEntities);
//            response.setData(realDataVo);
//        }
        try {
            String token = httpServletRequest.getHeader("token");
            String userId = JWT.decode(token).getAudience().get(0);
            response = dataManageService.findRealTimeData(dataHistoryQuery,userId);
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
        response.setResponseMsg("success");
        response.setResponseCode(200);
        return response;
    }

    @PostMapping("findHistoryData")
    @ApiOperation(value = "查询历史数据", notes = "查询历史数据", tags = "数据管理", httpMethod = "POST")
    public BaseResponse findHistoryData(@RequestBody DataHistoryQuery dataHistoryQuery) {
        BaseResponse response;
        try {
            response = dataManageService.findHistoryData(dataHistoryQuery);
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
    @GetMapping("findRealTimeDataByDeviceId")
    @ApiOperation(value = "根据deviceId查询实时数据信息", notes = "根据deviceId查询实时数据信息", tags = "传感器操作", httpMethod = "GET")
    public BaseResponse<List<RealTimeData>> findRealTimeDataByDeviceId(String deviceId) {
        BaseResponse<List<RealTimeData>> response;
        try {
            response = dataManageService.findRealTimeDataByDeviceId(deviceId);
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
}
