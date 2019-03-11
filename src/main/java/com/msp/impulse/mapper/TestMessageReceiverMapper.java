package com.msp.impulse.mapper;

import com.msp.impulse.entity.TestMessageReceiver;
import com.msp.impulse.entity.TestMessageReceiverExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMessageReceiverMapper {
    long countByExample(TestMessageReceiverExample example);

    int deleteByExample(TestMessageReceiverExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestMessageReceiver record);

    int insertSelective(TestMessageReceiver record);

    List<TestMessageReceiver> selectByExampleWithBLOBs(TestMessageReceiverExample example);

    List<TestMessageReceiver> selectByExample(TestMessageReceiverExample example);

    TestMessageReceiver selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestMessageReceiver record, @Param("example") TestMessageReceiverExample example);

    int updateByExampleWithBLOBs(@Param("record") TestMessageReceiver record, @Param("example") TestMessageReceiverExample example);

    int updateByExample(@Param("record") TestMessageReceiver record, @Param("example") TestMessageReceiverExample example);

    int updateByPrimaryKeySelective(TestMessageReceiver record);

    int updateByPrimaryKeyWithBLOBs(TestMessageReceiver record);

}