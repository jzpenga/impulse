package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.constants.Constants;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.*;
import com.msp.impulse.query.*;
import com.msp.impulse.vo.CompanyDetailVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminUserService {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GatewayMapper gatewayMapper;
    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private UserService userService;

    /**
     * 用户信息查询
     *
     * @param findUserQuery
     * @return
     */
    public BaseResponse<PageInfo> findUser(FindUserQuery findUserQuery, Integer userId) {
        BaseResponse<PageInfo> response = new BaseResponse<>();
        if (findUserQuery.getPageNo() == null) {
            findUserQuery.setPageNo(1);
        }
        if (findUserQuery.getPageSize() == null) {
            findUserQuery.setPageSize(10);
        }
        User user = userService.findUserById(userId + "");
        if (user != null) {
            if (user.getAuthFlag().equals(Constants.AuthFlag.AGENT.getValue())) {
                //查询代理人所管理的用户
                List<Integer> userIds = new ArrayList<>();
                UserExample userExample = new UserExample();
                userExample.createCriteria().andAgentIdEqualTo(userId).andFlagEqualTo("0");
                List<User> users = userMapper.selectByExample(userExample);
                for (User user1 : users) {
                    userIds.add(user1.getId());
                }
                findUserQuery.setUserIds(userIds);
            }
        }
        if (StringUtils.isBlank(findUserQuery.getAuthFlag())) {
            findUserQuery.setAuthFlag(Constants.AuthFlag.NORMAL.getValue());
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
        User user = userMapper.selectByPrimaryKey(userId);
        //查询公司
        Company company = companyMapper.selectByPrimaryKey(user.getCompanyId());
        if (company != null) {
            companyDetailVo.setCompany(company);
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
     * @param companyParam
     * @return
     */
    @Transactional
    public BaseResponse saveUser(CompanyParam companyParam, Integer userId) {
        BaseResponse response = new BaseResponse<>();
        //用户登录名不能为空
        if (StringUtils.isBlank(companyParam.getLoginName())) {
            response.setResponseCode(ResponseCode.USERNAME_NULL.getCode());
            response.setResponseMsg(ResponseCode.USERNAME_NULL.getMessage());
            return response;
        }
        //联系人姓名不能为空
        if (StringUtils.isBlank(companyParam.getLinkmanName())) {
            response.setResponseCode(ResponseCode.LINKMAN_NAME_MUST_HAVE.getCode());
            response.setResponseMsg(ResponseCode.LINKMAN_NAME_MUST_HAVE.getMessage());
            return response;
        }

        //联系人电话号不能为空
        if (StringUtils.isBlank(companyParam.getPhoneNo())) {
            response.setResponseCode(ResponseCode.PHONE_NO_MUST_HAVE.getCode());
            response.setResponseMsg(ResponseCode.PHONE_NO_MUST_HAVE.getMessage());
            return response;
        }

        if (companyParam.getId() != null) {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andFlagEqualTo("0").andCompanyIdEqualTo(companyParam.getId());
            List<User> users = userMapper.selectByExample(userExample);
            if (users.isEmpty()) {
                throw new MyException("该公司对应的用户数据不存在!");
            }
            User user = users.get(0);

            Company company1 = companyMapper.selectByPrimaryKey(companyParam.getId());
            //密码加密
            if (StringUtils.isNotBlank(companyParam.getPassword())) {
                String pwd = DigestUtils.md5DigestAsHex(companyParam.getPassword().getBytes());
                company1.setPassword(pwd);
                user.setPassword(pwd);
            }
            company1.setUpdateTime(new Date());
            company1.setLoginName(companyParam.getLoginName());
            company1.setCompanyName(companyParam.getCompanyName());
            company1.setProvince(companyParam.getProvince());
            company1.setCity(companyParam.getCity());
            company1.setDetailedAdd(companyParam.getDetailedAdd());
            company1.setPostalCode(companyParam.getPostalCode());
            company1.setLinkmanName(companyParam.getLinkmanName());
            company1.setAccount(companyParam.getAccount());
            company1.setPhoneNo(companyParam.getPhoneNo());
            company1.setEmail(companyParam.getEmail());
            company1.setGender(companyParam.getGender());
            company1.setUpdateUser(userId);
            companyMapper.updateByPrimaryKey(company1);

            user.setLoginName(companyParam.getLoginName());
            user.setUpdateTime(new Date());
            user.setUpdateUser(userId);
            user.setName(companyParam.getLinkmanName());
            user.setPhoneNo(companyParam.getPhoneNo());
            if(companyParam.getAgent()!=null) {
                user.setAgentId(companyParam.getAgent());
            }
            userMapper.updateByPrimaryKey(user);

        } else {
            if (StringUtils.isBlank(companyParam.getPassword())) {
                response.setResponseCode(ResponseCode.PASSWORD_NULL.getCode());
                response.setResponseMsg(ResponseCode.PASSWORD_NULL.getMessage());
                return response;
            }
            //用户登录名不能重复
            CompanyExample companyExample = new CompanyExample();
            companyExample.createCriteria().andFlagEqualTo("0").andLoginNameEqualTo(companyParam.getLoginName());
            List<Company> companyList = companyMapper.selectByExample(companyExample);
            if (!companyList.isEmpty()) {
                response.setResponseCode(ResponseCode.LOGINNAME_EXSIST.getCode());
                response.setResponseMsg(ResponseCode.LOGINNAME_EXSIST.getMessage());
                return response;
            }
            companyParam.setCreateUser(userId);
            //新增公司信息
            Integer companyId = addCompany(companyParam);
            //新增用户信息
            User user = new User();
            user.setCreateTime(new Date());
            String pwd = DigestUtils.md5DigestAsHex(companyParam.getPassword().getBytes());
            user.setPassword(pwd);
            user.setLoginName(companyParam.getLoginName());
            if (StringUtils.isBlank(companyParam.getAuthFlag())) {
                user.setAuthFlag(Constants.AuthFlag.NORMAL.getValue());//普通用户
            } else {
                user.setAuthFlag(companyParam.getAuthFlag());
            }
            if(companyParam.getAgent()!=null) {
                user.setAgentId(companyParam.getAgent());
            }
            user.setCompanyId(companyId);
            user.setFlag("0");
            user.setCreateUser(userId);
            user.setName(companyParam.getLinkmanName());
            user.setPhoneNo(companyParam.getPhoneNo());
            userMapper.insertSelective(user);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public Integer addCompany(CompanyParam companyParam) {
        Company company = new Company();
        if (StringUtils.isBlank(companyParam.getPassword())) {
            throw new MyException("密码必输！");
        }
        //密码加密
        String pwd = DigestUtils.md5DigestAsHex(companyParam.getPassword().getBytes());
        company.setPassword(pwd);
        //保存公司信息
//            company.setGatewayNumber(0);
//            company.setSensorNumber(0);
        company.setFlag("0");
        company.setCreateTime(new Date());
        company.setEmail(StringUtils.isBlank(companyParam.getEmail()) ? null : companyParam.getEmail());
        company.setPhoneNo(companyParam.getPhoneNo());
        company.setAccount(StringUtils.isBlank(companyParam.getAccount()) ? null : companyParam.getAccount());
        company.setLinkmanName(StringUtils.isBlank(companyParam.getLinkmanName()) ? null : companyParam.getLinkmanName());
        company.setPostalCode(StringUtils.isBlank(companyParam.getPostalCode()) ? null : companyParam.getPostalCode());
        company.setDetailedAdd(StringUtils.isBlank(companyParam.getDetailedAdd()) ? null : companyParam.getDetailedAdd());
        company.setCity(StringUtils.isBlank(companyParam.getCity()) ? null : companyParam.getCity());
        company.setProvince(StringUtils.isBlank(companyParam.getProvince()) ? null : companyParam.getProvince());
        company.setCompanyName(StringUtils.isBlank(companyParam.getCompanyName()) ? null : companyParam.getCompanyName());
        company.setLoginName(companyParam.getLoginName());
        company.setGender(StringUtils.isBlank(companyParam.getGender()) ? null : companyParam.getGender());
        company.setCreateUser(companyParam.getCreateUser());
        companyMapper.insertSelective(company);

        return company.getId();
    }

    /**
     * 批量删除数据
     *
     * @param ids
     * @return
     */
    @Transactional
    public BaseResponse deleteUserBatch(List<Integer> ids, Integer userId) {
        BaseResponse response = new BaseResponse<>();
        for (Integer id : ids) {
            //删除公司
            Company company = companyMapper.selectByPrimaryKey(id);
            company.setFlag("1");
            company.setUpdateUser(userId);
            companyMapper.updateByPrimaryKey(company);
            //删除用户
            UserExample userExample = new UserExample();
            userExample.createCriteria().andFlagEqualTo("0").andCompanyIdEqualTo(id);
            List<User> users = userMapper.selectByExample(userExample);
            for (User user : users) {
                user.setUpdateUser(userId);
                user.setUpdateTime(new Date());
                user.setFlag("1");
                userMapper.updateByPrimaryKey(user);
            }
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

    /**
     * 新增代理人
     *
     * @param agentParam
     * @param parseInt
     * @return
     */
    public BaseResponse saveAgent(AgentParam agentParam, int parseInt) {
        BaseResponse response = new BaseResponse();

        if (StringUtils.isBlank(agentParam.getLoginName())) {
            response.setResponseCode(ResponseCode.LPGIN_NAME_MUST_HAVE.getCode());
            response.setResponseMsg(ResponseCode.LPGIN_NAME_MUST_HAVE.getMessage());
            return response;
        }
        if (StringUtils.isBlank(agentParam.getName())) {
            response.setResponseCode(ResponseCode.LINKMAN_NAME_MUST_HAVE.getCode());
            response.setResponseMsg(ResponseCode.LINKMAN_NAME_MUST_HAVE.getMessage());
            return response;
        }
        if (StringUtils.isBlank(agentParam.getPhoneNo())) {
            response.setResponseCode(ResponseCode.PHONE_NO_MUST_HAVE.getCode());
            response.setResponseMsg(ResponseCode.PHONE_NO_MUST_HAVE.getMessage());
            return response;
        }
        if (agentParam.getId() == null) {
            //用户登录名不能为空
            if (StringUtils.isBlank(agentParam.getPassword())) {
                response.setResponseCode(ResponseCode.PASSWORD_NULL.getCode());
                response.setResponseMsg(ResponseCode.PASSWORD_NULL.getMessage());
                return response;
            }
            User user = new User();
            user.setPhoneNo(agentParam.getPhoneNo());
            user.setName(agentParam.getName());
            //密码加密
            String pwd = DigestUtils.md5DigestAsHex(agentParam.getPassword().getBytes());
            user.setPassword(pwd);
            user.setLoginName(agentParam.getLoginName());
            user.setCreateTime(new Date());
            user.setCreateUser(parseInt);
            user.setFlag("0");
            user.setAuthFlag(Constants.AuthFlag.AGENT.getValue());
            userMapper.insertSelective(user);
        } else {
            User user = userMapper.selectByPrimaryKey(agentParam.getId());
            user.setUpdateTime(new Date());
            user.setUpdateUser(parseInt);
            user.setLoginName(agentParam.getLoginName());
            if (StringUtils.isNotBlank(agentParam.getPassword())) {
                String pwd = DigestUtils.md5DigestAsHex(agentParam.getPassword().getBytes());
                user.setPassword(pwd);
            }
            user.setName(agentParam.getName());
            user.setPhoneNo(agentParam.getPhoneNo());
            userMapper.updateByPrimaryKey(user);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据名称模糊查询所有代理人
     * @param agentName
     * @return
     */
    public BaseResponse searchAgentByName(String agentName) {
        BaseResponse response = new BaseResponse();
        UserExample userExample=new UserExample();
        userExample.createCriteria().andNameLike("%"+agentName+"%").andFlagEqualTo("0");
        List<User> users = userMapper.selectByExample(userExample);
        response.setData(users);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
