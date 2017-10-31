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
 * @FileName OrganizationBean 
 * @author wei.huang02
 * @Date 2017年10月20日 上午9:31:17 
 *****************************************************************************/
package com.bqjr.report.model;

import java.io.Serializable;

/**
 * @ClassName OrganizationBean.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年10月20日 上午9:31:17
 * @since JDK 1.8
 */
public class OrganizationBudget implements Serializable {
	private static final long serialVersionUID = -6942929988907995584L;
	private String schemaName;
	private String orgName;
	private String businessType;
	private String businessName;
	private String money;
	private String income;
	private String expend;
	
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getExpend() {
		return expend;
	}
	public void setExpend(String expend) {
		this.expend = expend;
	}
}