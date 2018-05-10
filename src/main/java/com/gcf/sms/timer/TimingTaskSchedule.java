package com.gcf.sms.timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimingTaskSchedule implements ServletContextListener {
	// 服务器启动时执行该事件
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			QuartzLoad.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 服务器停止时执行该事件
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			QuartzLoad.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
