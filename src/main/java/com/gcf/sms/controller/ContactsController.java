package com.gcf.sms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * 
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

	/**
	 * 联系人的添加 用rest风格统一下请求 URI： （/allContacts/{id} GET 查询联系人） （/addContacts POST
	 * 保存联系人） （/allContacts/{id} PUT 修改联系人） （/allContacts/{id} DELETE 删除联系人）
	 */

	/**
	 * 联系人保存 1，支持JSR303校验 2，导入Hibernate-Validator jar包
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addContacts", method = RequestMethod.POST)
	@ResponseBody
	public Msg saveContacts(@Valid Contacts contacts, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败,应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				/*
				 * System.out.println("错误字段名" + fieldError.getField());
				 * System.out.println("错误信息" + fieldError.getDefaultMessage());
				 */
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}

			return Msg.fail().add("fieldErrors", map);
		} else {
			contactsService.saveContacts(contacts);
			return Msg.success();
		}

	}

	/**
	 * 根据ID查询单个联系人
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/Contacts/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getContacts(@PathVariable("id") Integer id) {
		Contacts contacts = contactsService.getContacts(id);
		return Msg.success().add("contacts", contacts);
	}
	
	/**
	 * 更新联系人信息
	 * 
	 * @param contacts
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Contacts/{contactId}", method = RequestMethod.PUT)
	public Msg UpdateContacts(@Valid Contacts contacts, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败,应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("fieldErrors", map);
		} else {
			contactsService.updateContacts(contacts);
			return Msg.success();
		}
	}
	
	
	/**
	 * 单个和批量删除二合一 批量删除，1,2,3..... 单个删除，1
	 * 
	 * @param adminId
	 * @return
	 */
	@RequestMapping(value = "/Contacts/{contactIds}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteContactsById(@PathVariable("contactIds") String contactIds) {
		// 包含,就是批量删除，否则单一删除
		if (contactIds.contains(",")) {
			String[] str_contactIds = contactIds.split(",");
			// 组装contactId的集合
			List<Integer> del_contactIds = new ArrayList<Integer>();
			for (String str_contactId : str_contactIds) {
				Integer contactId = Integer.parseInt(str_contactId);
				del_contactIds.add(contactId);
			}
			contactsService.deleteBatch(del_contactIds);
			return Msg.success();
		} else {
			Integer contactId = Integer.parseInt(contactIds);
			contactsService.deleteContacts(contactId);
			return Msg.success();
		}
	}
}
