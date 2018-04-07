package com.gcf.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcf.sms.bean.FestivalTemp;
import com.gcf.sms.bean.Msg;
import com.gcf.sms.service.FestivalTempService;

/**
 * 处理和节日模板有关的请求
 * 
 * @author gcf
 *
 */
@Controller
public class FestivalTempController {
	@Autowired
	private FestivalTempService festivalTempService;

	/**
	 * 返回所有的节日模板主题信息
	 */
	@RequestMapping("/festivalTemp")
	@ResponseBody
	public Msg getFestivalTemp() {
		// 查出所有节日模板的信息
		List<FestivalTemp> festivalTemps = festivalTempService.getFestivalTemp();
		return Msg.success().add("festivalTemps", festivalTemps);
	}

	/**
	 * 返回所有的节日模板内容信息
	 */
	@RequestMapping(value = "/selectFestivalTempCon", method = RequestMethod.POST)
	@ResponseBody
	public Msg getFestivalTempCon(@RequestParam(value = "opValue", defaultValue = "1") Integer opValue) {
		// 通过id查出节日模板内容的信息
		String festivalTempCon = festivalTempService.getFestivalTempCon(opValue);
		return Msg.success().add("festivalTempCon", festivalTempCon);
	}

}
