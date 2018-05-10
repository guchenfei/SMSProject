package com.gcf.sms.timer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gcf.sms.bean.Contacts;
import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.service.ContactsService;
import com.gcf.sms.service.SmsService;
import com.gcf.sms.service.StatisticalQueryService;

//申明为spring组件
@Component
public class UtilService {

	List<SendedRec> taskSendedRecs = new ArrayList<SendedRec>();

	@Autowired
	StatisticalQueryService statisticalQueryService;
	@Autowired
	ContactsService contactsService;
	@Autowired
	SmsService smsService;

	// 关键点1 静态初使化 一个工具类 这样是为了在spring初使化之前
	private static UtilService utilService;

	public void setStatisticalQueryService(StatisticalQueryService statisticalQueryService) {
		this.statisticalQueryService = statisticalQueryService;
	}

	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

	public void setSmsService(SmsService smsService) {
		this.smsService = smsService;
	}

	// 关键二 通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
	@PostConstruct
	public void init() {
		utilService = this;
		// 初使化时将已静态化的utilService实例化
		utilService.statisticalQueryService = this.statisticalQueryService;
		System.out.println(statisticalQueryService);
		utilService.contactsService = this.contactsService;
		System.out.println(contactsService);
		utilService.smsService = this.smsService;
		System.out.println(smsService);
	}

	public void getAllStatistical() throws ParseException, HttpException, IOException {
		List<SendedRec> sendedRecs = utilService.statisticalQueryService.getAllStatistical();
		List<SendedRec> tasksendedRecs1 = new ArrayList<SendedRec>();
		for (SendedRec sendedRec : sendedRecs) {
			if ("立即发送".equals(sendedRec.getReservetime())) {

			} else {
				tasksendedRecs1.add(sendedRec);
			}
		}

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateNowStr = sdf.format(cal.getTime());
		System.out.println("现在时间：" + dateNowStr);

		cal.add(Calendar.MINUTE, -1);
		String datePre = sdf.format(cal.getTime());
		System.out.println("一分钟前时间：" + datePre);
		Date datePre1 = sdf.parse(datePre);
		cal.add(Calendar.MINUTE, 2);
		String dateNext = sdf.format(cal.getTime());
		System.out.println("一分钟后时间：" + dateNext);
		Date dateNext1 = sdf.parse(dateNext);

		Calendar begin = Calendar.getInstance();
		begin.setTime(datePre1);

		Calendar end = Calendar.getInstance();
		end.setTime(dateNext1);

		Date sqlDate = sdf.parse("2000-01-01 00:00:00");
		Calendar sqlCalender = Calendar.getInstance();
		for (SendedRec sendedRec : tasksendedRecs1) {
			String reservetime = sendedRec.getReservetime();
			System.out.println(reservetime);
			if ("".equals(reservetime)) {
				System.out.println("定时时间为空！");
			} else {
				sqlDate = sdf.parse(reservetime);
				System.out.println("该任务是定时任务时间是：" + sdf.format(sqlDate));
				sqlCalender.setTime(sqlDate);
			}

			if (sqlCalender.after(begin) && sqlCalender.before(end)) {
				System.out.println("数据库时间在当前时间范围内，开始执行定时任务！");
				taskSendedRecs.add(sendedRec);
				excuteTask();
			} else {
				System.out.println("数据库时间不在当前时间范围内");
			}
		}
	}

	public void excuteTask() throws HttpException, IOException {
		for (SendedRec sendedRec2 : taskSendedRecs) {
			if (sendedRec2 != null) {
				System.out.println("执行定时任务：" + sendedRec2);
				String recePhones = "";
				String smsText = sendedRec2.getSmscon();
				int companyId = sendedRec2.getRececompanyid();
				System.out.println(companyId);
				List<Contacts> contacts = utilService.contactsService.getAllContactsByCompany(companyId);
				System.out.println(contacts);
				for (Contacts contacts1 : contacts) {
					recePhones = recePhones + contacts1.getConphonenum() + ",";
				}

				// 去除recePhones多余的
				recePhones = recePhones.substring(0, recePhones.length() - 1);
				System.out.println(recePhones);

				HttpClient client = new HttpClient();
				PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
				post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
				NameValuePair[] data = { new NameValuePair("Uid", "guyintai"),
						new NameValuePair("Key", "d41d8cd98f00b204e980"), new NameValuePair("smsMob", recePhones),
						new NameValuePair("smsText", smsText) };
				post.setRequestBody(data);

				client.executeMethod(post);
				Header[] headers = post.getResponseHeaders();
				int statusCode = post.getStatusCode();
				System.out.println("statusCode:" + statusCode);
				for (Header h : headers) {
					System.out.println(h.toString());
				}
				String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
				System.out.println(result); // 打印返回消息状态

				post.releaseConnection();

				// 发送状态0:已发送，1:待发送
				sendedRec2.setStatus(0);
				utilService.smsService.updateSendedRec(sendedRec2);
			}
		}
	}
}
