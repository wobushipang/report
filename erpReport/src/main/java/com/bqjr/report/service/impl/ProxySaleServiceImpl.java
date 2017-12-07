package com.bqjr.report.service.impl;

import java.math.BigDecimal;
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
		 try {
			 String schemaName=null;
			 String orgId=null;
			PageHelper.startPage(pageNum, pageSize);
			List<ProxySale> list = mapper.getProxySaleList(condition);
			List<String> codes = new ArrayList<String>();
			for (ProxySale p : list) {
				condition.setMark("0");
				List<ProxySale> proxyMarket = mapper.getMarket(condition);
				for (ProxySale p2 : proxyMarket) {
					if(condition.getType()==1) {
						if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
								StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
								StringUtils.equals(p.getSupplierId(), p2.getSupplierId())&&
								StringUtils.equals(p.getCommodityCode(), p2.getCommodityCode())){
									p.setSaleOrderNum(p2.getSaleOrderNum());
									p.setActualAmount(p2.getActualAmount());
									p.setSaleOrderAmount(p2.getSaleOrderAmount());
							}
					}else if(condition.getType()==2) {
						if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
								StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
								StringUtils.equals(p.getSupplierId(), p2.getSupplierId())){
									p.setSaleOrderNum(p2.getSaleOrderNum());
									p.setActualAmount(p2.getActualAmount());
									p.setSaleOrderAmount(p2.getSaleOrderAmount());
							}
					}
				}
				condition.setMark("1");
				List<ProxySale> proxyGift = mapper.getMarket(condition);
				for (ProxySale p2 : proxyGift) {
					if(condition.getType()==1) {
						if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
								StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
								StringUtils.equals(p.getSupplierId(), p2.getSupplierId())&&
								StringUtils.equals(p.getCommodityCode(), p2.getCommodityCode())){
									p.setGiftNum(p2.getSaleOrderNum());
							}
					}else if(condition.getType()==2) {
						if(StringUtils.equals(p.getSchemaName(), p2.getSchemaName())&&
								StringUtils.equals(p.getOrgId(), p2.getOrgId())&&
								StringUtils.equals(p.getSupplierId(), p2.getSupplierId())){
									p.setGiftNum(p2.getSaleOrderNum());
							}
					}
				}

				
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
				if(StringUtils.isEmpty(p.getExchangeSaleOutAmount())) p.setExchangeSaleOutAmount("0");
				if(StringUtils.isEmpty(p.getExchangeSaleInAmount())) p.setExchangeSaleInAmount("0");
				if(StringUtils.isEmpty(p.getExchangeSaleOutCount())) p.setExchangeSaleOutCount("0");
				if(StringUtils.isEmpty(p.getExchangeSaleInCount())) p.setExchangeSaleInCount("0");
				if(StringUtils.isEmpty(p.getExchangeGiftInCount())) p.setExchangeGiftInCount("0");
				if(StringUtils.isEmpty(p.getExchangeGiftOutCount())) p.setExchangeGiftOutCount("0");
				//进货数量
				p.setStockNum(Integer.valueOf(p.getWareInCount())-Integer.valueOf(p.getRefundsCount())+Integer.valueOf(p.getExchangeInCount())-Integer.valueOf(p.getExchangeOutCount())+"");
				//销售数量
				p.setSaleNum(Integer.valueOf(p.getSaleOrderNum())-Integer.valueOf(p.getReturnNum())+Integer.valueOf(p.getExchangeSaleOutCount())-Integer.valueOf(p.getExchangeSaleInCount())+"");
				//赠品数量
				p.setGiftNum(Integer.valueOf(p.getGiftNum())-Integer.valueOf(p.getReturnNumGift())+Integer.valueOf(p.getExchangeGiftOutCount())-Integer.valueOf(p.getExchangeGiftInCount())+"");
				//优惠后销售金额
				p.setDiscountsAmount(new BigDecimal(p.getSaleOrderAmount()).subtract(new BigDecimal(p.getReturnAmount())).add(new BigDecimal(p.getExchangeSaleOutAmount())).subtract(new BigDecimal(p.getExchangeSaleInAmount())).toString());
				if(!StringUtils.isEmpty(p.getPriceMethod())) {
					if(StringUtils.equals("1", p.getPriceMethod())) {
						p.setChargeAmount(new BigDecimal(p.getDiscountsAmount()).multiply(new BigDecimal(new BigDecimal(p.getPriceRatio()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP).toString())).toString());
					}else {
						p.setChargeAmount(new BigDecimal(p.getSaleNum()).multiply(new BigDecimal(new BigDecimal(p.getPriceRatio()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP).toString())).toString());
					}
				}
				codes.add(p.getCommodityCode());
				schemaName = p.getSchemaName();
				orgId = p.getOrgId();
			}
			
			
			List<SearchCondition> specs = new ArrayList<SearchCondition>();
			if(condition.getType()==1&&codes.size()>0) {
				specs = mapper.getSpecList(codes,schemaName,orgId);
			}
			for (ProxySale p : list) {
				String str="";
				for (SearchCondition s : specs) {
					if(StringUtils.equals(p.getCommodityCode(), s.getCommodityCode())
							&&StringUtils.equals(p.getOrgId(), s.getOrgId())) {
						str+=s.getSpecName()+":"+s.getSpecItem()+"/";
					}
					p.setSpec(str);
			}
			}
			//list.add(ps);
			PageInfo pageInfo = new PageInfo(list);
			map.put("rows", list);
			map.put("total", pageInfo.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
