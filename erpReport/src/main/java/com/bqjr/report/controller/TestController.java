package com.bqjr.report.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	// 从 application.properties 中读取配置，如取不到默认值为HelloShanhy
//	@Value("${application.hello:Hello Angel}")
//	private String hello;
	
//	@Autowired
//	private  ReceiveCsvData re;

//	@RequestMapping("/helloJsp")
//	public String StringhelloJsp(Map<String, Object> map) {
//
//		//User u = user.getUserInfo();
//
//		System.out.println("HelloController.helloJsp().hello=" + hello);
//
//		map.put("hello", hello);
//		//map.put("user", u);
//		Map<String, List<List<String>>> files = FTPUtil.ReadFile.readFile();
//		Object obj = re.importData(files);
//		System.out.println(obj);
//		map.put("obj", obj);
//		return "helloJsp";
//
//	}

//	@Test
//	public  void test() {
//		Map<String, List<List<String>>> files = FTPUtil.ReadFile.readFile();
//		Object obj = re.importData(files);
//		System.out.println(obj);
//
//	}

//	@RequestMapping("/readFile")
//	public String readFile() {
//		Map<String, List<List<String>>> files = FTPUtil.ReadFile.readFile();
//		if (files != null && files.size() > 0) {
//			System.out.println(files.size());
//		} else {
//			System.out.println("The folder is not exists or empty");
//		}
//		return "helloJsp";
//
//	}
	
	@RequestMapping("/index.dhtml")
	public String index() {
		return "organization_budget";
	}
}
