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
 * @FileName StockDay 
 * @author wei.huang02
 * @Date 2017年11月1日 下午1:41:48 
 *****************************************************************************/
package com.bqjr.report.model;

import java.io.Serializable;

/**
 * @ClassName StockDay.java
 * @Description
 * @author wei.huang02
 * @Date 2017年11月1日 下午1:41:48
 * @since JDK 1.8
 */
public class StockDay implements Serializable {
	private static final long serialVersionUID = -8634197196156308313L;

	private String orgId;
	private String orgName;
	private String whName;// 仓库名称
	private String commodityCode;// 商品编码
	private String commodityName;// 商品名称
	private String brandName;// 品牌名称
	private String catalogName;// 分类名称
	private String modelName;// 型号
	private String spec;// 规格
	private String specName;// 规格名
	private String beginQuantity;// 期初库存数量
	private String purchaseIn; // 采购入库量
	private String purchaseReturn; // 采购退货量
	private String purchaseExpendIn; // 采购换货入库量
	private String purchaseExpendOut; // 采购换货出库量
	private String allotOut; // 调拨出库数量
	private String allotIn; // 调拨入库量
	private String profitQuantity; // 盘盈数量
	private String lossQuantity; // 盘亏数量
	private String trimQuantity; // 调整量
	private String saleOut; // 销售出库量
	private String saleReturn; // 销售退货量
	private String saleExpendOut; // 销售换货出库
	private String saleExpendIn; // 销售换货入库
	private String finalQuantity; // 期末库存量
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
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
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
	public String getBeginQuantity() {
		return beginQuantity;
	}
	public void setBeginQuantity(String beginQuantity) {
		this.beginQuantity = beginQuantity;
	}
	public String getPurchaseIn() {
		return purchaseIn;
	}
	public void setPurchaseIn(String purchaseIn) {
		this.purchaseIn = purchaseIn;
	}
	public String getPurchaseReturn() {
		return purchaseReturn;
	}
	public void setPurchaseReturn(String purchaseReturn) {
		this.purchaseReturn = purchaseReturn;
	}
	public String getPurchaseExpendIn() {
		return purchaseExpendIn;
	}
	public void setPurchaseExpendIn(String purchaseExpendIn) {
		this.purchaseExpendIn = purchaseExpendIn;
	}
	public String getPurchaseExpendOut() {
		return purchaseExpendOut;
	}
	public void setPurchaseExpendOut(String purchaseExpendOut) {
		this.purchaseExpendOut = purchaseExpendOut;
	}
	public String getAllotOut() {
		return allotOut;
	}
	public void setAllotOut(String allotOut) {
		this.allotOut = allotOut;
	}
	public String getAllotIn() {
		return allotIn;
	}
	public void setAllotIn(String allotIn) {
		this.allotIn = allotIn;
	}
	public String getProfitQuantity() {
		return profitQuantity;
	}
	public void setProfitQuantity(String profitQuantity) {
		this.profitQuantity = profitQuantity;
	}
	public String getLossQuantity() {
		return lossQuantity;
	}
	public void setLossQuantity(String lossQuantity) {
		this.lossQuantity = lossQuantity;
	}
	public String getTrimQuantity() {
		return trimQuantity;
	}
	public void setTrimQuantity(String trimQuantity) {
		this.trimQuantity = trimQuantity;
	}
	public String getSaleOut() {
		return saleOut;
	}
	public void setSaleOut(String saleOut) {
		this.saleOut = saleOut;
	}
	public String getSaleReturn() {
		return saleReturn;
	}
	public void setSaleReturn(String saleReturn) {
		this.saleReturn = saleReturn;
	}
	public String getSaleExpendOut() {
		return saleExpendOut;
	}
	public void setSaleExpendOut(String saleExpendOut) {
		this.saleExpendOut = saleExpendOut;
	}
	public String getSaleExpendIn() {
		return saleExpendIn;
	}
	public void setSaleExpendIn(String saleExpendIn) {
		this.saleExpendIn = saleExpendIn;
	}
	public String getFinalQuantity() {
		return finalQuantity;
	}
	public void setFinalQuantity(String finalQuantity) {
		this.finalQuantity = finalQuantity;
	}
}
