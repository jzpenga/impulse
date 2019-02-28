package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.UserDao;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.User;
import com.msp.impulse.query.PersonalInfoQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public BaseResponse<Company> addUser(Company company) {
        BaseResponse response = new BaseResponse<>();
        if(StringUtils.isBlank(company.getLoginName())){
            response.setResponseCode(ResponseCode.USERNAME_NULL.getCode());
            response.setResponseMsg(ResponseCode.USERNAME_NULL.getMessage());
            return response;
        }

        //判断登录名是否存在
        Company com=userDao.findByName(company.getLoginName());
        if(com!=null){
            response.setResponseCode(ResponseCode.LOGINNAME_EXSIST.getCode());
            response.setResponseMsg(ResponseCode.LOGINNAME_EXSIST.getMessage());
            return response;
        }

        String pwd = DigestUtils.md5DigestAsHex("123456".getBytes());//默认密码
        company.setPassword(pwd);
        company.setCreateTime(new Date());
        Company saveCompany = userDao.save(company);

        response.setData(saveCompany);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 更新密码
     *
     * @param company
     * @param newPwd
     * @param oPwd
     */
    public BaseResponse modifyPwd(Company company, String oPwd, String newPwd) {
        BaseResponse response = new BaseResponse<>();
        //参数是否为空
        if (StringUtils.isBlank(oPwd) || StringUtils.isBlank(newPwd)) {
            response.setResponseCode(ResponseCode.PARAMETER_ISNULL.getCode());
            response.setResponseMsg(ResponseCode.PARAMETER_ISNULL.getMessage());
            return response;
        }

        //判断用户是否登录
        if (null == company) {
            response.setResponseCode(ResponseCode.NOT_LOGIN.getCode());
            response.setResponseMsg(ResponseCode.NOT_LOGIN.getMessage());
            return response;
        }

        //判断原密码是否与数据库密码相符
        String oPassWord = DigestUtils.md5DigestAsHex(oPwd.getBytes());
        if (!oPassWord.equals(company.getPassword())) {
            response.setResponseCode(ResponseCode.OPWD_WRONG.getCode());
            response.setResponseMsg(ResponseCode.OPWD_WRONG.getMessage());
            return response;
        }

        //对新密码进行加密
        String newPassWord = DigestUtils.md5DigestAsHex(newPwd.getBytes());
        company.setPassword(newPassWord);
        userDao.save(company);

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());

        return response;
    }

    public BaseResponse<Company> findByNameAndPwd(String loginName, String password) {
        BaseResponse<Company> response = new BaseResponse<>();
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());//默认密码
        Company company= userDao.findByNameAndPwd(loginName,pwd);
        if(company==null){
            response.setResponseMsg(ResponseCode.USERNAME_OR_PWD_WRONG.getMessage());
            response.setResponseCode(ResponseCode.USERNAME_OR_PWD_WRONG.getCode());
            return response;
        }
        response.setData(company);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
       return response;
    }
}
