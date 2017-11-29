package com.bqjr.report.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.bqjr.report.model.SearchCondition;

@Service
public interface InventoryWarnService {

	public Map<String,Object> getInventoryWarnList(int pageNum,int pageSize,SearchCondition condition);
	
	public Map<String,Object> getDetail(String schemaName,String commodityId,String whId,String type,String unsalableDays,String supplierId);
}
