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
 * @Date 2017年10月23日 上午10:13:23 
 *****************************************************************************/
package com.bqjr.report.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName OrganizationBean.java
 * @Description
 * @author wei.huang02
 * @Date 2017年10月23日 上午10:13:23
 * @since JDK 1.8
 */
public class OrganizationBean implements Serializable {
	private static final long serialVersionUID = -4946811304087560046L;

	private String schemaName; // 数据库名称
	private String orgId; // 组织机构ID
	private String businessType; // 业务类型
	private String businessId; // 业务Id
	private String summaryWay; // 汇总方式
	private String beginDay; // 起始日期
	private String endDay; // 终止日期
	private List<String> list;	//机构Id集合

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

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getSummaryWay() {
		return summaryWay;
	}

	public void setSummaryWay(String summaryWay) {
		this.summaryWay = summaryWay;
	}
	
	public String getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(String beginDay) {
		this.beginDay = beginDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
}