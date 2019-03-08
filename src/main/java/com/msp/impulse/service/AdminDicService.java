package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Dictionary;
import com.msp.impulse.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDicService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    /**
     *根据分组
     * @param id
     * @return
     */
    public BaseResponse<Dictionary> findDicByGroupCode(Integer id) {
        BaseResponse<Dictionary> response = new BaseResponse<>();
        Dictionary dictionary= dictionaryMapper.selectByPrimaryKey(id);
        response.setData(dictionary);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 新增数据字典
     * @param dictionary
     * @return
     */
    public BaseResponse addDictionary(Dictionary dictionary) {
        BaseResponse response = new BaseResponse<>();
        dictionaryMapper.insertSelective(dictionary);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

//    /**
//     * 根据id查询
//     * @param id
//     * @return
//     */
//    public BaseResponse<DataDictionary> findDicById(String id) {
//        BaseResponse response = new BaseResponse<>();
//        response.setResponseCode(ResponseCode.OK.getCode());
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        return response;
//    }
}
