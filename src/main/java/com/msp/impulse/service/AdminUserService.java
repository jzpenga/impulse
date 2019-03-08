package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.*;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.CompanyMapper;
import com.msp.impulse.mapper.LinkmanMapper;
import com.msp.impulse.query.FindUserQuery;
import com.msp.impulse.query.GateSenPageQuery;
import com.msp.impulse.query.SaveUserQuery;
import com.msp.impulse.vo.CompanyDetailVo;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class AdminUserService {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private LinkmanMapper linkmanMapper;

    /**
     * 用户信息查询
     *
     * @param findUserQuery
     * @return
     */
    public BaseResponse<PageBean> findUser(FindUserQuery findUserQuery) {
        BaseResponse<PageInfo> response = new BaseResponse<>();
        if (findUserQuery.getPageNo() == null) {
            findUserQuery.setPageNo(1);
        }
        if (findUserQuery.getPageSize() == null) {
            findUserQuery.setPageSize(10);
        }
        PageHelper.startPage(findUserQuery.getPageNo(), findUserQuery.getPageSize());
//        List<Company> gatewayList = companyMapper.findUser(findUserQuery);
//        PageInfo<Company> pageInfo = new PageInfo<>(gatewayList);

//        response.setData(pageInfo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return null;
    }

//    /**
//     * 根据用户id查询
//     *
//     * @param userId
//     * @return
//     */
//    public BaseResponse<CompanyDetailVo> findUserById(String userId) {
//        BaseResponse response = new BaseResponse<>();
//        CompanyDetailVo companyDetailVo = new CompanyDetailVo();
//        Company company = adminUserDao.findUserById(userId);
//        if (company != null) {
//            companyDetailVo.setCompany(company);
//        }
//
//        PageBean pageBeanGateway = gatewayDao.findGatewayByUserId(userId);
//        if (pageBeanGateway != null) {
//            companyDetailVo.setPageBeanGateway(pageBeanGateway);
//        }
//        PageBean pageBeanSensor = sensorDao.findSensorByUserId(userId);
//        if (pageBeanSensor != null) {
//            companyDetailVo.setPageBeanSensor(pageBeanSensor);
//        }
//        response.setData(companyDetailVo);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }

    /**
     * 新增或修改用户数据
     *
     * @param saveUserQuery
     * @return
     */
    @Transactional
    public BaseResponse saveUser(SaveUserQuery saveUserQuery) {
        BaseResponse response = new BaseResponse<>();
        if(saveUserQuery.getCompany()==null){
            response.setResponseCode(ResponseCode.INPUT_COMPAY.getCode());
            response.setResponseMsg(ResponseCode.INPUT_COMPAY.getMessage());
            return response;
        }
        //用户登录名不能为空
        if(StringUtils.isBlank(saveUserQuery.getCompany().getLoginName())){
            response.setResponseCode(ResponseCode.USERNAME_NULL.getCode());
            response.setResponseMsg(ResponseCode.USERNAME_NULL.getMessage());
            return response;
        }
        //密码不能为空
        if(StringUtils.isBlank(saveUserQuery.getCompany().getPassword())){
            response.setResponseCode(ResponseCode.PASSWORD_NULL.getCode());
            response.setResponseMsg(ResponseCode.PASSWORD_NULL.getMessage());
            return response;
        }
        Company company = saveUserQuery.getCompany();
        if(company.getId()!=null){
            //密码加密
            String pwd = DigestUtils.md5DigestAsHex(saveUserQuery.getCompany().getPassword().getBytes());
            company.setPassword(pwd);
            company.setUpdateTime(new Date());
            companyMapper.updateByPrimaryKey(company);
            //修改联系人
            Linkman linkman = saveUserQuery.getLinkman();
            if(linkman==null){
                response.setResponseCode(ResponseCode.LINKMAN_MUST_INPUT.getCode());
                response.setResponseMsg(ResponseCode.LINKMAN_MUST_INPUT.getMessage());
                return response;
            }
            if(linkman.getId()==null){
                throw new MyException("修改时请传入联系人id！");
            }
            linkman.setUpdateTime(new Date());
            linkmanMapper.updateByPrimaryKey(linkman);
        }else{
            //用户登录名不能重复
            Company com=companyMapper.findByName(saveUserQuery.getCompany().getLoginName());
            if(com!=null){
                response.setResponseCode(ResponseCode.LOGINNAME_EXSIST.getCode());
                response.setResponseMsg(ResponseCode.LOGINNAME_EXSIST.getMessage());
                return response;
            }
            //密码加密
            String pwd = DigestUtils.md5DigestAsHex(saveUserQuery.getCompany().getPassword().getBytes());
            company.setPassword(pwd);
            //保存公司信息
            company.setGatewayNumber(0);
            company.setSensorNumber(0);
            company.setCreateTime(new Date());
            companyMapper.insertSelective(company);
            //保存联系人信息
            if(saveUserQuery.getLinkman()==null){
                throw  new MyException("联系人信息必输!");
            }
            if(StringUtils.isBlank(saveUserQuery.getLinkman().getName())){
                throw  new MyException("联系人姓名必输!");
            }
            Linkman linkman = saveUserQuery.getLinkman();
            linkman.setCreateTime(new Date());
            linkmanMapper.insertSelective(linkman);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

//    /**
//     * 根据用户id删除数据
//     *
//     * @param userId
//     * @return
//     */
//    public BaseResponse deleteUserById(String userId) {
//        BaseResponse response = new BaseResponse<>();
//        adminUserDao.deleteUserById(userId);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }

//    /**
//     * 批量删除数据
//     *
//     * @param ids
//     * @return
//     */
//    @Transactional
//    public BaseResponse deleteUserBatch(List<String> ids) {
//        BaseResponse response = new BaseResponse<>();
//        for (String id : ids) {
//            adminUserDao.deleteUserById(id);
//        }
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }

//    /**
//     * 根据用户id对网关进行分页查询
//     *
//     * @param gateSenPageQuery
//     * @return
//     */
//    public BaseResponse findGatewayByUserId(GateSenPageQuery gateSenPageQuery) {
//        BaseResponse response = new BaseResponse<>();
//        PageBean pageBean = adminUserDao.findGatewayByUserId(gateSenPageQuery);
//        response.setData(pageBean);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }

//    public BaseResponse findSensorByUserId(GateSenPageQuery gateSenPageQuery) {
//        BaseResponse response = new BaseResponse<>();
//        PageBean pageBean = adminUserDao.findSensorByUserId(gateSenPageQuery);
//        response.setData(pageBean);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }
}
