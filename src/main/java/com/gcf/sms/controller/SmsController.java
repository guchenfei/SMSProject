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

	@RequestMapping(value = "/sendMessages", method = RequestMethod.PUT)
	@ResponseBody
	public Msg sendMessages(SendedRec sendedRec) {
		SendedRec sendedRec2 = sendedRec;
		int massType = sendedRec2.getMasstype();
		// value为0普通群发，1定时群发
		if (massType == 0) {
			// 0普通群发
			// 发送状态0:已发送，1:待发送
			sendedRec2.setStatus(0);
			sendedRec2.setReservetime("立即发送");
			SmsService.insertSendedRec(sendedRec2);
			return Msg.success().add("smsResult", "群发成功！");
		} else {
			// 1定时群发
			// 发送状态0:已发送，1:待发送
			sendedRec2.setStatus(1);
			SmsService.insertSendedRec(sendedRec2);
			return Msg.success().add("smsResult", "定时任务建立成功！");
		}
	}
}
