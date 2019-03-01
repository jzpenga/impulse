package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.AdminUserDao;
import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.dao.SensorDao;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.query.FindUserQuery;
import com.msp.impulse.query.GateSenPageQuery;
import com.msp.impulse.query.SaveUserQuery;
import com.msp.impulse.vo.CompanyDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;
    @Autowired
    private GatewayDao gatewayDao;
    @Autowired
    private SensorDao sensorDao;

    /**
     * 用户信息查询
     *
     * @param findUserQuery
     * @return
     */
    public BaseResponse<PageBean> findUser(FindUserQuery findUserQuery) {
        BaseResponse response = new BaseResponse<>();
        PageBean pageBean = adminUserDao.findUser(findUserQuery);
        response.setData(pageBean);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据用户id查询
     *
     * @param userId
     * @return
     */
    public BaseResponse<CompanyDetailVo> findUserById(String userId) {
        BaseResponse response = new BaseResponse<>();
        CompanyDetailVo companyDetailVo = new CompanyDetailVo();
        Company company = adminUserDao.findUserById(userId);
        if (company != null) {
            companyDetailVo.setCompany(company);
        }

        PageBean pageBeanGateway = gatewayDao.findGatewayByUserId(userId);
        if (pageBeanGateway != null) {
            companyDetailVo.setPageBeanGateway(pageBeanGateway);
        }
        PageBean pageBeanSensor = sensorDao.findSensorByUserId(userId);
        if (pageBeanSensor != null) {
            companyDetailVo.setPageBeanSensor(pageBeanSensor);
        }
        response.setData(companyDetailVo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 新增或修改用户数据
     *
     * @param saveUserQuery
     * @return
     */
    @Transactional
    public BaseResponse saveUser(SaveUserQuery saveUserQuery) {
        BaseResponse response = new BaseResponse<>();
        List<Gateway> gatewayList = saveUserQuery.getGatewayList();
        List<Sensor> sensorList = saveUserQuery.getSensorList();
        //保存公司信息
        adminUserDao.save(saveUserQuery.getCompany());
        //保存网关信息
        if (!gatewayList.isEmpty()) {
            for (Gateway gateway : gatewayList) {
                gatewayDao.save(gateway);
            }
        }
        //保存传感器信息
        if (!sensorList.isEmpty()) {
            for (Sensor sensor : sensorList) {
                sensorDao.save(sensor);
            }
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据用户id删除数据
     *
     * @param userId
     * @return
     */
    public BaseResponse deleteUserById(String userId) {
        BaseResponse response = new BaseResponse<>();
        adminUserDao.deleteUserById(userId);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 批量删除数据
     *
     * @param ids
     * @return
     */
    @Transactional
    public BaseResponse deleteUserBatch(List<String> ids) {
        BaseResponse response = new BaseResponse<>();
        for (String id : ids) {
            adminUserDao.deleteUserById(id);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据用户id对网关进行分页查询
     *
     * @param gateSenPageQuery
     * @return
     */
    public BaseResponse findGatewayByUserId(GateSenPageQuery gateSenPageQuery) {
        BaseResponse response = new BaseResponse<>();
        PageBean pageBean = adminUserDao.findGatewayByUserId(gateSenPageQuery);
        response.setData(pageBean);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public BaseResponse findSensorByUserId(GateSenPageQuery gateSenPageQuery) {
        BaseResponse response = new BaseResponse<>();
        PageBean pageBean = adminUserDao.findSensorByUserId(gateSenPageQuery);
        response.setData(pageBean);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
