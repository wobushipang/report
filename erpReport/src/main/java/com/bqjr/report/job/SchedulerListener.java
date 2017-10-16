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
 * @FileName SchedulerListener.java
 * @author YuanWei Yi
 * @Date 2017年4月26日 下午3:59:51
 *****************************************************************************/

package com.bqjr.report.job;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @ClassName SchedulerListener <br/>
 * @Description 定时任务监听器 <br/>
 * @author wei.huang02
 * @version 2017年10月13日 下午4:20:51
 * @since JDK 1.8
 */
@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerListener.class);

	@Autowired
	public SchedulerConfigure myScheduler;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		logger.info("scheduleJob begin ");
		try {
			myScheduler.scheduleJobs();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		// 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
		// schedulerFactoryBean.setOverwriteExistingJobs(true);
		// 延时启动，应用启动10秒后
		// schedulerFactoryBean.setStartupDelay(10);
		// 自定义Job Factory，用于Spring注入
		// schedulerFactoryBean.setJobFactory(myJobFactory);
		return schedulerFactoryBean;
	}

}
