package com.gcf.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcf.sms.bean.Admin;
import com.gcf.sms.bean.Msg;
import com.gcf.sms.service.RoleCRUDService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 角色管理
 * 
 * @author gcf
 *
 */
@Controller
public class RoleCRUDController {

	@Autowired
	RoleCRUDService roleCRUDService;

	/**
	 * 查询用户数据（分页查询）
	 * 导入jackson包
	 * @param pn
	 * @return
	 */
	@RequestMapping("/allAdmin")
	@ResponseBody
	public Msg getAllAdminWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 20);
		// startPage后面紧跟着这个查询就是一个分页查询
		List<Admin> admins = roleCRUDService.getAllAdmin();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		// 封装了详细的分页信息，包括有我们查出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(admins, 5);
		return Msg.success().add("pageInfo",page);
	}

	/**
	 * 用户角色的添加
	 * 用rest风格统一下请求
	 * URI：
	 *（/allAdmin/{id} GET 查询用户）
	 *（/addAdmin  POST 保存用户）
	 *（/allAdmin/{id} PUT 修改用户）
	 *（/allAdmin/{id} DELETE 删除用户）
	 */
	
	/**
	 * 用户保存
	 * @return
	 */
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveAdmin(Admin admin) {
		roleCRUDService.saveAdmin(admin);
		return Msg.success();
	}
	
	
	/**
	 * 校验邮箱是否已经存在
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkEmail")
	public Msg checkEmail(@RequestParam("email")String email) {
		boolean isExist = roleCRUDService.checkEmail(email);
		if (isExist) {
			//邮箱存在
			return Msg.fail();
		}else {
			//邮箱不存在
			return Msg.success();
		}
	}
	
}
