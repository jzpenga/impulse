package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.AdminDao;
import com.msp.impulse.entity.*;
import com.msp.impulse.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;


    /**
     * 新增修改admin
     *
     * @param admin
     * @return
     */
    public BaseResponse<Admin> addAdmin(Admin admin) {
        BaseResponse<Admin> response = new BaseResponse();
        //判断登录名是否已经存在
        Admin admin1 = adminMapper.finAdminByLoginName(admin.getLoginName());
        if (admin1 != null) {
            response.setResponseCode(ResponseCode.LOGINNAME_EXSIST.getCode());
            response.setResponseMsg(ResponseCode.LOGINNAME_EXSIST.getMessage());
            return response;
        }
        //密码用户名不能为空
        if (admin.getPassword() == null) {
            response.setResponseCode(ResponseCode.PASSWORD_NULL.getCode());
            response.setResponseMsg(ResponseCode.PASSWORD_NULL.getMessage());
            return response;
        }
        if (admin.getLoginName() == null) {
            response.setResponseCode(ResponseCode.ADMINNAME_NULL.getCode());
            response.setResponseMsg(ResponseCode.ADMINNAME_NULL.getMessage());
            return response;
        }
        String pwdCode = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        admin.setPassword(pwdCode);
        if(admin.getId()==null){
            //新增
            admin.setCreateTime(new Date());
            adminMapper.insertSelective(admin);
        }else{
            //修改
            admin.setUpdateTime(new Date());
            adminMapper.updateByPrimaryKey(admin);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

//    /**
//     * 根基id查询管理员
//     *
//     * @param id
//     * @return
//     */
//    public BaseResponse<Admin> findAdminById(String id) {
//        BaseResponse<Admin> response = new BaseResponse();
//        Admin adminAdd = adminDao.findAdminById(id);
//        response.setData(adminAdd);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }

//    /**
//     * 更据id删除管理员
//     *
//     * @param id
//     * @return
//     */
//    public BaseResponse deleteAdminById(String id) {
//        BaseResponse response = new BaseResponse();
//        adminDao.deleteAdminById(id);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }

    /**
     * @param loginName
     * @param password
     * @return
     */
    public BaseResponse findByNameAndPwd(String loginName, String password) {
        BaseResponse response = new BaseResponse<>();
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());//默认密码
        Admin admin = adminMapper.findByNameAndPwd(loginName, pwd);
        if (admin == null) {
            response.setResponseMsg(ResponseCode.USERNAME_OR_PWD_WRONG.getMessage());
            response.setResponseCode(ResponseCode.USERNAME_OR_PWD_WRONG.getCode());
            return response;
        }
        response.setData(admin);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }



}
