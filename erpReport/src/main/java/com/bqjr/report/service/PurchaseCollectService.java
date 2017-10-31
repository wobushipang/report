package com.bqjr.report.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.bqjr.report.model.SearchCondition;


/**
 * 
 * @author jialong.sun
 *
 */
@Service
public interface PurchaseCollectService {

	public Map<String, Object> getpurchaseCollectList(int pageNum,int pageSize,SearchCondition condition);
	
	public String getOrgList(String id,String schemaName);
	
	public String getSupplierList(String id,String schemaName);
	
	public String getCatalogList(String id,String schemaName);
	
	public String getBrandList(String id,String schemaName,String catalogCode);
	
	public String getModelList(String id,String schemaName,String modelCode);
	
	public String getBusinessList(String schemaName, String businessType);
}
