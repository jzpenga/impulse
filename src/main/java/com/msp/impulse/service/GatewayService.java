package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.*;
import com.msp.impulse.query.GatewayAddQuery;
import com.msp.impulse.query.GatewayQuery;
import com.msp.impulse.query.PassQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class GatewayService {
    @Autowired
    private GatewayMapper gatewayMapper;
    @Autowired
    private PassMapper passMapper;
    @Autowired
    private RelayMapper relayMapper;
    @Autowired
    private ControlinstruMapper controlinstruMapper;
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 新增网关
     *
     * @param gatewayAddQuery
     * @param userId
     * @return
     */
    @Transactional
    public BaseResponse saveGateway(GatewayAddQuery gatewayAddQuery, Integer userId) {
        BaseResponse response = new BaseResponse<>();
        Gateway gateway = gatewayAddQuery.getGateway();
        if (gateway == null) {
            throw new MyException("请输入网关信息!");
        }
        //名称必输
        if (StringUtils.isBlank(gateway.getGatewayName())) {
            response.setResponseCode(ResponseCode.GATEWAYNAME_NULL.getCode());
            response.setResponseMsg(ResponseCode.GATEWAYNAME_NULL.getMessage());
            return response;
        }

        if(gateway.getId()!=null) {
            //查询网关信息
            Gateway gatewayUpdate = gatewayMapper.selectByPrimaryKey(gateway.getId());
            if(gatewayUpdate==null){
                response.setResponseCode(ResponseCode.GATEWAY_NOT_HAVE.getCode());
                response.setResponseMsg(ResponseCode.GATEWAY_NOT_HAVE.getMessage());
                return response;
            }
            //判断网关名称是否唯一
            if (!gatewayUpdate.getGatewayName().equals(gateway.getGatewayName())&&
                    gatewayMapper.findGatewayName(gateway.getGatewayName())>0) {
                response.setResponseCode(ResponseCode.GATEWAYNAME_REPEAT.getCode());
                response.setResponseMsg(ResponseCode.GATEWAYNAME_REPEAT.getMessage());
                return response;
            }
            gatewayUpdate.setGatewayName(gateway.getGatewayName());
            gatewayUpdate.setGatewayNo(gateway.getGatewayNo());
            gatewayUpdate.setGatewayType(gateway.getGatewayType());
            gatewayUpdate.setGatewayModel(gateway.getGatewayModel());
            gatewayUpdate.setLatitude(gateway.getLatitude());
            gatewayUpdate.setLongitude(gateway.getLongitude());
            gatewayUpdate.setWorkModel(gateway.getWorkModel());
            gatewayUpdate.setPort(gateway.getPort());
            gatewayUpdate.setOvertimePeriod(gateway.getOvertimePeriod());
            gatewayUpdate.setPollPeriod(gateway.getPollPeriod());
            gatewayUpdate.setUpdateTime(new Date());
            if(userId!=null) {
                gatewayUpdate.setUpdateUser(userId);
            }
            //修改网关
            gatewayMapper.updateByPrimaryKey(gatewayUpdate);
        }else {
            //判断网关名称是否唯一
            if (gatewayMapper.findGatewayName(gateway.getGatewayName()) > 0) {
                response.setResponseCode(ResponseCode.GATEWAYNAME_REPEAT.getCode());
                response.setResponseMsg(ResponseCode.GATEWAYNAME_REPEAT.getMessage());
                return response;
            }
            gateway.setCreateTime(new Date());
            gateway.setFlag("0");
            if(userId!=null) {
                Company company = companyMapper.selectByPrimaryKey(userId);
                gateway.setLoginName(company.getCompanyName());
                gateway.setUserId(userId);
                gateway.setCreateUser(userId);
            }
            //新增网关
            gatewayMapper.insertSelective(gateway);
        }
        //新增通道
        if(!gatewayAddQuery.getPassList().isEmpty()){
            savePass(gatewayAddQuery.getPassList(),userId,null,gateway);
        }
        //新增或修改继电器
        if (!gatewayAddQuery.getRelayList().isEmpty()) {
            for (Relay  relay: gatewayAddQuery.getRelayList()) {
                if(relay.getId()!=null){
                    Relay relay1 = relayMapper.selectByPrimaryKey(relay.getId());
                    relay1.setDealStatus(relay.getDealStatus());
                    //根据id查询
                    relay1.setUpdateTime(new Date());
                    if(userId!=null) {
                        relay1.setUpdateUser(userId);
                        relay1.setUserId(userId);
                    }
                    //修改
                    relayMapper.insertSelective(relay1);
                }else{
                    //新增
                    relay.setFlag("0");
                    relay.setGatewayId(gateway.getId());
                    relay.setCreateTime(new Date());
                    if(userId!=null) {
                        relay.setUserId(userId);
                        relay.setCreateUser(userId);
                    }
                    relayMapper.insertSelective(relay);
                }

                //记录继电器控制指令
                if (StringUtils.isBlank(relay.getDealStatus())) {
                    throw new MyException("请输入控制指令进行继电器的开关操作");
                }
                if (relay.getWayNo() == null) {
                    throw new MyException("请确认继电器路数");
                }
                //登记控制指令
                Controlinstru controlInstru=new Controlinstru();
                controlInstru.setRelayId(relay.getId());
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
                controlInstru.setFlag("0");
                if(userId!=null){
                    controlInstru.setUserId(userId);
                    controlInstru.setCreateUser(userId);
                }
                controlinstruMapper.insertSelective(controlInstru);
            }
        }

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
    /**
     * 新增或修改通道
     */
    public synchronized void  savePass(List<Pass> passList,Integer userId,Sensor sensor,
                                       Gateway gateway){
        //新增或修改通道
        if (!passList.isEmpty()) {
            for (Pass pass : passList) {
                if(pass.getId()!=null){
                    Pass pass1 = passMapper.selectByPrimaryKey(pass.getId());
                    pass1.setGatewayName(pass.getGatewayName());
                    pass1.setSensorName(pass.getSensorName());
                    pass1.setSensorType(pass.getSensorType());
                    pass1.setAnalogZero(pass.getAnalogZero());
                    pass1.setAnalogFull(pass.getAnalogFull());
                    pass1.setSensorZero(pass.getSensorZero());
                    pass1.setSensorFull(pass.getSensorFull());
                    pass1.setAlarmCeil(pass.getAlarmCeil());
                    pass1.setAlarmFloor(pass.getAlarmFloor());
                    pass1.setDecimalPlaces(pass.getDecimalPlaces());
                    //修改通道
                    pass1.setUpdateTime(new Date());
                    if(userId!=null) {
                        pass1.setUpdateUser(userId);
                    }
                    passMapper.updateByPrimaryKey(pass1);
                }else{
                    //新增通道
                    if(gateway!=null&&StringUtils.isNotBlank(gateway.getGatewayName())) {
                        Integer passNo = queryPassNo(gateway.getGatewayName());
                        pass.setPassNo(passNo);
                    }
                    pass.setFlag("0");
                    if(gateway!=null){
                        pass.setGatewayId(gateway.getId());
                        pass.setGatewayName(gateway.getGatewayName());
                    }
                    if(sensor!=null){
                        pass.setSensorId(sensor.getId());
                        pass.setSensorName(sensor.getName());
                    }
                    pass.setCreateTime(new Date());
                    if(userId!=null) {
                        pass.setUserId(userId);
                        pass.setCreateUser(userId);
                    }
                    passMapper.insertSelective(pass);
                }

            }
        }

    }

    /**
     * 查询并新增通道号
     * @return
     */
    public synchronized Integer queryPassNo(String gatewayName){
        //查询当前通道号
        Integer passNo=passMapper.queryMaxPassNoByGatewayName(gatewayName);
        if(passNo==null||passNo<=0){
            passNo=1;
        }else{
            passNo=+1;
        }
        return passNo;
    }

    /**
     * 根据条件分页查询网关信息
     *
     * @param gatewayQuery
     * @return
     */
    public BaseResponse<PageInfo> findGatewayByCondition(@RequestBody GatewayQuery gatewayQuery, Integer userId) {
        BaseResponse<PageInfo> response = new BaseResponse<>();
        if (gatewayQuery.getPageNo() == null) {
            gatewayQuery.setPageNo(1);
        }
        if (gatewayQuery.getPageSize() == null) {
            gatewayQuery.setPageSize(10);
        }
        PageHelper.startPage(gatewayQuery.getPageNo(), gatewayQuery.getPageSize());
        List<Gateway> gatewayList = gatewayMapper.selectGatewayfo(gatewayQuery);
        PageInfo<Gateway> pageInfo = new PageInfo<>(gatewayList);

        response.setData(pageInfo);
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
    public BaseResponse deleteGateway(Integer id) {
        BaseResponse response = new BaseResponse();
        Gateway gateway = gatewayMapper.selectByPrimaryKey(id);
        gateway.setFlag("1");
        gatewayMapper.updateByPrimaryKey(gateway);
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
    public BaseResponse<Gateway> findGatewayById(Integer id) {
        BaseResponse<Gateway> response = new BaseResponse<>();
        Gateway gateway = gatewayMapper.selectByPrimaryKey(id);
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
    public BaseResponse deleteGatewayBatch(List<Integer> ids) {
        BaseResponse response = new BaseResponse<>();
        for (Integer id : ids) {
            Gateway gateway = gatewayMapper.selectByPrimaryKey(id);
            gateway.setFlag("1");
            gatewayMapper.updateByPrimaryKey(gateway);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
