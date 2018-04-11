package com.gcf.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcf.sms.bean.Msg;
import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.service.SmsService;

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
	/*
	public Msg sendMessages(@RequestParam(value = "phoneNumbers", defaultValue = "18910386873") String phoneNumbers,@RequestParam(value = "smsContent", defaultValue = "smsContent") String smsContent) throws UnsupportedEncodingException, IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data ={ new NameValuePair("Uid", "guyintai"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob",phoneNumbers),new NameValuePair("smsText",smsContent)};
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		List<String> headersList = new ArrayList<String>();
		
		for(Header h : headers)
		{
	    headersList.add(h.toString());
		System.out.println(h.toString());
		}
		
		System.out.println(headersList);
		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
		System.out.println(result); //打印返回消息状态


		post.releaseConnection();
		return Msg.success();
	}*/
	@RequestMapping(value = "/sendMessages",method = RequestMethod.PUT)
	@ResponseBody
	public Msg sendMessages(SendedRec sendedRec){
		SendedRec sendedRec2 = sendedRec;
		int massType = sendedRec2.getMasstype();
		//value为0普通群发，1定时群发
		if (massType==0) {
			//0普通群发
			//发送状态0:已发送，1:待发送
			sendedRec2.setStatus(0);
			sendedRec2.setReservetime("立即发送");
			SmsService.insertSendedRec(sendedRec2);
			return Msg.success().add("smsResult", "群发成功！");
		}else if (massType==1) {
			//1定时群发
			//发送状态0:已发送，1:待发送
			sendedRec2.setStatus(1);
			SmsService.insertSendedRec(sendedRec2);
			return Msg.success().add("smsResult", "定时任务建立成功！");
		}
		return Msg.fail().add("smsResult", "不存在该任务类型！");
	}
}
