package com.msp.impulse.nb.service;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.CompanyExample;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.mapper.CompanyMapper;
import com.msp.impulse.mapper.SensorMapper;
import com.msp.impulse.nb.dao.SubscribeInfoDao;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import com.msp.impulse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class SubscribeInfoService {

    @Autowired
    private SubscribeInfoDao subscribeInfoDao;

    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private UserService userService;

    public SubscribeInfoEntity getSubscribeInfoByDeviceId(String deviceId){
        Sensor sensor = sensorMapper.findSensorByDeviceId(deviceId);
        return subscribeInfoDao.findByCompanyName(sensor.getUserName());
    }

    public int saveSubscribeInfo(SubscribeInfoEntity subscribeInfoEntity){
        CompanyExample companyExample = new CompanyExample();
        companyExample.createCriteria().andLoginNameEqualTo(subscribeInfoEntity.getLoginName())
                .andPasswordEqualTo(DigestUtils.md5DigestAsHex(subscribeInfoEntity.getPassword().getBytes()));
        List<Company> companyList = companyMapper.selectByExample(companyExample);
        if (companyList!=null && companyList.size()>0){
            Company company = companyList.get(0);
            company.setCallbackUrl(subscribeInfoEntity.getCallbackUrl());
            return companyMapper.updateByPrimaryKey(company);
        }else {
            return -1;
        }

    }
}
