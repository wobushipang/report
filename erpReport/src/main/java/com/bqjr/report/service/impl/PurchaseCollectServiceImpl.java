package com.bqjr.report.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bqjr.report.mapper.ReportMapper;
import com.bqjr.report.model.Option;
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
	public Map<String, Object> getpurchaseCollectList(int pageNum, int pageSize, SearchCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();
		String schemaName = null;
		String orgId = null;
		List<String> codes = new ArrayList<String>();
		PageHelper.startPage(pageNum, pageSize);
		List<PurchaseCollect> list = mapper.getpurchaseCollectList(condition);
		for (PurchaseCollect p : list) {
			List<PurchaseCollect> purchaseOrder = mapper.getPurchaseOrder(condition);
			for (PurchaseCollect p1 : purchaseOrder) {
				if(condition.getType()==1) {
					if(StringUtils.equals(p.getSchemaName(), p1.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p1.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p1.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p1.getSupplierId())&&
							StringUtils.equals(p.getCommodityId(), p1.getCommodityId())){
							p.setPurchaseAmount(p1.getPurchaseAmount());
							p.setPurchaseCount(p1.getPurchaseCount());
						}
				}else if(condition.getType()==2) {
					if(StringUtils.equals(p.getSchemaName(), p1.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p1.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p1.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p1.getSupplierId())){
							p.setPurchaseAmount(p1.getPurchaseAmount());
							p.setPurchaseCount(p1.getPurchaseCount());
						}
				}
				
			}
			List<PurchaseCollect> purchaseWarehouse = mapper.getPurchaseWarehouse(condition);
			for (PurchaseCollect p2 : purchaseWarehouse) {
				if(condition.getType()==1) {
					if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p2.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p2.getSupplierId())&&
							StringUtils.equals(p.getCommodityId(), p2.getCommodityId())){
							p.setWareInAmount(p2.getWareInAmount());
							p.setWareInCount(p2.getWareInCount());
						}
				}else if(condition.getType()==2) {
					if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p2.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p2.getSupplierId())){
							p.setWareInAmount(p2.getWareInAmount());
							p.setWareInCount(p2.getWareInCount());
						}
				}
				
			}
			List<PurchaseCollect> purchaseRefunds = mapper.getPurchaseRefunds(condition);
			for (PurchaseCollect p2 : purchaseRefunds) {
				if(condition.getType()==1) {
					if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p2.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p2.getSupplierId())&&
							StringUtils.equals(p.getCommodityId(), p2.getCommodityId())){
							p.setRefundsAmount(p2.getRefundsAmount());
							p.setRefundsCount(p2.getRefundsCount());
						}
				}else if(condition.getType()==2) {
					if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p2.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p2.getSupplierId())){
							p.setRefundsAmount(p2.getRefundsAmount());
							p.setRefundsCount(p2.getRefundsCount());
						}
				}
			}
			List<PurchaseCollect> purchaseExchangeIn = mapper.getPurchaseExchangeIn(condition);
			for (PurchaseCollect p2 : purchaseExchangeIn) {
				if(condition.getType()==1) {
					if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p2.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p2.getSupplierId())&&
							StringUtils.equals(p.getCommodityId(), p2.getCommodityId())){
							p.setExchangeInAmount(p2.getExchangeInAmount());
							p.setExchangeInCount(p2.getExchangeInCount());
						}
				}else if(condition.getType()==2) {
					if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p2.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p2.getSupplierId())){
							p.setExchangeInAmount(p2.getExchangeInAmount());
							p.setExchangeInCount(p2.getExchangeInCount());
						}
				}
			}
			List<PurchaseCollect> purchaseExchangeOut = mapper.getPurchaseExchangeOut(condition);
			for (PurchaseCollect p2 : purchaseExchangeOut) {
				if(condition.getType()==1) {
					if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p2.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p2.getSupplierId())&&
							StringUtils.equals(p.getCommodityId(), p2.getCommodityId())){
							p.setExchangeOutAmount(p2.getExchangeInAmount());
							p.setExchangeOutCount(p2.getExchangeInCount());
						}
				}else if(condition.getType()==2) {
					if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
							StringUtils.equals(p.getOperationType(), p2.getOperationType())&&
							StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
							StringUtils.equals(p.getSupplierId(), p2.getSupplierId())){
							p.setExchangeOutAmount(p2.getExchangeInAmount());
							p.setExchangeOutCount(p2.getExchangeInCount());
						}
				}
			}
			
			if (StringUtils.isEmpty(p.getExchangeInAmount()))
			    p.setExchangeInAmount("0");
			   if (StringUtils.isEmpty(p.getExchangeInCount()))
			    p.setExchangeInCount("0");
			   if (StringUtils.isEmpty(p.getExchangeOutAmount()))
			    p.setExchangeOutAmount("0");
			   if (StringUtils.isEmpty(p.getExchangeOutCount()))
			    p.setExchangeOutCount("0");
			   if (StringUtils.isEmpty(p.getRefundsAmount()))
			    p.setRefundsAmount("0");
			   if (StringUtils.isEmpty(p.getRefundsCount()))
			    p.setRefundsCount("0");
			   if (StringUtils.isEmpty(p.getWareInAmount()))
			    p.setWareInAmount("0");
			   if (StringUtils.isEmpty(p.getWareInCount()))
			    p.setWareInCount("0");
			   if (StringUtils.isEmpty(p.getPurchaseCount()))
			    p.setPurchaseCount("0");
			   if (StringUtils.isEmpty(p.getPurchaseAmount()))
			    p.setPurchaseAmount("0");
			// 实际采购数量
			p.setActualPurchaseCount(Integer.valueOf(p.getWareInCount()) - Integer.valueOf(p.getRefundsCount())
					+ Integer.valueOf(p.getExchangeInCount()) - Integer.valueOf(p.getExchangeOutCount()) + "");
			// 实际采购金额
			p.setActualPurchaseAmount(new BigDecimal(p.getWareInAmount()).subtract(new BigDecimal(p.getRefundsAmount())).add(new BigDecimal(p.getExchangeInAmount())).subtract(new BigDecimal(p.getExchangeOutAmount())).toString());
			codes.add(p.getCommodityCode());
			schemaName = p.getSchemaName();
			orgId = p.getOrgId();
		}

		List<SearchCondition> specs = new ArrayList<SearchCondition>();
		if (condition.getType() == 1 && codes.size() > 0) {
			HashSet h = new HashSet(codes);
			codes.clear();
			codes.addAll(h);
			specs = mapper.getSpecList(codes, schemaName, orgId);
		}
		for (PurchaseCollect pc : list) {
			String str = "";
			for (SearchCondition s : specs) {
				if (StringUtils.equals(pc.getCommodityCode(), s.getCommodityCode())
						&& StringUtils.equals(pc.getOrgId(), s.getOrgId())) {
					str += s.getSpecName() + "：" + s.getSpecItem() + "/";
				}
				
			}
			pc.setSpec(str);
		}
		PageInfo pageInfo = new PageInfo(list);
		map.put("rows", list);
		map.put("total", pageInfo.getTotal());
		return map;
	}

	@Override
	public String getOrgList(String id, String schemaName) {
		List<SearchCondition> list = mapper.getOrgList(id, schemaName);
		List<Option> listStages = new ArrayList<Option>();
		Option d = new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for (SearchCondition dic : list) {
			Option opt = new Option();
			opt.setId(dic.getOrgId());
			opt.setText(dic.getOrgName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}

	@Override
	public String getSupplierList(List<String> strs, String schemaName) {
		if(strs.size()==0)strs=null;
		List<SearchCondition> list = mapper.getSupplierList(strs, schemaName);
		List<Option> listStages = new ArrayList<Option>();
		Option d = new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for (SearchCondition dic : list) {
			Option opt = new Option();
			opt.setId(dic.getSupplierId());
			opt.setText(dic.getSupplierName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}

	@Override
	public String getCatalogList(String id, String schemaName) {
		List<SearchCondition> list = mapper.getCatalogList(id, schemaName);
		List<Option> listStages = new ArrayList<Option>();
		Option d = new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for (SearchCondition dic : list) {
			Option opt = new Option();
			opt.setId(dic.getCatalogCode());
			opt.setText(dic.getCatalogName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}

	@Override
	public String getBrandList(String id, String schemaName, String catalogCode) {
		List<SearchCondition> list = mapper.getBrandList(id, schemaName, catalogCode);
		List<Option> listStages = new ArrayList<Option>();
		Option d = new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for (SearchCondition dic : list) {
			Option opt = new Option();
			opt.setId(dic.getBrandCode());
			opt.setText(dic.getBrandName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}

	@Override
	public String getModelList(String id, String schemaName, String brandCode) {
		if (StringUtils.equals(brandCode, "0"))
			brandCode = null;
		List<SearchCondition> list = mapper.getModelList(id, schemaName, brandCode);
		List<Option> listStages = new ArrayList<Option>();
		Option d = new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for (SearchCondition dic : list) {
			Option opt = new Option();
			opt.setId(dic.getModelCode());
			opt.setText(dic.getModelName());
			listStages.add(opt);
		}
		return JSON.toJSONString(listStages);
	}

	@Override
	public String getBusinessList(String orgId,String schemaName, String businessType) {
		if(StringUtils.equals(orgId, "") || StringUtils.equals(orgId, "0")) orgId=null;
		List<SearchCondition> list = mapper.getBusinessList(orgId,schemaName, businessType);
		List<Option> listStages = new ArrayList<Option>();
		Option d = new Option();
		d.setId("0");
		d.setText("请选择");
		d.setSelected(true);
		listStages.add(d);
		for (SearchCondition dic : list) {
			if (dic != null) {
				Option opt = new Option();
				opt.setId(dic.getBusinessId());
				opt.setText(dic.getBusinessName());
				listStages.add(opt);
			}
		}
		return JSON.toJSONString(listStages);
	}
}
