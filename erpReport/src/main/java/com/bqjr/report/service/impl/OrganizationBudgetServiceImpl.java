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
 * @PackageName com.bqjr.report.service.impl
 * @FileName OrganizationBudgetServiceImpl 
 * @author wei.huang02
 * @Date 2017年10月30日 上午9:25:08 
 *****************************************************************************/
package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bqjr.report.mapper.ReportInfoMapper;
import com.bqjr.report.model.OrganizationBudget;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.OrganizationBudgetService;
import com.github.pagehelper.PageHelper;

/**
 * @ClassName OrganizationBudgetServiceImpl.java
 * @Description
 * @author wei.huang02
 * @Date 2017年10月30日 上午9:25:08
 * @since JDK 1.8
 */
@Service
public class OrganizationBudgetServiceImpl implements OrganizationBudgetService {
	@Autowired
	private ReportInfoMapper mapper;

	@Override
	public Map<String, Object> getOrganizationBudgetList(int pageNum, int pageSize, SearchCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OrganizationBudget> list = new ArrayList<OrganizationBudget>();
		PageHelper.startPage(pageNum, pageSize);
		if (condition.getType() == 1) {
			if (StringUtils.equals("1", condition.getBusinessType())) {
				list = mapper.getIncomeByBusinessType(condition);
			} else if (StringUtils.equals("2", condition.getBusinessType())) {
				list = mapper.getExpendByBusinessType(condition);
			} else if (StringUtils.equals("0", condition.getBusinessType())) {
				list = mapper.getIncomeByBusinessType(condition);
				list.addAll(mapper.getExpendByBusinessType(condition));
			}
		} else {
			list = mapper.getInfoByOrganizationId(condition);
		}
		for (OrganizationBudget o : list) {
			if (StringUtils.isBlank(o.getMoney()))
				o.setMoney("0");
			if (StringUtils.isBlank(o.getIncome()))
				o.setIncome("0");
			if (StringUtils.isBlank(o.getExpend()))
				o.setExpend("0");
		}
		//PageInfo<OrganizationBudget> pageInfo = new PageInfo<OrganizationBudget>(list);
		map.put("rows", list);
		map.put("total", list.size());
		return map;
	}
}
