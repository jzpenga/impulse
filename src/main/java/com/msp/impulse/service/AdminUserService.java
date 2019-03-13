package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.CompanyMapper;
import com.msp.impulse.mapper.GatewayMapper;
import com.msp.impulse.mapper.LinkmanMapper;
import com.msp.impulse.mapper.SensorMapper;
import com.msp.impulse.query.*;
import com.msp.impulse.vo.CompanyDetailVo;
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
    @Autowired
    private GatewayMapper gatewayMapper;
    @Autowired
    private SensorMapper sensorMapper;

    /**
     * 用户信息查询
     *
     * @param findUserQuery
     * @return
     */
    public BaseResponse<PageInfo> findUser(FindUserQuery findUserQuery) {
        BaseResponse<PageInfo> response = new BaseResponse<>();
        if (findUserQuery.getPageNo() == null) {
            findUserQuery.setPageNo(1);
        }
        if (findUserQuery.getPageSize() == null) {
            findUserQuery.setPageSize(10);
        }
        PageHelper.startPage(findUserQuery.getPageNo(), findUserQuery.getPageSize());
        List<Company> gatewayList = companyMapper.findUser(findUserQuery);
        PageInfo<Company> pageInfo = new PageInfo<>(gatewayList);

        response.setData(pageInfo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据用户id查询
     *
     * @param findUserByIdQuery
     * @return
     */
    public BaseResponse<CompanyDetailVo> findUserById(FindUserByIdQuery findUserByIdQuery) {
        BaseResponse response = new BaseResponse<>();
        if (findUserByIdQuery.getUserId() == null) {
            throw new MyException("用户id必输!");
        }
        Integer userId = findUserByIdQuery.getUserId();//用户id

        CompanyDetailVo companyDetailVo = new CompanyDetailVo();
        //查询公司
        Company company = companyMapper.selectByPrimaryKey(userId);
        if (company != null) {
            companyDetailVo.setCompany(company);
        }
        //查询联系人
        Linkman linkman = linkmanMapper.selectByCompanyId(userId);
        if (linkman != null) {
            companyDetailVo.setLinkman(linkman);
        }
        //查询网关
        GatewayQuery gatewayQuery = new GatewayQuery();
        gatewayQuery.setUserId(userId);
        if (findUserByIdQuery.getPageNoGate() == null) {
            findUserByIdQuery.setPageNoGate(1);
        }
        if (findUserByIdQuery.getPageSizeGate() == null) {
            findUserByIdQuery.setPageSizeGate(10);
        }
        PageHelper.startPage(findUserByIdQuery.getPageNoGate(), findUserByIdQuery.getPageSizeGate());
        List<Gateway> gatewayList = gatewayMapper.selectGatewayfo(gatewayQuery);
        PageInfo<Gateway> pageInfoGate = new PageInfo<>(gatewayList);
        companyDetailVo.setPageBeanGateway(pageInfoGate);
        //查询传感器
        SensorQuery sensorQuery = new SensorQuery();
        sensorQuery.setUserId(userId);
        if (findUserByIdQuery.getPageNoSensor() == null) {
            findUserByIdQuery.setPageNoSensor(1);
        }
        if (findUserByIdQuery.getPageSizeSensor() == null) {
            findUserByIdQuery.setPageSizeSensor(10);
        }
        PageHelper.startPage(findUserByIdQuery.getPageNoSensor(), findUserByIdQuery.getPageSizeSensor());
        List<Sensor> sensorList = sensorMapper.selectSensorInfo(sensorQuery);
        PageInfo<Sensor> pageInfo = new PageInfo<>(sensorList);
        companyDetailVo.setPageBeanSensor(pageInfo);

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
        if (saveUserQuery.getCompany() == null) {
            response.setResponseCode(ResponseCode.INPUT_COMPAY.getCode());
            response.setResponseMsg(ResponseCode.INPUT_COMPAY.getMessage());
            return response;
        }
        //用户登录名不能为空
        if (StringUtils.isBlank(saveUserQuery.getCompany().getLoginName())) {
            response.setResponseCode(ResponseCode.USERNAME_NULL.getCode());
            response.setResponseMsg(ResponseCode.USERNAME_NULL.getMessage());
            return response;
        }
//        //密码不能为空
//        if(StringUtils.isBlank(saveUserQuery.getCompany().getPassword())){
//            response.setResponseCode(ResponseCode.PASSWORD_NULL.getCode());
//            response.setResponseMsg(ResponseCode.PASSWORD_NULL.getMessage());
//            return response;
//        }
        Company company = saveUserQuery.getCompany();
        if (company.getId() != null) {
            Company company1 = companyMapper.selectByPrimaryKey(company.getId());
            //密码加密
            if (company.getPassword() != null) {
                String pwd = DigestUtils.md5DigestAsHex(saveUserQuery.getCompany().getPassword().getBytes());
                company1.setPassword(pwd);
            }
            company1.setUpdateTime(new Date());
            company1.setLoginName(company.getLoginName());
            company1.setCompanyName(company.getCompanyName());
            company1.setProvince(company.getProvince());
            company1.setCity(company.getCity());
            company1.setDetailedAdd(company.getDetailedAdd());
            company1.setPostalCode(company.getPostalCode());
            companyMapper.updateByPrimaryKey(company1);
            //修改联系人
            Linkman linkman = saveUserQuery.getLinkman();
            if (linkman == null) {
                response.setResponseCode(ResponseCode.LINKMAN_MUST_INPUT.getCode());
                response.setResponseMsg(ResponseCode.LINKMAN_MUST_INPUT.getMessage());
                return response;
            }
            if (linkman.getId() == null) {
                throw new MyException("修改时请传入联系人id！");
            }
            Linkman linkman1 = linkmanMapper.selectByPrimaryKey(linkman.getId());
            linkman1.setUpdateTime(new Date());
            linkman1.setName(linkman.getName());
            linkman1.setGender(linkman.getGender());
            linkman1.setPhoneNo(linkman.getPhoneNo());
            linkman1.setEmail(linkman.getEmail());
            linkmanMapper.updateByPrimaryKey(linkman1);
        } else {
            //用户登录名不能重复
            Company com = companyMapper.findByName(saveUserQuery.getCompany().getLoginName());
            if (com != null) {
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
            company.setFlag("0");
            company.setCreateTime(new Date());
            companyMapper.insertSelective(company);
            //保存联系人信息
            if (saveUserQuery.getLinkman() == null) {
                throw new MyException("联系人信息必输!");
            }
            if (StringUtils.isBlank(saveUserQuery.getLinkman().getName())) {
                throw new MyException("联系人姓名必输!");
            }
            Linkman linkman = saveUserQuery.getLinkman();
            linkman.setCreateTime(new Date());
            linkman.setFlag("0");
            linkman.setCompanyId(company.getId());
            linkmanMapper.insertSelective(linkman);
        }
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
    public BaseResponse deleteUserBatch(List<Integer> ids) {
        BaseResponse response = new BaseResponse<>();
        for (Integer id : ids) {
            Company company = companyMapper.selectByPrimaryKey(id);
            company.setFlag("1");
            companyMapper.updateByPrimaryKey(company);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据名称搜索用户
     *
     * @param userName
     * @return
     */
    public BaseResponse searchUserByName(String userName) {
        BaseResponse response = new BaseResponse<>();
        List<Company> companyList = companyMapper.seletByUserName(userName);
        response.setData(companyList);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
