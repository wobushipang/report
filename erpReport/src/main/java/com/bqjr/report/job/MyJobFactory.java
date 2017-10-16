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
 * @FileName MyJobFactory.java
 * @author YuanWei Yi
 * @Date 2017年5月17日 上午11:19:17
 *****************************************************************************/

package com.bqjr.report.job;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyJobFactory <br/>
 * @Description 为了在JOB中使用Spring管理的Bean <br/>
 * @author wei.huang02
 * @version 2017年10月13日 下午4:27:17
 * @since JDK 1.8
 */
@Component
public class MyJobFactory extends AdaptableJobFactory {
	@Autowired
	private AutowireCapableBeanFactory capableBeanFactory;

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		// 调用父类的方法
		Object jobInstance = super.createJobInstance(bundle);
		// 进行注入
		capableBeanFactory.autowireBean(jobInstance);
		return jobInstance;
	}
}