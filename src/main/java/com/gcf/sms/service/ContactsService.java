package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 通讯录联系人的Service
 * @author gcf
 *
 */

import com.gcf.sms.bean.Admin;
import com.gcf.sms.bean.AdminExample;
import com.gcf.sms.bean.Contacts;
import com.gcf.sms.bean.ContactsExample;
import com.gcf.sms.dao.ContactsMapper;
@Service
public class ContactsService {
	@Autowired
	ContactsMapper contactsMapper;
	/**
	 * 查询所有联系人
	 * 
	 * @return
	 */
	public List<Contacts> getAllContacts() {
		ContactsExample example = new ContactsExample();
		example.setOrderByClause("contact_id ASC");
		return contactsMapper.selectByExampleWithCpy(example);
	}
}
