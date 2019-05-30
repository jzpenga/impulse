package com.msp.impulse.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Dictionary;
import com.msp.impulse.entity.DictionaryExample;
import com.msp.impulse.entity.User;
import com.msp.impulse.exception.MyException;
import com.msp.impulse.mapper.DictionaryMapper;
import com.msp.impulse.mapper.UserMapper;
import com.msp.impulse.query.ChildDicQuery;
import com.msp.impulse.query.DicQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminDicService {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据分组
     *
     * @param id
     * @return
     */
    public BaseResponse<Dictionary> findDicById(Integer id) {
        BaseResponse<Dictionary> response = new BaseResponse<>();
        Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(id);
        response.setData(dictionary);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 新增数据字典
     *
     * @param dictionary
     * @return
     */
    public BaseResponse addDictionary(Dictionary dictionary,Integer userId) {
        if (StringUtils.isBlank(dictionary.getDicName())) {
            throw new MyException("系统编码名称不能为空!");
        }
        if (StringUtils.isBlank(dictionary.getDicCode())) {
            throw new MyException("系统编码不能为空!");
        }
        //确定层级
        if (dictionary.getParentId() == null) {
            dictionary.setHierarchy("1");
        } else {
            //根据父id查询，是否存在父id
            Dictionary dictionary1 = dictionaryMapper.selectByPrimaryKey(dictionary.getParentId());
            if (dictionary1 == null) {
                throw new MyException("父id【" + dictionary.getParentId() + "】对应的记录不存在！");
            }
            if (dictionary1.getParentId() == null) {
                //没有则为第二级
                dictionary.setHierarchy("2");
            } else {
                // 有则为第三级
                dictionary.setHierarchy("3");
            }
        }
        BaseResponse response = new BaseResponse<>();
        if (dictionary.getId() != null) {
            //修改
            Dictionary dictionaryUpdate = dictionaryMapper.selectByPrimaryKey(dictionary.getId());
            if (!dictionaryUpdate.getDicName().equals(dictionary.getDicName())) {
                Dictionary dictionary2 = dictionaryMapper.findDicByDicName(dictionary.getDicName());
                if (dictionary2 != null) {
                    throw new MyException("名称重复");
                }
            }
            dictionaryUpdate.setDicName(dictionary.getDicName());
            if(StringUtils.isNotBlank(dictionary.getExt1())){
                dictionaryUpdate.setExt1(dictionary.getExt1());
            }
            dictionaryUpdate.setUpdateTime(new Date());
            dictionaryUpdate.setUpdateUser(userId+"");

            dictionaryMapper.updateByPrimaryKey(dictionaryUpdate);
        } else {
            //判断dicCode是否重复
            Dictionary dictionary1 = dictionaryMapper.findDicByDicCode(dictionary.getDicCode());
            if (dictionary1 != null) {
                throw new MyException("编码重复");
            }
            //判断名称是否重复
            Dictionary dictionary2 = dictionaryMapper.findDicByDicName(dictionary.getDicName());
            if (dictionary2 != null) {
                throw new MyException("名称重复");
            }
            //新增
            dictionary.setCreateTime(new Date());
            dictionary.setFlag("0");
            dictionary.setCreateUser(userId+"");
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
            dicQuery.setPageSize(100);
        }
        PageHelper.startPage(dicQuery.getPageNo(), dicQuery.getPageSize());
        List<Dictionary> dictionaryList = dictionaryMapper.findDicByCondition(dicQuery);
        PageInfo<Dictionary> dictionaryPageInfo = new PageInfo<>(dictionaryList);

        response.setData(dictionaryPageInfo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 删除系统码表数据
     *
     * @param ids
     * @return
     */
    public BaseResponse deleteDic(List<Integer> ids,Integer userId) {
        BaseResponse response = new BaseResponse<>();
        for (Integer id : ids) {
            Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(id);
            dictionary.setFlag("1");
            dictionaryMapper.updateByPrimaryKey(dictionary);
            //查询下一级删除
            DictionaryExample dictionaryExample=new DictionaryExample();
            dictionaryExample.createCriteria().andFlagEqualTo("0").andParentIdEqualTo(id);
            List<Dictionary> dictionaryList2 = dictionaryMapper.selectByExample(dictionaryExample);
            if(!dictionaryList2.isEmpty()){
                for ( Dictionary secondDictionary: dictionaryList2) {
                    secondDictionary.setFlag("1");
                    secondDictionary.setUpdateUser(userId+"");
                    dictionaryMapper.updateByPrimaryKey(secondDictionary);

                    DictionaryExample dictionaryExample3=new DictionaryExample();
                    dictionaryExample3.createCriteria().andFlagEqualTo("0").andParentIdEqualTo(secondDictionary.getId());
                    List<Dictionary> dictionaryList3 = dictionaryMapper.selectByExample(dictionaryExample3);
                    if(!dictionaryList3.isEmpty()) {
                        for (Dictionary thirdDictionary : dictionaryList3) {
                            thirdDictionary.setFlag("1");
                            thirdDictionary.setUpdateUser(userId+"");
                            dictionaryMapper.updateByPrimaryKey(thirdDictionary);
                        }
                    }
                }
            }
        }
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据id查询子系统编码
     *
     * @param childDicQuery
     * @return
     */
    public BaseResponse<PageInfo> findChildDicCode(ChildDicQuery childDicQuery) {
        BaseResponse<PageInfo> response = new BaseResponse<>();
        if (childDicQuery.getId() == null) {
            throw new MyException("id必输");
        }
        if (childDicQuery.getPageNo() == null) {
            childDicQuery.setPageNo(1);
        }
        if (childDicQuery.getPageSize() == null) {
            childDicQuery.setPageSize(100);
        }
        PageHelper.startPage(childDicQuery.getPageNo(), childDicQuery.getPageSize());
        List<Dictionary> dictionaryList = dictionaryMapper.findChildDicCode(childDicQuery.getId());
        PageInfo<Dictionary> dictionaryPageInfo = new PageInfo<>(dictionaryList);

        response.setData(dictionaryPageInfo);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    public BaseResponse findAllDic(Integer id) {
        BaseResponse response = new BaseResponse<>();
        List listSecond = new ArrayList();
        //查询第一级
        DictionaryExample example=new DictionaryExample();
        example.createCriteria().andFlagEqualTo("0").andIdEqualTo(id);
        Dictionary dictionary = dictionaryMapper.selectByExample(example).get(0);
        if (dictionary != null) {
            if (dictionary.getId() != null) {
                DictionaryExample dictionaryExample = new DictionaryExample();
                dictionaryExample.createCriteria().andParentIdEqualTo(dictionary.getId()).andFlagEqualTo("0");
                List<Dictionary> dictionaryList = dictionaryMapper.selectByExample(dictionaryExample);

                for (Dictionary secondDictionary : dictionaryList) {
                    HashMap secondMap = new HashMap();
                    secondMap.put("title", secondDictionary.getDicName());
                    secondMap.put("key", secondDictionary.getDicCode());
                    secondMap.put("value", secondDictionary.getId());

                    //根据二级id查询三级
                    if(secondDictionary.getId()!=null) {
                        DictionaryExample dictionaryExample3 = new DictionaryExample();
                        dictionaryExample3.createCriteria().andParentIdEqualTo(secondDictionary.getId()).andFlagEqualTo("0");
                        List<Dictionary> dictionaryList3 = dictionaryMapper.selectByExample(dictionaryExample3);
                        List listThird = new ArrayList();
                        for (Dictionary third : dictionaryList3) {
                            HashMap thirdMap = new HashMap();
                            thirdMap.put("title",third.getDicName());
                            thirdMap.put("key",third.getDicCode());
                            thirdMap.put("value",third.getId());
                            listThird.add(thirdMap);
                        }
                        secondMap.put("child3",listThird);
                    }
                    listSecond.add(secondMap);
                }
            }
        }
        response.setData(listSecond);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
