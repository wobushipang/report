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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName ScheduledJob <br/>
 * @Description 定时任务1 <br/>
 * @author YuanWei Yi
 * @version 2017年4月26日 下午3:56:19
 * @since JDK 1.8
 */
public class ScheduledJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

	public ScheduledJob() {
	}

	private SimpleDateFormat dateFormat() {
		return new SimpleDateFormat("HH:mm:ss");
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("----------->执行定时任务");
		System.out.println("AAAA: The time is now " + dateFormat().format(new Date()));
	}

}
