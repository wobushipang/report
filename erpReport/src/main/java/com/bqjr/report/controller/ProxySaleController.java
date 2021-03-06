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
import com.bqjr.report.service.ProxySaleService;
import com.bqjr.report.util.Constants;
/**
 * 
 * @author jialong.sun
 *
 */
@Controller
public class ProxySaleController {

	@Autowired
	private ProxySaleService service;
	@Autowired
	private ConditionService con;
	
	
	@RequestMapping("/proxySale")
	public ModelAndView redirect(String orgId,String openId,String schemaName) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(orgId==null)orgId="BQJR999_G000000019";
		if(openId==null)openId="F2500B5240E54BB2A5A0683787A85BA2";
		if(schemaName==null)schemaName="bqjr_erp_0000000019";
		map.put("orgId", orgId);
		map.put("openId", openId);
		map.put("schemaName", schemaName);
		return new ModelAndView("proxySale",map);
	}
	
	@RequestMapping(value="/getProxySale", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getProxySale(HttpServletRequest request,SearchCondition condition){
		List<String> strs = new ArrayList<String>();
		//分页参数
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
		if(condition.getStartDate()!=null) {
			SimpleDateFormat sdf=new SimpleDateFormat(Constants.DateFormat.DATE_FORMAT);  
			String str=sdf.format(condition.getStartDate()); 
			condition.setStart(str+" 00:00:00");
		}
		if(condition.getEndDate()!=null) {
			SimpleDateFormat sdf=new SimpleDateFormat(Constants.DateFormat.DATE_FORMAT);  
			String str=sdf.format(condition.getEndDate()); 
			condition.setEnd(str+" 23:59:59");
		}
		if(condition.getStartDate()!=null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			String str=sdf.format(condition.getStartDate()); 
			condition.setStart1(str);
		}
		if(condition.getEndDate()!=null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			String str=sdf.format(condition.getEndDate()); 
			condition.setEnd1(str);
		}
		
		return service.getProxySaleList(pageNum, pageSize, condition);
	}
}
