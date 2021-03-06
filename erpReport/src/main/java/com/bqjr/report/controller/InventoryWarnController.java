package com.bqjr.report.controller;

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
import com.bqjr.report.service.InventoryWarnService;

@Controller
public class InventoryWarnController {

	@Autowired
	private InventoryWarnService service;
	
	@Autowired
	private ConditionService con;
	
	@RequestMapping("/inventoryWarn")
	public ModelAndView redirect(String orgId,String openId,String schemaName) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(orgId==null)orgId="BQJR999_G000000009";
		if(openId==null)openId="F2500B5240E54BB2A5A0683787A85BA2";
		if(schemaName==null)schemaName="bqjr_erp_0000000009";
		map.put("orgId", orgId);
		map.put("openId", openId);
		map.put("schemaName", schemaName);
		//map=service.getProxySaleList(1, 12, null);
		return new ModelAndView("inventoryWarn",map);
	}
	
	@RequestMapping("/getInventoryWarnList")
	@ResponseBody
	public Map<String,Object> getInventoryWarnList(HttpServletRequest request,SearchCondition condition){
		//分页参数
				List<String> strs = new ArrayList<String>();
				int pageNum = 1, pageSize = 15;
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
					condition.setOrgId(null);
					List<Organization> orgs=con.organizationList(condition.getOrgName());
					for (Organization organization : orgs) {
						String org=organization.getPkId();
						strs.add(org);
					}
					condition.setOrgs(strs);
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
				if(StringUtils.equals("0", condition.getWarehouseId())) {
					condition.setWarehouseId(null);
				}
		return service.getInventoryWarnList(pageNum, pageSize, condition);
	}
	
	@RequestMapping("/getDetail")
	@ResponseBody
	public Map<String,Object>getDetail(HttpServletRequest request){
		String commodityId=request.getParameter("commodityId");
		String schemaName=request.getParameter("schemaName");
		String whId=request.getParameter("whId");
		String type= request.getParameter("type");
		String unsalableDays= request.getParameter("unsalableDays");
		String supplierId= request.getParameter("supplierId");
		//commodityId="31704B663E244562BD019C2795669DD9";
		return service.getDetail(schemaName, commodityId,whId,type,unsalableDays,supplierId);
	}
	
//	@RequestMapping("/getWarehouseList")
//	@ResponseBody
//	public String getWarehouseList(HttpServletRequest request) {
//		String orgId=request.getParameter("orgId");
//		if(StringUtils.equals("0", orgId)) {
//			orgId=null;
//		}
//		String schemaName=request.getParameter("schemaName");
//		return con.getWarehouseList(orgId, schemaName);
//	}
}
