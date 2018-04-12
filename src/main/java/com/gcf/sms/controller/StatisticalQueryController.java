package com.gcf.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcf.sms.bean.Msg;
import com.gcf.sms.bean.SendedRec;
import com.gcf.sms.service.StatisticalQueryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 统计查询等功能请求处理
 * 
 * @author gcf
 *
 */
@Controller
public class StatisticalQueryController {
	@Autowired
	StatisticalQueryService statisticalQueryService;
	
	@RequestMapping("/Statistical")
	@ResponseBody
	public Msg getAllStatisticalWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 20);
		// startPage后面紧跟着这个查询就是一个分页查询
		List<SendedRec> sendedRecs = statisticalQueryService.getAllStatistical();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		// 封装了详细的分页信息，包括有我们查出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(sendedRecs, 5);
		return Msg.success().add("pageInfo", page);
	}

}
