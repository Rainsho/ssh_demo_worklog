package com.rainsho.dao;

import com.rainsho.entity.Log;
import com.rainsho.entity.LogWithBLOBs;

public interface LogMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(LogWithBLOBs record);

    int insertSelective(LogWithBLOBs record);

    LogWithBLOBs selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(LogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogWithBLOBs record);

    int updateByPrimaryKey(Log record);
}