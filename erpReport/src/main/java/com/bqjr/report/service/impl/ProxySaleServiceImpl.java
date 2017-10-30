package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bqjr.report.mapper.ReportMapper;
import com.bqjr.report.model.ProxySale;
import com.bqjr.report.model.PurchaseCollect;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.ProxySaleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProxySaleServiceImpl implements ProxySaleService {

	@Autowired
	private ReportMapper mapper;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getProxySaleList(int pageNum, int pageSize, SearchCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum, pageSize);
		List<ProxySale> list = mapper.getProxySaleList(condition);
		List<String> codes = new ArrayList<String>();
		for (ProxySale p : list) {
			if(StringUtils.isEmpty(p.getAccountAmount())) p.setAccountAmount("0");
			if(StringUtils.isEmpty(p.getActualAmount())) p.setActualAmount("0");
			if(StringUtils.isEmpty(p.getChargeAmount())) p.setChargeAmount("0");
			if(StringUtils.isEmpty(p.getDiscountsAmount())) p.setDiscountsAmount("0");
			if(StringUtils.isEmpty(p.getExchangeInAmount())) p.setExchangeInAmount("0");
			if(StringUtils.isEmpty(p.getExchangeInCount())) p.setExchangeInCount("0");
			if(StringUtils.isEmpty(p.getExchangeOutAmount())) p.setExchangeOutAmount("0");
			if(StringUtils.isEmpty(p.getExchangeOutCount())) p.setExchangeOutCount("0");
			if(StringUtils.isEmpty(p.getGiftNum())) p.setGiftNum("0");
			if(StringUtils.isEmpty(p.getInventoryNum())) p.setInventoryNum("0");
			if(StringUtils.isEmpty(p.getProceedsAmount())) p.setProceedsAmount("0");
			if(StringUtils.isEmpty(p.getRefundsAmount())) p.setRefundsAmount("0");
			if(StringUtils.isEmpty(p.getRefundsCount())) p.setRefundsCount("0");
			if(StringUtils.isEmpty(p.getReturnAmount())) p.setReturnAmount("0");
			if(StringUtils.isEmpty(p.getReturnNum())) p.setReturnNum("0");
			if(StringUtils.isEmpty(p.getReturnNumGift())) p.setReturnNumGift("0");
			if(StringUtils.isEmpty(p.getSaleAmount())) p.setSaleAmount("0");
			if(StringUtils.isEmpty(p.getSaleNum())) p.setSaleNum("0");
			if(StringUtils.isEmpty(p.getSaleOrderAmount())) p.setSaleOrderAmount("0");
			if(StringUtils.isEmpty(p.getStockNum())) p.setStockNum("0");
			if(StringUtils.isEmpty(p.getWareInAmount())) p.setWareInAmount("0");
			if(StringUtils.isEmpty(p.getWareInCount())) p.setWareInCount("0");
			if(StringUtils.isEmpty(p.getSaleOrderNum())) p.setSaleOrderNum("0");
			if(StringUtils.isEmpty(p.getSaleGiftNum())) p.setSaleGiftNum("0");
			//进货数量
			p.setStockNum(Integer.valueOf(p.getWareInCount())-Integer.valueOf(p.getRefundsCount())+Integer.valueOf(p.getExchangeInCount())-Integer.valueOf(p.getExchangeOutCount())+"");
			//销售数量
			p.setSaleNum(Integer.valueOf(p.getSaleOrderNum())-Integer.valueOf(p.getReturnNum())+"");
			//赠品数量
			p.setGiftNum(Integer.valueOf(p.getSaleGiftNum())-Integer.valueOf(p.getReturnNumGift())+"");
			//优惠后销售金额
			p.setDiscountsAmount(Double.valueOf(p.getActualAmount())-Double.valueOf(p.getReturnNum())+"");
			if(StringUtils.isEmpty(p.getPriceMethod())) {
				if(p.getPriceMethod()=="1") {
					p.setChargeAmount(Double.valueOf(p.getDiscountsAmount())*Double.valueOf(p.getPriceRatio())+"");
				}else {
					p.setChargeAmount(Double.valueOf(p.getSaleOrderAmount())-Double.valueOf(p.getReturnAmount())+"");
				}
			}
			codes.add(p.getCommodityCode());
			
		}
		List<SearchCondition> specs = new ArrayList<SearchCondition>();
		if(condition.getType()==1&&codes.size()>0) {
			specs = mapper.getSpecList(codes);
		}
		for (ProxySale p : list) {
			String str="";
			for (SearchCondition s : specs) {
				if(StringUtils.equals(p.getCommodityCode(), s.getCommodityCode())) {
					str+=s.getSpecName()+":"+s.getSpecItem()+"/";
				}
				p.setSpec(str);
		}
		}
		PageInfo pageInfo = new PageInfo(list);
		map.put("rows", list);
		map.put("total", pageInfo.getTotal());
		return map;
	}

}
