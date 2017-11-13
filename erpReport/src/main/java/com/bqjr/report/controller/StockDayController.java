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
 * @FileName StockDayController 
 * @author wei.huang02
 * @Date 2017年10月31日 下午7:25:06 
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bqjr.report.model.Organization;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.ConditionService;
import com.bqjr.report.service.StockDayService;

/**
 * @ClassName StockDayController.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年10月31日 下午7:25:06
 * @since JDK 1.8
 */
@Controller
public class StockDayController {
	@Autowired
	private StockDayService service;
	
	@Autowired
	private ConditionService con;
	
	@RequestMapping("/stockDay")
	public ModelAndView redirect(String orgId,String openId,String schemaName){
			Map<String,Object> map = new HashMap<String,Object>();
			if(orgId==null)orgId="BQJR999_G000000013";
			if(openId==null)openId="F2500B5240E54BB2A5A0683787A85BA2";
			if(schemaName==null)schemaName="bqjr_erp_0000000019";
			map.put("orgId", orgId);
			map.put("openId", openId);
			map.put("schemaName", schemaName);
			return new ModelAndView("stock_day",map);
	}
	
	@RequestMapping(value="/getStockDay", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getStockDayList(HttpServletRequest request,SearchCondition condition,String type){
		//分页参数
		int pageNum = 1, pageSize = 10;
		if(StringUtils.isNotBlank(request.getParameter("page"))){
			pageNum = Integer.parseInt(request.getParameter("page"));
		}
		if(StringUtils.isNotBlank(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		if(StringUtils.equals("0", condition.getOrgId())) {
			condition.setOrgId(condition.getOrgName());
		}
		if(StringUtils.equals("0", condition.getWarehouseName())) {
			condition.setWarehouseName(null);
		}
		if(StringUtils.equals("0", condition.getCatalogName())) {
			condition.setCatalogName(null);
		}
		if(StringUtils.equals("0", condition.getBrandName())) {
			condition.setBrandName(null);
		}
		if(StringUtils.equals("0", condition.getModelName())) {
			condition.setModelName(null);
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
		return service.getStockDayList(pageNum, pageSize, condition);
	}
}