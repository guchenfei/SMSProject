package com.gcf.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcf.sms.bean.Admin;
import com.gcf.sms.bean.AdminExample;
import com.gcf.sms.bean.AdminExample.Criteria;
import com.gcf.sms.dao.AdminMapper;

/**
 * 角色CRUDService
 * 
 * @author gcf
 *
 */
@Service
public class RoleCRUDService {

	@Autowired
	AdminMapper adminMapper;

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<Admin> getAllAdmin() {
		AdminExample adminExample = new AdminExample();
		adminExample.setOrderByClause("admin_id ASC");
		return adminMapper.selectByExampleWithCpy(adminExample);
	}

	/**
	 * 用户保存
	 * 
	 * @param admin
	 */
	public void saveAdmin(Admin admin) {
		adminMapper.insertSelective(admin);
	}

	/**
	 * 校验邮箱是否存在
	 * 
	 * @param email
	 * @return true 代表当前邮箱已存在，false 代表不存在
	 */
	public boolean checkEmail(String email) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseremailEqualTo(email);
		long count = adminMapper.countByExample(example);
		if (count == 0) {
			// 代表该邮箱不存在，可以添加
			return false;
		} else {
			// 代表该邮箱存在，不能添加
			return true;
		}
	}

	/**
	 * 查询单个用户
	 * 
	 * @param id
	 * @return
	 */
	public Admin getAdmin(Integer id) {
		Admin admin = adminMapper.selectByPrimaryKey(id);
		return admin;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param admin
	 */
	public void updateAdmin(Admin admin) {
		adminMapper.updateByPrimaryKeySelective(admin);
	}

	/**
	 * 通过Id值删除用户
	 * 
	 * @param adminId
	 */
	public void deleteAdmin(Integer adminId) {
       adminMapper.deleteByPrimaryKey(adminId);
	}

	public void deleteBatch(List<Integer> adminIds) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminIdIn(adminIds);
		adminMapper.deleteByExample(example);
	}
    /**
     * 按角色查询用户
     * @param opValue
     * @return
     */
	public List<Admin> getAllAdminByRole(Integer opValue) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsertypeEqualTo(opValue);
		List<Admin> admins = adminMapper.selectByExampleWithCpy(example);
		return admins;
	}
}
