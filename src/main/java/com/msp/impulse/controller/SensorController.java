package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Pass;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.query.PassQuery;
import com.msp.impulse.query.SensorQuery;
import com.msp.impulse.service.SensorService;
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
@RequestMapping("impulse/sensor")
@Api(value = "传感器接口", tags = "传感器接口", description = "传感器接口API")
public class SensorController {
    private static Logger logger = LoggerFactory.getLogger(SensorController.class);
    @Autowired
    private SensorService sensorService;

    @PostMapping("saveSensor")
    @ApiOperation(value="新增",notes = "新增或修改传感器",tags="传感器操作",httpMethod = "POST")
    public BaseResponse addSensor(@RequestBody Sensor sensor, HttpSession session){
        BaseResponse response;
        try{
            //获取用户id
            String  userId="";
            Company company= (Company)session.getAttribute("loginUser");
            if(company!=null){
                userId=company.getId();
            }
           response=sensorService.saveSensor(sensor,userId);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("querySensorById")
    @ApiOperation(value="根据id查询",notes = "根据id返显传感器信息,用于编辑操作",tags="传感器操作",httpMethod = "POST")
    public BaseResponse<Sensor> querySensorById(String id){
        BaseResponse<Sensor> response;
        try{
            response=sensorService.querySensorById(id);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("searchSensor")
    @ApiOperation(value = "查询", notes = "查询传感器相关信息", tags = "传感器操作", httpMethod = "POST")
    public BaseResponse<List<Sensor>> queryBySensorAndGateway(@RequestBody SensorQuery sensorQuery, HttpSession session){
        BaseResponse<List<Sensor>> response;
        try{
            //获取用户id
            String  userId="";
            Company company= (Company)session.getAttribute("loginUser");
            if(company!=null){
                userId=company.getId();
            }
            response=sensorService.queryBySensorAndGateway(sensorQuery,userId);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
    @PostMapping("queryByPassNoAndGatewayName")
    @ApiOperation(value = "根据网关通道号查询通道信息", notes = "根据网关通道号查询通道信息", tags = "传感器操作", httpMethod = "POST")
    public BaseResponse<Pass> queryByPassNoAndGatewayName(@RequestBody PassQuery passQuery){
        BaseResponse<Pass> response;
        try{
            response=sensorService.queryByPassNoAndGatewayName(passQuery);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @GetMapping("deleteSerson/{id}")
    @ApiOperation(value = "根据id删除传感器信息", notes = "根据id删除传感器信息", tags = "传感器操作", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "传感器ID", example = "1", required = true, dataType = "string")
    public BaseResponse deleteSensor(@PathVariable String id) {
        BaseResponse response;
        try {
            response = sensorService.deleteSensor(id);
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

    @GetMapping("deleteSensorBatch")
    @ApiOperation(value = "批量删除传感器信息", notes = "批量删除传感器信息", tags = "传感器操作", httpMethod = "GET")
    @ApiImplicitParam(name = "ids", value = "网关ID集合", example = "1，3,4", required = true, dataType = "string")
    public BaseResponse deleteSensorBatch(@RequestBody List<String> ids) {
        BaseResponse response;
        try {
            response = sensorService.deleteSensorBatch(ids);
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
    @GetMapping("querySensorNotRelation")
    @ApiOperation(value = "查询未被用户关联的传感器", notes = "查询未被用户关联的传感器", tags = "传感器操作", httpMethod = "GET")
    public BaseResponse<List<Sensor>> querySensorNotRelation() {
        BaseResponse<List<Sensor>> response;
        try {
            response = sensorService.querySensorNotRelation();
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
    @GetMapping("relationSensorAndUser")
    @ApiOperation(value = "传感器与用户关联", notes = "查询未被用户关联的传感器", tags = "传感器操作", httpMethod = "GET")
    public BaseResponse relationSensorAndUser(String userId,String sensorName) {
        BaseResponse response;
        try {
            response = sensorService.relationSensorAndUser(userId,sensorName);
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
