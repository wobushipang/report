package com.bqjr.report.model;

import com.alibaba.fastjson.annotation.JSONField;

public class TOrgInventoryItemDetail {
	
	@JSONField(name = "schema_name")
    private String schemaName;
	
	@JSONField(name = "PK_ID")
    private String pkId;

	@JSONField(name = "inventory_item_id")
    private String inventoryItemId;

	@JSONField(name = "inventory_type")
    private String inventoryType;

	@JSONField(name = "begin_quantity")
    private String beginQuantity;

	@JSONField(name = "change_quantity")
    private String changeQuantity;

	@JSONField(name = "final_quantity")
    private String finalQuantity;

	@JSONField(name = "remarks")
    private String remarks;

	@JSONField(name = "delete_flag")
    private String deleteFlag;

	@JSONField(name = "create_time")
    private String createTime;

	@JSONField(name = "last_up_time")
    private String lastUpTime;

	@JSONField(name = "update_user_id")
    private String updateUserId;

	@JSONField(name = "create_user_id")
    private String createUserId;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    public String getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(String inventoryItemId) {
        this.inventoryItemId = inventoryItemId == null ? null : inventoryItemId.trim();
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getBeginQuantity() {
        return beginQuantity;
    }

    public void setBeginQuantity(String beginQuantity) {
        this.beginQuantity = beginQuantity;
    }

    public String getChangeQuantity() {
        return changeQuantity;
    }

    public void setChangeQuantity(String changeQuantity) {
        this.changeQuantity = changeQuantity;
    }

    public String getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(String finalQuantity) {
        this.finalQuantity = finalQuantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(String lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }
}