package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bqjr.report.mapper.ReportMapper;
import com.bqjr.report.model.Option;
import com.bqjr.report.model.PurchaseCollect;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.PurchaseCollectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PurchaseCollectServiceImpl implements PurchaseCollectService {

	@Autowired
	private ReportMapper mapper;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getpurchaseCollectList(int pageNum,int pageSize,SearchCondition condition) {
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		List<PurchaseCollect> list = mapper.getpurchaseCollectList(condition);
		PageInfo pageInfo = new PageInfo(list);
		map.put("rows", list);
		map.put("total", pageInfo.getTotal());
		return map;
	}
	@Override
	public String getOrgList(String id,String schemaName) {
		List<SearchCondition> list = mapper.getOrgList(id, schemaName);
		List<Option> listStages=new ArrayList<Option>();
		Option d=new Option();
		d.setId("0");
		d.setText("==请选择==");
		d.setSelected(true);
		listStages.add(d);
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getOrgId());
			opt.setText(dic.getOrgName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}
	@Override
	public String getSupplierList(String id, String schemaName) {
		List<SearchCondition> list = mapper.getSupplierList(id, schemaName);
		List<Option> listStages=new ArrayList<Option>();
		Option d=new Option();
		d.setId("0");
		d.setText("==请选择==");
		d.setSelected(true);
		listStages.add(d);
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getSupplierId());
			opt.setText(dic.getSupplierName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}
	@Override
	public String getCatalogList(String id, String schemaName) {
		List<SearchCondition> list = mapper.getCatalogList(id, schemaName);
		List<Option> listStages=new ArrayList<Option>();
		Option d=new Option();
		d.setId("0");
		d.setText("==请选择==");
		d.setSelected(true);
		listStages.add(d);
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getCatalogCode());
			opt.setText(dic.getCatalogName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}
	@Override
	public String getBrandList(String id, String schemaName, String catalogCode) {
		List<SearchCondition> list = mapper.getBrandList(id, schemaName,catalogCode);
		List<Option> listStages=new ArrayList<Option>();
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getBrandCode());
			opt.setText(dic.getBrandName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}
	@Override
	public String getModelList(String id, String schemaName, String modelCode) {
		List<SearchCondition> list = mapper.getModelList(id, schemaName,modelCode);
		List<Option> listStages=new ArrayList<Option>();
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getModelCode());
			opt.setText(dic.getModelName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}

}
