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
 * @FileName Organization 
 * @author wei.huang02
 * @Date 2017年10月23日 下午4:50:25 
 *****************************************************************************/
package com.bqjr.report.model;

/**
 * @ClassName Organization.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年10月23日 下午4:50:25
 * @since JDK 1.8
 */
public class Organization {
	private String pkId;
	private String parentId;
	private String orgName;
	private String virtualNode;
	public String getPkId() {
		return pkId;
	}
	public void setPkId(String pkId) {
		this.pkId = pkId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getVirtualNode() {
		return virtualNode;
	}
	public void setVirtualNode(String virtualNode) {
		this.virtualNode = virtualNode;
	}
}
