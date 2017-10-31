package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bqjr.report.mapper.ReportInfoMapper;
import com.bqjr.report.mapper.ReportMapper;
import com.bqjr.report.model.Option;
import com.bqjr.report.model.Organization;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.ConditionService;

@Service
public class ConditionServiceImpl implements ConditionService{

	@Autowired
	private ReportInfoMapper reportInfoMapper;
	
	@Autowired
	private ReportMapper mapper;

	// 子机构
	List<Organization> child = new ArrayList<Organization>();
	
	public List<Organization> organizationList(String pkId) {
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
	public String getOrgList(String id,String schemaName) {
		List<Organization> list = this.organizationList(id);
		List<Option> listStages=new ArrayList<Option>();
		Option d=new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for(Organization dic : list){
			Option opt=new Option();
			opt.setId(dic.getPkId());
			opt.setText(dic.getOrgName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}
	
	@Override
	public String getWarehouseList(String orgId, String schemaName) {
		List<SearchCondition> list = mapper.getWarehouseList(orgId, schemaName);
		List<Option> listStages=new ArrayList<Option>();
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getOrgId());
			opt.setText(dic.getOrgName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}
	
}
