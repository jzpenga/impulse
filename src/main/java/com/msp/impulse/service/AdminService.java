package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.AdminDao;
import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.dao.SensorDao;
import com.msp.impulse.dao.UserDao;
import com.msp.impulse.entity.Admin;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.vo.CompanyDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private GatewayDao gatewayDao;
    @Autowired
    private SensorDao sensorDao;

    /**
     * 新增修改admin
     * @param admin
     * @return
     */
    public BaseResponse<Admin> addAdmin(Admin admin) {
        BaseResponse<Admin> response = new BaseResponse();
        //判断登录名是否已经存在
        Admin admin1=adminDao.finAdminByLoginName(admin.getLoginName());
        if(admin1!=null){
            response.setResponseCode(ResponseCode.LOGINNAME_EXSIST.getCode());
            response.setResponseMsg(ResponseCode.LOGINNAME_EXSIST.getMessage());
            return response;
        }
        //密码用户名不能为空
        if(admin.getPassword()==null){
            response.setResponseCode(ResponseCode.PASSWORD_NULL.getCode());
            response.setResponseMsg(ResponseCode.PASSWORD_NULL.getMessage());
            return response;
        }
        if(admin.getLoginName()==null){
            response.setResponseCode(ResponseCode.ADMINNAME_NULL.getCode());
            response.setResponseMsg(ResponseCode.ADMINNAME_NULL.getMessage());
            return response;
        }
        String  pwdCode = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        admin.setPassword(pwdCode);
        Admin adminAdd = adminDao.addAdmin(admin);
        response.setData(adminAdd);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根基id查询管理员
     * @param id
     * @return
     */
    public BaseResponse<Admin> findAdminById(String id) {
        BaseResponse<Admin> response = new BaseResponse();
        Admin adminAdd = adminDao.findAdminById(id);
        response.setData(adminAdd);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 更据id删除管理员
     * @param id
     * @return
     */
    public BaseResponse deleteAdminById(String id) {
        BaseResponse response = new BaseResponse();
        adminDao.deleteAdminById(id);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     *
     * @param loginName
     * @param password
     * @return
     */
    public BaseResponse findByNameAndPwd(String loginName, String password) {
        BaseResponse response = new BaseResponse<>();
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());//默认密码
        Admin admin= adminDao.findByNameAndPwd(loginName,pwd);
        if(admin==null){
            response.setResponseMsg(ResponseCode.USERNAME_OR_PWD_WRONG.getMessage());
            response.setResponseCode(ResponseCode.USERNAME_OR_PWD_WRONG.getCode());
            return response;
        }
        response.setData(admin);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 用户信息查询
     * @param company
     * @return
     */
    public BaseResponse<List<Company>> findUser(Company company) {
        BaseResponse response = new BaseResponse<>();
        List<Company> companyList=adminDao.findUser(company);
        response.setData(companyList);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    public BaseResponse<CompanyDetailVo> findUserById(String userId) {
        BaseResponse response = new BaseResponse<>();
        CompanyDetailVo companyDetailVo=new  CompanyDetailVo();
        Company company=adminDao.findUserById(userId);
        if(company!=null) {
            companyDetailVo.setCompany(company);
        }
        List<Gateway> gateways=gatewayDao.findGatewayByUserId(userId);
        if(!gateways.isEmpty()){
            companyDetailVo.setGatewayList(gateways);
        }
        List<Sensor> sensorList=sensorDao.findSensorByUserId(userId);
        if(!sensorList.isEmpty()){
            companyDetailVo.setSensorList(sensorList);
        }
        response.setData(companyDetailVo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
