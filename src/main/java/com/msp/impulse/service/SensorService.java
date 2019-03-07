package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iotplatform.client.dto.DeviceInfo;
import com.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.CompanyMapper;
import com.msp.impulse.mapper.PassMapper;
import com.msp.impulse.mapper.SensorMapper;
import com.msp.impulse.nb.utils.NBDXManager;
import com.msp.impulse.query.PassQuery;
import com.msp.impulse.query.SensorAddQuery;
import com.msp.impulse.query.SensorQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class SensorService {
    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private PassMapper passMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private  GatewayService gatewayService;
    /**
     * 新增传感器
     *
     * @param sensorAddQuery
     * @return
     */
    @Transactional
    public BaseResponse saveSensor(SensorAddQuery sensorAddQuery, Integer userId) {
        BaseResponse response = new BaseResponse();
        addSensor(sensorAddQuery,userId);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public synchronized void  addSensor(SensorAddQuery sensorAddQuery, Integer userId){
        Sensor sensor = sensorAddQuery.getSensor();
        if(sensor==null){
            throw new MyException("请输入传感器信息!");
        }
        //名称必输
        if (StringUtils.isBlank(sensor.getName())) {
          throw  new MyException("传感器名称不能为空!");
        }
        Integer sensorId=0;
        if (sensor.getId()!=null) {//修改
            //查询传感器
            Sensor sensorUp= sensorMapper.selectByPrimaryKey(sensor.getId());
            if(sensorUp==null){
               throw  new MyException("传感器不存在!");
            }
            //判断网关名称是否唯一
            if (!sensorUp.equals(sensor.getName())&&sensorMapper.findBySensorName(sensor.getName())>0) {
                throw  new MyException("传感器名称已存在!");
            }
            sensorUp.setGatewayName(sensor.getGatewayName());
            sensorUp.setUpdateTime(new Date());
            if(userId!=null) {
                sensorUp.setUpdateUser(userId);
            }
            sensorUp.setSensorModel(sensor.getSensorModel());
            sensorUp.setLatitude(sensor.getLatitude());
            sensorUp.setLongitude(sensor.getLongitude());
            sensorUp.setPassNumber(sensor.getPassNumber());
            sensorMapper.updateByPrimaryKey(sensorUp);
            sensorId=sensor.getId();

        }else{//新增
            //获取传感器序列号
            if(StringUtils.isBlank(sensor.getSensorNo())){
                throw  new RuntimeException("传感器序列号不能为空!");
            }
            //判断网关名称是否唯一
            if (sensorMapper.findBySensorName(sensor.getName())>0) {
                throw  new MyException("传感器名称已存在!");
            }
            //传感器名称必输
            if (StringUtils.isBlank(sensor.getName())){
                throw  new MyException("传感器名称必输!");
            }
            if (StringUtils.isBlank(sensor.getSensorType())) {
                throw  new MyException("传感器类型必输!");
            }
            if (StringUtils.isBlank(sensor.getSensorModel())) {
                throw  new MyException("传感器型号必输!");
            }
            //注册电信运营商
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setName(sensor.getName());
            deviceInfo.setDeviceType(sensor.getSensorType());
            deviceInfo.setModel(sensor.getSensorModel());
            Random random = new Random();

            String nodeid = sensor.getSensorNo() + (random.nextInt(9000000) + 1000000); //this is a test imei
            deviceInfo.setNodeId(nodeid);// mac 地址

            RegDirectDeviceOutDTO regDirectDeviceOutDTO = NBDXManager.registerDevice(deviceInfo);
            if(regDirectDeviceOutDTO==null){
                throw  new RuntimeException("注册失败");
            }
            if(StringUtils.isBlank(regDirectDeviceOutDTO.getDeviceId())){
                throw  new MyException("注册失败");
            }
            sensor.setDeviceId(regDirectDeviceOutDTO.getDeviceId());

            sensor.setFlag("0");
            sensor.setCreateTime(new Date());
            if(userId!=null){
                Company company = companyMapper.selectByPrimaryKey(userId);
                sensor.setUserName(company.getCompanyName());
                sensor.setCreateUser(userId);
                sensor.setUserId(userId);

            }
            sensorMapper.insertSelective(sensor);
            sensorId=sensor.getId();
        }

        List<Pass> passList= sensorAddQuery.getPassList();
        if(passList!=null) {
            gatewayService.savePass(passList,userId,sensor,null);
        }
    }
    /**
     * 根据传感器名称和网关查询传感器信息
     *
     * @param sensorQuery
     * @return
     */
    public BaseResponse<PageInfo> queryBySensorAndGateway(SensorQuery sensorQuery, Integer userId) {

        BaseResponse<PageInfo> response = new BaseResponse<>();
        if (sensorQuery.getPageNo() == null) {
            sensorQuery.setPageNo(1);
        }
        if (sensorQuery.getPageSize() == null) {
            sensorQuery.setPageSize(10);
        }
        PageHelper.startPage(sensorQuery.getPageNo(), sensorQuery.getPageSize());
        if(userId!=null){
            sensorQuery.setUserId(userId);
        }
        List<Sensor> sensorList = sensorMapper.selectSensorInfo(sensorQuery);
        PageInfo<Sensor> pageInfo = new PageInfo<>(sensorList);

        response.setData(pageInfo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据id查询传感器
     *
     * @param id
     * @return
     */
    public BaseResponse<Sensor> querySensorById(Integer id) {
        BaseResponse<Sensor> response = new BaseResponse<>();
        Sensor sensor = sensorMapper.selectByPrimaryKey(id);
        response.setData(sensor);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据网关名称，通道号查询通道信息
     *
     * @param passQuery
     * @return
     */
    public BaseResponse<Pass> queryByPassNoAndGatewayName(String gatewayName,Integer passNo) {
        BaseResponse response = new BaseResponse();
        Pass pass = passMapper.queryByPassNoAndGatewayName(gatewayName,passNo);
        response.setData(pass);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

//    /**
//     * 删除传感器
//     *
//     * @param id
//     * @return
//     */
//    @Transactional
//    public BaseResponse deleteSensor(String id,Integer userId) {
//        BaseResponse response = new BaseResponse();
//        //删除运营商传感器
//        deleteNBDXSensor(id);
//        //删除传感器
//        sensorDao.findAndRemove(id);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }
//    /**
//     * 更改company表的传感器数
//     *
//     * @param userId
//     * @param changeNumber 删除传负数
//     */
//    public synchronized void changeSensorNumber(String userId, Integer changeNumber) {
//        //根据userId查询当前gatewayNumber
//        Company company = userDao.findById(userId);
//        if(company!=null){
//            Integer  sensorNumber = company.getSensorNumber();
//            if(sensorNumber>0){
//                sensorNumber=sensorNumber-changeNumber;
//                //改变网关个数
//                company.setSensorNumber(sensorNumber);
//                userDao.save(company);
//            }
//        }
//    }
//    /**
//     * 删除电信运营商设备
//     */
//    public void deleteNBDXSensor(String sensorId) {
//        Sensor sensor= sensorDao.findOne(sensorId);
//        NBDXManager.deleteDevice(sensor.getDeviceId());
//    }

//    /**
//     * 批量删除传感器
//     *
//     * @param ids
//     * @return
//     */
//    @Transactional
//    public BaseResponse deleteSensorBatch(List<String> ids,Integer userId) {
//        BaseResponse response = new BaseResponse();
//        for (String id : ids) {
//            //删除运营商传感器
//            deleteNBDXSensor(id);
//            //删除传感器
//            sensorDao.findAndRemove(id);
//            //更新用户传感器个数
//            if(StringUtils.isNotBlank(userId)){
//                changeSensorNumber(userId,-1);
//            }
//        }
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }

//    /**
//     * 根据loginName查询所有设备
//     */
//    public List<Sensor> getDeviceList(String loginName) {
//        //检验是否为空
//        if (StringUtils.isBlank(loginName)) {
//            throw new RuntimeException("登录名为空！！！");
//        }
//        //判断登录名是否存在
//        Company company = userDao.findByName(loginName);
//        if (company == null) {
//            throw new RuntimeException("登录名不存在！！！");
//        }
//
//        List<Sensor> sensorList = sensorDao.findByLoginName(loginName);
//        return sensorList;
//    }
//
//    /**
//     * 查询未被关联的传感器
//     *
//     * @return
//     */
//    public BaseResponse<List<Sensor>> querySensorNotRelation() {
//        BaseResponse response = new BaseResponse();
//        List<Sensor> sensorList = sensorDao.querySensorNotRelation();
//        response.setData(sensorList);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }

//    /**
//     * 关联传感器与用户
//     * @param userId
//     * @param sensorName
//     * @return
//     */
//    public BaseResponse relationSensorAndUser(String userId, String sensorName) {
//        BaseResponse response = new BaseResponse();
//        //根据用户id查询用户信息
//        Company company = userDao.findById(userId);
//        //根据传感器名称查询传感器信息
//        Sensor sensor=sensorDao.findBySensorName(sensorName);
//        //关联
//        sensor.setUserId(company.getId());
//        sensor.setLoginName(company.getLoginName());
//        sensorDao.save(sensor);
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }
}
