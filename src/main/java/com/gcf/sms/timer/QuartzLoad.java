package com.gcf.sms.timer;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzLoad {
	static TriggerKey triggerKey= new TriggerKey("ramTrigger", "ramTriggerGroup");
	static JobKey jobKey = new JobKey("ramJob", "ramGroup");
	public static void run() throws SchedulerException {
		final Logger logger = LoggerFactory.getLogger(QuartzLoad.class);

		// 1.创建Scheduler的工厂
		SchedulerFactory sf = new StdSchedulerFactory();
		// 2.从工厂中获取调度器实例
		Scheduler scheduler = sf.getScheduler();

		// 3.创建JobDetail
		JobDetail jb = JobBuilder.newJob(RAMJob.class).withDescription("this is a ram job") // job的描述
				.withIdentity(jobKey) // job 的name和group
				.build();

		// 任务运行的时间，SimpleSchedle类型触发器有效
		long time = System.currentTimeMillis() + 3 * 1000L; // 3秒后启动任务
		Date statTime = new Date(time);

		// 4.创建Trigger
		// 使用SimpleScheduleBuilder或者CronScheduleBuilder
		Trigger t = TriggerBuilder.newTrigger().withDescription("").withIdentity(triggerKey)
				// .withSchedule(SimpleScheduleBuilder.simpleSchedule())
				.startAt(statTime) // 默认当前时间启动
				.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?")) // 30秒执行一次
				.build();

		// 5.注册任务和定时器
		scheduler.scheduleJob(jb, t);

		// 6.启动 调度器
		scheduler.start();
		logger.info("启动时间 ： " + new Date());

	}

	// 停止
	public static void stop() throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		sched.pauseTrigger(triggerKey);// 停止触发器
		sched.unscheduleJob(triggerKey);// 移除触发器
		sched.deleteJob(jobKey);// 删除任务
	}
}
