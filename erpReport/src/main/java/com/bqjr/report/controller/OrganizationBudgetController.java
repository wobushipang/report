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
 * @FileName OrganizationBudgetController 
 * @author wei.huang02
 * @Date 2017年10月30日 上午9:23:18 
 *****************************************************************************/
package com.bqjr.report.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bqjr.report.model.Organization;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.ConditionService;
import com.bqjr.report.service.OrganizationBudgetService;

/**
 * @ClassName OrganizationBudgetController.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年10月30日 上午9:23:18
 * @since JDK 1.8
 */

@Controller
public class OrganizationBudgetController {
	@Autowired
	private OrganizationBudgetService service;
	
	@Autowired
	private ConditionService con;
	
	@RequestMapping("/organizationBudget")
	public ModelAndView redirect(String orgId,String openId,String schemaName) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(orgId==null) orgId="BQJR999_G000000013";
		if(openId==null) openId="";
		if(schemaName==null) schemaName="bqjr_erp_0000000019";
		map.put("orgId", orgId);
		map.put("openId", openId);
		map.put("schemaName", schemaName);
		//map=service.getProxySaleList(1, 12, null);
		return new ModelAndView("organizationBudget",map);
	}
	
	@RequestMapping("/getOrganizationBudgetList")
	@ResponseBody
	public Map<String,Object> getInventoryWarnList(HttpServletRequest request,SearchCondition condition){
		//分页参数
				int pageNum = 1, pageSize = 15;
				if(StringUtils.isNotBlank(request.getParameter("page"))){
					pageNum = Integer.parseInt(request.getParameter("page"));
				}
				if(StringUtils.isNotBlank(request.getParameter("rows"))){
					pageSize = Integer.parseInt(request.getParameter("rows"));
				}
				if(StringUtils.equals("0", condition.getOrgId())) {
					condition.setOrgId(condition.getOrgName());
				}
				if(StringUtils.equals("0", condition.getBusinessId())) {
					condition.setBusinessId(null);
				}
				if(condition.getStartDate()!=null) {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
					String str=sdf.format(condition.getStartDate()); 
					condition.setStart(str);
				}
				if(condition.getEndDate()!=null) {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
					String str=sdf.format(condition.getEndDate()); 
					condition.setEnd(str);
				}
				List<String> strs = new ArrayList<String>();
				List<Organization> orgs=con.organizationList(condition.getOrgId());
				for (Organization organization : orgs) {
					String org=organization.getPkId();
					strs.add(org);
				}
				condition.setOrgs(strs);
		return service.getOrganizationBudgetList(pageNum, pageSize, condition);
	}
}