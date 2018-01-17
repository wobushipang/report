package com.bqjr.report.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bqjr.report.job.task.ReadFileAndSaveJob;
import com.bqjr.report.service.GetDataService;
import com.bqjr.report.service.ReceiveCsvData;
import com.bqjr.report.util.FTPUtil;
import com.bqjr.report.util.SpringBeanUtils;

@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(ReadFileAndSaveJob.class);

	// 从 application.properties 中读取配置，如取不到默认值为HelloShanhy
	// @Value("${application.hello:Hello Angel}")
	// private String hello;

	// @RequestMapping("/helloJsp")
	// public String StringhelloJsp(Map<String, Object> map) {
	//
	// //User u = user.getUserInfo();
	//
	// System.out.println("HelloController.helloJsp().hello=" + hello);
	//
	// map.put("hello", hello);
	// //map.put("user", u);
	// Map<String, List<List<String>>> files = FTPUtil.ReadFile.readFile();
	// Object obj = re.importData(files);
	// System.out.println(obj);
	// map.put("obj", obj);
	// return "helloJsp";
	//
	// }

	// @Test
	// public void test() {
	// Map<String, List<List<String>>> files = FTPUtil.ReadFile.readFile();
	// Object obj = re.importData(files);
	// System.out.println(obj);
	//
	// }

	// @RequestMapping("/readFile")
	// public String readFile() {
	// Map<String, List<List<String>>> files = FTPUtil.ReadFile.readFile();
	// if (files != null && files.size() > 0) {
	// System.out.println(files.size());
	// } else {
	// System.out.println("The folder is not exists or empty");
	// }
	// return "helloJsp";
	//
	// }

	@RequestMapping("/insertData")
	public String index(String date, String type) {
		logger.info("[execute BEGIN],执行定时任务，读取文件并保存数据到数据库.");
		Map<String, List<List<String>>> files = new HashMap<String, List<List<String>>>();
		try {
			// 读取文件，返回集合
			if (StringUtils.equals("oss", type)) {
				GetDataService dataService = (GetDataService) SpringBeanUtils.getBean(GetDataService.class);
				files = dataService.getDataFromALiYunOss(date);
			} else {
				files = FTPUtil.ReadFile.readFile(date);
			}
			ReceiveCsvData receiveCsvData = (ReceiveCsvData) SpringBeanUtils.getBean(ReceiveCsvData.class);
			receiveCsvData.importData(files);
		} catch (Exception e) {
			logger.error("执行定时任务，读取文件并保存数据到数据库发生异常，异常信息为：" + e.getMessage());
		} finally {
			logger.info("[execute END],执行定时任务，读取文件并保存数据到数据库.");
		}
		return "NewFile";
	}
}
