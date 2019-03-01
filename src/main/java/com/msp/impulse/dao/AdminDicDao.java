package com.msp.impulse.dao;

import com.msp.impulse.entity.DataDictionary;

import java.util.List;

public interface AdminDicDao {
    List<DataDictionary> findDicByGroupCode(String groupCode);

    void save(DataDictionary dataDictionary);
}
