package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.sms.bean.Admin;
import com.gcf.sms.bean.AdminExample;
import com.gcf.sms.dao.AdminMapper;
/**
 * 登录Service
 * @author gcf
 */
@Service
public class LoginService {

	@Autowired
	AdminMapper adminMapper;
	
	/**
	 *通过邮件查询用户
	 */
	
	public List<Admin> findUserByEmail(String email) {
		AdminExample adminExample = new AdminExample();
		adminExample.createCriteria().andUseremailEqualTo(email);
		List<Admin> admins = adminMapper.selectByExampleWithCpy(adminExample);
		return admins;
	}
}
