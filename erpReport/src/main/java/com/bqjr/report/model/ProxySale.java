package com.bqjr.report.model;
/**
 * 代销汇总
 * @author jialong.sun
 *
 */
public class ProxySale extends PurchaseCollect{

	
	private String stockNum;//进货数量
	private String saleNum;//销售数量
	private String saleOrderNum;//销售订单数量
	private String saleGiftNum;//销售订单数量（赠品）
	private String giftNum;//赠品数量
	private String returnNum;//退货数量
	private String returnNumGift;//赠品退货数量
	private String inventoryNum;//库存数量
	private String discountsAmount;//优惠后销售金额
	private String actualAmount;//实际金额
	private String returnAmount;//退货数量*单价
	private String saleOrderAmount;//销售订单数量*单价
	private String exchangeSaleInAmount;//退货换货金额
	private String exchangeSaleOutAmount;//销售换货金额
	private String exchangeSaleOutCount;
	private String exchangeSaleInCount;
	private String exchangeGiftOutCount;
	private String exchangeGiftInCount;
	private String saleAmount;//销售金额
	private String chargeAmount;//应计收费金额
	private String accountAmount;//生成结算金额
	private String proceedsAmount;//已收款金额
	
	private String priceMethod;//计价方式
	private String priceRatio;//计价比率
	public String getStockNum() {
		return stockNum;
	}
	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
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
	public String getInventoryNum() {
		return inventoryNum;
	}
	public void setInventoryNum(String inventoryNum) {
		this.inventoryNum = inventoryNum;
	}
	public String getDiscountsAmount() {
		return discountsAmount;
	}
	public void setDiscountsAmount(String discountsAmount) {
		this.discountsAmount = discountsAmount;
	}
	public String getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
	public String getReturnAmount() {
		return returnAmount;
	}
	public void setReturnAmount(String returnAmount) {
		this.returnAmount = returnAmount;
	}
	public String getSaleOrderAmount() {
		return saleOrderAmount;
	}
	public void setSaleOrderAmount(String saleOrderAmount) {
		this.saleOrderAmount = saleOrderAmount;
	}
	public String getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(String saleAmount) {
		this.saleAmount = saleAmount;
	}
	public String getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(String chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	public String getAccountAmount() {
		return accountAmount;
	}
	public void setAccountAmount(String accountAmount) {
		this.accountAmount = accountAmount;
	}
	public String getProceedsAmount() {
		return proceedsAmount;
	}
	public void setProceedsAmount(String proceedsAmount) {
		this.proceedsAmount = proceedsAmount;
	}
	public String getReturnNum() {
		return returnNum;
	}
	public void setReturnNum(String returnNum) {
		this.returnNum = returnNum;
	}
	public String getReturnNumGift() {
		return returnNumGift;
	}
	public void setReturnNumGift(String returnNumGift) {
		this.returnNumGift = returnNumGift;
	}
	public String getSaleOrderNum() {
		return saleOrderNum;
	}
	public void setSaleOrderNum(String saleOrderNum) {
		this.saleOrderNum = saleOrderNum;
	}
	public String getSaleGiftNum() {
		return saleGiftNum;
	}
	public void setSaleGiftNum(String saleGiftNum) {
		this.saleGiftNum = saleGiftNum;
	}
	public String getPriceMethod() {
		return priceMethod;
	}
	public void setPriceMethod(String priceMethod) {
		this.priceMethod = priceMethod;
	}
	public String getPriceRatio() {
		return priceRatio;
	}
	public void setPriceRatio(String priceRatio) {
		this.priceRatio = priceRatio;
	}
	public String getExchangeSaleInAmount() {
		return exchangeSaleInAmount;
	}
	public void setExchangeSaleInAmount(String exchangeSaleInAmount) {
		this.exchangeSaleInAmount = exchangeSaleInAmount;
	}
	public String getExchangeSaleOutAmount() {
		return exchangeSaleOutAmount;
	}
	public void setExchangeSaleOutAmount(String exchangeSaleOutAmount) {
		this.exchangeSaleOutAmount = exchangeSaleOutAmount;
	}
	public String getExchangeSaleOutCount() {
		return exchangeSaleOutCount;
	}
	public void setExchangeSaleOutCount(String exchangeSaleOutCount) {
		this.exchangeSaleOutCount = exchangeSaleOutCount;
	}
	public String getExchangeSaleInCount() {
		return exchangeSaleInCount;
	}
	public void setExchangeSaleInCount(String exchangeSaleInCount) {
		this.exchangeSaleInCount = exchangeSaleInCount;
	}
	public String getExchangeGiftOutCount() {
		return exchangeGiftOutCount;
	}
	public void setExchangeGiftOutCount(String exchangeGiftOutCount) {
		this.exchangeGiftOutCount = exchangeGiftOutCount;
	}
	public String getExchangeGiftInCount() {
		return exchangeGiftInCount;
	}
	public void setExchangeGiftInCount(String exchangeGiftInCount) {
		this.exchangeGiftInCount = exchangeGiftInCount;
	}
	
	
}
