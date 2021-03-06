package com.msp.impulse.mapper;

import com.msp.impulse.entity.Dictionary;
import com.msp.impulse.entity.DictionaryExample;
import com.msp.impulse.query.DicQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryMapper {
    long countByExample(DictionaryExample example);

    int deleteByExample(DictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    List<Dictionary> selectByExample(DictionaryExample example);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

    List<Dictionary> findDicByCondition(DicQuery dicQuery);

    List<Dictionary> findChildDicCode(Integer id);

    Dictionary findDicByDicCode(String dicCode);

    Dictionary findDicByDicName(String dicName);
}