package com.msp.impulse.mapper;

import com.msp.impulse.entity.Pass;
import com.msp.impulse.entity.PassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PassMapper {
    long countByExample(PassExample example);

    int deleteByExample(PassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pass record);

    int insertSelective(Pass record);

    List<Pass> selectByExample(PassExample example);

    Pass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pass record, @Param("example") PassExample example);

    int updateByExample(@Param("record") Pass record, @Param("example") PassExample example);

    int updateByPrimaryKeySelective(Pass record);

    int updateByPrimaryKey(Pass record);

    Pass queryByPassNoAndGatewayName(@Param("gatewayName") String gatewayName,@Param("passNo") Integer passNo);

    Integer queryMaxPassNoByGatewayName(String gatewayName);
}