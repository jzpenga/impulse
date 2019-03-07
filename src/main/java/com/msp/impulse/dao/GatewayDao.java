//package com.msp.impulse.dao;
//
//import com.msp.impulse.entity.Gateway;
//import com.msp.impulse.entity.PageBean;
//import com.msp.impulse.entity.Relay;
//import com.msp.impulse.query.GatewayQuery;
//
//import java.util.List;
//
//public interface GatewayDao {
//    Gateway save(Gateway gateway);
//
//    void findAndRemove(String id);
//
//    PageBean findGatewayByCondition(GatewayQuery gatewayQuery,String id);
//
//    boolean findByName(String gatewayName);
//
//    Gateway findGatewayById(String id);
//
//    Relay findByNameAndWay(String gatewayName, Integer wayNo);
//
//    PageBean findGatewayByUserId(String userId);
//}
