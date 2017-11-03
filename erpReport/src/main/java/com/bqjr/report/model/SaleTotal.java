/******************************************************************************
 * Copyright (C) 2010-2020 Billions Finance. All Rights Reserved.
 * ============================================================================
 * 版权所有 2010-2020 佰仟金融服务有限公司，并保留所有权利
 * ----------------------------------------------------------------------------
 * 这不是一个自由软件！您不能在任何未经允许的前提下对程序代码进行修改和使用；不允许
 * 对程序代码以任何形式任何目的的再发布
 * ============================================================================
 *
 * @ProjectName erp
 * @PackageName com.bqjr.report.model
 * @FileName SaleTotal 
 * @author wei.huang02
 * @Date 2017年11月2日 上午9:52:30 
 *****************************************************************************/
package com.bqjr.report.model;

import java.io.Serializable;

/**
 * @ClassName SaleTotal.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年11月2日 上午9:52:30
 * @since JDK 1.8
 */
public class SaleTotal implements Serializable {
	private static final long serialVersionUID = 4830459296833397775L;

	private String schemaName;
	private String orgId;
	private String orgName;
	private String operationType;// 购销方式
	private String commodityCode;// 商品编码
	private String commodityName;// 商品名称
	private String brandName;// 品牌名称
	private String catalogName;// 分类名称
	private String modelName;// 型号
	private String spec;// 规格
	private String specName;// 规格名
	private String saleNum;// 销售数量
	private String giftNum; // 赠品数量
	private String orderSaleNum; // 销售订单数量
	private String orderSaleSum; // 销售订单金额
	private String returnNum; // 销售退货数量
	private String returnSum; // 销售退货金额
	private String saleReturnNum; // 销售换货退回数量
	private String saleReturnSum; // 销售换货退回金额
	private String saleExpendNum; // 销售换货换出数量
	private String saleExpendSum; // 销售换货换出金额
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getCommodityCode() {
		return commodityCode;
	}
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(String saleNum) {
		this.saleNum = saleNum;
	}
	public String getGiftNum() {
		return giftNum;
	}
	public void setGiftNum(String giftNum) {
		this.giftNum = giftNum;
	}
	public String getOrderSaleNum() {
		return orderSaleNum;
	}
	public void setOrderSaleNum(String orderSaleNum) {
		this.orderSaleNum = orderSaleNum;
	}
	public String getOrderSaleSum() {
		return orderSaleSum;
	}
	public void setOrderSaleSum(String orderSaleSum) {
		this.orderSaleSum = orderSaleSum;
	}
	public String getReturnNum() {
		return returnNum;
	}
	public void setReturnNum(String returnNum) {
		this.returnNum = returnNum;
	}
	public String getReturnSum() {
		return returnSum;
	}
	public void setReturnSum(String returnSum) {
		this.returnSum = returnSum;
	}
	public String getSaleReturnNum() {
		return saleReturnNum;
	}
	public void setSaleReturnNum(String saleReturnNum) {
		this.saleReturnNum = saleReturnNum;
	}
	public String getSaleReturnSum() {
		return saleReturnSum;
	}
	public void setSaleReturnSum(String saleReturnSum) {
		this.saleReturnSum = saleReturnSum;
	}
	public String getSaleExpendNum() {
		return saleExpendNum;
	}
	public void setSaleExpendNum(String saleExpendNum) {
		this.saleExpendNum = saleExpendNum;
	}
	public String getSaleExpendSum() {
		return saleExpendSum;
	}
	public void setSaleExpendSum(String saleExpendSum) {
		this.saleExpendSum = saleExpendSum;
	}
}