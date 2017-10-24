package com.bqjr.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bqjr.report.model.PurchaseCollect;
import com.bqjr.report.model.SearchCondition;

/**
 * 
 * @author jialong.sun
 *
 */
public interface ReportMapper {

	List<PurchaseCollect> getpurchaseCollectList(SearchCondition condition);
	
	List<SearchCondition> getOrgList(@Param("orgId")String id,@Param("schemaName")String schemaName);
	
	List<SearchCondition> getSupplierList(@Param("orgId")String id,@Param("schemaName")String schemaName);
	
	List<SearchCondition> getCatalogList(@Param("orgId")String id,@Param("schemaName")String schemaName);
	
	List<SearchCondition> getBrandList(@Param("orgId")String id,@Param("schemaName")String schemaName,@Param("catalogCode")String catalogCode);
	
	List<SearchCondition> getModelList(@Param("orgId")String id,@Param("schemaName")String schemaName,@Param("brandCode")String brandCode);
}
