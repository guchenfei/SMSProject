package com.gcf.sms.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcf.sms.bean.Msg;

/**
 * 短信群发
 * 
 * @author gcf
 *
 */
@Controller
public class SmsController {

	@RequestMapping(value = "/sendMessages",method = RequestMethod.POST)
	@ResponseBody
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
		for(Header h : headers)
		{
		System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
		System.out.println(result); //打印返回消息状态


		post.releaseConnection();
		return Msg.success();
	}
}
