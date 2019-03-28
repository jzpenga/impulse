package com.msp.impulse.mapper;

import com.msp.impulse.entity.ModelService;
import com.msp.impulse.entity.ModelServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelServiceMapper {
    long countByExample(ModelServiceExample example);

    int deleteByExample(ModelServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModelService record);

    int insertSelective(ModelService record);

    List<ModelService> selectByExample(ModelServiceExample example);

    ModelService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModelService record, @Param("example") ModelServiceExample example);

    int updateByExample(@Param("record") ModelService record, @Param("example") ModelServiceExample example);

    int updateByPrimaryKeySelective(ModelService record);

    int updateByPrimaryKey(ModelService record);
}