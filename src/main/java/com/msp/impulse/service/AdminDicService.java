package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Dictionary;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.DictionaryMapper;
import com.msp.impulse.query.ChildDicQuery;
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
        if(dictionary.getDicName()==null){
            throw  new MyException("系统编码名称不能为空!");
        }
        if(dictionary.getDicCode()==null){
            throw  new MyException("系统编码不能为空!");
        }
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
            if(!dictionaryUpdate.getDicName().equals(dictionary.getDicName())){
                Dictionary dictionary2=dictionaryMapper.findDicByDicName(dictionary.getDicName());
                if(dictionary2!=null){
                    throw new MyException("名称重复");
                }
            }
            dictionaryUpdate.setDicName(dictionary.getDicName());
            dictionaryUpdate.setUpdateTime(new Date());
            dictionaryMapper.updateByPrimaryKey(dictionaryUpdate);
        }else{
            //判断dicCode是否重复
           Dictionary dictionary1= dictionaryMapper.findDicByDicCode(dictionary.getDicCode());
           if(dictionary1!=null){
                throw new MyException("编码重复");
           }
           //判断名称是否重复
            Dictionary dictionary2=dictionaryMapper.findDicByDicName(dictionary.getDicName());
            if(dictionary2!=null){
                throw new MyException("名称重复");
            }
            //新增
            dictionary.setCreateTime(new Date());
            dictionary.setFlag("0");
            dictionaryMapper.insertSelective(dictionary);
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

    /**
     * 根据id查询子系统编码
     * @param childDicQuery
     * @return
     */
    public BaseResponse<PageInfo> findChildDicCode(ChildDicQuery childDicQuery) {
        BaseResponse<PageInfo> response = new BaseResponse<>();
        if(childDicQuery.getId()==null){
           throw new MyException("id必输");
        }
        if (childDicQuery.getPageNo() == null) {
            childDicQuery.setPageNo(1);
        }
        if (childDicQuery.getPageSize() == null) {
            childDicQuery.setPageSize(10);
        }
        PageHelper.startPage(childDicQuery.getPageNo(), childDicQuery.getPageSize());
        List<Dictionary> dictionaryList=dictionaryMapper.findChildDicCode(childDicQuery.getId());
        PageInfo<Dictionary> dictionaryPageInfo = new PageInfo<>(dictionaryList);

        response.setData(dictionaryPageInfo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
