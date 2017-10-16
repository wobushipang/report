/******************************************************************************
 * Copyright (C) 2010-2020 Billions Finance. All Rights Reserved.
 * ============================================================================
 * 版权所有 2010-2020 佰仟金融服务有限公司，并保留所有权利
 * ----------------------------------------------------------------------------
 * 这不是一个自由软件！您不能在任何未经允许的前提下对程序代码进行修改和使用；不允许
 * 对程序代码以任何形式任何目的的再发布
 * ============================================================================
 *
 * @ProjectName jqms-admin
 * @PackageName com.bqjr.jqms.admin.job 
 * @FileName SchedulerConfigure.java
 * @author YuanWei Yi
 * @Date 2017年4月26日 下午3:54:04
 *****************************************************************************/

package com.bqjr.report.job;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName SchedulerConfigure <br/>
 * @Description 配置定时任务 <br/>
 * @author wei.huang02
 * @version 2017年10月13日 下午4:24:04
 * @since JDK 1.8
 */
@Component
public class SchedulerConfigure {

//	private static final Logger logger = LoggerFactory.getLogger(SchedulerConfigure.class);

	@Autowired
	SchedulerFactoryBean schedulerFactoryBean;

	/*
	 * 配置定时任务
	 */
	public void scheduleJobs() throws SchedulerException {
//		Scheduler scheduler = schedulerFactoryBean.getScheduler();
	}
}
