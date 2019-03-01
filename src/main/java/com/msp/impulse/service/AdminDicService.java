package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.AdminDicDao;
import com.msp.impulse.entity.DataDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDicService {
    @Autowired
    private AdminDicDao adminDicDao;

    /**
     *根据分组
     * @param groupCode
     * @return
     */
    public BaseResponse<List<DataDictionary>> findDicByGroupCode(String groupCode) {
        BaseResponse<List<DataDictionary>> response = new BaseResponse<>();
        List<DataDictionary> dataDictionaryList= adminDicDao.findDicByGroupCode(groupCode);
        response.setData(dataDictionaryList);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 新增数据字典
     * @param dataDictionary
     * @return
     */
    public BaseResponse addDictionary(DataDictionary dataDictionary) {
        BaseResponse response = new BaseResponse<>();
        adminDicDao.save(dataDictionary);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
