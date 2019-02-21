package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.ControlInstruDao;
import com.msp.impulse.entity.ControlInstru;
import com.msp.impulse.query.ControlInstruQuery;
import com.msp.impulse.query.ControllnstruUpdateQuery;
import com.msp.impulse.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class ControlInstruDaoImpl implements ControlInstruDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void save(ControlInstru controlInstru) {
        mongoTemplate.save(controlInstru);
    }

    /**
     * 查询控制指令
     * @param controlInstruQuery
     * @return
     */
    @Override
    public List<ControlInstru> findControlInstru(ControlInstruQuery controlInstruQuery) throws ParseException {
        Query query = new Query();
        if (StringUtils.isNotBlank(controlInstruQuery.getGatewayName())){
            Pattern pattern = Pattern.compile("^" + controlInstruQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("gatewayName").regex(pattern));
        }
        //最终的开关状态
        if(StringUtils.isNotBlank(controlInstruQuery.getExecuteStatus())){
            query.addCriteria(Criteria.where("finalStatus").is(controlInstruQuery.getExecuteStatus()));
        }
        //处理状态
        if(StringUtils.isNotBlank(controlInstruQuery.getDealStatus())){
            query.addCriteria(Criteria.where("dealStatus").is(controlInstruQuery.getDealStatus()));
        }

        Criteria downTime=null;
        //下发时间
        if(controlInstruQuery.getDownTimeStart()!=null){//下发时间from
             downTime = Criteria.where("downTime").gte(DateUtil.dateToISODate(controlInstruQuery.getDownTimeStart()));
        }
        if(controlInstruQuery.getDownTimeEnd()!=null){//下发时间to
            downTime.lte(DateUtil.dateToISODate(controlInstruQuery.getDownTimeEnd()));
        }
        if(downTime!=null) {
            query.addCriteria(downTime);
        }

        Criteria executeTime=null;
        //执行时间
        if(controlInstruQuery.getExecuteTimeStart()!=null){//执行时间from
            executeTime= Criteria.where("executeTime").gte(DateUtil.dateToISODate(controlInstruQuery.getExecuteTimeStart()));
        }
        if(controlInstruQuery.getExecuteTimeEnd()!=null){//执行时间to
            executeTime.lte(DateUtil.dateToISODate(controlInstruQuery.getExecuteTimeEnd()));
        }
        if(executeTime!=null){
            query.addCriteria(executeTime);
        }
        List<ControlInstru> controlInstrus = mongoTemplate.find(query, ControlInstru.class);
        return controlInstrus;
    }

    @Override
    public List<ControlInstru> getControlInstruList() {
        Query query=new Query();
        List<ControlInstru> controlInstruList = mongoTemplate.find(query, ControlInstru.class);
        return controlInstruList;
    }


    @Override
    public void updateControlInstru(ControllnstruUpdateQuery updateQuery) {



    }

    @Override
    public List<ControlInstru> findByDealStatusAndReturnStatus(ControllnstruUpdateQuery controllnstruUpdateQuery) {
        Query query=new Query();
        query.addCriteria(Criteria.where("gatewayName").is(controllnstruUpdateQuery.getGatewayName())
                        .and("wayNo").is(controllnstruUpdateQuery.getWayNo())
                .and("dealStatus").in("0","1")
                .and("returnStatus").nin("0","1"));
        List<ControlInstru> controlInstruList = mongoTemplate.find(query, ControlInstru.class);
        return controlInstruList;
    }

}
