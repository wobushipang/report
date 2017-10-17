package com.bqjr.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bqjr.report.mapper.BaseUtilMapper;


@Service
public class ReceiveCsvData {
	
	private static final Logger log = LoggerFactory.getLogger(ReceiveCsvData.class);
	
	@Autowired
	private BaseUtilMapper mapper;
	
	
public Object importData(Map<String,List<List<String>>> map) {
	log.info("开始保存文件数据......");
	try {
		String tableName=null;
		List<String> headList = new ArrayList<String>();
		List<List<String>> contList = new ArrayList<List<String>>();
		Map<String,Object> mapObj = new HashMap<String,Object>();
		for(Entry<String, List<List<String>>> vo : map.entrySet()){ 
			tableName=vo.getKey();
			tableName=tableName.substring(0,tableName.indexOf("."));
			contList = vo.getValue();
			headList = contList.get(0);
			contList.remove(0);
			mapObj.put("tableName", tableName);
			mapObj.put("headlist", headList);
			mapObj.put("contentall", contList);
			mapper.batchInsertClient(mapObj);
			log.info("保存"+tableName+"文件数据成功...");
		}
	} catch (Exception e) {
		log.info("保存文件数据失败......");
		e.printStackTrace();
		return "保存失败";
	}
	
	return "保存成功";
	}

}
