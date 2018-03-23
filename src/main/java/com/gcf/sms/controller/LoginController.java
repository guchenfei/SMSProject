package com.gcf.sms.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.VoiceStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcf.sms.bean.Admin;
import com.gcf.sms.service.LoginService;
import com.gcf.sms.utils.CreateImageCode;

/**
 * 登录功能
 * 
 * @author gcf
 *
 */
@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	/**
	 * 验证码验证
	 */
	@RequestMapping("/checkCode.png")
	public void getCheckCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 设置响应的类型格式为图片格式 response.setContentType("image/jpeg");
		// 禁止图像缓存。 response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		CreateImageCode vCode = new CreateImageCode(98, 20, 4, 10);
		session.setAttribute("code", vCode.getCode());
		try {
			vCode.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 邮箱登录验证
	 */
	@RequestMapping("/login")
	public String Login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 1,获取浏览器提交的邮箱,密码和验证码
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkCode");

		// 判断输入框是否为空
		if ("".equals(email) || "".equals(password) || "".equals(checkCode)) {
			request.setAttribute("msg", "输入框不能为空！");
			// 提示输入框不能为空,并返回登录界面
            return "index";
		} else if (checkCode == "" || !session.getAttribute("code").toString().equalsIgnoreCase(checkCode)) {
			// 判断验证码是否正确
			request.setAttribute("msg", "验证码错误！");
			return "index";
		} else {
			// 核查用户是否正确
			List<Admin> admins = loginService.findUserByEmail(email);
			if (admins == null || admins.size() == 0) {
				// 该系统没有该用户，重新登录，可以弹窗提示
				request.setAttribute("msg", "该用户不存在,核查后登录！");
               return "index";
			} else if (admins.get(0).getUserpass().equals(password)) {
				// 验证成功根据不同角色进入主界面
				int type = admins.get(0).getUsertype();
				session.setAttribute("UserName", admins.get(0).getUsername());
				// 权限角色：0表示超级管理员，1表示普通管理员，2表示业务员
				switch (type) {
				case 0:
                    //进入超级管理员界面
					return "superIndex";
				case 1:
                    //进入普通管理员界面
					return "generalIndex";
				case 2:
                    //进入业务员界面
					return "salesmanIndex";
				}
			}
		}
		return "index";
	}
	
	/**
	 * 退出系统，清除session中的数据
	 */
	@RequestMapping("loginOut")
	public String LoginOut(HttpSession session) {
		//invalidate()方法。该方法可以清除session对象中的所有信息。
		session.invalidate();
		return "index";
	}
}
