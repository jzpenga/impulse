package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iotplatform.client.dto.DeviceInfo;
import com.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.RealTimeDataDao;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.*;
import com.msp.impulse.nb.utils.NBDXManager;
import com.msp.impulse.query.SensorAddQuery;
import com.msp.impulse.query.SensorQuery;
import org.apache.commons.lang.StringUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private PassMapper passMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private GatewayService gatewayService;
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private IotDeviceModelMapper iotDeviceModelMapper;
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;
    @Autowired
    private RealTimeDataDao realTimeDataDao;
    @Autowired
    private DeviceServiceMapper deviceServiceMapper;

    /**
     * 新增传感器
     *
     * @param sensorAddQuery
     * @return
     */
    @Transactional
    public BaseResponse saveSensor(SensorAddQuery sensorAddQuery, Integer userId) {
        BaseResponse response = new BaseResponse();
        addSensor(sensorAddQuery, userId);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public void addSensor(SensorAddQuery sensorAddQuery, Integer userId) {
        Sensor sensor = sensorAddQuery.getSensor();
        if (sensor == null) {
            throw new MyException("请输入传感器信息!");
        }
        //传感器名称必输
        if (StringUtils.isBlank(sensor.getName())) {
            throw new MyException("传感器名称必输!");
        }
        if (StringUtils.isBlank(sensor.getSensorType())) {
            throw new MyException("传感器类型必输!");
        }
        if (StringUtils.isBlank(sensor.getSensorModel())) {
            throw new MyException("传感器型号必输!");
        }
        if (StringUtils.isBlank(sensor.getSensorNo())) {
            throw new MyException("传感器序列号必输!");
        }
        if (sensor.getId() != null) {//修改
            //查询传感器
            Sensor sensorUp = sensorMapper.selectByPrimaryKey(sensor.getId());
            if (sensorUp == null) {
                throw new MyException("id对应的传感器不存在!");
            }
//            //判断网关名称是否唯一
//            if (!sensorUp.getName().equals(sensor.getName())&&sensorMapper.findBySensorName(sensor.getName())>0) {
//                throw  new MyException("传感器名称已存在!");
//            }
            sensorUp.setName(sensor.getName());
            sensorUp.setGatewayName(sensor.getGatewayName());
            sensorUp.setSensorNo(sensor.getSensorNo());
            sensorUp.setSensorModel(sensor.getSensorModel());
            sensorUp.setSensorType(sensor.getSensorType());
            sensorUp.setLatitude(sensor.getLatitude());
            sensorUp.setLongitude(sensor.getLongitude());
            sensorUp.setPassNumber(sensor.getPassNumber());
            sensorUp.setUpdateTime(new Date());
            if (userId != null) {
                sensorUp.setUpdateUser(userId);
            }
            sensorMapper.updateByPrimaryKey(sensorUp);
            List<Pass> passList = sensorAddQuery.getPassList();
            if (passList != null) {
                gatewayService.savePass(passList, userId, sensor, null);
            }
        } else {//新增
            //获取传感器序列号
            if (StringUtils.isBlank(sensor.getSensorNo())) {
                throw new RuntimeException("传感器序列号不能为空!");
            }
//            //判断网关名称是否唯一
//            if (sensorMapper.findBySensorName(sensor.getName())>0) {
//                throw  new MyException("传感器名称已存在!");
//            }

            String deviceModel = getDeviceModel(sensor.getSensorModel());
            //获取iotServiceType
            String iotServiceType = getIotServiceType(sensor.getSensorModel());
            if(StringUtils.isBlank(iotServiceType)){
                throw new MyException("iot设备类型不存在!");
            }
            //注册电信运营商
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setName(sensor.getName());
            deviceInfo.setDeviceType(iotServiceType);
            deviceInfo.setModel(deviceModel);
            deviceInfo.setNodeId(sensor.getSensorNo());// mac 地址

            RegDirectDeviceOutDTO regDirectDeviceOutDTO = NBDXManager.registerDevice(deviceInfo);
            if (regDirectDeviceOutDTO == null) {
                throw new MyException("注册失败,请检查设备序列号是否正确或稍后重试!");
            }
            if (StringUtils.isBlank(regDirectDeviceOutDTO.getDeviceId())) {
                throw new MyException("注册失败,请检查设备序列号是否正确或稍后重试!");
            }
            sensor.setDeviceId(regDirectDeviceOutDTO.getDeviceId());

            sensor.setFlag("0");
            sensor.setCreateTime(new Date());
            if (userId != null) {
                CompanyExample companyExample = new CompanyExample();
                companyExample.createCriteria().andFlagEqualTo("0").andIdEqualTo(userId);
                List<Company> companyList = companyMapper.selectByExample(companyExample);
                if (!companyList.isEmpty()) {
                    Company company = companyList.get(0);
                    if (StringUtils.isNotBlank(company.getCompanyName())) {
                        sensor.setUserName(company.getCompanyName());
                    }
                }
                sensor.setCreateUser(userId);
                sensor.setUserId(userId);
            }
            try {
                sensorMapper.insertSelective(sensor);
            } catch (Exception e) {
                //删除
                NBDXManager.deleteDevice(regDirectDeviceOutDTO.getDeviceId());
                throw new MyException("插入数据库失败，已回滚!");
            }
            //根据设备模型查询服务类型
            DeviceServiceExample deviceServiceExample=new DeviceServiceExample();
            deviceServiceExample.createCriteria().andTypeNameEqualTo(deviceModel).andFlagEqualTo("0");
            List<DeviceService> deviceServices = deviceServiceMapper.selectByExample(deviceServiceExample);
            for(DeviceService deviceService:deviceServices) {
                //新增实时数据
                RealTimeData realTimeData=new RealTimeData();
                realTimeData.setCreateTime(new Date());
                realTimeData.setDataKey(deviceService.getServiceCode());
                realTimeData.setDeviceId(regDirectDeviceOutDTO.getDeviceId());
                realTimeDataDao.save(realTimeData);
            }
        }
        if (userId != null) {//传感器数加1
            changeSensorNumber(userId, 1);
        }

        List<Pass> passList = sensorAddQuery.getPassList();
        if (passList != null) {
            try {
                gatewayService.savePass(passList, userId, sensor, null);
            } catch (Exception e) {
                //删除
                SensorExample sensorExample = new SensorExample();
                sensorExample.createCriteria().andIdEqualTo(sensor.getId()).andFlagEqualTo("0");
                List<Sensor> sensorList = sensorMapper.selectByExample(sensorExample);
                if (sensorList.isEmpty()) {
                    throw new MyException("传感器id对应的值不存在");
                }
                Sensor sensor1 = sensorList.get(0);
                NBDXManager.deleteDevice(sensor1.getDeviceId());
                throw new MyException("插入数据库失败，已回滚!");
            }
        }
    }
    public  String getDeviceModel(String deviceModelId){
        DeviceTypeExample deviceTypeExample=new DeviceTypeExample();
        deviceTypeExample.createCriteria().andIdEqualTo(Integer.parseInt(deviceModelId)).andFlagEqualTo("0");
        List<DeviceType> deviceTypeList = deviceTypeMapper.selectByExample(deviceTypeExample);
        if (deviceTypeList.isEmpty()) {
            throw new MyException("id【" + deviceModelId + "】对应的传感器型号不存在");
        }
        String dicName = deviceTypeList.get(0).getDeviceType();
        return dicName;
    }

    public String getIotServiceType(String sensorModelId) {
        //查询设备型号名称
        String dicName = getDeviceModel(sensorModelId);
        //根据型号查询
        IotDeviceModelExample iotDeviceModelExample = new IotDeviceModelExample();
        iotDeviceModelExample.createCriteria().andFlagEqualTo("0").andSensorModelEqualTo(dicName);
        List<IotDeviceModel> iotDeviceModels = iotDeviceModelMapper.selectByExample(iotDeviceModelExample);
        if (iotDeviceModels.isEmpty()) {
            throw new MyException(dicName + "对应的iot类型不存在");
        }
        String iotSensorTypeId = iotDeviceModels.get(0).getIotSensorType();
        //根据iotServiceType查询名称
        DictionaryExample dictionaryExampleModel1 = new DictionaryExample();
        dictionaryExampleModel1.createCriteria().andFlagEqualTo("0").andIdEqualTo(Integer.parseInt(iotSensorTypeId));
        List<Dictionary> dictionaryList2= dictionaryMapper.selectByExample(dictionaryExampleModel1);
        if(dictionaryList2.isEmpty()){
            throw new MyException(iotSensorTypeId + "对应的数据字典不存在");
        }
        return dictionaryList2.get(0).getDicName();
    }

    /**
     * 更改company表的传感器数
     *
     * @param userId
     * @param changeNumber 删除传负数
     */
    public synchronized void changeSensorNumber(Integer userId, Integer changeNumber) {
        //根据userId查询当前sensorNumber
        Company company = companyMapper.selectByPrimaryKey(userId);
        Integer sensorNumber;
        if (company != null) {
            if (company.getSensorNumber() == null) {
                sensorNumber = 0;
            } else {
                sensorNumber = company.getSensorNumber();
                sensorNumber = sensorNumber + changeNumber;
            }
            company.setSensorNumber(sensorNumber);
            companyMapper.updateByPrimaryKey(company);
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
        if (userId != null) {
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
    public BaseResponse<SensorAddQuery> querySensorById(Integer id) {
        BaseResponse<SensorAddQuery> response = new BaseResponse<>();
        SensorAddQuery sensorAddQuery = new SensorAddQuery();
        SensorExample sensorExample = new SensorExample();
        sensorExample.createCriteria().andIdEqualTo(id).andFlagEqualTo("0");
        List<Sensor> sensorList = sensorMapper.selectByExample(sensorExample);
        //根据id查询通道
        if (!sensorList.isEmpty()) {
            sensorAddQuery.setSensor(sensorList.get(0));
        }
        PassExample passExample = new PassExample();
        passExample.createCriteria().andSensorIdEqualTo(id).andFlagEqualTo("0");
        List<Pass> passList = passMapper.selectByExample(passExample);
        sensorAddQuery.setPassList(passList);
        response.setData(sensorAddQuery);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据网关名称，通道号查询通道信息
     *
     * @param gatewayName
     * @param passNo
     * @return
     */
    public BaseResponse<Pass> queryByPassNoAndGatewayName(String gatewayName, Integer passNo) {
        BaseResponse response = new BaseResponse();
        Pass pass = passMapper.queryByPassNoAndGatewayName(gatewayName, passNo);
        response.setData(pass);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 删除传感器
     *
     * @param id
     * @return
     */
    @Transactional
    public BaseResponse deleteSensor(Integer id, Integer userId) {
        BaseResponse response = new BaseResponse();
        //删除运营商传感器
        deleteNBDXSensor(id);
        //传感器数减一
        if (userId != null) {
            changeSensorNumber(userId, -1);
        }
        //更新传感器flag为1
        SensorExample sensorExample = new SensorExample();
        sensorExample.createCriteria().andFlagEqualTo("0")
                .andIdEqualTo(id);
        List<Sensor> sensorList = sensorMapper.selectByExample(sensorExample);
        if (sensorList.isEmpty()) {
            throw new MyException("id【" + id + "】对应的传感器不存在");
        }
        Sensor sensor = sensorList.get(0);
        sensor.setFlag("1");
        sensorMapper.updateByPrimaryKey(sensor);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 删除电信运营商设备
     */
    public void deleteNBDXSensor(Integer sensorId) {
        Sensor sensor = sensorMapper.selectByPrimaryKey(sensorId);
        NBDXManager.deleteDevice(sensor.getDeviceId());
    }

    /**
     * 批量删除传感器
     *
     * @param ids
     * @return
     */
    @Transactional
    public BaseResponse deleteSensorBatch(List<Integer> ids, Integer userId) {
        BaseResponse response = new BaseResponse();
        for (Integer id : ids) {
            //删除运营商传感器
            deleteNBDXSensor(id);
            //传感器数减一
            if (userId != null) {
                changeSensorNumber(userId, -1);
            }
            //删除传感器
            Sensor sensor = sensorMapper.selectByPrimaryKey(id);
            sensor.setFlag("1");
            sensorMapper.updateByPrimaryKey(sensor);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

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

    /**
     * 查询未被关联的传感器
     *
     * @return
     */
    public BaseResponse<List<Sensor>> querySensorNotRelation(String sensorName) {
        BaseResponse response = new BaseResponse();
        List<Sensor> sensorList = sensorMapper.querySensorNotRelation(sensorName);
        response.setData(sensorList);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 关联传感器与用户
     *
     * @param userId
     * @param sensorName
     * @return
     */
    public BaseResponse relationSensorAndUser(Integer userId, String sensorName) {
        BaseResponse response = new BaseResponse();
        //根据用户id查询用户信息
        Company company = companyMapper.selectByPrimaryKey(userId);
        //根据传感器名称查询传感器信息
        Sensor sensor = sensorMapper.findSensorBySensorName(sensorName);
        //关联
        sensor.setUserId(company.getId());
        sensor.setUserName(company.getLoginName());
        sensorMapper.updateByPrimaryKey(sensor);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public Sensor queryByDeviceId(String deviceId) {
        return sensorMapper.findSensorByDeviceId(deviceId);
    }

    /**
     * 根据名称查询传感器信息
     *
     * @param sensorName
     * @return
     */
    public BaseResponse<List<Sensor>> findSensorByName(String sensorName) {
        BaseResponse<List<Sensor>> response = new BaseResponse();
        if (TextUtils.isEmpty(sensorName)) {
            response.setData(new ArrayList<>());
            response.setResponseCode(ResponseCode.OK.getCode());
            response.setResponseMsg(ResponseCode.OK.getMessage());
            return response;
        }
        //根据传感器名称查询传感器信息
        List<Sensor> sensorList = sensorMapper.findSensorByNameLike(sensorName);
        if (sensorList.isEmpty()) {
            response.setData(new ArrayList<>());
            response.setResponseCode(ResponseCode.OK.getCode());
            response.setResponseMsg(ResponseCode.OK.getMessage());
            return response;
        }
        response.setData(sensorList);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
