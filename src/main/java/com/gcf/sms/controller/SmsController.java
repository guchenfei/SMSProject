package com.gcf.sms.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcf.sms.bean.Contacts;
import com.gcf.sms.bean.Msg;
import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.service.ContactsService;
import com.gcf.sms.service.SmsService;
import com.gcf.sms.service.StatisticalQueryService;

/**
 * 短信群发
 * 
 * @author gcf
 *
 */
@Controller
public class SmsController {
	@Autowired
	SmsService SmsService;
	
	@Autowired
	ContactsService contactsService;
	

	@RequestMapping(value = "/sendMessages", method = RequestMethod.PUT)
	@ResponseBody
	public Msg sendMessages(SendedRec sendedRec)
			throws IllegalArgumentException, HttpException, UnsupportedEncodingException, IOException {
		SendedRec sendedRec2 = sendedRec;
		int massType = sendedRec2.getMasstype();
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateNowStr = sdf.format(cal.getTime());
		System.out.println("现在时间：" + dateNowStr);
		// value为0普通群发，1定时群发
		if (massType == 0) {
			// 0普通群发
			// 发送状态0:已发送，1:待发送
			smsSendMass(sendedRec2);
			sendedRec2.setStatus(0);
			sendedRec2.setReservetime("立即发送");
			sendedRec2.setCreatetime(dateNowStr);
			SmsService.insertSendedRec(sendedRec2);
			return Msg.success().add("smsResult", "群发成功！");
		} else {
			// 1定时群发
			// 发送状态0:已发送，1:待发送
			sendedRec2.setStatus(1);
			sendedRec2.setCreatetime(dateNowStr);
			SmsService.insertSendedRec(sendedRec2);
			return Msg.success().add("smsResult", "定时任务建立成功！");
		}
	}

	public void smsSendMass(SendedRec sendedRec2)
			throws IllegalArgumentException, HttpException, UnsupportedEncodingException, IOException {
		String recePhones = "";
		String smsText = sendedRec2.getSmscon();
		
		List<Contacts> contacts = contactsService.getAllContactsByCompany(sendedRec2.getRececompanyid());
		for(Contacts contacts1 : contacts){
			recePhones = recePhones + contacts1.getConphonenum() + ",";
		}
		
		//去除recePhones多余的
		recePhones = recePhones.substring(0, recePhones.length() - 1);
		System.out.println(recePhones);
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid", "guyintai"), new NameValuePair("Key", "d41d8cd98f00b204e980"),
				new NameValuePair("smsMob", recePhones), new NameValuePair("smsText", smsText) };
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

	}

}
