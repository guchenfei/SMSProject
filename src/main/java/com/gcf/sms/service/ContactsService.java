package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.sms.bean.Contacts;
import com.gcf.sms.bean.ContactsExample;
import com.gcf.sms.bean.ContactsExample.Criteria;
import com.gcf.sms.dao.ContactsMapper;

/**
 * 通讯录联系人的Service
 * 
 * @author gcf
 *
 */

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

	/**
	 * 联系人添加保存
	 * 
	 * @param contacts
	 */
	public void saveContacts(Contacts contacts) {
		contactsMapper.insertSelective(contacts);
	}

	/**
	 * 根据id查询单个联系人
	 * 
	 * @param id
	 * @return
	 */
	public Contacts getContacts(Integer id) {
		Contacts contacts = contactsMapper.selectByPrimaryKey(id);
		return contacts;
	}

	/**
	 * 更新联系人信息
	 * 
	 * @param contacts
	 */
	public void updateContacts(Contacts contacts) {
		contactsMapper.updateByPrimaryKeySelective(contacts);
	}

	/**
	 * 批量删除联系人
	 * 
	 * @param del_contactIds
	 */
	public void deleteBatch(List<Integer> del_contactIds) {
		ContactsExample example = new ContactsExample();
		Criteria criteria = example.createCriteria();
		criteria.andContactIdIn(del_contactIds);
		contactsMapper.deleteByExample(example);
	}

	/**
	 * 单个删除联系人
	 * 
	 * @param contactId
	 */
	public void deleteContacts(Integer contactId) {
		contactsMapper.deleteByPrimaryKey(contactId);
	}

	/**
	 * 按所属的公司查询联系人
	 * @param opValue
	 * @return
	 */
	public List<Contacts> getAllContactsByCompany(Integer opValue) {
		ContactsExample example = new ContactsExample();
		Criteria criteria = example.createCriteria();
		criteria.andConcompanyEqualTo(opValue);
		List<Contacts> contacts = contactsMapper.selectByExampleWithCpy(example);
		return contacts;
	}
}
