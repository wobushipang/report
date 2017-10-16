package com.bqjr.report.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bqjr.report.model.User;
import com.bqjr.report.service.UserService;

@Controller
public class TestController {

	// 从 application.properties 中读取配置，如取不到默认值为HelloShanhy

	@Value("${application.hello:Hello Angel}")

	private String hello;

	@Autowired
	private UserService user;

	@RequestMapping("/helloJsp")
	public String StringhelloJsp(Map<String, Object> map) {

		User u = user.getUserInfo();

		System.out.println("HelloController.helloJsp().hello=" + hello);

		map.put("hello", hello);
		map.put("user", u);

		return "helloJsp";

	}
}
