package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.SensorDao;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.Pass;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.query.PassQuery;
import com.msp.impulse.query.SensorQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.bson.Document;

import java.util.List;
import java.util.regex.Pattern;

@Repository
public class SensorDaoImpl implements SensorDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据id查找传感器
     * @param id
     * @return
     */
    @Override
    public Sensor findOne(String id) {
        Query query=new  Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Sensor.class);
    }

    /**
     * 保存传感器
     * @param sensor
     */
    @Override
    public void save(Sensor sensor) {
        mongoTemplate.save(sensor);
    }

    /**
     * 判断名称是否重复
     * @param name
     * @return
     */
    @Override
    public boolean findByName(String name) {
        Query query=new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Sensor> sensorList = mongoTemplate.find(query, Sensor.class);
        if(!sensorList.isEmpty()){
            return  true;
        }
        return false;
    }

    /**
     * 根据条件查询传感器
     * @param sensorQuery
     * @return
     */
    @Override
    public List<Sensor> queryBySensorAndGateway(SensorQuery sensorQuery,String userId) {

        Query query =new Query();
        if(StringUtils.isNotBlank(userId)){
            query.addCriteria(Criteria.where("userId").is(userId));
        }
        if(StringUtils.isNotBlank(sensorQuery.getGatewayName())) {
            Pattern pattern = Pattern.compile("^" + sensorQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("gatewayName").regex(pattern));
        }
        if(StringUtils.isNotBlank(sensorQuery.getSensorName())) {
            Pattern pattern = Pattern.compile("^" + sensorQuery.getSensorName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("name").regex(pattern));
        }
        Pageable pageable=new PageRequest(sensorQuery.getPageNo(),sensorQuery.getPageSize());
        query.with(pageable);
        query.with(Sort.by(Sort.Order.desc("sensorNo")));
        List<Sensor> sensorList = mongoTemplate.find(query, Sensor.class);
        return sensorList;
    }

    /**
     * 通过网关名称通道号查询通道
     * @param passQuery
     * @return
     */
    @Override
    public Pass queryByPassNoAndGatewayName(PassQuery passQuery) {
        Query query=new Query();
        query.addCriteria(Criteria.where("equipmentName").is(passQuery.getGatewayName()));
        List<Gateway> gateways = mongoTemplate.find(query, Gateway.class);
        if (!gateways.isEmpty()){
            List<Pass> passList = gateways.get(0).getPassList();
            for (Pass pass:passList) {
                if(
//                   pass.getSensorName().equals(passQuery.getSensorName())&&
                     pass.getPassNo().equals(passQuery.getPassNo())){
                    return pass;
                }
            }
        }
        return null;
    }

    @Override
    public void findAndRemove(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Sensor.class);
    }

    @Override
    public  List<Sensor> findSensorByUserId(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        List<Sensor> sensorList = mongoTemplate.find(query, Sensor.class);
        return sensorList;
    }

    /**
     *
     * 根据deviceId查找序列号
     * @param deviceId
     * @return
     */
    @Override
    public String findByDeviceId(String deviceId) {
        Query query = new Query(Criteria.where("deviceId").is(deviceId));
        Sensor sensor = mongoTemplate.findOne(query, Sensor.class);
        if(sensor!=null){
            return sensor.getSensorNo();
        }
        return null;
    }

    @Override
    public Sensor findSensorByDeviceId(String deviceId) {
        Query query = new Query(Criteria.where("deviceId").is(deviceId));
        return mongoTemplate.findOne(query, Sensor.class);
    }

    @Override
    public List<Sensor> findByLoginName(String loginName) {
        Query query = new Query(Criteria.where("loginName").is(loginName));
        return mongoTemplate.find(query, Sensor.class);
    }

    @Override
    public List<Sensor> querySensorNotRelation() {
        Query query = new Query(Criteria.where("userId").exists(false));
        List<Sensor> sensorList = mongoTemplate.find(query, Sensor.class);
        return  sensorList;
    }

    @Override
    public Sensor findBySensorName(String sensorName) {
        Query query = new Query(Criteria.where("name").is(sensorName));
        Sensor sensor = mongoTemplate.findOne(query, Sensor.class);
        return  sensor;
    }
}
