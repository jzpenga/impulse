package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Dictionary;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.DictionaryMapper;
import com.msp.impulse.query.DicQuery;
import com.msp.impulse.query.GatewayQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public BaseResponse<Dictionary> findDicById(Integer id) {
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
        //确定层级
        if(dictionary.getParentId()==null){
            dictionary.setHierarchy("1");
        }else{
            //根据父id查询，是否存在父id
            Dictionary dictionary1= dictionaryMapper.selectByPrimaryKey(dictionary.getParentId());
            if(dictionary1==null){
                throw new MyException("父id【"+dictionary.getParentId()+"】对应的记录不存在！");
            }
            if(dictionary1.getParentId()==null){
                //没有则为第二级
                dictionary.setHierarchy("2");
            }else{
                // 有则为第三级
                dictionary.setHierarchy("3");
            }
        }
        BaseResponse response = new BaseResponse<>();
        if(dictionary.getId()!=null){
            //修改
            Dictionary dictionaryUpdate = dictionaryMapper.selectByPrimaryKey(dictionary.getId());
            dictionaryUpdate.setDicName(dictionary.getDicName());
            dictionaryUpdate.setUpdateTime(new Date());
            dictionaryMapper.updateByPrimaryKey(dictionaryUpdate);
        }else{
            //新增
            dictionary.setCreateTime(new Date());
            dictionary.setFlag("0");
            dictionaryMapper.insertSelective(dictionary);
            //跟新dicCode
            dictionary.setDicCode(dictionary.getId()+"");
            dictionaryMapper.updateByPrimaryKey(dictionary);

        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public BaseResponse<PageInfo> findDicByCondition(DicQuery dicQuery) {
        BaseResponse response = new BaseResponse<>();
        if (dicQuery.getPageNo() == null) {
            dicQuery.setPageNo(1);
        }
        if (dicQuery.getPageSize() == null) {
            dicQuery.setPageSize(10);
        }
        PageHelper.startPage(dicQuery.getPageNo(), dicQuery.getPageSize());
        List<Dictionary> dictionaryList=dictionaryMapper.findDicByCondition(dicQuery);
        PageInfo<Dictionary> dictionaryPageInfo = new PageInfo<>(dictionaryList);

        response.setData(dictionaryPageInfo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 删除系统码表数据
     * @param ids
     * @return
     */
    public BaseResponse deleteDic(List<Integer> ids) {
        BaseResponse response = new BaseResponse<>();
        for (Integer id:ids) {
            Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(id);
            dictionary.setFlag("1");
            dictionaryMapper.updateByPrimaryKey(dictionary);
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
