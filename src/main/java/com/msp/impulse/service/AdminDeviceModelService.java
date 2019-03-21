package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.IotDeviceModel;
import com.msp.impulse.entity.IotDeviceModelExample;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.IotDeviceModelMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class AdminDeviceModelService {
    @Autowired
    private IotDeviceModelMapper iotDeviceModelMapper;

    /**
     * 新增iot平台设备类型
     * @param iotDeviceModel
     * @return
     */
    @Transactional
    public BaseResponse saveDeviceType(IotDeviceModel iotDeviceModel , HttpSession session) throws IOException {
        BaseResponse response=new BaseResponse();
        MultipartFile file = iotDeviceModel.getFile();
        if (file.isEmpty()) {
            response.setResponseCode(ResponseCode.FILE_NOT_HAVE.getCode());
            response.setResponseMsg(ResponseCode.FILE_NOT_HAVE.getMessage());
            return response;
        }
        // 设置文件存储路径
        String path = session.getServletContext().getRealPath("/upload/");
        System.out.println("path:"+path);

        String filename = file.getOriginalFilename();
        File filepath = new File(path, filename);
        // 检测是否存在目录
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();// 新建文件夹
        }
        //检测文件是否存在
        if (filepath.exists()){//存在删除
            filepath.delete();
        }
        file.transferTo(new File(path + File.separator + filename));// 文件写入

        if(StringUtils.isBlank(iotDeviceModel.getSensorModel())){
            throw  new MyException("请输入设备型号!");
        }
        if(StringUtils.isBlank(iotDeviceModel.getIotSensorType())){
            throw  new MyException("请输入iot设备类型!");
        }
        if(iotDeviceModel.getId()!=null){//修改
            IotDeviceModelExample iotDeviceModelExample=new IotDeviceModelExample();
            iotDeviceModelExample.createCriteria().andFlagEqualTo("0").andIdEqualTo(iotDeviceModel.getId());
            List<IotDeviceModel> iotDeviceModels = iotDeviceModelMapper.selectByExample(iotDeviceModelExample);
            if(!iotDeviceModels.isEmpty()){

                IotDeviceModel iotDeviceModel1 = iotDeviceModels.get(0);
                //根据设备型号查询
                IotDeviceModelExample iotDeviceModelExample1=new IotDeviceModelExample();
                iotDeviceModelExample1.createCriteria().andSensorModelEqualTo(iotDeviceModel.getSensorModel()).andFlagEqualTo("0");
                List<IotDeviceModel> iotDeviceModels1= iotDeviceModelMapper.selectByExample(iotDeviceModelExample1);
                if(!iotDeviceModel1.getSensorModel().equals(iotDeviceModel.getSensorModel())&&!iotDeviceModels1.isEmpty()){
                    throw  new MyException("已存在设备型号为【"+iotDeviceModels1.get(0).getSensorModel()+"】的iot设备类型");
                }
                iotDeviceModel1.setIotSensorType(iotDeviceModel.getIotSensorType());
                iotDeviceModel1.setSensorModel(iotDeviceModel.getSensorModel());
                iotDeviceModel1.setUpdateTime(new Date());
                iotDeviceModelMapper.updateByPrimaryKey(iotDeviceModel1);
            }
        }else{//新增
            //根据设备型号查询
            IotDeviceModelExample iotDeviceModelExample=new IotDeviceModelExample();
            iotDeviceModelExample.createCriteria().andSensorModelEqualTo(iotDeviceModel.getSensorModel()).andFlagEqualTo("0");
            List<IotDeviceModel> iotDeviceModels = iotDeviceModelMapper.selectByExample(iotDeviceModelExample);
            if(!iotDeviceModels.isEmpty()){
                throw  new MyException("已存在设备型号为【"+iotDeviceModel.getSensorModel()+"】的iot设备类型");
            }
            iotDeviceModel.setCreateTime(new Date());
            iotDeviceModel.setFlag("0");
            iotDeviceModelMapper.insertSelective(iotDeviceModel);
        }
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public BaseResponse queryDeviceModelById(Integer id) {
        BaseResponse response=new BaseResponse();
        IotDeviceModelExample iotDeviceModelExample=new IotDeviceModelExample();
        iotDeviceModelExample.createCriteria().andIdEqualTo(id).andFlagEqualTo("0");
        List<IotDeviceModel> iotDeviceModels = iotDeviceModelMapper.selectByExample(iotDeviceModelExample);
        if(!iotDeviceModels.isEmpty()){
            IotDeviceModel iotDeviceModel = iotDeviceModels.get(0);
            response.setData(iotDeviceModel);
        }
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }

    /**
     * 根据id删iot设备模型
     * @param ids
     * @return
     */
    @Transactional
    public BaseResponse deleteDeviceModelById(List<Integer> ids) {
        BaseResponse response=new BaseResponse();
        for (Integer id:ids) {
            iotDeviceModelMapper.deleteByPrimaryKey(id);
        }
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }

    public BaseResponse queryDeviceModelList(IotDeviceModel iotDeviceModel) {
        BaseResponse response=new BaseResponse();
        List<IotDeviceModel> iotDeviceModelList=iotDeviceModelMapper.selectIotList(iotDeviceModel);
        response.setData(iotDeviceModelList);
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }
}
