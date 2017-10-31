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
import com.bqjr.report.service.PurchaseCollectService;

@Controller
public class PurchaseCollectController {

	@Autowired
	private PurchaseCollectService service;
	@Autowired
	private ConditionService con;
	
	@RequestMapping("/purcaseCollect")
	public ModelAndView redirect(String orgId,String openId,String schemaName){
			Map<String,Object> map = new HashMap<String,Object>();
			orgId="BQJR999_G000000001";
			openId="F2500B5240E54BB2A5A0683787A85BA2";
			schemaName="bqjr_erp_0000000001";
			map.put("orgId", orgId);
			map.put("openId", openId);
			map.put("schemaName", schemaName);
			return new ModelAndView("purchaseCollect",map);
	}
	
	@RequestMapping(value="/getPurcaseCollect", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getpurcaseCollect(HttpServletRequest request,SearchCondition condition,String type){
		//分页参数
		int pageNum = 1, pageSize = 10;
		if(StringUtils.isNotBlank(request.getParameter("page"))){
			pageNum = Integer.parseInt(request.getParameter("page"));
		}
		if(StringUtils.isNotBlank(request.getParameter("rows"))){
			pageSize = Integer.parseInt(request.getParameter("rows"));
		}
		if(StringUtils.equals("0", condition.getSupplierId())) {
			condition.setSupplierId(null);
		}
		if(StringUtils.equals("0", condition.getOrgId())) {
			condition.setOrgId(condition.getOrgName());
		}
		if(StringUtils.equals("0", condition.getOperationType())) {
			condition.setOperationType(null);
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
		return service.getpurchaseCollectList(pageNum, pageSize, condition);
	}
	
	@RequestMapping("/getOrgList")
	@ResponseBody
	public String getOrgList(HttpServletRequest request){
		String orgId=request.getParameter("orgId");
		String schemaName=request.getParameter("schemaName");
		return con.getOrgList(orgId, schemaName);
	}
	
	@RequestMapping("/getSupplierList")
	@ResponseBody
	public String getSupplierList(HttpServletRequest request){
		String orgId=request.getParameter("orgId");
		String schemaName=request.getParameter("schemaName");
		if(StringUtils.equals(orgId, "0"))orgId=null;
		return service.getSupplierList(orgId, schemaName);
	}
	
	@RequestMapping("/getCatalogList")
	@ResponseBody
	public String getCatalogList(HttpServletRequest request){
		String orgId=request.getParameter("orgId");
		String schemaName=request.getParameter("schemaName");
		return service.getCatalogList(orgId, schemaName);
	}
	
	@RequestMapping("/getBrandList")
	@ResponseBody
	public String getBrandList(HttpServletRequest request){
		String orgId=request.getParameter("orgId");
		String schemaName=request.getParameter("schemaName");
		String catalogCode=request.getParameter("catalogCode");
		return service.getBrandList(orgId, schemaName,catalogCode);
	}
	
	@RequestMapping("/getModelList")
	@ResponseBody
	public String getModelList(HttpServletRequest request){
		String orgId=request.getParameter("orgId");
		String schemaName=request.getParameter("schemaName");
		String brandCode=request.getParameter("brandCode");
		return service.getModelList(orgId, schemaName,brandCode);
	}
	
	@RequestMapping("/getBusinessList")
	@ResponseBody
	public String getBusinessList(HttpServletRequest request){
		String schemaName=request.getParameter("schemaName");
		String businessType=request.getParameter("businessType");
		return service.getBusinessList(schemaName,businessType);
	}
}
