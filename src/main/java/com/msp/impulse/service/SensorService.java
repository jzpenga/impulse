package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.PassDao;
import com.msp.impulse.dao.SensorDao;
import com.msp.impulse.dao.UserDao;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Pass;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.query.PassQuery;
import com.msp.impulse.query.SensorQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorDao sensorDao;
    @Autowired
    private PassDao passDao;
    @Autowired
    private UserDao userDao;

    /**
     * 新增传感器
     *
     * @param sensor
     * @return
     */
    public BaseResponse saveSensor(Sensor sensor, String userId) {
        BaseResponse response = new BaseResponse();
        //名称必输
        if (StringUtils.isBlank(sensor.getName())) {
            response.setResponseCode(ResponseCode.SENSOR_NULL.getCode());
            response.setResponseMsg(ResponseCode.SENSOR_NULL.getMessage());
            return response;
        }
        if (StringUtils.isBlank(sensor.getId())) {
            //判断网关名称是否唯一
            if (sensorDao.findByName(sensor.getName())) {
                response.setResponseCode(ResponseCode.SENSOR_REPEAT.getCode());
                response.setResponseMsg(ResponseCode.SENSOR_REPEAT.getMessage());
                return response;
            }
        }
        //新增通道
        List<Pass> passList = new ArrayList<>();
        for (Pass pass : sensor.getPassList()) {
            if (StringUtils.isNotBlank(sensor.getName())) {
                pass.setSensorName(sensor.getName());
            }
            Pass passReturn = passDao.save(pass);
            passList.add(passReturn);
        }
        //用户id
        if (StringUtils.isNotBlank(userId)) {
            sensor.setUserId(userId);
        }
        sensor.setPassList(passList);
        sensor.setCreateTime(new Date());
        sensorDao.save(sensor);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据传感器名称和网关查询传感器信息
     *
     * @param sensorQuery
     * @return
     */
    public BaseResponse<List<Sensor>> queryBySensorAndGateway(SensorQuery sensorQuery, String userId) {

        BaseResponse<List<Sensor>> response = new BaseResponse<>();
        //最小页为第一页
        if (sensorQuery.getPageNo() == null || sensorQuery.getPageNo() < 1) {
            sensorQuery.setPageNo(0);
        }
        if (sensorQuery.getPageSize() == null || sensorQuery.getPageSize() < 1) {
            sensorQuery.setPageSize(10);
        }
        List<Sensor> sensorList = sensorDao.queryBySensorAndGateway(sensorQuery, userId);
        response.setData(sensorList);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据id查询传感器
     *
     * @param id
     * @return
     */
    public BaseResponse<Sensor> querySensorById(String id) {
        BaseResponse<Sensor> response = new BaseResponse<>();
        Sensor sensor = sensorDao.findOne(id);
        response.setData(sensor);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据网关名称，通道号查询通道信息
     *
     * @param passQuery
     * @return
     */
    public BaseResponse<Pass> queryByPassNoAndGatewayName(PassQuery passQuery) {
        BaseResponse response = new BaseResponse();
        Pass pass = sensorDao.queryByPassNoAndGatewayName(passQuery);
        response.setData(pass);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 删除传感器
     *
     * @param id
     * @return
     */
    public BaseResponse deleteSensor(String id) {
        BaseResponse response = new BaseResponse();
        sensorDao.findAndRemove(id);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 删除传感器
     *
     * @param ids
     * @return
     */
    @Transactional
    public BaseResponse deleteSensorBatch(List<String> ids) {
        BaseResponse response = new BaseResponse();
        for (String id : ids) {
            sensorDao.findAndRemove(id);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据loginName查询所有设备
     */
    public List<Sensor> getDeviceList(String loginName) {
        //检验是否为空
        if (StringUtils.isBlank(loginName)) {
            throw new RuntimeException("登录名为空！！！");
        }
        //判断登录名是否存在
        Company company = userDao.findByName(loginName);
        if (company == null) {
            throw new RuntimeException("登录名不存在！！！");
        }

        List<Sensor> sensorList = sensorDao.findByLoginName(loginName);
        return sensorList;
    }

    /**
     * 查询未被关联的传感器
     *
     * @return
     */
    public BaseResponse<List<Sensor>> querySensorNotRelation() {
        BaseResponse response = new BaseResponse();
        List<Sensor> sensorList = sensorDao.querySensorNotRelation();
        response.setData(sensorList);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
