package com.bqjr.report.model;

public class InventoryWarn extends PurchaseCollect {

	private String inventoryNum;//库存量
	private String safeInventory;//安全库存
	private String unsalableDays;//滞销天数
	private String whName;//仓库名称
	private String whId;
	private String infoContent;//串号批次信息
	private String inventoryInTime;//首次入库时间
	private String infoType;
	private String quantity;//数量
	public String getInventoryNum() {
		return inventoryNum;
	}
	public void setInventoryNum(String inventoryNum) {
		this.inventoryNum = inventoryNum;
	}
	public String getSafeInventory() {
		return safeInventory;
	}
	public void setSafeInventory(String safeInventory) {
		this.safeInventory = safeInventory;
	}
	public String getUnsalableDays() {
		return unsalableDays;
	}
	public void setUnsalableDays(String unsalableDays) {
		this.unsalableDays = unsalableDays;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public String getInventoryInTime() {
		return inventoryInTime;
	}
	public void setInventoryInTime(String inventoryInTime) {
		this.inventoryInTime = inventoryInTime;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getWhId() {
		return whId;
	}
	public void setWhId(String whId) {
		this.whId = whId;
	}
	
}
