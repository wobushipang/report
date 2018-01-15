package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bqjr.report.mapper.ReportInfoMapper;
import com.bqjr.report.model.Option;
import com.bqjr.report.model.Organization;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.ConditionService;

@Service
public class ConditionServiceImpl implements ConditionService{

	@Autowired
	private ReportInfoMapper reportInfoMapper;

	// 子机构
	List<Organization> child = new ArrayList<Organization>();
	//父机构
	List<Organization> father = new ArrayList<Organization>();
	
	public List<Organization> organizationList(String pkId) {
		child.clear();
		List<Organization> organizationsAll = reportInfoMapper.findAll();
		List<Organization> organizations = organizationListAll(organizationsAll, pkId);
		Organization org = reportInfoMapper.getOrganizationById(pkId);
		if (org != null) {
			organizations.add(org);
		}
		return organizations;
	}

	public List<Organization> organizationListAll(List<Organization> organizationList, String orgId) {
		for (Organization organization : organizationList) {
			if (orgId.equals(organization.getParentId())) {
				// 递归遍历下一级
				child.add(organization);
				organizationListAll(organizationList, organization.getPkId());
				
			}
		}
		return child;
	}
	
	public List<Organization> upOrganizationList(String pkId) {
		father.clear();
		//List<Organization> organizationsAll = reportInfoMapper.findAll();
		List<Organization> organizations = upOrganizationListAll(pkId);
		return organizations;
	}
	
	public List<Organization> upOrganizationListAll(String orgId) {
		/*for (Organization organization : organizationList) {
			if (orgId.equals(organization.getPkId())) {*/
				// 递归遍历上一级
				//organizationListAll(organizationList, organization.getParentId());
				Organization org = reportInfoMapper.getOrganizationById(orgId);
				if(org!=null) {
					father.add(org);
					upOrganizationListAll(org.getParentId());
					
				}
		/*	}
		}*/
		return father;
	}
	
	public String getOrgList(String id,String schemaName) {
		List<Organization> list = new ArrayList<Organization>();
		list = organizationList(id);
		List<Option> listStages=new ArrayList<Option>();
		Option d=new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		if(list.size()>0) {
		for(Organization dic : list){
			if(dic!=null) {
				if(StringUtils.equals("0", dic.getVirtualNode())) {
					Option opt=new Option();
					opt.setId(dic.getPkId());
					opt.setText(dic.getOrgName());
					listStages.add(opt);
				}
			}
		}
		}
		System.out.println("----------------------------"+list.size());
		return JSON.toJSONString(listStages);
	}
	
	@Override
	public String getWarehouseList(List<String> orgIds, String schemaName) {
		List<SearchCondition> list = reportInfoMapper.getWarehouseList(orgIds, schemaName);
		List<Option> listStages=new ArrayList<Option>();
		Option o=new Option();
		o.setId("0");
		o.setText("请选择");
		o.setSelected(true);
		listStages.add(o);
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getWarehouseId());
			opt.setText(dic.getWarehouseName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}
}
