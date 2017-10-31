package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bqjr.report.mapper.ReportMapper;
import com.bqjr.report.model.Option;
import com.bqjr.report.model.ProxySale;
import com.bqjr.report.model.PurchaseCollect;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.PurchaseCollectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @author jialong.sun
 *
 */
@Service
public class PurchaseCollectServiceImpl implements PurchaseCollectService {

	@Autowired
	private ReportMapper mapper;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getpurchaseCollectList(int pageNum,int pageSize,SearchCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();
		 int purchaseCount=0;//采购订单数量
		 float purchaseAmount=0;//采购订单总价
		 int wareInCount=0;//入库数量
		 float wareInAmount=0;//入库金额
		 int refundsCount=0;//退货数量
		 float refundsAmount=0;
		 int exchangeInCount=0;
		 float exchangeInAmount=0;
		 int exchangeOutCount=0;
		 float exchangeOutAmount=0;
		List<String> codes = new ArrayList<String>();
		PageHelper.startPage(pageNum, pageSize);
		List<PurchaseCollect> list = mapper.getpurchaseCollectList(condition);
		for (PurchaseCollect p : list) {
			if(StringUtils.isEmpty(p.getExchangeInAmount())) p.setExchangeInAmount("0");
			if(StringUtils.isEmpty(p.getExchangeInCount())) p.setExchangeInCount("0");
			if(StringUtils.isEmpty(p.getExchangeOutAmount())) p.setExchangeOutAmount("0");
			if(StringUtils.isEmpty(p.getExchangeOutCount())) p.setExchangeOutCount("0");
			if(StringUtils.isEmpty(p.getRefundsAmount())) p.setRefundsAmount("0");
			if(StringUtils.isEmpty(p.getRefundsCount())) p.setRefundsCount("0");
			if(StringUtils.isEmpty(p.getWareInAmount())) p.setWareInAmount("0");
			if(StringUtils.isEmpty(p.getWareInCount())) p.setWareInCount("0");
			if(StringUtils.isEmpty(p.getPurchaseCount())) p.setPurchaseCount("0");
			if(StringUtils.isEmpty(p.getPurchaseAmount())) p.setPurchaseAmount("0");
			//实际采购数量
			p.setActualPurchaseCount(Integer.valueOf(p.getWareInCount())-Integer.valueOf(p.getRefundsCount())+Integer.valueOf(p.getExchangeInCount())-Integer.valueOf(p.getExchangeOutCount())+"");
			//实际采购金额
			p.setActualPurchaseAmount(Float.valueOf(p.getWareInAmount())-Float.valueOf(p.getRefundsAmount())+Float.valueOf(p.getExchangeInAmount())-Float.valueOf(p.getExchangeOutAmount())+"");
			codes.add(p.getCommodityCode());
			 
			 purchaseCount+=Integer.valueOf(p.getPurchaseCount());
			 purchaseAmount+=Float.valueOf(p.getPurchaseAmount());
			 wareInCount+=Integer.valueOf(p.getWareInCount());
			 wareInAmount+=Float.valueOf(p.getWareInAmount());
			 refundsCount+=Integer.valueOf(p.getRefundsCount());
			 refundsAmount+=Float.valueOf(p.getRefundsAmount());
			 exchangeInCount+=Integer.valueOf(p.getExchangeInCount());
			 exchangeInAmount+=Float.valueOf(p.getExchangeInAmount());
			 exchangeOutCount+=Integer.valueOf(p.getExchangeOutCount());
			 exchangeOutAmount+=Float.valueOf(p.getExchangeOutAmount());
		}
		PurchaseCollect p = new PurchaseCollect();
		p.setPurchaseCount(purchaseCount+"");
		p.setPurchaseAmount(purchaseAmount+"");
		p.setWareInCount(wareInCount+"");
		p.setWareInAmount(wareInAmount+"");
		p.setRefundsCount(refundsCount+"");
		p.setRefundsAmount(refundsAmount+"");
		p.setExchangeInCount(exchangeInCount+"");
		p.setExchangeInAmount(exchangeInAmount+"");
		p.setExchangeOutCount(exchangeOutCount+"");
		p.setExchangeOutAmount(exchangeOutAmount+"");
		if(condition.getType()==1) {
			p.setCommodityName("总计");
		}else {
			p.setSupplier("总计");
		}
		
		List<SearchCondition> specs = new ArrayList<SearchCondition>();
		if(condition.getType()==1&&codes.size()>0) {
			specs = mapper.getSpecList(codes);
		}
		for (PurchaseCollect pc : list) {
			String str="";
			for (SearchCondition s : specs) {
				if(StringUtils.equals(pc.getCommodityCode(), s.getCommodityCode())) {
					str+=s.getSpecName()+":"+s.getSpecItem()+"/";
				}
				pc.setSpec(str);
		}
		}
		PageInfo pageInfo = new PageInfo(list);
		//list.add(p);
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
		d.setText("请选择");
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
		d.setText("请选择");
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
		d.setText("请选择");
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
		Option d=new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getBrandCode());
			opt.setText(dic.getBrandName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}
	@Override
	public String getModelList(String id, String schemaName, String brandCode) {
		List<SearchCondition> list = mapper.getModelList(id, schemaName,brandCode);
		List<Option> listStages=new ArrayList<Option>();
		Option d=new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for(SearchCondition dic : list){
			Option opt=new Option();
			opt.setId(dic.getModelCode());
			opt.setText(dic.getModelName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}

}
