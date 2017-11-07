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
 * @PackageName com.bqjr.report.mapper
 * @FileName ReportInfoMapper 
 * @author wei.huang02
 * @Date 2017年10月20日 下午2:36:09 
 *****************************************************************************/
package com.bqjr.report.mapper;

import java.util.List;

import com.bqjr.report.model.Organization;
import com.bqjr.report.model.OrganizationBudget;
import com.bqjr.report.model.SaleReturn;
import com.bqjr.report.model.SaleTotal;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.model.StockDay;

/**
 * @ClassName ReportInfoMapper.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年10月20日 下午2:36:09
 * @since JDK 1.8
 */
public interface ReportInfoMapper {
	/**
	 * 按机构统计收支情况
	 * @param organizationBean
	 * @return
	 */
	public List<OrganizationBudget> getInfoByOrganizationId(SearchCondition condition);

	/**
	 * 获取所有的机构信息
	 * @return
	 */
	public List<Organization> findAll();

	/**
	 * 根据机构Id获取机构信息
	 * @param pkId
	 * @return
	 */
	public Organization getOrganizationById(String pkId);
	
	/**
	 * 按业务类型机构的收入情况
	 * @param organizationBean
	 * @return
	 */
	public List<OrganizationBudget> getIncomeByBusinessType(SearchCondition condition);
	
	/**
	 * 按业务类型机构的支出情况
	 * @param organizationBean
	 * @return
	 */
	public List<OrganizationBudget> getExpendByBusinessType(SearchCondition condition);

	public List<StockDay> getStockDayList(SearchCondition condition);

	public List<SaleTotal> getSaleTotalList(SearchCondition condition);

	public List<SaleReturn> getSaleReturnList(SearchCondition condition);
}
