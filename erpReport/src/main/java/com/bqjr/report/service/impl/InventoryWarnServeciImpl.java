package com.bqjr.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bqjr.report.mapper.ReportMapper;
import com.bqjr.report.model.InventoryWarn;
import com.bqjr.report.model.ProxySale;
import com.bqjr.report.model.SearchCondition;
import com.bqjr.report.service.InventoryWarnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @author jialong.sun
 *
 */
@Service
public class InventoryWarnServeciImpl implements InventoryWarnService{

	@Autowired
	private ReportMapper mapper;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getInventoryWarnList(int pageNum, int pageSize, SearchCondition condition) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<InventoryWarn> list = new ArrayList<InventoryWarn>();
		List<String> codes = new ArrayList<String>();
		PageHelper.startPage(pageNum, pageSize);
		if( condition.getType()==1) {
			list = mapper.getInventoryWarnList(condition);
		}else {
			list = mapper.getInventoryWarnList1(condition);
		}
		for (InventoryWarn i : list) {
			codes.add(i.getCommodityCode());
		}
		List<SearchCondition> specs = new ArrayList<SearchCondition>();
		if(codes.size()>0) specs = mapper.getSpecList(codes);
		for (InventoryWarn i : list) {
			String str="";
			for (SearchCondition s : specs) {
				if(StringUtils.equals(i.getCommodityCode(), s.getCommodityCode())) {
					str+=s.getSpecName()+":"+s.getSpecItem()+"/";
				}
				i.setSpec(str);
		}
		}
		PageInfo pageInfo = new PageInfo(list);
		map.put("rows", list);
		map.put("total", pageInfo.getTotal());
		return map;
	}

	@Override
	public Map<String, Object> getDetail(String schemaName, String commodityId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<InventoryWarn> list = mapper.getDetail(schemaName, commodityId);
		map.put("rows", list);
		return map;
	}
}
