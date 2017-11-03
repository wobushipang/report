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
			if(StringUtils.isBlank(s.getGiftNum())) s.setGiftNum("0");
			if(StringUtils.isBlank(s.getDiscountSaleSum())) s.setDiscountSaleSum("0");
			if(StringUtils.isBlank(s.getSaleCost())) s.setSaleCost("0");
			if(StringUtils.isBlank(s.getSaleGross())) s.setSaleGross("0");
			if(StringUtils.isBlank(s.getSaleNum())) s.setSaleNum("0");
			if(StringUtils.isBlank(s.getSaleSum())) s.setSaleSum("0");
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