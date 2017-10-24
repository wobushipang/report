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
 * @PackageName com.bqjr.report.controller
 * @FileName ReportInfoController 
 * @author wei.huang02
 * @Date 2017年10月23日 下午2:53:19 
 *****************************************************************************/
package com.bqjr.report.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bqjr.report.mapper.ReportInfoMapper;
import com.bqjr.report.model.Organization;
import com.bqjr.report.model.OrganizationBean;
import com.bqjr.report.model.OrganizationVo;

/**
 * @ClassName ReportInfoController.java
 * @Description
 * @author wei.huang02
 * @Date 2017年10月23日 下午2:53:19
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "/report")
public class ReportInfoController {

	@Autowired
	private ReportInfoMapper reportInfoMapper;

	// 子机构
	List<Organization> child = new ArrayList<Organization>();

	@RequestMapping(value = "/organization/businessType", method = RequestMethod.GET)
	@ResponseBody
	public String organizationByBusinessType(OrganizationBean organizationBean) {
		List<Organization> organizations = organizationList("BQJR999_G000000001_R0005");
		List<String> pkIds = new ArrayList<String>();
		for (Organization organization : organizations) {
			pkIds.add(organization.getPkId());
		}
//		List<String> pkIds = new ArrayList<String>();
//		pkIds.add("BQJR999_G000000001_R0005");
		organizationBean.setList(pkIds);
		organizationBean.setBeginDay("2017/05/01 00:00:00");
		organizationBean.setEndDay("2017/05/04 00:00:00");
		List<OrganizationVo> organizationVos = reportInfoMapper.getIncomeByBusinessType(organizationBean);
		for (OrganizationVo organizationVo : organizationVos) {
			System.out.println(organizationVo.getOrgName()+"==>"+organizationVo.getIncome()+"==>"+organizationVo.getBusinessType());
		}
		return "organization_budget";
	}

	private List<Organization> organizationList(String pkId) {
		child.clear();
		List<Organization> organizationsAll = reportInfoMapper.findAll();
		List<Organization> organizations = organizationListAll(organizationsAll, pkId);
		Organization org = reportInfoMapper.getOrganizationById(pkId);
		organizations.add(org);
		return organizations;
	}

	public List<Organization> organizationListAll(List<Organization> organizationList, String orgId) {
		for (Organization organization : organizationList) {
			if (orgId.equals(organization.getParentId())) {
				// 递归遍历下一级
				organizationListAll(organizationList, organization.getPkId());
				child.add(organization);
			}
		}
		return child;
	}
}