package com.rainsho.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rainsho.entity.Log;
import com.rainsho.entity.LogWithBLOBs;

@Repository
public interface LogMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(LogWithBLOBs record);

    int insertSelective(LogWithBLOBs record);

    LogWithBLOBs selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(LogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogWithBLOBs record);

    int updateByPrimaryKey(Log record);
    
    List<LogWithBLOBs> selectAllLogs();
    
    List<LogWithBLOBs> selectLogsByUid(Integer uid);
}