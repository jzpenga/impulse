package com.msp.impulse.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.CompanyExample;
import com.msp.impulse.entity.User;
import com.msp.impulse.entity.UserExample;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.CompanyMapper;
import com.msp.impulse.mapper.UserMapper;
import com.msp.impulse.vo.AppUserVo;
import com.msp.impulse.vo.CompanyVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 更新密码
     *
     * @param userId
     * @param newPwd
     * @param oPwd
     */
    public BaseResponse modifyPwd(String userId, String oPwd, String newPwd) {
        BaseResponse response = new BaseResponse<>();
        //参数是否为空
        if (StringUtils.isBlank(oPwd) || StringUtils.isBlank(newPwd)) {
            response.setResponseCode(ResponseCode.PARAMETER_ISNULL.getCode());
            response.setResponseMsg(ResponseCode.PARAMETER_ISNULL.getMessage());
            return response;
        }
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(userId));
        //判断用户是否登录
        Company company = companyMapper.selectByPrimaryKey(user.getCompanyId());
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
        company.setUpdateTime(new Date());
        company.setUpdateUser(Integer.parseInt(userId));
        companyMapper.updateByPrimaryKey(company);

        user.setPassword(newPassWord);
        user.setUpdateUser(Integer.parseInt(userId));
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKey(user);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public BaseResponse<Company> findByNameAndPwd(String loginName, String password) {
        BaseResponse<Company> response = new BaseResponse<>();
        if (StringUtils.isBlank(loginName)) {
            throw new MyException("请输入登录名!");
        }
        if (StringUtils.isBlank(password)) {
            throw new MyException("请输入登密码!");
        }
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());//默认密码
        Company company = companyMapper.findByNameAndPwd(loginName, pwd);
        if (company == null) {
            response.setResponseMsg(ResponseCode.USERNAME_OR_PWD_WRONG.getMessage());
            response.setResponseCode(ResponseCode.USERNAME_OR_PWD_WRONG.getCode());
            return response;
        }
        response.setData(company);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public BaseResponse loginByNameAndPwd(String loginName, String password) {
        BaseResponse response = new BaseResponse<>();
        if (StringUtils.isBlank(loginName)) {
            throw new MyException("请输入登录名!");
        }
        if (StringUtils.isBlank(password)) {
            throw new MyException("请输入登密码!");
        }
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());//默认密码
        User user = userMapper.findByNameAndPwd(loginName, pwd);
        if (user == null) {
            response.setResponseMsg(ResponseCode.USERNAME_OR_PWD_WRONG.getMessage());
            response.setResponseCode(ResponseCode.USERNAME_OR_PWD_WRONG.getCode());
            return response;
        }
        CompanyVo companyVo=new CompanyVo();
        //生成token
        String token = JWT.create().withAudience(user.getId() + "")
                .sign(Algorithm.HMAC256(user.getPassword()));
        companyVo.setToken(token);
        companyVo.setAuthFlag(user.getAuthFlag());
        companyVo.setLoginName(user.getLoginName());
        response.setData(companyVo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public Company findById(String userId) {
        CompanyExample companyExample = new CompanyExample();
        companyExample.createCriteria().andIdEqualTo(Integer.parseInt(userId)).andFlagNotEqualTo("1");
        List<Company> companyList = companyMapper.selectByExample(companyExample);
        if (!companyList.isEmpty()) {
            return companyList.get(0);
        }
        return null;
    }

    public BaseResponse login(String loginName, String password) {
        BaseResponse response = new BaseResponse();
        if (StringUtils.isBlank(loginName)) {
            throw new MyException("请输入登录名!");
        }
        if (StringUtils.isBlank(password)) {
            throw new MyException("请输入登密码!");
        }
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());//默认密码
        //根据用户名密码查询用户
        User user = userMapper.findByNameAndPwd(loginName, pwd);
        if(user==null){
            throw new MyException("用户名或密码不正确!");
        }
        //生成token
        String token = JWT.create().withAudience(user.getId() + "")
                .sign(Algorithm.HMAC256(user.getPassword()));
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        response.setData(map);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public BaseResponse findUserInfo(String userId) {
        BaseResponse response=new BaseResponse();
        AppUserVo appUserVo = userMapper.findUserInfo(userId);
        if(appUserVo==null){
            response.setResponseCode(ResponseCode.TOKEN_TIME_OUT.getCode());
            response.setResponseMsg(ResponseCode.TOKEN_TIME_OUT.getMessage());
            return response;
        }
        response.setData(appUserVo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public User findUserById(String userId) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andFlagEqualTo("0").andIdEqualTo(Integer.parseInt(userId));
        List<User> users = userMapper.selectByExample(userExample);
        return users.isEmpty()?null:users.get(0);
    }
}
