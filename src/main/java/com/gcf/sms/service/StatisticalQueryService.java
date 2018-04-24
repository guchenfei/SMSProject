package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.sms.bean.Contacts;
import com.gcf.sms.bean.ContactsExample;
import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.bean.SendedRecExample;
import com.gcf.sms.bean.SendedRecExample.Criteria;
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

	public void deleteBatch(List<Integer> del_recordIds) {
		SendedRecExample example = new SendedRecExample();
		Criteria criteria = example.createCriteria();
		criteria.andSrecordIdIn(del_recordIds);
		sendedRecMapper.deleteByExample(example);
	}

	public void deleteRecord(Integer recordId) {
		sendedRecMapper.deleteByPrimaryKey(recordId);
	}

	public List<SendedRec> getAllRecordsByCompany(Integer opValue) {
		SendedRecExample example = new SendedRecExample();
		Criteria criteria = example.createCriteria();
		criteria.andRececompanyidEqualTo(opValue);
		List<SendedRec> records = sendedRecMapper.selectByExampleWithAdmCom(example);
		return records;
	}

	

}
