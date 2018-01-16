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
 * @FileName GetDataServiceImpl 
 * @author wei.huang02
 * @Date 2018年1月15日 下午3:09:42 
 *****************************************************************************/
package com.bqjr.report.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bqjr.report.service.GetDataService;
import com.bqjr.report.util.AliyunossUtils;

/**
 * @ClassName GetDataServiceImpl.java
 * @Description
 * @author wei.huang02
 * @Date 2018年1月15日 下午3:09:42
 * @since JDK 1.8
 */
@Service
public class GetDataServiceImpl implements GetDataService {
	private static Logger logger = Logger.getLogger(GetDataServiceImpl.class);

	private AliyunossUtils util = new AliyunossUtils();

	@Override
	public Map<String, List<List<String>>> getDataFromALiYunOss(String keyPrefix) {
		keyPrefix = getKeyPrefix(keyPrefix);
		keyPrefix = keyPrefix + "/";
		logger.info("开始读取前缀为【" + keyPrefix + "】的CSV文件......");
		Map<String, List<List<String>>> fileMap = new HashMap<String, List<List<String>>>();
		List<String> keys = util.listByKeyPrefix(keyPrefix);
		try {
			if (keys != null && keys.size() > 0) {
				for (String key : keys) {
					fileMap.put(key.split("/")[1], readFileContent(key));
					Thread.sleep(1);
				}
			} else {
				logger.info("没有前缀为【" + keyPrefix + "】的CSV文件......");
			}
		} catch (Exception e) {
			logger.error("读取文件异常，异常信息如下" + e.getMessage());
		}
		logger.info("本次共读取了文件的个数为:" + keys.size());
		return fileMap;
	}

	private String getKeyPrefix(String keyPrefix) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String prefix = "";
		try {
			if (StringUtils.isBlank(keyPrefix)) {
				prefix = sdFormat.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
			} else {
				prefix = keyPrefix;
			}
		} catch (Exception e) {
			logger.error("日期转换错误", e);
			return "";
		}
		if ("1900-01-01".equals(keyPrefix)) {
			prefix = "";
		}
		return prefix;
	}

	private List<List<String>> readFileContent(String key) {
		List<List<String>> result = new ArrayList<List<String>>();
		InputStream ins = null;
		BufferedReader reader = null;
		try {
			ins = util.getInputStream(key);
			reader = new BufferedReader(new InputStreamReader(ins));
			String inLine = reader.readLine();
			while (inLine != null) {
				List<String> column = new ArrayList<String>();
				column = parseCSVLine(inLine, false);
				result.add(column);
				// result = (inLine + System.getProperty("line.separator"));
				inLine = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				logger.error("文件流处理失败", e);
			}
		}
		return result;
	}

	/**
	 * 解析CSV文件（按行解析）
	 * 
	 * @param str
	 * @param isHead
	 * @return
	 */
	private List<String> parseCSVLine(String str, boolean isHead) {
		String reg = "\\G(?:^|,)(?:\"([^\"]*+(?:\"\"[^\"]*+)*+)\"|([^\",]*+))";
		Matcher matcherMain = Pattern.compile(reg).matcher("");
		Matcher matcherQuoto = Pattern.compile("\"\"").matcher("");
		matcherMain.reset(str);
		List<String> list = new ArrayList<String>();
		while (matcherMain.find()) {
			String field;
			if (matcherMain.start(2) >= 0) {
				field = matcherMain.group(2);
			} else {
				field = matcherQuoto.reset(matcherMain.group(1)).replaceAll("\"");
			}
			if (isHead && StringUtils.isEmpty(field)) {
				list.clear();
				break;
			}
			list.add(field);
		}
		return list;
	}
}
