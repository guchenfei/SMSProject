package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.sms.bean.Admin;
import com.gcf.sms.dao.AdminMapper;
/**
 * 角色CRUDService
 * @author gcf
 *
 */
@Service
public class RoleCRUDService {

	@Autowired
	AdminMapper adminMapper;
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Admin> getAllAdmin() {
		return adminMapper.selectByExampleWithCpy(null);
	}
}
