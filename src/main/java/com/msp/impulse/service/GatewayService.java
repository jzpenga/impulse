package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.*;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.query.GatewayQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GatewayService {

    @Autowired
    private GatewayDao gatewayDao;
    @Autowired
    private PassDao passDao;
    @Autowired
    private ExtPassDao extPassDao;
    @Autowired
    private RelayDao relayDao;
    @Autowired
    private ControlInstruDao controlInstruDao;
    @Autowired
    private UserDao userDao;

    /**
     * 新增网关
     *
     * @param gateway
     * @return
     */
    @Transactional
    public BaseResponse addGateway(Gateway gateway, String userId) {
        BaseResponse response = new BaseResponse<>();
        //名称必输
        if (StringUtils.isBlank(gateway.getGatewayName())) {
            response.setResponseCode(ResponseCode.GATEWAYNAME_NULL.getCode());
            response.setResponseMsg(ResponseCode.GATEWAYNAME_NULL.getMessage());
            return response;
        }
        if (StringUtils.isBlank(gateway.getId())) {
            //判断网关名称是否唯一
            if (gatewayDao.findByName(gateway.getGatewayName())) {
                response.setResponseCode(ResponseCode.GATEWAYNAME_REPEAT.getCode());
                response.setResponseMsg(ResponseCode.GATEWAYNAME_REPEAT.getMessage());
                return response;
            }
        }
        //新增或修改通道
        if (!gateway.getPassList().isEmpty()) {
            List<Pass> passList = new ArrayList<>();
            for (Pass pass : gateway.getPassList()) {
                Pass returnPass = passDao.save(pass);
                passList.add(returnPass);
            }
            gateway.setPassList(passList);
        }

        //新增或修改外接通道
        if (gateway.getExtPass() != null) {
            if (!gateway.getExtPass().getPassList().isEmpty()) {
                List<Pass> extPassList = new ArrayList<>();
                for (Pass extPass : gateway.getExtPass().getPassList()) {
                    Pass returnExtPass = passDao.save(extPass);
                    extPassList.add(returnExtPass);
                }
                gateway.getExtPass().setPassList(extPassList);
                ExtPass returnExtPass = extPassDao.save(gateway.getExtPass());
                gateway.setExtPass(returnExtPass);
            }
        }
        //新增或修改继电器
        if (!gateway.getRelayList().isEmpty()) {
            List<Relay> relayList = new ArrayList<>();
            for (Relay relay : gateway.getRelayList()) {
                Relay returnRelay = relayDao.save(relay);
                relayList.add(returnRelay);
                //记录继电器控制指令
                if (StringUtils.isBlank(relay.getDealStatus())) {
                    throw new MyException("请输入控制指令进行继电器的开关操作");
                }
                if (relay.getWayNo() == null) {
                    throw new MyException("请确认继电器路数");
                }
                //登记控制指令
                ControlInstru controlInstru = new ControlInstru();
                controlInstru.setRelay(relay);
                controlInstru.setDownTime(new Date());//下发时间
                controlInstru.setDealStatus(relay.getDealStatus());//处理状态0-开 1-关
//                controlInstru.setExecuteTime();//执行时间
//                controlInstru.setReturnStatus();//返回状态
//                controlInstru.setExtraMessage();//附件信息
                controlInstru.setGatewayName(gateway.getGatewayName());//网关名称
                controlInstru.setWayNo(relay.getWayNo());//网关路数
//                controlInstru.setUpdateTime();//更新时间
//                controlInstru.setFinalStatus();//最终状态
                controlInstru.setCreateTime(new Date());
                controlInstruDao.save(controlInstru);
            }
            gateway.setRelayList(relayList);
        }
        //用户id
        if (StringUtils.isNotBlank(userId)) {
            gateway.setUserId(userId);
        }
        gateway.setCreateTime(new Date());
        gatewayDao.save(gateway);

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据条件分页查询网关信息
     *
     * @param gatewayQuery
     * @return
     */
    public BaseResponse<List<Gateway>> findGatewayByCondition(@RequestBody GatewayQuery gatewayQuery, String id) {
        BaseResponse<List<Gateway>> response = new BaseResponse<>();
        //最小页为第一页
        if (gatewayQuery.getPageNo() == null || gatewayQuery.getPageNo() < 1) {
            gatewayQuery.setPageNo(0);
        }
        if (gatewayQuery.getPageSize() == null || gatewayQuery.getPageSize() < 1) {
            gatewayQuery.setPageSize(10);
        }
        response.setData(gatewayDao.findGatewayByCondition(gatewayQuery, id));
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());

        return response;
    }

    /**
     * 根据id删除网关信息
     *
     * @param id
     * @return
     */
    public BaseResponse deleteGateway(String id) {
        BaseResponse response = new BaseResponse();
        gatewayDao.findAndRemove(id);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据id查询网关
     *
     * @param id
     * @return
     */
    public BaseResponse<Gateway> findGatewayById(String id) {
        BaseResponse<Gateway> response = new BaseResponse<>();
        Gateway gateway = gatewayDao.findGatewayById(id);
        response.setData(gateway);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 批量删除网关数据
     *
     * @param ids
     * @return
     */
    @Transactional
    public BaseResponse deleteGatewayBatch(List<String> ids) {
        BaseResponse response = new BaseResponse<>();
        for (String id : ids) {
            gatewayDao.findAndRemove(id);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 更改company表的网关数
     *
     * @param userId
     * @param changeNumber 删除传负数
     */
    public synchronized void changeGatewayNumber(String userId, Integer changeNumber) {
        //根据userId查询当前gatewayNumber
        Company company = userDao.findById(userId);
        if(company!=null){
            Integer  gatewayNumber = company.getGatewayNumber();
            if(gatewayNumber>0){
                gatewayNumber=gatewayNumber-changeNumber;
                //改变网关个数
                company.setGatewayNumber(gatewayNumber);
                userDao.save(company);
            }
        }
    }
}
