package com.gcf.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 发送短信后将发送信息记录下来，插入数据库备统计
 * @author gcf
 *
 */

import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.dao.SendedRecMapper;

@Service
public class SmsService {

	@Autowired
	SendedRecMapper sendedRecMapper;

	/**
	 * 插入统计信息
	 * 
	 * @param sendedRec2
	 */
	public void insertSendedRec(SendedRec sendedRec2) {
		sendedRecMapper.insertSelective(sendedRec2);
	}

	/**
	 * 更新统计信息
	 * 
	 * @param sendedRec2
	 */
	public void updateSendedRec(SendedRec sendedRec2) {
		sendedRecMapper.updateByExampleSelective(sendedRec2, null);
	}

}
