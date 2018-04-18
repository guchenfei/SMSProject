package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.sms.bean.Contacts;
import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.bean.SendedRecExample;
import com.gcf.sms.dao.SendedRecMapper;

/**
 * 处理统计查询等
 * 
 * @author gcf
 *
 */
@Service
public class StatisticalQueryService {
	@Autowired
	SendedRecMapper sendedRecMapper;

	public List<SendedRec> getAllStatistical() {
		SendedRecExample sendedRecExample = new SendedRecExample();
		sendedRecExample.setOrderByClause("SRecord_id ASC");
		return sendedRecMapper.selectByExampleWithAdmCom(sendedRecExample);
	}

	/**
	 * 根据ID查询单个统计记录
	 * 
	 * @param id
	 * @return
	 */
	public SendedRec getStatistical(Integer id) {
		SendedRec sendedRec = sendedRecMapper.selectByPrimaryKey(id);
		return sendedRec;
	}

}
