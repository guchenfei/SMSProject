package com.gcf.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Msg getAllAdminWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
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

	/*@RequestMapping("/allAdmin")*/
	public String getAdmin(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 20);
		// startPage后面紧跟着这个查询就是一个分页查询
		List<Admin> admins = roleCRUDService.getAllAdmin();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		// 封装了详细的分页信息，包括有我们查出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(admins, 5);
		// model可以通过请求将数据带回页面
		model.addAttribute("pageInfo", page);
		return "braManMan";
	}
}
