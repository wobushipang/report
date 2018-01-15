package com.bqjr.report.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bqjr.report.model.InventoryWarn;
import com.bqjr.report.model.ProxySale;
import com.bqjr.report.model.PurchaseCollect;
import com.bqjr.report.model.SearchCondition;

/**
 * 
 * @author jialong.sun
 *
 */
public interface ReportMapper {
	
	//采购汇总
	List<PurchaseCollect> getpurchaseCollectList(SearchCondition condition);
	//采购订单
	List<PurchaseCollect> getPurchaseOrder(SearchCondition condition);
	//采购入库
	List<PurchaseCollect> getPurchaseWarehouse(SearchCondition condition);
	//采购退货
	List<PurchaseCollect> getPurchaseRefunds(SearchCondition condition);
	//采购换货
	List<PurchaseCollect> getPurchaseExchangeIn(SearchCondition condition);
	
	List<PurchaseCollect> getPurchaseExchangeOut(SearchCondition condition);
	
	//代销汇总
	List<ProxySale> getProxySaleList(SearchCondition condition);
	
	List<ProxySale> getMarket(SearchCondition condition);
	
	List<ProxySale> getProceedsAmount(SearchCondition condition);
	
	//低库存
	List<InventoryWarn> getInventoryWarnList(SearchCondition condition);
	
	//滞销库存
	List<InventoryWarn> getInventoryWarnList1(SearchCondition condition);
	
	//串号详情
	List<InventoryWarn> getDetail(@Param("schemaName")String schemaName,@Param("commodityId")String commodityId,@Param("whId")String whId);
	
	List<InventoryWarn> getDetails(@Param("schemaName")String schemaName,@Param("commodityId")String commodityId,@Param("whId")String whId,@Param("supplierId")String supplierId);
	
	//组织机构
	List<SearchCondition> getOrgList(@Param("orgId")String id,@Param("schemaName")String schemaName);
	
	//供应商
	List<SearchCondition> getSupplierList(@Param("orgId")List<String> orgId,@Param("schemaName")String schemaName);
	
	//商品分类
	List<SearchCondition> getCatalogList(@Param("orgId")String id,@Param("schemaName")String schemaName);
	
	//商品品牌
	List<SearchCondition> getBrandList(@Param("orgId")String id,@Param("schemaName")String schemaName,@Param("catalogCode")String catalogCode);
	
	//商品型号
	List<SearchCondition> getModelList(@Param("orgId")String id,@Param("schemaName")String schemaName,@Param("brandCode")String brandCode);

	//商品规格
	List<SearchCondition> getSpecList(@Param("codes")List<String> codes,@Param("schemaName")String schemaName,@Param("orgId")String orgId);

	//业务名称
	List<SearchCondition> getBusinessList(@Param("orgId")String orgId, @Param("schemaName")String schemaName, @Param("businessType")String businessType);
}
