package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.controller.AdminDeviceModelController;
import com.msp.impulse.entity.*;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.DeviceModelMapper;
import com.msp.impulse.mapper.DictionaryMapper;
import com.msp.impulse.mapper.ModelServiceMapper;
import com.msp.impulse.query.DeviceModelQuery;
import com.msp.impulse.vo.DeviceModelVo;
import com.msp.impulse.vo.ModelServiceVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Service
public class AdminDeviceModelService {
    @Autowired
    private DeviceModelMapper deviceModelMapper;
    @Autowired
    private ModelServiceMapper modelServiceMapper;
    @Autowired
    private DictionaryMapper dictionaryMapper;

    private static Logger logger = LoggerFactory.getLogger(AdminDeviceModelController.class);

    /**
     * 新增iot平台设备类型
     *
     * @param deviceModelQuery
     * @return
     */
    @Transactional
    public BaseResponse saveDeviceType(DeviceModelQuery deviceModelQuery) throws IOException {
        BaseResponse response = new BaseResponse();
        if (StringUtils.isBlank(deviceModelQuery.getSensorModel())) {
            throw new MyException("请输入设备型号名称!");
        }
        if (StringUtils.isBlank(deviceModelQuery.getIotSensorType())) {
            throw new MyException("请输入iot设备类型!");
        }
        if (deviceModelQuery.getId() != null) {//修改
            DeviceModelExample deviceModelExample = new DeviceModelExample();
            deviceModelExample.createCriteria().andFlagEqualTo("0").andIdEqualTo(deviceModelQuery.getId());
            List<DeviceModel> deviceModels = deviceModelMapper.selectByExample(deviceModelExample);
            if (deviceModels.isEmpty()) {
                throw  new MyException("不存在此数据!");
            }
            DeviceModel deviceModel1 = deviceModels.get(0);
            //根据设备型号查询
            DeviceModelExample deviceModelExample1 = new DeviceModelExample();
            deviceModelExample1.createCriteria().andSensorModelEqualTo(deviceModelQuery.getSensorModel()).andFlagEqualTo("0");
            List<DeviceModel> deviceModelList = deviceModelMapper.selectByExample(deviceModelExample1);
            if (!deviceModel1.getSensorModel().equals(deviceModelQuery.getSensorModel()) && !deviceModelList.isEmpty()) {
                throw new MyException("已存在设备型号为【" + deviceModelList.get(0).getSensorModel() + "】的iot设备类型");
            }
            //上传文件
            String fileName = fileUpload(deviceModelQuery.getFile());

            deviceModel1.setIotSensorType(deviceModelQuery.getIotSensorType());
            deviceModel1.setSensorModel(deviceModelQuery.getSensorModel());
            deviceModel1.setDeviceType(deviceModel1.getDeviceType());
            deviceModel1.setFileName(fileName);
            deviceModel1.setUpdateTime(new Date());
            deviceModelMapper.updateByPrimaryKey(deviceModel1);

            //更新modelService==========================================start
            ModelServiceExample modelServiceExample = new ModelServiceExample();
            modelServiceExample.createCriteria().andDeviceModelIdEqualTo(deviceModelQuery.getId()).andFlagEqualTo("0");
            List<ModelService> modelServices = modelServiceMapper.selectByExample(modelServiceExample);
            for (ModelService modelService : modelServices) {
                modelService.setUpdateTime(new Date());
                modelService.setFlag("1");
                modelServiceMapper.updateByPrimaryKey(modelService);
            }
            List<Integer> modelServiceIds = deviceModelQuery.getModelServiceIds();
            if (!modelServiceIds.isEmpty()) {
                //新增modelService
                for (Integer id : modelServiceIds) {
                    addModelService(id, deviceModelQuery.getSensorModel(), deviceModelQuery.getId());
                }
            }
            //更新modelService=============================================end
        } else {//新增
            DeviceModel deviceModel = new DeviceModel();
            //上传文件
            String fileName = fileUpload(deviceModelQuery.getFile());
            //新增  deviceMode
            DeviceModelExample deviceModelExample = new DeviceModelExample();
            deviceModelExample.createCriteria().andSensorModelEqualTo(deviceModelQuery.getSensorModel()).andFlagEqualTo("0");
            List<DeviceModel> iotDeviceModels = deviceModelMapper.selectByExample(deviceModelExample);
            if (!iotDeviceModels.isEmpty()) {
                throw new MyException("已存在设备型号名称为【" + deviceModelQuery.getSensorModel() + "】的iot设备类型");
            }
            if (StringUtils.isNotBlank(deviceModelQuery.getDeviceType())) {
                deviceModel.setDeviceType(deviceModelQuery.getDeviceType());
            }
            deviceModel.setFileName(fileName);
            deviceModel.setIotSensorType(deviceModelQuery.getIotSensorType());
            deviceModel.setSensorModel(deviceModelQuery.getSensorModel());
            deviceModel.setCreateTime(new Date());
            deviceModel.setFlag("0");
            deviceModelMapper.insertSelective(deviceModel);

            //新增modelService
            List<Integer> modelServiceIds = deviceModelQuery.getModelServiceIds();
            if (modelServiceIds!=null||!modelServiceIds.isEmpty()) {
                //新增modelService
                for (Integer id : modelServiceIds) {
                    addModelService(id, deviceModelQuery.getSensorModel(), deviceModel.getId());
                }
            }
        }
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }

    /**
     * 新增modelService
     *
     * @param dicId
     * @param sensorModel
     * @param modelId
     */
    public void addModelService(Integer dicId, String sensorModel, Integer modelId) {
        //查询是否已经存在 设备型号和传感类型相同的数据
        Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(dicId);
        if (getModelService(modelId, dictionary.getDicCode()) != null) {
            throw new MyException("已存在设备型号为【" + sensorModel
                    + "】传感类型为【" + dictionary.getDicCode() + "】的数据!");
        }
        ModelService modelService = new ModelService();
        modelService.setModelName(sensorModel);
        modelService.setDeviceModelId(modelId);
        modelService.setServiceCode(dictionary.getDicCode());
        modelService.setCodeName(dictionary.getDicName());
        modelService.setFlag("0");
        modelService.setCreateTime(new Date());
        modelServiceMapper.insertSelective(modelService);
    }

    public ModelService getModelService(Integer serviceModelId, String dicCode) {
        ModelServiceExample modelServiceExample = new ModelServiceExample();
        modelServiceExample.createCriteria()
                .andFlagEqualTo("0").andServiceCodeEqualTo(dicCode)
                .andDeviceModelIdEqualTo(serviceModelId);
        List<ModelService> modelServices = modelServiceMapper.selectByExample(modelServiceExample);
        if (modelServices.isEmpty()) {
            return null;
        }
        return modelServices.get(0);
    }

    public String fileUpload(MultipartFile file) throws IOException {
        if (file == null) {
            throw new MyException("文件不存在！");
        }
        // 设置文件存储路径
        String path = "/tmp/upload/";
//        String path = "D:/upload/";
        logger.info("path================================:" + path);
        System.out.println("path:" + path);

        String filename = file.getOriginalFilename();
        File filepath = new File(path, filename);
        // 检测是否存在目录
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();// 新建文件夹
        }
        //检测文件是否存在
        if (filepath.exists()) {//存在删除
            filepath.delete();
        }
        file.transferTo(new File(path + File.separator + filename));// 文件写入
        return filename;
    }

    /**
     * 根据id查询信息
     *
     * @param id
     * @return
     */
    public BaseResponse queryDeviceModelById(Integer id) {
        BaseResponse response = new BaseResponse();
        ModelServiceVo modelServiceVo = new ModelServiceVo();
        DeviceModelExample deviceModelExample = new DeviceModelExample();
        deviceModelExample.createCriteria().andIdEqualTo(id).andFlagEqualTo("0");
        List<DeviceModel> iotDeviceModels = deviceModelMapper.selectByExample(deviceModelExample);
        if (!iotDeviceModels.isEmpty()) {
            DeviceModel iotDeviceModel = iotDeviceModels.get(0);
            modelServiceVo.setCreateTime(iotDeviceModel.getCreateTime());
            modelServiceVo.setDeviceType(iotDeviceModel.getDeviceType());
            modelServiceVo.setFileName(iotDeviceModel.getFileName());
            modelServiceVo.setId(iotDeviceModel.getId());
            modelServiceVo.setIotSensorType(iotDeviceModel.getIotSensorType());
            modelServiceVo.setSensorModel(iotDeviceModel.getSensorModel());
        }
        ModelServiceExample modelServiceExample = new ModelServiceExample();
        modelServiceExample.createCriteria().andDeviceModelIdEqualTo(id).andFlagEqualTo("0");
        List<ModelService> modelServices = modelServiceMapper.selectByExample(modelServiceExample);
        modelServiceVo.setModelServiceList(modelServices);

        response.setData(modelServiceVo);
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }

    /**
     * 根据id删iot设备模型
     *
     * @param ids
     * @return
     */
    @Transactional
    public BaseResponse deleteDeviceModelById(List<Integer> ids) {
        BaseResponse response = new BaseResponse();
        for (Integer id : ids) {
            DeviceModel deviceModel = deviceModelMapper.selectByPrimaryKey(id);
            if (deviceModel == null) {
                throw new MyException("数据不存在");
            }
            deviceModel.setUpdateTime(new Date());
            deviceModel.setFlag("1");
            deviceModelMapper.updateByPrimaryKey(deviceModel);
        }
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }


    public BaseResponse queryDeviceModelList(DeviceModel deviceModel) {
        BaseResponse<PageInfo> response = new BaseResponse<>();
        if (deviceModel.getPageNo() == null) {
            deviceModel.setPageNo(1);
        }
        if (deviceModel.getPageSize() == null) {
            deviceModel.setPageSize(20);
        }
        PageHelper.startPage(deviceModel.getPageNo(), deviceModel.getPageSize());
        List<DeviceModelVo> deviceModelVoList = deviceModelMapper.selectIotList(deviceModel);
        PageInfo<DeviceModelVo> pageInfo = new PageInfo<>(deviceModelVoList);
        response.setData(pageInfo);
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }

    /**
     * 文件下载
     *
     * @param fileName
     * @param response
     * @return
     */
    public void profileDownload(String fileName, HttpServletResponse response, HttpSession session) throws IOException {
        String path = "/tmp/upload/";
//        String path = "D:/upload/";
        // 构建File
        File file = new File(path + File.separator + fileName);
        if (!file.exists()) {
            throw new MyException("文件不存在!");
        }
        response.reset();
        response.setContentType(session.getServletContext().getMimeType(fileName));
        response.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode(fileName));
        InputStream inStream = new FileInputStream(file);
        OutputStream os = response.getOutputStream();

        byte[] buff = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buff)) > 0) {
            os.write(buff, 0, len);
        }
        os.flush();
        os.close();
        inStream.close();
    }

    /**
     * 查询所有deviceType
     *
     * @return
     */
    public BaseResponse findDeviceType() {
        BaseResponse response = new BaseResponse<>();
        DeviceModelExample iotDeviceModelExample = new DeviceModelExample();
        iotDeviceModelExample.createCriteria().andFlagEqualTo("0");
        List<DeviceModel> deviceModelList = deviceModelMapper.selectByExample(iotDeviceModelExample);
        response.setData(deviceModelList);
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }
}
