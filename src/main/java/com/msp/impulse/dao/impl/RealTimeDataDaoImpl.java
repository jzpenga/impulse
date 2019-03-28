package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.RealTimeDataDao;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.entity.RealTimeData;
import com.msp.impulse.query.DataHistoryQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class RealTimeDataDaoImpl implements RealTimeDataDao {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public RealTimeData selectByDeviceIdAndDataKey(String deviceId, String dataKey) {
        Query query=new Query();
        query.addCriteria(Criteria.where("deviceId").is(deviceId).and("dataKey").is(dataKey));
         RealTimeData realTimeData = mongoTemplate.findOne(query, RealTimeData.class);
        return realTimeData;
    }

    @Override
    public void save(RealTimeData realTimeData) {
        mongoTemplate.save(realTimeData);
    }

    @Override
    public PageBean selectRealTimeDataInfo(DataHistoryQuery dataHistoryQuery) {
        Query query =new Query();
        Criteria criteria=new Criteria();
        criteria.and("dataValue").exists(true);
        if(StringUtils.isNotBlank(dataHistoryQuery.getSensorName())){
            Pattern pattern = Pattern.compile("^.*" + dataHistoryQuery.getSensorName() + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("sensorName").regex(pattern);
        }
        if(StringUtils.isNotBlank(dataHistoryQuery.getGatewayName())) {
            Pattern pattern = Pattern.compile("^.*" + dataHistoryQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("gatewayName").regex(pattern);
        }
        if(StringUtils.isNotBlank(dataHistoryQuery.getSensorType())) {
            criteria.and("dataKey").is(dataHistoryQuery.getSensorType());
        }
        Criteria eventTime = criteria.and("eventTime").nin("0");
        if(StringUtils.isNotBlank(dataHistoryQuery.getReportDateFrom())){//上报时间 From
            eventTime.gte(dataHistoryQuery.getReportDateFrom());
        }
        if(StringUtils.isNotBlank(dataHistoryQuery.getReportDateTo())){//上报时间to
            eventTime.lte(dataHistoryQuery.getReportDateTo());
        }
        Query query1 = query.addCriteria(criteria);

        //查询总条数
        Long totalRecord = mongoTemplate.count(query1, RealTimeData.class);
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        if(dataHistoryQuery.getPageNo()==null){
            dataHistoryQuery.setPageNo(1);
        }
        if(dataHistoryQuery.getPageSize()==null){
            dataHistoryQuery.setPageSize(10);
        }
        Pageable pageable = new PageRequest(dataHistoryQuery.getPageNo()-1, dataHistoryQuery.getPageSize(), sort);
        List<RealTimeData> realTimeDataList = mongoTemplate.find(query1.with(pageable), RealTimeData.class);

        PageBean pageBean = new PageBean(dataHistoryQuery.getPageNo(), dataHistoryQuery.getPageSize(), totalRecord.intValue());
        pageBean.setList(realTimeDataList);
        return pageBean;
    }
}
