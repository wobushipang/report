package com.bqjr.report.mapper;

import java.util.List;
import java.util.Map;



public interface BaseUtilMapper {

    void batchDeleteClient(Map<String,Object> map);

    void batchInsertClient(Map<String,Object> map);
    
    String tableExist(String name);
    
    List<String> getColumnName(String name);
}