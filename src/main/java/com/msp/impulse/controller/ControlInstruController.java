//package com.msp.impulse.controller;
//
//import com.msp.impulse.base.BaseResponse;
//import com.msp.impulse.base.ResponseCode;
//import com.msp.impulse.entity.Company;
//import com.msp.impulse.query.ControlInstruQuery;
//import com.msp.impulse.query.ControllnstruUpdateQuery;
//import com.msp.impulse.service.ControlInstruService;
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
//@RequestMapping("impulse/controlInstru")
//@Api(value = "控制指令", tags = "控制指令", description = "控制指令")
//public class ControlInstruController {
//    private static Logger logger = LoggerFactory.getLogger(ControlInstruController.class);
//
//    @Autowired
//    private ControlInstruService controlInstruService;
//
//    @PostMapping("findControlInstru")
//    @ApiOperation(value = "查询控制指令", notes = "查询控制指令", tags = "控制指令", httpMethod = "POST")
//    public BaseResponse findControlInstru(@RequestBody ControlInstruQuery controlInstruQuery, HttpSession session) {
//        BaseResponse response;
//        try {
//            //获取用户id
//            String  userId="";
//            Company company= (Company)session.getAttribute("loginUser");
//            if(company!=null){
//                userId=company.getId();
//            }
//            response = controlInstruService.findControlInstru(controlInstruQuery,userId);
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            response = new BaseResponse();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//
//    @PostMapping("updateControlInstru")
//    @ApiOperation(value = "修改控制指令", notes = "修改控制指令", tags = "控制指令", httpMethod = "POST")
//    public BaseResponse updateControlInstru(@RequestBody ControllnstruUpdateQuery updateQuery) {
//        BaseResponse response;
//        try {
//            response = controlInstruService.updateControlInstru(updateQuery);
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            response = new BaseResponse();
//            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
//            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
//        }
//        return response;
//    }
//    //TODO 修改返回状态
////    @PostMapping("updateReturnStaus")
////    @ApiOperation(value = "修改返回状态", notes = "修改控制指令返回状态", tags = "控制指令", httpMethod = "POST")
////    public BaseResponse updateReturnStaus() {
////        BaseResponse response;
////        try {
////            response = controlInstruService.updateControlInstru();
////        } catch (Exception e) {
////            logger.error(e.getMessage(),e);
////            response = new BaseResponse();
////            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
////            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
////        }
////        return response;
////    }
//}
