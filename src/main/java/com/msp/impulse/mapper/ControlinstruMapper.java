package com.msp.impulse.mapper;

import com.msp.impulse.entity.Controlinstru;
import com.msp.impulse.entity.ControlinstruExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ControlinstruMapper {
    long countByExample(ControlinstruExample example);

    int deleteByExample(ControlinstruExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Controlinstru record);

    int insertSelective(Controlinstru record);

    List<Controlinstru> selectByExample(ControlinstruExample example);

    Controlinstru selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Controlinstru record, @Param("example") ControlinstruExample example);

    int updateByExample(@Param("record") Controlinstru record, @Param("example") ControlinstruExample example);

    int updateByPrimaryKeySelective(Controlinstru record);

    int updateByPrimaryKey(Controlinstru record);
}