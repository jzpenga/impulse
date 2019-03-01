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
import com.msp.impulse.vo.CompanyDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Gateway> gateways = gatewayDao.findGatewayByUserId(userId);
        if (!gateways.isEmpty()) {
            companyDetailVo.setGatewayList(gateways);
        }
        List<Sensor> sensorList = sensorDao.findSensorByUserId(userId);
        if (!sensorList.isEmpty()) {
            companyDetailVo.setSensorList(sensorList);
        }
        response.setData(companyDetailVo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

}
