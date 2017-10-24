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
	String tableName=null;
	try {
		
		List<String> headList = new ArrayList<String>();
		List<List<String>> contList = new ArrayList<List<String>>();
		List<List<String>> batchContList = new ArrayList<List<String>>();
		List<String> idList = new ArrayList<String>();
		Map<String,Object> mapObj = new HashMap<String,Object>();
		for(Entry<String, List<List<String>>> vo : map.entrySet()){ 
			tableName=vo.getKey();
			tableName=tableName.substring(6,tableName.indexOf("."));
			if(tableName.length()>30) {
				tableName=tableName.substring(tableName.length()-30);
				if("_"==tableName.substring(0, 1)) {
					tableName=tableName.substring(1, tableName.length());
				}
			}
			int count = mapper.tableExist(tableName.toUpperCase());
			if(count>0) {
				contList = vo.getValue();
				headList = contList.get(0);
				int idIndex = headList.indexOf("pk_id");
				contList.remove(0);
				
				mapObj.put("tableName", tableName);
				mapObj.put("headlist", headList);
				int subSize = 1000;
				int listSize = contList.size();
				for (int i = 0; i < listSize;) {
					batchContList=contList.subList(i, i+=(listSize-i>subSize)?subSize:listSize-i);
					idList.clear();
					for (List<String> list : batchContList) {
						String pkId = list.get(idIndex);
						idList.add(pkId);
					}
					mapObj.put("idList", idList);
					mapObj.put("contentall", batchContList);
					log.info("id:"+idList.size());
					log.info("content:"+batchContList.size());
					mapper.batchInsertClient(mapObj);
				}
				
				log.info("保存"+tableName+"文件数据成功...");
			}
			
		}
	} catch (Exception e) {
		log.info("保存文件数据失败......");
		e.printStackTrace();
		return "保存"+tableName+"失败";
	}
	
	return "保存成功";
	}

}
