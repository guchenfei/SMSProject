package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.sms.bean.FestivalTemp;
import com.gcf.sms.dao.FestivalTempMapper;

@Service
public class FestivalTempService {
	@Autowired
	FestivalTempMapper festivalTempMapper;
	
	public List<FestivalTemp> getFestivalTemp() {
		List<FestivalTemp> festivalTemps = festivalTempMapper.selectByExample(null);
		return festivalTemps;
	}

	/**
	 * 通过ID查询出对应模板内容
	 * @param opValue
	 * @return
	 */
	public String getFestivalTempCon(Integer opValue) {
		FestivalTemp festivalTemp = festivalTempMapper.selectByPrimaryKey(opValue);
		return festivalTemp.getTemplatecon();
	}
}
