/******************************************************************************
 * Copyright (C) 2010-2020 Billions Finance. All Rights Reserved.
 * ============================================================================
 * 版权所有 2010-2020 佰仟金融服务有限公司，并保留所有权利
 * ----------------------------------------------------------------------------
 * 这不是一个自由软件！您不能在任何未经允许的前提下对程序代码进行修改和使用；不允许
 * 对程序代码以任何形式任何目的的再发布
 * ============================================================================
 *
 * @ProjectName jqms-server
 * @PackageName com.bqjr.jqms.server.job 
 * @FileName ScheduledJob.java
 * @author YuanWei Yi
 * @Date 2017年4月26日 下午3:56:19
 *****************************************************************************/

package com.bqjr.report.job.task;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bqjr.report.util.FTPUtil;

/**
 * @ClassName ScheduledJob <br/>
 * @Description 定时任务 <br/>
 * @author wei.huang02
 * @version 2017年10月16日 下午3:56:19
 * @since JDK 1.8
 */
public class ReadFileAndSaveJob implements Job,Serializable {

	private static final long serialVersionUID = -3522993675072203332L;
	private static final Logger logger = LoggerFactory.getLogger(ReadFileAndSaveJob.class);
	
//	@Autowired
//	private 

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("[execute BEGIN],执行定时任务，读取ftp服务器上的文件并保存数据到数据库.");
		try {
			//读取指定路径下所有文件，返回集合
			Map<String, List<List<String>>> files = FTPUtil.ReadFile.readFile();
			
		} catch (Exception e) {
			logger.error("执行定时任务，读取ftp文件并保存数据到数据库发生异常，异常信息为：" + e.getMessage());
		} finally {
			logger.info("[execute END],执行定时任务，读取ftp服务器上的文件并保存数据到数据库.");
		}
	}
}