package com.bqjr.report.mapper;

import java.util.List;
import java.util.Map;



public interface BaseUtilMapper {
    
    void batchInsertClient(Map<String,Object> map);
    
    int tableExist(String name);
    
    List<String> getColumnName(String name);
}