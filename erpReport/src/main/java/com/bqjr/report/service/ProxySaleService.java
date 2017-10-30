package com.bqjr.report.service;

import java.util.Map;

import com.bqjr.report.model.SearchCondition;

public interface ProxySaleService {

	public Map<String,Object>getProxySaleList(int pageNum,int pageSize,SearchCondition condition);
}
