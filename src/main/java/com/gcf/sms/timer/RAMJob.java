package com.gcf.sms.timer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.httpclient.HttpException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RAMJob implements Job {
	private static Logger _log = LoggerFactory.getLogger(RAMJob.class);
	UtilService UtilService = new UtilService();

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		_log.info("Say hello to Quartz" + new Date());
		try {
			UtilService.getAllStatistical();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
