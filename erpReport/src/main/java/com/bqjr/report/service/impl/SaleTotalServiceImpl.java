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
 * @FileName SaleTotalServiceImpl 
 * @author wei.huang02
 * @Date 2017年11月1日 下午6:34:08 
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
import com.bqjr.report.model.SaleTotal;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.SaleTotalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName SaleTotalServiceImpl.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年11月1日 下午6:34:08
 * @since JDK 1.8
 */
@Service
public class SaleTotalServiceImpl implements SaleTotalService {

	@Autowired
	private ReportInfoMapper mapper;
	
	@Autowired
	private ReportMapper mapper1;
	
	@Override
	public Map<String, Object> getSaleTotalList(int pageNum, int pageSize, SearchCondition condition) {
 		Map<String, Object> map = new HashMap<String, Object>();
		List<String> codes = new ArrayList<String>();
		List<SaleTotal> list = new ArrayList<>();	
		PageHelper.startPage(pageNum, pageSize);
		list = mapper.getSaleTotalList(condition);
		for (SaleTotal s : list) {
			if(StringUtils.isBlank(s.getGiftSaleNum())) s.setGiftSaleNum("0");
			if(StringUtils.isBlank(s.getGiftReturnNum())) s.setGiftReturnNum("0");
			if(StringUtils.isBlank(s.getOrderSaleNum())) s.setOrderSaleNum("0");
			if(StringUtils.isBlank(s.getOrderSaleSum())) s.setOrderSaleSum("0");
			if(StringUtils.isBlank(s.getReturnNum())) s.setReturnNum("0");
			if(StringUtils.isBlank(s.getReturnSum())) s.setReturnSum("0");
			if(StringUtils.isBlank(s.getSaleExpendNum())) s.setSaleExpendNum("0");
			if(StringUtils.isBlank(s.getSaleExpendSum())) s.setSaleExpendSum("0");
			if(StringUtils.isBlank(s.getSaleReturnNum())) s.setSaleReturnNum("0");
			if(StringUtils.isBlank(s.getSaleReturnSum())) s.setSaleReturnSum("0");
			s.setSaleNum(Integer.valueOf(s.getOrderSaleNum())-Integer.valueOf(s.getReturnNum())-Integer.valueOf(s.getSaleReturnNum())+Integer.valueOf(s.getSaleExpendNum())+"");
			s.setGiftNum(Integer.valueOf(s.getGiftSaleNum())-Integer.valueOf(s.getGiftReturnNum())+"");
			codes.add(s.getCommodityCode());
		}
		List<SearchCondition> specs = new ArrayList<SearchCondition>();
		if(codes.size()>0) {
			HashSet<String> h = new HashSet<String>(codes);      
			codes.clear();
			codes.addAll(h);
			specs = mapper1.getSpecList(codes,condition.getSchemaName(),"");
		}
		for (SaleTotal sd : list) {
			String str="";
			for (SearchCondition s : specs) {
				if(StringUtils.equals(sd.getCommodityCode(), s.getCommodityCode())&&StringUtils.equals(sd.getOrgId(), s.getOrgId())) {
					str+=s.getSpecName()+":"+s.getSpecItem()+"/";
				}
				sd.setSpec(str);
			}
		}
		PageInfo<SaleTotal> pageInfo = new PageInfo<SaleTotal>(list);
		map.put("rows", list);
		map.put("total", pageInfo.getTotal());
		return map;
	}
}