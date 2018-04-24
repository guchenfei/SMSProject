package com.gcf.sms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	/**
	 * 根据ID查询单个统计记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/Statistical/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getStatistical(@PathVariable("id") Integer id) {
		SendedRec  sendedRec = statisticalQueryService.getStatistical(id);
		return Msg.success().add("sendedRec", sendedRec);
	}
	
	/**
	 * 单个和批量删除二合一 批量删除，1,2,3..... 单个删除，1
	 * 
	 * @param contactIds
	 * @return
	 */
	@RequestMapping(value = "/Statistical/{recordIds}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteRecordById(@PathVariable("recordIds") String recordIds) {
		// 包含,就是批量删除，否则单一删除
		if (recordIds.contains(",")) {
			String[] str_recordIds = recordIds.split(",");
			// 组装recordId的集合
			List<Integer> del_recordIds = new ArrayList<Integer>();
			for (String str_recordId : str_recordIds) {
				Integer recordId = Integer.parseInt(str_recordId);
				del_recordIds.add(recordId);
			}
			statisticalQueryService.deleteBatch(del_recordIds);
			return Msg.success();
		} else {
			Integer recordId = Integer.parseInt(recordIds);
			statisticalQueryService.deleteRecord(recordId);
			return Msg.success();
		}
	}
	
	
	/**
	 * 按接收对象所属的公司查询
	 * 
	 * @param opValue
	 * @param pn
	 * @return
	 */
	@RequestMapping(value = "/selectRecordsByCompany", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectRecordsByCompany(@RequestParam(value = "opValue", defaultValue = "1") Integer opValue,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 20);
		// startPage后面紧跟着这个查询就是一个分页查询
		List<SendedRec> records = statisticalQueryService.getAllRecordsByCompany(opValue);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		// 封装了详细的分页信息，包括有我们查出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(records, 5);
		return Msg.success().add("pageInfo", page);
	}

}
