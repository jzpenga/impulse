package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.entity.Relay;
import com.msp.impulse.query.GatewayQuery;
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
public class GatewayDaoImpl implements GatewayDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Gateway save(Gateway gateway) {
        mongoTemplate.save(gateway);
        return gateway;
    }

    @Override
    public void findAndRemove(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Gateway.class);
    }

    @Override
    public PageBean findGatewayByCondition(GatewayQuery gatewayQuery, String id) {
        Query query = new Query();
        if(StringUtils.isNotBlank(id)){
            query.addCriteria(Criteria.where("userId").is(id));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getGatewayName())) {
            Pattern pattern = Pattern.compile("^" + gatewayQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("gatewayName").regex(pattern));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getWorkModel())) {
            query.addCriteria(Criteria.where("workModel").is(gatewayQuery.getWorkModel()));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getGatewayType())) {
            query.addCriteria(Criteria.where("gatewayType").is(gatewayQuery.getGatewayType()));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getGatewayModel())) {
            query.addCriteria(Criteria.where("gatewayModel").is(gatewayQuery.getGatewayModel()));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getWorkStatus())) {
            query.addCriteria(Criteria.where("workStatus").is(gatewayQuery.getWorkStatus()));
        }
        //查询总条数
        Long totalRecord = mongoTemplate.count(query, Gateway.class);
        Sort sort = new Sort(Sort.Direction.DESC, "gatewayNo");
        if(gatewayQuery.getPageNo()==null){
            gatewayQuery.setPageNo(1);
        }
        if(gatewayQuery.getPageSize()==null){
            gatewayQuery.setPageSize(10);
        }
        Pageable pageable = new PageRequest(gatewayQuery.getPageNo()-1, gatewayQuery.getPageSize(), sort);
        List<Gateway> gatewayList= mongoTemplate.find(query.with(pageable), Gateway.class);

        PageBean pageBean = new PageBean(gatewayQuery.getPageNo(), gatewayQuery.getPageSize(), totalRecord.intValue());
        pageBean.setList(gatewayList);
        return pageBean;

    }

    @Override
    public boolean findByName(String gatewayName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("gatewayName").is(gatewayName));
        List<Gateway> gateways = mongoTemplate.find(query, Gateway.class);
        if (gateways.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Gateway findGatewayById(String id) {
        Query query=new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Gateway.class);
    }


    /**
     * 通过网关名称和路数查询继电器
     * @param gatewayName
     * @param wayNo
     * @return
     */
    @Override
    public Relay findByNameAndWay(String gatewayName, Integer wayNo) {
        Query query=new Query();
        query.addCriteria(Criteria.where("gatewayName").is(gatewayName));
        Gateway gateway = mongoTemplate.findOne(query, Gateway.class);
        if(gateway!=null) {
            for (Relay relay : gateway.getRelayList()) {
                if (relay.getWayNo() == wayNo) {
                    return relay;
                }
            }
        }
        return null;
    }

    @Override
    public  PageBean findGatewayByUserId(String userId) {
        Query query=new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        //总条数
        Long count = mongoTemplate.count(query, Gateway.class);
        //分页
        Pageable pageable = new PageRequest(0, 10, sort);
        PageBean pageBean = new PageBean(1,10, count.intValue());
        List<Gateway> gateways = mongoTemplate.find(query.with(pageable), Gateway.class);
        pageBean.setList(gateways);
        return pageBean;
    }
}
