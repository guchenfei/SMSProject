package com.gcf.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcf.sms.bean.Company;
import com.gcf.sms.bean.Msg;
import com.gcf.sms.service.CompanyService;

/**
 * 处理和公司有关的请求
 * @author gcf
 *
 */
@Controller
public class CompanyController {
        @Autowired
        private CompanyService companyService;
        
        /**
         * 返回所有的分公司信息
         */
        @RequestMapping("/companies")
        @ResponseBody
        public Msg getCompany() {
        	//查出所有公司的信息
        	List<Company> companies = companyService.getCompanies();
        	return Msg.success().add("companies", companies);
		}
}
