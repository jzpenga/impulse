package com.msp.impulse.mapper;

import com.msp.impulse.entity.Linkman;
import com.msp.impulse.entity.LinkmanExample;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.query.FindUserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LinkmanMapper {
    long countByExample(LinkmanExample example);

    int deleteByExample(LinkmanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Linkman record);

    int insertSelective(Linkman record);

    List<Linkman> selectByExample(LinkmanExample example);

    Linkman selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByExample(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);

    Linkman selectByCompanyId(Integer companyId);
}