package com.bqjr.report.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bqjr.report.model.Organization;

@Service
public interface ConditionService {

	public String getWarehouseList(List<String> orgIds,String schemaName);
	
	public String getOrgList(String id,String schemaName);
	
	public List<Organization> organizationList(String pkId);
	
	public List<Organization> upOrganizationList(String pkId);
}
