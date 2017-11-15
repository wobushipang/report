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
 * @FileName SaleReturn 
 * @author wei.huang02
 * @Date 2017年11月2日 下午3:26:44 
 *****************************************************************************/
package com.bqjr.report.model;

import java.io.Serializable;

/**
 * @ClassName SaleReturn.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年11月2日 下午3:26:44
 * @since JDK 1.8
 */
public class SaleReturn implements Serializable {
	private static final long serialVersionUID = -6548499114526121435L;

	private String schemaName;
	private String orgId;
	private String orgName;
	private String commodityCode;// 商品编码
	private String commodityName;// 商品名称
	private String brandName;// 品牌名称
	private String catalogName;// 分类名称
	private String modelName;// 型号
	private String spec;// 规格
	private String specName;// 规格名
	private String saleNum;// 销售数量
	private String giftNum; // 赠品数量
	private String saleSum; // 销售金额
	private String discountSaleSum; // 优惠后销售金额
	private String saleCost; // 销售成本
	private String saleGross; // 销售毛利
	private String saleOrderNum;
	private String saleOrderSum;
	private String saleOrderDiscountSum;
	private String giftSaleOrderNum;
	private String returnOrderNum;
	private String returnOrderSum;
	private String giftReturnOrderNum;
	private String saleOrderCost;
	private String returnOrderCost;
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
	public String getSaleSum() {
		return saleSum;
	}
	public void setSaleSum(String saleSum) {
		this.saleSum = saleSum;
	}
	public String getDiscountSaleSum() {
		return discountSaleSum;
	}
	public void setDiscountSaleSum(String discountSaleSum) {
		this.discountSaleSum = discountSaleSum;
	}
	public String getSaleCost() {
		return saleCost;
	}
	public void setSaleCost(String saleCost) {
		this.saleCost = saleCost;
	}
	public String getSaleGross() {
		return saleGross;
	}
	public void setSaleGross(String saleGross) {
		this.saleGross = saleGross;
	}
	public String getSaleOrderNum() {
		return saleOrderNum;
	}
	public void setSaleOrderNum(String saleOrderNum) {
		this.saleOrderNum = saleOrderNum;
	}
	public String getSaleOrderSum() {
		return saleOrderSum;
	}
	public void setSaleOrderSum(String saleOrderSum) {
		this.saleOrderSum = saleOrderSum;
	}
	public String getSaleOrderDiscountSum() {
		return saleOrderDiscountSum;
	}
	public void setSaleOrderDiscountSum(String saleOrderDiscountSum) {
		this.saleOrderDiscountSum = saleOrderDiscountSum;
	}
	public String getGiftSaleOrderNum() {
		return giftSaleOrderNum;
	}
	public void setGiftSaleOrderNum(String giftSaleOrderNum) {
		this.giftSaleOrderNum = giftSaleOrderNum;
	}
	public String getReturnOrderNum() {
		return returnOrderNum;
	}
	public void setReturnOrderNum(String returnOrderNum) {
		this.returnOrderNum = returnOrderNum;
	}
	public String getReturnOrderSum() {
		return returnOrderSum;
	}
	public void setReturnOrderSum(String returnOrderSum) {
		this.returnOrderSum = returnOrderSum;
	}
	public String getGiftReturnOrderNum() {
		return giftReturnOrderNum;
	}
	public void setGiftReturnOrderNum(String giftReturnOrderNum) {
		this.giftReturnOrderNum = giftReturnOrderNum;
	}
	public String getSaleOrderCost() {
		return saleOrderCost;
	}
	public void setSaleOrderCost(String saleOrderCost) {
		this.saleOrderCost = saleOrderCost;
	}
	public String getReturnOrderCost() {
		return returnOrderCost;
	}
	public void setReturnOrderCost(String returnOrderCost) {
		this.returnOrderCost = returnOrderCost;
	}
}