package com.gcf.sms.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.core.pattern.EqualsReplacementConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	 * 查询用户数据（分页查询） 导入jackson包
	 * 
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
		return Msg.success().add("pageInfo", page);
	}

	/**
	 * 用户角色的添加 用rest风格统一下请求 URI： （/allAdmin/{id} GET 查询用户） （/addAdmin POST 保存用户）
	 * （/allAdmin/{id} PUT 修改用户） （/allAdmin/{id} DELETE 删除用户）
	 */

	/**
	 * 用户保存 1，支持JSR303校验 2，导入Hibernate-Validator jar包
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	@ResponseBody
	public Msg saveAdmin(@Valid Admin admin, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败,应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			System.out.println(errors);
			for (FieldError fieldError : errors) {
				System.out.println("错误字段名" + fieldError.getField());
				System.out.println("错误信息" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}

			return Msg.fail().add("fieldErrors", map);
		} else {
			roleCRUDService.saveAdmin(admin);
			return Msg.success();
		}

	}

	/**
	 * 校验邮箱是否已经存在
	 * 
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkEmail")
	public Msg checkEmail(@RequestParam("email") String email) {
		// 先判断邮箱是否合法
		String regEmail = "(^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6}))";
		if (!email.matches(regEmail)) {
			return Msg.fail().add("checkEmail_msg", "请按正确的邮箱格式输入");
		}

		boolean isExist = roleCRUDService.checkEmail(email);
		if (isExist) {
			// 邮箱存在
			return Msg.fail().add("checkEmail_msg", "该邮箱已经存在，请核查！");
		} else {
			// 邮箱不存在
			return Msg.success().add("checkEmail_msg", "该邮箱可用！");
		}
	}

	/**
	 * 根据ID查询单个用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getAdmin(@PathVariable("id") Integer id) {
		Admin admin = roleCRUDService.getAdmin(id);
		return Msg.success().add("admin", admin);
	}

	/**
	 * 更新用户信息
	 * 
	 * @param admin
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/{adminId}", method = RequestMethod.PUT)
	public Msg UpdateAdmin(@Valid Admin admin, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败,应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			System.out.println(errors);
			for (FieldError fieldError : errors) {
				System.out.println("错误字段名" + fieldError.getField());
				System.out.println("错误信息" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("fieldErrors", map);
		} else {
			roleCRUDService.updateAdmin(admin);
			return Msg.success();
		}

	}

	/**
	 * 单个和批量删除二合一 批量删除，1-2-3..... 单个删除，1
	 * 
	 * @param adminId
	 * @return
	 */
	@RequestMapping(value = "/admin/{adminIds}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteAdminById(@PathVariable("adminIds") String adminIds) {
		// 包含-就是批量删除，否则单一删除
		if (adminIds.contains(",")) {
			String[] str_adminIds = adminIds.split(",");
			// 组装adminId的集合
			List<Integer> del_adminIds = new ArrayList<Integer>();
			for (String str_adminId : str_adminIds) {
				Integer adminId = Integer.parseInt(str_adminId);
				del_adminIds.add(adminId);
			}
			roleCRUDService.deleteBatch(del_adminIds);
			return Msg.success();
		} else {
			Integer adminId = Integer.parseInt(adminIds);
			roleCRUDService.deleteAdmin(adminId);
			return Msg.success();
		}

	}

}
