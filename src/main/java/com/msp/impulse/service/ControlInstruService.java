package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.ControlInstruDao;
import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.entity.ControlInstru;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.entity.Relay;
import com.msp.impulse.query.ControlInstruQuery;
import com.msp.impulse.query.ControllnstruUpdateQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class ControlInstruService {
    @Autowired
    private ControlInstruDao controlInstruDao;
    @Autowired
    private GatewayDao gatewayDao;
    /**
     * 根据条件查询控制指令
     * @param controlInstruQuery
     * @return
     */
    public BaseResponse findControlInstru(ControlInstruQuery controlInstruQuery,String userId) throws ParseException {
        BaseResponse response=new BaseResponse();
        PageBean pageBean= controlInstruDao.findControlInstru(controlInstruQuery,userId);
        response.setData(pageBean);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 开关操作
     * @param updateQuery
     * @return
     */
    public BaseResponse updateControlInstru(ControllnstruUpdateQuery updateQuery) {
        BaseResponse response=new BaseResponse();
        //判断改条操作指令是否有未返回状态的操作,若有，提示不可以重复提交
       List<ControlInstru>  controlInstruList= controlInstruDao.findByDealStatusAndReturnStatus(updateQuery);
       if(!controlInstruList.isEmpty()){
           response.setResponseCode(ResponseCode.CONTRO_NOT_DONE.getCode());
           response.setResponseMsg(ResponseCode.CONTRO_NOT_DONE.getMessage());
           return response;
       }
       //查询当前路数对应的继电器
       Relay relay= gatewayDao.findByNameAndWay(updateQuery.getGatewayName(),updateQuery.getWayNo());
       if(relay==null){
           response.setResponseCode(ResponseCode.RELAY_NOT_EXSIST.getCode());
           response.setResponseMsg(ResponseCode.RELAY_NOT_EXSIST.getMessage());
           return response;
       }
       //新增记录
        ControlInstru controlInstru=new ControlInstru();
        controlInstru.setRelay(relay);
        controlInstru.setDownTime(new Date());//下发时间
        controlInstru.setDealStatus(relay.getDealStatus());//处理状态0-开 1-关
        controlInstru.setExecuteTime(new Date());//执行时间
//                controlInstru.setReturnStatus();//返回状态
        controlInstru.setExtraMessage(updateQuery.getExtraMessage());//附加信息
        controlInstru.setGatewayName(updateQuery.getGatewayName());//网关名称
        controlInstru.setWayNo(relay.getWayNo());//网关路数
//                controlInstru.setUpdateTime();//更新时间
//                controlInstru.setFinalStatus();//最终状态
        controlInstru.setCreateTime(new Date());
        controlInstruDao.save(controlInstru);

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
