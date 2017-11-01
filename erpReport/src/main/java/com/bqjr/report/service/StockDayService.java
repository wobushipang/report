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
 * @PackageName com.bqjr.report.service
 * @FileName StockDayService 
 * @author wei.huang02
 * @Date 2017年10月31日 下午7:26:34 
 *****************************************************************************/
package com.bqjr.report.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.bqjr.report.model.SearchCondition;

/**
 * @ClassName StockDayService.java
 * @Description 
 * @author wei.huang02
 * @Date 2017年10月31日 下午7:26:34
 * @since JDK 1.8
 */
@Service
public interface StockDayService {
	Map<String, Object> getStockDayList(int pageNum, int pageSize, SearchCondition condition);
}