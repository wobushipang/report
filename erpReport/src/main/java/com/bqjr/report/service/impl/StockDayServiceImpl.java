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
 * @FileName StockDayServiceImpl 
 * @author wei.huang02
 * @Date 2017年10月31日 下午7:28:41 
 *****************************************************************************/
package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bqjr.report.mapper.ReportInfoMapper;
import com.bqjr.report.mapper.ReportMapper;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.model.StockDay;
import com.bqjr.report.service.StockDayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName StockDayServiceImpl.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年10月31日 下午7:28:41
 * @since JDK 1.8
 */
@Service
public class StockDayServiceImpl implements StockDayService {
	
	@Autowired
	private ReportInfoMapper mapper;
	
	@Autowired
	private ReportMapper mapper1;

	@Override
	public Map<String, Object> getStockDayList(int pageNum, int pageSize, SearchCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> codes = new ArrayList<String>();
		PageHelper.startPage(pageNum, pageSize);
		List<StockDay> list = new ArrayList<>();
		try {
			list = mapper.getStockDayList(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (StockDay s : list) {
			if(StringUtils.isBlank(s.getAllotIn())) s.setAllotIn("0");
			if(StringUtils.isBlank(s.getAllotOut())) s.setAllotOut("0");
			if(StringUtils.isBlank(s.getBeginQuantity())) s.setBeginQuantity("0");
			if(StringUtils.isBlank(s.getFinalQuantity())) s.setFinalQuantity("0");
			if(StringUtils.isBlank(s.getLossQuantity())) s.setLossQuantity("0");
			if(StringUtils.isBlank(s.getProfitQuantity())) s.setProfitQuantity("0");
			if(StringUtils.isBlank(s.getPurchaseExpendIn())) s.setPurchaseExpendIn("0");
			if(StringUtils.isBlank(s.getPurchaseExpendOut())) s.setPurchaseExpendOut("0");
			if(StringUtils.isBlank(s.getPurchaseIn())) s.setPurchaseIn("0");
			if(StringUtils.isBlank(s.getPurchaseReturn())) s.setPurchaseReturn("0");
			if(StringUtils.isBlank(s.getSaleExpendIn())) s.setSaleExpendIn("0");
			if(StringUtils.isBlank(s.getSaleExpendOut())) s.setSaleExpendOut("0");
			if(StringUtils.isBlank(s.getSaleOut())) s.setSaleOut("0");
			if(StringUtils.isBlank(s.getSaleReturn())) s.setSaleReturn("0");
			if(StringUtils.isBlank(s.getTrimQuantity())) s.setTrimQuantity("0");
			codes.add(s.getCommodityCode());
		}
		List<SearchCondition> specs = new ArrayList<SearchCondition>();
		if(codes.size()>0) {
			//specs = mapper1.getSpecList(codes);
		}
		for (StockDay sd : list) {
			String str="";
			for (SearchCondition s : specs) {
				if(StringUtils.equals(sd.getCommodityCode(), s.getCommodityCode())) {
					str+=s.getSpecName()+":"+s.getSpecItem()+"/";
				}
				sd.setSpec(str);
			}
		}
		PageInfo<StockDay> pageInfo = new PageInfo<StockDay>(list);
		map.put("rows", list);
		map.put("total", pageInfo.getTotal());
		return map;
	}
}