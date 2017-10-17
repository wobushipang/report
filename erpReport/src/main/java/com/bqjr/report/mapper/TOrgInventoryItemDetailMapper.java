package com.bqjr.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bqjr.report.model.TOrgInventoryItemDetail;

public interface TOrgInventoryItemDetailMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(TOrgInventoryItemDetail record);

    int insertSelective(TOrgInventoryItemDetail record);

    TOrgInventoryItemDetail selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(TOrgInventoryItemDetail record);

    int updateByPrimaryKey(TOrgInventoryItemDetail record);
    
    void batchInsertClient(@Param("list")List<TOrgInventoryItemDetail> list);
}