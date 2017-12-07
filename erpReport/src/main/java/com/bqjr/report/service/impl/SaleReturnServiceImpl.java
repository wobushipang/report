/******************************************************************************
 * Copyright (C) 2010-2020 Billions Finance. All Rights Reserved.
 * ============================================================================
 * 版权所有 2010-2020 佰仟金融服务有限公司，并保留所有权利
 * ----------------------------------------------------------------------------
 * 这不是一个自由软件！您不能在任何未经允许的前提下对程序代码进行修改和使用；不允许
 * 对程序代码以任何形式任何目的的再发布
 * ============================================================================
 *
 * @ProjectName erp
 * @PackageName com.bqjr.report.service.impl
 * @FileName SaleReturnServiceImpl 
 * @author wei.huang02
 * @Date 2017年11月2日 下午2:17:09 
 *****************************************************************************/
package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bqjr.report.mapper.ReportInfoMapper;
import com.bqjr.report.mapper.ReportMapper;
import com.bqjr.report.model.SaleReturn;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.SaleReturnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName SaleReturnServiceImpl.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年11月2日 下午2:17:09
 * @since JDK 1.8
 */
@Service
public class SaleReturnServiceImpl implements SaleReturnService {

	@Autowired
	private ReportInfoMapper mapper;
	
	@Autowired
	private ReportMapper mapper1;
	
	@Override
	public Map<String, Object> getSaleReturnList(int pageNum, int pageSize, SearchCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> codes = new ArrayList<String>();
		List<SaleReturn> list = new ArrayList<SaleReturn>();
		PageHelper.startPage(pageNum, pageSize);
		list = mapper.getSaleReturnList(condition);
		for (SaleReturn s : list) {
			if(StringUtils.isBlank(s.getSaleOrderNum())) s.setSaleOrderNum("0");
			if(StringUtils.isBlank(s.getReturnOrderNum())) s.setReturnOrderNum("0");
			if(StringUtils.isBlank(s.getGiftReturnOrderNum())) s.setGiftReturnOrderNum("0");
			if(StringUtils.isBlank(s.getGiftSaleOrderNum())) s.setGiftSaleOrderNum("0");
			if(StringUtils.isBlank(s.getSaleOrderSum())) s.setSaleOrderSum("0");
			if(StringUtils.isBlank(s.getSaleOrderDiscountSum())) s.setSaleOrderDiscountSum("0");
			if(StringUtils.isBlank(s.getReturnOrderNum())) s.setReturnOrderNum("0");
			if(StringUtils.isBlank(s.getReturnOrderSum())) s.setReturnOrderSum("0");
			if(StringUtils.isBlank(s.getAllCost())) s.setAllCost("0");
			if(StringUtils.isBlank(s.getReturnCost())) s.setReturnCost("0");
			s.setSaleNum(Integer.valueOf(s.getSaleOrderNum())-Integer.valueOf(s.getReturnOrderNum())+"");
			s.setGiftNum(Integer.valueOf(s.getGiftSaleOrderNum())-Integer.valueOf(s.getGiftReturnOrderNum())+"");
			s.setSaleSum(Double.valueOf(s.getSaleOrderSum())-Double.valueOf(s.getReturnOrderSum())+"");
			//s.setDiscountSaleSum(Double.valueOf(s.getSaleOrderDiscountSum())-Double.valueOf(s.getReturnOrderSum())+"");
			s.setSaleCost(Double.valueOf(s.getAllCost())-Double.valueOf(s.getReturnCost())+"");
			s.setSaleGross(Double.valueOf(s.getSaleSum())-Double.valueOf(s.getSaleCost())+"");
			codes.add(s.getCommodityCode());
		}
		List<SearchCondition> specs = new ArrayList<SearchCondition>();
		if(codes.size()>0) {
			HashSet<String> h = new HashSet<String>(codes);      
			codes.clear();
			codes.addAll(h);
			specs = mapper1.getSpecList(codes,condition.getSchemaName(),"");
		}
		for (SaleReturn sd : list) {
			String str="";
			for (SearchCondition s : specs) {
				if(StringUtils.equals(sd.getCommodityCode(), s.getCommodityCode())&&StringUtils.equals(sd.getOrgId(), s.getOrgId())) {
					str+=s.getSpecName()+":"+s.getSpecItem()+"/";
				}
				sd.setSpec(str);
			}
		}
		PageInfo<SaleReturn> pageInfo = new PageInfo<SaleReturn>(list);
		map.put("rows", list);
		map.put("total", pageInfo.getTotal());
		return map;
	}
}