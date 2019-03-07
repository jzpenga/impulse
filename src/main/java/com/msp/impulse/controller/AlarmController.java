//package com.msp.impulse.controller;
//
//import com.msp.impulse.base.BaseResponse;
//import com.msp.impulse.base.ResponseCode;
//import com.msp.impulse.entity.Company;
//import com.msp.impulse.query.AlarmQuery;
//import com.msp.impulse.service.AlarmService;
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
//import javax.servlet.http.HttpSession;
//
//@RestController
//@RequestMapping("impulse/alarmManage")
//@Api(value = "警报管理", tags = "警报管理", description = "警报管理")
//public class AlarmController {
//    private static Logger logger = LoggerFactory.getLogger(AlarmController.class);
//    @Autowired
//    private AlarmService alarmService;
//
//    @PostMapping("findAlarm")
//    @ApiOperation(value = "查询警报", notes = "查询警报", tags = "警报管理", httpMethod = "POST")
//    public BaseResponse findAlarm(@RequestBody AlarmQuery alarmQuery, HttpSession session) {
//        BaseResponse response;
//        try {
//            //获取用户id
//            String  userId="";
//            Company company= (Company)session.getAttribute("loginUser");
//            if(company!=null){
//                userId=company.getId();
//            }
//            response = alarmService.findAlarm(alarmQuery,userId);
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            response = new BaseResponse();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//}
