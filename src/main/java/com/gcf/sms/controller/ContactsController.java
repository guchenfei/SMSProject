package com.gcf.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcf.sms.bean.Admin;
import com.gcf.sms.bean.Contacts;
import com.gcf.sms.bean.Msg;
import com.gcf.sms.service.ContactsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 通讯录，联系人的CRUD
 * @author gcf
 *
 */
@Controller
public class ContactsController {
	@Autowired
	ContactsService contactsService;
	
	/**
	 * 查询联系人数据（分页查询） 导入jackson包
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping("/allContacts")
	@ResponseBody
	public Msg getAllContactsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 20);
		// startPage后面紧跟着这个查询就是一个分页查询
		List<Contacts> contacts = contactsService.getAllContacts();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		// 封装了详细的分页信息，包括有我们查出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(contacts, 5);
		return Msg.success().add("pageInfo", page);
	}
}
